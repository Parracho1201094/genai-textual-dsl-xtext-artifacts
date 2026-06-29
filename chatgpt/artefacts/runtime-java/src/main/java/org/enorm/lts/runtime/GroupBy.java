package org.enorm.lts.runtime;

import java.util.*;

public final class GroupBy {
    private final List<String> columns;
    private GroupBy(List<String> columns) { this.columns = List.copyOf(columns); }
    public static GroupBy columns(String... columns) { return new GroupBy(Arrays.asList(columns)); }
    public List<String> columns() { return columns; }
}
