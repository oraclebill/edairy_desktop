/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.tracking.util;

import com.agritrace.edairy.desktop.common.model.tracking.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage
 * @generated
 */
public class TrackingAdapterFactory extends AdapterFactoryImpl {
        /**
         * The cached model package.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected static TrackingPackage modelPackage;

        /**
         * Creates an instance of the adapter factory.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public TrackingAdapterFactory() {
                if (modelPackage == null) {
                        modelPackage = TrackingPackage.eINSTANCE;
                }
        }

        /**
         * Returns whether this factory is applicable for the type of the object.
         * <!-- begin-user-doc -->
         * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
         * <!-- end-user-doc -->
         * @return whether this factory is applicable for the type of the object.
         * @generated
         */
        @Override
        public boolean isFactoryForType(Object object) {
                if (object == modelPackage) {
                        return true;
                }
                if (object instanceof EObject) {
                        return ((EObject)object).eClass().getEPackage() == modelPackage;
                }
                return false;
        }

        /**
         * The switch that delegates to the <code>createXXX</code> methods.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected TrackingSwitch<Adapter> modelSwitch =
                new TrackingSwitch<Adapter>() {
                        @Override
                        public Adapter caseFarm(Farm object) {
                                return createFarmAdapter();
                        }
                        @Override
                        public Adapter caseContainer(Container object) {
                                return createContainerAdapter();
                        }
                        @Override
                        public Adapter caseRegisteredAnimal(RegisteredAnimal object) {
                                return createRegisteredAnimalAdapter();
                        }
                        @Override
                        public Adapter caseReferenceAnimalType(ReferenceAnimalType object) {
                                return createReferenceAnimalTypeAdapter();
                        }
                        @Override
                        public Adapter caseAnimalIdentifier(AnimalIdentifier object) {
                                return createAnimalIdentifierAdapter();
                        }
                        @Override
                        public Adapter defaultCase(EObject object) {
                                return createEObjectAdapter();
                        }
                };

        /**
         * Creates an adapter for the <code>target</code>.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param target the object to adapt.
         * @return the adapter for the <code>target</code>.
         * @generated
         */
        @Override
        public Adapter createAdapter(Notifier target) {
                return modelSwitch.doSwitch((EObject)target);
        }


        /**
         * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.tracking.Farm <em>Farm</em>}'.
         * <!-- begin-user-doc -->
         * This default implementation returns null so that we can easily ignore cases;
         * it's useful to ignore a case when inheritance will catch all the cases anyway.
         * <!-- end-user-doc -->
         * @return the new adapter.
         * @see com.agritrace.edairy.desktop.common.model.tracking.Farm
         * @generated
         */
        public Adapter createFarmAdapter() {
                return null;
        }

        /**
         * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.tracking.Container <em>Container</em>}'.
         * <!-- begin-user-doc -->
         * This default implementation returns null so that we can easily ignore cases;
         * it's useful to ignore a case when inheritance will catch all the cases anyway.
         * <!-- end-user-doc -->
         * @return the new adapter.
         * @see com.agritrace.edairy.desktop.common.model.tracking.Container
         * @generated
         */
        public Adapter createContainerAdapter() {
                return null;
        }

        /**
         * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal <em>Registered Animal</em>}'.
         * <!-- begin-user-doc -->
         * This default implementation returns null so that we can easily ignore cases;
         * it's useful to ignore a case when inheritance will catch all the cases anyway.
         * <!-- end-user-doc -->
         * @return the new adapter.
         * @see com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal
         * @generated
         */
        public Adapter createRegisteredAnimalAdapter() {
                return null;
        }

        /**
         * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.tracking.ReferenceAnimalType <em>Reference Animal Type</em>}'.
         * <!-- begin-user-doc -->
         * This default implementation returns null so that we can easily ignore cases;
         * it's useful to ignore a case when inheritance will catch all the cases anyway.
         * <!-- end-user-doc -->
         * @return the new adapter.
         * @see com.agritrace.edairy.desktop.common.model.tracking.ReferenceAnimalType
         * @generated
         */
        public Adapter createReferenceAnimalTypeAdapter() {
                return null;
        }

        /**
         * Creates a new adapter for an object of class '{@link com.agritrace.edairy.desktop.common.model.tracking.AnimalIdentifier <em>Animal Identifier</em>}'.
         * <!-- begin-user-doc -->
         * This default implementation returns null so that we can easily ignore cases;
         * it's useful to ignore a case when inheritance will catch all the cases anyway.
         * <!-- end-user-doc -->
         * @return the new adapter.
         * @see com.agritrace.edairy.desktop.common.model.tracking.AnimalIdentifier
         * @generated
         */
        public Adapter createAnimalIdentifierAdapter() {
                return null;
        }

        /**
         * Creates a new adapter for the default case.
         * <!-- begin-user-doc -->
         * This default implementation returns null.
         * <!-- end-user-doc -->
         * @return the new adapter.
         * @generated
         */
        public Adapter createEObjectAdapter() {
                return null;
        }

} //TrackingAdapterFactory
