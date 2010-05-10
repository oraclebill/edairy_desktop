/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.tracking.impl;

import com.agritrace.edairy.model.tracking.ReferenceAnimalType;
import com.agritrace.edairy.model.tracking.TrackingPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Animal Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.model.tracking.impl.ReferenceAnimalTypeImpl#getAnimalTypeId <em>Animal Type Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.tracking.impl.ReferenceAnimalTypeImpl#getSpecies <em>Species</em>}</li>
 *   <li>{@link com.agritrace.edairy.model.tracking.impl.ReferenceAnimalTypeImpl#getBreed <em>Breed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceAnimalTypeImpl extends EObjectImpl implements ReferenceAnimalType {
	/**
         * The default value of the '{@link #getAnimalTypeId() <em>Animal Type Id</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getAnimalTypeId()
         * @generated
         * @ordered
         */
	protected static final long ANIMAL_TYPE_ID_EDEFAULT = 0L;

	/**
         * The cached value of the '{@link #getAnimalTypeId() <em>Animal Type Id</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getAnimalTypeId()
         * @generated
         * @ordered
         */
	protected long animalTypeId = ANIMAL_TYPE_ID_EDEFAULT;

	/**
         * The default value of the '{@link #getSpecies() <em>Species</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getSpecies()
         * @generated
         * @ordered
         */
	protected static final String SPECIES_EDEFAULT = null;

	/**
         * The cached value of the '{@link #getSpecies() <em>Species</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getSpecies()
         * @generated
         * @ordered
         */
	protected String species = SPECIES_EDEFAULT;

	/**
         * The default value of the '{@link #getBreed() <em>Breed</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getBreed()
         * @generated
         * @ordered
         */
	protected static final String BREED_EDEFAULT = null;

	/**
         * The cached value of the '{@link #getBreed() <em>Breed</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getBreed()
         * @generated
         * @ordered
         */
	protected String breed = BREED_EDEFAULT;

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	protected ReferenceAnimalTypeImpl() {
                super();
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	protected EClass eStaticClass() {
                return TrackingPackage.Literals.REFERENCE_ANIMAL_TYPE;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public long getAnimalTypeId() {
                return animalTypeId;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setAnimalTypeId(long newAnimalTypeId) {
                long oldAnimalTypeId = animalTypeId;
                animalTypeId = newAnimalTypeId;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REFERENCE_ANIMAL_TYPE__ANIMAL_TYPE_ID, oldAnimalTypeId, animalTypeId));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public String getSpecies() {
                return species;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setSpecies(String newSpecies) {
                String oldSpecies = species;
                species = newSpecies;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REFERENCE_ANIMAL_TYPE__SPECIES, oldSpecies, species));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public String getBreed() {
                return breed;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setBreed(String newBreed) {
                String oldBreed = breed;
                breed = newBreed;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.REFERENCE_ANIMAL_TYPE__BREED, oldBreed, breed));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case TrackingPackage.REFERENCE_ANIMAL_TYPE__ANIMAL_TYPE_ID:
                                return getAnimalTypeId();
                        case TrackingPackage.REFERENCE_ANIMAL_TYPE__SPECIES:
                                return getSpecies();
                        case TrackingPackage.REFERENCE_ANIMAL_TYPE__BREED:
                                return getBreed();
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
                        case TrackingPackage.REFERENCE_ANIMAL_TYPE__ANIMAL_TYPE_ID:
                                setAnimalTypeId((Long)newValue);
                                return;
                        case TrackingPackage.REFERENCE_ANIMAL_TYPE__SPECIES:
                                setSpecies((String)newValue);
                                return;
                        case TrackingPackage.REFERENCE_ANIMAL_TYPE__BREED:
                                setBreed((String)newValue);
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
                        case TrackingPackage.REFERENCE_ANIMAL_TYPE__ANIMAL_TYPE_ID:
                                setAnimalTypeId(ANIMAL_TYPE_ID_EDEFAULT);
                                return;
                        case TrackingPackage.REFERENCE_ANIMAL_TYPE__SPECIES:
                                setSpecies(SPECIES_EDEFAULT);
                                return;
                        case TrackingPackage.REFERENCE_ANIMAL_TYPE__BREED:
                                setBreed(BREED_EDEFAULT);
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
                        case TrackingPackage.REFERENCE_ANIMAL_TYPE__ANIMAL_TYPE_ID:
                                return animalTypeId != ANIMAL_TYPE_ID_EDEFAULT;
                        case TrackingPackage.REFERENCE_ANIMAL_TYPE__SPECIES:
                                return SPECIES_EDEFAULT == null ? species != null : !SPECIES_EDEFAULT.equals(species);
                        case TrackingPackage.REFERENCE_ANIMAL_TYPE__BREED:
                                return BREED_EDEFAULT == null ? breed != null : !BREED_EDEFAULT.equals(breed);
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
                result.append(" (animalTypeId: ");
                result.append(animalTypeId);
                result.append(", species: ");
                result.append(species);
                result.append(", breed: ");
                result.append(breed);
                result.append(')');
                return result.toString();
        }

} //ReferenceAnimalTypeImpl
