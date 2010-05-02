/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package requests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Request Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see requests.RequestsPackage#getRequestType()
 * @model
 * @generated
 */
public enum RequestType implements Enumerator {
	/**
	 * The '<em><b>Veterinary</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VETERINARY_VALUE
	 * @generated
	 * @ordered
	 */
	VETERINARY(0, "Veterinary", "Veterinary"),

	/**
	 * The '<em><b>Insemination</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSEMINATION_VALUE
	 * @generated
	 * @ordered
	 */
	INSEMINATION(1, "Insemination", "Insemination");

	/**
	 * The '<em><b>Veterinary</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Veterinary</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VETERINARY
	 * @model name="Veterinary"
	 * @generated
	 * @ordered
	 */
	public static final int VETERINARY_VALUE = 0;

	/**
	 * The '<em><b>Insemination</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Insemination</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSEMINATION
	 * @model name="Insemination"
	 * @generated
	 * @ordered
	 */
	public static final int INSEMINATION_VALUE = 1;

	/**
	 * An array of all the '<em><b>Request Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RequestType[] VALUES_ARRAY =
		new RequestType[] {
			VETERINARY,
			INSEMINATION,
		};

	/**
	 * A public read-only list of all the '<em><b>Request Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RequestType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Request Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RequestType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RequestType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Request Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RequestType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RequestType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Request Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RequestType get(int value) {
		switch (value) {
			case VETERINARY_VALUE: return VETERINARY;
			case INSEMINATION_VALUE: return INSEMINATION;
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
	private RequestType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	
} //RequestType
