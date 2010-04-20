/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edairy.model.tracking.impl;

import edairy.model.tracking.Animal;
import edairy.model.tracking.Container;
import edairy.model.tracking.Farm;
import edairy.model.tracking.TrackingPackage;

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
 * An implementation of the model object '<em><b>Farm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edairy.model.tracking.impl.FarmImpl#getName <em>Name</em>}</li>
 *   <li>{@link edairy.model.tracking.impl.FarmImpl#getAnimals <em>Animals</em>}</li>
 *   <li>{@link edairy.model.tracking.impl.FarmImpl#getCans <em>Cans</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FarmImpl extends EObjectImpl implements Farm {
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
	protected EList<Animal> animals;

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
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.FARM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Animal> getAnimals() {
		if (animals == null) {
			animals = new EObjectContainmentEList<Animal>(Animal.class, this, TrackingPackage.FARM__ANIMALS);
		}
		return animals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackingPackage.FARM__ANIMALS:
				return ((InternalEList<?>)getAnimals()).basicRemove(otherEnd, msgs);
			case TrackingPackage.FARM__CANS:
				return ((InternalEList<?>)getCans()).basicRemove(otherEnd, msgs);
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
			case TrackingPackage.FARM__NAME:
				return getName();
			case TrackingPackage.FARM__ANIMALS:
				return getAnimals();
			case TrackingPackage.FARM__CANS:
				return getCans();
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
			case TrackingPackage.FARM__NAME:
				setName((String)newValue);
				return;
			case TrackingPackage.FARM__ANIMALS:
				getAnimals().clear();
				getAnimals().addAll((Collection<? extends Animal>)newValue);
				return;
			case TrackingPackage.FARM__CANS:
				getCans().clear();
				getCans().addAll((Collection<? extends Container>)newValue);
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
			case TrackingPackage.FARM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TrackingPackage.FARM__ANIMALS:
				getAnimals().clear();
				return;
			case TrackingPackage.FARM__CANS:
				getCans().clear();
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
			case TrackingPackage.FARM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TrackingPackage.FARM__ANIMALS:
				return animals != null && !animals.isEmpty();
			case TrackingPackage.FARM__CANS:
				return cans != null && !cans.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //FarmImpl
