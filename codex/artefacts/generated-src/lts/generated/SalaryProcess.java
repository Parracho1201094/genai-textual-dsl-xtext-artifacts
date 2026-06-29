package lts.generated;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

import org.example.lts.runtime.*;

/**
 * Generated from the LTS process Salary.
 * Regenerate this file instead of editing it manually.
 */
public final class SalaryProcess {
    private final Path baseDirectory;
    private final Map<String, DataTable> tables = new LinkedHashMap<>();
    private final FunctionRegistry functions = new FunctionRegistry();
    private final LtsLog log = new LtsLog();

    public SalaryProcess(Path baseDirectory) {
        this.baseDirectory = baseDirectory;
    }

    public static void main(String[] args) throws Exception {
        Path base = args.length == 0 ? Path.of(".") : Path.of(args[0]);
        new SalaryProcess(base).run();
    }

    public void run() throws Exception {
        tables.put("employees",
                CsvIO.read("employees", path("data/employees.csv"),
                        ',', true,
                        schema_employees(), log));
        tables.put("workedHours",
                CsvIO.read("workedHours", path("data/worked-hours.csv"),
                        ',', true,
                        schema_workedHours(), log));
        tables.put("categories",
                CsvIO.read("categories", path("data/employee-categories.csv"),
                        ',', true,
                        schema_categories(), log));
        LtsOps.removeDuplicates(tables.get("employees")
        ,         "employeeId"
                );
        LtsOps.sort(tables.get("employees")
        ,         new SortSpec("employeeId",
                        true)
                );
        tables.put("payments",
                new DataTable("payments",
                        schema_payments()));
        LtsOps.append("employees",
                tables.get("employees"),
                "payments",
                tables.get("payments"),
                LtsOps.assignments(
                        "employeeId", Expressions.column("employees",
                                                "employeeId"),
                                        
                                "name", Expressions.column("employees",
                                                "name"),
                                        
                                "categoryId", Expressions.column("employees",
                                                "categoryId"),
                                        
                                "baseSalary", Expressions.column("employees",
                                                "baseSalary")
                        )
                , functions);
        LtsOps.join("payments",
                tables.get("payments"),
                "categories",
                tables.get("categories"),
                true,
                Expressions.binary(Expressions.column("payments",
                                        "categoryId"),
                                        "=",
                                        Expressions.column("categories",
                                                                "categoryId")),
                LtsOps.assignments(
                        "hourlyRate", Expressions.column("categories",
                                                "hourlyRate")
                        )
                ,
                LtsOps.assignments(
                )
                ,
                functions, log);
        LtsOps.join("payments",
                tables.get("payments"),
                "workedHours",
                tables.get("workedHours"),
                true,
                Expressions.binary(Expressions.column("payments",
                                        "employeeId"),
                                        "=",
                                        Expressions.column("workedHours",
                                                                "employeeId")),
                LtsOps.assignments(
                )
                ,
                LtsOps.assignments(
                        "totalHours", Expressions.call("sum"
                        ,                         Expressions.column("workedHours",
                                                                        "hours")
                                                )
                        )
                ,
                functions, log);
        LtsOps.calculate("payments",
                tables.get("payments"),
                "payment",
                Expressions.binary(Expressions.column("payments",
                                        "baseSalary"),
                                        "+",
                                        Expressions.binary(Expressions.column("payments",
                                                                "totalHours"),
                                                                "*",
                                                                Expressions.column("payments",
                                                                                        "hourlyRate"))), functions);
        LtsOps.removeColumns(tables.get(
                "payments")
        ,         "categoryId", 
                        "baseSalary", 
                        "hourlyRate", 
                        "totalHours"
                );
        CsvIO.write(tables.get("payments"),
                path("out/payments.csv"), ',',
                true);
        log.save(path("out/salary.log"));
    }

    private Path path(String relativeOrAbsolute) {
        Path path = Path.of(relativeOrAbsolute);
        return path.isAbsolute() ? path : baseDirectory.resolve(path).normalize();
    }

    private static Schema schema_employees() {
        return Schema.builder()
            .column("employeeId", ValueType.INTEGER,
                    true, null)
            .column("name", ValueType.STRING,
                    true, null)
            .column("categoryId", ValueType.STRING,
                    true, null)
            .column("baseSalary", ValueType.DECIMAL,
                    true, null)
            .build();
    }

    private static Schema schema_workedHours() {
        return Schema.builder()
            .column("employeeId", ValueType.INTEGER,
                    true, null)
            .column("hours", ValueType.DECIMAL,
                    true, null)
            .build();
    }

    private static Schema schema_categories() {
        return Schema.builder()
            .column("categoryId", ValueType.STRING,
                    true, null)
            .column("hourlyRate", ValueType.DECIMAL,
                    true, null)
            .build();
    }

    private static Schema schema_payments() {
        return Schema.builder()
            .column("employeeId", ValueType.INTEGER,
                    true, null)
            .column("name", ValueType.STRING,
                    true, null)
            .column("categoryId", ValueType.STRING,
                    true, null)
            .column("baseSalary", ValueType.DECIMAL,
                    true, null)
            .column("hourlyRate", ValueType.DECIMAL,
                    false, null)
            .column("totalHours", ValueType.DECIMAL,
                    false, null)
            .column("payment", ValueType.DECIMAL,
                    false, null)
            .build();
    }

}
