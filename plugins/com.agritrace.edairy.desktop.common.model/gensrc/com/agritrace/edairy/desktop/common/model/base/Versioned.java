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
 * A representation of the model object '<em><b>Versioned</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Versioned#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getVersioned()
 * @model extendedMetaData="name='Versioned' kind='elementOnly'"
 *        annotation="teneo.jpa appinfo='@MappedSuperclass'"
 * @generated
 */
public interface Versioned extends EObject {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(long)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getVersioned_Version()
	 * @model required="true"
	 * @generated
	 */
	long getVersion();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.Versioned#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(long value);

} // Versioned
