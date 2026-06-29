package generated.invoicing;

import java.math.BigDecimal;
import java.nio.file.Path;
import org.enorm.lts.runtime.*;
import org.enorm.lts.custom.CustomFunctions;

public final class InvoicingProcess {
    public static void main(String[] args) throws Exception {
        ProcessLogger log = new ProcessLogger();

        Table clients = CsvLoader.load(
            Path.of("data/invoicing/clients.csv"),
            Schema.of(
                Column.of("id", Type.INT),
                Column.of("name", Type.STRING),
                Column.of("taxNumber", Type.STRING)
            ),
            CsvOptions.header(true).delimiter(","),
            log
        );

        Table products = CsvLoader.load(
            Path.of("data/invoicing/products.csv"),
            Schema.of(
                Column.of("id", Type.INT),
                Column.of("name", Type.STRING),
                Column.of("unitPrice", Type.DECIMAL)
            ),
            CsvOptions.header(true).delimiter(","),
            log
        );

        Table sales = CsvLoader.load(
            Path.of("data/invoicing/sales.csv"),
            Schema.of(
                Column.of("clientId", Type.INT),
                Column.of("productId", Type.INT),
                Column.of("quantity", Type.DECIMAL),
                Column.of("saleDate", Type.DATE)
            ),
            CsvOptions.header(true).delimiter(","),
            log
        );

        clients = Operators.removeDuplicates(clients, "id");
        products = Operators.removeDuplicates(products, "id");
        sales = Operators.filter(sales, row -> row.decimal("quantity").compareTo(BigDecimal.ZERO) > 0);

        sales = Operators.leftJoin(
            sales,
            products,
            JoinSpec.on("productId", "id")
                .add("name", "productName")
                .add("unitPrice", "unitPrice"),
            log
        );

        sales = Operators.setColumn(
            sales,
            "lineTotal",
            Type.DECIMAL,
            row -> row.decimal("quantity").multiply(row.decimal("unitPrice"))
        );

        Table invoiceTotals = Operators.aggregate(
            sales,
            GroupBy.columns("clientId"),
            Aggregations.sum("lineTotal", "totalValue", Type.DECIMAL)
        );

        Table invoices = Table.empty(
            "invoices",
            Schema.of(
                Column.of("clientId", Type.INT),
                Column.of("clientName", Type.STRING),
                Column.of("taxNumber", Type.STRING),
                Column.of("totalValue", Type.DECIMAL),
                Column.of("description", Type.STRING)
            )
        );

        invoices = Operators.copy(
            invoiceTotals,
            invoices,
            Mapping.of("clientId", "clientId"),
            Mapping.of("totalValue", "totalValue")
        );

        invoices = Operators.leftJoin(
            invoices,
            clients,
            JoinSpec.on("clientId", "id")
                .add("name", "clientName")
                .add("taxNumber", "taxNumber"),
            log
        );

        invoices = Operators.setColumn(
            invoices,
            "description",
            Type.STRING,
            row -> CustomFunctions.concat("Invoice for ", row.string("clientName"))
        );

        invoices = Operators.filter(invoices, row -> row.decimal("totalValue").compareTo(BigDecimal.ZERO) > 0);
        invoices = Operators.sort(invoices, Sort.by("clientName", Sort.Direction.ASC));

        CsvSaver.save(invoices, Path.of("out/invoicing/invoices.csv"), CsvOptions.header(true), log);
        log.save(Path.of("out/invoicing/invoicing.log"));
    }
}
