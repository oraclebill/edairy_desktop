/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Contact Method Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getContactMethodType()
 * @model
 * @generated
 */
public enum ContactMethodType implements Enumerator {
	/**
	 * The '<em><b>EMAIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EMAIL_VALUE
	 * @generated
	 * @ordered
	 */
	EMAIL(0, "EMAIL", "EMAIL"),

	/**
	 * The '<em><b>SMS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SMS_VALUE
	 * @generated
	 * @ordered
	 */
	SMS(1, "SMS", "SMS"),

	/**
	 * The '<em><b>PHONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PHONE_VALUE
	 * @generated
	 * @ordered
	 */
	PHONE(2, "PHONE", "PHONE"),

	/**
	 * The '<em><b>FAX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAX_VALUE
	 * @generated
	 * @ordered
	 */
	FAX(3, "FAX", "FAX"),

	/**
	 * The '<em><b>IM AIM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IM_AIM_VALUE
	 * @generated
	 * @ordered
	 */
	IM_AIM(4, "IM_AIM", "IM_AIM"),

	/**
	 * The '<em><b>IM SKYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IM_SKYPE_VALUE
	 * @generated
	 * @ordered
	 */
	IM_SKYPE(5, "IM_SKYPE", "IM_SKYPE"),

	/**
	 * The '<em><b>IM MSN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IM_MSN_VALUE
	 * @generated
	 * @ordered
	 */
	IM_MSN(6, "IM_MSN", "IM_MSN"),

	/**
	 * The '<em><b>IM GTALK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IM_GTALK_VALUE
	 * @generated
	 * @ordered
	 */
	IM_GTALK(7, "IM_GTALK", "IM_GTALK"),

	/**
	 * The '<em><b>IM YAHOO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IM_YAHOO_VALUE
	 * @generated
	 * @ordered
	 */
	IM_YAHOO(8, "IM_YAHOO", "IM_YAHOO"),

	/**
	 * The '<em><b>IM OTHER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IM_OTHER_VALUE
	 * @generated
	 * @ordered
	 */
	IM_OTHER(9, "IM_OTHER", "IM_OTHER"),

	/**
	 * The '<em><b>OTHER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OTHER_VALUE
	 * @generated
	 * @ordered
	 */
	OTHER(10, "OTHER", "OTHER");

	/**
	 * The '<em><b>EMAIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EMAIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EMAIL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EMAIL_VALUE = 0;

	/**
	 * The '<em><b>SMS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SMS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SMS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SMS_VALUE = 1;

	/**
	 * The '<em><b>PHONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PHONE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PHONE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PHONE_VALUE = 2;

	/**
	 * The '<em><b>FAX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FAX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FAX
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FAX_VALUE = 3;

	/**
	 * The '<em><b>IM AIM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IM AIM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IM_AIM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IM_AIM_VALUE = 4;

	/**
	 * The '<em><b>IM SKYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IM SKYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IM_SKYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IM_SKYPE_VALUE = 5;

	/**
	 * The '<em><b>IM MSN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IM MSN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IM_MSN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IM_MSN_VALUE = 6;

	/**
	 * The '<em><b>IM GTALK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IM GTALK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IM_GTALK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IM_GTALK_VALUE = 7;

	/**
	 * The '<em><b>IM YAHOO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IM YAHOO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IM_YAHOO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IM_YAHOO_VALUE = 8;

	/**
	 * The '<em><b>IM OTHER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IM OTHER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IM_OTHER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IM_OTHER_VALUE = 9;

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
	public static final int OTHER_VALUE = 10;

	/**
	 * An array of all the '<em><b>Contact Method Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ContactMethodType[] VALUES_ARRAY =
		new ContactMethodType[]
		{
			EMAIL,
			SMS,
			PHONE,
			FAX,
			IM_AIM,
			IM_SKYPE,
			IM_MSN,
			IM_GTALK,
			IM_YAHOO,
			IM_OTHER,
			OTHER,
		};

	/**
	 * A public read-only list of all the '<em><b>Contact Method Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ContactMethodType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Contact Method Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContactMethodType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			ContactMethodType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Contact Method Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContactMethodType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			ContactMethodType result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Contact Method Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContactMethodType get(int value) {
		switch (value)
		{
			case EMAIL_VALUE: return EMAIL;
			case SMS_VALUE: return SMS;
			case PHONE_VALUE: return PHONE;
			case FAX_VALUE: return FAX;
			case IM_AIM_VALUE: return IM_AIM;
			case IM_SKYPE_VALUE: return IM_SKYPE;
			case IM_MSN_VALUE: return IM_MSN;
			case IM_GTALK_VALUE: return IM_GTALK;
			case IM_YAHOO_VALUE: return IM_YAHOO;
			case IM_OTHER_VALUE: return IM_OTHER;
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
	private ContactMethodType(int value, String name, String literal) {
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
	
} //ContactMethodType
