/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.base.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.agritrace.edairy.desktop.common.model.base.Audited;
import com.agritrace.edairy.desktop.common.model.base.Company;
import com.agritrace.edairy.desktop.common.model.base.ContactMethod;
import com.agritrace.edairy.desktop.common.model.base.ContactMethodType;
import com.agritrace.edairy.desktop.common.model.base.Contactable;
import com.agritrace.edairy.desktop.common.model.base.ContainerType;
import com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation;
import com.agritrace.edairy.desktop.common.model.base.Gender;
import com.agritrace.edairy.desktop.common.model.base.ImageEntry;
import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.MapLocation;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.model.base.StatutoryLocation;
import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.base.Versioned;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelFactory init() {
		try {
			final ModelFactory theModelFactory = (ModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://com.agritrace.edairy.desktop.common.model/base/");
			if (theModelFactory != null) {
				return theModelFactory;
			}
		}
		catch (final Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactoryImpl() {
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
			case ModelPackage.MAP_LOCATION: return createMapLocation();
			case ModelPackage.POSTAL_LOCATION: return createPostalLocation();
			case ModelPackage.STATUTORY_LOCATION: return createStatutoryLocation();
			case ModelPackage.AUDITED: return createAudited();
			case ModelPackage.VERSIONED: return createVersioned();
			case ModelPackage.CONTACTABLE: return createContactable();
			case ModelPackage.PERSON: return createPerson();
			case ModelPackage.COMPANY: return createCompany();
			case ModelPackage.DESCRIPTIVE_LOCATION: return createDescriptiveLocation();
			case ModelPackage.LOCATION: return createLocation();
			case ModelPackage.CONTACT_METHOD: return createContactMethod();
			case ModelPackage.IMAGE_ENTRY: return createImageEntry();
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
			case ModelPackage.GENDER:
				return createGenderFromString(eDataType, initialValue);
			case ModelPackage.CONTACT_METHOD_TYPE:
				return createContactMethodTypeFromString(eDataType, initialValue);
			case ModelPackage.UNIT_OF_MEASURE:
				return createUnitOfMeasureFromString(eDataType, initialValue);
			case ModelPackage.CONTAINER_TYPE:
				return createContainerTypeFromString(eDataType, initialValue);
			case ModelPackage.TRANSACTION_ID:
				return createTransactionIDFromString(eDataType, initialValue);
			case ModelPackage.UNIQUE_ID:
				return createUniqueIDFromString(eDataType, initialValue);
			case ModelPackage.IMAGE_REFERENCE:
				return createImageReferenceFromString(eDataType, initialValue);
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
			case ModelPackage.GENDER:
				return convertGenderToString(eDataType, instanceValue);
			case ModelPackage.CONTACT_METHOD_TYPE:
				return convertContactMethodTypeToString(eDataType, instanceValue);
			case ModelPackage.UNIT_OF_MEASURE:
				return convertUnitOfMeasureToString(eDataType, instanceValue);
			case ModelPackage.CONTAINER_TYPE:
				return convertContainerTypeToString(eDataType, instanceValue);
			case ModelPackage.TRANSACTION_ID:
				return convertTransactionIDToString(eDataType, instanceValue);
			case ModelPackage.UNIQUE_ID:
				return convertUniqueIDToString(eDataType, instanceValue);
			case ModelPackage.IMAGE_REFERENCE:
				return convertImageReferenceToString(eDataType, instanceValue);
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
	public MapLocation createMapLocation() {
		final MapLocationImpl mapLocation = new MapLocationImpl();
		return mapLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PostalLocation createPostalLocation() {
		final PostalLocationImpl postalLocation = new PostalLocationImpl();
		return postalLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StatutoryLocation createStatutoryLocation() {
		final StatutoryLocationImpl statutoryLocation = new StatutoryLocationImpl();
		return statutoryLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Audited createAudited() {
		final AuditedImpl audited = new AuditedImpl();
		return audited;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Versioned createVersioned() {
		final VersionedImpl versioned = new VersionedImpl();
		return versioned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Contactable createContactable() {
		final ContactableImpl contactable = new ContactableImpl();
		return contactable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Person createPerson() {
		final PersonImpl person = new PersonImpl();
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Company createCompany() {
		final CompanyImpl company = new CompanyImpl();
		return company;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DescriptiveLocation createDescriptiveLocation() {
		final DescriptiveLocationImpl descriptiveLocation = new DescriptiveLocationImpl();
		return descriptiveLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Location createLocation() {
		final LocationImpl location = new LocationImpl();
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ContactMethod createContactMethod() {
		final ContactMethodImpl contactMethod = new ContactMethodImpl();
		return contactMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageEntry createImageEntry() {
		final ImageEntryImpl imageEntry = new ImageEntryImpl();
		return imageEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gender createGenderFromString(EDataType eDataType, String initialValue) {
		final Gender result = Gender.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenderToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContactMethodType createContactMethodTypeFromString(EDataType eDataType, String initialValue) {
		final ContactMethodType result = ContactMethodType.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertContactMethodTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitOfMeasure createUnitOfMeasureFromString(EDataType eDataType, String initialValue) {
		final UnitOfMeasure result = UnitOfMeasure.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
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
		final ContainerType result = ContainerType.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
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
	public String createTransactionIDFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTransactionIDToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long createUniqueIDFromString(EDataType eDataType, String initialValue) {
		return (Long)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUniqueIDToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createImageReferenceFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertImageReferenceToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelPackage getModelPackage() {
		return (ModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelPackage getPackage() {
		return ModelPackage.eINSTANCE;
	}

} //ModelFactoryImpl
