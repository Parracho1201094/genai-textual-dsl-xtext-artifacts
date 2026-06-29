package org.example.lts.runtime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DataTable {
    private final String name;
    private final Schema schema;
    private final List<Row> rows;

    public DataTable(String name, Schema schema) {
        this(name, schema, new ArrayList<>());
    }

    public DataTable(String name, Schema schema, List<Row> rows) {
        this.name = name;
        this.schema = schema;
        this.rows = new ArrayList<>(rows);
    }

    public String name() { return name; }
    public Schema schema() { return schema; }
    public List<Row> rows() { return rows; }
    public List<Row> readOnlyRows() { return Collections.unmodifiableList(rows); }
}
