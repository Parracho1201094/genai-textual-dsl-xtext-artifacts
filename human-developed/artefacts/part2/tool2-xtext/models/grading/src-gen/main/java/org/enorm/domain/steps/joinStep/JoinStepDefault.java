package main.java.org.enorm.domain.steps.joinStep;

import main.java.org.enorm.Logger;			
import main.java.org.enorm.domain.tables.Column;
import main.java.org.enorm.domain.tables.Table;
import main.java.org.enorm.domain.tables.factories.FactoryTable;
import main.java.org.enorm.domain.enums.JoinType;

import java.util.List;

public class JoinStepDefault implements IJoinStep {

    @Override
    public Table apply(Table leftTable, Table rightTable, Column leftColumn, Column rightColumn, JoinType type,
                       FactoryTable resultTableFactory, List<Column> selectColumns) {

        var leftCells = leftTable.getColumnInfo().get(leftColumn);
        var rightCells = rightTable.getColumnInfo().get(rightColumn);
        var resultTable = resultTableFactory.generateTable();
        var lineCounter = 1;

        for (var leftCellLine : leftCells.keySet()) {
            var leftValue = leftCells.get(leftCellLine);

            for (var rightCellLine : rightCells.keySet()) {
                var rightValue = rightCells.get(rightCellLine);

                if (leftValue.equals(rightValue)) {
                    collectValues(leftTable, leftCellLine, rightTable, rightCellLine, resultTable, selectColumns, lineCounter);
                    lineCounter++;
                }
            }
        }
        
        Logger.log(Logger.LogLevel.INFO, "JoinStepDefault success.");
        
        return resultTable;
    }

    private void collectValues(Table leftTable, Integer leftCellLine, Table rightTable, Integer rightCellLine, Table resultTable,
                               List<Column> selectColumns, Integer resultLine) {

        for (var column : selectColumns) {
            Object value;
            
            if (leftTable.getColumnInfo().containsKey(column)) {
                value = leftTable.getColumnInfo().get(column).get(leftCellLine);
            } else {
                value = rightTable.getColumnInfo().get(column).get(rightCellLine);
            }
            
            resultTable.getColumnInfo().get(column).put(resultLine, value);
        }
    }
}
