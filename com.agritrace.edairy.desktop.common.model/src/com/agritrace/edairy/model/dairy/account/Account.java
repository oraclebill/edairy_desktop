/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy.account;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.model.dairy.Membership;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Account</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.agritrace.edairy.model.dairy.account.Account#getAccountId <em>
 * Account Id</em>}</li>
 * <li>{@link com.agritrace.edairy.model.dairy.account.Account#getMember <em>
 * Member</em>}</li>
 * <li>{@link com.agritrace.edairy.model.dairy.account.Account#getEstablished
 * <em>Established</em>}</li>
 * <li>{@link com.agritrace.edairy.model.dairy.account.Account#getType <em>Type
 * </em>}</li>
 * <li>{@link com.agritrace.edairy.model.dairy.account.Account#getTransactions
 * <em>Transactions</em>}</li>
 * <li>{@link com.agritrace.edairy.model.dairy.account.Account#getBalances <em>
 * Balances</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.agritrace.edairy.model.dairy.account.AccountPackage#getAccount()
 * @model
 * @generated
 */
public interface Account extends EObject {
    /**
     * Returns the value of the '<em><b>Account Id</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Account Id</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Account Id</em>' attribute.
     * @see #setAccountId(long)
     * @see com.agritrace.edairy.model.dairy.account.AccountPackage#getAccount_AccountId()
     * @model
     * @generated
     */
    long getAccountId();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.dairy.account.Account#getAccountId
     * <em>Account Id</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Account Id</em>' attribute.
     * @see #getAccountId()
     * @generated
     */
    void setAccountId(long value);

    /**
     * Returns the value of the '<em><b>Member</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Member</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Member</em>' reference.
     * @see #setMember(Membership)
     * @see com.agritrace.edairy.model.dairy.account.AccountPackage#getAccount_Member()
     * @model
     * @generated
     */
    Membership getMember();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.dairy.account.Account#getMember
     * <em>Member</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Member</em>' reference.
     * @see #getMember()
     * @generated
     */
    void setMember(Membership value);

    /**
     * Returns the value of the '<em><b>Established</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Established</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Established</em>' attribute.
     * @see #setEstablished(Date)
     * @see com.agritrace.edairy.model.dairy.account.AccountPackage#getAccount_Established()
     * @model
     * @generated
     */
    Date getEstablished();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.dairy.account.Account#getEstablished
     * <em>Established</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Established</em>' attribute.
     * @see #getEstablished()
     * @generated
     */
    void setEstablished(Date value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Type</em>' attribute.
     * @see #setType(String)
     * @see com.agritrace.edairy.model.dairy.account.AccountPackage#getAccount_Type()
     * @model
     * @generated
     */
    String getType();

    /**
     * Sets the value of the '
     * {@link com.agritrace.edairy.model.dairy.account.Account#getType
     * <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Type</em>' attribute.
     * @see #getType()
     * @generated
     */
    void setType(String value);

    /**
     * Returns the value of the '<em><b>Transactions</b></em>' reference list.
     * The list contents are of type
     * {@link com.agritrace.edairy.model.dairy.account.AccountTransaction}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transactions</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Transactions</em>' reference list.
     * @see com.agritrace.edairy.model.dairy.account.AccountPackage#getAccount_Transactions()
     * @model
     * @generated
     */
    EList<AccountTransaction> getTransactions();

    /**
     * Returns the value of the '<em><b>Balances</b></em>' reference list. The
     * list contents are of type
     * {@link com.agritrace.edairy.model.dairy.account.BalancePoint}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Balances</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Balances</em>' reference list.
     * @see com.agritrace.edairy.model.dairy.account.AccountPackage#getAccount_Balances()
     * @model
     * @generated
     */
    EList<BalancePoint> getBalances();

} // Account
