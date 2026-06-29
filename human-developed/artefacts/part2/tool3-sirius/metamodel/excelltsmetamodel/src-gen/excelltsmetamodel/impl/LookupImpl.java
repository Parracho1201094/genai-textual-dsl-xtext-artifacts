/**
 */
package excelltsmetamodel.impl;

import excelltsmetamodel.Column;
import excelltsmetamodel.ExcelltsmetamodelPackage;
import excelltsmetamodel.Lookup;
import excelltsmetamodel.LookupOperationType;
import excelltsmetamodel.Table;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lookup</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.impl.LookupImpl#getTable <em>Table</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.LookupImpl#getLookupTable <em>Lookup Table</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.LookupImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.LookupImpl#getOperandColumn <em>Operand Column</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.LookupImpl#getMatchColumn <em>Match Column</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.LookupImpl#getLookupColumn <em>Lookup Column</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.LookupImpl#getResultColumn <em>Result Column</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.LookupImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.LookupImpl#getResultTable <em>Result Table</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LookupImpl extends FlowStepImpl implements Lookup {
	/**
	 * The cached value of the '{@link #getTable() <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTable()
	 * @generated
	 * @ordered
	 */
	protected Table table;

	/**
	 * The cached value of the '{@link #getLookupTable() <em>Lookup Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLookupTable()
	 * @generated
	 * @ordered
	 */
	protected Table lookupTable;

	/**
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected Column column;

	/**
	 * The cached value of the '{@link #getOperandColumn() <em>Operand Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperandColumn()
	 * @generated
	 * @ordered
	 */
	protected Column operandColumn;

	/**
	 * The cached value of the '{@link #getMatchColumn() <em>Match Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatchColumn()
	 * @generated
	 * @ordered
	 */
	protected Column matchColumn;

	/**
	 * The cached value of the '{@link #getLookupColumn() <em>Lookup Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLookupColumn()
	 * @generated
	 * @ordered
	 */
	protected Column lookupColumn;

	/**
	 * The cached value of the '{@link #getResultColumn() <em>Result Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultColumn()
	 * @generated
	 * @ordered
	 */
	protected Column resultColumn;

	/**
	 * The default value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected static final LookupOperationType OPERATION_EDEFAULT = LookupOperationType.NUMERIC_SUM;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected LookupOperationType operation = OPERATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResultTable() <em>Result Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultTable()
	 * @generated
	 * @ordered
	 */
	protected Table resultTable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LookupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExcelltsmetamodelPackage.Literals.LOOKUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Table getTable() {
		if (table != null && table.eIsProxy()) {
			InternalEObject oldTable = (InternalEObject) table;
			table = (Table) eResolveProxy(oldTable);
			if (table != oldTable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExcelltsmetamodelPackage.LOOKUP__TABLE,
							oldTable, table));
			}
		}
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table basicGetTable() {
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTable(Table newTable) {
		Table oldTable = table;
		table = newTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.LOOKUP__TABLE, oldTable,
					table));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Table getLookupTable() {
		if (lookupTable != null && lookupTable.eIsProxy()) {
			InternalEObject oldLookupTable = (InternalEObject) lookupTable;
			lookupTable = (Table) eResolveProxy(oldLookupTable);
			if (lookupTable != oldLookupTable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExcelltsmetamodelPackage.LOOKUP__LOOKUP_TABLE, oldLookupTable, lookupTable));
			}
		}
		return lookupTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table basicGetLookupTable() {
		return lookupTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLookupTable(Table newLookupTable) {
		Table oldLookupTable = lookupTable;
		lookupTable = newLookupTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.LOOKUP__LOOKUP_TABLE,
					oldLookupTable, lookupTable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Column getColumn() {
		if (column != null && column.eIsProxy()) {
			InternalEObject oldColumn = (InternalEObject) column;
			column = (Column) eResolveProxy(oldColumn);
			if (column != oldColumn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExcelltsmetamodelPackage.LOOKUP__COLUMN,
							oldColumn, column));
			}
		}
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetColumn() {
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColumn(Column newColumn) {
		Column oldColumn = column;
		column = newColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.LOOKUP__COLUMN, oldColumn,
					column));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Column getOperandColumn() {
		if (operandColumn != null && operandColumn.eIsProxy()) {
			InternalEObject oldOperandColumn = (InternalEObject) operandColumn;
			operandColumn = (Column) eResolveProxy(oldOperandColumn);
			if (operandColumn != oldOperandColumn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExcelltsmetamodelPackage.LOOKUP__OPERAND_COLUMN, oldOperandColumn, operandColumn));
			}
		}
		return operandColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetOperandColumn() {
		return operandColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperandColumn(Column newOperandColumn) {
		Column oldOperandColumn = operandColumn;
		operandColumn = newOperandColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.LOOKUP__OPERAND_COLUMN,
					oldOperandColumn, operandColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Column getMatchColumn() {
		if (matchColumn != null && matchColumn.eIsProxy()) {
			InternalEObject oldMatchColumn = (InternalEObject) matchColumn;
			matchColumn = (Column) eResolveProxy(oldMatchColumn);
			if (matchColumn != oldMatchColumn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExcelltsmetamodelPackage.LOOKUP__MATCH_COLUMN, oldMatchColumn, matchColumn));
			}
		}
		return matchColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetMatchColumn() {
		return matchColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMatchColumn(Column newMatchColumn) {
		Column oldMatchColumn = matchColumn;
		matchColumn = newMatchColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.LOOKUP__MATCH_COLUMN,
					oldMatchColumn, matchColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Column getLookupColumn() {
		if (lookupColumn != null && lookupColumn.eIsProxy()) {
			InternalEObject oldLookupColumn = (InternalEObject) lookupColumn;
			lookupColumn = (Column) eResolveProxy(oldLookupColumn);
			if (lookupColumn != oldLookupColumn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExcelltsmetamodelPackage.LOOKUP__LOOKUP_COLUMN, oldLookupColumn, lookupColumn));
			}
		}
		return lookupColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetLookupColumn() {
		return lookupColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLookupColumn(Column newLookupColumn) {
		Column oldLookupColumn = lookupColumn;
		lookupColumn = newLookupColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.LOOKUP__LOOKUP_COLUMN,
					oldLookupColumn, lookupColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Column getResultColumn() {
		if (resultColumn != null && resultColumn.eIsProxy()) {
			InternalEObject oldResultColumn = (InternalEObject) resultColumn;
			resultColumn = (Column) eResolveProxy(oldResultColumn);
			if (resultColumn != oldResultColumn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExcelltsmetamodelPackage.LOOKUP__RESULT_COLUMN, oldResultColumn, resultColumn));
			}
		}
		return resultColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetResultColumn() {
		return resultColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResultColumn(Column newResultColumn) {
		Column oldResultColumn = resultColumn;
		resultColumn = newResultColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.LOOKUP__RESULT_COLUMN,
					oldResultColumn, resultColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LookupOperationType getOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperation(LookupOperationType newOperation) {
		LookupOperationType oldOperation = operation;
		operation = newOperation == null ? OPERATION_EDEFAULT : newOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.LOOKUP__OPERATION,
					oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Table getResultTable() {
		if (resultTable != null && resultTable.eIsProxy()) {
			InternalEObject oldResultTable = (InternalEObject) resultTable;
			resultTable = (Table) eResolveProxy(oldResultTable);
			if (resultTable != oldResultTable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExcelltsmetamodelPackage.LOOKUP__RESULT_TABLE, oldResultTable, resultTable));
			}
		}
		return resultTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table basicGetResultTable() {
		return resultTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResultTable(Table newResultTable) {
		Table oldResultTable = resultTable;
		resultTable = newResultTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.LOOKUP__RESULT_TABLE,
					oldResultTable, resultTable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ExcelltsmetamodelPackage.LOOKUP__TABLE:
			if (resolve)
				return getTable();
			return basicGetTable();
		case ExcelltsmetamodelPackage.LOOKUP__LOOKUP_TABLE:
			if (resolve)
				return getLookupTable();
			return basicGetLookupTable();
		case ExcelltsmetamodelPackage.LOOKUP__COLUMN:
			if (resolve)
				return getColumn();
			return basicGetColumn();
		case ExcelltsmetamodelPackage.LOOKUP__OPERAND_COLUMN:
			if (resolve)
				return getOperandColumn();
			return basicGetOperandColumn();
		case ExcelltsmetamodelPackage.LOOKUP__MATCH_COLUMN:
			if (resolve)
				return getMatchColumn();
			return basicGetMatchColumn();
		case ExcelltsmetamodelPackage.LOOKUP__LOOKUP_COLUMN:
			if (resolve)
				return getLookupColumn();
			return basicGetLookupColumn();
		case ExcelltsmetamodelPackage.LOOKUP__RESULT_COLUMN:
			if (resolve)
				return getResultColumn();
			return basicGetResultColumn();
		case ExcelltsmetamodelPackage.LOOKUP__OPERATION:
			return getOperation();
		case ExcelltsmetamodelPackage.LOOKUP__RESULT_TABLE:
			if (resolve)
				return getResultTable();
			return basicGetResultTable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ExcelltsmetamodelPackage.LOOKUP__TABLE:
			setTable((Table) newValue);
			return;
		case ExcelltsmetamodelPackage.LOOKUP__LOOKUP_TABLE:
			setLookupTable((Table) newValue);
			return;
		case ExcelltsmetamodelPackage.LOOKUP__COLUMN:
			setColumn((Column) newValue);
			return;
		case ExcelltsmetamodelPackage.LOOKUP__OPERAND_COLUMN:
			setOperandColumn((Column) newValue);
			return;
		case ExcelltsmetamodelPackage.LOOKUP__MATCH_COLUMN:
			setMatchColumn((Column) newValue);
			return;
		case ExcelltsmetamodelPackage.LOOKUP__LOOKUP_COLUMN:
			setLookupColumn((Column) newValue);
			return;
		case ExcelltsmetamodelPackage.LOOKUP__RESULT_COLUMN:
			setResultColumn((Column) newValue);
			return;
		case ExcelltsmetamodelPackage.LOOKUP__OPERATION:
			setOperation((LookupOperationType) newValue);
			return;
		case ExcelltsmetamodelPackage.LOOKUP__RESULT_TABLE:
			setResultTable((Table) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ExcelltsmetamodelPackage.LOOKUP__TABLE:
			setTable((Table) null);
			return;
		case ExcelltsmetamodelPackage.LOOKUP__LOOKUP_TABLE:
			setLookupTable((Table) null);
			return;
		case ExcelltsmetamodelPackage.LOOKUP__COLUMN:
			setColumn((Column) null);
			return;
		case ExcelltsmetamodelPackage.LOOKUP__OPERAND_COLUMN:
			setOperandColumn((Column) null);
			return;
		case ExcelltsmetamodelPackage.LOOKUP__MATCH_COLUMN:
			setMatchColumn((Column) null);
			return;
		case ExcelltsmetamodelPackage.LOOKUP__LOOKUP_COLUMN:
			setLookupColumn((Column) null);
			return;
		case ExcelltsmetamodelPackage.LOOKUP__RESULT_COLUMN:
			setResultColumn((Column) null);
			return;
		case ExcelltsmetamodelPackage.LOOKUP__OPERATION:
			setOperation(OPERATION_EDEFAULT);
			return;
		case ExcelltsmetamodelPackage.LOOKUP__RESULT_TABLE:
			setResultTable((Table) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ExcelltsmetamodelPackage.LOOKUP__TABLE:
			return table != null;
		case ExcelltsmetamodelPackage.LOOKUP__LOOKUP_TABLE:
			return lookupTable != null;
		case ExcelltsmetamodelPackage.LOOKUP__COLUMN:
			return column != null;
		case ExcelltsmetamodelPackage.LOOKUP__OPERAND_COLUMN:
			return operandColumn != null;
		case ExcelltsmetamodelPackage.LOOKUP__MATCH_COLUMN:
			return matchColumn != null;
		case ExcelltsmetamodelPackage.LOOKUP__LOOKUP_COLUMN:
			return lookupColumn != null;
		case ExcelltsmetamodelPackage.LOOKUP__RESULT_COLUMN:
			return resultColumn != null;
		case ExcelltsmetamodelPackage.LOOKUP__OPERATION:
			return operation != OPERATION_EDEFAULT;
		case ExcelltsmetamodelPackage.LOOKUP__RESULT_TABLE:
			return resultTable != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (operation: ");
		result.append(operation);
		result.append(')');
		return result.toString();
	}

} //LookupImpl
