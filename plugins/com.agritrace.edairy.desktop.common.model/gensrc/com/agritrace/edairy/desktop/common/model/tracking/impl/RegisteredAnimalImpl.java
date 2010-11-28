/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.tracking.impl;

import com.agritrace.edairy.desktop.common.model.base.Gender;
import com.agritrace.edairy.desktop.common.model.base.ImageEntry;

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
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getRegistrationId <em>Registration Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getGivenName <em>Given Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getPhoto <em>Photo</em>}</li>
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
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getBirthCertificateNumber <em>Birth Certificate Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getVeterinaryCertificateNumber <em>Veterinary Certificate Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getMinistryId <em>Ministry Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getInsuranceCompany <em>Insurance Company</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getFeedingHabit <em>Feeding Habit</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getFeedType <em>Feed Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getFeedBrand <em>Feed Brand</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getSupplements <em>Supplements</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getAntibiotics <em>Antibiotics</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getVeterinary <em>Veterinary</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getAwards <em>Awards</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.RegisteredAnimalImpl#getNotes <em>Notes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegisteredAnimalImpl extends EObjectImpl implements RegisteredAnimal {
	/**
	 * The default value of the '{@link #getRegistrationId() <em>Registration Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistrationId()
	 * @generated
	 * @ordered
	 */
	protected static final long REGISTRATION_ID_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getRegistrationId() <em>Registration Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistrationId()
	 * @generated
	 * @ordered
	 */
	protected long registrationId = REGISTRATION_ID_EDEFAULT;

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
	 * The default value of the '{@link #getPhoto() <em>Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhoto()
	 * @generated
	 * @ordered
	 */
	protected static final String PHOTO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPhoto() <em>Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhoto()
	 * @generated
	 * @ordered
	 */
	protected String photo = PHOTO_EDEFAULT;

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
	 * The cached value of the '{@link #getAnimalType() <em>Animal Type</em>}' reference.
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
	 * The default value of the '{@link #getBirthCertificateNumber() <em>Birth Certificate Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirthCertificateNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String BIRTH_CERTIFICATE_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBirthCertificateNumber() <em>Birth Certificate Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirthCertificateNumber()
	 * @generated
	 * @ordered
	 */
	protected String birthCertificateNumber = BIRTH_CERTIFICATE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getVeterinaryCertificateNumber() <em>Veterinary Certificate Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVeterinaryCertificateNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String VETERINARY_CERTIFICATE_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVeterinaryCertificateNumber() <em>Veterinary Certificate Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVeterinaryCertificateNumber()
	 * @generated
	 * @ordered
	 */
	protected String veterinaryCertificateNumber = VETERINARY_CERTIFICATE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinistryId() <em>Ministry Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinistryId()
	 * @generated
	 * @ordered
	 */
	protected static final String MINISTRY_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinistryId() <em>Ministry Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinistryId()
	 * @generated
	 * @ordered
	 */
	protected String ministryId = MINISTRY_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getInsuranceCompany() <em>Insurance Company</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsuranceCompany()
	 * @generated
	 * @ordered
	 */
	protected static final String INSURANCE_COMPANY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInsuranceCompany() <em>Insurance Company</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsuranceCompany()
	 * @generated
	 * @ordered
	 */
	protected String insuranceCompany = INSURANCE_COMPANY_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeedingHabit() <em>Feeding Habit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedingHabit()
	 * @generated
	 * @ordered
	 */
	protected static final String FEEDING_HABIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeedingHabit() <em>Feeding Habit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedingHabit()
	 * @generated
	 * @ordered
	 */
	protected String feedingHabit = FEEDING_HABIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeedType() <em>Feed Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedType()
	 * @generated
	 * @ordered
	 */
	protected static final String FEED_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeedType() <em>Feed Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedType()
	 * @generated
	 * @ordered
	 */
	protected String feedType = FEED_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeedBrand() <em>Feed Brand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedBrand()
	 * @generated
	 * @ordered
	 */
	protected static final String FEED_BRAND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeedBrand() <em>Feed Brand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedBrand()
	 * @generated
	 * @ordered
	 */
	protected String feedBrand = FEED_BRAND_EDEFAULT;

	/**
	 * The default value of the '{@link #getSupplements() <em>Supplements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupplements()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPPLEMENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSupplements() <em>Supplements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupplements()
	 * @generated
	 * @ordered
	 */
	protected String supplements = SUPPLEMENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getAntibiotics() <em>Antibiotics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAntibiotics()
	 * @generated
	 * @ordered
	 */
	protected static final String ANTIBIOTICS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAntibiotics() <em>Antibiotics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAntibiotics()
	 * @generated
	 * @ordered
	 */
	protected String antibiotics = ANTIBIOTICS_EDEFAULT;

	/**
	 * The default value of the '{@link #getVeterinary() <em>Veterinary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVeterinary()
	 * @generated
	 * @ordered
	 */
	protected static final String VETERINARY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVeterinary() <em>Veterinary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVeterinary()
	 * @generated
	 * @ordered
	 */
	protected String veterinary = VETERINARY_EDEFAULT;

	/**
	 * The default value of the '{@link #getAwards() <em>Awards</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAwards()
	 * @generated
	 * @ordered
	 */
	protected static final String AWARDS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAwards() <em>Awards</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAwards()
	 * @generated
	 * @ordered
	 */
	protected String awards = AWARDS_EDEFAULT;

	/**
	 * The default value of the '{@link #getNotes() <em>Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNotes() <em>Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected String notes = NOTES_EDEFAULT;

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
	public long getRegistrationId() {
		return registrationId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistrationId(long newRegistrationId) {
		long oldRegistrationId = registrationId;
		registrationId = newRegistrationId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__REGISTRATION_ID, oldRegistrationId, registrationId));
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
	public String getPhoto() {
		return photo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhoto(String newPhoto) {
		String oldPhoto = photo;
		photo = newPhoto;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__PHOTO, oldPhoto, photo));
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
		if (animalType != null && animalType.eIsProxy()) {
			InternalEObject oldAnimalType = (InternalEObject)animalType;
			animalType = (ReferenceAnimalType)eResolveProxy(oldAnimalType);
			if (animalType != oldAnimalType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TrackingPackage.REGISTERED_ANIMAL__ANIMAL_TYPE, oldAnimalType, animalType));
			}
		}
		return animalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceAnimalType basicGetAnimalType() {
		return animalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnimalType(ReferenceAnimalType newAnimalType) {
		ReferenceAnimalType oldAnimalType = animalType;
		animalType = newAnimalType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__ANIMAL_TYPE, oldAnimalType, animalType));
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
	public String getBirthCertificateNumber() {
		return birthCertificateNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBirthCertificateNumber(String newBirthCertificateNumber) {
		String oldBirthCertificateNumber = birthCertificateNumber;
		birthCertificateNumber = newBirthCertificateNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__BIRTH_CERTIFICATE_NUMBER, oldBirthCertificateNumber, birthCertificateNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVeterinaryCertificateNumber() {
		return veterinaryCertificateNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVeterinaryCertificateNumber(String newVeterinaryCertificateNumber) {
		String oldVeterinaryCertificateNumber = veterinaryCertificateNumber;
		veterinaryCertificateNumber = newVeterinaryCertificateNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__VETERINARY_CERTIFICATE_NUMBER, oldVeterinaryCertificateNumber, veterinaryCertificateNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinistryId() {
		return ministryId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinistryId(String newMinistryId) {
		String oldMinistryId = ministryId;
		ministryId = newMinistryId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__MINISTRY_ID, oldMinistryId, ministryId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInsuranceCompany(String newInsuranceCompany) {
		String oldInsuranceCompany = insuranceCompany;
		insuranceCompany = newInsuranceCompany;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__INSURANCE_COMPANY, oldInsuranceCompany, insuranceCompany));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeedingHabit() {
		return feedingHabit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeedingHabit(String newFeedingHabit) {
		String oldFeedingHabit = feedingHabit;
		feedingHabit = newFeedingHabit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__FEEDING_HABIT, oldFeedingHabit, feedingHabit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeedType() {
		return feedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeedType(String newFeedType) {
		String oldFeedType = feedType;
		feedType = newFeedType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__FEED_TYPE, oldFeedType, feedType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeedBrand() {
		return feedBrand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeedBrand(String newFeedBrand) {
		String oldFeedBrand = feedBrand;
		feedBrand = newFeedBrand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__FEED_BRAND, oldFeedBrand, feedBrand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSupplements() {
		return supplements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupplements(String newSupplements) {
		String oldSupplements = supplements;
		supplements = newSupplements;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__SUPPLEMENTS, oldSupplements, supplements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAntibiotics() {
		return antibiotics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAntibiotics(String newAntibiotics) {
		String oldAntibiotics = antibiotics;
		antibiotics = newAntibiotics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__ANTIBIOTICS, oldAntibiotics, antibiotics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVeterinary() {
		return veterinary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVeterinary(String newVeterinary) {
		String oldVeterinary = veterinary;
		veterinary = newVeterinary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__VETERINARY, oldVeterinary, veterinary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAwards() {
		return awards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAwards(String newAwards) {
		String oldAwards = awards;
		awards = newAwards;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__AWARDS, oldAwards, awards));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotes(String newNotes) {
		String oldNotes = notes;
		notes = newNotes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REGISTERED_ANIMAL__NOTES, oldNotes, notes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
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
			case TrackingPackage.REGISTERED_ANIMAL__REGISTRATION_ID:
				return getRegistrationId();
			case TrackingPackage.REGISTERED_ANIMAL__GIVEN_NAME:
				return getGivenName();
			case TrackingPackage.REGISTERED_ANIMAL__PHOTO:
				return getPhoto();
			case TrackingPackage.REGISTERED_ANIMAL__LOCATION:
				if (resolve) return getLocation();
				return basicGetLocation();
			case TrackingPackage.REGISTERED_ANIMAL__GENDER:
				return getGender();
			case TrackingPackage.REGISTERED_ANIMAL__ANIMAL_TYPE:
				if (resolve) return getAnimalType();
				return basicGetAnimalType();
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
			case TrackingPackage.REGISTERED_ANIMAL__BIRTH_CERTIFICATE_NUMBER:
				return getBirthCertificateNumber();
			case TrackingPackage.REGISTERED_ANIMAL__VETERINARY_CERTIFICATE_NUMBER:
				return getVeterinaryCertificateNumber();
			case TrackingPackage.REGISTERED_ANIMAL__MINISTRY_ID:
				return getMinistryId();
			case TrackingPackage.REGISTERED_ANIMAL__INSURANCE_COMPANY:
				return getInsuranceCompany();
			case TrackingPackage.REGISTERED_ANIMAL__FEEDING_HABIT:
				return getFeedingHabit();
			case TrackingPackage.REGISTERED_ANIMAL__FEED_TYPE:
				return getFeedType();
			case TrackingPackage.REGISTERED_ANIMAL__FEED_BRAND:
				return getFeedBrand();
			case TrackingPackage.REGISTERED_ANIMAL__SUPPLEMENTS:
				return getSupplements();
			case TrackingPackage.REGISTERED_ANIMAL__ANTIBIOTICS:
				return getAntibiotics();
			case TrackingPackage.REGISTERED_ANIMAL__VETERINARY:
				return getVeterinary();
			case TrackingPackage.REGISTERED_ANIMAL__AWARDS:
				return getAwards();
			case TrackingPackage.REGISTERED_ANIMAL__NOTES:
				return getNotes();
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
			case TrackingPackage.REGISTERED_ANIMAL__REGISTRATION_ID:
				setRegistrationId((Long)newValue);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__GIVEN_NAME:
				setGivenName((String)newValue);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__PHOTO:
				setPhoto((String)newValue);
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
			case TrackingPackage.REGISTERED_ANIMAL__BIRTH_CERTIFICATE_NUMBER:
				setBirthCertificateNumber((String)newValue);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__VETERINARY_CERTIFICATE_NUMBER:
				setVeterinaryCertificateNumber((String)newValue);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__MINISTRY_ID:
				setMinistryId((String)newValue);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__INSURANCE_COMPANY:
				setInsuranceCompany((String)newValue);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__FEEDING_HABIT:
				setFeedingHabit((String)newValue);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__FEED_TYPE:
				setFeedType((String)newValue);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__FEED_BRAND:
				setFeedBrand((String)newValue);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__SUPPLEMENTS:
				setSupplements((String)newValue);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__ANTIBIOTICS:
				setAntibiotics((String)newValue);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__VETERINARY:
				setVeterinary((String)newValue);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__AWARDS:
				setAwards((String)newValue);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__NOTES:
				setNotes((String)newValue);
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
			case TrackingPackage.REGISTERED_ANIMAL__REGISTRATION_ID:
				setRegistrationId(REGISTRATION_ID_EDEFAULT);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__GIVEN_NAME:
				setGivenName(GIVEN_NAME_EDEFAULT);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__PHOTO:
				setPhoto(PHOTO_EDEFAULT);
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
			case TrackingPackage.REGISTERED_ANIMAL__BIRTH_CERTIFICATE_NUMBER:
				setBirthCertificateNumber(BIRTH_CERTIFICATE_NUMBER_EDEFAULT);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__VETERINARY_CERTIFICATE_NUMBER:
				setVeterinaryCertificateNumber(VETERINARY_CERTIFICATE_NUMBER_EDEFAULT);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__MINISTRY_ID:
				setMinistryId(MINISTRY_ID_EDEFAULT);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__INSURANCE_COMPANY:
				setInsuranceCompany(INSURANCE_COMPANY_EDEFAULT);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__FEEDING_HABIT:
				setFeedingHabit(FEEDING_HABIT_EDEFAULT);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__FEED_TYPE:
				setFeedType(FEED_TYPE_EDEFAULT);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__FEED_BRAND:
				setFeedBrand(FEED_BRAND_EDEFAULT);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__SUPPLEMENTS:
				setSupplements(SUPPLEMENTS_EDEFAULT);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__ANTIBIOTICS:
				setAntibiotics(ANTIBIOTICS_EDEFAULT);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__VETERINARY:
				setVeterinary(VETERINARY_EDEFAULT);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__AWARDS:
				setAwards(AWARDS_EDEFAULT);
				return;
			case TrackingPackage.REGISTERED_ANIMAL__NOTES:
				setNotes(NOTES_EDEFAULT);
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
			case TrackingPackage.REGISTERED_ANIMAL__REGISTRATION_ID:
				return registrationId != REGISTRATION_ID_EDEFAULT;
			case TrackingPackage.REGISTERED_ANIMAL__GIVEN_NAME:
				return GIVEN_NAME_EDEFAULT == null ? givenName != null : !GIVEN_NAME_EDEFAULT.equals(givenName);
			case TrackingPackage.REGISTERED_ANIMAL__PHOTO:
				return PHOTO_EDEFAULT == null ? photo != null : !PHOTO_EDEFAULT.equals(photo);
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
			case TrackingPackage.REGISTERED_ANIMAL__BIRTH_CERTIFICATE_NUMBER:
				return BIRTH_CERTIFICATE_NUMBER_EDEFAULT == null ? birthCertificateNumber != null : !BIRTH_CERTIFICATE_NUMBER_EDEFAULT.equals(birthCertificateNumber);
			case TrackingPackage.REGISTERED_ANIMAL__VETERINARY_CERTIFICATE_NUMBER:
				return VETERINARY_CERTIFICATE_NUMBER_EDEFAULT == null ? veterinaryCertificateNumber != null : !VETERINARY_CERTIFICATE_NUMBER_EDEFAULT.equals(veterinaryCertificateNumber);
			case TrackingPackage.REGISTERED_ANIMAL__MINISTRY_ID:
				return MINISTRY_ID_EDEFAULT == null ? ministryId != null : !MINISTRY_ID_EDEFAULT.equals(ministryId);
			case TrackingPackage.REGISTERED_ANIMAL__INSURANCE_COMPANY:
				return INSURANCE_COMPANY_EDEFAULT == null ? insuranceCompany != null : !INSURANCE_COMPANY_EDEFAULT.equals(insuranceCompany);
			case TrackingPackage.REGISTERED_ANIMAL__FEEDING_HABIT:
				return FEEDING_HABIT_EDEFAULT == null ? feedingHabit != null : !FEEDING_HABIT_EDEFAULT.equals(feedingHabit);
			case TrackingPackage.REGISTERED_ANIMAL__FEED_TYPE:
				return FEED_TYPE_EDEFAULT == null ? feedType != null : !FEED_TYPE_EDEFAULT.equals(feedType);
			case TrackingPackage.REGISTERED_ANIMAL__FEED_BRAND:
				return FEED_BRAND_EDEFAULT == null ? feedBrand != null : !FEED_BRAND_EDEFAULT.equals(feedBrand);
			case TrackingPackage.REGISTERED_ANIMAL__SUPPLEMENTS:
				return SUPPLEMENTS_EDEFAULT == null ? supplements != null : !SUPPLEMENTS_EDEFAULT.equals(supplements);
			case TrackingPackage.REGISTERED_ANIMAL__ANTIBIOTICS:
				return ANTIBIOTICS_EDEFAULT == null ? antibiotics != null : !ANTIBIOTICS_EDEFAULT.equals(antibiotics);
			case TrackingPackage.REGISTERED_ANIMAL__VETERINARY:
				return VETERINARY_EDEFAULT == null ? veterinary != null : !VETERINARY_EDEFAULT.equals(veterinary);
			case TrackingPackage.REGISTERED_ANIMAL__AWARDS:
				return AWARDS_EDEFAULT == null ? awards != null : !AWARDS_EDEFAULT.equals(awards);
			case TrackingPackage.REGISTERED_ANIMAL__NOTES:
				return NOTES_EDEFAULT == null ? notes != null : !NOTES_EDEFAULT.equals(notes);
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
		result.append(" (registrationId: ");
		result.append(registrationId);
		result.append(", givenName: ");
		result.append(givenName);
		result.append(", photo: ");
		result.append(photo);
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
		result.append(", birthCertificateNumber: ");
		result.append(birthCertificateNumber);
		result.append(", veterinaryCertificateNumber: ");
		result.append(veterinaryCertificateNumber);
		result.append(", ministryId: ");
		result.append(ministryId);
		result.append(", insuranceCompany: ");
		result.append(insuranceCompany);
		result.append(", feedingHabit: ");
		result.append(feedingHabit);
		result.append(", feedType: ");
		result.append(feedType);
		result.append(", feedBrand: ");
		result.append(feedBrand);
		result.append(", supplements: ");
		result.append(supplements);
		result.append(", antibiotics: ");
		result.append(antibiotics);
		result.append(", veterinary: ");
		result.append(veterinary);
		result.append(", awards: ");
		result.append(awards);
		result.append(", notes: ");
		result.append(notes);
		result.append(')');
		return result.toString();
	}

} //RegisteredAnimalImpl
