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
 *   <li>{@link com.agritrace.edairy.model.Company#getContacts <em>Contacts</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.Company#getLegalName <em>Legal Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.Company#getCompanyName <em>Company Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.ModelPackage#getCompany()
 * @model
 * @generated
 */
public interface Company extends Party {
	/**
         * Returns the value of the '<em><b>Contacts</b></em>' containment reference list.
         * The list contents are of type {@link com.agritrace.edairy.model.Person}.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contacts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Contacts</em>' containment reference list.
         * @see com.agritrace.edairy.model.ModelPackage#getCompany_Contacts()
         * @model containment="true" required="true"
         * @generated
         */
	EList<Person> getContacts();

	/**
         * Returns the value of the '<em><b>Legal Name</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Legal Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Legal Name</em>' attribute.
         * @see #setLegalName(String)
         * @see com.agritrace.edairy.model.ModelPackage#getCompany_LegalName()
         * @model
         * @generated
         */
	String getLegalName();

	/**
         * Sets the value of the '{@link com.agritrace.edairy.model.Company#getLegalName <em>Legal Name</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @param value the new value of the '<em>Legal Name</em>' attribute.
         * @see #getLegalName()
         * @generated
         */
	void setLegalName(String value);

	/**
         * Returns the value of the '<em><b>Company Name</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Company Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Company Name</em>' attribute.
         * @see #setCompanyName(String)
         * @see com.agritrace.edairy.model.ModelPackage#getCompany_CompanyName()
         * @model
         * @generated
         */
	String getCompanyName();

	/**
         * Sets the value of the '{@link com.agritrace.edairy.model.Company#getCompanyName <em>Company Name</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @param value the new value of the '<em>Company Name</em>' attribute.
         * @see #getCompanyName()
         * @generated
         */
	void setCompanyName(String value);

} // Company
