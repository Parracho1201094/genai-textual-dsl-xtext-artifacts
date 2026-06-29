package org.enorm.domain.steps.sortStep;

import org.enorm.domain.enums.SortType;
import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;

public interface ISortStep {
    Table apply(Table inputTable, Column column, SortType sortType);
}

