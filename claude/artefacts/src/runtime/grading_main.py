"""
grading_main.py
---------------
Python translation of the Java code LTSGenerator.xtend would produce
for grading.lts.

Fixture data:
  Dan  (id=1): Math(101, w=3.0) score=18, Physics(102, w=4.0) score=16
  Eve  (id=2): Math(101, w=3.0) score=14, Physics(102, w=4.0) score=-1 → filtered

Expected output (grades.csv):
  Dan : finalGrade = (18*3 + 16*4) / (3+4) = (54+64)/7 = 118/7 ≈ 16.857
  Eve : only Math exam valid → (14*3) / 3 = 14.0
"""

import sys, os
sys.path.insert(0, os.path.dirname(__file__))

import lts_runtime as rt

DATA   = os.path.join(os.path.dirname(__file__), "data")
OUTPUT = os.path.join(os.path.dirname(__file__), "output")

def main():
    log = rt.LogCollector(os.path.join(OUTPUT, "grading_log.txt"))

    studentsConfig = rt.CsvConfig(f"{DATA}/students.csv")
    coursesConfig  = rt.CsvConfig(f"{DATA}/courses.csv")
    examsConfig    = rt.CsvConfig(f"{DATA}/exams.csv")
    gradesConfig   = rt.CsvConfig(f"{OUTPUT}/grades.csv")

    # load
    students = rt.load(studentsConfig)
    courses  = rt.load(coursesConfig)
    exams    = rt.load(examsConfig)
    log.info(f"Loaded students ({students.row_count()}), courses ({courses.row_count()}), exams ({exams.row_count()})")

    # filter exams where score >= 0
    before = exams.row_count()
    exams = rt.filter_table(exams, lambda row: rt.compare(row.get("score"), ">=", 0))
    log.warning(f"Filtered {before - exams.row_count()} exam(s) with negative score.")

    # lookup creditWeight from courses
    exams = rt.lookup(exams, "courseId", courses, "courseId", "creditWeight")

    # add column weightedScore = score * creditWeight
    exams = rt.add_computed_column(
        exams, "weightedScore",
        lambda row: rt.arithmetic(row.get("score"), "*", row.get("creditWeight"))
    )

    # group by studentId aggregating weightedScore SUM → gradeSummary
    gradeSummary = rt.group(exams, ["studentId"], "weightedScore", rt.AggFunction.SUM)

    # group by studentId aggregating creditWeight SUM (into separate table, then merge)
    creditSummary = rt.group(exams, ["studentId"], "creditWeight", rt.AggFunction.SUM)

    # join the two summaries on studentId
    gradeSummary = rt.join(gradeSummary, "studentId", creditSummary, "studentId")

    # calculate finalGrade = totalWeightedScore / totalCredits
    # Column names after group are "weightedScore" and "creditWeight"
    gradeSummary = rt.add_computed_column(
        gradeSummary, "finalGrade",
        lambda row: rt.arithmetic(row.get("weightedScore"), "/", row.get("creditWeight"))
    )

    # lookup studentName
    gradeSummary = rt.lookup(gradeSummary, "studentId",
                             students, "studentId", "studentName")

    # drop intermediates
    gradeSummary = rt.drop_columns(gradeSummary, ["weightedScore", "creditWeight"])

    # output table
    grades = rt.Table(["studentId", "studentName", "finalGrade"])
    grades = rt.append_rows(grades, gradeSummary)

    rt.save(grades, gradesConfig)
    log.info(f"Saved grades ({grades.row_count()} rows)")
    log.flush()

    return grades

if __name__ == "__main__":
    result = main()
    print("\n=== grades table ===")
    print(",".join(result.columns))
    for row in result.rows:
        print(",".join(str(row.get(c, "")) for c in result.columns))
