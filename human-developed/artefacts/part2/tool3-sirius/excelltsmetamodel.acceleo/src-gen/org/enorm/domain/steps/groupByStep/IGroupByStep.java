package org.enorm.domain.steps.groupByStep;

import org.enorm.domain.enums.GroupByOperationType;
import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;
import org.enorm.domain.tables.factories.FactoryTable;

import java.util.List;

public interface IGroupByStep {
    Table apply(Table inputTable, List<Column> groupBy, Column operandColumn, GroupByOperationType operation, FactoryTable factoryTable);
}

