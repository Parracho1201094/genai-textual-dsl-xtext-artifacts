package org.enorm.domain.steps.removeDuplicatesStep;

import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;
import org.enorm.domain.tables.factories.FactoryTable;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicatesStepDefault implements IRemoveDuplicatesStep {
    @Override
    public Table apply(Table inputTable, Column targetColumn, FactoryTable factoryTable) {

        Set<Object> valuesTrackingSet = new HashSet<>();
        Table resultTable = factoryTable.generateTable();
        int newLineCounter = 1;

        // For all lines in the table
        for (int lineIndex = 1; lineIndex <= inputTable.getNumLines(); lineIndex++) {

            // Maps <Column, Value> to this specific line that we are iterating
            Map<Column, Object> lineInfo = inputTable.getLineInfo(lineIndex);

            if (valuesTrackingSet.contains(lineInfo.get(targetColumn))) {
                continue;
            }

            // Adds the data to the column
            for (Column column : lineInfo.keySet()) {
                Object value = lineInfo.get(column);
                resultTable.getColumnInfo().get(column).put(newLineCounter, value);
            }

            valuesTrackingSet.add(lineInfo.get(targetColumn));
            newLineCounter++;
        }
        return resultTable;
    }
}

