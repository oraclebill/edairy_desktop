/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.dairy.Asset;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vehicle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl#getVehicleId <em>Vehicle Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl#getRegistrationNumber <em>Registration Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl#getMake <em>Make</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl#getModel <em>Model</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl#getEngineNumber <em>Engine Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl#getChassisNumber <em>Chassis Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl#getLogBookNumber <em>Log Book Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl#getInsurancePolicyNumber <em>Insurance Policy Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl#getInsuranceExpirationDate <em>Insurance Expiration Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl#getDominantColour <em>Dominant Colour</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl#getCapacityInTonnes <em>Capacity In Tonnes</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl#getYear <em>Year</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl#getDriver <em>Driver</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.VehicleImpl#getAssetInfo <em>Asset Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VehicleImpl extends EObjectImpl implements Vehicle {
	/**
	 * The default value of the '{@link #getVehicleId() <em>Vehicle Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleId()
	 * @generated
	 * @ordered
	 */
	protected static final Long VEHICLE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVehicleId() <em>Vehicle Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleId()
	 * @generated
	 * @ordered
	 */
	protected Long vehicleId = VEHICLE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getRegistrationNumber() <em>Registration Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistrationNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String REGISTRATION_NUMBER_EDEFAULT = " ";

	/**
	 * The cached value of the '{@link #getRegistrationNumber() <em>Registration Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistrationNumber()
	 * @generated
	 * @ordered
	 */
	protected String registrationNumber = REGISTRATION_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = " ";

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMake() <em>Make</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMake()
	 * @generated
	 * @ordered
	 */
	protected static final String MAKE_EDEFAULT = " ";

	/**
	 * The cached value of the '{@link #getMake() <em>Make</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMake()
	 * @generated
	 * @ordered
	 */
	protected String make = MAKE_EDEFAULT;

	/**
	 * The default value of the '{@link #getModel() <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_EDEFAULT = " ";

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected String model = MODEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getEngineNumber() <em>Engine Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngineNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String ENGINE_NUMBER_EDEFAULT = " ";

	/**
	 * The cached value of the '{@link #getEngineNumber() <em>Engine Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngineNumber()
	 * @generated
	 * @ordered
	 */
	protected String engineNumber = ENGINE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getChassisNumber() <em>Chassis Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChassisNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String CHASSIS_NUMBER_EDEFAULT = " ";

	/**
	 * The cached value of the '{@link #getChassisNumber() <em>Chassis Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChassisNumber()
	 * @generated
	 * @ordered
	 */
	protected String chassisNumber = CHASSIS_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogBookNumber() <em>Log Book Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogBookNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String LOG_BOOK_NUMBER_EDEFAULT = " ";

	/**
	 * The cached value of the '{@link #getLogBookNumber() <em>Log Book Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogBookNumber()
	 * @generated
	 * @ordered
	 */
	protected String logBookNumber = LOG_BOOK_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getInsurancePolicyNumber() <em>Insurance Policy Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsurancePolicyNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String INSURANCE_POLICY_NUMBER_EDEFAULT = " ";

	/**
	 * The cached value of the '{@link #getInsurancePolicyNumber() <em>Insurance Policy Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsurancePolicyNumber()
	 * @generated
	 * @ordered
	 */
	protected String insurancePolicyNumber = INSURANCE_POLICY_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getInsuranceExpirationDate() <em>Insurance Expiration Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsuranceExpirationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date INSURANCE_EXPIRATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInsuranceExpirationDate() <em>Insurance Expiration Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsuranceExpirationDate()
	 * @generated
	 * @ordered
	 */
	protected Date insuranceExpirationDate = INSURANCE_EXPIRATION_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDominantColour() <em>Dominant Colour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDominantColour()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMINANT_COLOUR_EDEFAULT = " ";

	/**
	 * The cached value of the '{@link #getDominantColour() <em>Dominant Colour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDominantColour()
	 * @generated
	 * @ordered
	 */
	protected String dominantColour = DOMINANT_COLOUR_EDEFAULT;

	/**
	 * The default value of the '{@link #getCapacityInTonnes() <em>Capacity In Tonnes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacityInTonnes()
	 * @generated
	 * @ordered
	 */
	protected static final double CAPACITY_IN_TONNES_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCapacityInTonnes() <em>Capacity In Tonnes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacityInTonnes()
	 * @generated
	 * @ordered
	 */
	protected double capacityInTonnes = CAPACITY_IN_TONNES_EDEFAULT;

	/**
	 * The default value of the '{@link #getYear() <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYear()
	 * @generated
	 * @ordered
	 */
	protected static final Integer YEAR_EDEFAULT = new Integer(2005);

	/**
	 * The cached value of the '{@link #getYear() <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYear()
	 * @generated
	 * @ordered
	 */
	protected Integer year = YEAR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDriver() <em>Driver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriver()
	 * @generated
	 * @ordered
	 */
	protected Employee driver;

	/**
	 * The cached value of the '{@link #getAssetInfo() <em>Asset Info</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssetInfo()
	 * @generated
	 * @ordered
	 */
	protected Asset assetInfo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VehicleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.VEHICLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getVehicleId() {
		return vehicleId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVehicleId(Long newVehicleId) {
		Long oldVehicleId = vehicleId;
		vehicleId = newVehicleId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__VEHICLE_ID, oldVehicleId, vehicleId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistrationNumber(String newRegistrationNumber) {
		String oldRegistrationNumber = registrationNumber;
		registrationNumber = newRegistrationNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__REGISTRATION_NUMBER, oldRegistrationNumber, registrationNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMake() {
		return make;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMake(String newMake) {
		String oldMake = make;
		make = newMake;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__MAKE, oldMake, make));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(String newModel) {
		String oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEngineNumber() {
		return engineNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEngineNumber(String newEngineNumber) {
		String oldEngineNumber = engineNumber;
		engineNumber = newEngineNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__ENGINE_NUMBER, oldEngineNumber, engineNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChassisNumber() {
		return chassisNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChassisNumber(String newChassisNumber) {
		String oldChassisNumber = chassisNumber;
		chassisNumber = newChassisNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__CHASSIS_NUMBER, oldChassisNumber, chassisNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogBookNumber() {
		return logBookNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogBookNumber(String newLogBookNumber) {
		String oldLogBookNumber = logBookNumber;
		logBookNumber = newLogBookNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__LOG_BOOK_NUMBER, oldLogBookNumber, logBookNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInsurancePolicyNumber() {
		return insurancePolicyNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInsurancePolicyNumber(String newInsurancePolicyNumber) {
		String oldInsurancePolicyNumber = insurancePolicyNumber;
		insurancePolicyNumber = newInsurancePolicyNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__INSURANCE_POLICY_NUMBER, oldInsurancePolicyNumber, insurancePolicyNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getInsuranceExpirationDate() {
		return insuranceExpirationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInsuranceExpirationDate(Date newInsuranceExpirationDate) {
		Date oldInsuranceExpirationDate = insuranceExpirationDate;
		insuranceExpirationDate = newInsuranceExpirationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__INSURANCE_EXPIRATION_DATE, oldInsuranceExpirationDate, insuranceExpirationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDominantColour() {
		return dominantColour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDominantColour(String newDominantColour) {
		String oldDominantColour = dominantColour;
		dominantColour = newDominantColour;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__DOMINANT_COLOUR, oldDominantColour, dominantColour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCapacityInTonnes() {
		return capacityInTonnes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacityInTonnes(double newCapacityInTonnes) {
		double oldCapacityInTonnes = capacityInTonnes;
		capacityInTonnes = newCapacityInTonnes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__CAPACITY_IN_TONNES, oldCapacityInTonnes, capacityInTonnes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYear(Integer newYear) {
		Integer oldYear = year;
		year = newYear;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__YEAR, oldYear, year));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee getDriver() {
		if (driver != null && driver.eIsProxy()) {
			InternalEObject oldDriver = (InternalEObject)driver;
			driver = (Employee)eResolveProxy(oldDriver);
			if (driver != oldDriver) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.VEHICLE__DRIVER, oldDriver, driver));
			}
		}
		return driver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee basicGetDriver() {
		return driver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDriver(Employee newDriver) {
		Employee oldDriver = driver;
		driver = newDriver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__DRIVER, oldDriver, driver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Asset getAssetInfo() {
		if (assetInfo != null && assetInfo.eIsProxy()) {
			InternalEObject oldAssetInfo = (InternalEObject)assetInfo;
			assetInfo = (Asset)eResolveProxy(oldAssetInfo);
			if (assetInfo != oldAssetInfo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.VEHICLE__ASSET_INFO, oldAssetInfo, assetInfo));
			}
		}
		return assetInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Asset basicGetAssetInfo() {
		return assetInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssetInfo(Asset newAssetInfo) {
		Asset oldAssetInfo = assetInfo;
		assetInfo = newAssetInfo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__ASSET_INFO, oldAssetInfo, assetInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DairyPackage.VEHICLE__VEHICLE_ID:
				return getVehicleId();
			case DairyPackage.VEHICLE__REGISTRATION_NUMBER:
				return getRegistrationNumber();
			case DairyPackage.VEHICLE__TYPE:
				return getType();
			case DairyPackage.VEHICLE__MAKE:
				return getMake();
			case DairyPackage.VEHICLE__MODEL:
				return getModel();
			case DairyPackage.VEHICLE__ENGINE_NUMBER:
				return getEngineNumber();
			case DairyPackage.VEHICLE__CHASSIS_NUMBER:
				return getChassisNumber();
			case DairyPackage.VEHICLE__LOG_BOOK_NUMBER:
				return getLogBookNumber();
			case DairyPackage.VEHICLE__INSURANCE_POLICY_NUMBER:
				return getInsurancePolicyNumber();
			case DairyPackage.VEHICLE__INSURANCE_EXPIRATION_DATE:
				return getInsuranceExpirationDate();
			case DairyPackage.VEHICLE__DOMINANT_COLOUR:
				return getDominantColour();
			case DairyPackage.VEHICLE__CAPACITY_IN_TONNES:
				return getCapacityInTonnes();
			case DairyPackage.VEHICLE__YEAR:
				return getYear();
			case DairyPackage.VEHICLE__DRIVER:
				if (resolve) return getDriver();
				return basicGetDriver();
			case DairyPackage.VEHICLE__ASSET_INFO:
				if (resolve) return getAssetInfo();
				return basicGetAssetInfo();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DairyPackage.VEHICLE__VEHICLE_ID:
				setVehicleId((Long)newValue);
				return;
			case DairyPackage.VEHICLE__REGISTRATION_NUMBER:
				setRegistrationNumber((String)newValue);
				return;
			case DairyPackage.VEHICLE__TYPE:
				setType((String)newValue);
				return;
			case DairyPackage.VEHICLE__MAKE:
				setMake((String)newValue);
				return;
			case DairyPackage.VEHICLE__MODEL:
				setModel((String)newValue);
				return;
			case DairyPackage.VEHICLE__ENGINE_NUMBER:
				setEngineNumber((String)newValue);
				return;
			case DairyPackage.VEHICLE__CHASSIS_NUMBER:
				setChassisNumber((String)newValue);
				return;
			case DairyPackage.VEHICLE__LOG_BOOK_NUMBER:
				setLogBookNumber((String)newValue);
				return;
			case DairyPackage.VEHICLE__INSURANCE_POLICY_NUMBER:
				setInsurancePolicyNumber((String)newValue);
				return;
			case DairyPackage.VEHICLE__INSURANCE_EXPIRATION_DATE:
				setInsuranceExpirationDate((Date)newValue);
				return;
			case DairyPackage.VEHICLE__DOMINANT_COLOUR:
				setDominantColour((String)newValue);
				return;
			case DairyPackage.VEHICLE__CAPACITY_IN_TONNES:
				setCapacityInTonnes((Double)newValue);
				return;
			case DairyPackage.VEHICLE__YEAR:
				setYear((Integer)newValue);
				return;
			case DairyPackage.VEHICLE__DRIVER:
				setDriver((Employee)newValue);
				return;
			case DairyPackage.VEHICLE__ASSET_INFO:
				setAssetInfo((Asset)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DairyPackage.VEHICLE__VEHICLE_ID:
				setVehicleId(VEHICLE_ID_EDEFAULT);
				return;
			case DairyPackage.VEHICLE__REGISTRATION_NUMBER:
				setRegistrationNumber(REGISTRATION_NUMBER_EDEFAULT);
				return;
			case DairyPackage.VEHICLE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case DairyPackage.VEHICLE__MAKE:
				setMake(MAKE_EDEFAULT);
				return;
			case DairyPackage.VEHICLE__MODEL:
				setModel(MODEL_EDEFAULT);
				return;
			case DairyPackage.VEHICLE__ENGINE_NUMBER:
				setEngineNumber(ENGINE_NUMBER_EDEFAULT);
				return;
			case DairyPackage.VEHICLE__CHASSIS_NUMBER:
				setChassisNumber(CHASSIS_NUMBER_EDEFAULT);
				return;
			case DairyPackage.VEHICLE__LOG_BOOK_NUMBER:
				setLogBookNumber(LOG_BOOK_NUMBER_EDEFAULT);
				return;
			case DairyPackage.VEHICLE__INSURANCE_POLICY_NUMBER:
				setInsurancePolicyNumber(INSURANCE_POLICY_NUMBER_EDEFAULT);
				return;
			case DairyPackage.VEHICLE__INSURANCE_EXPIRATION_DATE:
				setInsuranceExpirationDate(INSURANCE_EXPIRATION_DATE_EDEFAULT);
				return;
			case DairyPackage.VEHICLE__DOMINANT_COLOUR:
				setDominantColour(DOMINANT_COLOUR_EDEFAULT);
				return;
			case DairyPackage.VEHICLE__CAPACITY_IN_TONNES:
				setCapacityInTonnes(CAPACITY_IN_TONNES_EDEFAULT);
				return;
			case DairyPackage.VEHICLE__YEAR:
				setYear(YEAR_EDEFAULT);
				return;
			case DairyPackage.VEHICLE__DRIVER:
				setDriver((Employee)null);
				return;
			case DairyPackage.VEHICLE__ASSET_INFO:
				setAssetInfo((Asset)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DairyPackage.VEHICLE__VEHICLE_ID:
				return VEHICLE_ID_EDEFAULT == null ? vehicleId != null : !VEHICLE_ID_EDEFAULT.equals(vehicleId);
			case DairyPackage.VEHICLE__REGISTRATION_NUMBER:
				return REGISTRATION_NUMBER_EDEFAULT == null ? registrationNumber != null : !REGISTRATION_NUMBER_EDEFAULT.equals(registrationNumber);
			case DairyPackage.VEHICLE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case DairyPackage.VEHICLE__MAKE:
				return MAKE_EDEFAULT == null ? make != null : !MAKE_EDEFAULT.equals(make);
			case DairyPackage.VEHICLE__MODEL:
				return MODEL_EDEFAULT == null ? model != null : !MODEL_EDEFAULT.equals(model);
			case DairyPackage.VEHICLE__ENGINE_NUMBER:
				return ENGINE_NUMBER_EDEFAULT == null ? engineNumber != null : !ENGINE_NUMBER_EDEFAULT.equals(engineNumber);
			case DairyPackage.VEHICLE__CHASSIS_NUMBER:
				return CHASSIS_NUMBER_EDEFAULT == null ? chassisNumber != null : !CHASSIS_NUMBER_EDEFAULT.equals(chassisNumber);
			case DairyPackage.VEHICLE__LOG_BOOK_NUMBER:
				return LOG_BOOK_NUMBER_EDEFAULT == null ? logBookNumber != null : !LOG_BOOK_NUMBER_EDEFAULT.equals(logBookNumber);
			case DairyPackage.VEHICLE__INSURANCE_POLICY_NUMBER:
				return INSURANCE_POLICY_NUMBER_EDEFAULT == null ? insurancePolicyNumber != null : !INSURANCE_POLICY_NUMBER_EDEFAULT.equals(insurancePolicyNumber);
			case DairyPackage.VEHICLE__INSURANCE_EXPIRATION_DATE:
				return INSURANCE_EXPIRATION_DATE_EDEFAULT == null ? insuranceExpirationDate != null : !INSURANCE_EXPIRATION_DATE_EDEFAULT.equals(insuranceExpirationDate);
			case DairyPackage.VEHICLE__DOMINANT_COLOUR:
				return DOMINANT_COLOUR_EDEFAULT == null ? dominantColour != null : !DOMINANT_COLOUR_EDEFAULT.equals(dominantColour);
			case DairyPackage.VEHICLE__CAPACITY_IN_TONNES:
				return capacityInTonnes != CAPACITY_IN_TONNES_EDEFAULT;
			case DairyPackage.VEHICLE__YEAR:
				return YEAR_EDEFAULT == null ? year != null : !YEAR_EDEFAULT.equals(year);
			case DairyPackage.VEHICLE__DRIVER:
				return driver != null;
			case DairyPackage.VEHICLE__ASSET_INFO:
				return assetInfo != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (vehicleId: ");
		result.append(vehicleId);
		result.append(", registrationNumber: ");
		result.append(registrationNumber);
		result.append(", type: ");
		result.append(type);
		result.append(", make: ");
		result.append(make);
		result.append(", model: ");
		result.append(model);
		result.append(", engineNumber: ");
		result.append(engineNumber);
		result.append(", chassisNumber: ");
		result.append(chassisNumber);
		result.append(", logBookNumber: ");
		result.append(logBookNumber);
		result.append(", insurancePolicyNumber: ");
		result.append(insurancePolicyNumber);
		result.append(", insuranceExpirationDate: ");
		result.append(insuranceExpirationDate);
		result.append(", dominantColour: ");
		result.append(dominantColour);
		result.append(", capacityInTonnes: ");
		result.append(capacityInTonnes);
		result.append(", year: ");
		result.append(year);
		result.append(')');
		return result.toString();
	}

} //VehicleImpl
