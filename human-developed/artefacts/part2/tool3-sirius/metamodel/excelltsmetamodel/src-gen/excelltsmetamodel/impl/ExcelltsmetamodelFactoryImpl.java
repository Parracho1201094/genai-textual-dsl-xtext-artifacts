/**
 */
package excelltsmetamodel.impl;

import excelltsmetamodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExcelltsmetamodelFactoryImpl extends EFactoryImpl implements ExcelltsmetamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExcelltsmetamodelFactory init() {
		try {
			ExcelltsmetamodelFactory theExcelltsmetamodelFactory = (ExcelltsmetamodelFactory) EPackage.Registry.INSTANCE
					.getEFactory(ExcelltsmetamodelPackage.eNS_URI);
			if (theExcelltsmetamodelFactory != null) {
				return theExcelltsmetamodelFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExcelltsmetamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExcelltsmetamodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ExcelltsmetamodelPackage.MODEL:
			return createModel();
		case ExcelltsmetamodelPackage.SAVE:
			return createSave();
		case ExcelltsmetamodelPackage.TABLE:
			return createTable();
		case ExcelltsmetamodelPackage.GROUP:
			return createGroup();
		case ExcelltsmetamodelPackage.COLUMN:
			return createColumn();
		case ExcelltsmetamodelPackage.SORT:
			return createSort();
		case ExcelltsmetamodelPackage.APPEND_ROWS:
			return createAppendRows();
		case ExcelltsmetamodelPackage.TABLE_TO_SAVE:
			return createTableToSave();
		case ExcelltsmetamodelPackage.ASSOCIATION:
			return createAssociation();
		case ExcelltsmetamodelPackage.FILTER:
			return createFilter();
		case ExcelltsmetamodelPackage.GENERIC_STEP:
			return createGenericStep();
		case ExcelltsmetamodelPackage.JOIN:
			return createJoin();
		case ExcelltsmetamodelPackage.IMPORT:
			return createImport();
		case ExcelltsmetamodelPackage.TABLE_TO_IMPORT:
			return createTableToImport();
		case ExcelltsmetamodelPackage.LOOKUP:
			return createLookup();
		case ExcelltsmetamodelPackage.REMOVE_DUPLICATES:
			return createRemoveDuplicates();
		case ExcelltsmetamodelPackage.CONCAT:
			return createConcat();
		case ExcelltsmetamodelPackage.SPLIT:
			return createSplit();
		case ExcelltsmetamodelPackage.EXTRACT:
			return createExtract();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case ExcelltsmetamodelPackage.JOIN_TYPE:
			return createJoinTypeFromString(eDataType, initialValue);
		case ExcelltsmetamodelPackage.ORDER_TYPE:
			return createOrderTypeFromString(eDataType, initialValue);
		case ExcelltsmetamodelPackage.COLUMN_OPERATION_TYPE:
			return createColumnOperationTypeFromString(eDataType, initialValue);
		case ExcelltsmetamodelPackage.DATA_TYPE:
			return createDataTypeFromString(eDataType, initialValue);
		case ExcelltsmetamodelPackage.LOOKUP_OPERATION_TYPE:
			return createLookupOperationTypeFromString(eDataType, initialValue);
		case ExcelltsmetamodelPackage.FILTER_OPERATOR_TYPE:
			return createFilterOperatorTypeFromString(eDataType, initialValue);
		case ExcelltsmetamodelPackage.GROUP_OPERATION_TYPE:
			return createGroupOperationTypeFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case ExcelltsmetamodelPackage.JOIN_TYPE:
			return convertJoinTypeToString(eDataType, instanceValue);
		case ExcelltsmetamodelPackage.ORDER_TYPE:
			return convertOrderTypeToString(eDataType, instanceValue);
		case ExcelltsmetamodelPackage.COLUMN_OPERATION_TYPE:
			return convertColumnOperationTypeToString(eDataType, instanceValue);
		case ExcelltsmetamodelPackage.DATA_TYPE:
			return convertDataTypeToString(eDataType, instanceValue);
		case ExcelltsmetamodelPackage.LOOKUP_OPERATION_TYPE:
			return convertLookupOperationTypeToString(eDataType, instanceValue);
		case ExcelltsmetamodelPackage.FILTER_OPERATOR_TYPE:
			return convertFilterOperatorTypeToString(eDataType, instanceValue);
		case ExcelltsmetamodelPackage.GROUP_OPERATION_TYPE:
			return convertGroupOperationTypeToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Save createSave() {
		SaveImpl save = new SaveImpl();
		return save;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Table createTable() {
		TableImpl table = new TableImpl();
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Group createGroup() {
		GroupImpl group = new GroupImpl();
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Column createColumn() {
		ColumnImpl column = new ColumnImpl();
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Sort createSort() {
		SortImpl sort = new SortImpl();
		return sort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AppendRows createAppendRows() {
		AppendRowsImpl appendRows = new AppendRowsImpl();
		return appendRows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TableToSave createTableToSave() {
		TableToSaveImpl tableToSave = new TableToSaveImpl();
		return tableToSave;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Association createAssociation() {
		AssociationImpl association = new AssociationImpl();
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Filter createFilter() {
		FilterImpl filter = new FilterImpl();
		return filter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenericStep createGenericStep() {
		GenericStepImpl genericStep = new GenericStepImpl();
		return genericStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Join createJoin() {
		JoinImpl join = new JoinImpl();
		return join;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Import createImport() {
		ImportImpl import_ = new ImportImpl();
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TableToImport createTableToImport() {
		TableToImportImpl tableToImport = new TableToImportImpl();
		return tableToImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Lookup createLookup() {
		LookupImpl lookup = new LookupImpl();
		return lookup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RemoveDuplicates createRemoveDuplicates() {
		RemoveDuplicatesImpl removeDuplicates = new RemoveDuplicatesImpl();
		return removeDuplicates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Concat createConcat() {
		ConcatImpl concat = new ConcatImpl();
		return concat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Split createSplit() {
		SplitImpl split = new SplitImpl();
		return split;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Extract createExtract() {
		ExtractImpl extract = new ExtractImpl();
		return extract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoinType createJoinTypeFromString(EDataType eDataType, String initialValue) {
		JoinType result = JoinType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJoinTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderType createOrderTypeFromString(EDataType eDataType, String initialValue) {
		OrderType result = OrderType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOrderTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColumnOperationType createColumnOperationTypeFromString(EDataType eDataType, String initialValue) {
		ColumnOperationType result = ColumnOperationType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertColumnOperationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType createDataTypeFromString(EDataType eDataType, String initialValue) {
		DataType result = DataType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LookupOperationType createLookupOperationTypeFromString(EDataType eDataType, String initialValue) {
		LookupOperationType result = LookupOperationType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLookupOperationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterOperatorType createFilterOperatorTypeFromString(EDataType eDataType, String initialValue) {
		FilterOperatorType result = FilterOperatorType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFilterOperatorTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupOperationType createGroupOperationTypeFromString(EDataType eDataType, String initialValue) {
		GroupOperationType result = GroupOperationType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGroupOperationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExcelltsmetamodelPackage getExcelltsmetamodelPackage() {
		return (ExcelltsmetamodelPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExcelltsmetamodelPackage getPackage() {
		return ExcelltsmetamodelPackage.eINSTANCE;
	}

} //ExcelltsmetamodelFactoryImpl
