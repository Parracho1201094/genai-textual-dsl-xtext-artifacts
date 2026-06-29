package main.java.org.enorm.domain.steps.groupByStep;
			
import main.java.org.enorm.domain.enums.GroupByOperationType;
import main.java.org.enorm.domain.tables.Column;
import main.java.org.enorm.domain.tables.Table;
import main.java.org.enorm.domain.tables.factories.FactoryTable;

import java.util.List;

public interface IGroupByStep {
	
    Table apply(Table inputTable, List<Column> groupBy, Column operandColumn, GroupByOperationType operation, FactoryTable factoryTable);
}
