/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model.impl;

import edairy.model.Location;
import edairy.model.ModelPackage;
import edairy.model.PostalLocation;

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
 *   <li>{@link edairy.model.impl.LocationImpl#getPostalComponent <em>Postal Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LocationImpl extends EObjectImpl implements Location {
	/**
	 * The cached value of the '{@link #getPostalComponent() <em>Postal Component</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalComponent()
	 * @generated
	 * @ordered
	 */
	protected PostalLocation postalComponent;

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
	public PostalLocation getPostalComponent() {
		return postalComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostalComponent(PostalLocation newPostalComponent, NotificationChain msgs) {
		PostalLocation oldPostalComponent = postalComponent;
		postalComponent = newPostalComponent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.LOCATION__POSTAL_COMPONENT, oldPostalComponent, newPostalComponent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostalComponent(PostalLocation newPostalComponent) {
		if (newPostalComponent != postalComponent) {
			NotificationChain msgs = null;
			if (postalComponent != null)
				msgs = ((InternalEObject)postalComponent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.LOCATION__POSTAL_COMPONENT, null, msgs);
			if (newPostalComponent != null)
				msgs = ((InternalEObject)newPostalComponent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.LOCATION__POSTAL_COMPONENT, null, msgs);
			msgs = basicSetPostalComponent(newPostalComponent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LOCATION__POSTAL_COMPONENT, newPostalComponent, newPostalComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.LOCATION__POSTAL_COMPONENT:
				return basicSetPostalComponent(null, msgs);
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
			case ModelPackage.LOCATION__POSTAL_COMPONENT:
				return getPostalComponent();
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
			case ModelPackage.LOCATION__POSTAL_COMPONENT:
				setPostalComponent((PostalLocation)newValue);
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
			case ModelPackage.LOCATION__POSTAL_COMPONENT:
				setPostalComponent((PostalLocation)null);
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
			case ModelPackage.LOCATION__POSTAL_COMPONENT:
				return postalComponent != null;
		}
		return super.eIsSet(featureID);
	}

} //LocationImpl
