/**
 */
package excelltsmetamodel.impl;

import excelltsmetamodel.ExcelltsmetamodelPackage;
import excelltsmetamodel.Table;
import excelltsmetamodel.TableToImport;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table To Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.impl.TableToImportImpl#getTable <em>Table</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.TableToImportImpl#getPath <em>Path</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.TableToImportImpl#getDelimiter <em>Delimiter</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.TableToImportImpl#isDeleteMismatchedTypes <em>Delete Mismatched Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TableToImportImpl extends MinimalEObjectImpl.Container implements TableToImport {
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
	 * The default value of the '{@link #getDelimiter() <em>Delimiter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelimiter()
	 * @generated
	 * @ordered
	 */
	protected static final String DELIMITER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDelimiter() <em>Delimiter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelimiter()
	 * @generated
	 * @ordered
	 */
	protected String delimiter = DELIMITER_EDEFAULT;

	/**
	 * The default value of the '{@link #isDeleteMismatchedTypes() <em>Delete Mismatched Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeleteMismatchedTypes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DELETE_MISMATCHED_TYPES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeleteMismatchedTypes() <em>Delete Mismatched Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeleteMismatchedTypes()
	 * @generated
	 * @ordered
	 */
	protected boolean deleteMismatchedTypes = DELETE_MISMATCHED_TYPES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableToImportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExcelltsmetamodelPackage.Literals.TABLE_TO_IMPORT;
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
							ExcelltsmetamodelPackage.TABLE_TO_IMPORT__TABLE, oldTable, table));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.TABLE_TO_IMPORT__TABLE,
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.TABLE_TO_IMPORT__PATH,
					oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDelimiter() {
		return delimiter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDelimiter(String newDelimiter) {
		String oldDelimiter = delimiter;
		delimiter = newDelimiter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.TABLE_TO_IMPORT__DELIMITER,
					oldDelimiter, delimiter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDeleteMismatchedTypes() {
		return deleteMismatchedTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeleteMismatchedTypes(boolean newDeleteMismatchedTypes) {
		boolean oldDeleteMismatchedTypes = deleteMismatchedTypes;
		deleteMismatchedTypes = newDeleteMismatchedTypes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ExcelltsmetamodelPackage.TABLE_TO_IMPORT__DELETE_MISMATCHED_TYPES, oldDeleteMismatchedTypes,
					deleteMismatchedTypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ExcelltsmetamodelPackage.TABLE_TO_IMPORT__TABLE:
			if (resolve)
				return getTable();
			return basicGetTable();
		case ExcelltsmetamodelPackage.TABLE_TO_IMPORT__PATH:
			return getPath();
		case ExcelltsmetamodelPackage.TABLE_TO_IMPORT__DELIMITER:
			return getDelimiter();
		case ExcelltsmetamodelPackage.TABLE_TO_IMPORT__DELETE_MISMATCHED_TYPES:
			return isDeleteMismatchedTypes();
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
		case ExcelltsmetamodelPackage.TABLE_TO_IMPORT__TABLE:
			setTable((Table) newValue);
			return;
		case ExcelltsmetamodelPackage.TABLE_TO_IMPORT__PATH:
			setPath((String) newValue);
			return;
		case ExcelltsmetamodelPackage.TABLE_TO_IMPORT__DELIMITER:
			setDelimiter((String) newValue);
			return;
		case ExcelltsmetamodelPackage.TABLE_TO_IMPORT__DELETE_MISMATCHED_TYPES:
			setDeleteMismatchedTypes((Boolean) newValue);
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
		case ExcelltsmetamodelPackage.TABLE_TO_IMPORT__TABLE:
			setTable((Table) null);
			return;
		case ExcelltsmetamodelPackage.TABLE_TO_IMPORT__PATH:
			setPath(PATH_EDEFAULT);
			return;
		case ExcelltsmetamodelPackage.TABLE_TO_IMPORT__DELIMITER:
			setDelimiter(DELIMITER_EDEFAULT);
			return;
		case ExcelltsmetamodelPackage.TABLE_TO_IMPORT__DELETE_MISMATCHED_TYPES:
			setDeleteMismatchedTypes(DELETE_MISMATCHED_TYPES_EDEFAULT);
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
		case ExcelltsmetamodelPackage.TABLE_TO_IMPORT__TABLE:
			return table != null;
		case ExcelltsmetamodelPackage.TABLE_TO_IMPORT__PATH:
			return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
		case ExcelltsmetamodelPackage.TABLE_TO_IMPORT__DELIMITER:
			return DELIMITER_EDEFAULT == null ? delimiter != null : !DELIMITER_EDEFAULT.equals(delimiter);
		case ExcelltsmetamodelPackage.TABLE_TO_IMPORT__DELETE_MISMATCHED_TYPES:
			return deleteMismatchedTypes != DELETE_MISMATCHED_TYPES_EDEFAULT;
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
		result.append(", delimiter: ");
		result.append(delimiter);
		result.append(", deleteMismatchedTypes: ");
		result.append(deleteMismatchedTypes);
		result.append(')');
		return result.toString();
	}

} //TableToImportImpl
