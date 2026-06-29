package main.java.org.enorm.domain.tables.factories;

import main.java.org.enorm.domain.enums.DataType;
import main.java.org.enorm.domain.tables.Column;
import main.java.org.enorm.domain.tables.Table;

import java.util.ArrayList;
import java.util.List;

public class FactoryPaymentsTable implements FactoryTable {

    public Table generateTable() {
        List<Column> columnList = new ArrayList<>();
		
		columnList.add(new Column("id_employee", DataType.NUMBER));
		columnList.add(new Column("name_employee", DataType.TEXT));
		columnList.add(new Column("id_category", DataType.NUMBER));
		columnList.add(new Column("name_category", DataType.TEXT));
		columnList.add(new Column("value_worked_hours", DataType.NUMBER));
		columnList.add(new Column("total_worked_hours", DataType.NUMBER));
		columnList.add(new Column("payment", DataType.NUMBER));
		
        return new Table(columnList, "Payments");
    }		
}
