package main.java.org.enorm.domain.steps.filterStep;
			
import main.java.org.enorm.domain.enums.FilterOperatorType;
import main.java.org.enorm.domain.tables.Column;
import main.java.org.enorm.domain.tables.Table;
import main.java.org.enorm.domain.tables.factories.FactoryTable;

public interface IFilterStep {
    
    Table apply(Table inputTable, Column targetColumn, Object operand, FilterOperatorType operator, FactoryTable factoryTable);
}
