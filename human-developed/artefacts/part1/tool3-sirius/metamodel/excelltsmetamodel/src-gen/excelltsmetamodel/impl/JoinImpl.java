/**
 */
package excelltsmetamodel.impl;

import excelltsmetamodel.Column;
import excelltsmetamodel.ExcelltsmetamodelPackage;
import excelltsmetamodel.Join;
import excelltsmetamodel.JoinType;
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
 * An implementation of the model object '<em><b>Join</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.impl.JoinImpl#getTableLeft <em>Table Left</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.JoinImpl#getTableRight <em>Table Right</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.JoinImpl#getColumnLeft <em>Column Left</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.JoinImpl#getColumnRight <em>Column Right</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.JoinImpl#getType <em>Type</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.JoinImpl#getResultTable <em>Result Table</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.JoinImpl#getSelectColumns <em>Select Columns</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JoinImpl extends FlowStepImpl implements Join {
	/**
	 * The cached value of the '{@link #getTableLeft() <em>Table Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableLeft()
	 * @generated
	 * @ordered
	 */
	protected Table tableLeft;

	/**
	 * The cached value of the '{@link #getTableRight() <em>Table Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableRight()
	 * @generated
	 * @ordered
	 */
	protected Table tableRight;

	/**
	 * The cached value of the '{@link #getColumnLeft() <em>Column Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnLeft()
	 * @generated
	 * @ordered
	 */
	protected Column columnLeft;

	/**
	 * The cached value of the '{@link #getColumnRight() <em>Column Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnRight()
	 * @generated
	 * @ordered
	 */
	protected Column columnRight;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final JoinType TYPE_EDEFAULT = JoinType.INNER;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected JoinType type = TYPE_EDEFAULT;

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
	 * The cached value of the '{@link #getSelectColumns() <em>Select Columns</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectColumns()
	 * @generated
	 * @ordered
	 */
	protected EList<Column> selectColumns;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JoinImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExcelltsmetamodelPackage.Literals.JOIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Table getTableLeft() {
		if (tableLeft != null && tableLeft.eIsProxy()) {
			InternalEObject oldTableLeft = (InternalEObject) tableLeft;
			tableLeft = (Table) eResolveProxy(oldTableLeft);
			if (tableLeft != oldTableLeft) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExcelltsmetamodelPackage.JOIN__TABLE_LEFT,
							oldTableLeft, tableLeft));
			}
		}
		return tableLeft;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table basicGetTableLeft() {
		return tableLeft;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTableLeft(Table newTableLeft) {
		Table oldTableLeft = tableLeft;
		tableLeft = newTableLeft;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.JOIN__TABLE_LEFT,
					oldTableLeft, tableLeft));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Table getTableRight() {
		if (tableRight != null && tableRight.eIsProxy()) {
			InternalEObject oldTableRight = (InternalEObject) tableRight;
			tableRight = (Table) eResolveProxy(oldTableRight);
			if (tableRight != oldTableRight) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExcelltsmetamodelPackage.JOIN__TABLE_RIGHT, oldTableRight, tableRight));
			}
		}
		return tableRight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table basicGetTableRight() {
		return tableRight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTableRight(Table newTableRight) {
		Table oldTableRight = tableRight;
		tableRight = newTableRight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.JOIN__TABLE_RIGHT,
					oldTableRight, tableRight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Column getColumnLeft() {
		if (columnLeft != null && columnLeft.eIsProxy()) {
			InternalEObject oldColumnLeft = (InternalEObject) columnLeft;
			columnLeft = (Column) eResolveProxy(oldColumnLeft);
			if (columnLeft != oldColumnLeft) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExcelltsmetamodelPackage.JOIN__COLUMN_LEFT, oldColumnLeft, columnLeft));
			}
		}
		return columnLeft;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetColumnLeft() {
		return columnLeft;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColumnLeft(Column newColumnLeft) {
		Column oldColumnLeft = columnLeft;
		columnLeft = newColumnLeft;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.JOIN__COLUMN_LEFT,
					oldColumnLeft, columnLeft));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Column getColumnRight() {
		if (columnRight != null && columnRight.eIsProxy()) {
			InternalEObject oldColumnRight = (InternalEObject) columnRight;
			columnRight = (Column) eResolveProxy(oldColumnRight);
			if (columnRight != oldColumnRight) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExcelltsmetamodelPackage.JOIN__COLUMN_RIGHT, oldColumnRight, columnRight));
			}
		}
		return columnRight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetColumnRight() {
		return columnRight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColumnRight(Column newColumnRight) {
		Column oldColumnRight = columnRight;
		columnRight = newColumnRight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.JOIN__COLUMN_RIGHT,
					oldColumnRight, columnRight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JoinType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(JoinType newType) {
		JoinType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.JOIN__TYPE, oldType, type));
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
							ExcelltsmetamodelPackage.JOIN__RESULT_TABLE, oldResultTable, resultTable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.JOIN__RESULT_TABLE,
					oldResultTable, resultTable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Column> getSelectColumns() {
		if (selectColumns == null) {
			selectColumns = new EObjectResolvingEList<Column>(Column.class, this,
					ExcelltsmetamodelPackage.JOIN__SELECT_COLUMNS);
		}
		return selectColumns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ExcelltsmetamodelPackage.JOIN__TABLE_LEFT:
			if (resolve)
				return getTableLeft();
			return basicGetTableLeft();
		case ExcelltsmetamodelPackage.JOIN__TABLE_RIGHT:
			if (resolve)
				return getTableRight();
			return basicGetTableRight();
		case ExcelltsmetamodelPackage.JOIN__COLUMN_LEFT:
			if (resolve)
				return getColumnLeft();
			return basicGetColumnLeft();
		case ExcelltsmetamodelPackage.JOIN__COLUMN_RIGHT:
			if (resolve)
				return getColumnRight();
			return basicGetColumnRight();
		case ExcelltsmetamodelPackage.JOIN__TYPE:
			return getType();
		case ExcelltsmetamodelPackage.JOIN__RESULT_TABLE:
			if (resolve)
				return getResultTable();
			return basicGetResultTable();
		case ExcelltsmetamodelPackage.JOIN__SELECT_COLUMNS:
			return getSelectColumns();
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
		case ExcelltsmetamodelPackage.JOIN__TABLE_LEFT:
			setTableLeft((Table) newValue);
			return;
		case ExcelltsmetamodelPackage.JOIN__TABLE_RIGHT:
			setTableRight((Table) newValue);
			return;
		case ExcelltsmetamodelPackage.JOIN__COLUMN_LEFT:
			setColumnLeft((Column) newValue);
			return;
		case ExcelltsmetamodelPackage.JOIN__COLUMN_RIGHT:
			setColumnRight((Column) newValue);
			return;
		case ExcelltsmetamodelPackage.JOIN__TYPE:
			setType((JoinType) newValue);
			return;
		case ExcelltsmetamodelPackage.JOIN__RESULT_TABLE:
			setResultTable((Table) newValue);
			return;
		case ExcelltsmetamodelPackage.JOIN__SELECT_COLUMNS:
			getSelectColumns().clear();
			getSelectColumns().addAll((Collection<? extends Column>) newValue);
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
		case ExcelltsmetamodelPackage.JOIN__TABLE_LEFT:
			setTableLeft((Table) null);
			return;
		case ExcelltsmetamodelPackage.JOIN__TABLE_RIGHT:
			setTableRight((Table) null);
			return;
		case ExcelltsmetamodelPackage.JOIN__COLUMN_LEFT:
			setColumnLeft((Column) null);
			return;
		case ExcelltsmetamodelPackage.JOIN__COLUMN_RIGHT:
			setColumnRight((Column) null);
			return;
		case ExcelltsmetamodelPackage.JOIN__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case ExcelltsmetamodelPackage.JOIN__RESULT_TABLE:
			setResultTable((Table) null);
			return;
		case ExcelltsmetamodelPackage.JOIN__SELECT_COLUMNS:
			getSelectColumns().clear();
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
		case ExcelltsmetamodelPackage.JOIN__TABLE_LEFT:
			return tableLeft != null;
		case ExcelltsmetamodelPackage.JOIN__TABLE_RIGHT:
			return tableRight != null;
		case ExcelltsmetamodelPackage.JOIN__COLUMN_LEFT:
			return columnLeft != null;
		case ExcelltsmetamodelPackage.JOIN__COLUMN_RIGHT:
			return columnRight != null;
		case ExcelltsmetamodelPackage.JOIN__TYPE:
			return type != TYPE_EDEFAULT;
		case ExcelltsmetamodelPackage.JOIN__RESULT_TABLE:
			return resultTable != null;
		case ExcelltsmetamodelPackage.JOIN__SELECT_COLUMNS:
			return selectColumns != null && !selectColumns.isEmpty();
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //JoinImpl
