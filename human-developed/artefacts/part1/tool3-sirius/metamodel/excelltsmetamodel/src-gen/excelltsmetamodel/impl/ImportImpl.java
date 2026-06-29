/**
 */
package excelltsmetamodel.impl;

import excelltsmetamodel.ExcelltsmetamodelPackage;
import excelltsmetamodel.Import;
import excelltsmetamodel.TableToImport;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.impl.ImportImpl#getTablesToImport <em>Tables To Import</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImportImpl extends FlowStepImpl implements Import {
	/**
	 * The cached value of the '{@link #getTablesToImport() <em>Tables To Import</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTablesToImport()
	 * @generated
	 * @ordered
	 */
	protected EList<TableToImport> tablesToImport;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExcelltsmetamodelPackage.Literals.IMPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TableToImport> getTablesToImport() {
		if (tablesToImport == null) {
			tablesToImport = new EObjectContainmentEList<TableToImport>(TableToImport.class, this,
					ExcelltsmetamodelPackage.IMPORT__TABLES_TO_IMPORT);
		}
		return tablesToImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ExcelltsmetamodelPackage.IMPORT__TABLES_TO_IMPORT:
			return ((InternalEList<?>) getTablesToImport()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ExcelltsmetamodelPackage.IMPORT__TABLES_TO_IMPORT:
			return getTablesToImport();
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
		case ExcelltsmetamodelPackage.IMPORT__TABLES_TO_IMPORT:
			getTablesToImport().clear();
			getTablesToImport().addAll((Collection<? extends TableToImport>) newValue);
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
		case ExcelltsmetamodelPackage.IMPORT__TABLES_TO_IMPORT:
			getTablesToImport().clear();
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
		case ExcelltsmetamodelPackage.IMPORT__TABLES_TO_IMPORT:
			return tablesToImport != null && !tablesToImport.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ImportImpl
