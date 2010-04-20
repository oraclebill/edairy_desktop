/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model.dairy.impl;

import edairy.model.dairy.DairyPackage;
import edairy.model.dairy.ServiceRecord;
import edairy.model.dairy.Vehicle;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vehicle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edairy.model.dairy.impl.VehicleImpl#getServiceRecords <em>Service Records</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.VehicleImpl#getRegistrationNumber <em>Registration Number</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.VehicleImpl#getType <em>Type</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.VehicleImpl#getMake <em>Make</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.VehicleImpl#getModel <em>Model</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.VehicleImpl#getEngineNumber <em>Engine Number</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.VehicleImpl#getChassisNumber <em>Chassis Number</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.VehicleImpl#getLogBookNumber <em>Log Book Number</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.VehicleImpl#getInsurancePolicyNumber <em>Insurance Policy Number</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.VehicleImpl#getInsurancePurchaseDate <em>Insurance Purchase Date</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.VehicleImpl#getPurchaseDate <em>Purchase Date</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.VehicleImpl#getDisposalDate <em>Disposal Date</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.VehicleImpl#getDominantColour <em>Dominant Colour</em>}</li>
 *   <li>{@link edairy.model.dairy.impl.VehicleImpl#getCapacityInTonnes <em>Capacity In Tonnes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VehicleImpl extends EObjectImpl implements Vehicle {
	/**
	 * The cached value of the '{@link #getServiceRecords() <em>Service Records</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceRecords()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceRecord> serviceRecords;

	/**
	 * The default value of the '{@link #getRegistrationNumber() <em>Registration Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistrationNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String REGISTRATION_NUMBER_EDEFAULT = null;

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
	protected static final String TYPE_EDEFAULT = null;

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
	protected static final String MAKE_EDEFAULT = null;

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
	protected static final String MODEL_EDEFAULT = null;

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
	protected static final String ENGINE_NUMBER_EDEFAULT = null;

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
	protected static final String CHASSIS_NUMBER_EDEFAULT = null;

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
	protected static final String LOG_BOOK_NUMBER_EDEFAULT = null;

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
	protected static final String INSURANCE_POLICY_NUMBER_EDEFAULT = null;

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
	 * The default value of the '{@link #getInsurancePurchaseDate() <em>Insurance Purchase Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsurancePurchaseDate()
	 * @generated
	 * @ordered
	 */
	protected static final String INSURANCE_PURCHASE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInsurancePurchaseDate() <em>Insurance Purchase Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsurancePurchaseDate()
	 * @generated
	 * @ordered
	 */
	protected String insurancePurchaseDate = INSURANCE_PURCHASE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPurchaseDate() <em>Purchase Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPurchaseDate()
	 * @generated
	 * @ordered
	 */
	protected static final String PURCHASE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPurchaseDate() <em>Purchase Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPurchaseDate()
	 * @generated
	 * @ordered
	 */
	protected String purchaseDate = PURCHASE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDisposalDate() <em>Disposal Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisposalDate()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPOSAL_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisposalDate() <em>Disposal Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisposalDate()
	 * @generated
	 * @ordered
	 */
	protected String disposalDate = DISPOSAL_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDominantColour() <em>Dominant Colour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDominantColour()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMINANT_COLOUR_EDEFAULT = null;

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
	protected static final String CAPACITY_IN_TONNES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCapacityInTonnes() <em>Capacity In Tonnes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacityInTonnes()
	 * @generated
	 * @ordered
	 */
	protected String capacityInTonnes = CAPACITY_IN_TONNES_EDEFAULT;

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
	public EList<ServiceRecord> getServiceRecords() {
		if (serviceRecords == null) {
			serviceRecords = new EObjectContainmentEList<ServiceRecord>(ServiceRecord.class, this, DairyPackage.VEHICLE__SERVICE_RECORDS);
		}
		return serviceRecords;
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
	public String getInsurancePurchaseDate() {
		return insurancePurchaseDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInsurancePurchaseDate(String newInsurancePurchaseDate) {
		String oldInsurancePurchaseDate = insurancePurchaseDate;
		insurancePurchaseDate = newInsurancePurchaseDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__INSURANCE_PURCHASE_DATE, oldInsurancePurchaseDate, insurancePurchaseDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPurchaseDate(String newPurchaseDate) {
		String oldPurchaseDate = purchaseDate;
		purchaseDate = newPurchaseDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__PURCHASE_DATE, oldPurchaseDate, purchaseDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisposalDate() {
		return disposalDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisposalDate(String newDisposalDate) {
		String oldDisposalDate = disposalDate;
		disposalDate = newDisposalDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__DISPOSAL_DATE, oldDisposalDate, disposalDate));
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
	public String getCapacityInTonnes() {
		return capacityInTonnes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacityInTonnes(String newCapacityInTonnes) {
		String oldCapacityInTonnes = capacityInTonnes;
		capacityInTonnes = newCapacityInTonnes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.VEHICLE__CAPACITY_IN_TONNES, oldCapacityInTonnes, capacityInTonnes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DairyPackage.VEHICLE__SERVICE_RECORDS:
				return ((InternalEList<?>)getServiceRecords()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DairyPackage.VEHICLE__SERVICE_RECORDS:
				return getServiceRecords();
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
			case DairyPackage.VEHICLE__INSURANCE_PURCHASE_DATE:
				return getInsurancePurchaseDate();
			case DairyPackage.VEHICLE__PURCHASE_DATE:
				return getPurchaseDate();
			case DairyPackage.VEHICLE__DISPOSAL_DATE:
				return getDisposalDate();
			case DairyPackage.VEHICLE__DOMINANT_COLOUR:
				return getDominantColour();
			case DairyPackage.VEHICLE__CAPACITY_IN_TONNES:
				return getCapacityInTonnes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DairyPackage.VEHICLE__SERVICE_RECORDS:
				getServiceRecords().clear();
				getServiceRecords().addAll((Collection<? extends ServiceRecord>)newValue);
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
			case DairyPackage.VEHICLE__INSURANCE_PURCHASE_DATE:
				setInsurancePurchaseDate((String)newValue);
				return;
			case DairyPackage.VEHICLE__PURCHASE_DATE:
				setPurchaseDate((String)newValue);
				return;
			case DairyPackage.VEHICLE__DISPOSAL_DATE:
				setDisposalDate((String)newValue);
				return;
			case DairyPackage.VEHICLE__DOMINANT_COLOUR:
				setDominantColour((String)newValue);
				return;
			case DairyPackage.VEHICLE__CAPACITY_IN_TONNES:
				setCapacityInTonnes((String)newValue);
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
			case DairyPackage.VEHICLE__SERVICE_RECORDS:
				getServiceRecords().clear();
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
			case DairyPackage.VEHICLE__INSURANCE_PURCHASE_DATE:
				setInsurancePurchaseDate(INSURANCE_PURCHASE_DATE_EDEFAULT);
				return;
			case DairyPackage.VEHICLE__PURCHASE_DATE:
				setPurchaseDate(PURCHASE_DATE_EDEFAULT);
				return;
			case DairyPackage.VEHICLE__DISPOSAL_DATE:
				setDisposalDate(DISPOSAL_DATE_EDEFAULT);
				return;
			case DairyPackage.VEHICLE__DOMINANT_COLOUR:
				setDominantColour(DOMINANT_COLOUR_EDEFAULT);
				return;
			case DairyPackage.VEHICLE__CAPACITY_IN_TONNES:
				setCapacityInTonnes(CAPACITY_IN_TONNES_EDEFAULT);
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
			case DairyPackage.VEHICLE__SERVICE_RECORDS:
				return serviceRecords != null && !serviceRecords.isEmpty();
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
			case DairyPackage.VEHICLE__INSURANCE_PURCHASE_DATE:
				return INSURANCE_PURCHASE_DATE_EDEFAULT == null ? insurancePurchaseDate != null : !INSURANCE_PURCHASE_DATE_EDEFAULT.equals(insurancePurchaseDate);
			case DairyPackage.VEHICLE__PURCHASE_DATE:
				return PURCHASE_DATE_EDEFAULT == null ? purchaseDate != null : !PURCHASE_DATE_EDEFAULT.equals(purchaseDate);
			case DairyPackage.VEHICLE__DISPOSAL_DATE:
				return DISPOSAL_DATE_EDEFAULT == null ? disposalDate != null : !DISPOSAL_DATE_EDEFAULT.equals(disposalDate);
			case DairyPackage.VEHICLE__DOMINANT_COLOUR:
				return DOMINANT_COLOUR_EDEFAULT == null ? dominantColour != null : !DOMINANT_COLOUR_EDEFAULT.equals(dominantColour);
			case DairyPackage.VEHICLE__CAPACITY_IN_TONNES:
				return CAPACITY_IN_TONNES_EDEFAULT == null ? capacityInTonnes != null : !CAPACITY_IN_TONNES_EDEFAULT.equals(capacityInTonnes);
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
		result.append(" (registrationNumber: ");
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
		result.append(", insurancePurchaseDate: ");
		result.append(insurancePurchaseDate);
		result.append(", purchaseDate: ");
		result.append(purchaseDate);
		result.append(", disposalDate: ");
		result.append(disposalDate);
		result.append(", dominantColour: ");
		result.append(dominantColour);
		result.append(", capacityInTonnes: ");
		result.append(capacityInTonnes);
		result.append(')');
		return result.toString();
	}

} //VehicleImpl
