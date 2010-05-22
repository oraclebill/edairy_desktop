/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base.impl;

import com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Descriptive Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.DescriptiveLocationImpl#getDirections <em>Directions</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.base.impl.DescriptiveLocationImpl#getLandmarks <em>Landmarks</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DescriptiveLocationImpl extends EObjectImpl implements DescriptiveLocation {
	/**
         * The default value of the '{@link #getDirections() <em>Directions</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getDirections()
         * @generated
         * @ordered
         */
	protected static final String DIRECTIONS_EDEFAULT = null;

	/**
         * The cached value of the '{@link #getDirections() <em>Directions</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getDirections()
         * @generated
         * @ordered
         */
	protected String directions = DIRECTIONS_EDEFAULT;

	/**
         * The default value of the '{@link #getLandmarks() <em>Landmarks</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getLandmarks()
         * @generated
         * @ordered
         */
	protected static final String LANDMARKS_EDEFAULT = null;

	/**
         * The cached value of the '{@link #getLandmarks() <em>Landmarks</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getLandmarks()
         * @generated
         * @ordered
         */
	protected String landmarks = LANDMARKS_EDEFAULT;

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	protected DescriptiveLocationImpl() {
                super();
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	protected EClass eStaticClass() {
                return ModelPackage.Literals.DESCRIPTIVE_LOCATION;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public String getDirections() {
                return directions;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setDirections(String newDirections) {
                String oldDirections = directions;
                directions = newDirections;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DESCRIPTIVE_LOCATION__DIRECTIONS, oldDirections, directions));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public String getLandmarks() {
                return landmarks;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setLandmarks(String newLandmarks) {
                String oldLandmarks = landmarks;
                landmarks = newLandmarks;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DESCRIPTIVE_LOCATION__LANDMARKS, oldLandmarks, landmarks));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case ModelPackage.DESCRIPTIVE_LOCATION__DIRECTIONS:
                                return getDirections();
                        case ModelPackage.DESCRIPTIVE_LOCATION__LANDMARKS:
                                return getLandmarks();
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
                        case ModelPackage.DESCRIPTIVE_LOCATION__DIRECTIONS:
                                setDirections((String)newValue);
                                return;
                        case ModelPackage.DESCRIPTIVE_LOCATION__LANDMARKS:
                                setLandmarks((String)newValue);
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
                        case ModelPackage.DESCRIPTIVE_LOCATION__DIRECTIONS:
                                setDirections(DIRECTIONS_EDEFAULT);
                                return;
                        case ModelPackage.DESCRIPTIVE_LOCATION__LANDMARKS:
                                setLandmarks(LANDMARKS_EDEFAULT);
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
                        case ModelPackage.DESCRIPTIVE_LOCATION__DIRECTIONS:
                                return DIRECTIONS_EDEFAULT == null ? directions != null : !DIRECTIONS_EDEFAULT.equals(directions);
                        case ModelPackage.DESCRIPTIVE_LOCATION__LANDMARKS:
                                return LANDMARKS_EDEFAULT == null ? landmarks != null : !LANDMARKS_EDEFAULT.equals(landmarks);
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
                result.append(" (directions: ");
                result.append(directions);
                result.append(", landmarks: ");
                result.append(landmarks);
                result.append(')');
                return result.toString();
        }

} //DescriptiveLocationImpl
