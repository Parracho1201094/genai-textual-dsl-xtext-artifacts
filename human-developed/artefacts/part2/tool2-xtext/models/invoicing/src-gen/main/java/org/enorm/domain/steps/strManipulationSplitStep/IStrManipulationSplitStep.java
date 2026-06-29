package main.java.org.enorm.domain.steps.strManipulationSplitStep;

import main.java.org.enorm.domain.tables.Column;
import main.java.org.enorm.domain.tables.Table;

public interface IStrManipulationSplitStep {
	
    Table apply(Table inputTable, Column column, String delim, int atCharIndex, Column resultColumnA, Column resultColumnB, Table resultTable);
}
