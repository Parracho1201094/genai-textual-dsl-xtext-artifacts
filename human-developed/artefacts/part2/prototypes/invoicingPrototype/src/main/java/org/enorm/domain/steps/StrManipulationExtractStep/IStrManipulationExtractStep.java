package org.enorm.domain.steps.StrManipulationExtractStep;

import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;

public interface IStrManipulationExtractStep {
    void apply(Table inputTable, Column column, int lbCharIndex, int ubCharIndex, String regexPattern);
}
