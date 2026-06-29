/**
 */
package excelltsmetamodel.impl;

import excelltsmetamodel.Column;
import excelltsmetamodel.Concat;
import excelltsmetamodel.ExcelltsmetamodelPackage;
import excelltsmetamodel.Table;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concat</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.impl.ConcatImpl#getSourceA <em>Source A</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.ConcatImpl#getSourceB <em>Source B</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.ConcatImpl#getResultColumn <em>Result Column</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.ConcatImpl#getResultTable <em>Result Table</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConcatImpl extends StringManipulationImpl implements Concat {
	/**
	 * The cached value of the '{@link #getSourceA() <em>Source A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceA()
	 * @generated
	 * @ordered
	 */
	protected Column sourceA;

	/**
	 * The cached value of the '{@link #getSourceB() <em>Source B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceB()
	 * @generated
	 * @ordered
	 */
	protected Column sourceB;

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
	protected ConcatImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExcelltsmetamodelPackage.Literals.CONCAT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Column getSourceA() {
		if (sourceA != null && sourceA.eIsProxy()) {
			InternalEObject oldSourceA = (InternalEObject) sourceA;
			sourceA = (Column) eResolveProxy(oldSourceA);
			if (sourceA != oldSourceA) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExcelltsmetamodelPackage.CONCAT__SOURCE_A,
							oldSourceA, sourceA));
			}
		}
		return sourceA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetSourceA() {
		return sourceA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourceA(Column newSourceA) {
		Column oldSourceA = sourceA;
		sourceA = newSourceA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.CONCAT__SOURCE_A, oldSourceA,
					sourceA));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Column getSourceB() {
		if (sourceB != null && sourceB.eIsProxy()) {
			InternalEObject oldSourceB = (InternalEObject) sourceB;
			sourceB = (Column) eResolveProxy(oldSourceB);
			if (sourceB != oldSourceB) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExcelltsmetamodelPackage.CONCAT__SOURCE_B,
							oldSourceB, sourceB));
			}
		}
		return sourceB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetSourceB() {
		return sourceB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourceB(Column newSourceB) {
		Column oldSourceB = sourceB;
		sourceB = newSourceB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.CONCAT__SOURCE_B, oldSourceB,
					sourceB));
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
							ExcelltsmetamodelPackage.CONCAT__RESULT_COLUMN, oldResultColumn, resultColumn));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.CONCAT__RESULT_COLUMN,
					oldResultColumn, resultColumn));
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
							ExcelltsmetamodelPackage.CONCAT__RESULT_TABLE, oldResultTable, resultTable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.CONCAT__RESULT_TABLE,
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
		case ExcelltsmetamodelPackage.CONCAT__SOURCE_A:
			if (resolve)
				return getSourceA();
			return basicGetSourceA();
		case ExcelltsmetamodelPackage.CONCAT__SOURCE_B:
			if (resolve)
				return getSourceB();
			return basicGetSourceB();
		case ExcelltsmetamodelPackage.CONCAT__RESULT_COLUMN:
			if (resolve)
				return getResultColumn();
			return basicGetResultColumn();
		case ExcelltsmetamodelPackage.CONCAT__RESULT_TABLE:
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
		case ExcelltsmetamodelPackage.CONCAT__SOURCE_A:
			setSourceA((Column) newValue);
			return;
		case ExcelltsmetamodelPackage.CONCAT__SOURCE_B:
			setSourceB((Column) newValue);
			return;
		case ExcelltsmetamodelPackage.CONCAT__RESULT_COLUMN:
			setResultColumn((Column) newValue);
			return;
		case ExcelltsmetamodelPackage.CONCAT__RESULT_TABLE:
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
		case ExcelltsmetamodelPackage.CONCAT__SOURCE_A:
			setSourceA((Column) null);
			return;
		case ExcelltsmetamodelPackage.CONCAT__SOURCE_B:
			setSourceB((Column) null);
			return;
		case ExcelltsmetamodelPackage.CONCAT__RESULT_COLUMN:
			setResultColumn((Column) null);
			return;
		case ExcelltsmetamodelPackage.CONCAT__RESULT_TABLE:
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
		case ExcelltsmetamodelPackage.CONCAT__SOURCE_A:
			return sourceA != null;
		case ExcelltsmetamodelPackage.CONCAT__SOURCE_B:
			return sourceB != null;
		case ExcelltsmetamodelPackage.CONCAT__RESULT_COLUMN:
			return resultColumn != null;
		case ExcelltsmetamodelPackage.CONCAT__RESULT_TABLE:
			return resultTable != null;
		}
		return super.eIsSet(featureID);
	}

} //ConcatImpl
