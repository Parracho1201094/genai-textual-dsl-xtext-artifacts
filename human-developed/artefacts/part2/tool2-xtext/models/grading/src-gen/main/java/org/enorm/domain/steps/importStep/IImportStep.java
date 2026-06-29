package main.java.org.enorm.domain.steps.importStep;
			
import main.java.org.enorm.domain.tables.Table;
import main.java.org.enorm.domain.tables.factories.FactoryTable;

public interface IImportStep {
	
    /**
     * Loads the data from a csv
     *
     * @param deleteMismatchedTypes if it's to delete the lines that the type not matches with the declared in the columns
     */
    Table apply(FactoryTable factoryTable, String path, String delimiter, boolean deleteMismatchedTypes);
}
