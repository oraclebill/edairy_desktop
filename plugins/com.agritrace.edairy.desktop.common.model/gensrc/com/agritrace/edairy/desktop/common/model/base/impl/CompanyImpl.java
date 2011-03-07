/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base.impl;

import com.agritrace.edairy.desktop.common.model.base.Company;
import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.Person;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.CompanyImpl#getLegalName <em>Legal Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.CompanyImpl#getCompanyName <em>Company Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.CompanyImpl#getContacts <em>Contacts</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.CompanyImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.CompanyImpl#getPhoneNumber <em>Phone Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.CompanyImpl#getCompanyId <em>Company Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.CompanyImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.CompanyImpl#getProfilePhoto <em>Profile Photo</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompanyImpl extends ContactableImpl implements Company {
	/**
	 * The default value of the '{@link #getLegalName() <em>Legal Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLegalName()
	 * @generated
	 * @ordered
	 */
	protected static final String LEGAL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLegalName() <em>Legal Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLegalName()
	 * @generated
	 * @ordered
	 */
	protected String legalName = LEGAL_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompanyName() <em>Company Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompanyName()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPANY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCompanyName() <em>Company Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompanyName()
	 * @generated
	 * @ordered
	 */
	protected String companyName = COMPANY_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContacts() <em>Contacts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContacts()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> contacts;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected Location location;

	/**
	 * The default value of the '{@link #getPhoneNumber() <em>Phone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhoneNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String PHONE_NUMBER_EDEFAULT = "+254";

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
	 * The default value of the '{@link #getCompanyId() <em>Company Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompanyId()
	 * @generated
	 * @ordered
	 */
	protected static final Long COMPANY_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCompanyId() <em>Company Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompanyId()
	 * @generated
	 * @ordered
	 */
	protected Long companyId = COMPANY_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getProfilePhoto() <em>Profile Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfilePhoto()
	 * @generated
	 * @ordered
	 */
	protected static final String PROFILE_PHOTO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProfilePhoto() <em>Profile Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfilePhoto()
	 * @generated
	 * @ordered
	 */
	protected String profilePhoto = PROFILE_PHOTO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompanyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.COMPANY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLegalName() {
		return legalName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLegalName(String newLegalName) {
		String oldLegalName = legalName;
		legalName = newLegalName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.COMPANY__LEGAL_NAME, oldLegalName, legalName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompanyName(String newCompanyName) {
		String oldCompanyName = companyName;
		companyName = newCompanyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.COMPANY__COMPANY_NAME, oldCompanyName, companyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Person> getContacts() {
		if (contacts == null)
		{
			contacts = new EObjectContainmentEList<Person>(Person.class, this, ModelPackage.COMPANY__CONTACTS);
		}
		return contacts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocation(Location newLocation, NotificationChain msgs) {
		Location oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.COMPANY__LOCATION, oldLocation, newLocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(Location newLocation) {
		if (newLocation != location)
		{
			NotificationChain msgs = null;
			if (location != null)
				msgs = ((InternalEObject)location).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.COMPANY__LOCATION, null, msgs);
			if (newLocation != null)
				msgs = ((InternalEObject)newLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.COMPANY__LOCATION, null, msgs);
			msgs = basicSetLocation(newLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.COMPANY__LOCATION, newLocation, newLocation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.COMPANY__PHONE_NUMBER, oldPhoneNumber, phoneNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompanyId(Long newCompanyId) {
		Long oldCompanyId = companyId;
		companyId = newCompanyId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.COMPANY__COMPANY_ID, oldCompanyId, companyId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.COMPANY__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProfilePhoto() {
		return profilePhoto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfilePhoto(String newProfilePhoto) {
		String oldProfilePhoto = profilePhoto;
		profilePhoto = newProfilePhoto;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.COMPANY__PROFILE_PHOTO, oldProfilePhoto, profilePhoto));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case ModelPackage.COMPANY__CONTACTS:
				return ((InternalEList<?>)getContacts()).basicRemove(otherEnd, msgs);
			case ModelPackage.COMPANY__LOCATION:
				return basicSetLocation(null, msgs);
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
		switch (featureID)
		{
			case ModelPackage.COMPANY__LEGAL_NAME:
				return getLegalName();
			case ModelPackage.COMPANY__COMPANY_NAME:
				return getCompanyName();
			case ModelPackage.COMPANY__CONTACTS:
				return getContacts();
			case ModelPackage.COMPANY__LOCATION:
				return getLocation();
			case ModelPackage.COMPANY__PHONE_NUMBER:
				return getPhoneNumber();
			case ModelPackage.COMPANY__COMPANY_ID:
				return getCompanyId();
			case ModelPackage.COMPANY__DESCRIPTION:
				return getDescription();
			case ModelPackage.COMPANY__PROFILE_PHOTO:
				return getProfilePhoto();
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
		switch (featureID)
		{
			case ModelPackage.COMPANY__LEGAL_NAME:
				setLegalName((String)newValue);
				return;
			case ModelPackage.COMPANY__COMPANY_NAME:
				setCompanyName((String)newValue);
				return;
			case ModelPackage.COMPANY__CONTACTS:
				getContacts().clear();
				getContacts().addAll((Collection<? extends Person>)newValue);
				return;
			case ModelPackage.COMPANY__LOCATION:
				setLocation((Location)newValue);
				return;
			case ModelPackage.COMPANY__PHONE_NUMBER:
				setPhoneNumber((String)newValue);
				return;
			case ModelPackage.COMPANY__COMPANY_ID:
				setCompanyId((Long)newValue);
				return;
			case ModelPackage.COMPANY__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelPackage.COMPANY__PROFILE_PHOTO:
				setProfilePhoto((String)newValue);
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
			case ModelPackage.COMPANY__LEGAL_NAME:
				setLegalName(LEGAL_NAME_EDEFAULT);
				return;
			case ModelPackage.COMPANY__COMPANY_NAME:
				setCompanyName(COMPANY_NAME_EDEFAULT);
				return;
			case ModelPackage.COMPANY__CONTACTS:
				getContacts().clear();
				return;
			case ModelPackage.COMPANY__LOCATION:
				setLocation((Location)null);
				return;
			case ModelPackage.COMPANY__PHONE_NUMBER:
				setPhoneNumber(PHONE_NUMBER_EDEFAULT);
				return;
			case ModelPackage.COMPANY__COMPANY_ID:
				setCompanyId(COMPANY_ID_EDEFAULT);
				return;
			case ModelPackage.COMPANY__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.COMPANY__PROFILE_PHOTO:
				setProfilePhoto(PROFILE_PHOTO_EDEFAULT);
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
			case ModelPackage.COMPANY__LEGAL_NAME:
				return LEGAL_NAME_EDEFAULT == null ? legalName != null : !LEGAL_NAME_EDEFAULT.equals(legalName);
			case ModelPackage.COMPANY__COMPANY_NAME:
				return COMPANY_NAME_EDEFAULT == null ? companyName != null : !COMPANY_NAME_EDEFAULT.equals(companyName);
			case ModelPackage.COMPANY__CONTACTS:
				return contacts != null && !contacts.isEmpty();
			case ModelPackage.COMPANY__LOCATION:
				return location != null;
			case ModelPackage.COMPANY__PHONE_NUMBER:
				return PHONE_NUMBER_EDEFAULT == null ? phoneNumber != null : !PHONE_NUMBER_EDEFAULT.equals(phoneNumber);
			case ModelPackage.COMPANY__COMPANY_ID:
				return COMPANY_ID_EDEFAULT == null ? companyId != null : !COMPANY_ID_EDEFAULT.equals(companyId);
			case ModelPackage.COMPANY__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelPackage.COMPANY__PROFILE_PHOTO:
				return PROFILE_PHOTO_EDEFAULT == null ? profilePhoto != null : !PROFILE_PHOTO_EDEFAULT.equals(profilePhoto);
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
		result.append(" (legalName: ");
		result.append(legalName);
		result.append(", companyName: ");
		result.append(companyName);
		result.append(", phoneNumber: ");
		result.append(phoneNumber);
		result.append(", companyId: ");
		result.append(companyId);
		result.append(", description: ");
		result.append(description);
		result.append(", profilePhoto: ");
		result.append(profilePhoto);
		result.append(')');
		return result.toString();
	}

} //CompanyImpl
