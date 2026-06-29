/**
 */
package excelltsmetamodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see excelltsmetamodel.ExcelltsmetamodelFactory
 * @model kind="package"
 * @generated
 */
public interface ExcelltsmetamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "excelltsmetamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/excelltsmetamodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "excelltsmetamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExcelltsmetamodelPackage eINSTANCE = excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.ModelImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Logs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__LOGS = 1;

	/**
	 * The feature id for the '<em><b>Tables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__TABLES = 2;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__STEPS = 3;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.StepImpl <em>Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.StepImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getStep()
	 * @generated
	 */
	int STEP = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__DESCRIPTION = 1;

	/**
	 * The number of structural features of the '<em>Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.FlowStepImpl <em>Flow Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.FlowStepImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getFlowStep()
	 * @generated
	 */
	int FLOW_STEP = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_STEP__NAME = STEP__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_STEP__DESCRIPTION = STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_STEP__NEXT = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Flow Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Flow Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_STEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.FinalStepImpl <em>Final Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.FinalStepImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getFinalStep()
	 * @generated
	 */
	int FINAL_STEP = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STEP__NAME = STEP__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STEP__DESCRIPTION = STEP__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Final Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Final Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.SaveImpl <em>Save</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.SaveImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getSave()
	 * @generated
	 */
	int SAVE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE__NAME = FINAL_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE__DESCRIPTION = FINAL_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tables To Save</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE__TABLES_TO_SAVE = FINAL_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Save</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE_FEATURE_COUNT = FINAL_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Save</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE_OPERATION_COUNT = FINAL_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.TableImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__COLUMNS = 1;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.GroupImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__NAME = FLOW_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__DESCRIPTION = FLOW_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__NEXT = FLOW_STEP__NEXT;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__TABLE = FLOW_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Group By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__GROUP_BY = FLOW_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Result Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__RESULT_TABLE = FLOW_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operand Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__OPERAND_COLUMN = FLOW_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__OPERATION = FLOW_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Result Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__RESULT_COLUMN = FLOW_STEP_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = FLOW_STEP_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_OPERATION_COUNT = FLOW_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.ColumnImpl <em>Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.ColumnImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getColumn()
	 * @generated
	 */
	int COLUMN = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__NAME = 0;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__DATA_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.SortImpl <em>Sort</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.SortImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getSort()
	 * @generated
	 */
	int SORT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT__NAME = FLOW_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT__DESCRIPTION = FLOW_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT__NEXT = FLOW_STEP__NEXT;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT__TABLE = FLOW_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT__COLUMN = FLOW_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT__ORDER = FLOW_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Sort</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT_FEATURE_COUNT = FLOW_STEP_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Sort</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT_OPERATION_COUNT = FLOW_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.AppendRowsImpl <em>Append Rows</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.AppendRowsImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getAppendRows()
	 * @generated
	 */
	int APPEND_ROWS = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_ROWS__NAME = FLOW_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_ROWS__DESCRIPTION = FLOW_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_ROWS__NEXT = FLOW_STEP__NEXT;

	/**
	 * The feature id for the '<em><b>Origin Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_ROWS__ORIGIN_TABLE = FLOW_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Destin Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_ROWS__DESTIN_TABLE = FLOW_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Associations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_ROWS__ASSOCIATIONS = FLOW_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Append Rows</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_ROWS_FEATURE_COUNT = FLOW_STEP_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Append Rows</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_ROWS_OPERATION_COUNT = FLOW_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.TableToSaveImpl <em>Table To Save</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.TableToSaveImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getTableToSave()
	 * @generated
	 */
	int TABLE_TO_SAVE = 10;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_TO_SAVE__TABLE = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_TO_SAVE__PATH = 1;

	/**
	 * The feature id for the '<em><b>Columns Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_TO_SAVE__COLUMNS_NAMES = 2;

	/**
	 * The number of structural features of the '<em>Table To Save</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_TO_SAVE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Table To Save</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_TO_SAVE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.AssociationImpl <em>Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.AssociationImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getAssociation()
	 * @generated
	 */
	int ASSOCIATION = 11;

	/**
	 * The feature id for the '<em><b>Origin Col</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__ORIGIN_COL = 0;

	/**
	 * The feature id for the '<em><b>Destin Col</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__DESTIN_COL = 1;

	/**
	 * The number of structural features of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.FilterImpl <em>Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.FilterImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getFilter()
	 * @generated
	 */
	int FILTER = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER__NAME = FLOW_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER__DESCRIPTION = FLOW_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER__NEXT = FLOW_STEP__NEXT;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER__TABLE = FLOW_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER__COLUMN = FLOW_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER__OPERAND = FLOW_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER__OPERATOR = FLOW_STEP_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_FEATURE_COUNT = FLOW_STEP_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_OPERATION_COUNT = FLOW_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.GenericStepImpl <em>Generic Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.GenericStepImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getGenericStep()
	 * @generated
	 */
	int GENERIC_STEP = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_STEP__NAME = FLOW_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_STEP__DESCRIPTION = FLOW_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_STEP__NEXT = FLOW_STEP__NEXT;

	/**
	 * The number of structural features of the '<em>Generic Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_STEP_FEATURE_COUNT = FLOW_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Generic Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_STEP_OPERATION_COUNT = FLOW_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.JoinImpl <em>Join</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.JoinImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getJoin()
	 * @generated
	 */
	int JOIN = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__NAME = FLOW_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__DESCRIPTION = FLOW_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__NEXT = FLOW_STEP__NEXT;

	/**
	 * The feature id for the '<em><b>Table Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__TABLE_LEFT = FLOW_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Table Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__TABLE_RIGHT = FLOW_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Column Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__COLUMN_LEFT = FLOW_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Column Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__COLUMN_RIGHT = FLOW_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__TYPE = FLOW_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Result Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__RESULT_TABLE = FLOW_STEP_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Select Columns</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__SELECT_COLUMNS = FLOW_STEP_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Join</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_FEATURE_COUNT = FLOW_STEP_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Join</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_OPERATION_COUNT = FLOW_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.ImportImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__NAME = FLOW_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__DESCRIPTION = FLOW_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__NEXT = FLOW_STEP__NEXT;

	/**
	 * The feature id for the '<em><b>Tables To Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__TABLES_TO_IMPORT = FLOW_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = FLOW_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_OPERATION_COUNT = FLOW_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.TableToImportImpl <em>Table To Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.TableToImportImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getTableToImport()
	 * @generated
	 */
	int TABLE_TO_IMPORT = 16;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_TO_IMPORT__TABLE = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_TO_IMPORT__PATH = 1;

	/**
	 * The feature id for the '<em><b>Delimiter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_TO_IMPORT__DELIMITER = 2;

	/**
	 * The feature id for the '<em><b>Delete Mismatched Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_TO_IMPORT__DELETE_MISMATCHED_TYPES = 3;

	/**
	 * The number of structural features of the '<em>Table To Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_TO_IMPORT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Table To Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_TO_IMPORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.LookupImpl <em>Lookup</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.LookupImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getLookup()
	 * @generated
	 */
	int LOOKUP = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP__NAME = FLOW_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP__DESCRIPTION = FLOW_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP__NEXT = FLOW_STEP__NEXT;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP__TABLE = FLOW_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lookup Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP__LOOKUP_TABLE = FLOW_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP__COLUMN = FLOW_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operand Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP__OPERAND_COLUMN = FLOW_STEP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Match Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP__MATCH_COLUMN = FLOW_STEP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Lookup Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP__LOOKUP_COLUMN = FLOW_STEP_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Result Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP__RESULT_COLUMN = FLOW_STEP_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP__OPERATION = FLOW_STEP_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Result Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP__RESULT_TABLE = FLOW_STEP_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Lookup</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_FEATURE_COUNT = FLOW_STEP_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Lookup</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_OPERATION_COUNT = FLOW_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.RemoveDuplicatesImpl <em>Remove Duplicates</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.RemoveDuplicatesImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getRemoveDuplicates()
	 * @generated
	 */
	int REMOVE_DUPLICATES = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_DUPLICATES__NAME = FLOW_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_DUPLICATES__DESCRIPTION = FLOW_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_DUPLICATES__NEXT = FLOW_STEP__NEXT;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_DUPLICATES__TABLE = FLOW_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_DUPLICATES__COLUMN = FLOW_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Remove Duplicates</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_DUPLICATES_FEATURE_COUNT = FLOW_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Remove Duplicates</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_DUPLICATES_OPERATION_COUNT = FLOW_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.StringManipulationImpl <em>String Manipulation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.StringManipulationImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getStringManipulation()
	 * @generated
	 */
	int STRING_MANIPULATION = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MANIPULATION__NAME = FLOW_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MANIPULATION__DESCRIPTION = FLOW_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MANIPULATION__NEXT = FLOW_STEP__NEXT;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MANIPULATION__TABLE = FLOW_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Manipulation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MANIPULATION_FEATURE_COUNT = FLOW_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Manipulation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MANIPULATION_OPERATION_COUNT = FLOW_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.ConcatImpl <em>Concat</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.ConcatImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getConcat()
	 * @generated
	 */
	int CONCAT = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT__NAME = STRING_MANIPULATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT__DESCRIPTION = STRING_MANIPULATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT__NEXT = STRING_MANIPULATION__NEXT;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT__TABLE = STRING_MANIPULATION__TABLE;

	/**
	 * The feature id for the '<em><b>Source A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT__SOURCE_A = STRING_MANIPULATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT__SOURCE_B = STRING_MANIPULATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Result Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT__RESULT_COLUMN = STRING_MANIPULATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Result Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT__RESULT_TABLE = STRING_MANIPULATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Concat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT_FEATURE_COUNT = STRING_MANIPULATION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Concat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT_OPERATION_COUNT = STRING_MANIPULATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.SplitImpl <em>Split</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.SplitImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getSplit()
	 * @generated
	 */
	int SPLIT = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__NAME = STRING_MANIPULATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__DESCRIPTION = STRING_MANIPULATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__NEXT = STRING_MANIPULATION__NEXT;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__TABLE = STRING_MANIPULATION__TABLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__SOURCE = STRING_MANIPULATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Result Column B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__RESULT_COLUMN_B = STRING_MANIPULATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Result Column A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__RESULT_COLUMN_A = STRING_MANIPULATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Delimiter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__DELIMITER = STRING_MANIPULATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Num Of Chars</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__NUM_OF_CHARS = STRING_MANIPULATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Result Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__RESULT_TABLE = STRING_MANIPULATION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Split</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT_FEATURE_COUNT = STRING_MANIPULATION_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Split</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT_OPERATION_COUNT = STRING_MANIPULATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.impl.ExtractImpl <em>Extract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.impl.ExtractImpl
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getExtract()
	 * @generated
	 */
	int EXTRACT = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT__NAME = STRING_MANIPULATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT__DESCRIPTION = STRING_MANIPULATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT__NEXT = STRING_MANIPULATION__NEXT;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT__TABLE = STRING_MANIPULATION__TABLE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT__COLUMN = STRING_MANIPULATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lb Char</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT__LB_CHAR = STRING_MANIPULATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ub Char</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT__UB_CHAR = STRING_MANIPULATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT__PATTERN = STRING_MANIPULATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Extract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT_FEATURE_COUNT = STRING_MANIPULATION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Extract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT_OPERATION_COUNT = STRING_MANIPULATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.JoinType <em>Join Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.JoinType
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getJoinType()
	 * @generated
	 */
	int JOIN_TYPE = 23;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.OrderType <em>Order Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.OrderType
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getOrderType()
	 * @generated
	 */
	int ORDER_TYPE = 24;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.ColumnOperationType <em>Column Operation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.ColumnOperationType
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getColumnOperationType()
	 * @generated
	 */
	int COLUMN_OPERATION_TYPE = 25;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.DataType <em>Data Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.DataType
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 26;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.LookupOperationType <em>Lookup Operation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.LookupOperationType
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getLookupOperationType()
	 * @generated
	 */
	int LOOKUP_OPERATION_TYPE = 27;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.FilterOperatorType <em>Filter Operator Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.FilterOperatorType
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getFilterOperatorType()
	 * @generated
	 */
	int FILTER_OPERATOR_TYPE = 28;

	/**
	 * The meta object id for the '{@link excelltsmetamodel.GroupOperationType <em>Group Operation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see excelltsmetamodel.GroupOperationType
	 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getGroupOperationType()
	 * @generated
	 */
	int GROUP_OPERATION_TYPE = 29;

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see excelltsmetamodel.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.Model#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see excelltsmetamodel.Model#getName()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.Model#isLogs <em>Logs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Logs</em>'.
	 * @see excelltsmetamodel.Model#isLogs()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Logs();

	/**
	 * Returns the meta object for the containment reference list '{@link excelltsmetamodel.Model#getTables <em>Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tables</em>'.
	 * @see excelltsmetamodel.Model#getTables()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Tables();

	/**
	 * Returns the meta object for the containment reference list '{@link excelltsmetamodel.Model#getSteps <em>Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Steps</em>'.
	 * @see excelltsmetamodel.Model#getSteps()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Steps();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.Step <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step</em>'.
	 * @see excelltsmetamodel.Step
	 * @generated
	 */
	EClass getStep();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.Step#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see excelltsmetamodel.Step#getName()
	 * @see #getStep()
	 * @generated
	 */
	EAttribute getStep_Name();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.Step#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see excelltsmetamodel.Step#getDescription()
	 * @see #getStep()
	 * @generated
	 */
	EAttribute getStep_Description();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.FlowStep <em>Flow Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Step</em>'.
	 * @see excelltsmetamodel.FlowStep
	 * @generated
	 */
	EClass getFlowStep();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.FlowStep#getNext <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next</em>'.
	 * @see excelltsmetamodel.FlowStep#getNext()
	 * @see #getFlowStep()
	 * @generated
	 */
	EReference getFlowStep_Next();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.FinalStep <em>Final Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Final Step</em>'.
	 * @see excelltsmetamodel.FinalStep
	 * @generated
	 */
	EClass getFinalStep();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.Save <em>Save</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Save</em>'.
	 * @see excelltsmetamodel.Save
	 * @generated
	 */
	EClass getSave();

	/**
	 * Returns the meta object for the containment reference list '{@link excelltsmetamodel.Save#getTablesToSave <em>Tables To Save</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tables To Save</em>'.
	 * @see excelltsmetamodel.Save#getTablesToSave()
	 * @see #getSave()
	 * @generated
	 */
	EReference getSave_TablesToSave();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see excelltsmetamodel.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.Table#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see excelltsmetamodel.Table#getName()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link excelltsmetamodel.Table#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns</em>'.
	 * @see excelltsmetamodel.Table#getColumns()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Columns();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see excelltsmetamodel.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Group#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see excelltsmetamodel.Group#getTable()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Table();

	/**
	 * Returns the meta object for the reference list '{@link excelltsmetamodel.Group#getGroupBy <em>Group By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Group By</em>'.
	 * @see excelltsmetamodel.Group#getGroupBy()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_GroupBy();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Group#getResultTable <em>Result Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Table</em>'.
	 * @see excelltsmetamodel.Group#getResultTable()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_ResultTable();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Group#getOperandColumn <em>Operand Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operand Column</em>'.
	 * @see excelltsmetamodel.Group#getOperandColumn()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_OperandColumn();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.Group#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see excelltsmetamodel.Group#getOperation()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Operation();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Group#getResultColumn <em>Result Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Column</em>'.
	 * @see excelltsmetamodel.Group#getResultColumn()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_ResultColumn();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.Column <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Column</em>'.
	 * @see excelltsmetamodel.Column
	 * @generated
	 */
	EClass getColumn();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.Column#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see excelltsmetamodel.Column#getName()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Name();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.Column#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type</em>'.
	 * @see excelltsmetamodel.Column#getDataType()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_DataType();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.Sort <em>Sort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sort</em>'.
	 * @see excelltsmetamodel.Sort
	 * @generated
	 */
	EClass getSort();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Sort#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see excelltsmetamodel.Sort#getTable()
	 * @see #getSort()
	 * @generated
	 */
	EReference getSort_Table();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Sort#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Column</em>'.
	 * @see excelltsmetamodel.Sort#getColumn()
	 * @see #getSort()
	 * @generated
	 */
	EReference getSort_Column();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.Sort#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see excelltsmetamodel.Sort#getOrder()
	 * @see #getSort()
	 * @generated
	 */
	EAttribute getSort_Order();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.AppendRows <em>Append Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Append Rows</em>'.
	 * @see excelltsmetamodel.AppendRows
	 * @generated
	 */
	EClass getAppendRows();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.AppendRows#getOriginTable <em>Origin Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Origin Table</em>'.
	 * @see excelltsmetamodel.AppendRows#getOriginTable()
	 * @see #getAppendRows()
	 * @generated
	 */
	EReference getAppendRows_OriginTable();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.AppendRows#getDestinTable <em>Destin Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destin Table</em>'.
	 * @see excelltsmetamodel.AppendRows#getDestinTable()
	 * @see #getAppendRows()
	 * @generated
	 */
	EReference getAppendRows_DestinTable();

	/**
	 * Returns the meta object for the containment reference list '{@link excelltsmetamodel.AppendRows#getAssociations <em>Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Associations</em>'.
	 * @see excelltsmetamodel.AppendRows#getAssociations()
	 * @see #getAppendRows()
	 * @generated
	 */
	EReference getAppendRows_Associations();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.TableToSave <em>Table To Save</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table To Save</em>'.
	 * @see excelltsmetamodel.TableToSave
	 * @generated
	 */
	EClass getTableToSave();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.TableToSave#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see excelltsmetamodel.TableToSave#getTable()
	 * @see #getTableToSave()
	 * @generated
	 */
	EReference getTableToSave_Table();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.TableToSave#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see excelltsmetamodel.TableToSave#getPath()
	 * @see #getTableToSave()
	 * @generated
	 */
	EAttribute getTableToSave_Path();

	/**
	 * Returns the meta object for the attribute list '{@link excelltsmetamodel.TableToSave#getColumnsNames <em>Columns Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Columns Names</em>'.
	 * @see excelltsmetamodel.TableToSave#getColumnsNames()
	 * @see #getTableToSave()
	 * @generated
	 */
	EAttribute getTableToSave_ColumnsNames();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association</em>'.
	 * @see excelltsmetamodel.Association
	 * @generated
	 */
	EClass getAssociation();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Association#getOriginCol <em>Origin Col</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Origin Col</em>'.
	 * @see excelltsmetamodel.Association#getOriginCol()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_OriginCol();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Association#getDestinCol <em>Destin Col</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destin Col</em>'.
	 * @see excelltsmetamodel.Association#getDestinCol()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_DestinCol();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.Filter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Filter</em>'.
	 * @see excelltsmetamodel.Filter
	 * @generated
	 */
	EClass getFilter();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Filter#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see excelltsmetamodel.Filter#getTable()
	 * @see #getFilter()
	 * @generated
	 */
	EReference getFilter_Table();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Filter#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Column</em>'.
	 * @see excelltsmetamodel.Filter#getColumn()
	 * @see #getFilter()
	 * @generated
	 */
	EReference getFilter_Column();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.Filter#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operand</em>'.
	 * @see excelltsmetamodel.Filter#getOperand()
	 * @see #getFilter()
	 * @generated
	 */
	EAttribute getFilter_Operand();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.Filter#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see excelltsmetamodel.Filter#getOperator()
	 * @see #getFilter()
	 * @generated
	 */
	EAttribute getFilter_Operator();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.GenericStep <em>Generic Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Step</em>'.
	 * @see excelltsmetamodel.GenericStep
	 * @generated
	 */
	EClass getGenericStep();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.Join <em>Join</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Join</em>'.
	 * @see excelltsmetamodel.Join
	 * @generated
	 */
	EClass getJoin();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Join#getTableLeft <em>Table Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table Left</em>'.
	 * @see excelltsmetamodel.Join#getTableLeft()
	 * @see #getJoin()
	 * @generated
	 */
	EReference getJoin_TableLeft();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Join#getTableRight <em>Table Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table Right</em>'.
	 * @see excelltsmetamodel.Join#getTableRight()
	 * @see #getJoin()
	 * @generated
	 */
	EReference getJoin_TableRight();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Join#getColumnLeft <em>Column Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Column Left</em>'.
	 * @see excelltsmetamodel.Join#getColumnLeft()
	 * @see #getJoin()
	 * @generated
	 */
	EReference getJoin_ColumnLeft();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Join#getColumnRight <em>Column Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Column Right</em>'.
	 * @see excelltsmetamodel.Join#getColumnRight()
	 * @see #getJoin()
	 * @generated
	 */
	EReference getJoin_ColumnRight();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.Join#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see excelltsmetamodel.Join#getType()
	 * @see #getJoin()
	 * @generated
	 */
	EAttribute getJoin_Type();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Join#getResultTable <em>Result Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Table</em>'.
	 * @see excelltsmetamodel.Join#getResultTable()
	 * @see #getJoin()
	 * @generated
	 */
	EReference getJoin_ResultTable();

	/**
	 * Returns the meta object for the reference list '{@link excelltsmetamodel.Join#getSelectColumns <em>Select Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Select Columns</em>'.
	 * @see excelltsmetamodel.Join#getSelectColumns()
	 * @see #getJoin()
	 * @generated
	 */
	EReference getJoin_SelectColumns();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see excelltsmetamodel.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the containment reference list '{@link excelltsmetamodel.Import#getTablesToImport <em>Tables To Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tables To Import</em>'.
	 * @see excelltsmetamodel.Import#getTablesToImport()
	 * @see #getImport()
	 * @generated
	 */
	EReference getImport_TablesToImport();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.TableToImport <em>Table To Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table To Import</em>'.
	 * @see excelltsmetamodel.TableToImport
	 * @generated
	 */
	EClass getTableToImport();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.TableToImport#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see excelltsmetamodel.TableToImport#getTable()
	 * @see #getTableToImport()
	 * @generated
	 */
	EReference getTableToImport_Table();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.TableToImport#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see excelltsmetamodel.TableToImport#getPath()
	 * @see #getTableToImport()
	 * @generated
	 */
	EAttribute getTableToImport_Path();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.TableToImport#getDelimiter <em>Delimiter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delimiter</em>'.
	 * @see excelltsmetamodel.TableToImport#getDelimiter()
	 * @see #getTableToImport()
	 * @generated
	 */
	EAttribute getTableToImport_Delimiter();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.TableToImport#isDeleteMismatchedTypes <em>Delete Mismatched Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delete Mismatched Types</em>'.
	 * @see excelltsmetamodel.TableToImport#isDeleteMismatchedTypes()
	 * @see #getTableToImport()
	 * @generated
	 */
	EAttribute getTableToImport_DeleteMismatchedTypes();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.Lookup <em>Lookup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lookup</em>'.
	 * @see excelltsmetamodel.Lookup
	 * @generated
	 */
	EClass getLookup();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Lookup#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see excelltsmetamodel.Lookup#getTable()
	 * @see #getLookup()
	 * @generated
	 */
	EReference getLookup_Table();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Lookup#getLookupTable <em>Lookup Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lookup Table</em>'.
	 * @see excelltsmetamodel.Lookup#getLookupTable()
	 * @see #getLookup()
	 * @generated
	 */
	EReference getLookup_LookupTable();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Lookup#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Column</em>'.
	 * @see excelltsmetamodel.Lookup#getColumn()
	 * @see #getLookup()
	 * @generated
	 */
	EReference getLookup_Column();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Lookup#getOperandColumn <em>Operand Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operand Column</em>'.
	 * @see excelltsmetamodel.Lookup#getOperandColumn()
	 * @see #getLookup()
	 * @generated
	 */
	EReference getLookup_OperandColumn();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Lookup#getMatchColumn <em>Match Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Match Column</em>'.
	 * @see excelltsmetamodel.Lookup#getMatchColumn()
	 * @see #getLookup()
	 * @generated
	 */
	EReference getLookup_MatchColumn();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Lookup#getLookupColumn <em>Lookup Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lookup Column</em>'.
	 * @see excelltsmetamodel.Lookup#getLookupColumn()
	 * @see #getLookup()
	 * @generated
	 */
	EReference getLookup_LookupColumn();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Lookup#getResultColumn <em>Result Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Column</em>'.
	 * @see excelltsmetamodel.Lookup#getResultColumn()
	 * @see #getLookup()
	 * @generated
	 */
	EReference getLookup_ResultColumn();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.Lookup#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see excelltsmetamodel.Lookup#getOperation()
	 * @see #getLookup()
	 * @generated
	 */
	EAttribute getLookup_Operation();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Lookup#getResultTable <em>Result Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Table</em>'.
	 * @see excelltsmetamodel.Lookup#getResultTable()
	 * @see #getLookup()
	 * @generated
	 */
	EReference getLookup_ResultTable();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.RemoveDuplicates <em>Remove Duplicates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Duplicates</em>'.
	 * @see excelltsmetamodel.RemoveDuplicates
	 * @generated
	 */
	EClass getRemoveDuplicates();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.RemoveDuplicates#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see excelltsmetamodel.RemoveDuplicates#getTable()
	 * @see #getRemoveDuplicates()
	 * @generated
	 */
	EReference getRemoveDuplicates_Table();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.RemoveDuplicates#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Column</em>'.
	 * @see excelltsmetamodel.RemoveDuplicates#getColumn()
	 * @see #getRemoveDuplicates()
	 * @generated
	 */
	EReference getRemoveDuplicates_Column();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.Concat <em>Concat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concat</em>'.
	 * @see excelltsmetamodel.Concat
	 * @generated
	 */
	EClass getConcat();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Concat#getSourceA <em>Source A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source A</em>'.
	 * @see excelltsmetamodel.Concat#getSourceA()
	 * @see #getConcat()
	 * @generated
	 */
	EReference getConcat_SourceA();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Concat#getSourceB <em>Source B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source B</em>'.
	 * @see excelltsmetamodel.Concat#getSourceB()
	 * @see #getConcat()
	 * @generated
	 */
	EReference getConcat_SourceB();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Concat#getResultColumn <em>Result Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Column</em>'.
	 * @see excelltsmetamodel.Concat#getResultColumn()
	 * @see #getConcat()
	 * @generated
	 */
	EReference getConcat_ResultColumn();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Concat#getResultTable <em>Result Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Table</em>'.
	 * @see excelltsmetamodel.Concat#getResultTable()
	 * @see #getConcat()
	 * @generated
	 */
	EReference getConcat_ResultTable();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.StringManipulation <em>String Manipulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Manipulation</em>'.
	 * @see excelltsmetamodel.StringManipulation
	 * @generated
	 */
	EClass getStringManipulation();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.StringManipulation#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see excelltsmetamodel.StringManipulation#getTable()
	 * @see #getStringManipulation()
	 * @generated
	 */
	EReference getStringManipulation_Table();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.Split <em>Split</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Split</em>'.
	 * @see excelltsmetamodel.Split
	 * @generated
	 */
	EClass getSplit();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Split#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see excelltsmetamodel.Split#getSource()
	 * @see #getSplit()
	 * @generated
	 */
	EReference getSplit_Source();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Split#getResultColumnB <em>Result Column B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Column B</em>'.
	 * @see excelltsmetamodel.Split#getResultColumnB()
	 * @see #getSplit()
	 * @generated
	 */
	EReference getSplit_ResultColumnB();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Split#getResultColumnA <em>Result Column A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Column A</em>'.
	 * @see excelltsmetamodel.Split#getResultColumnA()
	 * @see #getSplit()
	 * @generated
	 */
	EReference getSplit_ResultColumnA();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.Split#getDelimiter <em>Delimiter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delimiter</em>'.
	 * @see excelltsmetamodel.Split#getDelimiter()
	 * @see #getSplit()
	 * @generated
	 */
	EAttribute getSplit_Delimiter();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.Split#getNumOfChars <em>Num Of Chars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Of Chars</em>'.
	 * @see excelltsmetamodel.Split#getNumOfChars()
	 * @see #getSplit()
	 * @generated
	 */
	EAttribute getSplit_NumOfChars();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Split#getResultTable <em>Result Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Table</em>'.
	 * @see excelltsmetamodel.Split#getResultTable()
	 * @see #getSplit()
	 * @generated
	 */
	EReference getSplit_ResultTable();

	/**
	 * Returns the meta object for class '{@link excelltsmetamodel.Extract <em>Extract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extract</em>'.
	 * @see excelltsmetamodel.Extract
	 * @generated
	 */
	EClass getExtract();

	/**
	 * Returns the meta object for the reference '{@link excelltsmetamodel.Extract#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Column</em>'.
	 * @see excelltsmetamodel.Extract#getColumn()
	 * @see #getExtract()
	 * @generated
	 */
	EReference getExtract_Column();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.Extract#getLbChar <em>Lb Char</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lb Char</em>'.
	 * @see excelltsmetamodel.Extract#getLbChar()
	 * @see #getExtract()
	 * @generated
	 */
	EAttribute getExtract_LbChar();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.Extract#getUbChar <em>Ub Char</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ub Char</em>'.
	 * @see excelltsmetamodel.Extract#getUbChar()
	 * @see #getExtract()
	 * @generated
	 */
	EAttribute getExtract_UbChar();

	/**
	 * Returns the meta object for the attribute '{@link excelltsmetamodel.Extract#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see excelltsmetamodel.Extract#getPattern()
	 * @see #getExtract()
	 * @generated
	 */
	EAttribute getExtract_Pattern();

	/**
	 * Returns the meta object for enum '{@link excelltsmetamodel.JoinType <em>Join Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Join Type</em>'.
	 * @see excelltsmetamodel.JoinType
	 * @generated
	 */
	EEnum getJoinType();

	/**
	 * Returns the meta object for enum '{@link excelltsmetamodel.OrderType <em>Order Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Order Type</em>'.
	 * @see excelltsmetamodel.OrderType
	 * @generated
	 */
	EEnum getOrderType();

	/**
	 * Returns the meta object for enum '{@link excelltsmetamodel.ColumnOperationType <em>Column Operation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Column Operation Type</em>'.
	 * @see excelltsmetamodel.ColumnOperationType
	 * @generated
	 */
	EEnum getColumnOperationType();

	/**
	 * Returns the meta object for enum '{@link excelltsmetamodel.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Type</em>'.
	 * @see excelltsmetamodel.DataType
	 * @generated
	 */
	EEnum getDataType();

	/**
	 * Returns the meta object for enum '{@link excelltsmetamodel.LookupOperationType <em>Lookup Operation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Lookup Operation Type</em>'.
	 * @see excelltsmetamodel.LookupOperationType
	 * @generated
	 */
	EEnum getLookupOperationType();

	/**
	 * Returns the meta object for enum '{@link excelltsmetamodel.FilterOperatorType <em>Filter Operator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Filter Operator Type</em>'.
	 * @see excelltsmetamodel.FilterOperatorType
	 * @generated
	 */
	EEnum getFilterOperatorType();

	/**
	 * Returns the meta object for enum '{@link excelltsmetamodel.GroupOperationType <em>Group Operation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Group Operation Type</em>'.
	 * @see excelltsmetamodel.GroupOperationType
	 * @generated
	 */
	EEnum getGroupOperationType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExcelltsmetamodelFactory getExcelltsmetamodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.ModelImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

		/**
		 * The meta object literal for the '<em><b>Logs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__LOGS = eINSTANCE.getModel_Logs();

		/**
		 * The meta object literal for the '<em><b>Tables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__TABLES = eINSTANCE.getModel_Tables();

		/**
		 * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__STEPS = eINSTANCE.getModel_Steps();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.StepImpl <em>Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.StepImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getStep()
		 * @generated
		 */
		EClass STEP = eINSTANCE.getStep();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEP__NAME = eINSTANCE.getStep_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEP__DESCRIPTION = eINSTANCE.getStep_Description();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.FlowStepImpl <em>Flow Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.FlowStepImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getFlowStep()
		 * @generated
		 */
		EClass FLOW_STEP = eINSTANCE.getFlowStep();

		/**
		 * The meta object literal for the '<em><b>Next</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_STEP__NEXT = eINSTANCE.getFlowStep_Next();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.FinalStepImpl <em>Final Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.FinalStepImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getFinalStep()
		 * @generated
		 */
		EClass FINAL_STEP = eINSTANCE.getFinalStep();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.SaveImpl <em>Save</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.SaveImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getSave()
		 * @generated
		 */
		EClass SAVE = eINSTANCE.getSave();

		/**
		 * The meta object literal for the '<em><b>Tables To Save</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAVE__TABLES_TO_SAVE = eINSTANCE.getSave_TablesToSave();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.TableImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE__NAME = eINSTANCE.getTable_Name();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__COLUMNS = eINSTANCE.getTable_Columns();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.GroupImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__TABLE = eINSTANCE.getGroup_Table();

		/**
		 * The meta object literal for the '<em><b>Group By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__GROUP_BY = eINSTANCE.getGroup_GroupBy();

		/**
		 * The meta object literal for the '<em><b>Result Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__RESULT_TABLE = eINSTANCE.getGroup_ResultTable();

		/**
		 * The meta object literal for the '<em><b>Operand Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__OPERAND_COLUMN = eINSTANCE.getGroup_OperandColumn();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__OPERATION = eINSTANCE.getGroup_Operation();

		/**
		 * The meta object literal for the '<em><b>Result Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__RESULT_COLUMN = eINSTANCE.getGroup_ResultColumn();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.ColumnImpl <em>Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.ColumnImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getColumn()
		 * @generated
		 */
		EClass COLUMN = eINSTANCE.getColumn();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__NAME = eINSTANCE.getColumn_Name();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__DATA_TYPE = eINSTANCE.getColumn_DataType();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.SortImpl <em>Sort</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.SortImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getSort()
		 * @generated
		 */
		EClass SORT = eINSTANCE.getSort();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SORT__TABLE = eINSTANCE.getSort_Table();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SORT__COLUMN = eINSTANCE.getSort_Column();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SORT__ORDER = eINSTANCE.getSort_Order();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.AppendRowsImpl <em>Append Rows</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.AppendRowsImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getAppendRows()
		 * @generated
		 */
		EClass APPEND_ROWS = eINSTANCE.getAppendRows();

		/**
		 * The meta object literal for the '<em><b>Origin Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPEND_ROWS__ORIGIN_TABLE = eINSTANCE.getAppendRows_OriginTable();

		/**
		 * The meta object literal for the '<em><b>Destin Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPEND_ROWS__DESTIN_TABLE = eINSTANCE.getAppendRows_DestinTable();

		/**
		 * The meta object literal for the '<em><b>Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPEND_ROWS__ASSOCIATIONS = eINSTANCE.getAppendRows_Associations();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.TableToSaveImpl <em>Table To Save</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.TableToSaveImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getTableToSave()
		 * @generated
		 */
		EClass TABLE_TO_SAVE = eINSTANCE.getTableToSave();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_TO_SAVE__TABLE = eINSTANCE.getTableToSave_Table();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_TO_SAVE__PATH = eINSTANCE.getTableToSave_Path();

		/**
		 * The meta object literal for the '<em><b>Columns Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_TO_SAVE__COLUMNS_NAMES = eINSTANCE.getTableToSave_ColumnsNames();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.AssociationImpl <em>Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.AssociationImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getAssociation()
		 * @generated
		 */
		EClass ASSOCIATION = eINSTANCE.getAssociation();

		/**
		 * The meta object literal for the '<em><b>Origin Col</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__ORIGIN_COL = eINSTANCE.getAssociation_OriginCol();

		/**
		 * The meta object literal for the '<em><b>Destin Col</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__DESTIN_COL = eINSTANCE.getAssociation_DestinCol();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.FilterImpl <em>Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.FilterImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getFilter()
		 * @generated
		 */
		EClass FILTER = eINSTANCE.getFilter();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILTER__TABLE = eINSTANCE.getFilter_Table();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILTER__COLUMN = eINSTANCE.getFilter_Column();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILTER__OPERAND = eINSTANCE.getFilter_Operand();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILTER__OPERATOR = eINSTANCE.getFilter_Operator();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.GenericStepImpl <em>Generic Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.GenericStepImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getGenericStep()
		 * @generated
		 */
		EClass GENERIC_STEP = eINSTANCE.getGenericStep();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.JoinImpl <em>Join</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.JoinImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getJoin()
		 * @generated
		 */
		EClass JOIN = eINSTANCE.getJoin();

		/**
		 * The meta object literal for the '<em><b>Table Left</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOIN__TABLE_LEFT = eINSTANCE.getJoin_TableLeft();

		/**
		 * The meta object literal for the '<em><b>Table Right</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOIN__TABLE_RIGHT = eINSTANCE.getJoin_TableRight();

		/**
		 * The meta object literal for the '<em><b>Column Left</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOIN__COLUMN_LEFT = eINSTANCE.getJoin_ColumnLeft();

		/**
		 * The meta object literal for the '<em><b>Column Right</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOIN__COLUMN_RIGHT = eINSTANCE.getJoin_ColumnRight();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOIN__TYPE = eINSTANCE.getJoin_Type();

		/**
		 * The meta object literal for the '<em><b>Result Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOIN__RESULT_TABLE = eINSTANCE.getJoin_ResultTable();

		/**
		 * The meta object literal for the '<em><b>Select Columns</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOIN__SELECT_COLUMNS = eINSTANCE.getJoin_SelectColumns();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.ImportImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>Tables To Import</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT__TABLES_TO_IMPORT = eINSTANCE.getImport_TablesToImport();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.TableToImportImpl <em>Table To Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.TableToImportImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getTableToImport()
		 * @generated
		 */
		EClass TABLE_TO_IMPORT = eINSTANCE.getTableToImport();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_TO_IMPORT__TABLE = eINSTANCE.getTableToImport_Table();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_TO_IMPORT__PATH = eINSTANCE.getTableToImport_Path();

		/**
		 * The meta object literal for the '<em><b>Delimiter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_TO_IMPORT__DELIMITER = eINSTANCE.getTableToImport_Delimiter();

		/**
		 * The meta object literal for the '<em><b>Delete Mismatched Types</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_TO_IMPORT__DELETE_MISMATCHED_TYPES = eINSTANCE.getTableToImport_DeleteMismatchedTypes();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.LookupImpl <em>Lookup</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.LookupImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getLookup()
		 * @generated
		 */
		EClass LOOKUP = eINSTANCE.getLookup();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOKUP__TABLE = eINSTANCE.getLookup_Table();

		/**
		 * The meta object literal for the '<em><b>Lookup Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOKUP__LOOKUP_TABLE = eINSTANCE.getLookup_LookupTable();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOKUP__COLUMN = eINSTANCE.getLookup_Column();

		/**
		 * The meta object literal for the '<em><b>Operand Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOKUP__OPERAND_COLUMN = eINSTANCE.getLookup_OperandColumn();

		/**
		 * The meta object literal for the '<em><b>Match Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOKUP__MATCH_COLUMN = eINSTANCE.getLookup_MatchColumn();

		/**
		 * The meta object literal for the '<em><b>Lookup Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOKUP__LOOKUP_COLUMN = eINSTANCE.getLookup_LookupColumn();

		/**
		 * The meta object literal for the '<em><b>Result Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOKUP__RESULT_COLUMN = eINSTANCE.getLookup_ResultColumn();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOOKUP__OPERATION = eINSTANCE.getLookup_Operation();

		/**
		 * The meta object literal for the '<em><b>Result Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOKUP__RESULT_TABLE = eINSTANCE.getLookup_ResultTable();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.RemoveDuplicatesImpl <em>Remove Duplicates</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.RemoveDuplicatesImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getRemoveDuplicates()
		 * @generated
		 */
		EClass REMOVE_DUPLICATES = eINSTANCE.getRemoveDuplicates();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVE_DUPLICATES__TABLE = eINSTANCE.getRemoveDuplicates_Table();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVE_DUPLICATES__COLUMN = eINSTANCE.getRemoveDuplicates_Column();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.ConcatImpl <em>Concat</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.ConcatImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getConcat()
		 * @generated
		 */
		EClass CONCAT = eINSTANCE.getConcat();

		/**
		 * The meta object literal for the '<em><b>Source A</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCAT__SOURCE_A = eINSTANCE.getConcat_SourceA();

		/**
		 * The meta object literal for the '<em><b>Source B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCAT__SOURCE_B = eINSTANCE.getConcat_SourceB();

		/**
		 * The meta object literal for the '<em><b>Result Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCAT__RESULT_COLUMN = eINSTANCE.getConcat_ResultColumn();

		/**
		 * The meta object literal for the '<em><b>Result Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCAT__RESULT_TABLE = eINSTANCE.getConcat_ResultTable();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.StringManipulationImpl <em>String Manipulation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.StringManipulationImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getStringManipulation()
		 * @generated
		 */
		EClass STRING_MANIPULATION = eINSTANCE.getStringManipulation();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_MANIPULATION__TABLE = eINSTANCE.getStringManipulation_Table();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.SplitImpl <em>Split</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.SplitImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getSplit()
		 * @generated
		 */
		EClass SPLIT = eINSTANCE.getSplit();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPLIT__SOURCE = eINSTANCE.getSplit_Source();

		/**
		 * The meta object literal for the '<em><b>Result Column B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPLIT__RESULT_COLUMN_B = eINSTANCE.getSplit_ResultColumnB();

		/**
		 * The meta object literal for the '<em><b>Result Column A</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPLIT__RESULT_COLUMN_A = eINSTANCE.getSplit_ResultColumnA();

		/**
		 * The meta object literal for the '<em><b>Delimiter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPLIT__DELIMITER = eINSTANCE.getSplit_Delimiter();

		/**
		 * The meta object literal for the '<em><b>Num Of Chars</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPLIT__NUM_OF_CHARS = eINSTANCE.getSplit_NumOfChars();

		/**
		 * The meta object literal for the '<em><b>Result Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPLIT__RESULT_TABLE = eINSTANCE.getSplit_ResultTable();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.impl.ExtractImpl <em>Extract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.impl.ExtractImpl
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getExtract()
		 * @generated
		 */
		EClass EXTRACT = eINSTANCE.getExtract();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTRACT__COLUMN = eINSTANCE.getExtract_Column();

		/**
		 * The meta object literal for the '<em><b>Lb Char</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTRACT__LB_CHAR = eINSTANCE.getExtract_LbChar();

		/**
		 * The meta object literal for the '<em><b>Ub Char</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTRACT__UB_CHAR = eINSTANCE.getExtract_UbChar();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTRACT__PATTERN = eINSTANCE.getExtract_Pattern();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.JoinType <em>Join Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.JoinType
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getJoinType()
		 * @generated
		 */
		EEnum JOIN_TYPE = eINSTANCE.getJoinType();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.OrderType <em>Order Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.OrderType
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getOrderType()
		 * @generated
		 */
		EEnum ORDER_TYPE = eINSTANCE.getOrderType();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.ColumnOperationType <em>Column Operation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.ColumnOperationType
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getColumnOperationType()
		 * @generated
		 */
		EEnum COLUMN_OPERATION_TYPE = eINSTANCE.getColumnOperationType();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.DataType <em>Data Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.DataType
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getDataType()
		 * @generated
		 */
		EEnum DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.LookupOperationType <em>Lookup Operation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.LookupOperationType
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getLookupOperationType()
		 * @generated
		 */
		EEnum LOOKUP_OPERATION_TYPE = eINSTANCE.getLookupOperationType();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.FilterOperatorType <em>Filter Operator Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.FilterOperatorType
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getFilterOperatorType()
		 * @generated
		 */
		EEnum FILTER_OPERATOR_TYPE = eINSTANCE.getFilterOperatorType();

		/**
		 * The meta object literal for the '{@link excelltsmetamodel.GroupOperationType <em>Group Operation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see excelltsmetamodel.GroupOperationType
		 * @see excelltsmetamodel.impl.ExcelltsmetamodelPackageImpl#getGroupOperationType()
		 * @generated
		 */
		EEnum GROUP_OPERATION_TYPE = eINSTANCE.getGroupOperationType();

	}

} //ExcelltsmetamodelPackage
