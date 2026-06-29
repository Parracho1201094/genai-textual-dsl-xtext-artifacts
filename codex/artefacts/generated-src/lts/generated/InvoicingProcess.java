package lts.generated;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

import org.example.lts.runtime.*;

/**
 * Generated from the LTS process Invoicing.
 * Regenerate this file instead of editing it manually.
 */
public final class InvoicingProcess {
    private final Path baseDirectory;
    private final Map<String, DataTable> tables = new LinkedHashMap<>();
    private final FunctionRegistry functions = new FunctionRegistry();
    private final LtsLog log = new LtsLog();

    public InvoicingProcess(Path baseDirectory) {
        this.baseDirectory = baseDirectory;
    }

    public static void main(String[] args) throws Exception {
        Path base = args.length == 0 ? Path.of(".") : Path.of(args[0]);
        new InvoicingProcess(base).run();
    }

    public void run() throws Exception {
        tables.put("clients",
                CsvIO.read("clients", path("data/clients.csv"),
                        ',', true,
                        schema_clients(), log));
        tables.put("products",
                CsvIO.read("products", path("data/products.csv"),
                        ',', true,
                        schema_products(), log));
        tables.put("sales",
                CsvIO.read("sales", path("data/sales.csv"),
                        ',', true,
                        schema_sales(), log));
        tables.put("saleLines",
                new DataTable("saleLines",
                        schema_saleLines()));
        LtsOps.append("sales",
                tables.get("sales"),
                "saleLines",
                tables.get("saleLines"),
                LtsOps.assignments(
                        "clientId", Expressions.column("sales",
                                                "clientId"),
                                        
                                "productId", Expressions.column("sales",
                                                "productId"),
                                        
                                "quantity", Expressions.column("sales",
                                                "quantity")
                        )
                , functions);
        LtsOps.join("saleLines",
                tables.get("saleLines"),
                "products",
                tables.get("products"),
                true,
                Expressions.binary(Expressions.column("saleLines",
                                        "productId"),
                                        "=",
                                        Expressions.column("products",
                                                                "productId")),
                LtsOps.assignments(
                        "unitPrice", Expressions.column("products",
                                                "unitPrice")
                        )
                ,
                LtsOps.assignments(
                )
                ,
                functions, log);
        LtsOps.join("saleLines",
                tables.get("saleLines"),
                "clients",
                tables.get("clients"),
                true,
                Expressions.binary(Expressions.column("saleLines",
                                        "clientId"),
                                        "=",
                                        Expressions.column("clients",
                                                                "clientId")),
                LtsOps.assignments(
                        "clientName", Expressions.column("clients",
                                                "clientName")
                        )
                ,
                LtsOps.assignments(
                )
                ,
                functions, log);
        LtsOps.calculate("saleLines",
                tables.get("saleLines"),
                "lineTotal",
                Expressions.binary(Expressions.column("saleLines",
                                        "quantity"),
                                        "*",
                                        Expressions.column("saleLines",
                                                                "unitPrice")), functions);
        tables.put("invoices",
                new DataTable("invoices",
                        schema_invoices()));
        LtsOps.group("saleLines",
                tables.get("saleLines"),
                tables.get("invoices"),
                LtsOps.expressions(
                        Expressions.column("saleLines",
                                                "clientId"), 
                                        Expressions.column("saleLines",
                                                "clientName")
                        ),
                LtsOps.assignments(
                        "clientId", Expressions.call("first"
                        ,                         Expressions.column("saleLines",
                                                                        "clientId")
                                                ),
                                        
                                "clientName", Expressions.call("first"
                        ,                         Expressions.column("saleLines",
                                                                        "clientName")
                                                ),
                                        
                                "totalToInvoice", Expressions.call("sum"
                        ,                         Expressions.column("saleLines",
                                                                        "lineTotal")
                                                )
                        )
                , functions);
        CsvIO.write(tables.get("invoices"),
                path("out/invoices.csv"), ',',
                true);
        log.save(path("out/invoicing.log"));
    }

    private Path path(String relativeOrAbsolute) {
        Path path = Path.of(relativeOrAbsolute);
        return path.isAbsolute() ? path : baseDirectory.resolve(path).normalize();
    }

    private static Schema schema_clients() {
        return Schema.builder()
            .column("clientId", ValueType.INTEGER,
                    true, null)
            .column("clientName", ValueType.STRING,
                    true, null)
            .build();
    }

    private static Schema schema_products() {
        return Schema.builder()
            .column("productId", ValueType.INTEGER,
                    true, null)
            .column("unitPrice", ValueType.DECIMAL,
                    true, null)
            .build();
    }

    private static Schema schema_sales() {
        return Schema.builder()
            .column("clientId", ValueType.INTEGER,
                    true, null)
            .column("productId", ValueType.INTEGER,
                    true, null)
            .column("quantity", ValueType.DECIMAL,
                    true, null)
            .build();
    }

    private static Schema schema_saleLines() {
        return Schema.builder()
            .column("clientId", ValueType.INTEGER,
                    true, null)
            .column("clientName", ValueType.STRING,
                    false, null)
            .column("productId", ValueType.INTEGER,
                    true, null)
            .column("quantity", ValueType.DECIMAL,
                    true, null)
            .column("unitPrice", ValueType.DECIMAL,
                    false, null)
            .column("lineTotal", ValueType.DECIMAL,
                    false, null)
            .build();
    }

    private static Schema schema_invoices() {
        return Schema.builder()
            .column("clientId", ValueType.INTEGER,
                    true, null)
            .column("clientName", ValueType.STRING,
                    true, null)
            .column("totalToInvoice", ValueType.DECIMAL,
                    true, null)
            .build();
    }

}
