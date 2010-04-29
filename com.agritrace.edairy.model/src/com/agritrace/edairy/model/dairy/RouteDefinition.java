/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Route Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.dairy.RouteDefinition#getName <em>Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.RouteDefinition#getStops <em>Stops</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.dairy.DairyPackage#getRouteDefinition()
 * @model
 * @generated
 */
public interface RouteDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getRouteDefinition_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.RouteDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Stops</b></em>' reference list.
	 * The list contents are of type {@link com.agritrace.edairy.model.dairy.CollectionCentre}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stops</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stops</em>' reference list.
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getRouteDefinition_Stops()
	 * @model
	 * @generated
	 */
	EList<CollectionCentre> getStops();

} // RouteDefinition
