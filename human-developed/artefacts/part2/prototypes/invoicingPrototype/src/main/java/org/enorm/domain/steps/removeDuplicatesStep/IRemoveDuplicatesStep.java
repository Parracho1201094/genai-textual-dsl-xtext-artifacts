package org.enorm.domain.steps.removeDuplicatesStep;

import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;
import org.enorm.domain.tables.factories.FactoryTable;

public interface IRemoveDuplicatesStep {
    Table apply(Table inputTable, Column targetColumn, FactoryTable factoryTable);
}
