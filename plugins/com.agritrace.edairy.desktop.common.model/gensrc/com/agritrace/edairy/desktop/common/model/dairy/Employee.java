/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import com.agritrace.edairy.desktop.common.model.base.Person;

import com.agritrace.edairy.desktop.common.model.base.SystemUser;
import java.util.Date;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getEmployeeNumber <em>Employee Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getOperatorCode <em>Operator Code</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getJobFunction <em>Job Function</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getDepartment <em>Department</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getLicenseNo <em>License No</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getSystemIdentity <em>System Identity</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee()
 * @model
 * @generated
 */
public interface Employee extends Person {
	/**
	 * Returns the value of the '<em><b>Employee Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employee Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employee Number</em>' attribute.
	 * @see #setEmployeeNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee_EmployeeNumber()
	 * @model required="true"
	 *        extendedMetaData="name='id' kind='elementOnly'"
	 * @generated
	 */
	String getEmployeeNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getEmployeeNumber <em>Employee Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Employee Number</em>' attribute.
	 * @see #getEmployeeNumber()
	 * @generated
	 */
	void setEmployeeNumber(String value);

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
	 * Returns the value of the '<em><b>System Identity</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.agritrace.edairy.desktop.common.model.base.SystemUser#getRelatedEmployee <em>Related Employee</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Identity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Identity</em>' reference.
	 * @see #setSystemIdentity(SystemUser)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee_SystemIdentity()
	 * @see com.agritrace.edairy.desktop.common.model.base.SystemUser#getRelatedEmployee
	 * @model opposite="relatedEmployee"
	 * @generated
	 */
	SystemUser getSystemIdentity();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getSystemIdentity <em>System Identity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Identity</em>' reference.
	 * @see #getSystemIdentity()
	 * @generated
	 */
	void setSystemIdentity(SystemUser value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false" required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (licenseNo != null && !licenseNo.isEmpty()) {\n\t\t\treturn String.format(\"%s (%s)\", familyName, licenseNo);\n\t\t} else {\n\t\t\treturn familyName;\n\t\t}'"
	 * @generated
	 */
	String getNameAndLicense();

} // Employee
