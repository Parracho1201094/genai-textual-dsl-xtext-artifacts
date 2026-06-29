
package org.enorm.domain;

import org.enorm.domain.enums.*;
import org.enorm.domain.steps.appendRowsStep.*;
import org.enorm.domain.steps.filterStep.*;
import org.enorm.domain.steps.groupByStep.*;
import org.enorm.domain.steps.importStep.*;
import org.enorm.domain.steps.joinStep.*;
import org.enorm.domain.steps.lookupStep.*;
import org.enorm.domain.steps.removeDuplicatesStep.*;
import org.enorm.domain.steps.sortStep.*;
import org.enorm.domain.steps.saveStep.*;
import org.enorm.domain.tables.*;
import org.enorm.domain.tables.factories.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flow {

    public static String initialInputPath = "./src-gen/org/enorm/files/input/";
    public static String initialOutputPath = "./src-gen/org/enorm/files/output/";

    public static void execute() {
		
		// Create factory tables ---------------------------------------------------------------------------------------
		FactoryTable factoryEmployees = new FactoryEmployees();
		FactoryTable factoryWorkedHours = new FactoryWorkedHours();
		FactoryTable factoryCategories = new FactoryCategories();
		FactoryTable factoryPayments = new FactoryPayments();
		FactoryTable factoryEmployeeJoinCategory = new FactoryEmployeeJoinCategory();
		FactoryTable factorySumWorkedHours = new FactorySumWorkedHours();
		FactoryTable factoryEmployeeJoinCategoryJoinSumWorkedHours = new FactoryEmployeeJoinCategoryJoinSumWorkedHours();
		FactoryTable factoryPaymentsFinal = new FactoryPaymentsFinal();

        // Steps -------------------------------------------------------------------------------------------------------

		
		// Instantiation of auxiliary variables
        // Group By 
        List<Column> groupByColumns;
        Column operandColumn;
        GroupByOperationType operation;

        // Append rows
        Map<Column, Column> mapping;

        // Join
     	List<Column> selectColumns;

		// Import (Load all the tables needed for salary processing )
        Table Employees = FactoryImportStep.getStep().apply(factoryEmployees, initialInputPath + "/employees.csv", ",", false);
        Table Categories = FactoryImportStep.getStep().apply(factoryCategories, initialInputPath + "/categories.csv", ",", false);
        Table WorkedHours = FactoryImportStep.getStep().apply(factoryWorkedHours, initialInputPath + "/workedhours.csv", ",", false);



		// Remove duplicates (The goal is to clean duplicated entries)
        Employees = FactoryRemoveDuplicatesStep.getStep().apply(Employees, Employees.getColumnByName("id_employee"), factoryEmployees);


		// Join (Join the information of employee with category)
        selectColumns = new ArrayList<>();
		selectColumns.add(Employees.getColumnByName("id_category"));
		selectColumns.add(Employees.getColumnByName("id_employee"));
		selectColumns.add(Employees.getColumnByName("name_employee"));
		selectColumns.add(Categories.getColumnByName("value_worked_hours"));
		selectColumns.add(Categories.getColumnByName("name_category"));
        Table EmployeeJoinCategory = FactoryJoinStep.getStep().apply(Employees, Categories,
                Employees.getColumnByName("id_category"),
                Categories.getColumnByName("id_category"),
                JoinType.INNER, factoryEmployeeJoinCategory, selectColumns);


		// Group By (Obtains the total of hours per employee)
        groupByColumns = new ArrayList<>();
        groupByColumns.add(WorkedHours.getColumnByName("id_employee"));
        operandColumn = WorkedHours.getColumnByName("worked_hours");
        operation = GroupByOperationType.SUM;
        Table SumWorkedHours = FactoryGroupByStep.getStep().apply(WorkedHours,
                groupByColumns, operandColumn, operation, factorySumWorkedHours);


		// Join (The goal is to join in order to obtain the total hours and the value per hour      )
        selectColumns = new ArrayList<>();
		selectColumns.add(EmployeeJoinCategory.getColumnByName("id_employee"));
		selectColumns.add(EmployeeJoinCategory.getColumnByName("id_category"));
		selectColumns.add(EmployeeJoinCategory.getColumnByName("name_employee"));
		selectColumns.add(EmployeeJoinCategory.getColumnByName("name_category"));
		selectColumns.add(EmployeeJoinCategory.getColumnByName("value_worked_hours"));
		selectColumns.add(SumWorkedHours.getColumnByName("worked_hours"));
        Table EmployeeJoinCategoryJoinSumWorkedHours = FactoryJoinStep.getStep().apply(EmployeeJoinCategory, SumWorkedHours,
                EmployeeJoinCategory.getColumnByName("id_employee"),
                SumWorkedHours.getColumnByName("id_employee"),
                JoinType.INNER, factoryEmployeeJoinCategoryJoinSumWorkedHours, selectColumns);


		// Append Rows (It will move all the content of EmployeeCategory and Sum Hours to the payment)
        Table Payments = factoryPayments.generateTable();
        mapping = new HashMap<>();
        mapping.put(EmployeeJoinCategoryJoinSumWorkedHours.getColumnByName("id_employee"), EmployeeJoinCategoryJoinSumWorkedHours.getColumnByName("id_employee"));
        mapping.put(EmployeeJoinCategoryJoinSumWorkedHours.getColumnByName("name_employee"), EmployeeJoinCategoryJoinSumWorkedHours.getColumnByName("name_employee"));
        mapping.put(EmployeeJoinCategoryJoinSumWorkedHours.getColumnByName("id_category"), EmployeeJoinCategoryJoinSumWorkedHours.getColumnByName("id_category"));
        mapping.put(EmployeeJoinCategoryJoinSumWorkedHours.getColumnByName("name_employee"), EmployeeJoinCategoryJoinSumWorkedHours.getColumnByName("name_category"));
        mapping.put(EmployeeJoinCategoryJoinSumWorkedHours.getColumnByName("value_worked_hours"), EmployeeJoinCategoryJoinSumWorkedHours.getColumnByName("value_worked_hours"));
        mapping.put(EmployeeJoinCategoryJoinSumWorkedHours.getColumnByName("worked_hours"), EmployeeJoinCategoryJoinSumWorkedHours.getColumnByName("worked_hours"));
        FactoryAppendRowsStep.getStep().apply(EmployeeJoinCategoryJoinSumWorkedHours, Payments, mapping);


		// Lookup Rows (It will multiply the column value_worked_hours by worked_hours and store it on payment)
      	Payments = FactoryLookupStep.getStep().apply(Payments, Payments.getColumnByName("id_employee"),
                Payments, Payments.getColumnByName("id_employee"),
                Payments.getColumnByName("value_worked_hours"), Payments.getColumnByName("worked_hours"),
                LookupOperationType.NUMERIC_MULTIPLY,
                "payment", factoryPayments);


		// Append Rows (After the calculation, remove the columns that are not needed)
        Table PaymentsFinal = factoryPaymentsFinal.generateTable();
        mapping = new HashMap<>();
        mapping.put(Payments.getColumnByName("id_employee"), Payments.getColumnByName("id_employee"));
        mapping.put(Payments.getColumnByName("name_employee"), Payments.getColumnByName("name_employee"));
        mapping.put(Payments.getColumnByName("id_category"), Payments.getColumnByName("id_category"));
        mapping.put(Payments.getColumnByName("name_employee"), Payments.getColumnByName("name_category"));
        mapping.put(Payments.getColumnByName("payment"), Payments.getColumnByName("payment"));
        FactoryAppendRowsStep.getStep().apply(Payments, PaymentsFinal, mapping);



		// Save
		FactorySaveStep.getStep().apply(PaymentsFinal, "payment-final");

	
	}
}

