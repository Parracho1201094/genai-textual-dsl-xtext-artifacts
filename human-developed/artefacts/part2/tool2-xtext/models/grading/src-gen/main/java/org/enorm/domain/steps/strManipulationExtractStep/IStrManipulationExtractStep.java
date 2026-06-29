package main.java.org.enorm.domain.steps.strManipulationExtractStep;
			
import main.java.org.enorm.domain.tables.Column;
import main.java.org.enorm.domain.tables.Table;

public interface IStrManipulationExtractStep {
	
    void apply(Table inputTable, Column column, int lbCharIndex, int ubCharIndex, String regexPattern);
}
