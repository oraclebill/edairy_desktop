/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import java.math.BigDecimal;

import java.util.Date;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delivery Journal Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getId <em>Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getReferenceNumber <em>Reference Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSaleDate <em>Sale Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getBin <em>Bin</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSaleType <em>Sale Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getGrade <em>Grade</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getUnitPrice <em>Unit Price</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getDescription <em>Description</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#isRejected <em>Rejected</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getStoreOrRoute <em>Store Or Route</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getCustomer <em>Customer</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSoldBy <em>Sold By</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSaleAmount <em>Sale Amount</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#isContractSale <em>Contract Sale</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSalesClerk <em>Sales Clerk</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSale()
 * @model
 * @generated
 */
public interface MilkSale extends EObject {
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSale_Id()
	 * @model id="true" dataType="com.agritrace.edairy.desktop.common.model.base.UniqueID" required="true"
	 * @generated
	 */
	Long getId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(Long value);

	/**
	 * Returns the value of the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Number</em>' attribute.
	 * @see #setLineNumber(int)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSale_LineNumber()
	 * @model
	 * @generated
	 */
	int getLineNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getLineNumber <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Number</em>' attribute.
	 * @see #getLineNumber()
	 * @generated
	 */
	void setLineNumber(int value);

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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSale_ReferenceNumber()
	 * @model
	 * @generated
	 */
	String getReferenceNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getReferenceNumber <em>Reference Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Number</em>' attribute.
	 * @see #getReferenceNumber()
	 * @generated
	 */
	void setReferenceNumber(String value);

	/**
	 * Returns the value of the '<em><b>Sale Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sale Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sale Date</em>' attribute.
	 * @see #setSaleDate(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSale_SaleDate()
	 * @model required="true"
	 * @generated
	 */
	Date getSaleDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSaleDate <em>Sale Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sale Date</em>' attribute.
	 * @see #getSaleDate()
	 * @generated
	 */
	void setSaleDate(Date value);

	/**
	 * Returns the value of the '<em><b>Bin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bin</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bin</em>' reference.
	 * @see #setBin(Bin)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSale_Bin()
	 * @model
	 * @generated
	 */
	Bin getBin();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getBin <em>Bin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bin</em>' reference.
	 * @see #getBin()
	 * @generated
	 */
	void setBin(Bin value);

	/**
	 * Returns the value of the '<em><b>Sale Type</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link com.agritrace.edairy.desktop.common.model.dairy.MilkSaleType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sale Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sale Type</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSaleType
	 * @see #setSaleType(MilkSaleType)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSale_SaleType()
	 * @model default="" required="true"
	 * @generated
	 */
	MilkSaleType getSaleType();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSaleType <em>Sale Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sale Type</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MilkSaleType
	 * @see #getSaleType()
	 * @generated
	 */
	void setSaleType(MilkSaleType value);

	/**
	 * Returns the value of the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quantity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quantity</em>' attribute.
	 * @see #setQuantity(BigDecimal)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSale_Quantity()
	 * @model required="true"
	 * @generated
	 */
	BigDecimal getQuantity();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getQuantity <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantity</em>' attribute.
	 * @see #getQuantity()
	 * @generated
	 */
	void setQuantity(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Grade</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grade</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grade</em>' reference.
	 * @see #setGrade(MilkGrade)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSale_Grade()
	 * @model required="true"
	 * @generated
	 */
	MilkGrade getGrade();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getGrade <em>Grade</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grade</em>' reference.
	 * @see #getGrade()
	 * @generated
	 */
	void setGrade(MilkGrade value);

	/**
	 * Returns the value of the '<em><b>Unit Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Price</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Price</em>' attribute.
	 * @see #setUnitPrice(BigDecimal)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSale_UnitPrice()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	BigDecimal getUnitPrice();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getUnitPrice <em>Unit Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Price</em>' attribute.
	 * @see #getUnitPrice()
	 * @generated
	 */
	void setUnitPrice(BigDecimal value);

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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSale_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Rejected</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rejected</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rejected</em>' attribute.
	 * @see #setRejected(boolean)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSale_Rejected()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isRejected();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#isRejected <em>Rejected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rejected</em>' attribute.
	 * @see #isRejected()
	 * @generated
	 */
	void setRejected(boolean value);

	/**
	 * Returns the value of the '<em><b>Store Or Route</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Store Or Route</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Store Or Route</em>' reference.
	 * @see #setStoreOrRoute(DairyLocation)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSale_StoreOrRoute()
	 * @model required="true"
	 * @generated
	 */
	DairyLocation getStoreOrRoute();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getStoreOrRoute <em>Store Or Route</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Store Or Route</em>' reference.
	 * @see #getStoreOrRoute()
	 * @generated
	 */
	void setStoreOrRoute(DairyLocation value);

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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSale_Customer()
	 * @model
	 * @generated
	 */
	Customer getCustomer();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getCustomer <em>Customer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer</em>' reference.
	 * @see #getCustomer()
	 * @generated
	 */
	void setCustomer(Customer value);

	/**
	 * Returns the value of the '<em><b>Sold By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sold By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sold By</em>' reference.
	 * @see #setSoldBy(Employee)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSale_SoldBy()
	 * @model
	 * @generated
	 */
	Employee getSoldBy();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSoldBy <em>Sold By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sold By</em>' reference.
	 * @see #getSoldBy()
	 * @generated
	 */
	void setSoldBy(Employee value);

	/**
	 * Returns the value of the '<em><b>Sale Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sale Amount</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sale Amount</em>' attribute.
	 * @see #setSaleAmount(BigDecimal)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSale_SaleAmount()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	BigDecimal getSaleAmount();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSaleAmount <em>Sale Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sale Amount</em>' attribute.
	 * @see #getSaleAmount()
	 * @generated
	 */
	void setSaleAmount(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Contract Sale</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contract Sale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contract Sale</em>' attribute.
	 * @see #setContractSale(boolean)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSale_ContractSale()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isContractSale();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#isContractSale <em>Contract Sale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contract Sale</em>' attribute.
	 * @see #isContractSale()
	 * @generated
	 */
	void setContractSale(boolean value);

	/**
	 * Returns the value of the '<em><b>Sales Clerk</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sales Clerk</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sales Clerk</em>' reference.
	 * @see #setSalesClerk(Employee)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkSale_SalesClerk()
	 * @model
	 * @generated
	 */
	Employee getSalesClerk();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkSale#getSalesClerk <em>Sales Clerk</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sales Clerk</em>' reference.
	 * @see #getSalesClerk()
	 * @generated
	 */
	void setSalesClerk(Employee value);

} // MilkSale
