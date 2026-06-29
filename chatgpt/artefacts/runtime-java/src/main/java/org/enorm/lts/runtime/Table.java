package org.enorm.lts.runtime;

import java.util.*;

public final class Table {
    private final String name;
    private final Schema schema;
    private final List<Row> rows;

    public Table(String name, Schema schema, List<Row> rows) {
        this.name = name;
        this.schema = schema;
        this.rows = List.copyOf(rows);
    }

    public static Table empty(String name, Schema schema) {
        return new Table(name, schema, List.of());
    }

    public String name() { return name; }
    public Schema schema() { return schema; }
    public List<Row> rows() { return rows; }

    public Table withRows(List<Row> rows) {
        return new Table(name, schema, rows);
    }

    public Table withSchema(Schema schema) {
        return new Table(name, schema, rows);
    }

    public Table with(String name, Schema schema, List<Row> rows) {
        return new Table(name, schema, rows);
    }
}
