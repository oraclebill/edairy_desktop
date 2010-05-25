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
 * A representation of the model object '<em><b>Vehicle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getRegistrationNumber <em>Registration Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getType <em>Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getMake <em>Make</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getModel <em>Model</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getEngineNumber <em>Engine Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getChassisNumber <em>Chassis Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getLogBookNumber <em>Log Book Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getInsurancePolicyNumber <em>Insurance Policy Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getInsuranceExpirationDate <em>Insurance Expiration Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getDominantColour <em>Dominant Colour</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getCapacityInTonnes <em>Capacity In Tonnes</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getYear <em>Year</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getDriver <em>Driver</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getAssetInfo <em>Asset Info</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getVehicleId <em>Vehicle Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle()
 * @model
 * @generated
 */
public interface Vehicle extends EObject {
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_RegistrationNumber()
	 * @model required="true"
	 * @generated
	 */
	String getRegistrationNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getRegistrationNumber <em>Registration Number</em>}' attribute.
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_Type()
	 * @model required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getType <em>Type</em>}' attribute.
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_Make()
	 * @model required="true"
	 * @generated
	 */
	String getMake();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getMake <em>Make</em>}' attribute.
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_Model()
	 * @model
	 * @generated
	 */
	String getModel();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getModel <em>Model</em>}' attribute.
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_EngineNumber()
	 * @model required="true"
	 * @generated
	 */
	String getEngineNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getEngineNumber <em>Engine Number</em>}' attribute.
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_ChassisNumber()
	 * @model required="true"
	 * @generated
	 */
	String getChassisNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getChassisNumber <em>Chassis Number</em>}' attribute.
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_LogBookNumber()
	 * @model required="true"
	 * @generated
	 */
	String getLogBookNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getLogBookNumber <em>Log Book Number</em>}' attribute.
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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_InsurancePolicyNumber()
	 * @model
	 * @generated
	 */
	String getInsurancePolicyNumber();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getInsurancePolicyNumber <em>Insurance Policy Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Insurance Policy Number</em>' attribute.
	 * @see #getInsurancePolicyNumber()
	 * @generated
	 */
	void setInsurancePolicyNumber(String value);

	/**
	 * Returns the value of the '<em><b>Insurance Expiration Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Insurance Expiration Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Insurance Expiration Date</em>' attribute.
	 * @see #setInsuranceExpirationDate(Date)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_InsuranceExpirationDate()
	 * @model
	 * @generated
	 */
	Date getInsuranceExpirationDate();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getInsuranceExpirationDate <em>Insurance Expiration Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Insurance Expiration Date</em>' attribute.
	 * @see #getInsuranceExpirationDate()
	 * @generated
	 */
	void setInsuranceExpirationDate(Date value);

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
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_DominantColour()
	 * @model
	 * @generated
	 */
	String getDominantColour();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getDominantColour <em>Dominant Colour</em>}' attribute.
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
	 * @see #setCapacityInTonnes(double)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_CapacityInTonnes()
	 * @model
	 * @generated
	 */
	double getCapacityInTonnes();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getCapacityInTonnes <em>Capacity In Tonnes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity In Tonnes</em>' attribute.
	 * @see #getCapacityInTonnes()
	 * @generated
	 */
	void setCapacityInTonnes(double value);

	/**
	 * Returns the value of the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Year</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Year</em>' attribute.
	 * @see #setYear(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_Year()
	 * @model
	 * @generated
	 */
	String getYear();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getYear <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Year</em>' attribute.
	 * @see #getYear()
	 * @generated
	 */
	void setYear(String value);

	/**
	 * Returns the value of the '<em><b>Driver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Driver</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driver</em>' reference.
	 * @see #setDriver(Employee)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_Driver()
	 * @model
	 * @generated
	 */
	Employee getDriver();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getDriver <em>Driver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driver</em>' reference.
	 * @see #getDriver()
	 * @generated
	 */
	void setDriver(Employee value);

	/**
	 * Returns the value of the '<em><b>Asset Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asset Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asset Info</em>' containment reference.
	 * @see #setAssetInfo(Asset)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_AssetInfo()
	 * @model containment="true"
	 * @generated
	 */
	Asset getAssetInfo();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getAssetInfo <em>Asset Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asset Info</em>' containment reference.
	 * @see #getAssetInfo()
	 * @generated
	 */
	void setAssetInfo(Asset value);

	/**
	 * Returns the value of the '<em><b>Vehicle Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vehicle Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle Id</em>' attribute.
	 * @see #setVehicleId(Long)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_VehicleId()
	 * @model dataType="com.agritrace.edairy.desktop.common.model.base.UniqueID"
	 *        extendedMetaData="name='vehicleId' kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@Id'"
	 * @generated
	 */
	Long getVehicleId();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getVehicleId <em>Vehicle Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle Id</em>' attribute.
	 * @see #getVehicleId()
	 * @generated
	 */
	void setVehicleId(Long value);

} // Vehicle
