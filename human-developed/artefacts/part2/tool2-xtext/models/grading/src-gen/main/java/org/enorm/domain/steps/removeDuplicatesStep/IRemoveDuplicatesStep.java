package main.java.org.enorm.domain.steps.removeDuplicatesStep;
			
import main.java.org.enorm.domain.tables.Column;
import main.java.org.enorm.domain.tables.Table;
import main.java.org.enorm.domain.tables.factories.FactoryTable;

public interface IRemoveDuplicatesStep {
	
    Table apply(Table inputTable, Column targetColumn, FactoryTable factoryTable);
}
