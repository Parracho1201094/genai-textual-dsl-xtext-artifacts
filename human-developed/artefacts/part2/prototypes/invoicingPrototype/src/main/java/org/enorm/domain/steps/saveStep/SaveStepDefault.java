package org.enorm.domain.steps.saveStep;

import org.enorm.Logger;
import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;

import java.io.FileWriter;
import java.io.IOException;

import static org.enorm.domain.Flow.initialOutputPath;

public class SaveStepDefault implements ISaveStep {

    @Override
    public void apply(Table inputTable, String fileName) {

        try (FileWriter writer = new FileWriter(initialOutputPath + fileName + ".csv")) {

            // Write the header
            for (int i = 0; i < inputTable.getColumnList().size(); i++) {
                writer.append(inputTable.getColumnList().get(i).name());

                if (i < inputTable.getColumnList().size() - 1) {
                    writer.append(',');
                }
            }

            writer.append('\n');

            // Write the data rows
            for (int lineIndex = 1; lineIndex <= inputTable.getNumLines(); lineIndex++) {
                boolean rowIsEmpty = true;

                for (int colIndex = 0; colIndex < inputTable.getColumnList().size(); colIndex++) {
                    Column column = inputTable.getColumnList().get(colIndex);
                    Object value = inputTable.getColumnInfo().get(column).get(lineIndex);

                    if (value != null) {
                        rowIsEmpty = false;
                    }

                    writer.append(value != null ? value.toString() : "");

                    if (colIndex < inputTable.getColumnList().size() - 1) {
                        writer.append(',');
                    }
                }

                if (!rowIsEmpty) {
                    writer.append('\n');
                }
            }

            Logger.log(Logger.LogLevel.INFO, "SaveStepDefault success.");

        } catch (IOException e) {
            Logger.log(Logger.LogLevel.ERROR, "Error in SaveStepDefault: " + e);
        }
    }
}
