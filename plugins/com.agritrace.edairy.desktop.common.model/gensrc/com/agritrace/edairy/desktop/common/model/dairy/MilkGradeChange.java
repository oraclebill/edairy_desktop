/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Milk Grade Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getDate <em>Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getStartingGrade <em>Starting Grade</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getEndingGrade <em>Ending Grade</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getChangedBy <em>Changed By</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getReason <em>Reason</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkGradeChange()
 * @model
 * @generated
 */
public interface MilkGradeChange extends EObject {
	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkGradeChange_Date()
	 * @model required="true"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Starting Grade</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Starting Grade</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Starting Grade</em>' reference.
	 * @see #setStartingGrade(MilkGrade)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkGradeChange_StartingGrade()
	 * @model required="true"
	 * @generated
	 */
	MilkGrade getStartingGrade();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getStartingGrade <em>Starting Grade</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Starting Grade</em>' reference.
	 * @see #getStartingGrade()
	 * @generated
	 */
	void setStartingGrade(MilkGrade value);

	/**
	 * Returns the value of the '<em><b>Ending Grade</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ending Grade</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ending Grade</em>' reference.
	 * @see #setEndingGrade(MilkGrade)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkGradeChange_EndingGrade()
	 * @model required="true"
	 * @generated
	 */
	MilkGrade getEndingGrade();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getEndingGrade <em>Ending Grade</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ending Grade</em>' reference.
	 * @see #getEndingGrade()
	 * @generated
	 */
	void setEndingGrade(MilkGrade value);

	/**
	 * Returns the value of the '<em><b>Changed By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changed By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Changed By</em>' reference.
	 * @see #setChangedBy(Employee)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkGradeChange_ChangedBy()
	 * @model
	 * @generated
	 */
	Employee getChangedBy();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getChangedBy <em>Changed By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Changed By</em>' reference.
	 * @see #getChangedBy()
	 * @generated
	 */
	void setChangedBy(Employee value);

	/**
	 * Returns the value of the '<em><b>Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reason</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reason</em>' attribute.
	 * @see #setReason(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getMilkGradeChange_Reason()
	 * @model
	 * @generated
	 */
	String getReason();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.MilkGradeChange#getReason <em>Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reason</em>' attribute.
	 * @see #getReason()
	 * @generated
	 */
	void setReason(String value);

} // MilkGradeChange
