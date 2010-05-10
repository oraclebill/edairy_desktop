/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Session</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.model.dairy.DairyPackage#getSession()
 * @model
 * @generated
 */
public enum Session implements Enumerator {
	/**
         * The '<em><b>Early Morning</b></em>' literal object.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #EARLY_MORNING_VALUE
         * @generated
         * @ordered
         */
	EARLY_MORNING(0, "EarlyMorning", "EarlyMorning"),

	/**
         * The '<em><b>Morning</b></em>' literal object.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #MORNING_VALUE
         * @generated
         * @ordered
         */
	MORNING(1, "Morning", "Morning"),

	/**
         * The '<em><b>Early Afternoon</b></em>' literal object.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #EARLY_AFTERNOON_VALUE
         * @generated
         * @ordered
         */
	EARLY_AFTERNOON(2, "EarlyAfternoon", "EarlyAfternoon"),

	/**
         * The '<em><b>Afternoon</b></em>' literal object.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #AFTERNOON_VALUE
         * @generated
         * @ordered
         */
	AFTERNOON(3, "Afternoon", "Afternoon"),

	/**
         * The '<em><b>Evening1</b></em>' literal object.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #EVENING1_VALUE
         * @generated
         * @ordered
         */
	EVENING1(4, "Evening1", "Evening1"),

	/**
         * The '<em><b>Evening2</b></em>' literal object.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #EVENING2_VALUE
         * @generated
         * @ordered
         */
	EVENING2(5, "Evening2", "Evening2");

	/**
         * The '<em><b>Early Morning</b></em>' literal value.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Early Morning</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @see #EARLY_MORNING
         * @model name="EarlyMorning"
         * @generated
         * @ordered
         */
	public static final int EARLY_MORNING_VALUE = 0;

	/**
         * The '<em><b>Morning</b></em>' literal value.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Morning</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @see #MORNING
         * @model name="Morning"
         * @generated
         * @ordered
         */
	public static final int MORNING_VALUE = 1;

	/**
         * The '<em><b>Early Afternoon</b></em>' literal value.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Early Afternoon</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @see #EARLY_AFTERNOON
         * @model name="EarlyAfternoon"
         * @generated
         * @ordered
         */
	public static final int EARLY_AFTERNOON_VALUE = 2;

	/**
         * The '<em><b>Afternoon</b></em>' literal value.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Afternoon</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @see #AFTERNOON
         * @model name="Afternoon"
         * @generated
         * @ordered
         */
	public static final int AFTERNOON_VALUE = 3;

	/**
         * The '<em><b>Evening1</b></em>' literal value.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Evening1</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @see #EVENING1
         * @model name="Evening1"
         * @generated
         * @ordered
         */
	public static final int EVENING1_VALUE = 4;

	/**
         * The '<em><b>Evening2</b></em>' literal value.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Evening2</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @see #EVENING2
         * @model name="Evening2"
         * @generated
         * @ordered
         */
	public static final int EVENING2_VALUE = 5;

	/**
         * An array of all the '<em><b>Session</b></em>' enumerators.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	private static final Session[] VALUES_ARRAY =
		new Session[] {
                        EARLY_MORNING,
                        MORNING,
                        EARLY_AFTERNOON,
                        AFTERNOON,
                        EVENING1,
                        EVENING2,
                };

	/**
         * A public read-only list of all the '<em><b>Session</b></em>' enumerators.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static final List<Session> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
         * Returns the '<em><b>Session</b></em>' literal with the specified literal value.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static Session get(String literal) {
                for (int i = 0; i < VALUES_ARRAY.length; ++i) {
                        Session result = VALUES_ARRAY[i];
                        if (result.toString().equals(literal)) {
                                return result;
                        }
                }
                return null;
        }

	/**
         * Returns the '<em><b>Session</b></em>' literal with the specified name.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static Session getByName(String name) {
                for (int i = 0; i < VALUES_ARRAY.length; ++i) {
                        Session result = VALUES_ARRAY[i];
                        if (result.getName().equals(name)) {
                                return result;
                        }
                }
                return null;
        }

	/**
         * Returns the '<em><b>Session</b></em>' literal with the specified integer value.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static Session get(int value) {
                switch (value) {
                        case EARLY_MORNING_VALUE: return EARLY_MORNING;
                        case MORNING_VALUE: return MORNING;
                        case EARLY_AFTERNOON_VALUE: return EARLY_AFTERNOON;
                        case AFTERNOON_VALUE: return AFTERNOON;
                        case EVENING1_VALUE: return EVENING1;
                        case EVENING2_VALUE: return EVENING2;
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
	private Session(int value, String name, String literal) {
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
	
} //Session
