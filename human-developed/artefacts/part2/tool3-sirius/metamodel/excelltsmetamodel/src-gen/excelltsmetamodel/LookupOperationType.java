/**
 */
package excelltsmetamodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Lookup Operation Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see excelltsmetamodel.ExcelltsmetamodelPackage#getLookupOperationType()
 * @model
 * @generated
 */
public enum LookupOperationType implements Enumerator {
	/**
	 * The '<em><b>NUMERIC SUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NUMERIC_SUM_VALUE
	 * @generated
	 * @ordered
	 */
	NUMERIC_SUM(0, "NUMERIC_SUM", "NUMERIC_SUM"),

	/**
	 * The '<em><b>NUMERIC SUBTRACT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NUMERIC_SUBTRACT_VALUE
	 * @generated
	 * @ordered
	 */
	NUMERIC_SUBTRACT(1, "NUMERIC_SUBTRACT", "NUMERIC_SUBTRACT"),

	/**
	 * The '<em><b>NUMERIC MULTIPLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NUMERIC_MULTIPLY_VALUE
	 * @generated
	 * @ordered
	 */
	NUMERIC_MULTIPLY(2, "NUMERIC_MULTIPLY", "NUMERIC_MULTIPLY"),

	/**
	 * The '<em><b>NUMERIC DIVIDE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NUMERIC_DIVIDE_VALUE
	 * @generated
	 * @ordered
	 */
	NUMERIC_DIVIDE(3, "NUMERIC_DIVIDE", "NUMERIC_DIVIDE"),

	/**
	 * The '<em><b>TEXT CONCAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEXT_CONCAT_VALUE
	 * @generated
	 * @ordered
	 */
	TEXT_CONCAT(4, "TEXT_CONCAT", "TEXT_CONCAT");

	/**
	 * The '<em><b>NUMERIC SUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NUMERIC_SUM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NUMERIC_SUM_VALUE = 0;

	/**
	 * The '<em><b>NUMERIC SUBTRACT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NUMERIC_SUBTRACT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NUMERIC_SUBTRACT_VALUE = 1;

	/**
	 * The '<em><b>NUMERIC MULTIPLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NUMERIC_MULTIPLY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NUMERIC_MULTIPLY_VALUE = 2;

	/**
	 * The '<em><b>NUMERIC DIVIDE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NUMERIC_DIVIDE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NUMERIC_DIVIDE_VALUE = 3;

	/**
	 * The '<em><b>TEXT CONCAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEXT_CONCAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEXT_CONCAT_VALUE = 4;

	/**
	 * An array of all the '<em><b>Lookup Operation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final LookupOperationType[] VALUES_ARRAY = new LookupOperationType[] { NUMERIC_SUM, NUMERIC_SUBTRACT,
			NUMERIC_MULTIPLY, NUMERIC_DIVIDE, TEXT_CONCAT, };

	/**
	 * A public read-only list of all the '<em><b>Lookup Operation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<LookupOperationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Lookup Operation Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static LookupOperationType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LookupOperationType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Lookup Operation Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static LookupOperationType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LookupOperationType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Lookup Operation Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static LookupOperationType get(int value) {
		switch (value) {
		case NUMERIC_SUM_VALUE:
			return NUMERIC_SUM;
		case NUMERIC_SUBTRACT_VALUE:
			return NUMERIC_SUBTRACT;
		case NUMERIC_MULTIPLY_VALUE:
			return NUMERIC_MULTIPLY;
		case NUMERIC_DIVIDE_VALUE:
			return NUMERIC_DIVIDE;
		case TEXT_CONCAT_VALUE:
			return TEXT_CONCAT;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private LookupOperationType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //LookupOperationType
