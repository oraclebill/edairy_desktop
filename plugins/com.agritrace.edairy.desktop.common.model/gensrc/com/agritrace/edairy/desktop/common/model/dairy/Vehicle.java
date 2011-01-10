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
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getVehicleId <em>Vehicle Id</em>}</li>
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
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle()
 * @model
 * @generated
 */
public interface Vehicle extends EObject {
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
	 * @model id="true" dataType="com.agritrace.edairy.desktop.common.model.base.UniqueID" required="true"
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

	/**
	 * Returns the value of the '<em><b>Registration Number</b></em>' attribute.
	 * The default value is <code>" "</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registration Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registration Number</em>' attribute.
	 * @see #setRegistrationNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_RegistrationNumber()
	 * @model default=" " required="true"
	 *        extendedMetaData="name='registrationNumber' kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@NaturalId\n'"
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
	 * The default value is <code>" "</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_Type()
	 * @model default=" " required="true"
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
	 * The default value is <code>" "</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Make</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Make</em>' attribute.
	 * @see #setMake(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_Make()
	 * @model default=" " required="true"
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
	 * The default value is <code>" "</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' attribute.
	 * @see #setModel(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_Model()
	 * @model default=" "
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
	 * The default value is <code>" "</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine Number</em>' attribute.
	 * @see #setEngineNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_EngineNumber()
	 * @model default=" " required="true"
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
	 * The default value is <code>" "</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chassis Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chassis Number</em>' attribute.
	 * @see #setChassisNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_ChassisNumber()
	 * @model default=" " required="true"
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
	 * The default value is <code>" "</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Book Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Book Number</em>' attribute.
	 * @see #setLogBookNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_LogBookNumber()
	 * @model default=" " required="true"
	 *        extendedMetaData="name='logBookNumber' kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@Column(unique=true)\n'"
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
	 * The default value is <code>" "</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Insurance Policy Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Insurance Policy Number</em>' attribute.
	 * @see #setInsurancePolicyNumber(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_InsurancePolicyNumber()
	 * @model default=" "
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
	 * The default value is <code>" "</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dominant Colour</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dominant Colour</em>' attribute.
	 * @see #setDominantColour(String)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_DominantColour()
	 * @model default=" "
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
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capacity In Tonnes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity In Tonnes</em>' attribute.
	 * @see #setCapacityInTonnes(double)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_CapacityInTonnes()
	 * @model default="0"
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
	 * The default value is <code>"2005"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Year</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Year</em>' attribute.
	 * @see #setYear(Integer)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_Year()
	 * @model default="2005"
	 * @generated
	 */
	Integer getYear();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getYear <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Year</em>' attribute.
	 * @see #getYear()
	 * @generated
	 */
	void setYear(Integer value);

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
	 * Returns the value of the '<em><b>Asset Info</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asset Info</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asset Info</em>' reference.
	 * @see #setAssetInfo(Asset)
	 * @see com.agritrace.edairy.desktop.common.model.dairy.DairyPackage#getVehicle_AssetInfo()
	 * @model extendedMetaData="name='assetInfo' kind='elementOnly'"
	 *        annotation="teneo.jpa appinfo='@Embedded'"
	 * @generated
	 */
	Asset getAssetInfo();

	/**
	 * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.dairy.Vehicle#getAssetInfo <em>Asset Info</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asset Info</em>' reference.
	 * @see #getAssetInfo()
	 * @generated
	 */
	void setAssetInfo(Asset value);

} // Vehicle
