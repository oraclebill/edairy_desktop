/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Unit Of Measure</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.model.ModelPackage#getUnitOfMeasure()
 * @model
 * @generated
 */
public enum UnitOfMeasure implements Enumerator {
	/**
         * The '<em><b>LITRE</b></em>' literal object.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #LITRE_VALUE
         * @generated
         * @ordered
         */
	LITRE(0, "LITRE", "LITRE"),

	/**
         * The '<em><b>KILOGRAM</b></em>' literal object.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #KILOGRAM_VALUE
         * @generated
         * @ordered
         */
	KILOGRAM(1, "KILOGRAM", "KILOGRAM"),

	/**
         * The '<em><b>UNKNOWN</b></em>' literal object.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #UNKNOWN_VALUE
         * @generated
         * @ordered
         */
	UNKNOWN(2, "UNKNOWN", "UNKNOWN");

	/**
         * The '<em><b>LITRE</b></em>' literal value.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LITRE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @see #LITRE
         * @model
         * @generated
         * @ordered
         */
	public static final int LITRE_VALUE = 0;

	/**
         * The '<em><b>KILOGRAM</b></em>' literal value.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KILOGRAM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @see #KILOGRAM
         * @model
         * @generated
         * @ordered
         */
	public static final int KILOGRAM_VALUE = 1;

	/**
         * The '<em><b>UNKNOWN</b></em>' literal value.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNKNOWN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @see #UNKNOWN
         * @model
         * @generated
         * @ordered
         */
	public static final int UNKNOWN_VALUE = 2;

	/**
         * An array of all the '<em><b>Unit Of Measure</b></em>' enumerators.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	private static final UnitOfMeasure[] VALUES_ARRAY =
		new UnitOfMeasure[] {
                        LITRE,
                        KILOGRAM,
                        UNKNOWN,
                };

	/**
         * A public read-only list of all the '<em><b>Unit Of Measure</b></em>' enumerators.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static final List<UnitOfMeasure> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
         * Returns the '<em><b>Unit Of Measure</b></em>' literal with the specified literal value.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static UnitOfMeasure get(String literal) {
                for (int i = 0; i < VALUES_ARRAY.length; ++i) {
                        UnitOfMeasure result = VALUES_ARRAY[i];
                        if (result.toString().equals(literal)) {
                                return result;
                        }
                }
                return null;
        }

	/**
         * Returns the '<em><b>Unit Of Measure</b></em>' literal with the specified name.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static UnitOfMeasure getByName(String name) {
                for (int i = 0; i < VALUES_ARRAY.length; ++i) {
                        UnitOfMeasure result = VALUES_ARRAY[i];
                        if (result.getName().equals(name)) {
                                return result;
                        }
                }
                return null;
        }

	/**
         * Returns the '<em><b>Unit Of Measure</b></em>' literal with the specified integer value.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static UnitOfMeasure get(int value) {
                switch (value) {
                        case LITRE_VALUE: return LITRE;
                        case KILOGRAM_VALUE: return KILOGRAM;
                        case UNKNOWN_VALUE: return UNKNOWN;
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
	private UnitOfMeasure(int value, String name, String literal) {
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
	
} //UnitOfMeasure
