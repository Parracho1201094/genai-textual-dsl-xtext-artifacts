package org.example.lts.runtime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Schema {
    public static final class Field {
        private final String name;
        private final ValueType type;
        private final boolean required;
        private final String format;

        private Field(String name, ValueType type, boolean required, String format) {
            this.name = name;
            this.type = type;
            this.required = required;
            this.format = format;
        }

        public String name() { return name; }
        public ValueType type() { return type; }
        public boolean required() { return required; }
        public String format() { return format; }
    }

    public static final class Builder {
        private final List<Field> fields = new ArrayList<>();

        public Builder column(String name, ValueType type, boolean required, String format) {
            fields.add(new Field(name, type, required, format));
            return this;
        }

        public Schema build() {
            return new Schema(fields);
        }
    }

    private final LinkedHashMap<String, Field> fields;

    private Schema(List<Field> fields) {
        this.fields = new LinkedHashMap<>();
        for (Field field : fields) {
            this.fields.put(field.name(), field);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<Field> fields() {
        return Collections.unmodifiableList(new ArrayList<>(fields.values()));
    }

    public Field field(String name) {
        return fields.get(name);
    }

    public boolean contains(String name) {
        return fields.containsKey(name);
    }

    public void add(String name, ValueType type, boolean required, String format) {
        fields.put(name, new Field(name, type, required, format));
    }

    public void remove(String name) {
        fields.remove(name);
    }

    public Map<String, Field> asMap() {
        return Collections.unmodifiableMap(fields);
    }
}
