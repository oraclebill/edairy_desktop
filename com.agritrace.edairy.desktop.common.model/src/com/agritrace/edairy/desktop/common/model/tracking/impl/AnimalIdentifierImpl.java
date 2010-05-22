/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.tracking.impl;

import com.agritrace.edairy.desktop.common.model.tracking.AnimalIdentifier;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Animal Identifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.AnimalIdentifierImpl#getIssuer <em>Issuer</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.impl.AnimalIdentifierImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnimalIdentifierImpl extends EObjectImpl implements AnimalIdentifier {
	/**
         * The default value of the '{@link #getIssuer() <em>Issuer</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getIssuer()
         * @generated
         * @ordered
         */
	protected static final String ISSUER_EDEFAULT = null;

	/**
         * The cached value of the '{@link #getIssuer() <em>Issuer</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getIssuer()
         * @generated
         * @ordered
         */
	protected String issuer = ISSUER_EDEFAULT;

	/**
         * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getValue()
         * @generated
         * @ordered
         */
	protected static final String VALUE_EDEFAULT = null;

	/**
         * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getValue()
         * @generated
         * @ordered
         */
	protected String value = VALUE_EDEFAULT;

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	protected AnimalIdentifierImpl() {
                super();
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	protected EClass eStaticClass() {
                return TrackingPackage.Literals.ANIMAL_IDENTIFIER;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public String getIssuer() {
                return issuer;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setIssuer(String newIssuer) {
                String oldIssuer = issuer;
                issuer = newIssuer;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.ANIMAL_IDENTIFIER__ISSUER, oldIssuer, issuer));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public String getValue() {
                return value;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setValue(String newValue) {
                String oldValue = value;
                value = newValue;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.ANIMAL_IDENTIFIER__VALUE, oldValue, value));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case TrackingPackage.ANIMAL_IDENTIFIER__ISSUER:
                                return getIssuer();
                        case TrackingPackage.ANIMAL_IDENTIFIER__VALUE:
                                return getValue();
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
                        case TrackingPackage.ANIMAL_IDENTIFIER__ISSUER:
                                setIssuer((String)newValue);
                                return;
                        case TrackingPackage.ANIMAL_IDENTIFIER__VALUE:
                                setValue((String)newValue);
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
                        case TrackingPackage.ANIMAL_IDENTIFIER__ISSUER:
                                setIssuer(ISSUER_EDEFAULT);
                                return;
                        case TrackingPackage.ANIMAL_IDENTIFIER__VALUE:
                                setValue(VALUE_EDEFAULT);
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
                        case TrackingPackage.ANIMAL_IDENTIFIER__ISSUER:
                                return ISSUER_EDEFAULT == null ? issuer != null : !ISSUER_EDEFAULT.equals(issuer);
                        case TrackingPackage.ANIMAL_IDENTIFIER__VALUE:
                                return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
                result.append(" (issuer: ");
                result.append(issuer);
                result.append(", value: ");
                result.append(value);
                result.append(')');
                return result.toString();
        }

} //AnimalIdentifierImpl
