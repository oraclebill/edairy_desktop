/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base.impl;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.Person;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl#getPhoto <em>Photo</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl#getHonorific <em>Honorific</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl#getFamilyName <em>Family Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl#getGivenName <em>Given Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl#getMiddleName <em>Middle Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl#getAdditionalNames <em>Additional Names</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl#getSuffix <em>Suffix</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl#getNickName <em>Nick Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl#getPhoneNumber <em>Phone Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl#getPersonId <em>Person Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl#getNssfNumber <em>Nssf Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl#getNhifNumber <em>Nhif Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.PersonImpl#getNationalId <em>National Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PersonImpl extends ContactableImpl implements Person {
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
	 * The default value of the '{@link #getHonorific() <em>Honorific</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHonorific()
	 * @generated
	 * @ordered
	 */
	protected static final String HONORIFIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHonorific() <em>Honorific</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHonorific()
	 * @generated
	 * @ordered
	 */
	protected String honorific = HONORIFIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getFamilyName() <em>Family Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFamilyName()
	 * @generated
	 * @ordered
	 */
	protected static final String FAMILY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFamilyName() <em>Family Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFamilyName()
	 * @generated
	 * @ordered
	 */
	protected String familyName = FAMILY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getGivenName() <em>Given Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGivenName()
	 * @generated
	 * @ordered
	 */
	protected static final String GIVEN_NAME_EDEFAULT = null;

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
	 * The default value of the '{@link #getMiddleName() <em>Middle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMiddleName()
	 * @generated
	 * @ordered
	 */
	protected static final String MIDDLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMiddleName() <em>Middle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMiddleName()
	 * @generated
	 * @ordered
	 */
	protected String middleName = MIDDLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdditionalNames() <em>Additional Names</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalNames()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDITIONAL_NAMES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdditionalNames() <em>Additional Names</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalNames()
	 * @generated
	 * @ordered
	 */
	protected String additionalNames = ADDITIONAL_NAMES_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuffix() <em>Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuffix()
	 * @generated
	 * @ordered
	 */
	protected static final String SUFFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuffix() <em>Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuffix()
	 * @generated
	 * @ordered
	 */
	protected String suffix = SUFFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getNickName() <em>Nick Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNickName()
	 * @generated
	 * @ordered
	 */
	protected static final String NICK_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNickName() <em>Nick Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNickName()
	 * @generated
	 * @ordered
	 */
	protected String nickName = NICK_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPhoneNumber() <em>Phone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhoneNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String PHONE_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPhoneNumber() <em>Phone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhoneNumber()
	 * @generated
	 * @ordered
	 */
	protected String phoneNumber = PHONE_NUMBER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected Location location;

	/**
	 * The default value of the '{@link #getPersonId() <em>Person Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersonId()
	 * @generated
	 * @ordered
	 */
	protected static final Long PERSON_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPersonId() <em>Person Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersonId()
	 * @generated
	 * @ordered
	 */
	protected Long personId = PERSON_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getNssfNumber() <em>Nssf Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNssfNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String NSSF_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNssfNumber() <em>Nssf Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNssfNumber()
	 * @generated
	 * @ordered
	 */
	protected String nssfNumber = NSSF_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getNhifNumber() <em>Nhif Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNhifNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String NHIF_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNhifNumber() <em>Nhif Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNhifNumber()
	 * @generated
	 * @ordered
	 */
	protected String nhifNumber = NHIF_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getNationalId() <em>National Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNationalId()
	 * @generated
	 * @ordered
	 */
	protected static final String NATIONAL_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNationalId() <em>National Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNationalId()
	 * @generated
	 * @ordered
	 */
	protected String nationalId = NATIONAL_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PERSON;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__PHOTO, oldPhoto, photo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHonorific() {
		return honorific;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHonorific(String newHonorific) {
		String oldHonorific = honorific;
		honorific = newHonorific;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__HONORIFIC, oldHonorific, honorific));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFamilyName(String newFamilyName) {
		String oldFamilyName = familyName;
		familyName = newFamilyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__FAMILY_NAME, oldFamilyName, familyName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__GIVEN_NAME, oldGivenName, givenName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMiddleName(String newMiddleName) {
		String oldMiddleName = middleName;
		middleName = newMiddleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__MIDDLE_NAME, oldMiddleName, middleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdditionalNames() {
		return additionalNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdditionalNames(String newAdditionalNames) {
		String oldAdditionalNames = additionalNames;
		additionalNames = newAdditionalNames;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__ADDITIONAL_NAMES, oldAdditionalNames, additionalNames));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuffix(String newSuffix) {
		String oldSuffix = suffix;
		suffix = newSuffix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__SUFFIX, oldSuffix, suffix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNickName(String newNickName) {
		String oldNickName = nickName;
		nickName = newNickName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__NICK_NAME, oldNickName, nickName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhoneNumber(String newPhoneNumber) {
		String oldPhoneNumber = phoneNumber;
		phoneNumber = newPhoneNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__PHONE_NUMBER, oldPhoneNumber, phoneNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location getLocation() {
		if (location != null && location.eIsProxy())
		{
			InternalEObject oldLocation = (InternalEObject)location;
			location = (Location)eResolveProxy(oldLocation);
			if (location != oldLocation)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PERSON__LOCATION, oldLocation, location));
			}
		}
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location basicGetLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(Location newLocation) {
		Location oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getPersonId() {
		return personId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersonId(Long newPersonId) {
		Long oldPersonId = personId;
		personId = newPersonId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__PERSON_ID, oldPersonId, personId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNssfNumber() {
		return nssfNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNssfNumber(String newNssfNumber) {
		String oldNssfNumber = nssfNumber;
		nssfNumber = newNssfNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__NSSF_NUMBER, oldNssfNumber, nssfNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNhifNumber() {
		return nhifNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNhifNumber(String newNhifNumber) {
		String oldNhifNumber = nhifNumber;
		nhifNumber = newNhifNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__NHIF_NUMBER, oldNhifNumber, nhifNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNationalId() {
		return nationalId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNationalId(String newNationalId) {
		String oldNationalId = nationalId;
		nationalId = newNationalId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__NATIONAL_ID, oldNationalId, nationalId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormattedName() {
		return com.agritrace.edairy.desktop.common.model.util.MemberUtil.formattedMemberName(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case ModelPackage.PERSON__PHOTO:
				return getPhoto();
			case ModelPackage.PERSON__HONORIFIC:
				return getHonorific();
			case ModelPackage.PERSON__FAMILY_NAME:
				return getFamilyName();
			case ModelPackage.PERSON__GIVEN_NAME:
				return getGivenName();
			case ModelPackage.PERSON__MIDDLE_NAME:
				return getMiddleName();
			case ModelPackage.PERSON__ADDITIONAL_NAMES:
				return getAdditionalNames();
			case ModelPackage.PERSON__SUFFIX:
				return getSuffix();
			case ModelPackage.PERSON__NICK_NAME:
				return getNickName();
			case ModelPackage.PERSON__PHONE_NUMBER:
				return getPhoneNumber();
			case ModelPackage.PERSON__LOCATION:
				if (resolve) return getLocation();
				return basicGetLocation();
			case ModelPackage.PERSON__PERSON_ID:
				return getPersonId();
			case ModelPackage.PERSON__NSSF_NUMBER:
				return getNssfNumber();
			case ModelPackage.PERSON__NHIF_NUMBER:
				return getNhifNumber();
			case ModelPackage.PERSON__NATIONAL_ID:
				return getNationalId();
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
		switch (featureID)
		{
			case ModelPackage.PERSON__PHOTO:
				setPhoto((String)newValue);
				return;
			case ModelPackage.PERSON__HONORIFIC:
				setHonorific((String)newValue);
				return;
			case ModelPackage.PERSON__FAMILY_NAME:
				setFamilyName((String)newValue);
				return;
			case ModelPackage.PERSON__GIVEN_NAME:
				setGivenName((String)newValue);
				return;
			case ModelPackage.PERSON__MIDDLE_NAME:
				setMiddleName((String)newValue);
				return;
			case ModelPackage.PERSON__ADDITIONAL_NAMES:
				setAdditionalNames((String)newValue);
				return;
			case ModelPackage.PERSON__SUFFIX:
				setSuffix((String)newValue);
				return;
			case ModelPackage.PERSON__NICK_NAME:
				setNickName((String)newValue);
				return;
			case ModelPackage.PERSON__PHONE_NUMBER:
				setPhoneNumber((String)newValue);
				return;
			case ModelPackage.PERSON__LOCATION:
				setLocation((Location)newValue);
				return;
			case ModelPackage.PERSON__PERSON_ID:
				setPersonId((Long)newValue);
				return;
			case ModelPackage.PERSON__NSSF_NUMBER:
				setNssfNumber((String)newValue);
				return;
			case ModelPackage.PERSON__NHIF_NUMBER:
				setNhifNumber((String)newValue);
				return;
			case ModelPackage.PERSON__NATIONAL_ID:
				setNationalId((String)newValue);
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
		switch (featureID)
		{
			case ModelPackage.PERSON__PHOTO:
				setPhoto(PHOTO_EDEFAULT);
				return;
			case ModelPackage.PERSON__HONORIFIC:
				setHonorific(HONORIFIC_EDEFAULT);
				return;
			case ModelPackage.PERSON__FAMILY_NAME:
				setFamilyName(FAMILY_NAME_EDEFAULT);
				return;
			case ModelPackage.PERSON__GIVEN_NAME:
				setGivenName(GIVEN_NAME_EDEFAULT);
				return;
			case ModelPackage.PERSON__MIDDLE_NAME:
				setMiddleName(MIDDLE_NAME_EDEFAULT);
				return;
			case ModelPackage.PERSON__ADDITIONAL_NAMES:
				setAdditionalNames(ADDITIONAL_NAMES_EDEFAULT);
				return;
			case ModelPackage.PERSON__SUFFIX:
				setSuffix(SUFFIX_EDEFAULT);
				return;
			case ModelPackage.PERSON__NICK_NAME:
				setNickName(NICK_NAME_EDEFAULT);
				return;
			case ModelPackage.PERSON__PHONE_NUMBER:
				setPhoneNumber(PHONE_NUMBER_EDEFAULT);
				return;
			case ModelPackage.PERSON__LOCATION:
				setLocation((Location)null);
				return;
			case ModelPackage.PERSON__PERSON_ID:
				setPersonId(PERSON_ID_EDEFAULT);
				return;
			case ModelPackage.PERSON__NSSF_NUMBER:
				setNssfNumber(NSSF_NUMBER_EDEFAULT);
				return;
			case ModelPackage.PERSON__NHIF_NUMBER:
				setNhifNumber(NHIF_NUMBER_EDEFAULT);
				return;
			case ModelPackage.PERSON__NATIONAL_ID:
				setNationalId(NATIONAL_ID_EDEFAULT);
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
		switch (featureID)
		{
			case ModelPackage.PERSON__PHOTO:
				return PHOTO_EDEFAULT == null ? photo != null : !PHOTO_EDEFAULT.equals(photo);
			case ModelPackage.PERSON__HONORIFIC:
				return HONORIFIC_EDEFAULT == null ? honorific != null : !HONORIFIC_EDEFAULT.equals(honorific);
			case ModelPackage.PERSON__FAMILY_NAME:
				return FAMILY_NAME_EDEFAULT == null ? familyName != null : !FAMILY_NAME_EDEFAULT.equals(familyName);
			case ModelPackage.PERSON__GIVEN_NAME:
				return GIVEN_NAME_EDEFAULT == null ? givenName != null : !GIVEN_NAME_EDEFAULT.equals(givenName);
			case ModelPackage.PERSON__MIDDLE_NAME:
				return MIDDLE_NAME_EDEFAULT == null ? middleName != null : !MIDDLE_NAME_EDEFAULT.equals(middleName);
			case ModelPackage.PERSON__ADDITIONAL_NAMES:
				return ADDITIONAL_NAMES_EDEFAULT == null ? additionalNames != null : !ADDITIONAL_NAMES_EDEFAULT.equals(additionalNames);
			case ModelPackage.PERSON__SUFFIX:
				return SUFFIX_EDEFAULT == null ? suffix != null : !SUFFIX_EDEFAULT.equals(suffix);
			case ModelPackage.PERSON__NICK_NAME:
				return NICK_NAME_EDEFAULT == null ? nickName != null : !NICK_NAME_EDEFAULT.equals(nickName);
			case ModelPackage.PERSON__PHONE_NUMBER:
				return PHONE_NUMBER_EDEFAULT == null ? phoneNumber != null : !PHONE_NUMBER_EDEFAULT.equals(phoneNumber);
			case ModelPackage.PERSON__LOCATION:
				return location != null;
			case ModelPackage.PERSON__PERSON_ID:
				return PERSON_ID_EDEFAULT == null ? personId != null : !PERSON_ID_EDEFAULT.equals(personId);
			case ModelPackage.PERSON__NSSF_NUMBER:
				return NSSF_NUMBER_EDEFAULT == null ? nssfNumber != null : !NSSF_NUMBER_EDEFAULT.equals(nssfNumber);
			case ModelPackage.PERSON__NHIF_NUMBER:
				return NHIF_NUMBER_EDEFAULT == null ? nhifNumber != null : !NHIF_NUMBER_EDEFAULT.equals(nhifNumber);
			case ModelPackage.PERSON__NATIONAL_ID:
				return NATIONAL_ID_EDEFAULT == null ? nationalId != null : !NATIONAL_ID_EDEFAULT.equals(nationalId);
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
		result.append(" (photo: ");
		result.append(photo);
		result.append(", honorific: ");
		result.append(honorific);
		result.append(", familyName: ");
		result.append(familyName);
		result.append(", givenName: ");
		result.append(givenName);
		result.append(", middleName: ");
		result.append(middleName);
		result.append(", additionalNames: ");
		result.append(additionalNames);
		result.append(", suffix: ");
		result.append(suffix);
		result.append(", nickName: ");
		result.append(nickName);
		result.append(", phoneNumber: ");
		result.append(phoneNumber);
		result.append(", personId: ");
		result.append(personId);
		result.append(", nssfNumber: ");
		result.append(nssfNumber);
		result.append(", nhifNumber: ");
		result.append(nhifNumber);
		result.append(", nationalId: ");
		result.append(nationalId);
		result.append(')');
		return result.toString();
	}

} //PersonImpl
