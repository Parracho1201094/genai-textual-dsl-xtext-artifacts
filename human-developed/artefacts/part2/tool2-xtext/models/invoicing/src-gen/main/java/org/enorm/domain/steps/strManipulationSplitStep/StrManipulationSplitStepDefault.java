package main.java.org.enorm.domain.steps.strManipulationSplitStep;

import main.java.org.enorm.Logger;			
import main.java.org.enorm.domain.tables.Column;
import main.java.org.enorm.domain.tables.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrManipulationSplitStepDefault implements IStrManipulationSplitStep {

    @Override
    public Table apply(Table inputTable, Column column, String delim, int atCharIndex, Column resultColumnA, Column resultColumnB, Table resultTable) {
        
        // Validate the parameters
        if ((delim == null && atCharIndex < 0) || (delim != null && atCharIndex >= 0)) {
            Logger.log(Logger.LogLevel.ERROR, "Error in StrManipulationSplitStepDefault: Either delim must " +
            		"be non-null or atCharIndex must be >= 0, but not both.");
            
			throw new IllegalArgumentException("Either delim must be non-null or atCharIndex must be >= 0, " +
					"but not both.");
        }

        // Create a new list of columns for the result table, including the result columns
        List<Column> resultColumns = new ArrayList<>(inputTable.getColumnList());
        resultColumns.add(resultColumnA);
        resultColumns.add(resultColumnB);

        // Initialize the result table's column info map
        Map<Column, Map<Integer, Object>> resultColumnInfo = new HashMap<>();
        
        for (Column col : resultColumns) {
            resultColumnInfo.put(col, new HashMap<>());
        }

        // Iterate over each row in the input table
        for (int i = 1; i <= inputTable.getNumLines(); i++) {
            
            // Copy existing column data to result table
            for (Column col : inputTable.getColumnList()) {
                resultColumnInfo.get(col).put(i, inputTable.getColumnInfo().get(col).get(i));
            }

            // Split the specified column's value and populate result columns
            String value = (String) inputTable.getColumnInfo().get(column).get(i);

            if (value == null) {
                resultColumnInfo.get(resultColumnA).put(i, null);
                resultColumnInfo.get(resultColumnB).put(i, null);
            } else {
                String partA;
                String partB;

                // Split the value based on the delimiter or the index
                if (delim != null) {
                    String[] parts = value.split(delim, 2);
                    partA = parts.length > 0 ? parts[0] : "";
                    partB = parts.length > 1 ? parts[1] : "";
                } else {
                    if (atCharIndex >= value.length()) {
                        partA = value;
                        partB = "";
                    } else {
                        partA = value.substring(0, atCharIndex);
                        partB = value.substring(atCharIndex);
                    }
                }

                // Populate the result columns
                resultColumnInfo.get(resultColumnA).put(i, partA);
                resultColumnInfo.get(resultColumnB).put(i, partB);
            }
        }

        // Construct the result table with the new column list and populated data
        resultTable = new Table(resultColumns, inputTable.getName());
        
        for (Map.Entry<Column, Map<Integer, Object>> entry : resultColumnInfo.entrySet()) {
            resultTable.getColumnInfo().put(entry.getKey(), entry.getValue());
        }
        
        Logger.log(Logger.LogLevel.INFO, "StrManipulationSplitStepDefault success.");

        return resultTable;
    }
}
