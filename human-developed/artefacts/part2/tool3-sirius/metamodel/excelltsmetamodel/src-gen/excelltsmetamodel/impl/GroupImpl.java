/**
 */
package excelltsmetamodel.impl;

import excelltsmetamodel.Column;
import excelltsmetamodel.ExcelltsmetamodelPackage;
import excelltsmetamodel.Group;
import excelltsmetamodel.GroupOperationType;
import excelltsmetamodel.Table;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.impl.GroupImpl#getTable <em>Table</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.GroupImpl#getGroupBy <em>Group By</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.GroupImpl#getResultTable <em>Result Table</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.GroupImpl#getOperandColumn <em>Operand Column</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.GroupImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.GroupImpl#getResultColumn <em>Result Column</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupImpl extends FlowStepImpl implements Group {
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
	 * The cached value of the '{@link #getGroupBy() <em>Group By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupBy()
	 * @generated
	 * @ordered
	 */
	protected EList<Column> groupBy;

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
	 * The cached value of the '{@link #getOperandColumn() <em>Operand Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperandColumn()
	 * @generated
	 * @ordered
	 */
	protected Column operandColumn;

	/**
	 * The default value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected static final GroupOperationType OPERATION_EDEFAULT = GroupOperationType.MAX;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected GroupOperationType operation = OPERATION_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExcelltsmetamodelPackage.Literals.GROUP;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExcelltsmetamodelPackage.GROUP__TABLE,
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.GROUP__TABLE, oldTable,
					table));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Column> getGroupBy() {
		if (groupBy == null) {
			groupBy = new EObjectResolvingEList<Column>(Column.class, this, ExcelltsmetamodelPackage.GROUP__GROUP_BY);
		}
		return groupBy;
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
							ExcelltsmetamodelPackage.GROUP__RESULT_TABLE, oldResultTable, resultTable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.GROUP__RESULT_TABLE,
					oldResultTable, resultTable));
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
							ExcelltsmetamodelPackage.GROUP__OPERAND_COLUMN, oldOperandColumn, operandColumn));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.GROUP__OPERAND_COLUMN,
					oldOperandColumn, operandColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GroupOperationType getOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperation(GroupOperationType newOperation) {
		GroupOperationType oldOperation = operation;
		operation = newOperation == null ? OPERATION_EDEFAULT : newOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.GROUP__OPERATION,
					oldOperation, operation));
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
							ExcelltsmetamodelPackage.GROUP__RESULT_COLUMN, oldResultColumn, resultColumn));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.GROUP__RESULT_COLUMN,
					oldResultColumn, resultColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ExcelltsmetamodelPackage.GROUP__TABLE:
			if (resolve)
				return getTable();
			return basicGetTable();
		case ExcelltsmetamodelPackage.GROUP__GROUP_BY:
			return getGroupBy();
		case ExcelltsmetamodelPackage.GROUP__RESULT_TABLE:
			if (resolve)
				return getResultTable();
			return basicGetResultTable();
		case ExcelltsmetamodelPackage.GROUP__OPERAND_COLUMN:
			if (resolve)
				return getOperandColumn();
			return basicGetOperandColumn();
		case ExcelltsmetamodelPackage.GROUP__OPERATION:
			return getOperation();
		case ExcelltsmetamodelPackage.GROUP__RESULT_COLUMN:
			if (resolve)
				return getResultColumn();
			return basicGetResultColumn();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ExcelltsmetamodelPackage.GROUP__TABLE:
			setTable((Table) newValue);
			return;
		case ExcelltsmetamodelPackage.GROUP__GROUP_BY:
			getGroupBy().clear();
			getGroupBy().addAll((Collection<? extends Column>) newValue);
			return;
		case ExcelltsmetamodelPackage.GROUP__RESULT_TABLE:
			setResultTable((Table) newValue);
			return;
		case ExcelltsmetamodelPackage.GROUP__OPERAND_COLUMN:
			setOperandColumn((Column) newValue);
			return;
		case ExcelltsmetamodelPackage.GROUP__OPERATION:
			setOperation((GroupOperationType) newValue);
			return;
		case ExcelltsmetamodelPackage.GROUP__RESULT_COLUMN:
			setResultColumn((Column) newValue);
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
		case ExcelltsmetamodelPackage.GROUP__TABLE:
			setTable((Table) null);
			return;
		case ExcelltsmetamodelPackage.GROUP__GROUP_BY:
			getGroupBy().clear();
			return;
		case ExcelltsmetamodelPackage.GROUP__RESULT_TABLE:
			setResultTable((Table) null);
			return;
		case ExcelltsmetamodelPackage.GROUP__OPERAND_COLUMN:
			setOperandColumn((Column) null);
			return;
		case ExcelltsmetamodelPackage.GROUP__OPERATION:
			setOperation(OPERATION_EDEFAULT);
			return;
		case ExcelltsmetamodelPackage.GROUP__RESULT_COLUMN:
			setResultColumn((Column) null);
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
		case ExcelltsmetamodelPackage.GROUP__TABLE:
			return table != null;
		case ExcelltsmetamodelPackage.GROUP__GROUP_BY:
			return groupBy != null && !groupBy.isEmpty();
		case ExcelltsmetamodelPackage.GROUP__RESULT_TABLE:
			return resultTable != null;
		case ExcelltsmetamodelPackage.GROUP__OPERAND_COLUMN:
			return operandColumn != null;
		case ExcelltsmetamodelPackage.GROUP__OPERATION:
			return operation != OPERATION_EDEFAULT;
		case ExcelltsmetamodelPackage.GROUP__RESULT_COLUMN:
			return resultColumn != null;
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

} //GroupImpl
