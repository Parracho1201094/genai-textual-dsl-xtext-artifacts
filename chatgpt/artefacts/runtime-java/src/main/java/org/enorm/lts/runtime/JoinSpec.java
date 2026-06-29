package org.enorm.lts.runtime;

import java.util.*;

public final class JoinSpec {
    public record Condition(String leftColumn, String rightColumn) {}
    public record AddedColumn(String sourceColumn, String targetColumn) {}

    private final List<Condition> conditions = new ArrayList<>();
    private final List<AddedColumn> addedColumns = new ArrayList<>();

    private JoinSpec() {}

    public static JoinSpec on(String leftColumn, String rightColumn) {
        JoinSpec spec = new JoinSpec();
        spec.conditions.add(new Condition(leftColumn, rightColumn));
        return spec;
    }

    public static JoinSpec on(String left1, String right1, String left2, String right2) {
        JoinSpec spec = on(left1, right1);
        spec.conditions.add(new Condition(left2, right2));
        return spec;
    }

    public JoinSpec and(String leftColumn, String rightColumn) {
        conditions.add(new Condition(leftColumn, rightColumn));
        return this;
    }

    public JoinSpec add(String sourceColumn, String targetColumn) {
        addedColumns.add(new AddedColumn(sourceColumn, targetColumn));
        return this;
    }

    public List<Condition> conditions() { return List.copyOf(conditions); }
    public List<AddedColumn> addedColumns() { return List.copyOf(addedColumns); }
}
