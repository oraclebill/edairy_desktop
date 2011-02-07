/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.tracking;

import com.agritrace.edairy.desktop.common.model.base.Person;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Farmer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Farmer#getFarms <em>Farms</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.Farmer#getMembership <em>Membership</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getFarmer()
 * @model
 * @generated
 */
public interface Farmer extends Person {
	/**
	 * Returns the value of the '<em><b>Farms</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.tracking.Farm}.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.tracking.Farm#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Farms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Farms</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getFarmer_Farms()
	 * @see com.agritrace.edairy.desktop.common.model.tracking.Farm#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Farm> getFarms();

	/**
	 * Returns the value of the '<em><b>Membership</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.dairy.Membership#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Membership</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Membership</em>' container reference.
	 * @see #setMembership(Membership)
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getFarmer_Membership()
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Membership#getMember
	 * @model opposite="member" transient="false"
	 * @generated
	 */
	Membership getMembership();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.Farmer#getMembership <em>Membership</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Membership</em>' container reference.
	 * @see #getMembership()
	 * @generated
	 */
	void setMembership(Membership value);

} // Farmer
