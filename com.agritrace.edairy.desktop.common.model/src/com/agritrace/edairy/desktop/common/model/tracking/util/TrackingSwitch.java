/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.tracking.util;

import com.agritrace.edairy.desktop.common.model.tracking.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage
 * @generated
 */
public class TrackingSwitch<T> {
        /**
         * The cached model package
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected static TrackingPackage modelPackage;

        /**
         * Creates an instance of the switch.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public TrackingSwitch() {
                if (modelPackage == null) {
                        modelPackage = TrackingPackage.eINSTANCE;
                }
        }

        /**
         * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the first non-null result returned by a <code>caseXXX</code> call.
         * @generated
         */
        public T doSwitch(EObject theEObject) {
                return doSwitch(theEObject.eClass(), theEObject);
        }

        /**
         * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the first non-null result returned by a <code>caseXXX</code> call.
         * @generated
         */
        protected T doSwitch(EClass theEClass, EObject theEObject) {
                if (theEClass.eContainer() == modelPackage) {
                        return doSwitch(theEClass.getClassifierID(), theEObject);
                }
                else {
                        List<EClass> eSuperTypes = theEClass.getESuperTypes();
                        return
                                eSuperTypes.isEmpty() ?
                                        defaultCase(theEObject) :
                                        doSwitch(eSuperTypes.get(0), theEObject);
                }
        }

        /**
         * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @return the first non-null result returned by a <code>caseXXX</code> call.
         * @generated
         */
        protected T doSwitch(int classifierID, EObject theEObject) {
                switch (classifierID) {
                        case TrackingPackage.FARM: {
                                Farm farm = (Farm)theEObject;
                                T result = caseFarm(farm);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case TrackingPackage.CONTAINER: {
                                Container container = (Container)theEObject;
                                T result = caseContainer(container);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case TrackingPackage.REGISTERED_ANIMAL: {
                                RegisteredAnimal registeredAnimal = (RegisteredAnimal)theEObject;
                                T result = caseRegisteredAnimal(registeredAnimal);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case TrackingPackage.REFERENCE_ANIMAL_TYPE: {
                                ReferenceAnimalType referenceAnimalType = (ReferenceAnimalType)theEObject;
                                T result = caseReferenceAnimalType(referenceAnimalType);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case TrackingPackage.ANIMAL_IDENTIFIER: {
                                AnimalIdentifier animalIdentifier = (AnimalIdentifier)theEObject;
                                T result = caseAnimalIdentifier(animalIdentifier);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        default: return defaultCase(theEObject);
                }
        }

        /**
         * Returns the result of interpreting the object as an instance of '<em>Farm</em>'.
         * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Farm</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
        public T caseFarm(Farm object) {
                return null;
        }

        /**
         * Returns the result of interpreting the object as an instance of '<em>Container</em>'.
         * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Container</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
        public T caseContainer(Container object) {
                return null;
        }

        /**
         * Returns the result of interpreting the object as an instance of '<em>Registered Animal</em>'.
         * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Registered Animal</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
        public T caseRegisteredAnimal(RegisteredAnimal object) {
                return null;
        }

        /**
         * Returns the result of interpreting the object as an instance of '<em>Reference Animal Type</em>'.
         * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Reference Animal Type</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
        public T caseReferenceAnimalType(ReferenceAnimalType object) {
                return null;
        }

        /**
         * Returns the result of interpreting the object as an instance of '<em>Animal Identifier</em>'.
         * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Animal Identifier</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
        public T caseAnimalIdentifier(AnimalIdentifier object) {
                return null;
        }

        /**
         * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
         * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch, but this is the last case anyway.
         * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject)
         * @generated
         */
        public T defaultCase(EObject object) {
                return null;
        }

} //TrackingSwitch
