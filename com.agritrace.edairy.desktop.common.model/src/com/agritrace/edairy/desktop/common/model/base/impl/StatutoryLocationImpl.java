/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base.impl;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.StatutoryLocation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statutory Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.StatutoryLocationImpl#getLandReferenceNumber <em>Land Reference Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatutoryLocationImpl extends EObjectImpl implements StatutoryLocation {
        /**
         * The default value of the '{@link #getLandReferenceNumber() <em>Land Reference Number</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getLandReferenceNumber()
         * @generated
         * @ordered
         */
        protected static final String LAND_REFERENCE_NUMBER_EDEFAULT = null;

        /**
         * The cached value of the '{@link #getLandReferenceNumber() <em>Land Reference Number</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getLandReferenceNumber()
         * @generated
         * @ordered
         */
        protected String landReferenceNumber = LAND_REFERENCE_NUMBER_EDEFAULT;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected StatutoryLocationImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return ModelPackage.Literals.STATUTORY_LOCATION;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public String getLandReferenceNumber() {
                return landReferenceNumber;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setLandReferenceNumber(String newLandReferenceNumber) {
                String oldLandReferenceNumber = landReferenceNumber;
                landReferenceNumber = newLandReferenceNumber;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STATUTORY_LOCATION__LAND_REFERENCE_NUMBER, oldLandReferenceNumber, landReferenceNumber));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case ModelPackage.STATUTORY_LOCATION__LAND_REFERENCE_NUMBER:
                                return getLandReferenceNumber();
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
                        case ModelPackage.STATUTORY_LOCATION__LAND_REFERENCE_NUMBER:
                                setLandReferenceNumber((String)newValue);
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
                        case ModelPackage.STATUTORY_LOCATION__LAND_REFERENCE_NUMBER:
                                setLandReferenceNumber(LAND_REFERENCE_NUMBER_EDEFAULT);
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
                        case ModelPackage.STATUTORY_LOCATION__LAND_REFERENCE_NUMBER:
                                return LAND_REFERENCE_NUMBER_EDEFAULT == null ? landReferenceNumber != null : !LAND_REFERENCE_NUMBER_EDEFAULT.equals(landReferenceNumber);
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
                result.append(" (landReferenceNumber: ");
                result.append(landReferenceNumber);
                result.append(')');
                return result.toString();
        }

} //StatutoryLocationImpl
