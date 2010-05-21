/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.account;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getTransactionId <em>Transaction Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getAccount <em>Account</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getTransactionType <em>Transaction Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getSource <em>Source</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getAmount <em>Amount</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getDescription <em>Description</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getTransactionDate <em>Transaction Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccountTransaction()
 * @model
 * @generated
 */
public interface AccountTransaction extends EObject {
	/**
	 * Returns the value of the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transaction Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transaction Id</em>' attribute.
	 * @see #setTransactionId(long)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccountTransaction_TransactionId()
	 * @model required="true"
	 * @generated
	 */
	long getTransactionId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getTransactionId <em>Transaction Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transaction Id</em>' attribute.
	 * @see #getTransactionId()
	 * @generated
	 */
	void setTransactionId(long value);

	/**
	 * Returns the value of the '<em><b>Account</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Account</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Account</em>' reference.
	 * @see #setAccount(Account)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccountTransaction_Account()
	 * @model required="true"
	 * @generated
	 */
	Account getAccount();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getAccount <em>Account</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account</em>' reference.
	 * @see #getAccount()
	 * @generated
	 */
	void setAccount(Account value);

	/**
	 * Returns the value of the '<em><b>Transaction Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transaction Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transaction Type</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType
	 * @see #setTransactionType(TransactionType)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccountTransaction_TransactionType()
	 * @model required="true"
	 * @generated
	 */
	TransactionType getTransactionType();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getTransactionType <em>Transaction Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transaction Type</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType
	 * @see #getTransactionType()
	 * @generated
	 */
	void setTransactionType(TransactionType value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccountTransaction_Source()
	 * @model
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

	/**
	 * Returns the value of the '<em><b>Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Amount</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Amount</em>' attribute.
	 * @see #setAmount(double)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccountTransaction_Amount()
	 * @model
	 * @generated
	 */
	double getAmount();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getAmount <em>Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Amount</em>' attribute.
	 * @see #getAmount()
	 * @generated
	 */
	void setAmount(double value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccountTransaction_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Transaction Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transaction Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transaction Date</em>' attribute.
	 * @see #setTransactionDate(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccountTransaction_TransactionDate()
	 * @model required="true"
	 * @generated
	 */
	Date getTransactionDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getTransactionDate <em>Transaction Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transaction Date</em>' attribute.
	 * @see #getTransactionDate()
	 * @generated
	 */
	void setTransactionDate(Date value);

} // AccountTransaction
