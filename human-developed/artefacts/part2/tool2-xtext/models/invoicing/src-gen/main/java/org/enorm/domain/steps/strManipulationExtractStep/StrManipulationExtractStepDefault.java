package main.java.org.enorm.domain.steps.strManipulationExtractStep;

import main.java.org.enorm.Logger;			
import  main.java.org.enorm.domain.tables.Column;
import  main.java.org.enorm.domain.tables.Table;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrManipulationExtractStepDefault implements IStrManipulationExtractStep {

    @Override
    public void apply(Table inputTable, Column column, int lbCharIndex, int ubCharIndex, String regexPattern) {
    	
        var cellsToModify = inputTable.getColumnInfo().get(column);

        for (var cell : cellsToModify.keySet()) {
            var value = (String) cellsToModify.get(cell);

            if (regexPattern != null) {
                Pattern pattern = Pattern.compile(regexPattern);
                Matcher matcher = pattern.matcher(value);

                if (matcher.find()) {
                    cellsToModify.put(cell, matcher.group(0));
                } else {
                    cellsToModify.put(cell, "");
                }
            } else {
                cellsToModify.put(cell, value.substring(lbCharIndex, Math.min(ubCharIndex, value.length() - 1)));
            }
        }
        
        Logger.log(Logger.LogLevel.INFO, "StrManipulationExtractStepDefault success.");			        
    }
}
