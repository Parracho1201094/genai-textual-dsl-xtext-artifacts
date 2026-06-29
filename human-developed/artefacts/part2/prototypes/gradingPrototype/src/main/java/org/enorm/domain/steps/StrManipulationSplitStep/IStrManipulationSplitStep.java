package org.enorm.domain.steps.StrManipulationSplitStep;

import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;

public interface IStrManipulationSplitStep {
    Table apply(Table inputTable, Column column, String delim, int atCharIndex, Column resultColumnA,
                Column resultColumnB, Table resultTable);
}
