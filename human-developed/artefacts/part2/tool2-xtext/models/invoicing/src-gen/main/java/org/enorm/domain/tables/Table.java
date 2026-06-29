package main.java.org.enorm.domain.tables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Integer;

public class Table {

    private final List<Column> columnList;
    private final Map<Column, Map<Integer, Object>> columnInfo; // Column -> {Line, Value}
    private final String name;

    public Table(List<Column> columnList, String name) {
        this.columnList = columnList;
        this.name = name;
        this.columnInfo = new HashMap<>();
        for (Column column : columnList) {
            columnInfo.put(column, new HashMap<>());
        }
    }

    public String getName() {
        return name;
    }

    public List<Column> getColumnList() {
        return columnList;
    }

    public Column getColumnByName(String column) {
        return columnList.stream().filter(c -> c.name().equals(column)).findFirst().get();
    }

    public Map<Column, Map<Integer, Object>> getColumnInfo() {
        return columnInfo;
    }

    /**
     * Returns a map that associates the values of each column on the line received
     *
     * @param numLine The line of the table
     * @return Returns a map: {Column -> Value} for the specific line
     */
    public Map<Column, Object> getLineInfo(int numLine) {
        Map<Column, Object> columnInfoInThisLine = new HashMap<>();

        // Iterates over the input table's columns to fulfill the map columnInfoInThisLine with the data
        for (Column column : this.getColumnList()) {
            columnInfoInThisLine.put(column, this.getColumnInfo().get(column).get(numLine));
        }

        return columnInfoInThisLine;
    }

    public int getNumLines() {
        if (this.columnInfo.isEmpty()) {
            return 0;
        } else {
            Map<Integer, Object> firstColumnInfo = columnInfo.get(columnList.get(0));
            if (firstColumnInfo != null) {
                return firstColumnInfo.size();
            } else {
                return 0;
            }
        }
    }
}
