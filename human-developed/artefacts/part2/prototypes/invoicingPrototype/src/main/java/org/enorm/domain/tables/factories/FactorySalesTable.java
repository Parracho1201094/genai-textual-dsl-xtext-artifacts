package org.enorm.domain.tables.factories;

import org.enorm.domain.enums.DataType;
import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;

import java.util.ArrayList;
import java.util.List;

public class FactorySalesTable implements FactoryTable {

    public Table generateTable() {
        List<Column> columnList = new ArrayList<>();
		
		columnList.add(new Column("id_sale", DataType.NUMBER));
		columnList.add(new Column("id_client", DataType.NUMBER));
		columnList.add(new Column("id_product", DataType.NUMBER));
		columnList.add(new Column("quantity", DataType.NUMBER));
		
        return new Table(columnList, "Sales");
    }		
}
