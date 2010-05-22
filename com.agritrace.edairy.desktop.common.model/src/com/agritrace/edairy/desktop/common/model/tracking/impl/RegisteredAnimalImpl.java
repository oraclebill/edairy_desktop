/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.tracking.impl;

import com.agritrace.edairy.desktop.common.model.base.Gender;

import com.agritrace.edairy.desktop.common.model.tracking.AcquisitionType;
import com.agritrace.edairy.desktop.common.model.tracking.AnimalIdentifier;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Purpose;
import com.agritrace.edairy.desktop.common.model.tracking.RearingMode;
import com.agritrace.edairy.desktop.common.model.tracking.ReferenceAnimalType;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Registered Animal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getAnimnalRegistrationId <em>Animnal Registration Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getGivenName <em>Given Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getGender <em>Gender</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getAnimalType <em>Animal Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getSireType <em>Sire Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getDateOfAcquisition <em>Date Of Acquisition</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getAcquisitionType <em>Acquisition Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getIdentifiers <em>Identifiers</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getIdentifyingFeatures <em>Identifying Features</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getRearingMode <em>Rearing Mode</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getPastOwners <em>Past Owners</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getInsuranceNumber <em>Insurance Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getDateOfBirth <em>Date Of Birth</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegisteredAnimalImpl extends EObjectImpl implements RegisteredAnimal {
	/**
         * The default value of the '{@link #getAnimnalRegistrationId() <em>Animnal Registration Id</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getAnimnalRegistrationId()
         * @generated
         * @ordered
         */
	protected static final long ANIMNAL_REGISTRATION_ID_EDEFAULT = 0L;

	/**
         * The cached value of the '{@link #getAnimnalRegistrationId() <em>Animnal Registration Id</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getAnimnalRegistrationId()
         * @generated
         * @ordered
         */
	protected long animnalRegistrationId = ANIMNAL_REGISTRATION_ID_EDEFAULT;

	/**
         * The default value of the '{@link #getGivenName() <em>Given Name</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getGivenName()
         * @generated
         * @ordered
         */
	protected static final String GIVEN_NAME_EDEFAULT = "";

	/**
         * The cached value of the '{@link #getGivenName() <em>Given Name</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getGivenName()
         * @generated
         * @ordered
         */
	protected String givenName = GIVEN_NAME_EDEFAULT;

	/**
         * The cached value of the '{@link #getLocation() <em>Location</em>}' reference.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getLocation()
         * @generated
         * @ordered
         */
	protected Farm location;

	/**
         * The default value of the '{@link #getGender() <em>Gender</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getGender()
         * @generated
         * @ordered
         */
	protected static final Gender GENDER_EDEFAULT = Gender.MALE;

	/**
         * The cached value of the '{@link #getGender() <em>Gender</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getGender()
         * @generated
         * @ordered
         */
	protected Gender gender = GENDER_EDEFAULT;

	/**
         * The cached value of the '{@link #getAnimalType() <em>Animal Type</em>}' containment reference.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getAnimalType()
         * @generated
         * @ordered
         */
	protected ReferenceAnimalType animalType;

	/**
         * The cached value of the '{@link #getSireType() <em>Sire Type</em>}' containment reference.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getSireType()
         * @generated
         * @ordered
         */
	protected ReferenceAnimalType sireType;

	/**
         * The default value of the '{@link #getPurpose() <em>Purpose</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getPurpose()
         * @generated
         * @ordered
         */
	protected static final Purpose PURPOSE_EDEFAULT = Purpose.DAIRY;

	/**
         * The cached value of the '{@link #getPurpose() <em>Purpose</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getPurpose()
         * @generated
         * @ordered
         */
	protected Purpose purpose = PURPOSE_EDEFAULT;

	/**
         * The default value of the '{@link #getDateOfAcquisition() <em>Date Of Acquisition</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getDateOfAcquisition()
         * @generated
         * @ordered
         */
	protected static final Date DATE_OF_ACQUISITION_EDEFAULT = null;

	/**
         * The cached value of the '{@link #getDateOfAcquisition() <em>Date Of Acquisition</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getDateOfAcquisition()
         * @generated
         * @ordered
         */
	protected Date dateOfAcquisition = DATE_OF_ACQUISITION_EDEFAULT;

	/**
         * The default value of the '{@link #getAcquisitionType() <em>Acquisition Type</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getAcquisitionType()
         * @generated
         * @ordered
         */
	protected static final AcquisitionType ACQUISITION_TYPE_EDEFAULT = AcquisitionType.BIRTH;

	/**
         * The cached value of the '{@link #getAcquisitionType() <em>Acquisition Type</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getAcquisitionType()
         * @generated
         * @ordered
         */
	protected AcquisitionType acquisitionType = ACQUISITION_TYPE_EDEFAULT;

	/**
         * The cached value of the '{@link #getIdentifiers() <em>Identifiers</em>}' containment reference list.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getIdentifiers()
         * @generated
         * @ordered
         */
	protected EList<AnimalIdentifier> identifiers;

	/**
         * The default value of the '{@link #getIdentifyingFeatures() <em>Identifying Features</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getIdentifyingFeatures()
         * @generated
         * @ordered
         */
	protected static final String IDENTIFYING_FEATURES_EDEFAULT = null;

	/**
         * The cached value of the '{@link #getIdentifyingFeatures() <em>Identifying Features</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getIdentifyingFeatures()
         * @generated
         * @ordered
         */
	protected String identifyingFeatures = IDENTIFYING_FEATURES_EDEFAULT;

	/**
         * The default value of the '{@link #getRearingMode() <em>Rearing Mode</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getRearingMode()
         * @generated
         * @ordered
         */
	protected static final RearingMode REARING_MODE_EDEFAULT = RearingMode.GRAZE;

	/**
         * The cached value of the '{@link #getRearingMode() <em>Rearing Mode</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getRearingMode()
         * @generated
         * @ordered
         */
	protected RearingMode rearingMode = REARING_MODE_EDEFAULT;

	/**
         * The cached value of the '{@link #getPastOwners() <em>Past Owners</em>}' attribute list.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getPastOwners()
         * @generated
         * @ordered
         */
	protected EList<String> pastOwners;

	/**
         * The default value of the '{@link #getInsuranceNumber() <em>Insurance Number</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getInsuranceNumber()
         * @generated
         * @ordered
         */
	protected static final String INSURANCE_NUMBER_EDEFAULT = null;

	/**
         * The cached value of the '{@link #getInsuranceNumber() <em>Insurance Number</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getInsuranceNumber()
         * @generated
         * @ordered
         */
	protected String insuranceNumber = INSURANCE_NUMBER_EDEFAULT;

	/**
         * The default value of the '{@link #getDateOfBirth() <em>Date Of Birth</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getDateOfBirth()
         * @generated
         * @ordered
         */
	protected static final Date DATE_OF_BIRTH_EDEFAULT = null;

	/**
         * The cached value of the '{@link #getDateOfBirth() <em>Date Of Birth</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getDateOfBirth()
         * @generated
         * @ordered
         */
	protected Date dateOfBirth = DATE_OF_BIRTH_EDEFAULT;

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	protected RegisteredAnimalImpl() {
                super();
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	protected EClass eStaticClass() {
                return TrackingPackage.Literals.REGISTERED_ANIMAL;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public long getAnimnalRegistrationId() {
                return animnalRegistrationId;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setAnimnalRegistrationId(long newAnimnalRegistrationId) {
                long oldAnimnalRegistrationId = animnalRegistrationId;
                animnalRegistrationId = newAnimnalRegistrationId;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__ANIMNAL_REGISTRATION_ID, oldAnimnalRegistrationId, animnalRegistrationId));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public String getGivenName() {
                return givenName;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setGivenName(String newGivenName) {
                String oldGivenName = givenName;
                givenName = newGivenName;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__GIVEN_NAME, oldGivenName, givenName));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public Farm getLocation() {
                if (location != null && location.eIsProxy()) {
                        InternalEObject oldLocation = (InternalEObject)location;
                        location = (Farm)eResolveProxy(oldLocation);
                        if (location != oldLocation) {
                                if (eNotificationRequired())
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, TrackingPackage.REGISTERED_ANIMAL__LOCATION, oldLocation, location));
                        }
                }
                return location;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public Farm basicGetLocation() {
                return location;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setLocation(Farm newLocation) {
                Farm oldLocation = location;
                location = newLocation;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__LOCATION, oldLocation, location));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public Gender getGender() {
                return gender;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setGender(Gender newGender) {
                Gender oldGender = gender;
                gender = newGender == null ? GENDER_EDEFAULT : newGender;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__GENDER, oldGender, gender));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public ReferenceAnimalType getAnimalType() {
                return animalType;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public NotificationChain basicSetAnimalType(ReferenceAnimalType newAnimalType, NotificationChain msgs) {
                ReferenceAnimalType oldAnimalType = animalType;
                animalType = newAnimalType;
                if (eNotificationRequired()) {
                        ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__ANIMAL_TYPE, oldAnimalType, newAnimalType);
                        if (msgs == null) msgs = notification; else msgs.add(notification);
                }
                return msgs;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setAnimalType(ReferenceAnimalType newAnimalType) {
                if (newAnimalType != animalType) {
                        NotificationChain msgs = null;
                        if (animalType != null)
                                msgs = ((InternalEObject)animalType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TrackingPackage.REGISTERED_ANIMAL__ANIMAL_TYPE, null, msgs);
                        if (newAnimalType != null)
                                msgs = ((InternalEObject)newAnimalType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TrackingPackage.REGISTERED_ANIMAL__ANIMAL_TYPE, null, msgs);
                        msgs = basicSetAnimalType(newAnimalType, msgs);
                        if (msgs != null) msgs.dispatch();
                }
                else if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__ANIMAL_TYPE, newAnimalType, newAnimalType));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public ReferenceAnimalType getSireType() {
                return sireType;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public NotificationChain basicSetSireType(ReferenceAnimalType newSireType, NotificationChain msgs) {
                ReferenceAnimalType oldSireType = sireType;
                sireType = newSireType;
                if (eNotificationRequired()) {
                        ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__SIRE_TYPE, oldSireType, newSireType);
                        if (msgs == null) msgs = notification; else msgs.add(notification);
                }
                return msgs;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setSireType(ReferenceAnimalType newSireType) {
                if (newSireType != sireType) {
                        NotificationChain msgs = null;
                        if (sireType != null)
                                msgs = ((InternalEObject)sireType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TrackingPackage.REGISTERED_ANIMAL__SIRE_TYPE, null, msgs);
                        if (newSireType != null)
                                msgs = ((InternalEObject)newSireType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TrackingPackage.REGISTERED_ANIMAL__SIRE_TYPE, null, msgs);
                        msgs = basicSetSireType(newSireType, msgs);
                        if (msgs != null) msgs.dispatch();
                }
                else if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__SIRE_TYPE, newSireType, newSireType));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public Purpose getPurpose() {
                return purpose;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setPurpose(Purpose newPurpose) {
                Purpose oldPurpose = purpose;
                purpose = newPurpose == null ? PURPOSE_EDEFAULT : newPurpose;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__PURPOSE, oldPurpose, purpose));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public Date getDateOfAcquisition() {
                return dateOfAcquisition;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setDateOfAcquisition(Date newDateOfAcquisition) {
                Date oldDateOfAcquisition = dateOfAcquisition;
                dateOfAcquisition = newDateOfAcquisition;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__DATE_OF_ACQUISITION, oldDateOfAcquisition, dateOfAcquisition));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public AcquisitionType getAcquisitionType() {
                return acquisitionType;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setAcquisitionType(AcquisitionType newAcquisitionType) {
                AcquisitionType oldAcquisitionType = acquisitionType;
                acquisitionType = newAcquisitionType == null ? ACQUISITION_TYPE_EDEFAULT : newAcquisitionType;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__ACQUISITION_TYPE, oldAcquisitionType, acquisitionType));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EList<AnimalIdentifier> getIdentifiers() {
                if (identifiers == null) {
                        identifiers = new EObjectContainmentEList<AnimalIdentifier>(AnimalIdentifier.class, this, TrackingPackage.REGISTERED_ANIMAL__IDENTIFIERS);
                }
                return identifiers;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public String getIdentifyingFeatures() {
                return identifyingFeatures;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setIdentifyingFeatures(String newIdentifyingFeatures) {
                String oldIdentifyingFeatures = identifyingFeatures;
                identifyingFeatures = newIdentifyingFeatures;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__IDENTIFYING_FEATURES, oldIdentifyingFeatures, identifyingFeatures));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public RearingMode getRearingMode() {
                return rearingMode;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setRearingMode(RearingMode newRearingMode) {
                RearingMode oldRearingMode = rearingMode;
                rearingMode = newRearingMode == null ? REARING_MODE_EDEFAULT : newRearingMode;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__REARING_MODE, oldRearingMode, rearingMode));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EList<String> getPastOwners() {
                if (pastOwners == null) {
                        pastOwners = new EDataTypeUniqueEList<String>(String.class, this, TrackingPackage.REGISTERED_ANIMAL__PAST_OWNERS);
                }
                return pastOwners;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public String getInsuranceNumber() {
                return insuranceNumber;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setInsuranceNumber(String newInsuranceNumber) {
                String oldInsuranceNumber = insuranceNumber;
                insuranceNumber = newInsuranceNumber;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__INSURANCE_NUMBER, oldInsuranceNumber, insuranceNumber));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public Date getDateOfBirth() {
                return dateOfBirth;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setDateOfBirth(Date newDateOfBirth) {
                Date oldDateOfBirth = dateOfBirth;
                dateOfBirth = newDateOfBirth;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__DATE_OF_BIRTH, oldDateOfBirth, dateOfBirth));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
                switch (featureID) {
                        case TrackingPackage.REGISTERED_ANIMAL__ANIMAL_TYPE:
                                return basicSetAnimalType(null, msgs);
                        case TrackingPackage.REGISTERED_ANIMAL__SIRE_TYPE:
                                return basicSetSireType(null, msgs);
                        case TrackingPackage.REGISTERED_ANIMAL__IDENTIFIERS:
                                return ((InternalEList<?>)getIdentifiers()).basicRemove(otherEnd, msgs);
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
                        case TrackingPackage.REGISTERED_ANIMAL__ANIMNAL_REGISTRATION_ID:
                                return getAnimnalRegistrationId();
                        case TrackingPackage.REGISTERED_ANIMAL__GIVEN_NAME:
                                return getGivenName();
                        case TrackingPackage.REGISTERED_ANIMAL__LOCATION:
                                if (resolve) return getLocation();
                                return basicGetLocation();
                        case TrackingPackage.REGISTERED_ANIMAL__GENDER:
                                return getGender();
                        case TrackingPackage.REGISTERED_ANIMAL__ANIMAL_TYPE:
                                return getAnimalType();
                        case TrackingPackage.REGISTERED_ANIMAL__SIRE_TYPE:
                                return getSireType();
                        case TrackingPackage.REGISTERED_ANIMAL__PURPOSE:
                                return getPurpose();
                        case TrackingPackage.REGISTERED_ANIMAL__DATE_OF_ACQUISITION:
                                return getDateOfAcquisition();
                        case TrackingPackage.REGISTERED_ANIMAL__ACQUISITION_TYPE:
                                return getAcquisitionType();
                        case TrackingPackage.REGISTERED_ANIMAL__IDENTIFIERS:
                                return getIdentifiers();
                        case TrackingPackage.REGISTERED_ANIMAL__IDENTIFYING_FEATURES:
                                return getIdentifyingFeatures();
                        case TrackingPackage.REGISTERED_ANIMAL__REARING_MODE:
                                return getRearingMode();
                        case TrackingPackage.REGISTERED_ANIMAL__PAST_OWNERS:
                                return getPastOwners();
                        case TrackingPackage.REGISTERED_ANIMAL__INSURANCE_NUMBER:
                                return getInsuranceNumber();
                        case TrackingPackage.REGISTERED_ANIMAL__DATE_OF_BIRTH:
                                return getDateOfBirth();
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
                        case TrackingPackage.REGISTERED_ANIMAL__ANIMNAL_REGISTRATION_ID:
                                setAnimnalRegistrationId((Long)newValue);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__GIVEN_NAME:
                                setGivenName((String)newValue);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__LOCATION:
                                setLocation((Farm)newValue);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__GENDER:
                                setGender((Gender)newValue);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__ANIMAL_TYPE:
                                setAnimalType((ReferenceAnimalType)newValue);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__SIRE_TYPE:
                                setSireType((ReferenceAnimalType)newValue);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__PURPOSE:
                                setPurpose((Purpose)newValue);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__DATE_OF_ACQUISITION:
                                setDateOfAcquisition((Date)newValue);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__ACQUISITION_TYPE:
                                setAcquisitionType((AcquisitionType)newValue);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__IDENTIFIERS:
                                getIdentifiers().clear();
                                getIdentifiers().addAll((Collection<? extends AnimalIdentifier>)newValue);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__IDENTIFYING_FEATURES:
                                setIdentifyingFeatures((String)newValue);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__REARING_MODE:
                                setRearingMode((RearingMode)newValue);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__PAST_OWNERS:
                                getPastOwners().clear();
                                getPastOwners().addAll((Collection<? extends String>)newValue);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__INSURANCE_NUMBER:
                                setInsuranceNumber((String)newValue);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__DATE_OF_BIRTH:
                                setDateOfBirth((Date)newValue);
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
                        case TrackingPackage.REGISTERED_ANIMAL__ANIMNAL_REGISTRATION_ID:
                                setAnimnalRegistrationId(ANIMNAL_REGISTRATION_ID_EDEFAULT);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__GIVEN_NAME:
                                setGivenName(GIVEN_NAME_EDEFAULT);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__LOCATION:
                                setLocation((Farm)null);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__GENDER:
                                setGender(GENDER_EDEFAULT);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__ANIMAL_TYPE:
                                setAnimalType((ReferenceAnimalType)null);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__SIRE_TYPE:
                                setSireType((ReferenceAnimalType)null);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__PURPOSE:
                                setPurpose(PURPOSE_EDEFAULT);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__DATE_OF_ACQUISITION:
                                setDateOfAcquisition(DATE_OF_ACQUISITION_EDEFAULT);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__ACQUISITION_TYPE:
                                setAcquisitionType(ACQUISITION_TYPE_EDEFAULT);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__IDENTIFIERS:
                                getIdentifiers().clear();
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__IDENTIFYING_FEATURES:
                                setIdentifyingFeatures(IDENTIFYING_FEATURES_EDEFAULT);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__REARING_MODE:
                                setRearingMode(REARING_MODE_EDEFAULT);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__PAST_OWNERS:
                                getPastOwners().clear();
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__INSURANCE_NUMBER:
                                setInsuranceNumber(INSURANCE_NUMBER_EDEFAULT);
                                return;
                        case TrackingPackage.REGISTERED_ANIMAL__DATE_OF_BIRTH:
                                setDateOfBirth(DATE_OF_BIRTH_EDEFAULT);
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
                        case TrackingPackage.REGISTERED_ANIMAL__ANIMNAL_REGISTRATION_ID:
                                return animnalRegistrationId != ANIMNAL_REGISTRATION_ID_EDEFAULT;
                        case TrackingPackage.REGISTERED_ANIMAL__GIVEN_NAME:
                                return GIVEN_NAME_EDEFAULT == null ? givenName != null : !GIVEN_NAME_EDEFAULT.equals(givenName);
                        case TrackingPackage.REGISTERED_ANIMAL__LOCATION:
                                return location != null;
                        case TrackingPackage.REGISTERED_ANIMAL__GENDER:
                                return gender != GENDER_EDEFAULT;
                        case TrackingPackage.REGISTERED_ANIMAL__ANIMAL_TYPE:
                                return animalType != null;
                        case TrackingPackage.REGISTERED_ANIMAL__SIRE_TYPE:
                                return sireType != null;
                        case TrackingPackage.REGISTERED_ANIMAL__PURPOSE:
                                return purpose != PURPOSE_EDEFAULT;
                        case TrackingPackage.REGISTERED_ANIMAL__DATE_OF_ACQUISITION:
                                return DATE_OF_ACQUISITION_EDEFAULT == null ? dateOfAcquisition != null : !DATE_OF_ACQUISITION_EDEFAULT.equals(dateOfAcquisition);
                        case TrackingPackage.REGISTERED_ANIMAL__ACQUISITION_TYPE:
                                return acquisitionType != ACQUISITION_TYPE_EDEFAULT;
                        case TrackingPackage.REGISTERED_ANIMAL__IDENTIFIERS:
                                return identifiers != null && !identifiers.isEmpty();
                        case TrackingPackage.REGISTERED_ANIMAL__IDENTIFYING_FEATURES:
                                return IDENTIFYING_FEATURES_EDEFAULT == null ? identifyingFeatures != null : !IDENTIFYING_FEATURES_EDEFAULT.equals(identifyingFeatures);
                        case TrackingPackage.REGISTERED_ANIMAL__REARING_MODE:
                                return rearingMode != REARING_MODE_EDEFAULT;
                        case TrackingPackage.REGISTERED_ANIMAL__PAST_OWNERS:
                                return pastOwners != null && !pastOwners.isEmpty();
                        case TrackingPackage.REGISTERED_ANIMAL__INSURANCE_NUMBER:
                                return INSURANCE_NUMBER_EDEFAULT == null ? insuranceNumber != null : !INSURANCE_NUMBER_EDEFAULT.equals(insuranceNumber);
                        case TrackingPackage.REGISTERED_ANIMAL__DATE_OF_BIRTH:
                                return DATE_OF_BIRTH_EDEFAULT == null ? dateOfBirth != null : !DATE_OF_BIRTH_EDEFAULT.equals(dateOfBirth);
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
                result.append(" (animnalRegistrationId: ");
                result.append(animnalRegistrationId);
                result.append(", givenName: ");
                result.append(givenName);
                result.append(", gender: ");
                result.append(gender);
                result.append(", purpose: ");
                result.append(purpose);
                result.append(", dateOfAcquisition: ");
                result.append(dateOfAcquisition);
                result.append(", acquisitionType: ");
                result.append(acquisitionType);
                result.append(", identifyingFeatures: ");
                result.append(identifyingFeatures);
                result.append(", rearingMode: ");
                result.append(rearingMode);
                result.append(", pastOwners: ");
                result.append(pastOwners);
                result.append(", insuranceNumber: ");
                result.append(insuranceNumber);
                result.append(", dateOfBirth: ");
                result.append(dateOfBirth);
                result.append(')');
                return result.toString();
        }

} //RegisteredAnimalImpl
