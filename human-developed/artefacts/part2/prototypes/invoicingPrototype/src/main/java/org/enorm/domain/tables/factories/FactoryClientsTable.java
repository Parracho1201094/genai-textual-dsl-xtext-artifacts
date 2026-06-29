package org.enorm.domain.tables.factories;

import org.enorm.domain.enums.DataType;
import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;

import java.util.ArrayList;
import java.util.List;

public class FactoryClientsTable implements FactoryTable {

    public Table generateTable() {
        List<Column> columnList = new ArrayList<>();
		
		columnList.add(new Column("id_client", DataType.NUMBER));
		columnList.add(new Column("name_client", DataType.TEXT));
		columnList.add(new Column("nif", DataType.TEXT));
		
        return new Table(columnList, "Clients");
    }		
}
