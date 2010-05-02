/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.tracking.provider;


import com.agritrace.edairy.model.dairy.provider.DairyEditPlugin;

import com.agritrace.edairy.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.model.tracking.TrackingPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.agritrace.edairy.model.tracking.RegisteredAnimal} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RegisteredAnimalItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegisteredAnimalItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addAnimnalRegistrationIdPropertyDescriptor(object);
			addGivenNamePropertyDescriptor(object);
			addLocationPropertyDescriptor(object);
			addGenderPropertyDescriptor(object);
			addAnimalTypePropertyDescriptor(object);
			addSireTypePropertyDescriptor(object);
			addPurposePropertyDescriptor(object);
			addDateOfAcquisitionPropertyDescriptor(object);
			addAcquisitionTypePropertyDescriptor(object);
			addIdentifiersPropertyDescriptor(object);
			addIdentifyingFeaturesPropertyDescriptor(object);
			addRearingModePropertyDescriptor(object);
			addPastOwnersPropertyDescriptor(object);
			addInsuranceNumberPropertyDescriptor(object);
			addDateOfBirthPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Animnal Registration Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAnimnalRegistrationIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegisteredAnimal_animnalRegistrationId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegisteredAnimal_animnalRegistrationId_feature", "_UI_RegisteredAnimal_type"),
				 TrackingPackage.Literals.REGISTERED_ANIMAL__ANIMNAL_REGISTRATION_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Given Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGivenNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegisteredAnimal_givenName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegisteredAnimal_givenName_feature", "_UI_RegisteredAnimal_type"),
				 TrackingPackage.Literals.REGISTERED_ANIMAL__GIVEN_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Location feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLocationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegisteredAnimal_location_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegisteredAnimal_location_feature", "_UI_RegisteredAnimal_type"),
				 TrackingPackage.Literals.REGISTERED_ANIMAL__LOCATION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Gender feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGenderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegisteredAnimal_gender_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegisteredAnimal_gender_feature", "_UI_RegisteredAnimal_type"),
				 TrackingPackage.Literals.REGISTERED_ANIMAL__GENDER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Animal Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAnimalTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegisteredAnimal_animalType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegisteredAnimal_animalType_feature", "_UI_RegisteredAnimal_type"),
				 TrackingPackage.Literals.REGISTERED_ANIMAL__ANIMAL_TYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sire Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSireTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegisteredAnimal_sireType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegisteredAnimal_sireType_feature", "_UI_RegisteredAnimal_type"),
				 TrackingPackage.Literals.REGISTERED_ANIMAL__SIRE_TYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Purpose feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPurposePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegisteredAnimal_purpose_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegisteredAnimal_purpose_feature", "_UI_RegisteredAnimal_type"),
				 TrackingPackage.Literals.REGISTERED_ANIMAL__PURPOSE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Date Of Acquisition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDateOfAcquisitionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegisteredAnimal_dateOfAcquisition_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegisteredAnimal_dateOfAcquisition_feature", "_UI_RegisteredAnimal_type"),
				 TrackingPackage.Literals.REGISTERED_ANIMAL__DATE_OF_ACQUISITION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Acquisition Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAcquisitionTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegisteredAnimal_acquisitionType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegisteredAnimal_acquisitionType_feature", "_UI_RegisteredAnimal_type"),
				 TrackingPackage.Literals.REGISTERED_ANIMAL__ACQUISITION_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Identifiers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdentifiersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegisteredAnimal_identifiers_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegisteredAnimal_identifiers_feature", "_UI_RegisteredAnimal_type"),
				 TrackingPackage.Literals.REGISTERED_ANIMAL__IDENTIFIERS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Identifying Features feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdentifyingFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegisteredAnimal_identifyingFeatures_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegisteredAnimal_identifyingFeatures_feature", "_UI_RegisteredAnimal_type"),
				 TrackingPackage.Literals.REGISTERED_ANIMAL__IDENTIFYING_FEATURES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Rearing Mode feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRearingModePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegisteredAnimal_rearingMode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegisteredAnimal_rearingMode_feature", "_UI_RegisteredAnimal_type"),
				 TrackingPackage.Literals.REGISTERED_ANIMAL__REARING_MODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Past Owners feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPastOwnersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegisteredAnimal_pastOwners_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegisteredAnimal_pastOwners_feature", "_UI_RegisteredAnimal_type"),
				 TrackingPackage.Literals.REGISTERED_ANIMAL__PAST_OWNERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Insurance Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInsuranceNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegisteredAnimal_insuranceNumber_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegisteredAnimal_insuranceNumber_feature", "_UI_RegisteredAnimal_type"),
				 TrackingPackage.Literals.REGISTERED_ANIMAL__INSURANCE_NUMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Date Of Birth feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDateOfBirthPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegisteredAnimal_dateOfBirth_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegisteredAnimal_dateOfBirth_feature", "_UI_RegisteredAnimal_type"),
				 TrackingPackage.Literals.REGISTERED_ANIMAL__DATE_OF_BIRTH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns RegisteredAnimal.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/RegisteredAnimal"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((RegisteredAnimal)object).getGivenName();
		return label == null || label.length() == 0 ?
			getString("_UI_RegisteredAnimal_type") :
			getString("_UI_RegisteredAnimal_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(RegisteredAnimal.class)) {
			case TrackingPackage.REGISTERED_ANIMAL__ANIMNAL_REGISTRATION_ID:
			case TrackingPackage.REGISTERED_ANIMAL__GIVEN_NAME:
			case TrackingPackage.REGISTERED_ANIMAL__GENDER:
			case TrackingPackage.REGISTERED_ANIMAL__PURPOSE:
			case TrackingPackage.REGISTERED_ANIMAL__DATE_OF_ACQUISITION:
			case TrackingPackage.REGISTERED_ANIMAL__ACQUISITION_TYPE:
			case TrackingPackage.REGISTERED_ANIMAL__IDENTIFYING_FEATURES:
			case TrackingPackage.REGISTERED_ANIMAL__REARING_MODE:
			case TrackingPackage.REGISTERED_ANIMAL__PAST_OWNERS:
			case TrackingPackage.REGISTERED_ANIMAL__INSURANCE_NUMBER:
			case TrackingPackage.REGISTERED_ANIMAL__DATE_OF_BIRTH:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DairyEditPlugin.INSTANCE;
	}

}
