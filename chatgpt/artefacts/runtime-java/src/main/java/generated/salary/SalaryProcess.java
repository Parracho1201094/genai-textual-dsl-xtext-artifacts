package generated.salary;

import java.nio.file.Path;
import org.enorm.lts.runtime.*;
import org.enorm.lts.custom.CustomFunctions;

public final class SalaryProcess {
    public static void main(String[] args) throws Exception {
        ProcessLogger log = new ProcessLogger();

        Table employee = CsvLoader.load(
            Path.of("data/salary/employees.csv"),
            Schema.of(
                Column.of("id", Type.INT),
                Column.of("name", Type.STRING),
                Column.of("categoryId", Type.INT)
            ),
            CsvOptions.header(true).delimiter(","),
            log
        );

        Table workedHours = CsvLoader.load(
            Path.of("data/salary/worked_hours.csv"),
            Schema.of(
                Column.of("employeeId", Type.INT),
                Column.of("date", Type.DATE),
                Column.of("hours", Type.DECIMAL)
            ),
            CsvOptions.header(true).delimiter(","),
            log
        );

        Table category = CsvLoader.load(
            Path.of("data/salary/categories.csv"),
            Schema.of(
                Column.of("id", Type.INT),
                Column.of("name", Type.STRING),
                Column.of("hourValue", Type.DECIMAL)
            ),
            CsvOptions.header(true).delimiter(","),
            log
        );

        employee = Operators.sort(employee, Sort.by("id", Sort.Direction.ASC));
        employee = Operators.removeDuplicates(employee, "id");

        Table hoursByEmployee = Operators.aggregate(
            workedHours,
            GroupBy.columns("employeeId"),
            Aggregations.sum("hours", "workedHours", Type.DECIMAL)
        );

        Table payments = Table.empty(
            "payments",
            Schema.of(
                Column.of("employeeId", Type.INT),
                Column.of("employeeName", Type.STRING),
                Column.of("categoryId", Type.INT),
                Column.of("categoryName", Type.STRING),
                Column.of("hourValue", Type.DECIMAL),
                Column.of("workedHours", Type.DECIMAL),
                Column.of("payment", Type.DECIMAL),
                Column.of("label", Type.STRING)
            )
        );

        payments = Operators.copy(
            employee,
            payments,
            Mapping.of("id", "employeeId"),
            Mapping.of("name", "employeeName"),
            Mapping.of("categoryId", "categoryId")
        );

        payments = Operators.leftJoin(
            payments,
            category,
            JoinSpec.on("categoryId", "id")
                .add("name", "categoryName")
                .add("hourValue", "hourValue"),
            log
        );

        payments = Operators.leftJoin(
            payments,
            hoursByEmployee,
            JoinSpec.on("employeeId", "employeeId")
                .add("workedHours", "workedHours"),
            log
        );

        payments = Operators.setColumn(
            payments,
            "payment",
            Type.DECIMAL,
            row -> row.decimal("workedHours").multiply(row.decimal("hourValue"))
        );

        payments = Operators.setColumn(
            payments,
            "label",
            Type.STRING,
            row -> CustomFunctions.concat(row.string("employeeName"), " / ", row.string("categoryName"))
        );

        payments = Operators.filter(payments, row -> row.decimal("payment").compareTo(java.math.BigDecimal.ZERO) > 0);
        payments = Operators.dropColumns(payments, "hourValue", "workedHours");
        payments = Operators.sort(payments, Sort.by("employeeName", Sort.Direction.ASC));

        CsvSaver.save(payments, Path.of("out/salary/payments.csv"), CsvOptions.header(true), log);
        log.save(Path.of("out/salary/salary.log"));
    }
}
