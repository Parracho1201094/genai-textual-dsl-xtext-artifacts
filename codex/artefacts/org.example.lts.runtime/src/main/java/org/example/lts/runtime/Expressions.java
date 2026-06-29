package org.example.lts.runtime;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public final class Expressions {
    private Expressions() {
    }

    public static Expr literal(Object value) {
        return context -> value;
    }

    public static Expr column(String table, String column) {
        return context -> context.value(table, column);
    }

    public static Expr unary(String operator, Expr operand) {
        return context -> {
            Object value = operand.eval(context);
            if ("not".equals(operator)) {
                return !truth(value);
            }
            if ("-".equals(operator)) {
                return decimal(value).negate();
            }
            throw new IllegalArgumentException("Unknown unary operator: " + operator);
        };
    }

    public static Expr binary(Expr left, String operator, Expr right) {
        return context -> {
            Object l = left.eval(context);
            Object r = right.eval(context);
            switch (operator) {
            case "and": return truth(l) && truth(r);
            case "or": return truth(l) || truth(r);
            case "=": return compare(l, r) == 0;
            case "!=": return compare(l, r) != 0;
            case "<": return compare(l, r) < 0;
            case "<=": return compare(l, r) <= 0;
            case ">": return compare(l, r) > 0;
            case ">=": return compare(l, r) >= 0;
            case "&": return text(l) + text(r);
            case "+": return decimal(l).add(decimal(r));
            case "-": return decimal(l).subtract(decimal(r));
            case "*": return decimal(l).multiply(decimal(r));
            case "/":
                return decimal(l).divide(decimal(r), 12, RoundingMode.HALF_UP)
                        .stripTrailingZeros();
            default:
                throw new IllegalArgumentException("Unknown binary operator: " + operator);
            }
        };
    }

    public static Expr call(String name, Expr... arguments) {
        List<Expr> args = Arrays.asList(arguments);
        return context -> call(name, args, context);
    }

    private static Object call(String rawName, List<Expr> args, EvalContext context) {
        String name = rawName.toLowerCase(Locale.ROOT);
        if (isAggregate(name)) {
            List<Object> values = new ArrayList<>();
            List<EvalContext> group = context.group().isEmpty()
                    ? Arrays.asList(context) : context.group();
            for (EvalContext item : group) {
                values.add(args.isEmpty() ? null : args.get(0).eval(item));
            }
            return aggregate(name, values);
        }

        Object[] values = args.stream().map(a -> a.eval(context)).toArray();
        switch (name) {
        case "concat":
            StringBuilder result = new StringBuilder();
            for (Object value : values) result.append(text(value));
            return result.toString();
        case "split":
            String[] parts = text(values[0]).split(
                    java.util.regex.Pattern.quote(text(values[1])), -1);
            int index = integer(values[2]).intValue();
            return index >= 0 && index < parts.length ? parts[index] : "";
        case "extract":
            String source = text(values[0]);
            int start = integer(values[1]).intValue();
            int length = integer(values[2]).intValue();
            int safeStart = Math.max(0, Math.min(start, source.length()));
            return source.substring(safeStart,
                    Math.min(source.length(), safeStart + Math.max(0, length)));
        case "upper": return text(values[0]).toUpperCase(Locale.ROOT);
        case "lower": return text(values[0]).toLowerCase(Locale.ROOT);
        case "trim": return text(values[0]).trim();
        case "coalesce":
            for (Object value : values) if (value != null) return value;
            return null;
        case "tostring": return text(values[0]);
        case "tointeger": return integer(values[0]);
        case "todecimal": return decimal(values[0]);
        case "toboolean": return truth(values[0]);
        default:
            if (context.functions().contains(rawName)) {
                return context.functions().invoke(rawName, values);
            }
            throw new IllegalArgumentException("Unknown function: " + rawName);
        }
    }

    private static Object aggregate(String name, List<Object> values) {
        switch (name) {
        case "count":
            return values.stream().filter(Objects::nonNull).count();
        case "first":
            return values.stream().filter(Objects::nonNull).findFirst().orElse(null);
        case "sum":
            return values.stream().filter(Objects::nonNull)
                    .map(Expressions::decimal).reduce(BigDecimal.ZERO, BigDecimal::add);
        case "avg":
            List<BigDecimal> numbers = new ArrayList<>();
            values.stream().filter(Objects::nonNull)
                    .map(Expressions::decimal).forEach(numbers::add);
            return numbers.isEmpty() ? BigDecimal.ZERO
                    : numbers.stream().reduce(BigDecimal.ZERO, BigDecimal::add)
                            .divide(BigDecimal.valueOf(numbers.size()), 12,
                                    RoundingMode.HALF_UP).stripTrailingZeros();
        case "min":
            return values.stream().filter(Objects::nonNull)
                    .min(Expressions::compare).orElse(null);
        case "max":
            return values.stream().filter(Objects::nonNull)
                    .max(Expressions::compare).orElse(null);
        default:
            throw new IllegalArgumentException("Unknown aggregate: " + name);
        }
    }

    public static boolean truth(Object value) {
        if (value == null) return false;
        if (value instanceof Boolean) return (Boolean) value;
        if (value instanceof Number) return decimal(value).compareTo(BigDecimal.ZERO) != 0;
        return Boolean.parseBoolean(value.toString());
    }

    public static BigDecimal decimal(Object value) {
        if (value == null || value.toString().trim().isEmpty()) return BigDecimal.ZERO;
        if (value instanceof BigDecimal) return (BigDecimal) value;
        return new BigDecimal(value.toString());
    }

    public static Long integer(Object value) {
        return decimal(value).longValue();
    }

    public static String text(Object value) {
        return value == null ? "" : value.toString();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static int compare(Object left, Object right) {
        if (left == right) return 0;
        if (left == null) return -1;
        if (right == null) return 1;
        if (left instanceof Number || right instanceof Number) {
            return decimal(left).compareTo(decimal(right));
        }
        if (left instanceof Comparable && left.getClass().isInstance(right)) {
            return ((Comparable) left).compareTo(right);
        }
        return left.toString().compareTo(right.toString());
    }

    private static boolean isAggregate(String name) {
        return Arrays.asList("sum", "avg", "min", "max", "count", "first").contains(name);
    }
}
