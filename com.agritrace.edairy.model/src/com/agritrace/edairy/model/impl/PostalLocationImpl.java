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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.agritrace.edairy.model.ModelPackage;
import com.agritrace.edairy.model.PostalLocation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Postal Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.impl.PostalLocationImpl#getAddress <em>Address</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.impl.PostalLocationImpl#getSection <em>Section</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.impl.PostalLocationImpl#getEstate <em>Estate</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.impl.PostalLocationImpl#getVillage <em>Village</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.impl.PostalLocationImpl#getSubLocation <em>Sub Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.impl.PostalLocationImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.impl.PostalLocationImpl#getDistrict <em>District</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.impl.PostalLocationImpl#getDivision <em>Division</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.impl.PostalLocationImpl#getProvince <em>Province</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.impl.PostalLocationImpl#getPostalCode <em>Postal Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PostalLocationImpl extends EObjectImpl implements PostalLocation {
	/**
	 * The default value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected String address = ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSection() <em>Section</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSection()
	 * @generated
	 * @ordered
	 */
	protected static final String SECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSection() <em>Section</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSection()
	 * @generated
	 * @ordered
	 */
	protected String section = SECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getEstate() <em>Estate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEstate()
	 * @generated
	 * @ordered
	 */
	protected static final String ESTATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEstate() <em>Estate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEstate()
	 * @generated
	 * @ordered
	 */
	protected String estate = ESTATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVillage() <em>Village</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVillage()
	 * @generated
	 * @ordered
	 */
	protected static final String VILLAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVillage() <em>Village</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVillage()
	 * @generated
	 * @ordered
	 */
	protected String village = VILLAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubLocation() <em>Sub Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String SUB_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubLocation() <em>Sub Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubLocation()
	 * @generated
	 * @ordered
	 */
	protected String subLocation = SUB_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDistrict() <em>District</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistrict()
	 * @generated
	 * @ordered
	 */
	protected static final String DISTRICT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDistrict() <em>District</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistrict()
	 * @generated
	 * @ordered
	 */
	protected String district = DISTRICT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDivision() <em>Division</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDivision()
	 * @generated
	 * @ordered
	 */
	protected static final String DIVISION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDivision() <em>Division</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDivision()
	 * @generated
	 * @ordered
	 */
	protected String division = DIVISION_EDEFAULT;

	/**
	 * The default value of the '{@link #getProvince() <em>Province</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvince()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVINCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProvince() <em>Province</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvince()
	 * @generated
	 * @ordered
	 */
	protected String province = PROVINCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPostalCode() <em>Postal Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalCode()
	 * @generated
	 * @ordered
	 */
	protected static final String POSTAL_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPostalCode() <em>Postal Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalCode()
	 * @generated
	 * @ordered
	 */
	protected String postalCode = POSTAL_CODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PostalLocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.POSTAL_LOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddress(String newAddress) {
		String oldAddress = address;
		address = newAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.POSTAL_LOCATION__ADDRESS, oldAddress, address));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSection() {
		return section;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSection(String newSection) {
		String oldSection = section;
		section = newSection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.POSTAL_LOCATION__SECTION, oldSection, section));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEstate() {
		return estate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEstate(String newEstate) {
		String oldEstate = estate;
		estate = newEstate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.POSTAL_LOCATION__ESTATE, oldEstate, estate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVillage() {
		return village;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVillage(String newVillage) {
		String oldVillage = village;
		village = newVillage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.POSTAL_LOCATION__VILLAGE, oldVillage, village));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubLocation() {
		return subLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubLocation(String newSubLocation) {
		String oldSubLocation = subLocation;
		subLocation = newSubLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.POSTAL_LOCATION__SUB_LOCATION, oldSubLocation, subLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.POSTAL_LOCATION__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistrict(String newDistrict) {
		String oldDistrict = district;
		district = newDistrict;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.POSTAL_LOCATION__DISTRICT, oldDistrict, district));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDivision() {
		return division;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDivision(String newDivision) {
		String oldDivision = division;
		division = newDivision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.POSTAL_LOCATION__DIVISION, oldDivision, division));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvince(String newProvince) {
		String oldProvince = province;
		province = newProvince;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.POSTAL_LOCATION__PROVINCE, oldProvince, province));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostalCode(String newPostalCode) {
		String oldPostalCode = postalCode;
		postalCode = newPostalCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.POSTAL_LOCATION__POSTAL_CODE, oldPostalCode, postalCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.POSTAL_LOCATION__ADDRESS:
				return getAddress();
			case ModelPackage.POSTAL_LOCATION__SECTION:
				return getSection();
			case ModelPackage.POSTAL_LOCATION__ESTATE:
				return getEstate();
			case ModelPackage.POSTAL_LOCATION__VILLAGE:
				return getVillage();
			case ModelPackage.POSTAL_LOCATION__SUB_LOCATION:
				return getSubLocation();
			case ModelPackage.POSTAL_LOCATION__LOCATION:
				return getLocation();
			case ModelPackage.POSTAL_LOCATION__DISTRICT:
				return getDistrict();
			case ModelPackage.POSTAL_LOCATION__DIVISION:
				return getDivision();
			case ModelPackage.POSTAL_LOCATION__PROVINCE:
				return getProvince();
			case ModelPackage.POSTAL_LOCATION__POSTAL_CODE:
				return getPostalCode();
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
			case ModelPackage.POSTAL_LOCATION__ADDRESS:
				setAddress((String)newValue);
				return;
			case ModelPackage.POSTAL_LOCATION__SECTION:
				setSection((String)newValue);
				return;
			case ModelPackage.POSTAL_LOCATION__ESTATE:
				setEstate((String)newValue);
				return;
			case ModelPackage.POSTAL_LOCATION__VILLAGE:
				setVillage((String)newValue);
				return;
			case ModelPackage.POSTAL_LOCATION__SUB_LOCATION:
				setSubLocation((String)newValue);
				return;
			case ModelPackage.POSTAL_LOCATION__LOCATION:
				setLocation((String)newValue);
				return;
			case ModelPackage.POSTAL_LOCATION__DISTRICT:
				setDistrict((String)newValue);
				return;
			case ModelPackage.POSTAL_LOCATION__DIVISION:
				setDivision((String)newValue);
				return;
			case ModelPackage.POSTAL_LOCATION__PROVINCE:
				setProvince((String)newValue);
				return;
			case ModelPackage.POSTAL_LOCATION__POSTAL_CODE:
				setPostalCode((String)newValue);
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
			case ModelPackage.POSTAL_LOCATION__ADDRESS:
				setAddress(ADDRESS_EDEFAULT);
				return;
			case ModelPackage.POSTAL_LOCATION__SECTION:
				setSection(SECTION_EDEFAULT);
				return;
			case ModelPackage.POSTAL_LOCATION__ESTATE:
				setEstate(ESTATE_EDEFAULT);
				return;
			case ModelPackage.POSTAL_LOCATION__VILLAGE:
				setVillage(VILLAGE_EDEFAULT);
				return;
			case ModelPackage.POSTAL_LOCATION__SUB_LOCATION:
				setSubLocation(SUB_LOCATION_EDEFAULT);
				return;
			case ModelPackage.POSTAL_LOCATION__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case ModelPackage.POSTAL_LOCATION__DISTRICT:
				setDistrict(DISTRICT_EDEFAULT);
				return;
			case ModelPackage.POSTAL_LOCATION__DIVISION:
				setDivision(DIVISION_EDEFAULT);
				return;
			case ModelPackage.POSTAL_LOCATION__PROVINCE:
				setProvince(PROVINCE_EDEFAULT);
				return;
			case ModelPackage.POSTAL_LOCATION__POSTAL_CODE:
				setPostalCode(POSTAL_CODE_EDEFAULT);
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
			case ModelPackage.POSTAL_LOCATION__ADDRESS:
				return ADDRESS_EDEFAULT == null ? address != null : !ADDRESS_EDEFAULT.equals(address);
			case ModelPackage.POSTAL_LOCATION__SECTION:
				return SECTION_EDEFAULT == null ? section != null : !SECTION_EDEFAULT.equals(section);
			case ModelPackage.POSTAL_LOCATION__ESTATE:
				return ESTATE_EDEFAULT == null ? estate != null : !ESTATE_EDEFAULT.equals(estate);
			case ModelPackage.POSTAL_LOCATION__VILLAGE:
				return VILLAGE_EDEFAULT == null ? village != null : !VILLAGE_EDEFAULT.equals(village);
			case ModelPackage.POSTAL_LOCATION__SUB_LOCATION:
				return SUB_LOCATION_EDEFAULT == null ? subLocation != null : !SUB_LOCATION_EDEFAULT.equals(subLocation);
			case ModelPackage.POSTAL_LOCATION__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case ModelPackage.POSTAL_LOCATION__DISTRICT:
				return DISTRICT_EDEFAULT == null ? district != null : !DISTRICT_EDEFAULT.equals(district);
			case ModelPackage.POSTAL_LOCATION__DIVISION:
				return DIVISION_EDEFAULT == null ? division != null : !DIVISION_EDEFAULT.equals(division);
			case ModelPackage.POSTAL_LOCATION__PROVINCE:
				return PROVINCE_EDEFAULT == null ? province != null : !PROVINCE_EDEFAULT.equals(province);
			case ModelPackage.POSTAL_LOCATION__POSTAL_CODE:
				return POSTAL_CODE_EDEFAULT == null ? postalCode != null : !POSTAL_CODE_EDEFAULT.equals(postalCode);
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
		result.append(" (address: ");
		result.append(address);
		result.append(", section: ");
		result.append(section);
		result.append(", estate: ");
		result.append(estate);
		result.append(", village: ");
		result.append(village);
		result.append(", subLocation: ");
		result.append(subLocation);
		result.append(", location: ");
		result.append(location);
		result.append(", district: ");
		result.append(district);
		result.append(", division: ");
		result.append(division);
		result.append(", province: ");
		result.append(province);
		result.append(", postalCode: ");
		result.append(postalCode);
		result.append(')');
		return result.toString();
	}

} //PostalLocationImpl
