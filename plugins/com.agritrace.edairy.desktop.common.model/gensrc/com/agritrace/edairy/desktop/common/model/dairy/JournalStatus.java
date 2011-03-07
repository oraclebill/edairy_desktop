/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Journal Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getJournalStatus()
 * @model
 * @generated
 */
public enum JournalStatus implements Enumerator {
	/**
	 * The '<em><b>NEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEW_VALUE
	 * @generated
	 * @ordered
	 */
	NEW(0, "NEW", "NEW"),

	/**
	 * The '<em><b>PENDING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PENDING_VALUE
	 * @generated
	 * @ordered
	 */
	PENDING(1, "PENDING", "PENDING"),

	/**
	 * The '<em><b>COMPLETE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPLETE_VALUE
	 * @generated
	 * @ordered
	 */
	COMPLETE(2, "COMPLETE", "COMPLETE"),

	/**
	 * The '<em><b>SUSPENDED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUSPENDED_VALUE
	 * @generated
	 * @ordered
	 */
	SUSPENDED(3, "SUSPENDED", "SUSPENDED"),

	/**
	 * The '<em><b>ARCHIVED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARCHIVED_VALUE
	 * @generated
	 * @ordered
	 */
	ARCHIVED(4, "ARCHIVED", "ARCHIVED");

	/**
	 * The '<em><b>NEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NEW_VALUE = 0;

	/**
	 * The '<em><b>PENDING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PENDING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PENDING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PENDING_VALUE = 1;

	/**
	 * The '<em><b>COMPLETE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMPLETE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPLETE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPLETE_VALUE = 2;

	/**
	 * The '<em><b>SUSPENDED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUSPENDED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUSPENDED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUSPENDED_VALUE = 3;

	/**
	 * The '<em><b>ARCHIVED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARCHIVED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARCHIVED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ARCHIVED_VALUE = 4;

	/**
	 * An array of all the '<em><b>Journal Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final JournalStatus[] VALUES_ARRAY =
		new JournalStatus[]
		{
			NEW,
			PENDING,
			COMPLETE,
			SUSPENDED,
			ARCHIVED,
		};

	/**
	 * A public read-only list of all the '<em><b>Journal Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<JournalStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Journal Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JournalStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			JournalStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Journal Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JournalStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			JournalStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Journal Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JournalStatus get(int value) {
		switch (value)
		{
			case NEW_VALUE: return NEW;
			case PENDING_VALUE: return PENDING;
			case COMPLETE_VALUE: return COMPLETE;
			case SUSPENDED_VALUE: return SUSPENDED;
			case ARCHIVED_VALUE: return ARCHIVED;
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
	private JournalStatus(int value, String name, String literal) {
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
	
} //JournalStatus
