package org.enorm.domain.steps.filterStep;

import org.enorm.domain.enums.FilterOperatorType;
import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;
import org.enorm.domain.tables.factories.FactoryTable;

public interface IFilterStep {
    Table apply(Table inputTable, Column targetColumn, Object operand, FilterOperatorType operator, FactoryTable factoryTable);
}

