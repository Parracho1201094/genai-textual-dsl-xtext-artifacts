package org.enorm.domain.steps.sortStep;

import org.enorm.domain.enums.SortType;
import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class SortStepDefault implements ISortStep {

    @Override
    public Table apply(Table inputTable, Column column, SortType sortType) {

        // Creates a new table to store the sorted result
        Table sortedTable = new Table(new ArrayList<>(inputTable.getColumnList()), inputTable.getName());

        // Creates a list to store the row indices and sort them based on the values in the specified column
        List<Integer> indices = new ArrayList<>();
        for (int i = 1; i <= inputTable.getNumLines(); i++) {
            indices.add(i);
        }

        // Defines a comparator based on the specified column's values
        Comparator<Integer> comparator = (index1, index2) -> {
            Object value1 = inputTable.getColumnInfo().get(column).get(index1);
            Object value2 = inputTable.getColumnInfo().get(column).get(index2);
            if (value1 instanceof Comparable && value2 instanceof Comparable) {
                @SuppressWarnings("unchecked")
                Comparable<Object> comparableValue1 = (Comparable<Object>) value1;
                @SuppressWarnings("unchecked")
                Comparable<Object> comparableValue2 = (Comparable<Object>) value2;
                return sortType == SortType.ASC ? comparableValue1.compareTo(comparableValue2) : comparableValue2.compareTo(comparableValue1);
            } else {
                throw new IllegalArgumentException("Values in the column are not comparable");
            }
        };

        // Sorts the indices based on the comparator
        indices.sort(comparator);

        // Reorders the rows in the sorted table based on the sorted indices
        for (int i = 0; i < indices.size(); i++) {
            int index = indices.get(i);
            Map<Column, Object> lineInfo = inputTable.getLineInfo(index);
            for (Column col : lineInfo.keySet()) {
                sortedTable.getColumnInfo().get(col).put(i + 1, lineInfo.get(col));
            }
        }

        // Returns the sorted table
        return sortedTable;
    }
}

