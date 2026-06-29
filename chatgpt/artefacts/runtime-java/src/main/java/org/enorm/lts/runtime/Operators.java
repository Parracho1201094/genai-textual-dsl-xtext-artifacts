package org.enorm.lts.runtime;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public final class Operators {
    private Operators() {}

    public static Table sort(Table table, Sort sort) {
        List<Row> rows = new ArrayList<>();
        for (Row r : table.rows()) rows.add(new Row(r));
        Comparator<Row> comparator = null;
        for (Sort.Key key : sort.keys()) {
            Comparator<Row> c = Comparator.comparing(
                r -> asComparable(r.get(key.column())),
                Comparator.nullsLast(Comparator.naturalOrder())
            );
            if (key.direction() == Sort.Direction.DESC) c = c.reversed();
            comparator = comparator == null ? c : comparator.thenComparing(c);
        }
        if (comparator != null) rows.sort(comparator);
        return table.withRows(rows);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static Comparable asComparable(Object value) {
        return value instanceof Comparable c ? c : String.valueOf(value);
    }

    public static Table filter(Table table, Predicate<Row> predicate) {
        List<Row> rows = new ArrayList<>();
        for (Row row : table.rows()) {
            if (predicate.test(row)) rows.add(new Row(row));
        }
        return table.withRows(rows);
    }

    public static Table removeDuplicates(Table table, String... columns) {
        Set<String> seen = new LinkedHashSet<>();
        List<Row> rows = new ArrayList<>();
        for (Row row : table.rows()) {
            String key = row.key(columns);
            if (seen.add(key)) rows.add(new Row(row));
        }
        return table.withRows(rows);
    }

    public static Table copy(Table source, Table target, Mapping... mappings) {
        List<Row> rows = new ArrayList<>(target.rows().stream().map(Row::new).toList());
        for (Row sourceRow : source.rows()) {
            Row targetRow = new Row();
            for (Column col : target.schema().columns()) {
                targetRow.set(col.name(), null);
            }
            for (Mapping mapping : mappings) {
                targetRow.set(mapping.targetColumn(), sourceRow.get(mapping.sourceColumn()));
            }
            rows.add(targetRow);
        }
        return target.withRows(rows);
    }

    public static Table leftJoin(Table left, Table right, JoinSpec spec, ProcessLogger log) {
        Map<String, List<Row>> index = new LinkedHashMap<>();
        String[] rightKeyColumns = spec.conditions().stream().map(JoinSpec.Condition::rightColumn).toArray(String[]::new);
        for (Row r : right.rows()) {
            index.computeIfAbsent(r.key(rightKeyColumns), k -> new ArrayList<>()).add(r);
        }

        Schema newSchema = left.schema();
        for (JoinSpec.AddedColumn added : spec.addedColumns()) {
            Column sourceCol = right.schema().column(added.sourceColumn());
            Type type = sourceCol == null ? Type.STRING : sourceCol.type();
            newSchema = newSchema.addOrReplace(Column.of(added.targetColumn(), type));
        }

        String[] leftKeyColumns = spec.conditions().stream().map(JoinSpec.Condition::leftColumn).toArray(String[]::new);
        List<Row> rows = new ArrayList<>();
        for (Row leftRow : left.rows()) {
            Row output = new Row(leftRow);
            List<Row> matches = index.get(leftRow.key(leftKeyColumns));
            if (matches == null || matches.isEmpty()) {
                log.warn("No join match for table '" + left.name() + "' key " + leftRow.key(leftKeyColumns) + " in table '" + right.name() + "'.");
                for (JoinSpec.AddedColumn added : spec.addedColumns()) output.set(added.targetColumn(), null);
            } else {
                if (matches.size() > 1) {
                    log.warn("Multiple join matches for table '" + left.name() + "' key " + leftRow.key(leftKeyColumns) + "; using first match.");
                }
                Row match = matches.get(0);
                for (JoinSpec.AddedColumn added : spec.addedColumns()) output.set(added.targetColumn(), match.get(added.sourceColumn()));
            }
            rows.add(output);
        }
        return new Table(left.name(), newSchema, rows);
    }

    public static Table aggregate(Table source, GroupBy groupBy, Aggregation... aggregations) {
        Map<String, List<Row>> groups = new LinkedHashMap<>();
        String[] groupColumns = groupBy.columns().toArray(String[]::new);
        for (Row row : source.rows()) {
            groups.computeIfAbsent(row.key(groupColumns), k -> new ArrayList<>()).add(row);
        }

        List<Column> cols = new ArrayList<>();
        for (String c : groupBy.columns()) {
            Column original = source.schema().column(c);
            cols.add(Column.of(c, original == null ? Type.STRING : original.type()));
        }
        for (Aggregation a : aggregations) cols.add(Column.of(a.targetColumn(), a.type()));
        Schema schema = Schema.of(cols.toArray(Column[]::new));

        List<Row> rows = new ArrayList<>();
        for (List<Row> groupRows : groups.values()) {
            Row first = groupRows.get(0);
            Row out = new Row();
            for (String c : groupBy.columns()) out.set(c, first.get(c));
            for (Aggregation a : aggregations) out.set(a.targetColumn(), computeAggregation(groupRows, a));
            rows.add(out);
        }
        return new Table(source.name() + "_aggregate", schema, rows);
    }

    private static Object computeAggregation(List<Row> rows, Aggregation a) {
        return switch (a.function()) {
            case "sum" -> rows.stream().map(r -> r.decimal(a.sourceColumn())).reduce(BigDecimal.ZERO, BigDecimal::add);
            case "avg" -> rows.isEmpty() ? BigDecimal.ZERO : rows.stream().map(r -> r.decimal(a.sourceColumn())).reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(rows.size()), MathContext.DECIMAL64);
            case "min" -> rows.stream().map(r -> r.decimal(a.sourceColumn())).min(Comparator.naturalOrder()).orElse(BigDecimal.ZERO);
            case "max" -> rows.stream().map(r -> r.decimal(a.sourceColumn())).max(Comparator.naturalOrder()).orElse(BigDecimal.ZERO);
            case "count" -> rows.size();
            default -> throw new IllegalArgumentException("Unsupported aggregation: " + a.function());
        };
    }

    public static Table setColumn(Table table, String column, Type type, Function<Row, Object> computer) {
        Schema schema = table.schema().addOrReplace(Column.of(column, type));
        List<Row> rows = new ArrayList<>();
        for (Row row : table.rows()) {
            Row next = new Row(row);
            next.set(column, computer.apply(next));
            rows.add(next);
        }
        return new Table(table.name(), schema, rows);
    }

    public static Table dropColumns(Table table, String... columns) {
        Set<String> drop = new HashSet<>(Arrays.asList(columns));
        Schema schema = table.schema().drop(columns);
        List<Row> rows = new ArrayList<>();
        for (Row row : table.rows()) {
            Row next = new Row();
            for (Column col : schema.columns()) {
                if (!drop.contains(col.name())) next.set(col.name(), row.get(col.name()));
            }
            rows.add(next);
        }
        return new Table(table.name(), schema, rows);
    }
}
