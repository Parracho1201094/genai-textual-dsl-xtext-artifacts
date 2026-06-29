package main.java.org.enorm.domain.steps.strManipulationConcatStep;
			
import main.java.org.enorm.domain.tables.Column;
import main.java.org.enorm.domain.tables.Table;
import main.java.org.enorm.domain.tables.factories.FactoryTable;

public interface IStrManipulationConcatStep {
	
    Table apply(Table inputTable, Column columnA, Column columnB, String columnName, FactoryTable factoryTable);
}
