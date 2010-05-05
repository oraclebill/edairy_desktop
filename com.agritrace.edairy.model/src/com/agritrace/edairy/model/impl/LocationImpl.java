/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.impl;

import com.agritrace.edairy.model.DescriptiveLocation;
import com.agritrace.edairy.model.Location;
import com.agritrace.edairy.model.MapLocation;
import com.agritrace.edairy.model.ModelPackage;
import com.agritrace.edairy.model.PostalLocation;
import com.agritrace.edairy.model.StatutoryLocation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.impl.LocationImpl#getPostalLocation <em>Postal Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.impl.LocationImpl#getMapLocation <em>Map Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.impl.LocationImpl#getStatutoryLocation <em>Statutory Location</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.impl.LocationImpl#getDescriptiveLocation <em>Descriptive Location</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocationImpl extends EObjectImpl implements Location {
	/**
	 * The cached value of the '{@link #getPostalLocation() <em>Postal Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalLocation()
	 * @generated
	 * @ordered
	 */
	protected PostalLocation postalLocation;

	/**
	 * The cached value of the '{@link #getMapLocation() <em>Map Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapLocation()
	 * @generated
	 * @ordered
	 */
	protected MapLocation mapLocation;

	/**
	 * The cached value of the '{@link #getStatutoryLocation() <em>Statutory Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatutoryLocation()
	 * @generated
	 * @ordered
	 */
	protected StatutoryLocation statutoryLocation;

	/**
	 * The cached value of the '{@link #getDescriptiveLocation() <em>Descriptive Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptiveLocation()
	 * @generated
	 * @ordered
	 */
	protected DescriptiveLocation descriptiveLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.LOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostalLocation getPostalLocation() {
		return postalLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostalLocation(PostalLocation newPostalLocation, NotificationChain msgs) {
		PostalLocation oldPostalLocation = postalLocation;
		postalLocation = newPostalLocation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.LOCATION__POSTAL_LOCATION, oldPostalLocation, newPostalLocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostalLocation(PostalLocation newPostalLocation) {
		if (newPostalLocation != postalLocation) {
			NotificationChain msgs = null;
			if (postalLocation != null)
				msgs = ((InternalEObject)postalLocation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.LOCATION__POSTAL_LOCATION, null, msgs);
			if (newPostalLocation != null)
				msgs = ((InternalEObject)newPostalLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.LOCATION__POSTAL_LOCATION, null, msgs);
			msgs = basicSetPostalLocation(newPostalLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LOCATION__POSTAL_LOCATION, newPostalLocation, newPostalLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapLocation getMapLocation() {
		return mapLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMapLocation(MapLocation newMapLocation, NotificationChain msgs) {
		MapLocation oldMapLocation = mapLocation;
		mapLocation = newMapLocation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.LOCATION__MAP_LOCATION, oldMapLocation, newMapLocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapLocation(MapLocation newMapLocation) {
		if (newMapLocation != mapLocation) {
			NotificationChain msgs = null;
			if (mapLocation != null)
				msgs = ((InternalEObject)mapLocation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.LOCATION__MAP_LOCATION, null, msgs);
			if (newMapLocation != null)
				msgs = ((InternalEObject)newMapLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.LOCATION__MAP_LOCATION, null, msgs);
			msgs = basicSetMapLocation(newMapLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LOCATION__MAP_LOCATION, newMapLocation, newMapLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatutoryLocation getStatutoryLocation() {
		return statutoryLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStatutoryLocation(StatutoryLocation newStatutoryLocation, NotificationChain msgs) {
		StatutoryLocation oldStatutoryLocation = statutoryLocation;
		statutoryLocation = newStatutoryLocation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.LOCATION__STATUTORY_LOCATION, oldStatutoryLocation, newStatutoryLocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatutoryLocation(StatutoryLocation newStatutoryLocation) {
		if (newStatutoryLocation != statutoryLocation) {
			NotificationChain msgs = null;
			if (statutoryLocation != null)
				msgs = ((InternalEObject)statutoryLocation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.LOCATION__STATUTORY_LOCATION, null, msgs);
			if (newStatutoryLocation != null)
				msgs = ((InternalEObject)newStatutoryLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.LOCATION__STATUTORY_LOCATION, null, msgs);
			msgs = basicSetStatutoryLocation(newStatutoryLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LOCATION__STATUTORY_LOCATION, newStatutoryLocation, newStatutoryLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptiveLocation getDescriptiveLocation() {
		return descriptiveLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescriptiveLocation(DescriptiveLocation newDescriptiveLocation, NotificationChain msgs) {
		DescriptiveLocation oldDescriptiveLocation = descriptiveLocation;
		descriptiveLocation = newDescriptiveLocation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.LOCATION__DESCRIPTIVE_LOCATION, oldDescriptiveLocation, newDescriptiveLocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptiveLocation(DescriptiveLocation newDescriptiveLocation) {
		if (newDescriptiveLocation != descriptiveLocation) {
			NotificationChain msgs = null;
			if (descriptiveLocation != null)
				msgs = ((InternalEObject)descriptiveLocation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.LOCATION__DESCRIPTIVE_LOCATION, null, msgs);
			if (newDescriptiveLocation != null)
				msgs = ((InternalEObject)newDescriptiveLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.LOCATION__DESCRIPTIVE_LOCATION, null, msgs);
			msgs = basicSetDescriptiveLocation(newDescriptiveLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LOCATION__DESCRIPTIVE_LOCATION, newDescriptiveLocation, newDescriptiveLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.LOCATION__POSTAL_LOCATION:
				return basicSetPostalLocation(null, msgs);
			case ModelPackage.LOCATION__MAP_LOCATION:
				return basicSetMapLocation(null, msgs);
			case ModelPackage.LOCATION__STATUTORY_LOCATION:
				return basicSetStatutoryLocation(null, msgs);
			case ModelPackage.LOCATION__DESCRIPTIVE_LOCATION:
				return basicSetDescriptiveLocation(null, msgs);
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
			case ModelPackage.LOCATION__POSTAL_LOCATION:
				return getPostalLocation();
			case ModelPackage.LOCATION__MAP_LOCATION:
				return getMapLocation();
			case ModelPackage.LOCATION__STATUTORY_LOCATION:
				return getStatutoryLocation();
			case ModelPackage.LOCATION__DESCRIPTIVE_LOCATION:
				return getDescriptiveLocation();
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
			case ModelPackage.LOCATION__POSTAL_LOCATION:
				setPostalLocation((PostalLocation)newValue);
				return;
			case ModelPackage.LOCATION__MAP_LOCATION:
				setMapLocation((MapLocation)newValue);
				return;
			case ModelPackage.LOCATION__STATUTORY_LOCATION:
				setStatutoryLocation((StatutoryLocation)newValue);
				return;
			case ModelPackage.LOCATION__DESCRIPTIVE_LOCATION:
				setDescriptiveLocation((DescriptiveLocation)newValue);
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
			case ModelPackage.LOCATION__POSTAL_LOCATION:
				setPostalLocation((PostalLocation)null);
				return;
			case ModelPackage.LOCATION__MAP_LOCATION:
				setMapLocation((MapLocation)null);
				return;
			case ModelPackage.LOCATION__STATUTORY_LOCATION:
				setStatutoryLocation((StatutoryLocation)null);
				return;
			case ModelPackage.LOCATION__DESCRIPTIVE_LOCATION:
				setDescriptiveLocation((DescriptiveLocation)null);
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
			case ModelPackage.LOCATION__POSTAL_LOCATION:
				return postalLocation != null;
			case ModelPackage.LOCATION__MAP_LOCATION:
				return mapLocation != null;
			case ModelPackage.LOCATION__STATUTORY_LOCATION:
				return statutoryLocation != null;
			case ModelPackage.LOCATION__DESCRIPTIVE_LOCATION:
				return descriptiveLocation != null;
		}
		return super.eIsSet(featureID);
	}

} //LocationImpl
