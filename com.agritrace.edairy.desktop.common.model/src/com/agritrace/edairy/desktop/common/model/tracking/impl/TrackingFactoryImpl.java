/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.tracking.impl;

import com.agritrace.edairy.desktop.common.model.tracking.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.agritrace.edairy.desktop.common.model.tracking.AcquisitionType;
import com.agritrace.edairy.desktop.common.model.tracking.AnimalIdentifier;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.model.tracking.Mechanism;
import com.agritrace.edairy.desktop.common.model.tracking.Purpose;
import com.agritrace.edairy.desktop.common.model.tracking.RearingMode;
import com.agritrace.edairy.desktop.common.model.tracking.ReferenceAnimalType;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingFactory;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TrackingFactoryImpl extends EFactoryImpl implements TrackingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TrackingFactory init() {
		try {
			TrackingFactory theTrackingFactory = (TrackingFactory)EPackage.Registry.INSTANCE.getEFactory("http://com.agritrace.edairy.desktop.common.model/tracking/"); 
			if (theTrackingFactory != null) {
				return theTrackingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TrackingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrackingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TrackingPackage.FARM: return createFarm();
			case TrackingPackage.CONTAINER: return createContainer();
			case TrackingPackage.REGISTERED_ANIMAL: return createRegisteredAnimal();
			case TrackingPackage.REFERENCE_ANIMAL_TYPE: return createReferenceAnimalType();
			case TrackingPackage.ANIMAL_IDENTIFIER: return createAnimalIdentifier();
			case TrackingPackage.FARMER: return createFarmer();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TrackingPackage.ACQUISITION_TYPE:
				return createAcquisitionTypeFromString(eDataType, initialValue);
			case TrackingPackage.PURPOSE:
				return createPurposeFromString(eDataType, initialValue);
			case TrackingPackage.REARING_MODE:
				return createRearingModeFromString(eDataType, initialValue);
			case TrackingPackage.MECHANISM:
				return createMechanismFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TrackingPackage.ACQUISITION_TYPE:
				return convertAcquisitionTypeToString(eDataType, instanceValue);
			case TrackingPackage.PURPOSE:
				return convertPurposeToString(eDataType, instanceValue);
			case TrackingPackage.REARING_MODE:
				return convertRearingModeToString(eDataType, instanceValue);
			case TrackingPackage.MECHANISM:
				return convertMechanismToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Farm createFarm() {
		FarmImpl farm = new FarmImpl();
		return farm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public com.agritrace.edairy.desktop.common.model.tracking.Container createContainer() {
		ContainerImpl container = new ContainerImpl();
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegisteredAnimal createRegisteredAnimal() {
		RegisteredAnimalImpl registeredAnimal = new RegisteredAnimalImpl();
		return registeredAnimal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceAnimalType createReferenceAnimalType() {
		ReferenceAnimalTypeImpl referenceAnimalType = new ReferenceAnimalTypeImpl();
		return referenceAnimalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimalIdentifier createAnimalIdentifier() {
		AnimalIdentifierImpl animalIdentifier = new AnimalIdentifierImpl();
		return animalIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Farmer createFarmer() {
		FarmerImpl farmer = new FarmerImpl();
		return farmer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AcquisitionType createAcquisitionTypeFromString(EDataType eDataType, String initialValue) {
		AcquisitionType result = AcquisitionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAcquisitionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Purpose createPurposeFromString(EDataType eDataType, String initialValue) {
		Purpose result = Purpose.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPurposeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RearingMode createRearingModeFromString(EDataType eDataType, String initialValue) {
		RearingMode result = RearingMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRearingModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mechanism createMechanismFromString(EDataType eDataType, String initialValue) {
		Mechanism result = Mechanism.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMechanismToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrackingPackage getTrackingPackage() {
		return (TrackingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TrackingPackage getPackage() {
		return TrackingPackage.eINSTANCE;
	}

} //TrackingFactoryImpl
