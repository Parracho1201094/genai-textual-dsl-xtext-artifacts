package org.enorm.domain.tables.factories;

import org.enorm.domain.enums.DataType;
import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;

import java.util.ArrayList;
import java.util.List;

public class FactoryPaymentsFinalTable implements FactoryTable {

    public Table generateTable() {
        List<Column> columnList = new ArrayList<>();
		
		columnList.add(new Column("id_employee", DataType.NUMBER));
		columnList.add(new Column("name_employee", DataType.TEXT));
		columnList.add(new Column("id_category", DataType.NUMBER));
		columnList.add(new Column("name_category", DataType.TEXT));
		columnList.add(new Column("payment", DataType.NUMBER));
		
        return new Table(columnList, "PaymentsFinal");
    }		
}
