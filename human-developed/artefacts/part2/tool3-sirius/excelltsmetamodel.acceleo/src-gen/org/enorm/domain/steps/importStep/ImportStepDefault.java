package org.enorm.domain.steps.importStep;

import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;
import org.enorm.domain.tables.factories.FactoryTable;
import org.enorm.domain.utils.EnumUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ImportStepDefault implements IImportStep {

    @Override
    public Table apply(FactoryTable factoryTable, String path, String delimiter, boolean deleteMismatchedTypes) {
        Table resultTable = factoryTable.generateTable();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String headerLine = br.readLine();
            if (headerLine == null) {
                throw new IOException("CSV file is empty");
            }

            String[] headers = headerLine.split(delimiter);
            if (headers.length != resultTable.getColumnList().size()) {
                throw new IOException("CSV header does not match the table's column list");
            }

            String line;
            int rowIndex = 1;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                for (int i = 0; i < values.length; i++) {
                    Column column = resultTable.getColumnList().get(i);
                    try {
                        Object value = EnumUtils.parseValue(values[i], column.type());
                        resultTable.getColumnInfo().get(column).put(rowIndex, value);
                    } catch (Exception e) {
                    }
                }
                rowIndex++;
            }
            return resultTable;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

