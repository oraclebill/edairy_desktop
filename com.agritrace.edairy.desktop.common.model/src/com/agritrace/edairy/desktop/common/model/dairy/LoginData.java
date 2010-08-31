/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Login Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.LoginData#getUsername <em>Username</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.LoginData#getPassword <em>Password</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.LoginData#isLocalEnabled <em>Local Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getLoginData()
 * @model annotation="teneo.jpa appinfo='@Embeddable'"
 * @generated
 */
public interface LoginData extends EObject {
	/**
	 * Returns the value of the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Username</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Username</em>' attribute.
	 * @see #setUsername(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getLoginData_Username()
	 * @model
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.LoginData#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getLoginData_Password()
	 * @model default=""
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.LoginData#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Local Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Enabled</em>' attribute.
	 * @see #setLocalEnabled(boolean)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getLoginData_LocalEnabled()
	 * @model default="true"
	 * @generated
	 */
	boolean isLocalEnabled();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.LoginData#isLocalEnabled <em>Local Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Enabled</em>' attribute.
	 * @see #isLocalEnabled()
	 * @generated
	 */
	void setLocalEnabled(boolean value);

} // LoginData
