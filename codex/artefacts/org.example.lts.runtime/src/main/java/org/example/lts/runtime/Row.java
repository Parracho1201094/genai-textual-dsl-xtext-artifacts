package org.example.lts.runtime;

import java.util.LinkedHashMap;

public final class Row extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public Row copy() {
        Row copy = new Row();
        copy.putAll(this);
        return copy;
    }
}
