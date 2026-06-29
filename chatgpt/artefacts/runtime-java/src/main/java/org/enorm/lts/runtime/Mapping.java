package org.enorm.lts.runtime;

public record Mapping(String sourceColumn, String targetColumn) {
    public static Mapping of(String sourceColumn, String targetColumn) {
        return new Mapping(sourceColumn, targetColumn);
    }
}
