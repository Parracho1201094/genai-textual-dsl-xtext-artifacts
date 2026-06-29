package org.example.lts.runtime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class LtsOps {
    private LtsOps() {
    }

    public static Map<String, Expr> assignments(Object... pairs) {
        if (pairs.length % 2 != 0) {
            throw new IllegalArgumentException("Assignments require name/expression pairs.");
        }
        Map<String, Expr> result = new LinkedHashMap<>();
        for (int i = 0; i < pairs.length; i += 2) {
            result.put((String) pairs[i], (Expr) pairs[i + 1]);
        }
        return result;
    }

    public static void append(String sourceName, DataTable source,
            String targetName, DataTable target, Map<String, Expr> mappings,
            FunctionRegistry functions) {
        for (Row sourceRow : source.rows()) {
            Row output = new Row();
            EvalContext context = context(functions, sourceName, sourceRow,
                    targetName, output);
            if (mappings.isEmpty()) {
                for (Schema.Field field : target.schema().fields()) {
                    output.put(field.name(), sourceRow.get(field.name()));
                }
            } else {
                mappings.forEach((column, expression) ->
                        output.put(column, expression.eval(context)));
            }
            target.rows().add(output);
        }
    }

    public static void filter(String tableName, DataTable table, Expr condition,
            FunctionRegistry functions) {
        table.rows().removeIf(row ->
                !Expressions.truth(condition.eval(context(functions, tableName, row))));
    }

    public static void sort(DataTable table, SortSpec... specifications) {
        Comparator<Row> comparator = null;
        for (SortSpec specification : specifications) {
            Comparator<Row> next = (left, right) -> Expressions.compare(
                    left.get(specification.column()), right.get(specification.column()));
            if (!specification.ascending()) {
                next = next.reversed();
            }
            comparator = comparator == null ? next : comparator.thenComparing(next);
        }
        if (comparator != null) {
            table.rows().sort(comparator);
        }
    }

    public static void removeDuplicates(DataTable table, String... columns) {
        Set<List<Object>> seen = new LinkedHashSet<>();
        table.rows().removeIf(row -> {
            List<Object> key = new ArrayList<>();
            for (String column : columns) {
                key.add(row.get(column));
            }
            return !seen.add(key);
        });
    }

    public static void calculate(String tableName, DataTable table, String column,
            Expr expression, FunctionRegistry functions) {
        for (Row row : table.rows()) {
            row.put(column, expression.eval(context(functions, tableName, row)));
        }
    }

    public static void insertColumn(String tableName, DataTable table, String column,
            ValueType type, Expr expression, FunctionRegistry functions) {
        table.schema().add(column, type, false, null);
        for (Row row : table.rows()) {
            row.put(column, expression == null ? null
                    : expression.eval(context(functions, tableName, row)));
        }
    }

    public static void removeColumns(DataTable table, String... columns) {
        for (String column : columns) {
            table.schema().remove(column);
            for (Row row : table.rows()) {
                row.remove(column);
            }
        }
    }

    public static void join(String targetName, DataTable target, String sourceName,
            DataTable source, boolean leftJoin, Expr condition,
            Map<String, Expr> selections, Map<String, Expr> aggregations,
            FunctionRegistry functions, LtsLog log) {
        for (Row targetRow : target.rows()) {
            List<EvalContext> matches = new ArrayList<>();
            for (Row sourceRow : source.rows()) {
                EvalContext candidate = context(functions,
                        targetName, targetRow, sourceName, sourceRow);
                if (Expressions.truth(condition.eval(candidate))) {
                    matches.add(candidate);
                }
            }
            if (matches.isEmpty()) {
                if (!leftJoin) {
                    targetRow.put("__lts_remove__", Boolean.TRUE);
                    continue;
                }
                matches.add(context(functions,
                        targetName, targetRow, sourceName, null));
                log.warning("No join match in '" + sourceName + "' for a row in '"
                        + targetName + "'.");
            }
            EvalContext first = matches.get(0);
            selections.forEach((column, expression) ->
                    targetRow.put(column, expression.eval(first)));
            EvalContext grouped = new EvalContext(first.rows(), matches, functions);
            aggregations.forEach((column, expression) ->
                    targetRow.put(column, expression.eval(grouped)));
        }
        target.rows().removeIf(row -> Boolean.TRUE.equals(row.remove("__lts_remove__")));
    }

    public static void group(String sourceName, DataTable source, DataTable target,
            List<Expr> keyExpressions, Map<String, Expr> assignments,
            FunctionRegistry functions) {
        Map<List<Object>, List<EvalContext>> groups = new LinkedHashMap<>();
        for (Row row : source.rows()) {
            EvalContext context = context(functions, sourceName, row);
            List<Object> key = new ArrayList<>();
            for (Expr expression : keyExpressions) {
                key.add(expression.eval(context));
            }
            groups.computeIfAbsent(key, ignored -> new ArrayList<>()).add(context);
        }
        target.rows().clear();
        for (List<EvalContext> members : groups.values()) {
            EvalContext grouped = new EvalContext(members.get(0).rows(), members, functions);
            Row output = new Row();
            assignments.forEach((column, expression) ->
                    output.put(column, expression.eval(grouped)));
            target.rows().add(output);
        }
    }

    public static void lookup(String targetTableName, DataTable target,
            String targetColumn, String sourceTableName, DataTable source,
            Expr left, Expr right, Expr result, Expr defaultValue,
            FunctionRegistry functions, LtsLog log) {
        for (Row targetRow : target.rows()) {
            Object found = null;
            boolean matched = false;
            for (Row sourceRow : source.rows()) {
                EvalContext context = context(functions,
                        targetTableName, targetRow, sourceTableName, sourceRow);
                if (Expressions.compare(left.eval(context), right.eval(context)) == 0) {
                    found = result.eval(context);
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                EvalContext context = context(functions, targetTableName, targetRow);
                found = defaultValue == null ? null : defaultValue.eval(context);
                log.warning("Lookup found no match in '" + sourceTableName + "'.");
            }
            targetRow.put(targetColumn, found);
        }
    }

    public static List<Expr> expressions(Expr... expressions) {
        return Arrays.asList(expressions);
    }

    private static EvalContext context(FunctionRegistry functions, Object... namesAndRows) {
        Map<String, Row> rows = new LinkedHashMap<>();
        for (int i = 0; i < namesAndRows.length; i += 2) {
            rows.put((String) namesAndRows[i], (Row) namesAndRows[i + 1]);
        }
        return new EvalContext(rows, Collections.emptyList(), functions);
    }
}
