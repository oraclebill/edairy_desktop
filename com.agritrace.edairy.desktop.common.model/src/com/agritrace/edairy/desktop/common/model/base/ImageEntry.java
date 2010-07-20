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
 * A representation of the model object '<em><b>Image Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.ImageEntry#getImageId <em>Image Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.ImageEntry#getMimeType <em>Mime Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.ImageEntry#getImageData <em>Image Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getImageEntry()
 * @model
 * @generated
 */
public interface ImageEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Image Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Id</em>' attribute.
	 * @see #setImageId(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getImageEntry_ImageId()
	 * @model id="true" dataType="com.agritrace.edairy.desktop.common.model.base.ImageReference" required="true"
	 * @generated
	 */
	String getImageId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.ImageEntry#getImageId <em>Image Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Id</em>' attribute.
	 * @see #getImageId()
	 * @generated
	 */
	void setImageId(String value);

	/**
	 * Returns the value of the '<em><b>Mime Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mime Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mime Type</em>' attribute.
	 * @see #setMimeType(String)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getImageEntry_MimeType()
	 * @model required="true"
	 * @generated
	 */
	String getMimeType();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.ImageEntry#getMimeType <em>Mime Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mime Type</em>' attribute.
	 * @see #getMimeType()
	 * @generated
	 */
	void setMimeType(String value);

	/**
	 * Returns the value of the '<em><b>Image Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Data</em>' attribute.
	 * @see #setImageData(byte[])
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getImageEntry_ImageData()
	 * @model extendedMetaData="name='imageData' kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@Lob\n@Column(length=1048576)'"
	 * @generated
	 */
	byte[] getImageData();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.ImageEntry#getImageData <em>Image Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Data</em>' attribute.
	 * @see #getImageData()
	 * @generated
	 */
	void setImageData(byte[] value);

} // ImageEntry
