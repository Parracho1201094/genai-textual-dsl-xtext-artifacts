package generated.grading;

import java.math.BigDecimal;
import java.math.MathContext;
import java.nio.file.Path;
import org.enorm.lts.runtime.*;
import org.enorm.lts.custom.CustomFunctions;

public final class GradingProcess {
    public static void main(String[] args) throws Exception {
        ProcessLogger log = new ProcessLogger();

        Table students = CsvLoader.load(
            Path.of("data/grading/students.csv"),
            Schema.of(
                Column.of("id", Type.INT),
                Column.of("name", Type.STRING),
                Column.of("email", Type.STRING)
            ),
            CsvOptions.header(true).delimiter(","),
            log
        );

        Table courses = CsvLoader.load(
            Path.of("data/grading/courses.csv"),
            Schema.of(
                Column.of("id", Type.INT),
                Column.of("code", Type.STRING),
                Column.of("name", Type.STRING)
            ),
            CsvOptions.header(true).delimiter(","),
            log
        );

        Table exams = CsvLoader.load(
            Path.of("data/grading/exams.csv"),
            Schema.of(
                Column.of("studentId", Type.INT),
                Column.of("courseId", Type.INT),
                Column.of("examName", Type.STRING),
                Column.of("grade", Type.DECIMAL),
                Column.of("weight", Type.DECIMAL)
            ),
            CsvOptions.header(true).delimiter(","),
            log
        );

        students = Operators.removeDuplicates(students, "id");
        courses = Operators.removeDuplicates(courses, "id");

        exams = Operators.filter(exams, row -> row.decimal("grade").compareTo(BigDecimal.ZERO) >= 0
            && row.decimal("grade").compareTo(BigDecimal.valueOf(20)) <= 0);

        exams = Operators.setColumn(
            exams,
            "weightedGrade",
            Type.DECIMAL,
            row -> row.decimal("grade").multiply(row.decimal("weight"))
        );

        Table finalGrades = Operators.aggregate(
            exams,
            GroupBy.columns("studentId", "courseId"),
            Aggregations.sum("weightedGrade", "weightedTotal", Type.DECIMAL),
            Aggregations.sum("weight", "totalWeight", Type.DECIMAL)
        );

        finalGrades = Operators.setColumn(
            finalGrades,
            "finalGrade",
            Type.DECIMAL,
            row -> row.decimal("totalWeight").compareTo(BigDecimal.ZERO) == 0
                ? BigDecimal.ZERO
                : row.decimal("weightedTotal").divide(row.decimal("totalWeight"), MathContext.DECIMAL64)
        );

        finalGrades = Operators.leftJoin(
            finalGrades,
            students,
            JoinSpec.on("studentId", "id")
                .add("name", "studentName")
                .add("email", "studentEmail"),
            log
        );

        finalGrades = Operators.leftJoin(
            finalGrades,
            courses,
            JoinSpec.on("courseId", "id")
                .add("code", "courseCode")
                .add("name", "courseName"),
            log
        );

        finalGrades = Operators.setColumn(
            finalGrades,
            "resultLabel",
            Type.STRING,
            row -> CustomFunctions.concat(row.string("courseCode"), " - ", row.string("studentName"))
        );

        finalGrades = Operators.setColumn(
            finalGrades,
            "status",
            Type.STRING,
            row -> CustomFunctions.passFail(row.decimal("finalGrade"))
        );

        finalGrades = Operators.dropColumns(finalGrades, "weightedTotal", "totalWeight");
        finalGrades = Operators.sort(finalGrades, Sort.by("studentName", Sort.Direction.ASC, "courseCode", Sort.Direction.ASC));

        CsvSaver.save(finalGrades, Path.of("out/grading/final_grades.csv"), CsvOptions.header(true), log);
        log.save(Path.of("out/grading/grading.log"));
    }
}
