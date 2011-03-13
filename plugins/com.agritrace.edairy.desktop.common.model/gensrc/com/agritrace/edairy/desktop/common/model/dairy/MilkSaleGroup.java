/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import java.math.BigDecimal;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Milk Sale Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getReferenceNumber <em>Reference Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getDate <em>Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getRoute <em>Route</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getCustomer <em>Customer</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getDriver <em>Driver</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getVehicle <em>Vehicle</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getSales <em>Sales</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getTotal <em>Total</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getSession <em>Session</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSaleGroup()
 * @model
 * @generated
 */
public interface MilkSaleGroup extends EObject
{
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSaleGroup_ReferenceNumber()
	 * @model required="true"
	 * @generated
	 */
	String getReferenceNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getReferenceNumber <em>Reference Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Number</em>' attribute.
	 * @see #getReferenceNumber()
	 * @generated
	 */
	void setReferenceNumber(String value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSaleGroup_Date()
	 * @model required="true"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Route</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Route</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Route</em>' reference.
	 * @see #setRoute(TransportRoute)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSaleGroup_Route()
	 * @model required="true"
	 * @generated
	 */
	TransportRoute getRoute();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getRoute <em>Route</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Route</em>' reference.
	 * @see #getRoute()
	 * @generated
	 */
	void setRoute(TransportRoute value);

	/**
	 * Returns the value of the '<em><b>Customer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer</em>' reference.
	 * @see #setCustomer(Customer)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSaleGroup_Customer()
	 * @model required="true"
	 * @generated
	 */
	Customer getCustomer();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getCustomer <em>Customer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer</em>' reference.
	 * @see #getCustomer()
	 * @generated
	 */
	void setCustomer(Customer value);

	/**
	 * Returns the value of the '<em><b>Driver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Driver</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driver</em>' reference.
	 * @see #setDriver(Employee)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSaleGroup_Driver()
	 * @model
	 * @generated
	 */
	Employee getDriver();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getDriver <em>Driver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driver</em>' reference.
	 * @see #getDriver()
	 * @generated
	 */
	void setDriver(Employee value);

	/**
	 * Returns the value of the '<em><b>Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vehicle</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle</em>' reference.
	 * @see #setVehicle(Vehicle)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSaleGroup_Vehicle()
	 * @model
	 * @generated
	 */
	Vehicle getVehicle();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getVehicle <em>Vehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle</em>' reference.
	 * @see #getVehicle()
	 * @generated
	 */
	void setVehicle(Vehicle value);

	/**
	 * Returns the value of the '<em><b>Sales</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sales</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sales</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSaleGroup_Sales()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<MilkSale> getSales();

	/**
	 * Returns the value of the '<em><b>Total</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total</em>' attribute.
	 * @see #setTotal(BigDecimal)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSaleGroup_Total()
	 * @model default="0.0" required="true"
	 * @generated
	 */
	BigDecimal getTotal();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getTotal <em>Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total</em>' attribute.
	 * @see #getTotal()
	 * @generated
	 */
	void setTotal(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Session</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Session</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Session</em>' reference.
	 * @see #setSession(CollectionSession)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSaleGroup_Session()
	 * @model required="true"
	 * @generated
	 */
	CollectionSession getSession();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getSession <em>Session</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Session</em>' reference.
	 * @see #getSession()
	 * @generated
	 */
	void setSession(CollectionSession value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(Long)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSaleGroup_Id()
	 * @model id="true" dataType="com.agritrace.edairy.desktop.common.model.base.UniqueID" required="true"
	 * @generated
	 */
	Long getId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(Long value);

} // MilkSaleGroup
