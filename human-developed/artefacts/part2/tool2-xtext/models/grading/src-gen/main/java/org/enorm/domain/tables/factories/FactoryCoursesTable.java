package main.java.org.enorm.domain.tables.factories;

import main.java.org.enorm.domain.enums.DataType;
import main.java.org.enorm.domain.tables.Column;
import main.java.org.enorm.domain.tables.Table;

import java.util.ArrayList;
import java.util.List;

public class FactoryCoursesTable implements FactoryTable {

    public Table generateTable() {
        List<Column> columnList = new ArrayList<>();
		
		columnList.add(new Column("id_course", DataType.NUMBER));
		columnList.add(new Column("name_course", DataType.TEXT));
		columnList.add(new Column("id_student", DataType.NUMBER));
		
        return new Table(columnList, "Courses");
    }		
}
