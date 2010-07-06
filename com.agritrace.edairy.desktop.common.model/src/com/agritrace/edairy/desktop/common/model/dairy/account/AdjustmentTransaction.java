/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.account;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Adjustment Transaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.account.AdjustmentTransaction#getSignedOffBy <em>Signed Off By</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAdjustmentTransaction()
 * @model
 * @generated
 */
public interface AdjustmentTransaction extends Transaction {
	/**
	 * Returns the value of the '<em><b>Signed Off By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signed Off By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signed Off By</em>' reference.
	 * @see #setSignedOffBy(Employee)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage#getAdjustmentTransaction_SignedOffBy()
	 * @model
	 * @generated
	 */
	Employee getSignedOffBy();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.account.AdjustmentTransaction#getSignedOffBy <em>Signed Off By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signed Off By</em>' reference.
	 * @see #getSignedOffBy()
	 * @generated
	 */
	void setSignedOffBy(Employee value);

} // AdjustmentTransaction
