/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.account;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Account</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getAccountId <em>Account Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getAccountNumber <em>Account Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getMember <em>Member</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getEstablished <em>Established</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getStatus <em>Status</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getType <em>Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getTransactions <em>Transactions</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getBalances <em>Balances</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccount()
 * @model
 * @generated
 */
public interface Account extends EObject {
	/**
	 * Returns the value of the '<em><b>Account Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Account Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Account Id</em>' attribute.
	 * @see #setAccountId(long)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccount_AccountId()
	 * @model id="true" required="true"
	 * @generated
	 */
	long getAccountId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getAccountId <em>Account Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account Id</em>' attribute.
	 * @see #getAccountId()
	 * @generated
	 */
	void setAccountId(long value);

	/**
	 * Returns the value of the '<em><b>Account Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Account Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Account Number</em>' attribute.
	 * @see #setAccountNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccount_AccountNumber()
	 * @model required="true"
	 * @generated
	 */
	String getAccountNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getAccountNumber <em>Account Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account Number</em>' attribute.
	 * @see #getAccountNumber()
	 * @generated
	 */
	void setAccountNumber(String value);

	/**
	 * Returns the value of the '<em><b>Member</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getAccount <em>Account</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member</em>' container reference.
	 * @see #setMember(Membership)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccount_Member()
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Membership#getAccount
	 * @model opposite="account" required="true" transient="false"
	 * @generated
	 */
	Membership getMember();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getMember <em>Member</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member</em>' container reference.
	 * @see #getMember()
	 * @generated
	 */
	void setMember(Membership value);

	/**
	 * Returns the value of the '<em><b>Established</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Established</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Established</em>' attribute.
	 * @see #setEstablished(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccount_Established()
	 * @model
	 * @generated
	 */
	Date getEstablished();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getEstablished <em>Established</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Established</em>' attribute.
	 * @see #getEstablished()
	 * @generated
	 */
	void setEstablished(Date value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * The literals are from the enumeration {@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountStatus
	 * @see #setStatus(AccountStatus)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccount_Status()
	 * @model default="0" required="true"
	 * @generated
	 */
	AccountStatus getStatus();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(AccountStatus value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccount_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Transactions</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.account.Transaction}.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Transaction#getAccount <em>Account</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transactions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transactions</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccount_Transactions()
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Transaction#getAccount
	 * @model opposite="account" containment="true"
	 * @generated
	 */
	EList<Transaction> getTransactions();

	/**
	 * Returns the value of the '<em><b>Balances</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Balances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Balances</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccount_Balances()
	 * @model containment="true"
	 * @generated
	 */
	EList<BalancePoint> getBalances();

} // Account
