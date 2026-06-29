package main.java.org.enorm.domain.steps.lookupStep;
			
import main.java.org.enorm.domain.enums.LookupOperationType;
import main.java.org.enorm.domain.tables.Column;
import main.java.org.enorm.domain.tables.Table;
import main.java.org.enorm.domain.tables.factories.FactoryTable;

public interface ILookupStep {
	
    Table apply(Table inputTable, Column inputMatchColumn, Table lookupTable, Column lookupMatchColumn,
                Column inputOperandColumn, Column lookupOperandColumn, LookupOperationType lookupOperation,
                String resultTableName, FactoryTable factoryTable);
}
