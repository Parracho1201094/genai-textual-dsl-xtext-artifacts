package org.enorm.domain;

import org.enorm.domain.enums.GroupByOperationType;
import org.enorm.domain.enums.LookupOperationType;
import org.enorm.domain.enums.JoinType;
import org.enorm.domain.enums.SortType;

import org.enorm.domain.steps.appendRowsStep.FactoryAppendRowsStep;
import org.enorm.domain.steps.groupByStep.FactoryGroupByStep;
import org.enorm.domain.steps.importStep.FactoryImportStep;
import org.enorm.domain.steps.joinStep.FactoryJoinStep;
import org.enorm.domain.steps.lookupStep.FactoryLookupStep;
import org.enorm.domain.steps.removeDuplicatesStep.FactoryRemoveDuplicatesStep;
import org.enorm.domain.steps.saveStep.FactorySaveStep;
import org.enorm.domain.steps.sortStep.FactorySortStep;

import org.enorm.domain.tables.Column;
import org.enorm.domain.tables.Table;
import org.enorm.domain.tables.factories.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flow {

    public static String initialInputPath = "./src/main/java/org/enorm/files/input/";
    public static String initialOutputPath = "./src/main/java/org/enorm/files/output/";

    public static void execute() {

        // Create factory tables ---------------------------------------------------------------------------------------
        FactoryTable factoryEmployeesTable = new FactoryEmployeesTable();
        FactoryTable factoryCategoriesTable = new FactoryCategoriesTable();
        FactoryTable factoryWorkedHoursTable = new FactoryWorkedHoursTable();
        FactoryTable factoryEmployeeJoinCategoryTable = new FactoryEmployeeJoinCategoryTable();
        FactoryTable factorySumWorkedHoursTable = new FactorySumWorkedHoursTable();
        FactoryTable factoryEmployeeJoinCategoryJoinSumWorkedHoursTable = new FactoryEmployeeJoinCategoryJoinSumWorkedHoursTable();
        FactoryTable factoryPaymentsTable = new FactoryPaymentsTable();
        FactoryTable factoryPaymentsFinalTable = new FactoryPaymentsFinalTable();

        // Steps -------------------------------------------------------------------------------------------------------

        // Import
        Table employeesTable = FactoryImportStep.getStep().apply(
                factoryEmployeesTable, initialInputPath + "/employees.csv", ",", false);
        Table categoriesTable = FactoryImportStep.getStep().apply(
                factoryCategoriesTable, initialInputPath + "/categories.csv", ",", false);
        Table workedHoursTable = FactoryImportStep.getStep().apply(
                factoryWorkedHoursTable, initialInputPath + "/workedhours.csv", ",", false);

        // Sort
        employeesTable = FactorySortStep.getStep().apply(
                employeesTable,
                employeesTable.getColumnByName("id_employee"),
                SortType.DESC);

        FactorySaveStep.getStep().apply(employeesTable, "sort_SortByEmployeeId");

        // Remove Duplicates
        employeesTable = FactoryRemoveDuplicatesStep.getStep().apply(
                employeesTable,
                employeesTable.getColumnByName("id_employee"),
                factoryEmployeesTable);

        FactorySaveStep.getStep().apply(employeesTable, "remove_duplicates_RemoveDuplicatedEmployeeIds");

        // Join
        List<Column> selectColumnsEmployeeWithCategory = new ArrayList<>();
        selectColumnsEmployeeWithCategory.add(employeesTable.getColumnByName("id_employee"));
        selectColumnsEmployeeWithCategory.add(employeesTable.getColumnByName("name_employee"));
        selectColumnsEmployeeWithCategory.add(categoriesTable.getColumnByName("id_category"));
        selectColumnsEmployeeWithCategory.add(categoriesTable.getColumnByName("name_category"));
        selectColumnsEmployeeWithCategory.add(categoriesTable.getColumnByName("value_worked_hours"));

        Table employeeJoinCategoryTable = FactoryJoinStep.getStep().apply(
                employeesTable,
                categoriesTable,
                employeesTable.getColumnByName("id_category"),
                categoriesTable.getColumnByName("id_category"),
                JoinType.INNER,
                factoryEmployeeJoinCategoryTable,
                selectColumnsEmployeeWithCategory);

        FactorySaveStep.getStep().apply(employeeJoinCategoryTable, "join_EmployeeWithCategory");

        // Group By
        List<Column> groupByColumnsEmployeeIdAndSumWorkedHours = new ArrayList<>();
        groupByColumnsEmployeeIdAndSumWorkedHours.add(workedHoursTable.getColumnByName("id_employee"));
        Column operandColumnEmployeeIdAndSumWorkedHours = workedHoursTable.getColumnByName("worked_hours");
        GroupByOperationType operationEmployeeIdAndSumWorkedHours = GroupByOperationType.SUM;

        Table sumWorkedHoursTable = FactoryGroupByStep.getStep().apply(
                workedHoursTable,
                groupByColumnsEmployeeIdAndSumWorkedHours,
                operandColumnEmployeeIdAndSumWorkedHours,
                operationEmployeeIdAndSumWorkedHours,
                factorySumWorkedHoursTable);

        FactorySaveStep.getStep().apply(sumWorkedHoursTable, "group_by_EmployeeIdAndSumWorkedHours");

        // Join
        List<Column> selectColumnsEmployeeJoinCategoryJoinSumWorkedHours = new ArrayList<>();
        selectColumnsEmployeeJoinCategoryJoinSumWorkedHours.add(employeeJoinCategoryTable.getColumnByName("id_employee"));
        selectColumnsEmployeeJoinCategoryJoinSumWorkedHours.add(employeeJoinCategoryTable.getColumnByName("id_category"));
        selectColumnsEmployeeJoinCategoryJoinSumWorkedHours.add(employeeJoinCategoryTable.getColumnByName("name_employee"));
        selectColumnsEmployeeJoinCategoryJoinSumWorkedHours.add(employeeJoinCategoryTable.getColumnByName("name_category"));
        selectColumnsEmployeeJoinCategoryJoinSumWorkedHours.add(employeeJoinCategoryTable.getColumnByName("value_worked_hours"));
        selectColumnsEmployeeJoinCategoryJoinSumWorkedHours.add(sumWorkedHoursTable.getColumnByName("worked_hours"));

        Table employeeJoinCategoryJoinSumWorkedHoursTable = FactoryJoinStep.getStep().apply(
                employeeJoinCategoryTable,
                sumWorkedHoursTable,
                employeeJoinCategoryTable.getColumnByName("id_employee"),
                sumWorkedHoursTable.getColumnByName("id_employee"),
                JoinType.INNER,
                factoryEmployeeJoinCategoryJoinSumWorkedHoursTable,
                selectColumnsEmployeeJoinCategoryJoinSumWorkedHours);

        FactorySaveStep.getStep().apply(employeeJoinCategoryJoinSumWorkedHoursTable, "join_EmployeeJoinCategoryJoinSumWorkedHours");

        // Append Rows
        Table paymentsTable = factoryPaymentsTable.generateTable();
        Map<Column, Column> mappingMoveToPaymentsTable = new HashMap<>();
        mappingMoveToPaymentsTable.put(employeeJoinCategoryJoinSumWorkedHoursTable.getColumnByName("id_employee"),
                paymentsTable.getColumnByName("id_employee"));
        mappingMoveToPaymentsTable.put(employeeJoinCategoryJoinSumWorkedHoursTable.getColumnByName("name_employee"),
                paymentsTable.getColumnByName("name_employee"));
        mappingMoveToPaymentsTable.put(employeeJoinCategoryJoinSumWorkedHoursTable.getColumnByName("id_category"),
                paymentsTable.getColumnByName("id_category"));
        mappingMoveToPaymentsTable.put(employeeJoinCategoryJoinSumWorkedHoursTable.getColumnByName("name_category"),
                paymentsTable.getColumnByName("name_category"));
        mappingMoveToPaymentsTable.put(employeeJoinCategoryJoinSumWorkedHoursTable.getColumnByName("value_worked_hours"),
                paymentsTable.getColumnByName("value_worked_hours"));
        mappingMoveToPaymentsTable.put(employeeJoinCategoryJoinSumWorkedHoursTable.getColumnByName("worked_hours"),
                paymentsTable.getColumnByName("total_worked_hours"));
        FactoryAppendRowsStep.getStep().apply(
                employeeJoinCategoryJoinSumWorkedHoursTable,
                paymentsTable,
                mappingMoveToPaymentsTable);

        FactorySaveStep.getStep().apply(paymentsTable, "append_rows_MoveToPaymentsTable");

        // Lookup
        paymentsTable = FactoryLookupStep.getStep().apply(
                paymentsTable,
                paymentsTable.getColumnByName("id_employee"),
                paymentsTable,
                paymentsTable.getColumnByName("id_employee"),
                paymentsTable.getColumnByName("value_worked_hours"),
                paymentsTable.getColumnByName("total_worked_hours"),
                LookupOperationType.NUMERIC_MULTIPLY,
                "payment",
                factoryPaymentsTable);

        FactorySaveStep.getStep().apply(paymentsTable, "lookup_TotalPayPerEmployee");

        // Append Rows
        Table paymentsFinalTable = factoryPaymentsFinalTable.generateTable();
        Map<Column, Column> mappingMoveToPaymentsFinal = new HashMap<>();
        mappingMoveToPaymentsFinal.put(paymentsTable.getColumnByName("id_employee"),
                paymentsFinalTable.getColumnByName("id_employee"));
        mappingMoveToPaymentsFinal.put(paymentsTable.getColumnByName("name_employee"),
                paymentsFinalTable.getColumnByName("name_employee"));
        mappingMoveToPaymentsFinal.put(paymentsTable.getColumnByName("id_category"),
                paymentsFinalTable.getColumnByName("id_category"));
        mappingMoveToPaymentsFinal.put(paymentsTable.getColumnByName("name_category"),
                paymentsFinalTable.getColumnByName("name_category"));
        mappingMoveToPaymentsFinal.put(paymentsTable.getColumnByName("payment"),
                paymentsFinalTable.getColumnByName("payment"));
        FactoryAppendRowsStep.getStep().apply(
                paymentsTable,
                paymentsFinalTable,
                mappingMoveToPaymentsFinal);

        FactorySaveStep.getStep().apply(paymentsFinalTable, "append_rows_MoveToPaymentsFinal");

        // Save
        FactorySaveStep.getStep().apply(paymentsFinalTable, "output-salary");
    }
}
