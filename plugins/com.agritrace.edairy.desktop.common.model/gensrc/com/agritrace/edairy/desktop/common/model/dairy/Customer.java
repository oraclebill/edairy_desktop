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
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Customer#getCustomerNumber <em>Customer Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Customer#getCustomerType <em>Customer Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Customer#getStatus <em>Status</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCustomer()
 * @model
 * @generated
 */
public interface Customer extends Company {
	/**
	 * Returns the value of the '<em><b>Customer Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer Number</em>' attribute.
	 * @see #setCustomerNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCustomer_CustomerNumber()
	 * @model required="true"
	 *        extendedMetaData="name='id' kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@NaturalId'"
	 * @generated
	 */
	String getCustomerNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Customer#getCustomerNumber <em>Customer Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer Number</em>' attribute.
	 * @see #getCustomerNumber()
	 * @generated
	 */
	void setCustomerNumber(String value);

	/**
	 * Returns the value of the '<em><b>Customer Type</b></em>' attribute.
	 * The default value is <code>"Milk Processor"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer Type</em>' attribute.
	 * @see #setCustomerType(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCustomer_CustomerType()
	 * @model default="Milk Processor"
	 * @generated
	 */
	String getCustomerType();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Customer#getCustomerType <em>Customer Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer Type</em>' attribute.
	 * @see #getCustomerType()
	 * @generated
	 */
	void setCustomerType(String value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The default value is <code>"Active"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see #setStatus(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getCustomer_Status()
	 * @model default="Active"
	 * @generated
	 */
	String getStatus();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Customer#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(String value);

} // Customer
