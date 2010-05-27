/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import com.agritrace.edairy.desktop.common.model.base.Company;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Customer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Customer#getCustomerId <em>Customer Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCustomer()
 * @model
 * @generated
 */
public interface Customer extends Company {
	/**
	 * Returns the value of the '<em><b>Customer Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer Id</em>' attribute.
	 * @see #setCustomerId(Long)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCustomer_CustomerId()
	 * @model dataType="com.agritrace.edairy.desktop.common.model.base.UniqueID"
	 *        extendedMetaData="name='customerId' kind='elementOnly'"
	 * @generated
	 */
	Long getCustomerId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Customer#getCustomerId <em>Customer Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer Id</em>' attribute.
	 * @see #getCustomerId()
	 * @generated
	 */
	void setCustomerId(Long value);

} // Customer
