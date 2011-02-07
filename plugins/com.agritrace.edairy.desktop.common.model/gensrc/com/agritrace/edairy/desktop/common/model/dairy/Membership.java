/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;

import com.agritrace.edairy.desktop.common.model.tracking.Farmer;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Membership</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getMemberId <em>Member Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getMemberNumber <em>Member Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getApplicationDate <em>Application Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getEffectiveDate <em>Effective Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getStatus <em>Status</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getDefaultRoute <em>Default Route</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getFarmer <em>Farmer</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getAccount <em>Account</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getDairy <em>Dairy</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getMaziwaCardNumber <em>Maziwa Card Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getMaziwaCardIssueDate <em>Maziwa Card Issue Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMembership()
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
	 * @see #setMemberId(Long)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMembership_MemberId()
	 * @model id="true" dataType="com.agritrace.edairy.desktop.common.model.base.UniqueID" required="true"
	 *        extendedMetaData="name='memberId' kind='elementOnly'"
	 * @generated
	 */
	Long getMemberId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getMemberId <em>Member Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member Id</em>' attribute.
	 * @see #getMemberId()
	 * @generated
	 */
	void setMemberId(Long value);

	/**
	 * Returns the value of the '<em><b>Member Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member Number</em>' attribute.
	 * @see #setMemberNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMembership_MemberNumber()
	 * @model required="true" ordered="false"
	 *        extendedMetaData="kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@NaturalId'"
	 * @generated
	 */
	String getMemberNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getMemberNumber <em>Member Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member Number</em>' attribute.
	 * @see #getMemberNumber()
	 * @generated
	 */
	void setMemberNumber(String value);

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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMembership_ApplicationDate()
	 * @model required="true"
	 * @generated
	 */
	Date getApplicationDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getApplicationDate <em>Application Date</em>}' attribute.
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMembership_EffectiveDate()
	 * @model
	 * @generated
	 */
	Date getEffectiveDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getEffectiveDate <em>Effective Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Effective Date</em>' attribute.
	 * @see #getEffectiveDate()
	 * @generated
	 */
	void setEffectiveDate(Date value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus
	 * @see #setStatus(MembershipStatus)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMembership_Status()
	 * @model required="true"
	 * @generated
	 */
	MembershipStatus getStatus();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus
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
	 * @see #setDefaultRoute(DairyLocation)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMembership_DefaultRoute()
	 * @model
	 * @generated
	 */
	DairyLocation getDefaultRoute();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getDefaultRoute <em>Default Route</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Route</em>' reference.
	 * @see #getDefaultRoute()
	 * @generated
	 */
	void setDefaultRoute(DairyLocation value);

	/**
	 * Returns the value of the '<em><b>Farmer</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.tracking.Farmer#getMembership <em>Membership</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Farmer</em>' containment reference.
	 * @see #setFarmer(Farmer)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMembership_Farmer()
	 * @see com.agritrace.edairy.desktop.common.model.tracking.Farmer#getMembership
	 * @model opposite="membership" containment="true" keys="personId" required="true"
	 * @generated
	 */
	Farmer getFarmer();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getFarmer <em>Farmer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Farmer</em>' containment reference.
	 * @see #getFarmer()
	 * @generated
	 */
	void setFarmer(Farmer value);

	/**
	 * Returns the value of the '<em><b>Account</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.dairy.account.Account#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Account</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Account</em>' containment reference.
	 * @see #setAccount(Account)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMembership_Account()
	 * @see com.agritrace.edairy.desktop.common.model.dairy.account.Account#getMember
	 * @model opposite="member" containment="true" keys="accountId" required="true"
	 * @generated
	 */
	Account getAccount();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getAccount <em>Account</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account</em>' containment reference.
	 * @see #getAccount()
	 * @generated
	 */
	void setAccount(Account value);

	/**
	 * Returns the value of the '<em><b>Dairy</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.dairy.Dairy#getMemberships <em>Memberships</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dairy</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dairy</em>' container reference.
	 * @see #setDairy(Dairy)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMembership_Dairy()
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Dairy#getMemberships
	 * @model opposite="memberships" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Dairy getDairy();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getDairy <em>Dairy</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dairy</em>' container reference.
	 * @see #getDairy()
	 * @generated
	 */
	void setDairy(Dairy value);

	/**
	 * Returns the value of the '<em><b>Maziwa Card Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maziwa Card Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maziwa Card Number</em>' attribute.
	 * @see #setMaziwaCardNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMembership_MaziwaCardNumber()
	 * @model
	 * @generated
	 */
	String getMaziwaCardNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getMaziwaCardNumber <em>Maziwa Card Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maziwa Card Number</em>' attribute.
	 * @see #getMaziwaCardNumber()
	 * @generated
	 */
	void setMaziwaCardNumber(String value);

	/**
	 * Returns the value of the '<em><b>Maziwa Card Issue Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maziwa Card Issue Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maziwa Card Issue Date</em>' attribute.
	 * @see #setMaziwaCardIssueDate(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMembership_MaziwaCardIssueDate()
	 * @model
	 * @generated
	 */
	Date getMaziwaCardIssueDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getMaziwaCardIssueDate <em>Maziwa Card Issue Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maziwa Card Issue Date</em>' attribute.
	 * @see #getMaziwaCardIssueDate()
	 * @generated
	 */
	void setMaziwaCardIssueDate(Date value);

} // Membership
