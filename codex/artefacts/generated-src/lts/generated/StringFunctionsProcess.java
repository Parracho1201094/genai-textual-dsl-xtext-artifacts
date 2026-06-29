package lts.generated;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

import org.example.lts.runtime.*;

/**
 * Generated from the LTS process StringFunctions.
 * Regenerate this file instead of editing it manually.
 */
public final class StringFunctionsProcess {
    private final Path baseDirectory;
    private final Map<String, DataTable> tables = new LinkedHashMap<>();
    private final FunctionRegistry functions = new FunctionRegistry();
    private final LtsLog log = new LtsLog();

    public StringFunctionsProcess(Path baseDirectory) {
        this.baseDirectory = baseDirectory;
    }

    public static void main(String[] args) throws Exception {
        Path base = args.length == 0 ? Path.of(".") : Path.of(args[0]);
        new StringFunctionsProcess(base).run();
    }

    public void run() throws Exception {
        tables.put("people",
                CsvIO.read("people", path("data/people.csv"),
                        ',', true,
                        schema_people(), log));
        tables.put("normalized",
                new DataTable("normalized",
                        schema_normalized()));
        LtsOps.append("people",
                tables.get("people"),
                "normalized",
                tables.get("normalized"),
                LtsOps.assignments(
                        "fullName", Expressions.column("people",
                                                "fullName"),
                                        
                                "firstName", Expressions.call("split"
                        ,                         Expressions.column("people",
                                                                        "fullName"), 
                                                                        Expressions.literal(" "), 
                                                                        Expressions.literal(0L)
                                                ),
                                        
                                "region", Expressions.call("extract"
                        ,                         Expressions.column("people",
                                                                        "code"), 
                                                                        Expressions.literal(0L), 
                                                                        Expressions.literal(2L)
                                                ),
                                        
                                "displayName", Expressions.call("concat"
                        ,                         Expressions.call("split"
                                                ,                         Expressions.column("people",
                                                                                                "fullName"), 
                                                                                                Expressions.literal(" "), 
                                                                                                Expressions.literal(0L)
                                                                        ), 
                                                                        Expressions.literal(" - "), 
                                                                        Expressions.call("extract"
                                                ,                         Expressions.column("people",
                                                                                                "code"), 
                                                                                                Expressions.literal(0L), 
                                                                                                Expressions.literal(2L)
                                                                        )
                                                )
                        )
                , functions);
        CsvIO.write(tables.get("normalized"),
                path("out/normalized.csv"), ',',
                true);
        log.save(path("out/strings.log"));
    }

    private Path path(String relativeOrAbsolute) {
        Path path = Path.of(relativeOrAbsolute);
        return path.isAbsolute() ? path : baseDirectory.resolve(path).normalize();
    }

    private static Schema schema_people() {
        return Schema.builder()
            .column("fullName", ValueType.STRING,
                    true, null)
            .column("code", ValueType.STRING,
                    true, null)
            .build();
    }

    private static Schema schema_normalized() {
        return Schema.builder()
            .column("fullName", ValueType.STRING,
                    false, null)
            .column("firstName", ValueType.STRING,
                    false, null)
            .column("region", ValueType.STRING,
                    false, null)
            .column("displayName", ValueType.STRING,
                    false, null)
            .build();
    }

}
