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
		FactoryTable factoryClientsTable = new FactoryClientsTable();
		FactoryTable factoryProductsTable = new FactoryProductsTable();
		FactoryTable factorySalesTable = new FactorySalesTable();
		FactoryTable factorySalesGroupedByClientProductWithQuantityTable = new FactorySalesGroupedByClientProductWithQuantityTable();
		FactoryTable factorySalesWithPriceTable = new FactorySalesWithPriceTable();
		FactoryTable factorySalesWithTotalTable = new FactorySalesWithTotalTable();
		FactoryTable factoryGroupedByIdClientSumTotalTable = new FactoryGroupedByIdClientSumTotalTable();
		FactoryTable factoryFinalTable = new FactoryFinalTable();
		
		// Steps -------------------------------------------------------------------------------------------------------
		
		// Import
		Table clientsTable = FactoryImportStep.getStep().apply(
				factoryClientsTable, initialInputPath + "/clients.csv", ",", false);			
		Table productsTable = FactoryImportStep.getStep().apply(
				factoryProductsTable, initialInputPath + "/products.csv", ";", false);			
		Table salesTable = FactoryImportStep.getStep().apply(
				factorySalesTable, initialInputPath + "/sales.csv", ",", false);			
		
		// Remove Duplicates
		salesTable = FactoryRemoveDuplicatesStep.getStep().apply(
				salesTable,
				salesTable.getColumnByName("id_sale"),
				factorySalesTable);
		
		FactorySaveStep.getStep().apply(salesTable, "remove_duplicates_RemoveDuplicatesBySalesId");
		
		// Filter
		salesTable = FactoryFilterStep.getStep().apply(
				salesTable, 
				salesTable.getColumnByName("quantity"), 
				1, 
				FilterOperatorType.GREATER_THAN, factorySalesTable);
				
		FactorySaveStep.getStep().apply(salesTable, "filter_FilterQuantitiesHigherThan1");		
		
		// Group By
		List<Column> groupByColumnsGroupByClientAndSumQuantity = new ArrayList<>();
		groupByColumnsGroupByClientAndSumQuantity.add(salesTable.getColumnByName("id_client"));
		groupByColumnsGroupByClientAndSumQuantity.add(salesTable.getColumnByName("id_product"));
		Column operandColumnGroupByClientAndSumQuantity = salesTable.getColumnByName("quantity");
		GroupByOperationType operationGroupByClientAndSumQuantity = GroupByOperationType.SUM;
		
		Table salesGroupedByClientProductWithQuantityTable = FactoryGroupByStep.getStep().apply(
				salesTable,
				groupByColumnsGroupByClientAndSumQuantity, 
				operandColumnGroupByClientAndSumQuantity, 
				operationGroupByClientAndSumQuantity, 
				factorySalesGroupedByClientProductWithQuantityTable);
				
		FactorySaveStep.getStep().apply(salesGroupedByClientProductWithQuantityTable, "group_by_GroupByClientAndSumQuantity");		
		
		// Join
		List<Column> selectColumnsJoinGroupedWithPrice = new ArrayList<>();
		selectColumnsJoinGroupedWithPrice.add(productsTable.getColumnByName("id_product"));
		selectColumnsJoinGroupedWithPrice.add(productsTable.getColumnByName("price"));
		selectColumnsJoinGroupedWithPrice.add(salesGroupedByClientProductWithQuantityTable.getColumnByName("id_client"));
		selectColumnsJoinGroupedWithPrice.add(salesGroupedByClientProductWithQuantityTable.getColumnByName("quantity"));
		
		Table salesWithPriceTable = FactoryJoinStep.getStep().apply(
				productsTable, 
				salesGroupedByClientProductWithQuantityTable,
				productsTable.getColumnByName("id_product"),
				salesGroupedByClientProductWithQuantityTable.getColumnByName("id_product"),
				JoinType.INNER, 
				factorySalesWithPriceTable, 
				selectColumnsJoinGroupedWithPrice);
				
		FactorySaveStep.getStep().apply(salesWithPriceTable, "join_JoinGroupedWithPrice");	
		
		// Append Rows
		Table salesWithTotalTable = factorySalesWithTotalTable.generateTable();
		Map<Column, Column> mappingParseToTotalSchema = new HashMap<>();
		mappingParseToTotalSchema.put(salesWithPriceTable.getColumnByName("id_client"), 
				salesWithTotalTable.getColumnByName("id_client"));
		mappingParseToTotalSchema.put(salesWithPriceTable.getColumnByName("id_product"), 
				salesWithTotalTable.getColumnByName("id_product"));
		mappingParseToTotalSchema.put(salesWithPriceTable.getColumnByName("quantity"), 
				salesWithTotalTable.getColumnByName("quantity"));
		mappingParseToTotalSchema.put(salesWithPriceTable.getColumnByName("price"), 
				salesWithTotalTable.getColumnByName("price"));
		FactoryAppendRowsStep.getStep().apply(
				salesWithPriceTable, 
				salesWithTotalTable, 
				mappingParseToTotalSchema);
		
		FactorySaveStep.getStep().apply(salesWithTotalTable, "append_rows_ParseToTotalSchema");	
		
		// Lookup
		salesWithTotalTable = FactoryLookupStep.getStep().apply(
				salesWithTotalTable, 
				salesWithTotalTable.getColumnByName("id_client"),
				salesWithTotalTable, 
				salesWithTotalTable.getColumnByName("id_client"),
				salesWithTotalTable.getColumnByName("quantity"), 
				salesWithTotalTable.getColumnByName("price"),
				LookupOperationType.NUMERIC_MULTIPLY,
				"total", 
				factorySalesWithTotalTable);
				
		FactorySaveStep.getStep().apply(salesWithTotalTable, "lookup_GetTheTotal");
		
		// Group By
		List<Column> groupByColumnsGroupsTheSumQuantityToPay = new ArrayList<>();
		groupByColumnsGroupsTheSumQuantityToPay.add(salesWithTotalTable.getColumnByName("id_client"));
		Column operandColumnGroupsTheSumQuantityToPay = salesWithTotalTable.getColumnByName("total");
		GroupByOperationType operationGroupsTheSumQuantityToPay = GroupByOperationType.SUM;
		
		Table groupedByIdClientSumTotalTable = FactoryGroupByStep.getStep().apply(
				salesWithTotalTable,
				groupByColumnsGroupsTheSumQuantityToPay, 
				operandColumnGroupsTheSumQuantityToPay, 
				operationGroupsTheSumQuantityToPay, 
				factoryGroupedByIdClientSumTotalTable);
				
		FactorySaveStep.getStep().apply(groupedByIdClientSumTotalTable, "group_by_GroupsTheSumQuantityToPay");		
		
		// Join
		List<Column> selectColumnsJoinIntoClientToFinalize = new ArrayList<>();
		selectColumnsJoinIntoClientToFinalize.add(clientsTable.getColumnByName("id_client"));
		selectColumnsJoinIntoClientToFinalize.add(clientsTable.getColumnByName("name_client"));
		selectColumnsJoinIntoClientToFinalize.add(clientsTable.getColumnByName("nif"));
		selectColumnsJoinIntoClientToFinalize.add(groupedByIdClientSumTotalTable.getColumnByName("total"));
		
		Table finalTable = FactoryJoinStep.getStep().apply(
				groupedByIdClientSumTotalTable, 
				clientsTable,
				groupedByIdClientSumTotalTable.getColumnByName("id_client"),
				clientsTable.getColumnByName("id_client"),
				JoinType.INNER, 
				factoryFinalTable, 
				selectColumnsJoinIntoClientToFinalize);
				
		FactorySaveStep.getStep().apply(finalTable, "join_JoinIntoClientToFinalize");	
		
		// Save
		FactorySaveStep.getStep().apply(finalTable, "output-invoicing");
    }
}
