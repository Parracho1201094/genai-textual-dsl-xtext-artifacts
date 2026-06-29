package org.enorm.domain.steps.filterStep;

import org.enorm.domain.enums.FilterOperatorType;
import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;
import org.enorm.domain.tables.factories.FactoryTable;

import java.time.LocalDate;
import java.util.Map;

public class FilterStepDefault implements IFilterStep {

    @Override
    public Table apply(Table inputTable, Column targetColumn, Object operand, FilterOperatorType operator,
                       FactoryTable factoryTable) {

        Table resultTable = factoryTable.generateTable();
        int newLineCounter = 1;

        // For all lines in the table
        for (int lineIndex = 1; lineIndex <= inputTable.getNumLines(); lineIndex++) {

            // Maps <Column, Value> to this specific line that we are iterating
            Map<Column, Object> lineInfo = inputTable.getLineInfo(lineIndex);

            // If the filter condition is not applied to this line, it's ignore
            if (!itApplies(lineInfo.get(targetColumn), operand, operator)) {
                continue;
            }

            // Adds the data to the column
            for (Column column : lineInfo.keySet()) {
                Object value = lineInfo.get(column);
                resultTable.getColumnInfo().get(column).put(newLineCounter, value);
            }

            newLineCounter++;
        }

        return resultTable;
    }

    public static boolean itApplies(Object valueA, Object valueB, FilterOperatorType filterType) {
        if (valueA instanceof Number && valueB instanceof Number) {
            double numA = ((Number) valueA).doubleValue();
            double numB = ((Number) valueB).doubleValue();

            return switch (filterType) {
                case EQUALS -> numA == numB;
                case LESS_THAN -> numA < numB;
                case LESS_OR_EQUALS_THAN -> numA <= numB;
                case GREATER_THAN -> numA > numB;
                case GREATER_OR_EQUALS_THAN -> numA >= numB;
            };
        } else if (valueA instanceof String strA && valueB instanceof String strB) {

            return switch (filterType) {
                case EQUALS -> strA.equals(strB);
                case LESS_THAN -> strA.compareTo(strB) < 0;
                case LESS_OR_EQUALS_THAN -> strA.compareTo(strB) <= 0;
                case GREATER_THAN -> strA.compareTo(strB) > 0;
                case GREATER_OR_EQUALS_THAN -> strA.compareTo(strB) >= 0;
            };
        } else if (valueA instanceof LocalDate dateA && valueB instanceof LocalDate dateB) {

            return switch (filterType) {
                case EQUALS -> dateA.equals(dateB);
                case LESS_THAN -> dateA.isBefore(dateB);
                case LESS_OR_EQUALS_THAN -> dateA.isBefore(dateB) || dateA.equals(dateB);
                case GREATER_THAN -> dateA.isAfter(dateB);
                case GREATER_OR_EQUALS_THAN -> dateA.isAfter(dateB) || dateA.equals(dateB);
            };
        } else {

            throw new IllegalArgumentException("Unsupported data types for comparison: " + valueA.getClass() + " and " +
                    valueB.getClass());
        }
    }
}



