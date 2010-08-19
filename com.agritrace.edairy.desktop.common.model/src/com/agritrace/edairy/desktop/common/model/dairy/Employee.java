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
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getNumber <em>Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getOperatorCode <em>Operator Code</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getJobFunction <em>Job Function</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getDepartment <em>Department</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getNationalId <em>National Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getNhifNumber <em>Nhif Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getNssfNumber <em>Nssf Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getSecurityRole <em>Security Role</em>}</li>
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
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee_Number()
	 * @model
	 * @generated
	 */
	String getNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(String value);

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
	 * Returns the value of the '<em><b>National Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>National Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>National Id</em>' attribute.
	 * @see #setNationalId(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee_NationalId()
	 * @model ordered="false"
	 * @generated
	 */
	String getNationalId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getNationalId <em>National Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>National Id</em>' attribute.
	 * @see #getNationalId()
	 * @generated
	 */
	void setNationalId(String value);

	/**
	 * Returns the value of the '<em><b>Nhif Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nhif Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nhif Number</em>' attribute.
	 * @see #setNhifNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee_NhifNumber()
	 * @model
	 * @generated
	 */
	String getNhifNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getNhifNumber <em>Nhif Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nhif Number</em>' attribute.
	 * @see #getNhifNumber()
	 * @generated
	 */
	void setNhifNumber(String value);

	/**
	 * Returns the value of the '<em><b>Nssf Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nssf Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nssf Number</em>' attribute.
	 * @see #setNssfNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee_NssfNumber()
	 * @model
	 * @generated
	 */
	String getNssfNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getNssfNumber <em>Nssf Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nssf Number</em>' attribute.
	 * @see #getNssfNumber()
	 * @generated
	 */
	void setNssfNumber(String value);

	/**
	 * Returns the value of the '<em><b>Security Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Security Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Role</em>' attribute.
	 * @see #setSecurityRole(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getEmployee_SecurityRole()
	 * @model
	 * @generated
	 */
	String getSecurityRole();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Employee#getSecurityRole <em>Security Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Security Role</em>' attribute.
	 * @see #getSecurityRole()
	 * @generated
	 */
	void setSecurityRole(String value);

} // Employee
