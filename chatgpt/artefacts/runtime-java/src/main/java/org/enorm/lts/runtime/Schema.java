package org.enorm.lts.runtime;

import java.util.*;

public final class Schema {
    private final List<Column> columns;
    private final Map<String, Column> byName;

    private Schema(List<Column> columns) {
        this.columns = List.copyOf(columns);
        this.byName = new LinkedHashMap<>();
        for (Column c : columns) {
            if (byName.put(c.name(), c) != null) {
                throw new IllegalArgumentException("Duplicate column: " + c.name());
            }
        }
    }

    public static Schema of(Column... columns) {
        return new Schema(Arrays.asList(columns));
    }

    public List<Column> columns() {
        return columns;
    }

    public boolean has(String name) {
        return byName.containsKey(name);
    }

    public Column column(String name) {
        return byName.get(name);
    }

    public Schema addOrReplace(Column column) {
        List<Column> next = new ArrayList<>();
        boolean replaced = false;
        for (Column c : columns) {
            if (c.name().equals(column.name())) {
                next.add(column);
                replaced = true;
            } else {
                next.add(c);
            }
        }
        if (!replaced) next.add(column);
        return new Schema(next);
    }

    public Schema drop(String... names) {
        Set<String> drop = new HashSet<>(Arrays.asList(names));
        List<Column> next = new ArrayList<>();
        for (Column c : columns) {
            if (!drop.contains(c.name())) next.add(c);
        }
        return new Schema(next);
    }
}
