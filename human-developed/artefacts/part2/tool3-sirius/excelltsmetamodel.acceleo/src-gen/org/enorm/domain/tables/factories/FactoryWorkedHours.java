package org.enorm.domain.tables.factories;

import org.enorm.domain.enums.*;
import org.enorm.domain.tables.*;

import java.util.ArrayList;
import java.util.List;

public class FactoryWorkedHours implements FactoryTable {

    public Table generateTable() {
        List<Column> columnList = new ArrayList<>();

        columnList.add(new Column("id_employee", DataType.NUMBER));
        columnList.add(new Column("date", DataType.DATE));
        columnList.add(new Column("worked_hours", DataType.NUMBER));

        return new Table(columnList, "WorkedHours");
    }

}

