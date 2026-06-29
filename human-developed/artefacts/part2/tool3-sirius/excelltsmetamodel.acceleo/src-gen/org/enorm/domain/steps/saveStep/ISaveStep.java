package org.enorm.domain.steps.saveStep;

import org.enorm.domain.tables.Table;

public interface ISaveStep {
    void apply(Table inputTable, String fileName);
}

