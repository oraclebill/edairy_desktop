/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy;

import java.util.Date;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scale Import Record</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getScaleSerial <em>Scale Serial</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getCollectionTime <em>Collection Time</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getCenterNumber <em>Center Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getNumCans <em>Num Cans</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getTripNumber <em>Trip Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getOperatorCode <em>Operator Code</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#isValidated <em>Validated</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getScaleImportRecord()
 * @model
 * @generated
 */
public interface ScaleImportRecord extends CollectionJournalLine {
	/**
	 * Returns the value of the '<em><b>Scale Serial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale Serial</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale Serial</em>' attribute.
	 * @see #setScaleSerial(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getScaleImportRecord_ScaleSerial()
	 * @model
	 * @generated
	 */
	String getScaleSerial();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getScaleSerial <em>Scale Serial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale Serial</em>' attribute.
	 * @see #getScaleSerial()
	 * @generated
	 */
	void setScaleSerial(String value);

	/**
	 * Returns the value of the '<em><b>Collection Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Time</em>' attribute.
	 * @see #setCollectionTime(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getScaleImportRecord_CollectionTime()
	 * @model
	 * @generated
	 */
	Date getCollectionTime();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getCollectionTime <em>Collection Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Time</em>' attribute.
	 * @see #getCollectionTime()
	 * @generated
	 */
	void setCollectionTime(Date value);

	/**
	 * Returns the value of the '<em><b>Center Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Center Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Center Number</em>' attribute.
	 * @see #setCenterNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getScaleImportRecord_CenterNumber()
	 * @model
	 * @generated
	 */
	String getCenterNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getCenterNumber <em>Center Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Center Number</em>' attribute.
	 * @see #getCenterNumber()
	 * @generated
	 */
	void setCenterNumber(String value);

	/**
	 * Returns the value of the '<em><b>Num Cans</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Cans</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Cans</em>' attribute.
	 * @see #setNumCans(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getScaleImportRecord_NumCans()
	 * @model
	 * @generated
	 */
	String getNumCans();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getNumCans <em>Num Cans</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Cans</em>' attribute.
	 * @see #getNumCans()
	 * @generated
	 */
	void setNumCans(String value);

	/**
	 * Returns the value of the '<em><b>Trip Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trip Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trip Number</em>' attribute.
	 * @see #setTripNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getScaleImportRecord_TripNumber()
	 * @model
	 * @generated
	 */
	String getTripNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getTripNumber <em>Trip Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trip Number</em>' attribute.
	 * @see #getTripNumber()
	 * @generated
	 */
	void setTripNumber(String value);

	/**
	 * Returns the value of the '<em><b>Operator Code</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator Code</em>' attribute.
	 * @see #setOperatorCode(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getScaleImportRecord_OperatorCode()
	 * @model default=""
	 * @generated
	 */
	String getOperatorCode();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#getOperatorCode <em>Operator Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator Code</em>' attribute.
	 * @see #getOperatorCode()
	 * @generated
	 */
	void setOperatorCode(String value);

	/**
	 * Returns the value of the '<em><b>Validated</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validated</em>' attribute.
	 * @see #setValidated(boolean)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getScaleImportRecord_Validated()
	 * @model default="false"
	 * @generated
	 */
	boolean isValidated();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.ScaleImportRecord#isValidated <em>Validated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validated</em>' attribute.
	 * @see #isValidated()
	 * @generated
	 */
	void setValidated(boolean value);

} // ScaleImportRecord
