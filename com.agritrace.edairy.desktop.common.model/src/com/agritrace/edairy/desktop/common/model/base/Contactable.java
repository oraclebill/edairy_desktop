/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contactable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.Contactable#getContactMethods <em>Contact Methods</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getContactable()
 * @model extendedMetaData="name='Contactable' kind='elementOnly'"
 *        annotation="teneo.jpa appinfo='@MappedSuperclass'"
 * @generated
 */
public interface Contactable extends EObject {
	/**
	 * Returns the value of the '<em><b>Contact Methods</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.desktop.common.model.base.ContactMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contact Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contact Methods</em>' containment reference list.
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getContactable_ContactMethods()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ContactMethod> getContactMethods();

} // Contactable
