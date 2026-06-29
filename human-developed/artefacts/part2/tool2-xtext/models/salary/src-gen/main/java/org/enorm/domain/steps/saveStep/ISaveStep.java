package main.java.org.enorm.domain.steps.saveStep;
			
import main.java.org.enorm.domain.tables.Table;

public interface ISaveStep {
	
    void apply(Table inputTable, String fileName);
}
