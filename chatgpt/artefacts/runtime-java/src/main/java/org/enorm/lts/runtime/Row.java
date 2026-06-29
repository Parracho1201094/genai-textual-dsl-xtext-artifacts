package org.enorm.lts.runtime;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public final class Row {
    private final LinkedHashMap<String, Object> values = new LinkedHashMap<>();

    public Row() {}

    public Row(Row other) {
        this.values.putAll(other.values);
    }

    public Object get(String column) {
        return values.get(column);
    }

    public void set(String column, Object value) {
        values.put(column, value);
    }

    public String string(String column) {
        Object v = values.get(column);
        return v == null ? "" : String.valueOf(v);
    }

    public Integer integer(String column) {
        Object v = values.get(column);
        if (v == null || String.valueOf(v).isBlank()) return 0;
        if (v instanceof Integer i) return i;
        if (v instanceof BigDecimal bd) return bd.intValue();
        return Integer.parseInt(String.valueOf(v));
    }

    public BigDecimal decimal(String column) {
        Object v = values.get(column);
        if (v == null || String.valueOf(v).isBlank()) return BigDecimal.ZERO;
        if (v instanceof BigDecimal bd) return bd;
        if (v instanceof Integer i) return BigDecimal.valueOf(i.longValue());
        return new BigDecimal(String.valueOf(v));
    }

    public Boolean bool(String column) {
        Object v = values.get(column);
        if (v == null || String.valueOf(v).isBlank()) return false;
        if (v instanceof Boolean b) return b;
        return Boolean.parseBoolean(String.valueOf(v));
    }

    public LocalDate date(String column) {
        Object v = values.get(column);
        if (v instanceof LocalDate d) return d;
        if (v == null || String.valueOf(v).isBlank()) return null;
        return LocalDate.parse(String.valueOf(v));
    }

    public Map<String, Object> values() {
        return Collections.unmodifiableMap(values);
    }

    public String key(String... columns) {
        List<String> parts = new ArrayList<>();
        for (String c : columns) parts.add(String.valueOf(values.get(c)));
        return String.join("\u001F", parts);
    }
}
