/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.tracking.impl;

import com.agritrace.edairy.model.ContainerType;
import com.agritrace.edairy.model.UnitOfMeasure;

import com.agritrace.edairy.model.tracking.Container;
import com.agritrace.edairy.model.tracking.Farm;
import com.agritrace.edairy.model.tracking.TrackingPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.tracking.impl.ContainerImpl#getContainerId <em>Container Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.tracking.impl.ContainerImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.tracking.impl.ContainerImpl#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.tracking.impl.ContainerImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.tracking.impl.ContainerImpl#getMeasureType <em>Measure Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContainerImpl extends EObjectImpl implements Container {
	/**
         * The default value of the '{@link #getContainerId() <em>Container Id</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getContainerId()
         * @generated
         * @ordered
         */
	protected static final String CONTAINER_ID_EDEFAULT = null;

	/**
         * The cached value of the '{@link #getContainerId() <em>Container Id</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getContainerId()
         * @generated
         * @ordered
         */
	protected String containerId = CONTAINER_ID_EDEFAULT;

	/**
         * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getOwner()
         * @generated
         * @ordered
         */
	protected Farm owner;

	/**
         * The default value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getCapacity()
         * @generated
         * @ordered
         */
	protected static final double CAPACITY_EDEFAULT = 0.0;

	/**
         * The cached value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getCapacity()
         * @generated
         * @ordered
         */
	protected double capacity = CAPACITY_EDEFAULT;

	/**
         * The default value of the '{@link #getType() <em>Type</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getType()
         * @generated
         * @ordered
         */
	protected static final ContainerType TYPE_EDEFAULT = ContainerType.BIN;

	/**
         * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getType()
         * @generated
         * @ordered
         */
	protected ContainerType type = TYPE_EDEFAULT;

	/**
         * The default value of the '{@link #getMeasureType() <em>Measure Type</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getMeasureType()
         * @generated
         * @ordered
         */
	protected static final UnitOfMeasure MEASURE_TYPE_EDEFAULT = UnitOfMeasure.LITRE;

	/**
         * The cached value of the '{@link #getMeasureType() <em>Measure Type</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getMeasureType()
         * @generated
         * @ordered
         */
	protected UnitOfMeasure measureType = MEASURE_TYPE_EDEFAULT;

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	protected ContainerImpl() {
                super();
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	protected EClass eStaticClass() {
                return TrackingPackage.Literals.CONTAINER;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public String getContainerId() {
                return containerId;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setContainerId(String newContainerId) {
                String oldContainerId = containerId;
                containerId = newContainerId;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.CONTAINER__CONTAINER_ID, oldContainerId, containerId));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public Farm getOwner() {
                if (owner != null && owner.eIsProxy()) {
                        InternalEObject oldOwner = (InternalEObject)owner;
                        owner = (Farm)eResolveProxy(oldOwner);
                        if (owner != oldOwner) {
                                if (eNotificationRequired())
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, TrackingPackage.CONTAINER__OWNER, oldOwner, owner));
                        }
                }
                return owner;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public Farm basicGetOwner() {
                return owner;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setOwner(Farm newOwner) {
                Farm oldOwner = owner;
                owner = newOwner;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.CONTAINER__OWNER, oldOwner, owner));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public double getCapacity() {
                return capacity;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setCapacity(double newCapacity) {
                double oldCapacity = capacity;
                capacity = newCapacity;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.CONTAINER__CAPACITY, oldCapacity, capacity));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public ContainerType getType() {
                return type;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setType(ContainerType newType) {
                ContainerType oldType = type;
                type = newType == null ? TYPE_EDEFAULT : newType;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.CONTAINER__TYPE, oldType, type));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public UnitOfMeasure getMeasureType() {
                return measureType;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setMeasureType(UnitOfMeasure newMeasureType) {
                UnitOfMeasure oldMeasureType = measureType;
                measureType = newMeasureType == null ? MEASURE_TYPE_EDEFAULT : newMeasureType;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.CONTAINER__MEASURE_TYPE, oldMeasureType, measureType));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case TrackingPackage.CONTAINER__CONTAINER_ID:
                                return getContainerId();
                        case TrackingPackage.CONTAINER__OWNER:
                                if (resolve) return getOwner();
                                return basicGetOwner();
                        case TrackingPackage.CONTAINER__CAPACITY:
                                return getCapacity();
                        case TrackingPackage.CONTAINER__TYPE:
                                return getType();
                        case TrackingPackage.CONTAINER__MEASURE_TYPE:
                                return getMeasureType();
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
                        case TrackingPackage.CONTAINER__CONTAINER_ID:
                                setContainerId((String)newValue);
                                return;
                        case TrackingPackage.CONTAINER__OWNER:
                                setOwner((Farm)newValue);
                                return;
                        case TrackingPackage.CONTAINER__CAPACITY:
                                setCapacity((Double)newValue);
                                return;
                        case TrackingPackage.CONTAINER__TYPE:
                                setType((ContainerType)newValue);
                                return;
                        case TrackingPackage.CONTAINER__MEASURE_TYPE:
                                setMeasureType((UnitOfMeasure)newValue);
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
                        case TrackingPackage.CONTAINER__CONTAINER_ID:
                                setContainerId(CONTAINER_ID_EDEFAULT);
                                return;
                        case TrackingPackage.CONTAINER__OWNER:
                                setOwner((Farm)null);
                                return;
                        case TrackingPackage.CONTAINER__CAPACITY:
                                setCapacity(CAPACITY_EDEFAULT);
                                return;
                        case TrackingPackage.CONTAINER__TYPE:
                                setType(TYPE_EDEFAULT);
                                return;
                        case TrackingPackage.CONTAINER__MEASURE_TYPE:
                                setMeasureType(MEASURE_TYPE_EDEFAULT);
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
                        case TrackingPackage.CONTAINER__CONTAINER_ID:
                                return CONTAINER_ID_EDEFAULT == null ? containerId != null : !CONTAINER_ID_EDEFAULT.equals(containerId);
                        case TrackingPackage.CONTAINER__OWNER:
                                return owner != null;
                        case TrackingPackage.CONTAINER__CAPACITY:
                                return capacity != CAPACITY_EDEFAULT;
                        case TrackingPackage.CONTAINER__TYPE:
                                return type != TYPE_EDEFAULT;
                        case TrackingPackage.CONTAINER__MEASURE_TYPE:
                                return measureType != MEASURE_TYPE_EDEFAULT;
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
                result.append(" (containerId: ");
                result.append(containerId);
                result.append(", capacity: ");
                result.append(capacity);
                result.append(", type: ");
                result.append(type);
                result.append(", measureType: ");
                result.append(measureType);
                result.append(')');
                return result.toString();
        }

} //ContainerImpl
