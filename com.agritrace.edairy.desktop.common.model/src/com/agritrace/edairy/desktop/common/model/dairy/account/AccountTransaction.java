/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.account;

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getReferenceNumber <em>Reference Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getSource <em>Source</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getRelatedLocation <em>Related Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getCheckNumber <em>Check Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction#getSignedBy <em>Signed By</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAccountTransaction()
 * @model
 * @generated
 */
public interface AccountTransaction extends Transaction {
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
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * The default value is <code>"StoreCredit"</code>.
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
	 * @model default="StoreCredit" required="true"
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
