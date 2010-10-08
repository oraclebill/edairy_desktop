/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.tracking.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Farm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.FarmImpl#getFarmId <em>Farm Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.FarmImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.FarmImpl#getAnimals <em>Animals</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.FarmImpl#getCans <em>Cans</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.FarmImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.FarmImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.FarmImpl#getProfilePhoto <em>Profile Photo</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FarmImpl extends EObjectImpl implements Farm {
	/**
	 * The default value of the '{@link #getFarmId() <em>Farm Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFarmId()
	 * @generated
	 * @ordered
	 */
	protected static final Long FARM_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFarmId() <em>Farm Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFarmId()
	 * @generated
	 * @ordered
	 */
	protected Long farmId = FARM_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnimals() <em>Animals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnimals()
	 * @generated
	 * @ordered
	 */
	protected EList<RegisteredAnimal> animals;

	/**
	 * The cached value of the '{@link #getCans() <em>Cans</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCans()
	 * @generated
	 * @ordered
	 */
	protected EList<Container> cans;

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
	protected FarmImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackingPackage.Literals.FARM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getFarmId() {
		return farmId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFarmId(Long newFarmId) {
		final Long oldFarmId = farmId;
		farmId = newFarmId;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.FARM__FARM_ID, oldFarmId, farmId));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		final String oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.FARM__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RegisteredAnimal> getAnimals() {
		if (animals == null) {
			animals = new EObjectContainmentEList<RegisteredAnimal>(RegisteredAnimal.class, this, TrackingPackage.FARM__ANIMALS);
		}
		return animals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Container> getCans() {
		if (cans == null) {
			cans = new EObjectContainmentEList<Container>(Container.class, this, TrackingPackage.FARM__CANS);
		}
		return cans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Location getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocation(Location newLocation, NotificationChain msgs) {
		final Location oldLocation = location;
		location = newLocation;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TrackingPackage.FARM__LOCATION, oldLocation, newLocation);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLocation(Location newLocation) {
		if (newLocation != location) {
			NotificationChain msgs = null;
			if (location != null) {
				msgs = ((InternalEObject)location).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TrackingPackage.FARM__LOCATION, null, msgs);
			}
			if (newLocation != null) {
				msgs = ((InternalEObject)newLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TrackingPackage.FARM__LOCATION, null, msgs);
			}
			msgs = basicSetLocation(newLocation, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		}
		else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.FARM__LOCATION, newLocation, newLocation));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Farmer getOwner() {
		if (eContainerFeatureID() != TrackingPackage.FARM__OWNER) {
			return null;
		}
		return (Farmer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Farmer newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, TrackingPackage.FARM__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwner(Farmer newOwner) {
		if (newOwner != eInternalContainer() || eContainerFeatureID() != TrackingPackage.FARM__OWNER && newOwner != null) {
			if (EcoreUtil.isAncestor(this, newOwner)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newOwner != null) {
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, TrackingPackage.FARMER__FARMS, Farmer.class, msgs);
			}
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		}
		else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.FARM__OWNER, newOwner, newOwner));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProfilePhoto() {
		return profilePhoto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProfilePhoto(String newProfilePhoto) {
		final String oldProfilePhoto = profilePhoto;
		profilePhoto = newProfilePhoto;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.FARM__PROFILE_PHOTO, oldProfilePhoto, profilePhoto));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNumberOfAnimals() {
		return getAnimals().size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNumberOfContainers() {
		return getCans().size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackingPackage.FARM__OWNER:
				if (eInternalContainer() != null) {
					msgs = eBasicRemoveFromContainer(msgs);
				}
				return basicSetOwner((Farmer)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackingPackage.FARM__ANIMALS:
				return ((InternalEList<?>)getAnimals()).basicRemove(otherEnd, msgs);
			case TrackingPackage.FARM__CANS:
				return ((InternalEList<?>)getCans()).basicRemove(otherEnd, msgs);
			case TrackingPackage.FARM__LOCATION:
				return basicSetLocation(null, msgs);
			case TrackingPackage.FARM__OWNER:
				return basicSetOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TrackingPackage.FARM__OWNER:
				return eInternalContainer().eInverseRemove(this, TrackingPackage.FARMER__FARMS, Farmer.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackingPackage.FARM__FARM_ID:
				return getFarmId();
			case TrackingPackage.FARM__NAME:
				return getName();
			case TrackingPackage.FARM__ANIMALS:
				return getAnimals();
			case TrackingPackage.FARM__CANS:
				return getCans();
			case TrackingPackage.FARM__LOCATION:
				return getLocation();
			case TrackingPackage.FARM__OWNER:
				return getOwner();
			case TrackingPackage.FARM__PROFILE_PHOTO:
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
		switch (featureID) {
			case TrackingPackage.FARM__FARM_ID:
				setFarmId((Long)newValue);
				return;
			case TrackingPackage.FARM__NAME:
				setName((String)newValue);
				return;
			case TrackingPackage.FARM__ANIMALS:
				getAnimals().clear();
				getAnimals().addAll((Collection<? extends RegisteredAnimal>)newValue);
				return;
			case TrackingPackage.FARM__CANS:
				getCans().clear();
				getCans().addAll((Collection<? extends Container>)newValue);
				return;
			case TrackingPackage.FARM__LOCATION:
				setLocation((Location)newValue);
				return;
			case TrackingPackage.FARM__OWNER:
				setOwner((Farmer)newValue);
				return;
			case TrackingPackage.FARM__PROFILE_PHOTO:
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
		switch (featureID) {
			case TrackingPackage.FARM__FARM_ID:
				setFarmId(FARM_ID_EDEFAULT);
				return;
			case TrackingPackage.FARM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TrackingPackage.FARM__ANIMALS:
				getAnimals().clear();
				return;
			case TrackingPackage.FARM__CANS:
				getCans().clear();
				return;
			case TrackingPackage.FARM__LOCATION:
				setLocation((Location)null);
				return;
			case TrackingPackage.FARM__OWNER:
				setOwner((Farmer)null);
				return;
			case TrackingPackage.FARM__PROFILE_PHOTO:
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
		switch (featureID) {
			case TrackingPackage.FARM__FARM_ID:
				return FARM_ID_EDEFAULT == null ? farmId != null : !FARM_ID_EDEFAULT.equals(farmId);
			case TrackingPackage.FARM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TrackingPackage.FARM__ANIMALS:
				return animals != null && !animals.isEmpty();
			case TrackingPackage.FARM__CANS:
				return cans != null && !cans.isEmpty();
			case TrackingPackage.FARM__LOCATION:
				return location != null;
			case TrackingPackage.FARM__OWNER:
				return getOwner() != null;
			case TrackingPackage.FARM__PROFILE_PHOTO:
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
		if (eIsProxy()) {
			return super.toString();
		}

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (farmId: ");
		result.append(farmId);
		result.append(", name: ");
		result.append(name);
		result.append(", profilePhoto: ");
		result.append(profilePhoto);
		result.append(')');
		return result.toString();
	}

} //FarmImpl
