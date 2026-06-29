/**
 */
package excelltsmetamodel.impl;

import excelltsmetamodel.AppendRows;
import excelltsmetamodel.Association;
import excelltsmetamodel.ExcelltsmetamodelPackage;
import excelltsmetamodel.Table;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Append Rows</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.impl.AppendRowsImpl#getOriginTable <em>Origin Table</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.AppendRowsImpl#getDestinTable <em>Destin Table</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.AppendRowsImpl#getAssociations <em>Associations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AppendRowsImpl extends FlowStepImpl implements AppendRows {
	/**
	 * The cached value of the '{@link #getOriginTable() <em>Origin Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginTable()
	 * @generated
	 * @ordered
	 */
	protected Table originTable;

	/**
	 * The cached value of the '{@link #getDestinTable() <em>Destin Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinTable()
	 * @generated
	 * @ordered
	 */
	protected Table destinTable;

	/**
	 * The cached value of the '{@link #getAssociations() <em>Associations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> associations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AppendRowsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExcelltsmetamodelPackage.Literals.APPEND_ROWS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Table getOriginTable() {
		if (originTable != null && originTable.eIsProxy()) {
			InternalEObject oldOriginTable = (InternalEObject) originTable;
			originTable = (Table) eResolveProxy(oldOriginTable);
			if (originTable != oldOriginTable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExcelltsmetamodelPackage.APPEND_ROWS__ORIGIN_TABLE, oldOriginTable, originTable));
			}
		}
		return originTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table basicGetOriginTable() {
		return originTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOriginTable(Table newOriginTable) {
		Table oldOriginTable = originTable;
		originTable = newOriginTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.APPEND_ROWS__ORIGIN_TABLE,
					oldOriginTable, originTable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Table getDestinTable() {
		if (destinTable != null && destinTable.eIsProxy()) {
			InternalEObject oldDestinTable = (InternalEObject) destinTable;
			destinTable = (Table) eResolveProxy(oldDestinTable);
			if (destinTable != oldDestinTable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExcelltsmetamodelPackage.APPEND_ROWS__DESTIN_TABLE, oldDestinTable, destinTable));
			}
		}
		return destinTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table basicGetDestinTable() {
		return destinTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDestinTable(Table newDestinTable) {
		Table oldDestinTable = destinTable;
		destinTable = newDestinTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.APPEND_ROWS__DESTIN_TABLE,
					oldDestinTable, destinTable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Association> getAssociations() {
		if (associations == null) {
			associations = new EObjectContainmentEList<Association>(Association.class, this,
					ExcelltsmetamodelPackage.APPEND_ROWS__ASSOCIATIONS);
		}
		return associations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ExcelltsmetamodelPackage.APPEND_ROWS__ASSOCIATIONS:
			return ((InternalEList<?>) getAssociations()).basicRemove(otherEnd, msgs);
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
		case ExcelltsmetamodelPackage.APPEND_ROWS__ORIGIN_TABLE:
			if (resolve)
				return getOriginTable();
			return basicGetOriginTable();
		case ExcelltsmetamodelPackage.APPEND_ROWS__DESTIN_TABLE:
			if (resolve)
				return getDestinTable();
			return basicGetDestinTable();
		case ExcelltsmetamodelPackage.APPEND_ROWS__ASSOCIATIONS:
			return getAssociations();
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
		case ExcelltsmetamodelPackage.APPEND_ROWS__ORIGIN_TABLE:
			setOriginTable((Table) newValue);
			return;
		case ExcelltsmetamodelPackage.APPEND_ROWS__DESTIN_TABLE:
			setDestinTable((Table) newValue);
			return;
		case ExcelltsmetamodelPackage.APPEND_ROWS__ASSOCIATIONS:
			getAssociations().clear();
			getAssociations().addAll((Collection<? extends Association>) newValue);
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
		case ExcelltsmetamodelPackage.APPEND_ROWS__ORIGIN_TABLE:
			setOriginTable((Table) null);
			return;
		case ExcelltsmetamodelPackage.APPEND_ROWS__DESTIN_TABLE:
			setDestinTable((Table) null);
			return;
		case ExcelltsmetamodelPackage.APPEND_ROWS__ASSOCIATIONS:
			getAssociations().clear();
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
		case ExcelltsmetamodelPackage.APPEND_ROWS__ORIGIN_TABLE:
			return originTable != null;
		case ExcelltsmetamodelPackage.APPEND_ROWS__DESTIN_TABLE:
			return destinTable != null;
		case ExcelltsmetamodelPackage.APPEND_ROWS__ASSOCIATIONS:
			return associations != null && !associations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AppendRowsImpl
