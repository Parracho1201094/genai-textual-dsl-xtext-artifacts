package main.java.org.enorm.domain.steps.strManipulationConcatStep;

import main.java.org.enorm.Logger;			
import main.java.org.enorm.domain.tables.Column;
import main.java.org.enorm.domain.tables.Table;
import main.java.org.enorm.domain.tables.factories.FactoryTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrManipulationConcatStepDefault implements IStrManipulationConcatStep {

    @Override
    public Table apply(Table inputTable, Column columnA, Column columnB, String columnName, FactoryTable factoryTable) {

        Table resultTable = factoryTable.generateTable();
        Column resultColumn = resultTable.getColumnByName(columnName);

        // Validate the parameters
        if (columnA == null || columnB == null || resultColumn == null) {
        	Logger.log(Logger.LogLevel.ERROR, "Error in StrManipulationConcatStepDefault: Columns must not " +
        			"be null.");
            throw new IllegalArgumentException("Columns must not be null.");
        }

        // Create a new list of columns for the result table, including the result column
        List<Column> resultColumns = new ArrayList<>(inputTable.getColumnList());
        resultColumns.add(resultColumn);

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

            // Get the values to concatenate
            String valueA = (String) inputTable.getColumnInfo().get(columnA).get(i);
            String valueB = (String) inputTable.getColumnInfo().get(columnB).get(i);

            // Concatenate the values
            String concatenatedValue;
            
            if (valueA == null && valueB == null) {
                concatenatedValue = null;
            } else if (valueA == null) {
                concatenatedValue = valueB;
            } else if (valueB == null) {
                concatenatedValue = valueA;
            } else {
                concatenatedValue = valueA + valueB;
            }

            // Populate the result column
            resultColumnInfo.get(resultColumn).put(i, concatenatedValue);
        }

        // Construct the result table with the new column list and populated data
        resultTable = new Table(resultColumns, inputTable.getName());
        
        for (Map.Entry<Column, Map<Integer, Object>> entry : resultColumnInfo.entrySet()) {
            resultTable.getColumnInfo().put(entry.getKey(), entry.getValue());
        }

 		Logger.log(Logger.LogLevel.INFO, "StrManipulationConcatStepDefault success.");
        
        return resultTable;
    }
}
