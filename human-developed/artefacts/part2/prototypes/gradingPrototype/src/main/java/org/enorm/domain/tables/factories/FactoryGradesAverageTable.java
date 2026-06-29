package org.enorm.domain.tables.factories;

import org.enorm.domain.enums.DataType;
import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;

import java.util.ArrayList;
import java.util.List;

public class FactoryGradesAverageTable implements FactoryTable {

    public Table generateTable() {
        List<Column> columnList = new ArrayList<>();
		
		columnList.add(new Column("id_student", DataType.NUMBER));
		columnList.add(new Column("id_course", DataType.NUMBER));
		columnList.add(new Column("grade", DataType.NUMBER));
		
        return new Table(columnList, "GradesAverage");
    }		
}
