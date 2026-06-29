/**
 */
package excelltsmetamodel.impl;

import excelltsmetamodel.ExcelltsmetamodelPackage;
import excelltsmetamodel.Table;
import excelltsmetamodel.TableToSave;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table To Save</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.impl.TableToSaveImpl#getTable <em>Table</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.TableToSaveImpl#getPath <em>Path</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.TableToSaveImpl#getColumnsNames <em>Columns Names</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TableToSaveImpl extends MinimalEObjectImpl.Container implements TableToSave {
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
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getColumnsNames() <em>Columns Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnsNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> columnsNames;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableToSaveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExcelltsmetamodelPackage.Literals.TABLE_TO_SAVE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExcelltsmetamodelPackage.TABLE_TO_SAVE__TABLE, oldTable, table));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.TABLE_TO_SAVE__TABLE,
					oldTable, table));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.TABLE_TO_SAVE__PATH, oldPath,
					path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getColumnsNames() {
		if (columnsNames == null) {
			columnsNames = new EDataTypeUniqueEList<String>(String.class, this,
					ExcelltsmetamodelPackage.TABLE_TO_SAVE__COLUMNS_NAMES);
		}
		return columnsNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ExcelltsmetamodelPackage.TABLE_TO_SAVE__TABLE:
			if (resolve)
				return getTable();
			return basicGetTable();
		case ExcelltsmetamodelPackage.TABLE_TO_SAVE__PATH:
			return getPath();
		case ExcelltsmetamodelPackage.TABLE_TO_SAVE__COLUMNS_NAMES:
			return getColumnsNames();
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
		case ExcelltsmetamodelPackage.TABLE_TO_SAVE__TABLE:
			setTable((Table) newValue);
			return;
		case ExcelltsmetamodelPackage.TABLE_TO_SAVE__PATH:
			setPath((String) newValue);
			return;
		case ExcelltsmetamodelPackage.TABLE_TO_SAVE__COLUMNS_NAMES:
			getColumnsNames().clear();
			getColumnsNames().addAll((Collection<? extends String>) newValue);
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
		case ExcelltsmetamodelPackage.TABLE_TO_SAVE__TABLE:
			setTable((Table) null);
			return;
		case ExcelltsmetamodelPackage.TABLE_TO_SAVE__PATH:
			setPath(PATH_EDEFAULT);
			return;
		case ExcelltsmetamodelPackage.TABLE_TO_SAVE__COLUMNS_NAMES:
			getColumnsNames().clear();
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
		case ExcelltsmetamodelPackage.TABLE_TO_SAVE__TABLE:
			return table != null;
		case ExcelltsmetamodelPackage.TABLE_TO_SAVE__PATH:
			return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
		case ExcelltsmetamodelPackage.TABLE_TO_SAVE__COLUMNS_NAMES:
			return columnsNames != null && !columnsNames.isEmpty();
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
		result.append(" (path: ");
		result.append(path);
		result.append(", columnsNames: ");
		result.append(columnsNames);
		result.append(')');
		return result.toString();
	}

} //TableToSaveImpl
