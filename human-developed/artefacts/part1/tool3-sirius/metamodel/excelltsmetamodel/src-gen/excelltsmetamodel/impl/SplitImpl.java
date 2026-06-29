/**
 */
package excelltsmetamodel.impl;

import excelltsmetamodel.Column;
import excelltsmetamodel.ExcelltsmetamodelPackage;
import excelltsmetamodel.Split;
import excelltsmetamodel.Table;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Split</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link excelltsmetamodel.impl.SplitImpl#getSource <em>Source</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.SplitImpl#getResultColumnB <em>Result Column B</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.SplitImpl#getResultColumnA <em>Result Column A</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.SplitImpl#getDelimiter <em>Delimiter</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.SplitImpl#getNumOfChars <em>Num Of Chars</em>}</li>
 *   <li>{@link excelltsmetamodel.impl.SplitImpl#getResultTable <em>Result Table</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SplitImpl extends StringManipulationImpl implements Split {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Column source;

	/**
	 * The cached value of the '{@link #getResultColumnB() <em>Result Column B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultColumnB()
	 * @generated
	 * @ordered
	 */
	protected Column resultColumnB;

	/**
	 * The cached value of the '{@link #getResultColumnA() <em>Result Column A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultColumnA()
	 * @generated
	 * @ordered
	 */
	protected Column resultColumnA;

	/**
	 * The default value of the '{@link #getDelimiter() <em>Delimiter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelimiter()
	 * @generated
	 * @ordered
	 */
	protected static final char DELIMITER_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getDelimiter() <em>Delimiter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelimiter()
	 * @generated
	 * @ordered
	 */
	protected char delimiter = DELIMITER_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumOfChars() <em>Num Of Chars</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumOfChars()
	 * @generated
	 * @ordered
	 */
	protected static final Integer NUM_OF_CHARS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumOfChars() <em>Num Of Chars</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumOfChars()
	 * @generated
	 * @ordered
	 */
	protected Integer numOfChars = NUM_OF_CHARS_EDEFAULT;

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
	protected SplitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExcelltsmetamodelPackage.Literals.SPLIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Column getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject) source;
			source = (Column) eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExcelltsmetamodelPackage.SPLIT__SOURCE,
							oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(Column newSource) {
		Column oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.SPLIT__SOURCE, oldSource,
					source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Column getResultColumnB() {
		if (resultColumnB != null && resultColumnB.eIsProxy()) {
			InternalEObject oldResultColumnB = (InternalEObject) resultColumnB;
			resultColumnB = (Column) eResolveProxy(oldResultColumnB);
			if (resultColumnB != oldResultColumnB) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExcelltsmetamodelPackage.SPLIT__RESULT_COLUMN_B, oldResultColumnB, resultColumnB));
			}
		}
		return resultColumnB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetResultColumnB() {
		return resultColumnB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResultColumnB(Column newResultColumnB) {
		Column oldResultColumnB = resultColumnB;
		resultColumnB = newResultColumnB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.SPLIT__RESULT_COLUMN_B,
					oldResultColumnB, resultColumnB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Column getResultColumnA() {
		if (resultColumnA != null && resultColumnA.eIsProxy()) {
			InternalEObject oldResultColumnA = (InternalEObject) resultColumnA;
			resultColumnA = (Column) eResolveProxy(oldResultColumnA);
			if (resultColumnA != oldResultColumnA) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExcelltsmetamodelPackage.SPLIT__RESULT_COLUMN_A, oldResultColumnA, resultColumnA));
			}
		}
		return resultColumnA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetResultColumnA() {
		return resultColumnA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResultColumnA(Column newResultColumnA) {
		Column oldResultColumnA = resultColumnA;
		resultColumnA = newResultColumnA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.SPLIT__RESULT_COLUMN_A,
					oldResultColumnA, resultColumnA));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public char getDelimiter() {
		return delimiter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDelimiter(char newDelimiter) {
		char oldDelimiter = delimiter;
		delimiter = newDelimiter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.SPLIT__DELIMITER,
					oldDelimiter, delimiter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getNumOfChars() {
		return numOfChars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumOfChars(Integer newNumOfChars) {
		Integer oldNumOfChars = numOfChars;
		numOfChars = newNumOfChars;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.SPLIT__NUM_OF_CHARS,
					oldNumOfChars, numOfChars));
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
							ExcelltsmetamodelPackage.SPLIT__RESULT_TABLE, oldResultTable, resultTable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExcelltsmetamodelPackage.SPLIT__RESULT_TABLE,
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
		case ExcelltsmetamodelPackage.SPLIT__SOURCE:
			if (resolve)
				return getSource();
			return basicGetSource();
		case ExcelltsmetamodelPackage.SPLIT__RESULT_COLUMN_B:
			if (resolve)
				return getResultColumnB();
			return basicGetResultColumnB();
		case ExcelltsmetamodelPackage.SPLIT__RESULT_COLUMN_A:
			if (resolve)
				return getResultColumnA();
			return basicGetResultColumnA();
		case ExcelltsmetamodelPackage.SPLIT__DELIMITER:
			return getDelimiter();
		case ExcelltsmetamodelPackage.SPLIT__NUM_OF_CHARS:
			return getNumOfChars();
		case ExcelltsmetamodelPackage.SPLIT__RESULT_TABLE:
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
		case ExcelltsmetamodelPackage.SPLIT__SOURCE:
			setSource((Column) newValue);
			return;
		case ExcelltsmetamodelPackage.SPLIT__RESULT_COLUMN_B:
			setResultColumnB((Column) newValue);
			return;
		case ExcelltsmetamodelPackage.SPLIT__RESULT_COLUMN_A:
			setResultColumnA((Column) newValue);
			return;
		case ExcelltsmetamodelPackage.SPLIT__DELIMITER:
			setDelimiter((Character) newValue);
			return;
		case ExcelltsmetamodelPackage.SPLIT__NUM_OF_CHARS:
			setNumOfChars((Integer) newValue);
			return;
		case ExcelltsmetamodelPackage.SPLIT__RESULT_TABLE:
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
		case ExcelltsmetamodelPackage.SPLIT__SOURCE:
			setSource((Column) null);
			return;
		case ExcelltsmetamodelPackage.SPLIT__RESULT_COLUMN_B:
			setResultColumnB((Column) null);
			return;
		case ExcelltsmetamodelPackage.SPLIT__RESULT_COLUMN_A:
			setResultColumnA((Column) null);
			return;
		case ExcelltsmetamodelPackage.SPLIT__DELIMITER:
			setDelimiter(DELIMITER_EDEFAULT);
			return;
		case ExcelltsmetamodelPackage.SPLIT__NUM_OF_CHARS:
			setNumOfChars(NUM_OF_CHARS_EDEFAULT);
			return;
		case ExcelltsmetamodelPackage.SPLIT__RESULT_TABLE:
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
		case ExcelltsmetamodelPackage.SPLIT__SOURCE:
			return source != null;
		case ExcelltsmetamodelPackage.SPLIT__RESULT_COLUMN_B:
			return resultColumnB != null;
		case ExcelltsmetamodelPackage.SPLIT__RESULT_COLUMN_A:
			return resultColumnA != null;
		case ExcelltsmetamodelPackage.SPLIT__DELIMITER:
			return delimiter != DELIMITER_EDEFAULT;
		case ExcelltsmetamodelPackage.SPLIT__NUM_OF_CHARS:
			return NUM_OF_CHARS_EDEFAULT == null ? numOfChars != null : !NUM_OF_CHARS_EDEFAULT.equals(numOfChars);
		case ExcelltsmetamodelPackage.SPLIT__RESULT_TABLE:
			return resultTable != null;
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
		result.append(" (delimiter: ");
		result.append(delimiter);
		result.append(", numOfChars: ");
		result.append(numOfChars);
		result.append(')');
		return result.toString();
	}

} //SplitImpl
