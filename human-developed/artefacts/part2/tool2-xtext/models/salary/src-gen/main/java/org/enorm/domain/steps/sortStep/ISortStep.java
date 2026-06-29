package main.java.org.enorm.domain.steps.sortStep;
			
import main.java.org.enorm.domain.enums.SortType;
import main.java.org.enorm.domain.tables.Column;
import main.java.org.enorm.domain.tables.Table;

public interface ISortStep {
	
    Table apply(Table inputTable, Column column, SortType sortType);
}
