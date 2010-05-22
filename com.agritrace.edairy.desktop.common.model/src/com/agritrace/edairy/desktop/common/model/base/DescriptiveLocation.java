/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Descriptive Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation#getDirections <em>Directions</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation#getLandmarks <em>Landmarks</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getDescriptiveLocation()
 * @model extendedMetaData="name='DescriptiveLocation' kind='elementOnly'"
 *        annotation="teneo.jpa appinfo='@Embeddable'"
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
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getDescriptiveLocation_Directions()
	 * @model
	 * @generated
	 */
	String getDirections();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation#getDirections <em>Directions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Directions</em>' attribute.
	 * @see #getDirections()
	 * @generated
	 */
	void setDirections(String value);

	/**
	 * Returns the value of the '<em><b>Landmarks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Landmarks</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Landmarks</em>' attribute.
	 * @see #setLandmarks(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getDescriptiveLocation_Landmarks()
	 * @model
	 * @generated
	 */
	String getLandmarks();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation#getLandmarks <em>Landmarks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Landmarks</em>' attribute.
	 * @see #getLandmarks()
	 * @generated
	 */
	void setLandmarks(String value);

} // DescriptiveLocation
