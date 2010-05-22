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
 * A representation of the literals of the enumeration '<em><b>Acquisition Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getAcquisitionType()
 * @model
 * @generated
 */
public enum AcquisitionType implements Enumerator {
	/**
         * The '<em><b>BIRTH</b></em>' literal object.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #BIRTH_VALUE
         * @generated
         * @ordered
         */
	BIRTH(0, "BIRTH", "BIRTH"),

	/**
         * The '<em><b>PURCHASE</b></em>' literal object.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #PURCHASE_VALUE
         * @generated
         * @ordered
         */
	PURCHASE(1, "PURCHASE", "PURCHASE"),

	/**
         * The '<em><b>OTHER</b></em>' literal object.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #OTHER_VALUE
         * @generated
         * @ordered
         */
	OTHER(2, "OTHER", "OTHER");

	/**
         * The '<em><b>BIRTH</b></em>' literal value.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BIRTH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @see #BIRTH
         * @model
         * @generated
         * @ordered
         */
	public static final int BIRTH_VALUE = 0;

	/**
         * The '<em><b>PURCHASE</b></em>' literal value.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PURCHASE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @see #PURCHASE
         * @model
         * @generated
         * @ordered
         */
	public static final int PURCHASE_VALUE = 1;

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
	public static final int OTHER_VALUE = 2;

	/**
         * An array of all the '<em><b>Acquisition Type</b></em>' enumerators.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	private static final AcquisitionType[] VALUES_ARRAY =
		new AcquisitionType[] {
                        BIRTH,
                        PURCHASE,
                        OTHER,
                };

	/**
         * A public read-only list of all the '<em><b>Acquisition Type</b></em>' enumerators.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static final List<AcquisitionType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
         * Returns the '<em><b>Acquisition Type</b></em>' literal with the specified literal value.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static AcquisitionType get(String literal) {
                for (int i = 0; i < VALUES_ARRAY.length; ++i) {
                        AcquisitionType result = VALUES_ARRAY[i];
                        if (result.toString().equals(literal)) {
                                return result;
                        }
                }
                return null;
        }

	/**
         * Returns the '<em><b>Acquisition Type</b></em>' literal with the specified name.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static AcquisitionType getByName(String name) {
                for (int i = 0; i < VALUES_ARRAY.length; ++i) {
                        AcquisitionType result = VALUES_ARRAY[i];
                        if (result.getName().equals(name)) {
                                return result;
                        }
                }
                return null;
        }

	/**
         * Returns the '<em><b>Acquisition Type</b></em>' literal with the specified integer value.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static AcquisitionType get(int value) {
                switch (value) {
                        case BIRTH_VALUE: return BIRTH;
                        case PURCHASE_VALUE: return PURCHASE;
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
	private AcquisitionType(int value, String name, String literal) {
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
	
} //AcquisitionType
