package org.enorm.domain.steps.lookupStep;

import org.enorm.domain.enums.LookupOperationType;
import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;
import org.enorm.domain.tables.factories.FactoryTable;

public interface ILookupStep {
    Table apply(Table inputTable, Column inputMatchColumn, Table lookupTable, Column lookupMatchColumn,
                Column inputOperandColumn, Column lookupOperandColumn, LookupOperationType lookupOperation,
                String resultTableName, FactoryTable factoryTable);
}
