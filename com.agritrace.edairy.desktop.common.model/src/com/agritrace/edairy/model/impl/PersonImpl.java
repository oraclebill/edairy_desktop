/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.agritrace.edairy.model.ModelPackage;
import com.agritrace.edairy.model.Person;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Person</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.agritrace.edairy.model.impl.PersonImpl#getPhoto <em>Photo
 * </em>}</li>
 * <li>{@link com.agritrace.edairy.model.impl.PersonImpl#getHonorific <em>
 * Honorific</em>}</li>
 * <li>{@link com.agritrace.edairy.model.impl.PersonImpl#getFamilyName <em>
 * Family Name</em>}</li>
 * <li>{@link com.agritrace.edairy.model.impl.PersonImpl#getGivenName <em>Given
 * Name</em>}</li>
 * <li>{@link com.agritrace.edairy.model.impl.PersonImpl#getMiddleName <em>
 * Middle Name</em>}</li>
 * <li>{@link com.agritrace.edairy.model.impl.PersonImpl#getAdditionalNames <em>
 * Additional Names</em>}</li>
 * <li>{@link com.agritrace.edairy.model.impl.PersonImpl#getSuffix <em>Suffix
 * </em>}</li>
 * <li>{@link com.agritrace.edairy.model.impl.PersonImpl#getNickName <em>Nick
 * Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PersonImpl extends PartyImpl implements Person {
    /**
     * The default value of the '{@link #getPhoto() <em>Photo</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPhoto()
     * @generated
     * @ordered
     */
    protected static final String PHOTO_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPhoto() <em>Photo</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPhoto()
     * @generated
     * @ordered
     */
    protected String photo = PHOTO_EDEFAULT;

    /**
     * The default value of the '{@link #getHonorific() <em>Honorific</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getHonorific()
     * @generated
     * @ordered
     */
    protected static final String HONORIFIC_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHonorific() <em>Honorific</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getHonorific()
     * @generated
     * @ordered
     */
    protected String honorific = HONORIFIC_EDEFAULT;

    /**
     * The default value of the '{@link #getFamilyName() <em>Family Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getFamilyName()
     * @generated
     * @ordered
     */
    protected static final String FAMILY_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFamilyName() <em>Family Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getFamilyName()
     * @generated
     * @ordered
     */
    protected String familyName = FAMILY_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getGivenName() <em>Given Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getGivenName()
     * @generated
     * @ordered
     */
    protected static final String GIVEN_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getGivenName() <em>Given Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getGivenName()
     * @generated
     * @ordered
     */
    protected String givenName = GIVEN_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getMiddleName() <em>Middle Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMiddleName()
     * @generated
     * @ordered
     */
    protected static final String MIDDLE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMiddleName() <em>Middle Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMiddleName()
     * @generated
     * @ordered
     */
    protected String middleName = MIDDLE_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getAdditionalNames()
     * <em>Additional Names</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getAdditionalNames()
     * @generated
     * @ordered
     */
    protected static final String ADDITIONAL_NAMES_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAdditionalNames()
     * <em>Additional Names</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getAdditionalNames()
     * @generated
     * @ordered
     */
    protected String additionalNames = ADDITIONAL_NAMES_EDEFAULT;

    /**
     * The default value of the '{@link #getSuffix() <em>Suffix</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSuffix()
     * @generated
     * @ordered
     */
    protected static final String SUFFIX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSuffix() <em>Suffix</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSuffix()
     * @generated
     * @ordered
     */
    protected String suffix = SUFFIX_EDEFAULT;

    /**
     * The default value of the '{@link #getNickName() <em>Nick Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getNickName()
     * @generated
     * @ordered
     */
    protected static final String NICK_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getNickName() <em>Nick Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getNickName()
     * @generated
     * @ordered
     */
    protected String nickName = NICK_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PersonImpl() {
	super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
	return ModelPackage.Literals.PERSON;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getPhoto() {
	return photo;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPhoto(String newPhoto) {
	final String oldPhoto = photo;
	photo = newPhoto;
	if (eNotificationRequired()) {
	    eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__PHOTO, oldPhoto, photo));
	}
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getHonorific() {
	return honorific;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setHonorific(String newHonorific) {
	final String oldHonorific = honorific;
	honorific = newHonorific;
	if (eNotificationRequired()) {
	    eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__HONORIFIC, oldHonorific,
		    honorific));
	}
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getFamilyName() {
	return familyName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setFamilyName(String newFamilyName) {
	final String oldFamilyName = familyName;
	familyName = newFamilyName;
	if (eNotificationRequired()) {
	    eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__FAMILY_NAME, oldFamilyName,
		    familyName));
	}
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getGivenName() {
	return givenName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setGivenName(String newGivenName) {
	final String oldGivenName = givenName;
	givenName = newGivenName;
	if (eNotificationRequired()) {
	    eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__GIVEN_NAME, oldGivenName,
		    givenName));
	}
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getMiddleName() {
	return middleName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMiddleName(String newMiddleName) {
	final String oldMiddleName = middleName;
	middleName = newMiddleName;
	if (eNotificationRequired()) {
	    eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__MIDDLE_NAME, oldMiddleName,
		    middleName));
	}
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getAdditionalNames() {
	return additionalNames;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAdditionalNames(String newAdditionalNames) {
	final String oldAdditionalNames = additionalNames;
	additionalNames = newAdditionalNames;
	if (eNotificationRequired()) {
	    eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__ADDITIONAL_NAMES,
		    oldAdditionalNames, additionalNames));
	}
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getSuffix() {
	return suffix;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSuffix(String newSuffix) {
	final String oldSuffix = suffix;
	suffix = newSuffix;
	if (eNotificationRequired()) {
	    eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__SUFFIX, oldSuffix, suffix));
	}
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getNickName() {
	return nickName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setNickName(String newNickName) {
	final String oldNickName = nickName;
	nickName = newNickName;
	if (eNotificationRequired()) {
	    eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PERSON__NICK_NAME, oldNickName, nickName));
	}
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
	switch (featureID) {
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
	}
	return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
	switch (featureID) {
	case ModelPackage.PERSON__PHOTO:
	    setPhoto((String) newValue);
	    return;
	case ModelPackage.PERSON__HONORIFIC:
	    setHonorific((String) newValue);
	    return;
	case ModelPackage.PERSON__FAMILY_NAME:
	    setFamilyName((String) newValue);
	    return;
	case ModelPackage.PERSON__GIVEN_NAME:
	    setGivenName((String) newValue);
	    return;
	case ModelPackage.PERSON__MIDDLE_NAME:
	    setMiddleName((String) newValue);
	    return;
	case ModelPackage.PERSON__ADDITIONAL_NAMES:
	    setAdditionalNames((String) newValue);
	    return;
	case ModelPackage.PERSON__SUFFIX:
	    setSuffix((String) newValue);
	    return;
	case ModelPackage.PERSON__NICK_NAME:
	    setNickName((String) newValue);
	    return;
	}
	super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
	switch (featureID) {
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
	}
	super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
	switch (featureID) {
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
	    return ADDITIONAL_NAMES_EDEFAULT == null ? additionalNames != null : !ADDITIONAL_NAMES_EDEFAULT
		    .equals(additionalNames);
	case ModelPackage.PERSON__SUFFIX:
	    return SUFFIX_EDEFAULT == null ? suffix != null : !SUFFIX_EDEFAULT.equals(suffix);
	case ModelPackage.PERSON__NICK_NAME:
	    return NICK_NAME_EDEFAULT == null ? nickName != null : !NICK_NAME_EDEFAULT.equals(nickName);
	}
	return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
	if (eIsProxy()) {
	    return super.toString();
	}

	final StringBuffer result = new StringBuffer(super.toString());
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
	result.append(')');
	return result.toString();
    }

    @Override
    public String getName() {
	final StringBuffer result = new StringBuffer();
	result.append(getGivenName());
	result.append(" ");
	result.append(getMiddleName());
	result.append(" ");
	result.append(getFamilyName());
	result.append(" ");
	result.append(getAdditionalNames());
	return result.toString();
    }
} // PersonImpl
