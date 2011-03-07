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
 * A representation of the literals of the enumeration '<em><b>Collection Group Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCollectionGroupType()
 * @model
 * @generated
 */
public enum CollectionGroupType implements Enumerator {
	/**
	 * The '<em><b>Scale Group</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCALE_GROUP_VALUE
	 * @generated
	 * @ordered
	 */
	SCALE_GROUP(0, "ScaleGroup", "ScaleGroup"),

	/**
	 * The '<em><b>Journal Group</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOURNAL_GROUP_VALUE
	 * @generated
	 * @ordered
	 */
	JOURNAL_GROUP(1, "JournalGroup", "JournalGroup");

	/**
	 * The '<em><b>Scale Group</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Scale Group</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCALE_GROUP
	 * @model name="ScaleGroup"
	 * @generated
	 * @ordered
	 */
	public static final int SCALE_GROUP_VALUE = 0;

	/**
	 * The '<em><b>Journal Group</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Journal Group</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JOURNAL_GROUP
	 * @model name="JournalGroup"
	 * @generated
	 * @ordered
	 */
	public static final int JOURNAL_GROUP_VALUE = 1;

	/**
	 * An array of all the '<em><b>Collection Group Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CollectionGroupType[] VALUES_ARRAY =
		new CollectionGroupType[]
		{
			SCALE_GROUP,
			JOURNAL_GROUP,
		};

	/**
	 * A public read-only list of all the '<em><b>Collection Group Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CollectionGroupType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Collection Group Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CollectionGroupType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			CollectionGroupType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Collection Group Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CollectionGroupType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			CollectionGroupType result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Collection Group Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CollectionGroupType get(int value) {
		switch (value)
		{
			case SCALE_GROUP_VALUE: return SCALE_GROUP;
			case JOURNAL_GROUP_VALUE: return JOURNAL_GROUP;
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
	private CollectionGroupType(int value, String name, String literal) {
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
	
} //CollectionGroupType
