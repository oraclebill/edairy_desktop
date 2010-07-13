/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.account;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Transaction Source</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getTransactionSource()
 * @model
 * @generated
 */
public enum TransactionSource implements Enumerator {
	/**
	 * The '<em><b>Store Credit</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORE_CREDIT_VALUE
	 * @generated
	 * @ordered
	 */
	STORE_CREDIT(0, "StoreCredit", "STORE_CREDIT"),

	/**
	 * The '<em><b>Clinical Services</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLINICAL_SERVICES_VALUE
	 * @generated
	 * @ordered
	 */
	CLINICAL_SERVICES(1, "ClinicalServices", "CLINICAL_SERVICES"),

	/**
	 * The '<em><b>Share Recovery</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHARE_RECOVERY_VALUE
	 * @generated
	 * @ordered
	 */
	SHARE_RECOVERY(2, "ShareRecovery", "SHARE_RECOVERY"),

	/**
	 * The '<em><b>Cash Payment</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CASH_PAYMENT_VALUE
	 * @generated
	 * @ordered
	 */
	CASH_PAYMENT(3, "CashPayment", "CASH_PAYMENT"),

	/**
	 * The '<em><b>Other</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OTHER_VALUE
	 * @generated
	 * @ordered
	 */
	OTHER(4, "Other", "OTHER");

	/**
	 * The '<em><b>Store Credit</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Store Credit</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STORE_CREDIT
	 * @model name="StoreCredit" literal="STORE_CREDIT"
	 * @generated
	 * @ordered
	 */
	public static final int STORE_CREDIT_VALUE = 0;

	/**
	 * The '<em><b>Clinical Services</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Clinical Services</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLINICAL_SERVICES
	 * @model name="ClinicalServices" literal="CLINICAL_SERVICES"
	 * @generated
	 * @ordered
	 */
	public static final int CLINICAL_SERVICES_VALUE = 1;

	/**
	 * The '<em><b>Share Recovery</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Share Recovery</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHARE_RECOVERY
	 * @model name="ShareRecovery" literal="SHARE_RECOVERY"
	 * @generated
	 * @ordered
	 */
	public static final int SHARE_RECOVERY_VALUE = 2;

	/**
	 * The '<em><b>Cash Payment</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cash Payment</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CASH_PAYMENT
	 * @model name="CashPayment" literal="CASH_PAYMENT"
	 * @generated
	 * @ordered
	 */
	public static final int CASH_PAYMENT_VALUE = 3;

	/**
	 * The '<em><b>Other</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Other</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OTHER
	 * @model name="Other" literal="OTHER"
	 * @generated
	 * @ordered
	 */
	public static final int OTHER_VALUE = 4;

	/**
	 * An array of all the '<em><b>Transaction Source</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TransactionSource[] VALUES_ARRAY =
		new TransactionSource[] {
			STORE_CREDIT,
			CLINICAL_SERVICES,
			SHARE_RECOVERY,
			CASH_PAYMENT,
			OTHER,
		};

	/**
	 * A public read-only list of all the '<em><b>Transaction Source</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TransactionSource> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Transaction Source</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransactionSource get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransactionSource result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transaction Source</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransactionSource getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransactionSource result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transaction Source</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransactionSource get(int value) {
		switch (value) {
			case STORE_CREDIT_VALUE: return STORE_CREDIT;
			case CLINICAL_SERVICES_VALUE: return CLINICAL_SERVICES;
			case SHARE_RECOVERY_VALUE: return SHARE_RECOVERY;
			case CASH_PAYMENT_VALUE: return CASH_PAYMENT;
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
	private TransactionSource(int value, String name, String literal) {
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
	
} //TransactionSource
