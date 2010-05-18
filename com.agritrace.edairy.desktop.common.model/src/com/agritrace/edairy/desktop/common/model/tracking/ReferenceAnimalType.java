/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.tracking;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Animal Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.ReferenceAnimalType#getAnimalTypeId <em>Animal Type Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.ReferenceAnimalType#getSpecies <em>Species</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.tracking.ReferenceAnimalType#getBreed <em>Breed</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getReferenceAnimalType()
 * @model
 * @generated
 */
public interface ReferenceAnimalType extends EObject {
        /**
         * Returns the value of the '<em><b>Animal Type Id</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Animal Type Id</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Animal Type Id</em>' attribute.
         * @see #setAnimalTypeId(long)
         * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getReferenceAnimalType_AnimalTypeId()
         * @model
         * @generated
         */
        long getAnimalTypeId();

        /**
         * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.ReferenceAnimalType#getAnimalTypeId <em>Animal Type Id</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Animal Type Id</em>' attribute.
         * @see #getAnimalTypeId()
         * @generated
         */
        void setAnimalTypeId(long value);

        /**
         * Returns the value of the '<em><b>Species</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Species</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Species</em>' attribute.
         * @see #setSpecies(String)
         * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getReferenceAnimalType_Species()
         * @model
         * @generated
         */
        String getSpecies();

        /**
         * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.ReferenceAnimalType#getSpecies <em>Species</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Species</em>' attribute.
         * @see #getSpecies()
         * @generated
         */
        void setSpecies(String value);

        /**
         * Returns the value of the '<em><b>Breed</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Breed</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Breed</em>' attribute.
         * @see #setBreed(String)
         * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage#getReferenceAnimalType_Breed()
         * @model
         * @generated
         */
        String getBreed();

        /**
         * Sets the value of the '{@link com.agritrace.edairy.desktop.common.model.tracking.ReferenceAnimalType#getBreed <em>Breed</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Breed</em>' attribute.
         * @see #getBreed()
         * @generated
         */
        void setBreed(String value);

} // ReferenceAnimalType
