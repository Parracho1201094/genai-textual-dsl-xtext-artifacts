package org.enorm.domain.steps.appendRowsStep;

import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;

import java.util.Map;

public interface IAppendRowsStep {
    void apply(Table from, Table to, Map<Column, Column> columnsMapping);
}

