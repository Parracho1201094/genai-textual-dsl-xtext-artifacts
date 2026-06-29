package org.enorm.lts.runtime;

public record Column(String name, Type type) {
    public static Column of(String name, Type type) {
        return new Column(name, type);
    }
}
