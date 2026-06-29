/**
 */
package excelltsmetamodel.impl;

import excelltsmetamodel.Association;
import excelltsmetamodel.Column;
import excelltsmetamodel.ExcelltsmetamodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.impl.AssociationImpl#getOriginCol <em>Origin Col</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.AssociationImpl#getDestinCol <em>Destin Col</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssociationImpl extends MinimalEObjectImpl.Container implements Association {
	/**
	 * The cached value of the '{@link #getOriginCol() <em>Origin Col</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginCol()
	 * @generated
	 * @ordered
	 */
	protected Column originCol;

	/**
	 * The cached value of the '{@link #getDestinCol() <em>Destin Col</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinCol()
	 * @generated
	 * @ordered
	 */
	protected Column destinCol;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExcelltsmetamodelPackage.Literals.ASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Column getOriginCol() {
		if (originCol != null && originCol.eIsProxy()) {
			InternalEObject oldOriginCol = (InternalEObject) originCol;
			originCol = (Column) eResolveProxy(oldOriginCol);
			if (originCol != oldOriginCol) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExcelltsmetamodelPackage.ASSOCIATION__ORIGIN_COL, oldOriginCol, originCol));
			}
		}
		return originCol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetOriginCol() {
		return originCol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOriginCol(Column newOriginCol) {
		Column oldOriginCol = originCol;
		originCol = newOriginCol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.ASSOCIATION__ORIGIN_COL,
					oldOriginCol, originCol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Column getDestinCol() {
		if (destinCol != null && destinCol.eIsProxy()) {
			InternalEObject oldDestinCol = (InternalEObject) destinCol;
			destinCol = (Column) eResolveProxy(oldDestinCol);
			if (destinCol != oldDestinCol) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExcelltsmetamodelPackage.ASSOCIATION__DESTIN_COL, oldDestinCol, destinCol));
			}
		}
		return destinCol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetDestinCol() {
		return destinCol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDestinCol(Column newDestinCol) {
		Column oldDestinCol = destinCol;
		destinCol = newDestinCol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.ASSOCIATION__DESTIN_COL,
					oldDestinCol, destinCol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ExcelltsmetamodelPackage.ASSOCIATION__ORIGIN_COL:
			if (resolve)
				return getOriginCol();
			return basicGetOriginCol();
		case ExcelltsmetamodelPackage.ASSOCIATION__DESTIN_COL:
			if (resolve)
				return getDestinCol();
			return basicGetDestinCol();
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
		case ExcelltsmetamodelPackage.ASSOCIATION__ORIGIN_COL:
			setOriginCol((Column) newValue);
			return;
		case ExcelltsmetamodelPackage.ASSOCIATION__DESTIN_COL:
			setDestinCol((Column) newValue);
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
		case ExcelltsmetamodelPackage.ASSOCIATION__ORIGIN_COL:
			setOriginCol((Column) null);
			return;
		case ExcelltsmetamodelPackage.ASSOCIATION__DESTIN_COL:
			setDestinCol((Column) null);
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
		case ExcelltsmetamodelPackage.ASSOCIATION__ORIGIN_COL:
			return originCol != null;
		case ExcelltsmetamodelPackage.ASSOCIATION__DESTIN_COL:
			return destinCol != null;
		}
		return super.eIsSet(featureID);
	}

} //AssociationImpl
