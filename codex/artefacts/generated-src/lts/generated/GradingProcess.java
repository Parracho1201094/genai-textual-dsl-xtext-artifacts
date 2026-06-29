package lts.generated;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

import org.example.lts.runtime.*;

/**
 * Generated from the LTS process Grading.
 * Regenerate this file instead of editing it manually.
 */
public final class GradingProcess {
    private final Path baseDirectory;
    private final Map<String, DataTable> tables = new LinkedHashMap<>();
    private final FunctionRegistry functions = new FunctionRegistry();
    private final LtsLog log = new LtsLog();

    public GradingProcess(Path baseDirectory) {
        this.baseDirectory = baseDirectory;
    }

    public static void main(String[] args) throws Exception {
        Path base = args.length == 0 ? Path.of(".") : Path.of(args[0]);
        new GradingProcess(base).run();
    }

    public void run() throws Exception {
        tables.put("students",
                CsvIO.read("students", path("data/students.csv"),
                        ',', true,
                        schema_students(), log));
        tables.put("courses",
                CsvIO.read("courses", path("data/courses.csv"),
                        ',', true,
                        schema_courses(), log));
        tables.put("exams",
                CsvIO.read("exams", path("data/exams.csv"),
                        ',', true,
                        schema_exams(), log));
        tables.put("examLines",
                new DataTable("examLines",
                        schema_examLines()));
        LtsOps.append("exams",
                tables.get("exams"),
                "examLines",
                tables.get("examLines"),
                LtsOps.assignments(
                        "studentId", Expressions.column("exams",
                                                "studentId"),
                                        
                                "courseId", Expressions.column("exams",
                                                "courseId"),
                                        
                                "weight", Expressions.column("exams",
                                                "weight"),
                                        
                                "weightedGrade", Expressions.binary(Expressions.column("exams",
                                                "grade"),
                                                "*",
                                                Expressions.column("exams",
                                                                        "weight"))
                        )
                , functions);
        LtsOps.join("examLines",
                tables.get("examLines"),
                "students",
                tables.get("students"),
                true,
                Expressions.binary(Expressions.column("examLines",
                                        "studentId"),
                                        "=",
                                        Expressions.column("students",
                                                                "studentId")),
                LtsOps.assignments(
                        "studentName", Expressions.column("students",
                                                "studentName")
                        )
                ,
                LtsOps.assignments(
                )
                ,
                functions, log);
        LtsOps.join("examLines",
                tables.get("examLines"),
                "courses",
                tables.get("courses"),
                true,
                Expressions.binary(Expressions.column("examLines",
                                        "courseId"),
                                        "=",
                                        Expressions.column("courses",
                                                                "courseId")),
                LtsOps.assignments(
                        "courseName", Expressions.column("courses",
                                                "courseName")
                        )
                ,
                LtsOps.assignments(
                )
                ,
                functions, log);
        tables.put("grades",
                new DataTable("grades",
                        schema_grades()));
        LtsOps.group("examLines",
                tables.get("examLines"),
                tables.get("grades"),
                LtsOps.expressions(
                        Expressions.column("examLines",
                                                "studentId"), 
                                        Expressions.column("examLines",
                                                "courseId")
                        ),
                LtsOps.assignments(
                        "studentId", Expressions.call("first"
                        ,                         Expressions.column("examLines",
                                                                        "studentId")
                                                ),
                                        
                                "studentName", Expressions.call("first"
                        ,                         Expressions.column("examLines",
                                                                        "studentName")
                                                ),
                                        
                                "courseId", Expressions.call("first"
                        ,                         Expressions.column("examLines",
                                                                        "courseId")
                                                ),
                                        
                                "courseName", Expressions.call("first"
                        ,                         Expressions.column("examLines",
                                                                        "courseName")
                                                ),
                                        
                                "finalGrade", Expressions.binary(Expressions.call("sum"
                        ,                         Expressions.column("examLines",
                                                                        "weightedGrade")
                                                ),
                                                "/",
                                                Expressions.call("sum"
                                                ,                         Expressions.column("examLines",
                                                                                                "weight")
                                                                        ))
                        )
                , functions);
        LtsOps.sort(tables.get("grades")
        ,         new SortSpec("studentId",
                        true), 
                        new SortSpec("courseId",
                        true)
                );
        CsvIO.write(tables.get("grades"),
                path("out/final-grades.csv"), ',',
                true);
        log.save(path("out/grading.log"));
    }

    private Path path(String relativeOrAbsolute) {
        Path path = Path.of(relativeOrAbsolute);
        return path.isAbsolute() ? path : baseDirectory.resolve(path).normalize();
    }

    private static Schema schema_students() {
        return Schema.builder()
            .column("studentId", ValueType.INTEGER,
                    true, null)
            .column("studentName", ValueType.STRING,
                    true, null)
            .build();
    }

    private static Schema schema_courses() {
        return Schema.builder()
            .column("courseId", ValueType.INTEGER,
                    true, null)
            .column("courseName", ValueType.STRING,
                    true, null)
            .build();
    }

    private static Schema schema_exams() {
        return Schema.builder()
            .column("studentId", ValueType.INTEGER,
                    true, null)
            .column("courseId", ValueType.INTEGER,
                    true, null)
            .column("grade", ValueType.DECIMAL,
                    true, null)
            .column("weight", ValueType.DECIMAL,
                    true, null)
            .build();
    }

    private static Schema schema_examLines() {
        return Schema.builder()
            .column("studentId", ValueType.INTEGER,
                    true, null)
            .column("studentName", ValueType.STRING,
                    false, null)
            .column("courseId", ValueType.INTEGER,
                    true, null)
            .column("courseName", ValueType.STRING,
                    false, null)
            .column("weightedGrade", ValueType.DECIMAL,
                    false, null)
            .column("weight", ValueType.DECIMAL,
                    false, null)
            .build();
    }

    private static Schema schema_grades() {
        return Schema.builder()
            .column("studentId", ValueType.INTEGER,
                    true, null)
            .column("studentName", ValueType.STRING,
                    true, null)
            .column("courseId", ValueType.INTEGER,
                    true, null)
            .column("courseName", ValueType.STRING,
                    true, null)
            .column("finalGrade", ValueType.DECIMAL,
                    true, null)
            .build();
    }

}
