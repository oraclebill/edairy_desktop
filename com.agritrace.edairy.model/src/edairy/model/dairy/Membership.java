/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model.dairy;

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
 *   <li>{@link edairy.model.dairy.Membership#getApplicationDate <em>Application Date</em>}</li>
 *   <li>{@link edairy.model.dairy.Membership#getEffectiveDate <em>Effective Date</em>}</li>
 *   <li>{@link edairy.model.dairy.Membership#getStatus <em>Status</em>}</li>
 *   <li>{@link edairy.model.dairy.Membership#getDefaultRoute <em>Default Route</em>}</li>
 * </ul>
 * </p>
 *
 * @see edairy.model.dairy.DairyPackage#getMembership()
 * @model
 * @generated
 */
public interface Membership extends EObject {
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
	 * @see edairy.model.dairy.DairyPackage#getMembership_ApplicationDate()
	 * @model required="true"
	 * @generated
	 */
	Date getApplicationDate();

	/**
	 * Sets the value of the '{@link edairy.model.dairy.Membership#getApplicationDate <em>Application Date</em>}' attribute.
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
	 * @see edairy.model.dairy.DairyPackage#getMembership_EffectiveDate()
	 * @model
	 * @generated
	 */
	Date getEffectiveDate();

	/**
	 * Sets the value of the '{@link edairy.model.dairy.Membership#getEffectiveDate <em>Effective Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Effective Date</em>' attribute.
	 * @see #getEffectiveDate()
	 * @generated
	 */
	void setEffectiveDate(Date value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link edairy.model.dairy.MembershipStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see edairy.model.dairy.MembershipStatus
	 * @see #setStatus(MembershipStatus)
	 * @see edairy.model.dairy.DairyPackage#getMembership_Status()
	 * @model required="true"
	 * @generated
	 */
	MembershipStatus getStatus();

	/**
	 * Sets the value of the '{@link edairy.model.dairy.Membership#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see edairy.model.dairy.MembershipStatus
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
	 * @see #setDefaultRoute(RouteDefinition)
	 * @see edairy.model.dairy.DairyPackage#getMembership_DefaultRoute()
	 * @model required="true"
	 * @generated
	 */
	RouteDefinition getDefaultRoute();

	/**
	 * Sets the value of the '{@link edairy.model.dairy.Membership#getDefaultRoute <em>Default Route</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Route</em>' reference.
	 * @see #getDefaultRoute()
	 * @generated
	 */
	void setDefaultRoute(RouteDefinition value);

} // Membership
