/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.account;

import java.math.BigDecimal;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Balance Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getAccountBalanceId <em>Account Balance Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getAccount <em>Account</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getAsOf <em>As Of</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getAmount <em>Amount</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getBalancePoint()
 * @model
 * @generated
 */
public interface BalancePoint extends EObject {
	/**
	 * Returns the value of the '<em><b>Account Balance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Account Balance Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Account Balance Id</em>' attribute.
	 * @see #setAccountBalanceId(long)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getBalancePoint_AccountBalanceId()
	 * @model id="true" required="true"
	 * @generated
	 */
	long getAccountBalanceId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getAccountBalanceId <em>Account Balance Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account Balance Id</em>' attribute.
	 * @see #getAccountBalanceId()
	 * @generated
	 */
	void setAccountBalanceId(long value);

	/**
	 * Returns the value of the '<em><b>Account</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getBalances <em>Balances</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Account</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Account</em>' container reference.
	 * @see #setAccount(Account)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getBalancePoint_Account()
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Account#getBalances
	 * @model opposite="balances" required="true" transient="false"
	 * @generated
	 */
	Account getAccount();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getAccount <em>Account</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account</em>' container reference.
	 * @see #getAccount()
	 * @generated
	 */
	void setAccount(Account value);

	/**
	 * Returns the value of the '<em><b>As Of</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>As Of</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>As Of</em>' attribute.
	 * @see #setAsOf(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getBalancePoint_AsOf()
	 * @model
	 * @generated
	 */
	Date getAsOf();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getAsOf <em>As Of</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>As Of</em>' attribute.
	 * @see #getAsOf()
	 * @generated
	 */
	void setAsOf(Date value);

	/**
	 * Returns the value of the '<em><b>Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Amount</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Amount</em>' attribute.
	 * @see #setAmount(BigDecimal)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getBalancePoint_Amount()
	 * @model
	 * @generated
	 */
	BigDecimal getAmount();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint#getAmount <em>Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Amount</em>' attribute.
	 * @see #getAmount()
	 * @generated
	 */
	void setAmount(BigDecimal value);

} // BalancePoint
