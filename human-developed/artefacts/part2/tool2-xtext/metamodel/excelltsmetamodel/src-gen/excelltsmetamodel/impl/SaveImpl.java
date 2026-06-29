/**
 */
package excelltsmetamodel.impl;

import excelltsmetamodel.ExcelltsmetamodelPackage;
import excelltsmetamodel.Save;
import excelltsmetamodel.TableToSave;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Save</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.impl.SaveImpl#getTablesToSave <em>Tables To Save</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SaveImpl extends FinalStepImpl implements Save {
	/**
	 * The cached value of the '{@link #getTablesToSave() <em>Tables To Save</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTablesToSave()
	 * @generated
	 * @ordered
	 */
	protected EList<TableToSave> tablesToSave;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExcelltsmetamodelPackage.Literals.SAVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TableToSave> getTablesToSave() {
		if (tablesToSave == null) {
			tablesToSave = new EObjectContainmentEList<TableToSave>(TableToSave.class, this,
					ExcelltsmetamodelPackage.SAVE__TABLES_TO_SAVE);
		}
		return tablesToSave;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ExcelltsmetamodelPackage.SAVE__TABLES_TO_SAVE:
			return ((InternalEList<?>) getTablesToSave()).basicRemove(otherEnd, msgs);
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
		case ExcelltsmetamodelPackage.SAVE__TABLES_TO_SAVE:
			return getTablesToSave();
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
		case ExcelltsmetamodelPackage.SAVE__TABLES_TO_SAVE:
			getTablesToSave().clear();
			getTablesToSave().addAll((Collection<? extends TableToSave>) newValue);
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
		case ExcelltsmetamodelPackage.SAVE__TABLES_TO_SAVE:
			getTablesToSave().clear();
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
		case ExcelltsmetamodelPackage.SAVE__TABLES_TO_SAVE:
			return tablesToSave != null && !tablesToSave.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SaveImpl
