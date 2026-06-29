package org.enorm.domain.tables;

import org.enorm.domain.enums.DataType;

import java.util.Objects;

public record Column(String name, DataType type) {

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column column = (Column) o;
        return Objects.equals(name, column.name) && type == column.type;
    }
}
