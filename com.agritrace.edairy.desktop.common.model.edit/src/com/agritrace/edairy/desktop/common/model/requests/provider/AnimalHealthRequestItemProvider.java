/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.requests.provider;


import com.agritrace.edairy.desktop.common.model.dairy.provider.DairyEditPlugin;

import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;

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
 * This is the item provider adapter for a {@link com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AnimalHealthRequestItemProvider
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
	public AnimalHealthRequestItemProvider(AdapterFactory adapterFactory) {
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

			addRequestIdPropertyDescriptor(object);
			addRequestingMemberPropertyDescriptor(object);
			addDairyPropertyDescriptor(object);
			addDatePropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addReportedProblemPropertyDescriptor(object);
			addReportedAnimalPropertyDescriptor(object);
			addDateHeatDetectedPropertyDescriptor(object);
			addFirstTreatmentPropertyDescriptor(object);
			addSecondTreatmentPropertyDescriptor(object);
			addThirdTreatmentPropertyDescriptor(object);
			addMemberPropertyDescriptor(object);
			addFarmPropertyDescriptor(object);
			addReferredToPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Request Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequestIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnimalHealthRequest_requestId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnimalHealthRequest_requestId_feature", "_UI_AnimalHealthRequest_type"),
				 RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUEST_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Requesting Member feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequestingMemberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnimalHealthRequest_requestingMember_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnimalHealthRequest_requestingMember_feature", "_UI_AnimalHealthRequest_type"),
				 RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Dairy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDairyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnimalHealthRequest_dairy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnimalHealthRequest_dairy_feature", "_UI_AnimalHealthRequest_type"),
				 RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DAIRY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Date feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnimalHealthRequest_date_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnimalHealthRequest_date_feature", "_UI_AnimalHealthRequest_type"),
				 RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnimalHealthRequest_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnimalHealthRequest_type_feature", "_UI_AnimalHealthRequest_type"),
				 RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Reported Problem feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReportedProblemPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnimalHealthRequest_reportedProblem_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnimalHealthRequest_reportedProblem_feature", "_UI_AnimalHealthRequest_type"),
				 RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REPORTED_PROBLEM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Reported Animal feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReportedAnimalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnimalHealthRequest_reportedAnimal_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnimalHealthRequest_reportedAnimal_feature", "_UI_AnimalHealthRequest_type"),
				 RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REPORTED_ANIMAL,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Date Heat Detected feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDateHeatDetectedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnimalHealthRequest_dateHeatDetected_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnimalHealthRequest_dateHeatDetected_feature", "_UI_AnimalHealthRequest_type"),
				 RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE_HEAT_DETECTED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the First Treatment feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFirstTreatmentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnimalHealthRequest_firstTreatment_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnimalHealthRequest_firstTreatment_feature", "_UI_AnimalHealthRequest_type"),
				 RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FIRST_TREATMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Second Treatment feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSecondTreatmentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnimalHealthRequest_secondTreatment_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnimalHealthRequest_secondTreatment_feature", "_UI_AnimalHealthRequest_type"),
				 RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__SECOND_TREATMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Third Treatment feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addThirdTreatmentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnimalHealthRequest_thirdTreatment_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnimalHealthRequest_thirdTreatment_feature", "_UI_AnimalHealthRequest_type"),
				 RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__THIRD_TREATMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Member feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMemberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnimalHealthRequest_member_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnimalHealthRequest_member_feature", "_UI_AnimalHealthRequest_type"),
				 RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__MEMBER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Farm feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFarmPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnimalHealthRequest_farm_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnimalHealthRequest_farm_feature", "_UI_AnimalHealthRequest_type"),
				 RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FARM,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Referred To feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferredToPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AnimalHealthRequest_referredTo_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AnimalHealthRequest_referredTo_feature", "_UI_AnimalHealthRequest_type"),
				 RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REFERRED_TO,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns AnimalHealthRequest.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AnimalHealthRequest"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		Long labelValue = ((AnimalHealthRequest)object).getRequestId();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_AnimalHealthRequest_type") :
			getString("_UI_AnimalHealthRequest_type") + " " + label;
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

		switch (notification.getFeatureID(AnimalHealthRequest.class)) {
			case RequestsPackage.ANIMAL_HEALTH_REQUEST__REQUEST_ID:
			case RequestsPackage.ANIMAL_HEALTH_REQUEST__DATE:
			case RequestsPackage.ANIMAL_HEALTH_REQUEST__TYPE:
			case RequestsPackage.ANIMAL_HEALTH_REQUEST__REPORTED_PROBLEM:
			case RequestsPackage.ANIMAL_HEALTH_REQUEST__DATE_HEAT_DETECTED:
			case RequestsPackage.ANIMAL_HEALTH_REQUEST__FIRST_TREATMENT:
			case RequestsPackage.ANIMAL_HEALTH_REQUEST__SECOND_TREATMENT:
			case RequestsPackage.ANIMAL_HEALTH_REQUEST__THIRD_TREATMENT:
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
