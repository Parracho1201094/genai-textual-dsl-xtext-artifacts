package org.enorm.lts.runtime;

public final class Aggregations {
    private Aggregations() {}
    public static Aggregation sum(String sourceColumn, String targetColumn, Type type) { return new Aggregation("sum", sourceColumn, targetColumn, type); }
    public static Aggregation avg(String sourceColumn, String targetColumn, Type type) { return new Aggregation("avg", sourceColumn, targetColumn, type); }
    public static Aggregation min(String sourceColumn, String targetColumn, Type type) { return new Aggregation("min", sourceColumn, targetColumn, type); }
    public static Aggregation max(String sourceColumn, String targetColumn, Type type) { return new Aggregation("max", sourceColumn, targetColumn, type); }
    public static Aggregation count(String sourceColumn, String targetColumn, Type type) { return new Aggregation("count", sourceColumn, targetColumn, type); }
}
