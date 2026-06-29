package org.enorm.domain.steps.joinStep;

import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;
import org.enorm.domain.tables.factories.FactoryTable;
import org.enorm.domain.enums.JoinType;

import java.util.List;

public interface IJoinStep {
    Table apply(Table leftTable, Table rightTable, Column leftColumn, Column rightColumn, JoinType type,
                FactoryTable resultTableFactory, List<Column> selectColumns);
}

