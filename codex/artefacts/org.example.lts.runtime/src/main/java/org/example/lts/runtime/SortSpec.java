package org.example.lts.runtime;

public final class SortSpec {
    private final String column;
    private final boolean ascending;

    public SortSpec(String column, boolean ascending) {
        this.column = column;
        this.ascending = ascending;
    }

    public String column() { return column; }
    public boolean ascending() { return ascending; }
}
