/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.Person#getPhoto <em>Photo</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.ModelPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends Party {
	/**
	 * Returns the value of the '<em><b>Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Photo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Photo</em>' attribute.
	 * @see #setPhoto(String)
	 * @see com.agritrace.edairy.model.ModelPackage#getPerson_Photo()
	 * @model dataType="com.agritrace.edairy.model.ImageReference"
	 * @generated
	 */
	String getPhoto();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.Person#getPhoto <em>Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Photo</em>' attribute.
	 * @see #getPhoto()
	 * @generated
	 */
	void setPhoto(String value);

} // Person
