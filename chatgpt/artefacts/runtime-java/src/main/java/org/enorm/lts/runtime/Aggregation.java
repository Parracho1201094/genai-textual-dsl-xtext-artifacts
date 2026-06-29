package org.enorm.lts.runtime;

public record Aggregation(String function, String sourceColumn, String targetColumn, Type type) {}
