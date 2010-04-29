/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vehicle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.dairy.Vehicle#getServiceRecords <em>Service Records</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Vehicle#getRegistrationNumber <em>Registration Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Vehicle#getType <em>Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Vehicle#getMake <em>Make</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Vehicle#getModel <em>Model</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Vehicle#getEngineNumber <em>Engine Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Vehicle#getChassisNumber <em>Chassis Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Vehicle#getLogBookNumber <em>Log Book Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Vehicle#getInsurancePolicyNumber <em>Insurance Policy Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Vehicle#getInsurancePurchaseDate <em>Insurance Purchase Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Vehicle#getPurchaseDate <em>Purchase Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Vehicle#getDisposalDate <em>Disposal Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Vehicle#getDominantColour <em>Dominant Colour</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.dairy.Vehicle#getCapacityInTonnes <em>Capacity In Tonnes</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.model.dairy.DairyPackage#getVehicle()
 * @model
 * @generated
 */
public interface Vehicle extends EObject {
	/**
	 * Returns the value of the '<em><b>Service Records</b></em>' containment reference list.
	 * The list contents are of type {@link com.agritrace.edairy.model.dairy.ServiceRecord}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Records</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Records</em>' containment reference list.
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getVehicle_ServiceRecords()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	EList<ServiceRecord> getServiceRecords();

	/**
	 * Returns the value of the '<em><b>Registration Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registration Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registration Number</em>' attribute.
	 * @see #setRegistrationNumber(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getVehicle_RegistrationNumber()
	 * @model required="true"
	 * @generated
	 */
	String getRegistrationNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Vehicle#getRegistrationNumber <em>Registration Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registration Number</em>' attribute.
	 * @see #getRegistrationNumber()
	 * @generated
	 */
	void setRegistrationNumber(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getVehicle_Type()
	 * @model required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Vehicle#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Make</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Make</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Make</em>' attribute.
	 * @see #setMake(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getVehicle_Make()
	 * @model required="true"
	 * @generated
	 */
	String getMake();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Vehicle#getMake <em>Make</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Make</em>' attribute.
	 * @see #getMake()
	 * @generated
	 */
	void setMake(String value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' attribute.
	 * @see #setModel(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getVehicle_Model()
	 * @model
	 * @generated
	 */
	String getModel();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Vehicle#getModel <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' attribute.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(String value);

	/**
	 * Returns the value of the '<em><b>Engine Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine Number</em>' attribute.
	 * @see #setEngineNumber(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getVehicle_EngineNumber()
	 * @model required="true"
	 * @generated
	 */
	String getEngineNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Vehicle#getEngineNumber <em>Engine Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Engine Number</em>' attribute.
	 * @see #getEngineNumber()
	 * @generated
	 */
	void setEngineNumber(String value);

	/**
	 * Returns the value of the '<em><b>Chassis Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chassis Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chassis Number</em>' attribute.
	 * @see #setChassisNumber(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getVehicle_ChassisNumber()
	 * @model required="true"
	 * @generated
	 */
	String getChassisNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Vehicle#getChassisNumber <em>Chassis Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chassis Number</em>' attribute.
	 * @see #getChassisNumber()
	 * @generated
	 */
	void setChassisNumber(String value);

	/**
	 * Returns the value of the '<em><b>Log Book Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Book Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Book Number</em>' attribute.
	 * @see #setLogBookNumber(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getVehicle_LogBookNumber()
	 * @model required="true"
	 * @generated
	 */
	String getLogBookNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Vehicle#getLogBookNumber <em>Log Book Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Book Number</em>' attribute.
	 * @see #getLogBookNumber()
	 * @generated
	 */
	void setLogBookNumber(String value);

	/**
	 * Returns the value of the '<em><b>Insurance Policy Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Insurance Policy Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Insurance Policy Number</em>' attribute.
	 * @see #setInsurancePolicyNumber(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getVehicle_InsurancePolicyNumber()
	 * @model
	 * @generated
	 */
	String getInsurancePolicyNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Vehicle#getInsurancePolicyNumber <em>Insurance Policy Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Insurance Policy Number</em>' attribute.
	 * @see #getInsurancePolicyNumber()
	 * @generated
	 */
	void setInsurancePolicyNumber(String value);

	/**
	 * Returns the value of the '<em><b>Insurance Purchase Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Insurance Purchase Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Insurance Purchase Date</em>' attribute.
	 * @see #setInsurancePurchaseDate(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getVehicle_InsurancePurchaseDate()
	 * @model
	 * @generated
	 */
	String getInsurancePurchaseDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Vehicle#getInsurancePurchaseDate <em>Insurance Purchase Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Insurance Purchase Date</em>' attribute.
	 * @see #getInsurancePurchaseDate()
	 * @generated
	 */
	void setInsurancePurchaseDate(String value);

	/**
	 * Returns the value of the '<em><b>Purchase Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Purchase Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Purchase Date</em>' attribute.
	 * @see #setPurchaseDate(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getVehicle_PurchaseDate()
	 * @model required="true"
	 * @generated
	 */
	String getPurchaseDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Vehicle#getPurchaseDate <em>Purchase Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Purchase Date</em>' attribute.
	 * @see #getPurchaseDate()
	 * @generated
	 */
	void setPurchaseDate(String value);

	/**
	 * Returns the value of the '<em><b>Disposal Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disposal Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disposal Date</em>' attribute.
	 * @see #setDisposalDate(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getVehicle_DisposalDate()
	 * @model
	 * @generated
	 */
	String getDisposalDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Vehicle#getDisposalDate <em>Disposal Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disposal Date</em>' attribute.
	 * @see #getDisposalDate()
	 * @generated
	 */
	void setDisposalDate(String value);

	/**
	 * Returns the value of the '<em><b>Dominant Colour</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dominant Colour</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dominant Colour</em>' attribute.
	 * @see #setDominantColour(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getVehicle_DominantColour()
	 * @model
	 * @generated
	 */
	String getDominantColour();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Vehicle#getDominantColour <em>Dominant Colour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dominant Colour</em>' attribute.
	 * @see #getDominantColour()
	 * @generated
	 */
	void setDominantColour(String value);

	/**
	 * Returns the value of the '<em><b>Capacity In Tonnes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capacity In Tonnes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity In Tonnes</em>' attribute.
	 * @see #setCapacityInTonnes(String)
	 * @see com.agritrace.edairy.model.dairy.DairyPackage#getVehicle_CapacityInTonnes()
	 * @model
	 * @generated
	 */
	String getCapacityInTonnes();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.model.dairy.Vehicle#getCapacityInTonnes <em>Capacity In Tonnes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity In Tonnes</em>' attribute.
	 * @see #getCapacityInTonnes()
	 * @generated
	 */
	void setCapacityInTonnes(String value);

} // Vehicle
