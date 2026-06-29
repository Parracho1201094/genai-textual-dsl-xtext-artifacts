package org.enorm.domain.steps.importStep;

import org.enorm.domain.tables.Table;
import org.enorm.domain.tables.factories.FactoryTable;

public interface IImportStep {
    /**
     * Loads the data from a csv
     */
    Table apply(FactoryTable factoryTable, String path, String delimiter, boolean deleteMismatchedTypes);
}

