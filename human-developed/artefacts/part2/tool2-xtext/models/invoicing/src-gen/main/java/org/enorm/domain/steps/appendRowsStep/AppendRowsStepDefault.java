package main.java.org.enorm.domain.steps.appendRowsStep;

import main.java.org.enorm.Logger;
import main.java.org.enorm.domain.tables.Column;
import main.java.org.enorm.domain.tables.Table;

import java.util.HashMap;
import java.util.Map;

public class AppendRowsStepDefault implements IAppendRowsStep {
	
    @Override
    public void apply(Table from, Table to, Map<Column, Column> columnsMapping) {
    	
        var appendAfterLine = to.getNumLines();

        for (var mapping : columnsMapping.entrySet()) {
            var sourceCells = from.getColumnInfo().get(mapping.getKey());
            var sourceLines = sourceCells.keySet().stream().toList();
            var sourceCellsTransformed = new HashMap<Integer, Object>();

            for (var sourceLine : sourceLines) {
                sourceCellsTransformed.put(appendAfterLine + sourceLine, sourceCells.get(sourceLine));
            }

            var destCells = to.getColumnInfo().get(mapping.getValue());
            destCells.putAll(sourceCellsTransformed);
        }
        
        Logger.log(Logger.LogLevel.INFO, "AppendRowsStepDefault success."); 
    }
}
