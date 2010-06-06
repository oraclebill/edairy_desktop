/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.tracking;

import com.agritrace.edairy.desktop.common.model.base.Person;

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
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Farms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Farms</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getFarmer_Farms()
	 * @model containment="true"
	 * @generated
	 */
	EList<Farm> getFarms();

} // Farmer
