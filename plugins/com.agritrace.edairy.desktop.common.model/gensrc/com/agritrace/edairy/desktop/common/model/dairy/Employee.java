/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import com.agritrace.edairy.desktop.common.model.base.Person;

import java.util.Date;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getId <em>Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getOperatorCode <em>Operator Code</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getJobFunction <em>Job Function</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getDepartment <em>Department</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getUsername <em>Username</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getPassword <em>Password</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#isLocalEnabled <em>Local Enabled</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getRole <em>Role</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#isPasswordHashed <em>Password Hashed</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getLicenseNo <em>License No</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee()
 * @model
 * @generated
 */
public interface Employee extends Person {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee_Id()
	 * @model required="true"
	 *        extendedMetaData="name='id' kind='elementOnly'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Operator Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator Code</em>' attribute.
	 * @see #setOperatorCode(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee_OperatorCode()
	 * @model
	 * @generated
	 */
	String getOperatorCode();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getOperatorCode <em>Operator Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator Code</em>' attribute.
	 * @see #getOperatorCode()
	 * @generated
	 */
	void setOperatorCode(String value);

	/**
	 * Returns the value of the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Date</em>' attribute.
	 * @see #setStartDate(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee_StartDate()
	 * @model required="true"
	 * @generated
	 */
	Date getStartDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getStartDate <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Date</em>' attribute.
	 * @see #getStartDate()
	 * @generated
	 */
	void setStartDate(Date value);

	/**
	 * Returns the value of the '<em><b>Job Function</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Job Function</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Job Function</em>' attribute.
	 * @see #setJobFunction(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee_JobFunction()
	 * @model
	 * @generated
	 */
	String getJobFunction();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getJobFunction <em>Job Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Job Function</em>' attribute.
	 * @see #getJobFunction()
	 * @generated
	 */
	void setJobFunction(String value);

	/**
	 * Returns the value of the '<em><b>Department</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Department</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Department</em>' attribute.
	 * @see #setDepartment(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee_Department()
	 * @model
	 * @generated
	 */
	String getDepartment();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getDepartment <em>Department</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Department</em>' attribute.
	 * @see #getDepartment()
	 * @generated
	 */
	void setDepartment(String value);

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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee_Username()
	 * @model annotation="teneo.jpa appinfo='@Column(unique=\"true\")'"
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getUsername <em>Username</em>}' attribute.
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee_Password()
	 * @model default=""
	 *        annotation="teneo.jpa appinfo='@Column(length=64)'"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getPassword <em>Password</em>}' attribute.
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee_LocalEnabled()
	 * @model default="true"
	 * @generated
	 */
	boolean isLocalEnabled();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#isLocalEnabled <em>Local Enabled</em>}' attribute.
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee_Role()
	 * @model
	 * @generated
	 */
	Role getRole();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getRole <em>Role</em>}' reference.
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee_PasswordHashed()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isPasswordHashed();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#isPasswordHashed <em>Password Hashed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password Hashed</em>' attribute.
	 * @see #isPasswordHashed()
	 * @generated
	 */
	void setPasswordHashed(boolean value);

	/**
	 * Returns the value of the '<em><b>License No</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>License No</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>License No</em>' attribute.
	 * @see #setLicenseNo(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee_LicenseNo()
	 * @model
	 * @generated
	 */
	String getLicenseNo();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getLicenseNo <em>License No</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>License No</em>' attribute.
	 * @see #getLicenseNo()
	 * @generated
	 */
	void setLicenseNo(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false" required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (licenseNo != null && !licenseNo.isEmpty()) {\n\t\t\treturn String.format(\"%s (%s)\", familyName, licenseNo);\n\t\t} else {\n\t\t\treturn familyName;\n\t\t}'"
	 * @generated
	 */
	String getNameAndLicense();

} // Employee