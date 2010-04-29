/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Descriptive Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.DescriptiveLocation#getDirections <em>Directions</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.ModelPackage#getDescriptiveLocation()
 * @model
 * @generated
 */
public interface DescriptiveLocation extends EObject {
	/**
	 * Returns the value of the '<em><b>Directions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Directions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Directions</em>' attribute.
	 * @see #setDirections(String)
	 * @see com.agritrace.edairy.model.ModelPackage#getDescriptiveLocation_Directions()
	 * @model required="true"
	 * @generated
	 */
	String getDirections();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.DescriptiveLocation#getDirections <em>Directions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Directions</em>' attribute.
	 * @see #getDirections()
	 * @generated
	 */
	void setDirections(String value);

} // DescriptiveLocation
