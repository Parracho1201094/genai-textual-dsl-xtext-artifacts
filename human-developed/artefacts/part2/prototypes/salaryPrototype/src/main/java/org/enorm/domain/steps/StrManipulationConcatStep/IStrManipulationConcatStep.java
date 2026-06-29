package org.enorm.domain.steps.StrManipulationConcatStep;

import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;
import org.enorm.domain.tables.factories.FactoryTable;

public interface IStrManipulationConcatStep {
    Table apply(Table inputTable, Column columnA, Column columnB, String columnName, FactoryTable factoryTable);
}
