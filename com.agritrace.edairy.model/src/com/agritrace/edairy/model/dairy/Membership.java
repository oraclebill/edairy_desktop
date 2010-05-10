/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy;

import com.agritrace.edairy.model.Person;

import com.agritrace.edairy.model.tracking.Farm;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Membership</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.dairy.Membership#getMemberId <em>Member Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Membership#getApplicationDate <em>Application Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Membership#getEffectiveDate <em>Effective Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Membership#getStatus <em>Status</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Membership#getDefaultRoute <em>Default Route</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Membership#getMember <em>Member</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Membership#getFarms <em>Farms</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.dairy.DairyPackage#getMembership()
 * @model
 * @generated
 */
public interface Membership extends EObject {
	/**
         * Returns the value of the '<em><b>Member Id</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Member Id</em>' attribute.
         * @see #setMemberId(String)
         * @see com.agritrace.edairy.model.dairy.DairyPackage#getMembership_MemberId()
         * @model required="true"
         * @generated
         */
	String getMemberId();

	/**
         * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Membership#getMemberId <em>Member Id</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @param value the new value of the '<em>Member Id</em>' attribute.
         * @see #getMemberId()
         * @generated
         */
	void setMemberId(String value);

	/**
         * Returns the value of the '<em><b>Application Date</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Application Date</em>' attribute.
         * @see #setApplicationDate(Date)
         * @see com.agritrace.edairy.model.dairy.DairyPackage#getMembership_ApplicationDate()
         * @model required="true"
         * @generated
         */
	Date getApplicationDate();

	/**
         * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Membership#getApplicationDate <em>Application Date</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @param value the new value of the '<em>Application Date</em>' attribute.
         * @see #getApplicationDate()
         * @generated
         */
	void setApplicationDate(Date value);

	/**
         * Returns the value of the '<em><b>Effective Date</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effective Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Effective Date</em>' attribute.
         * @see #setEffectiveDate(Date)
         * @see com.agritrace.edairy.model.dairy.DairyPackage#getMembership_EffectiveDate()
         * @model
         * @generated
         */
	Date getEffectiveDate();

	/**
         * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Membership#getEffectiveDate <em>Effective Date</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @param value the new value of the '<em>Effective Date</em>' attribute.
         * @see #getEffectiveDate()
         * @generated
         */
	void setEffectiveDate(Date value);

	/**
         * Returns the value of the '<em><b>Status</b></em>' attribute.
         * The literals are from the enumeration {@link com.agritrace.edairy.model.dairy.MembershipStatus}.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Status</em>' attribute.
         * @see com.agritrace.edairy.model.dairy.MembershipStatus
         * @see #setStatus(MembershipStatus)
         * @see com.agritrace.edairy.model.dairy.DairyPackage#getMembership_Status()
         * @model required="true"
         * @generated
         */
	MembershipStatus getStatus();

	/**
         * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Membership#getStatus <em>Status</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @param value the new value of the '<em>Status</em>' attribute.
         * @see com.agritrace.edairy.model.dairy.MembershipStatus
         * @see #getStatus()
         * @generated
         */
	void setStatus(MembershipStatus value);

	/**
         * Returns the value of the '<em><b>Default Route</b></em>' reference.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Route</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Default Route</em>' reference.
         * @see #setDefaultRoute(Route)
         * @see com.agritrace.edairy.model.dairy.DairyPackage#getMembership_DefaultRoute()
         * @model required="true"
         * @generated
         */
	Route getDefaultRoute();

	/**
         * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Membership#getDefaultRoute <em>Default Route</em>}' reference.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @param value the new value of the '<em>Default Route</em>' reference.
         * @see #getDefaultRoute()
         * @generated
         */
	void setDefaultRoute(Route value);

	/**
         * Returns the value of the '<em><b>Member</b></em>' containment reference.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Member</em>' containment reference.
         * @see #setMember(Person)
         * @see com.agritrace.edairy.model.dairy.DairyPackage#getMembership_Member()
         * @model containment="true" required="true"
         * @generated
         */
	Person getMember();

	/**
         * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Membership#getMember <em>Member</em>}' containment reference.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @param value the new value of the '<em>Member</em>' containment reference.
         * @see #getMember()
         * @generated
         */
	void setMember(Person value);

	/**
         * Returns the value of the '<em><b>Farms</b></em>' reference list.
         * The list contents are of type {@link com.agritrace.edairy.model.tracking.Farm}.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Farms</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Farms</em>' reference list.
         * @see com.agritrace.edairy.model.dairy.DairyPackage#getMembership_Farms()
         * @model
         * @generated
         */
	EList<Farm> getFarms();

} // Membership
