/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.Company#getContactPerson <em>Contact Person</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.ModelPackage#getCompany()
 * @model
 * @generated
 */
public interface Company extends Party {
	/**
	 * Returns the value of the '<em><b>Contact Person</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.model.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contact Person</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contact Person</em>' containment reference list.
	 * @see com.agritrace.edairy.model.ModelPackage#getCompany_ContactPerson()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	EList<Person> getContactPerson();

} // Company
