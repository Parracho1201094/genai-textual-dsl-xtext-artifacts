package main.java.org.enorm.domain.steps.joinStep;
			
import main.java.org.enorm.domain.tables.Column;
import main.java.org.enorm.domain.tables.Table;
import main.java.org.enorm.domain.tables.factories.FactoryTable;
import main.java.org.enorm.domain.enums.JoinType;

import java.util.List;

public interface IJoinStep {
	
    Table apply(Table leftTable, Table rightTable, Column leftColumn, Column rightColumn, JoinType type,
                FactoryTable resultTableFactory, List<Column> selectColumns);
}
