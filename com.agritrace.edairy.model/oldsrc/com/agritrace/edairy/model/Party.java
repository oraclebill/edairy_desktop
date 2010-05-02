/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Party</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.Party#getName <em>Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.Party#getPhoneNumber <em>Phone Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.Party#getLocation <em>Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.Party#getEReference0 <em>EReference0</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.Party#getContactMethods <em>Contact Methods</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.ModelPackage#getParty()
 * @model abstract="true"
 * @generated
 */
public interface Party extends EObject {
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
	 * @see com.agritrace.edairy.model.ModelPackage#getParty_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.Party#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phone Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phone Number</em>' attribute.
	 * @see #setPhoneNumber(String)
	 * @see com.agritrace.edairy.model.ModelPackage#getParty_PhoneNumber()
	 * @model
	 * @generated
	 */
	String getPhoneNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.Party#getPhoneNumber <em>Phone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phone Number</em>' attribute.
	 * @see #getPhoneNumber()
	 * @generated
	 */
	void setPhoneNumber(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' containment reference.
	 * @see #setLocation(Location)
	 * @see com.agritrace.edairy.model.ModelPackage#getParty_Location()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	Location getLocation();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.Party#getLocation <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' containment reference.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Location value);

	/**
	 * Returns the value of the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference0</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference0</em>' reference.
	 * @see #setEReference0(Location)
	 * @see com.agritrace.edairy.model.ModelPackage#getParty_EReference0()
	 * @model
	 * @generated
	 */
	Location getEReference0();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.Party#getEReference0 <em>EReference0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference0</em>' reference.
	 * @see #getEReference0()
	 * @generated
	 */
	void setEReference0(Location value);

	/**
	 * Returns the value of the '<em><b>Contact Methods</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.model.ContactMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contact Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contact Methods</em>' containment reference list.
	 * @see com.agritrace.edairy.model.ModelPackage#getParty_ContactMethods()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ContactMethod> getContactMethods();

} // Party
