package lts.generated;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

import org.example.lts.runtime.*;

/**
 * Generated from the LTS process CustomFunction.
 * Regenerate this file instead of editing it manually.
 */
public final class CustomFunctionProcess {
    private final Path baseDirectory;
    private final Map<String, DataTable> tables = new LinkedHashMap<>();
    private final FunctionRegistry functions = new FunctionRegistry();
    private final LtsLog log = new LtsLog();

    public CustomFunctionProcess(Path baseDirectory) {
        this.baseDirectory = baseDirectory;
        functions.register("overtime",
                "com.acme.lts.PayrollFunctions#overtime");
    }

    public static void main(String[] args) throws Exception {
        Path base = args.length == 0 ? Path.of(".") : Path.of(args[0]);
        new CustomFunctionProcess(base).run();
    }

    public void run() throws Exception {
        tables.put("hours",
                CsvIO.read("hours", path("data/hours.csv"),
                        ',', true,
                        schema_hours(), log));
        tables.put("result",
                new DataTable("result",
                        schema_result()));
        LtsOps.append("hours",
                tables.get("hours"),
                "result",
                tables.get("result"),
                LtsOps.assignments(
                        "employeeId", Expressions.column("hours",
                                                "employeeId"),
                                        
                                "overtimePayment", Expressions.call("overtime"
                        ,                         Expressions.column("hours",
                                                                        "worked"), 
                                                                        Expressions.literal(new BigDecimal("40.0")), 
                                                                        Expressions.literal(new BigDecimal("20.0"))
                                                )
                        )
                , functions);
        CsvIO.write(tables.get("result"),
                path("out/overtime.csv"), ',',
                true);
        log.save(path("out/overtime.log"));
    }

    private Path path(String relativeOrAbsolute) {
        Path path = Path.of(relativeOrAbsolute);
        return path.isAbsolute() ? path : baseDirectory.resolve(path).normalize();
    }

    private static Schema schema_hours() {
        return Schema.builder()
            .column("employeeId", ValueType.INTEGER,
                    true, null)
            .column("worked", ValueType.DECIMAL,
                    true, null)
            .build();
    }

    private static Schema schema_result() {
        return Schema.builder()
            .column("employeeId", ValueType.INTEGER,
                    true, null)
            .column("overtimePayment", ValueType.DECIMAL,
                    true, null)
            .build();
    }

}
