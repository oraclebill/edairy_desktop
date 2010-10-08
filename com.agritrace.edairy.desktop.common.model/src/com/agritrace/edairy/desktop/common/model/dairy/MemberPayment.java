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
 * A representation of the model object '<em><b>Member Payment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getId <em>Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getYear <em>Year</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getMonth <em>Month</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getPaymentRate <em>Payment Rate</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getPaymentsTotal <em>Payments Total</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getPaymentsCount <em>Payments Count</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getEnteredBy <em>Entered By</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getEntryDate <em>Entry Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMemberPayment()
 * @model
 * @generated
 */
public interface MemberPayment extends EObject {
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMemberPayment_Id()
	 * @model id="true" dataType="com.agritrace.edairy.desktop.common.model.base.UniqueID" required="true"
	 * @generated
	 */
	Long getId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(Long value);

	/**
	 * Returns the value of the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Year</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Year</em>' attribute.
	 * @see #setYear(int)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMemberPayment_Year()
	 * @model required="true"
	 * @generated
	 */
	int getYear();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getYear <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Year</em>' attribute.
	 * @see #getYear()
	 * @generated
	 */
	void setYear(int value);

	/**
	 * Returns the value of the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Month</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Month</em>' attribute.
	 * @see #setMonth(int)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMemberPayment_Month()
	 * @model required="true"
	 * @generated
	 */
	int getMonth();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getMonth <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Month</em>' attribute.
	 * @see #getMonth()
	 * @generated
	 */
	void setMonth(int value);

	/**
	 * Returns the value of the '<em><b>Payment Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payment Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payment Rate</em>' attribute.
	 * @see #setPaymentRate(BigDecimal)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMemberPayment_PaymentRate()
	 * @model required="true"
	 * @generated
	 */
	BigDecimal getPaymentRate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getPaymentRate <em>Payment Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payment Rate</em>' attribute.
	 * @see #getPaymentRate()
	 * @generated
	 */
	void setPaymentRate(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Payments Total</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payments Total</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payments Total</em>' attribute.
	 * @see #setPaymentsTotal(BigDecimal)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMemberPayment_PaymentsTotal()
	 * @model
	 * @generated
	 */
	BigDecimal getPaymentsTotal();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getPaymentsTotal <em>Payments Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payments Total</em>' attribute.
	 * @see #getPaymentsTotal()
	 * @generated
	 */
	void setPaymentsTotal(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Payments Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payments Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payments Count</em>' attribute.
	 * @see #setPaymentsCount(int)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMemberPayment_PaymentsCount()
	 * @model
	 * @generated
	 */
	int getPaymentsCount();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getPaymentsCount <em>Payments Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payments Count</em>' attribute.
	 * @see #getPaymentsCount()
	 * @generated
	 */
	void setPaymentsCount(int value);

	/**
	 * Returns the value of the '<em><b>Entered By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entered By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entered By</em>' reference.
	 * @see #setEnteredBy(Employee)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMemberPayment_EnteredBy()
	 * @model required="true"
	 * @generated
	 */
	Employee getEnteredBy();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getEnteredBy <em>Entered By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entered By</em>' reference.
	 * @see #getEnteredBy()
	 * @generated
	 */
	void setEnteredBy(Employee value);

	/**
	 * Returns the value of the '<em><b>Entry Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Date</em>' attribute.
	 * @see #setEntryDate(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMemberPayment_EntryDate()
	 * @model required="true"
	 * @generated
	 */
	Date getEntryDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MemberPayment#getEntryDate <em>Entry Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Date</em>' attribute.
	 * @see #getEntryDate()
	 * @generated
	 */
	void setEntryDate(Date value);

} // MemberPayment
