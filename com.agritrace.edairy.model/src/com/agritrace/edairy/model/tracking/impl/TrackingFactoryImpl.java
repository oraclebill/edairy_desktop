/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.tracking.impl;

import com.agritrace.edairy.model.tracking.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
			TrackingFactory theTrackingFactory = (TrackingFactory)EPackage.Registry.INSTANCE.getEFactory("http://com.agritrace.edairy.model/tracking/"); 
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
			case TrackingPackage.DAIRY: return createDairy();
			case TrackingPackage.FARM: return createFarm();
			case TrackingPackage.ANIMAL: return createAnimal();
			case TrackingPackage.CONTAINER: return createContainer();
			case TrackingPackage.PROCESSOR: return createProcessor();
			case TrackingPackage.SUPPLIER: return createSupplier();
			case TrackingPackage.COLLECTION: return createCollection();
			case TrackingPackage.LOT: return createLot();
			case TrackingPackage.DELIVERY: return createDelivery();
			case TrackingPackage.TRANSFER: return createTransfer();
			case TrackingPackage.REGISTERED_ANIMAL: return createRegisteredAnimal();
			case TrackingPackage.REFERENCE_ANIMAL_TYPE: return createReferenceAnimalType();
			case TrackingPackage.ANIMAL_IDENTIFIER: return createAnimalIdentifier();
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
			case TrackingPackage.UNIT_OF_MEASURE:
				return createUnitOfMeasureFromString(eDataType, initialValue);
			case TrackingPackage.CONTAINER_TYPE:
				return createContainerTypeFromString(eDataType, initialValue);
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
			case TrackingPackage.UNIT_OF_MEASURE:
				return convertUnitOfMeasureToString(eDataType, instanceValue);
			case TrackingPackage.CONTAINER_TYPE:
				return convertContainerTypeToString(eDataType, instanceValue);
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
	public Dairy createDairy() {
		DairyImpl dairy = new DairyImpl();
		return dairy;
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
	public Animal createAnimal() {
		AnimalImpl animal = new AnimalImpl();
		return animal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public com.agritrace.edairy.model.tracking.Container createContainer() {
		ContainerImpl container = new ContainerImpl();
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Processor createProcessor() {
		ProcessorImpl processor = new ProcessorImpl();
		return processor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Supplier createSupplier() {
		SupplierImpl supplier = new SupplierImpl();
		return supplier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection createCollection() {
		CollectionImpl collection = new CollectionImpl();
		return collection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lot createLot() {
		LotImpl lot = new LotImpl();
		return lot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Delivery createDelivery() {
		DeliveryImpl delivery = new DeliveryImpl();
		return delivery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transfer createTransfer() {
		TransferImpl transfer = new TransferImpl();
		return transfer;
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
	public UnitOfMeasure createUnitOfMeasureFromString(EDataType eDataType, String initialValue) {
		UnitOfMeasure result = UnitOfMeasure.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnitOfMeasureToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerType createContainerTypeFromString(EDataType eDataType, String initialValue) {
		ContainerType result = ContainerType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertContainerTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
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
