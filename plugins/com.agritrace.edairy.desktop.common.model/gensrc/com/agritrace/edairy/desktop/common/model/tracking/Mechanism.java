/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.tracking;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Mechanism</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getMechanism()
 * @model
 * @generated
 */
public enum Mechanism implements Enumerator {
	/**
	 * The '<em><b>BRAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRAND_VALUE
	 * @generated
	 * @ordered
	 */
	BRAND(0, "BRAND", "BRAND"),

	/**
	 * The '<em><b>BADGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BADGE_VALUE
	 * @generated
	 * @ordered
	 */
	BADGE(1, "BADGE", "BADGE"),

	/**
	 * The '<em><b>COLLAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLLAR_VALUE
	 * @generated
	 * @ordered
	 */
	COLLAR(2, "COLLAR", "COLLAR"),

	/**
	 * The '<em><b>EARTAG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EARTAG_VALUE
	 * @generated
	 * @ordered
	 */
	EARTAG(3, "EARTAG", "EARTAG"),

	/**
	 * The '<em><b>RFID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RFID_VALUE
	 * @generated
	 * @ordered
	 */
	RFID(4, "RFID", "RFID"),

	/**
	 * The '<em><b>GSMGPRS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GSMGPRS_VALUE
	 * @generated
	 * @ordered
	 */
	GSMGPRS(5, "GSMGPRS", "GSMGPRS"),

	/**
	 * The '<em><b>OTHER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OTHER_VALUE
	 * @generated
	 * @ordered
	 */
	OTHER(6, "OTHER", "OTHER");

	/**
	 * The '<em><b>BRAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BRAND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BRAND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BRAND_VALUE = 0;

	/**
	 * The '<em><b>BADGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BADGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BADGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BADGE_VALUE = 1;

	/**
	 * The '<em><b>COLLAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COLLAR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COLLAR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COLLAR_VALUE = 2;

	/**
	 * The '<em><b>EARTAG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EARTAG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EARTAG
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EARTAG_VALUE = 3;

	/**
	 * The '<em><b>RFID</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RFID</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RFID
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RFID_VALUE = 4;

	/**
	 * The '<em><b>GSMGPRS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GSMGPRS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GSMGPRS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GSMGPRS_VALUE = 5;

	/**
	 * The '<em><b>OTHER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OTHER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OTHER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OTHER_VALUE = 6;

	/**
	 * An array of all the '<em><b>Mechanism</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Mechanism[] VALUES_ARRAY =
		new Mechanism[]
		{
			BRAND,
			BADGE,
			COLLAR,
			EARTAG,
			RFID,
			GSMGPRS,
			OTHER,
		};

	/**
	 * A public read-only list of all the '<em><b>Mechanism</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Mechanism> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Mechanism</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Mechanism get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			Mechanism result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Mechanism</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Mechanism getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			Mechanism result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Mechanism</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Mechanism get(int value) {
		switch (value)
		{
			case BRAND_VALUE: return BRAND;
			case BADGE_VALUE: return BADGE;
			case COLLAR_VALUE: return COLLAR;
			case EARTAG_VALUE: return EARTAG;
			case RFID_VALUE: return RFID;
			case GSMGPRS_VALUE: return GSMGPRS;
			case OTHER_VALUE: return OTHER;
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
	private Mechanism(int value, String name, String literal) {
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
	
} //Mechanism
