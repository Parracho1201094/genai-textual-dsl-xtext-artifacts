package main.java.org.enorm.domain;

import main.java.org.enorm.domain.enums.FilterOperatorType;
import main.java.org.enorm.domain.enums.GroupByOperationType;
import main.java.org.enorm.domain.enums.LookupOperationType;
import main.java.org.enorm.domain.enums.JoinType;
import main.java.org.enorm.domain.enums.SortType;

import main.java.org.enorm.domain.steps.appendRowsStep.FactoryAppendRowsStep;
import main.java.org.enorm.domain.steps.filterStep.FactoryFilterStep;
import main.java.org.enorm.domain.steps.groupByStep.FactoryGroupByStep;
import main.java.org.enorm.domain.steps.importStep.FactoryImportStep;
import main.java.org.enorm.domain.steps.joinStep.FactoryJoinStep;
import main.java.org.enorm.domain.steps.lookupStep.FactoryLookupStep;
import main.java.org.enorm.domain.steps.removeDuplicatesStep.FactoryRemoveDuplicatesStep;
import main.java.org.enorm.domain.steps.saveStep.FactorySaveStep;
import main.java.org.enorm.domain.steps.sortStep.FactorySortStep;

import main.java.org.enorm.domain.tables.Column;
import main.java.org.enorm.domain.tables.Table;
import main.java.org.enorm.domain.tables.factories.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flow {

    public static String initialInputPath = "./src-gen/main/java/org/enorm/files/input/";
    public static String initialOutputPath = "./src-gen/main/java/org/enorm/files/output/";

    public static void execute() {
    	
		// Create factory tables ---------------------------------------------------------------------------------------
		FactoryTable factoryStudentsTable = new FactoryStudentsTable();
		FactoryTable factoryCoursesTable = new FactoryCoursesTable();
		FactoryTable factoryGradesTable = new FactoryGradesTable();
		FactoryTable factoryGradesAverageTable = new FactoryGradesAverageTable();
		FactoryTable factoryGradesAverageJoinCoursesTable = new FactoryGradesAverageJoinCoursesTable();
		FactoryTable factoryFinalTable = new FactoryFinalTable();
		FactoryTable factoryJoinFinalTableWithStudentTable = new FactoryJoinFinalTableWithStudentTable();
		
		// Steps -------------------------------------------------------------------------------------------------------
		
		// Import
		Table studentsTable = FactoryImportStep.getStep().apply(
				factoryStudentsTable, initialInputPath + "./students.csv", ",", false);			
		Table coursesTable = FactoryImportStep.getStep().apply(
				factoryCoursesTable, initialInputPath + "./courses.csv", ",", false);			
		Table gradesTable = FactoryImportStep.getStep().apply(
				factoryGradesTable, initialInputPath + "./grades.csv", ",", false);			
		
		// Remove Duplicates
		gradesTable = FactoryRemoveDuplicatesStep.getStep().apply(
				gradesTable,
				gradesTable.getColumnByName("id_grade"),
				factoryGradesTable);
		
		FactorySaveStep.getStep().apply(gradesTable, "remove_duplicates_RemoveDuplicatedGradeIds");
		
		// Group By
		List<Column> groupByColumnsGroupStudentsToGetAVGNotes = new ArrayList<>();
		groupByColumnsGroupStudentsToGetAVGNotes.add(gradesTable.getColumnByName("id_student"));
		groupByColumnsGroupStudentsToGetAVGNotes.add(gradesTable.getColumnByName("id_course"));
		Column operandColumnGroupStudentsToGetAVGNotes = gradesTable.getColumnByName("grade");
		GroupByOperationType operationGroupStudentsToGetAVGNotes = GroupByOperationType.AVERAGE;
		
		Table gradesAverageTable = FactoryGroupByStep.getStep().apply(
				gradesTable,
				groupByColumnsGroupStudentsToGetAVGNotes, 
				operandColumnGroupStudentsToGetAVGNotes, 
				operationGroupStudentsToGetAVGNotes, 
				factoryGradesAverageTable);
				
		FactorySaveStep.getStep().apply(gradesAverageTable, "group_by_GroupStudentsToGetAVGNotes");		
		
		// Join
		List<Column> selectColumnsJoinWithCoursesToGetName = new ArrayList<>();
		selectColumnsJoinWithCoursesToGetName.add(gradesAverageTable.getColumnByName("id_student"));
		selectColumnsJoinWithCoursesToGetName.add(gradesAverageTable.getColumnByName("id_course"));
		selectColumnsJoinWithCoursesToGetName.add(gradesAverageTable.getColumnByName("grade"));
		selectColumnsJoinWithCoursesToGetName.add(coursesTable.getColumnByName("name_course"));
		
		Table gradesAverageJoinCoursesTable = FactoryJoinStep.getStep().apply(
				gradesAverageTable, 
				coursesTable,
				gradesAverageTable.getColumnByName("id_course"),
				coursesTable.getColumnByName("id_course"),
				JoinType.INNER, 
				factoryGradesAverageJoinCoursesTable, 
				selectColumnsJoinWithCoursesToGetName);
				
		FactorySaveStep.getStep().apply(gradesAverageJoinCoursesTable, "join_JoinWithCoursesToGetName");	
		
		// Append Rows
		Table finalTable = factoryFinalTable.generateTable();
		Map<Column, Column> mappingCreateFinalTable = new HashMap<>();
		mappingCreateFinalTable.put(gradesAverageJoinCoursesTable.getColumnByName("id_student"), 
				finalTable.getColumnByName("id_student"));
		mappingCreateFinalTable.put(gradesAverageJoinCoursesTable.getColumnByName("id_course"), 
				finalTable.getColumnByName("id_course"));
		mappingCreateFinalTable.put(gradesAverageJoinCoursesTable.getColumnByName("grade"), 
				finalTable.getColumnByName("grade"));
		mappingCreateFinalTable.put(gradesAverageJoinCoursesTable.getColumnByName("name_course"), 
				finalTable.getColumnByName("name_course"));
		FactoryAppendRowsStep.getStep().apply(
				gradesAverageJoinCoursesTable, 
				finalTable, 
				mappingCreateFinalTable);
		
		FactorySaveStep.getStep().apply(finalTable, "append_rows_CreateFinalTable");	
		
		// Join
		List<Column> selectColumnsJoinFinalTableWithStudent = new ArrayList<>();
		selectColumnsJoinFinalTableWithStudent.add(finalTable.getColumnByName("id_student"));
		selectColumnsJoinFinalTableWithStudent.add(studentsTable.getColumnByName("first_name"));
		selectColumnsJoinFinalTableWithStudent.add(finalTable.getColumnByName("id_course"));
		selectColumnsJoinFinalTableWithStudent.add(finalTable.getColumnByName("grade"));
		selectColumnsJoinFinalTableWithStudent.add(finalTable.getColumnByName("name_course"));
		
		Table joinFinalTableWithStudentTable = FactoryJoinStep.getStep().apply(
				finalTable, 
				studentsTable,
				finalTable.getColumnByName("id_student"),
				studentsTable.getColumnByName("id_student"),
				JoinType.INNER, 
				factoryJoinFinalTableWithStudentTable, 
				selectColumnsJoinFinalTableWithStudent);
				
		FactorySaveStep.getStep().apply(joinFinalTableWithStudentTable, "join_JoinFinalTableWithStudent");	
		
		// Save
		FactorySaveStep.getStep().apply(joinFinalTableWithStudentTable, "output-grading");
    }
}
