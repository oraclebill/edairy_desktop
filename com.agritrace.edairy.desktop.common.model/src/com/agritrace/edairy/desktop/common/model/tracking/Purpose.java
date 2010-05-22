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
 * A representation of the literals of the enumeration '<em><b>Purpose</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getPurpose()
 * @model
 * @generated
 */
public enum Purpose implements Enumerator {
	/**
         * The '<em><b>DAIRY</b></em>' literal object.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #DAIRY_VALUE
         * @generated
         * @ordered
         */
	DAIRY(0, "DAIRY", "DAIRY"),

	/**
         * The '<em><b>BEEF</b></em>' literal object.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #BEEF_VALUE
         * @generated
         * @ordered
         */
	BEEF(1, "BEEF", "BEEF"),

	/**
         * The '<em><b>BREEDING</b></em>' literal object.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #BREEDING_VALUE
         * @generated
         * @ordered
         */
	BREEDING(2, "BREEDING", "BREEDING"),

	/**
         * The '<em><b>HIDE</b></em>' literal object.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #HIDE_VALUE
         * @generated
         * @ordered
         */
	HIDE(3, "HIDE", "HIDE"),

	/**
         * The '<em><b>TRANSPORT</b></em>' literal object.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #TRANSPORT_VALUE
         * @generated
         * @ordered
         */
	TRANSPORT(4, "TRANSPORT", "TRANSPORT"),

	/**
         * The '<em><b>OTHER</b></em>' literal object.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #OTHER_VALUE
         * @generated
         * @ordered
         */
	OTHER(5, "OTHER", "OTHER");

	/**
         * The '<em><b>DAIRY</b></em>' literal value.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DAIRY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @see #DAIRY
         * @model
         * @generated
         * @ordered
         */
	public static final int DAIRY_VALUE = 0;

	/**
         * The '<em><b>BEEF</b></em>' literal value.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BEEF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @see #BEEF
         * @model
         * @generated
         * @ordered
         */
	public static final int BEEF_VALUE = 1;

	/**
         * The '<em><b>BREEDING</b></em>' literal value.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BREEDING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @see #BREEDING
         * @model
         * @generated
         * @ordered
         */
	public static final int BREEDING_VALUE = 2;

	/**
         * The '<em><b>HIDE</b></em>' literal value.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HIDE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @see #HIDE
         * @model
         * @generated
         * @ordered
         */
	public static final int HIDE_VALUE = 3;

	/**
         * The '<em><b>TRANSPORT</b></em>' literal value.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRANSPORT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @see #TRANSPORT
         * @model
         * @generated
         * @ordered
         */
	public static final int TRANSPORT_VALUE = 4;

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
	public static final int OTHER_VALUE = 5;

	/**
         * An array of all the '<em><b>Purpose</b></em>' enumerators.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	private static final Purpose[] VALUES_ARRAY =
		new Purpose[] {
                        DAIRY,
                        BEEF,
                        BREEDING,
                        HIDE,
                        TRANSPORT,
                        OTHER,
                };

	/**
         * A public read-only list of all the '<em><b>Purpose</b></em>' enumerators.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static final List<Purpose> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
         * Returns the '<em><b>Purpose</b></em>' literal with the specified literal value.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static Purpose get(String literal) {
                for (int i = 0; i < VALUES_ARRAY.length; ++i) {
                        Purpose result = VALUES_ARRAY[i];
                        if (result.toString().equals(literal)) {
                                return result;
                        }
                }
                return null;
        }

	/**
         * Returns the '<em><b>Purpose</b></em>' literal with the specified name.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static Purpose getByName(String name) {
                for (int i = 0; i < VALUES_ARRAY.length; ++i) {
                        Purpose result = VALUES_ARRAY[i];
                        if (result.getName().equals(name)) {
                                return result;
                        }
                }
                return null;
        }

	/**
         * Returns the '<em><b>Purpose</b></em>' literal with the specified integer value.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static Purpose get(int value) {
                switch (value) {
                        case DAIRY_VALUE: return DAIRY;
                        case BEEF_VALUE: return BEEF;
                        case BREEDING_VALUE: return BREEDING;
                        case HIDE_VALUE: return HIDE;
                        case TRANSPORT_VALUE: return TRANSPORT;
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
	private Purpose(int value, String name, String literal) {
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
	
} //Purpose
