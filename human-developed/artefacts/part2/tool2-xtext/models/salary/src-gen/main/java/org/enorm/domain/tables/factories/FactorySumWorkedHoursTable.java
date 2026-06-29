package main.java.org.enorm.domain.tables.factories;

import main.java.org.enorm.domain.enums.DataType;
import main.java.org.enorm.domain.tables.Column;
import main.java.org.enorm.domain.tables.Table;

import java.util.ArrayList;
import java.util.List;

public class FactorySumWorkedHoursTable implements FactoryTable {

    public Table generateTable() {
        List<Column> columnList = new ArrayList<>();
		
		columnList.add(new Column("id_employee", DataType.NUMBER));
		columnList.add(new Column("worked_hours", DataType.NUMBER));
		
        return new Table(columnList, "SumWorkedHours");
    }		
}
