/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.account;

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
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
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getReferenceNumber <em>Reference Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getAccount <em>Account</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getTransactionType <em>Transaction Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getSource <em>Source</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getRelatedLocation <em>Related Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getAmount <em>Amount</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getDescription <em>Description</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getTransactionDate <em>Transaction Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getCheckNumber <em>Check Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getSignedBy <em>Signed By</em>}</li>
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
	 * @model id="true" required="true"
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
	 * Returns the value of the '<em><b>Reference Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Number</em>' attribute.
	 * @see #setReferenceNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccountTransaction_ReferenceNumber()
	 * @model required="true"
	 * @generated
	 */
	String getReferenceNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getReferenceNumber <em>Reference Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Number</em>' attribute.
	 * @see #getReferenceNumber()
	 * @generated
	 */
	void setReferenceNumber(String value);

	/**
	 * Returns the value of the '<em><b>Account</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getTransactions <em>Transactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Account</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Account</em>' container reference.
	 * @see #setAccount(Account)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccountTransaction_Account()
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Account#getTransactions
	 * @model opposite="transactions" keys="accountId" required="true" transient="false"
	 * @generated
	 */
	Account getAccount();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getAccount <em>Account</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account</em>' container reference.
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
	 * The literals are from the enumeration {@link com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource
	 * @see #setSource(TransactionSource)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccountTransaction_Source()
	 * @model required="true"
	 * @generated
	 */
	TransactionSource getSource();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource
	 * @see #getSource()
	 * @generated
	 */
	void setSource(TransactionSource value);

	/**
	 * Returns the value of the '<em><b>Related Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Location</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Location</em>' reference.
	 * @see #setRelatedLocation(DairyLocation)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccountTransaction_RelatedLocation()
	 * @model
	 * @generated
	 */
	DairyLocation getRelatedLocation();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getRelatedLocation <em>Related Location</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Location</em>' reference.
	 * @see #getRelatedLocation()
	 * @generated
	 */
	void setRelatedLocation(DairyLocation value);

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

	/**
	 * Returns the value of the '<em><b>Check Number</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Check Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check Number</em>' attribute.
	 * @see #setCheckNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccountTransaction_CheckNumber()
	 * @model default=""
	 * @generated
	 */
	String getCheckNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getCheckNumber <em>Check Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Check Number</em>' attribute.
	 * @see #getCheckNumber()
	 * @generated
	 */
	void setCheckNumber(String value);

	/**
	 * Returns the value of the '<em><b>Signed By</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signed By</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signed By</em>' attribute.
	 * @see #setSignedBy(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccountTransaction_SignedBy()
	 * @model default=""
	 * @generated
	 */
	String getSignedBy();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getSignedBy <em>Signed By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signed By</em>' attribute.
	 * @see #getSignedBy()
	 * @generated
	 */
	void setSignedBy(String value);

} // AccountTransaction
