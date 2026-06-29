/**
 */
package excelltsmetamodel.impl;

import excelltsmetamodel.Column;
import excelltsmetamodel.ExcelltsmetamodelPackage;
import excelltsmetamodel.Extract;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extract</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.impl.ExtractImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.ExtractImpl#getLbChar <em>Lb Char</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.ExtractImpl#getUbChar <em>Ub Char</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.ExtractImpl#getPattern <em>Pattern</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExtractImpl extends StringManipulationImpl implements Extract {
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
	 * The default value of the '{@link #getLbChar() <em>Lb Char</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLbChar()
	 * @generated
	 * @ordered
	 */
	protected static final Integer LB_CHAR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLbChar() <em>Lb Char</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLbChar()
	 * @generated
	 * @ordered
	 */
	protected Integer lbChar = LB_CHAR_EDEFAULT;

	/**
	 * The default value of the '{@link #getUbChar() <em>Ub Char</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUbChar()
	 * @generated
	 * @ordered
	 */
	protected static final Integer UB_CHAR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUbChar() <em>Ub Char</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUbChar()
	 * @generated
	 * @ordered
	 */
	protected Integer ubChar = UB_CHAR_EDEFAULT;

	/**
	 * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected String pattern = PATTERN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtractImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExcelltsmetamodelPackage.Literals.EXTRACT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExcelltsmetamodelPackage.EXTRACT__COLUMN,
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.EXTRACT__COLUMN, oldColumn,
					column));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getLbChar() {
		return lbChar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLbChar(Integer newLbChar) {
		Integer oldLbChar = lbChar;
		lbChar = newLbChar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.EXTRACT__LB_CHAR, oldLbChar,
					lbChar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getUbChar() {
		return ubChar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUbChar(Integer newUbChar) {
		Integer oldUbChar = ubChar;
		ubChar = newUbChar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.EXTRACT__UB_CHAR, oldUbChar,
					ubChar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPattern(String newPattern) {
		String oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.EXTRACT__PATTERN, oldPattern,
					pattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ExcelltsmetamodelPackage.EXTRACT__COLUMN:
			if (resolve)
				return getColumn();
			return basicGetColumn();
		case ExcelltsmetamodelPackage.EXTRACT__LB_CHAR:
			return getLbChar();
		case ExcelltsmetamodelPackage.EXTRACT__UB_CHAR:
			return getUbChar();
		case ExcelltsmetamodelPackage.EXTRACT__PATTERN:
			return getPattern();
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
		case ExcelltsmetamodelPackage.EXTRACT__COLUMN:
			setColumn((Column) newValue);
			return;
		case ExcelltsmetamodelPackage.EXTRACT__LB_CHAR:
			setLbChar((Integer) newValue);
			return;
		case ExcelltsmetamodelPackage.EXTRACT__UB_CHAR:
			setUbChar((Integer) newValue);
			return;
		case ExcelltsmetamodelPackage.EXTRACT__PATTERN:
			setPattern((String) newValue);
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
		case ExcelltsmetamodelPackage.EXTRACT__COLUMN:
			setColumn((Column) null);
			return;
		case ExcelltsmetamodelPackage.EXTRACT__LB_CHAR:
			setLbChar(LB_CHAR_EDEFAULT);
			return;
		case ExcelltsmetamodelPackage.EXTRACT__UB_CHAR:
			setUbChar(UB_CHAR_EDEFAULT);
			return;
		case ExcelltsmetamodelPackage.EXTRACT__PATTERN:
			setPattern(PATTERN_EDEFAULT);
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
		case ExcelltsmetamodelPackage.EXTRACT__COLUMN:
			return column != null;
		case ExcelltsmetamodelPackage.EXTRACT__LB_CHAR:
			return LB_CHAR_EDEFAULT == null ? lbChar != null : !LB_CHAR_EDEFAULT.equals(lbChar);
		case ExcelltsmetamodelPackage.EXTRACT__UB_CHAR:
			return UB_CHAR_EDEFAULT == null ? ubChar != null : !UB_CHAR_EDEFAULT.equals(ubChar);
		case ExcelltsmetamodelPackage.EXTRACT__PATTERN:
			return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals(pattern);
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
		result.append(" (lbChar: ");
		result.append(lbChar);
		result.append(", ubChar: ");
		result.append(ubChar);
		result.append(", pattern: ");
		result.append(pattern);
		result.append(')');
		return result.toString();
	}

} //ExtractImpl
