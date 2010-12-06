/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#getUsername <em>Username</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#getPassword <em>Password</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#getRelatedEmployee <em>Related Employee</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#isLocalEnabled <em>Local Enabled</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#getRole <em>Role</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#isPasswordHashed <em>Password Hashed</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getSystemUser()
 * @model
 * @generated
 */
public interface SystemUser extends EObject {
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
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getSystemUser_Username()
	 * @model annotation="teneo.jpa appinfo='@Column(unique=\"true\")'"
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#getUsername <em>Username</em>}' attribute.
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
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getSystemUser_Password()
	 * @model default=""
	 *        annotation="teneo.jpa appinfo='@Column(length=64)'"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Related Employee</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getSystemIdentity <em>System Identity</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Employee</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Employee</em>' reference.
	 * @see #setRelatedEmployee(Employee)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getSystemUser_RelatedEmployee()
	 * @see com.agritrace.edairy.desktop.common.model.dairy.Employee#getSystemIdentity
	 * @model opposite="systemIdentity"
	 * @generated
	 */
	Employee getRelatedEmployee();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#getRelatedEmployee <em>Related Employee</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Employee</em>' reference.
	 * @see #getRelatedEmployee()
	 * @generated
	 */
	void setRelatedEmployee(Employee value);

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
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getSystemUser_LocalEnabled()
	 * @model default="true"
	 * @generated
	 */
	boolean isLocalEnabled();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#isLocalEnabled <em>Local Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Enabled</em>' attribute.
	 * @see #isLocalEnabled()
	 * @generated
	 */
	void setLocalEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' reference.
	 * @see #setRole(Role)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getSystemUser_Role()
	 * @model
	 * @generated
	 */
	Role getRole();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#getRole <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' reference.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(Role value);

	/**
	 * Returns the value of the '<em><b>Password Hashed</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password Hashed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password Hashed</em>' attribute.
	 * @see #setPasswordHashed(boolean)
	 * @see com.agritrace.edairy.desktop.common.model.base.ModelPackage#getSystemUser_PasswordHashed()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isPasswordHashed();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#isPasswordHashed <em>Password Hashed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password Hashed</em>' attribute.
	 * @see #isPasswordHashed()
	 * @generated
	 */
	void setPasswordHashed(boolean value);

} // SystemUser
