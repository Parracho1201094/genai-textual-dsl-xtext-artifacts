package main.java.org.enorm.domain.steps.appendRowsStep;
			
import main.java.org.enorm.domain.tables.Column;
import main.java.org.enorm.domain.tables.Table;

import java.util.Map;

public interface IAppendRowsStep {
	
    void apply(Table from, Table to, Map<Column, Column> columnsMapping);
}
