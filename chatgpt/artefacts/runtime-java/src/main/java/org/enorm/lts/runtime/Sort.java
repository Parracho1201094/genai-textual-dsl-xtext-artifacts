package org.enorm.lts.runtime;

import java.util.*;

public final class Sort {
    public enum Direction { ASC, DESC }
    public record Key(String column, Direction direction) {}

    private final List<Key> keys;

    private Sort(List<Key> keys) { this.keys = List.copyOf(keys); }
    public List<Key> keys() { return keys; }

    public static Sort by(Object... columnDirectionPairs) {
        if (columnDirectionPairs.length % 2 != 0) throw new IllegalArgumentException("Sort.by expects column/direction pairs");
        List<Key> keys = new ArrayList<>();
        for (int i = 0; i < columnDirectionPairs.length; i += 2) {
            keys.add(new Key((String) columnDirectionPairs[i], (Direction) columnDirectionPairs[i + 1]));
        }
        return new Sort(keys);
    }
}
