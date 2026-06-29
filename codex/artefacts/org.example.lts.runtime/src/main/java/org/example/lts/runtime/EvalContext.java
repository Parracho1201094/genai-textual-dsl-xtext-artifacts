package org.example.lts.runtime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class EvalContext {
    private final Map<String, Row> rows;
    private final List<EvalContext> group;
    private final FunctionRegistry functions;

    public EvalContext(Map<String, Row> rows, FunctionRegistry functions) {
        this(rows, Collections.emptyList(), functions);
    }

    public EvalContext(Map<String, Row> rows, List<EvalContext> group,
            FunctionRegistry functions) {
        this.rows = new LinkedHashMap<>(rows);
        this.group = new ArrayList<>(group);
        this.functions = functions;
    }

    public Object value(String table, String column) {
        Row row = rows.get(table);
        return row == null ? null : row.get(column);
    }

    public List<EvalContext> group() {
        return Collections.unmodifiableList(group);
    }

    public FunctionRegistry functions() {
        return functions;
    }

    public Map<String, Row> rows() {
        return Collections.unmodifiableMap(rows);
    }
}
