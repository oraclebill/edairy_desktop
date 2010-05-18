/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.provider;


import com.agritrace.edairy.desktop.common.model.base.ModelPackage;

import com.agritrace.edairy.desktop.common.model.base.provider.CompanyItemProvider;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;

import com.agritrace.edairy.desktop.common.model.requests.RequestsFactory;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.agritrace.edairy.desktop.common.model.dairy.Dairy} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DairyItemProvider
	extends CompanyItemProvider
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
	public DairyItemProvider(AdapterFactory adapterFactory) {
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

			addRegistrationNumberPropertyDescriptor(object);
			addNhifNumberPropertyDescriptor(object);
			addNssfNumberPropertyDescriptor(object);
			addFederalPinPropertyDescriptor(object);
			addLicenseEffectiveDatePropertyDescriptor(object);
			addLicenseExpirationDatePropertyDescriptor(object);
			addSuppliersPropertyDescriptor(object);
			addDairyIdPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Registration Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRegistrationNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Dairy_registrationNumber_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Dairy_registrationNumber_feature", "_UI_Dairy_type"),
				 DairyPackage.Literals.DAIRY__REGISTRATION_NUMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Nhif Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNhifNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Dairy_nhifNumber_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Dairy_nhifNumber_feature", "_UI_Dairy_type"),
				 DairyPackage.Literals.DAIRY__NHIF_NUMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Nssf Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNssfNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Dairy_nssfNumber_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Dairy_nssfNumber_feature", "_UI_Dairy_type"),
				 DairyPackage.Literals.DAIRY__NSSF_NUMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Federal Pin feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFederalPinPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Dairy_federalPin_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Dairy_federalPin_feature", "_UI_Dairy_type"),
				 DairyPackage.Literals.DAIRY__FEDERAL_PIN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the License Effective Date feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLicenseEffectiveDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Dairy_licenseEffectiveDate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Dairy_licenseEffectiveDate_feature", "_UI_Dairy_type"),
				 DairyPackage.Literals.DAIRY__LICENSE_EFFECTIVE_DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the License Expiration Date feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLicenseExpirationDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Dairy_licenseExpirationDate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Dairy_licenseExpirationDate_feature", "_UI_Dairy_type"),
				 DairyPackage.Literals.DAIRY__LICENSE_EXPIRATION_DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Suppliers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuppliersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Dairy_suppliers_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Dairy_suppliers_feature", "_UI_Dairy_type"),
				 DairyPackage.Literals.DAIRY__SUPPLIERS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Dairy Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDairyIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Dairy_dairyId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Dairy_dairyId_feature", "_UI_Dairy_type"),
				 DairyPackage.Literals.DAIRY__DAIRY_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DairyPackage.Literals.DAIRY__ROUTES);
			childrenFeatures.add(DairyPackage.Literals.DAIRY__VEHICLES);
			childrenFeatures.add(DairyPackage.Literals.DAIRY__EMPLOYEES);
			childrenFeatures.add(DairyPackage.Literals.DAIRY__MEMBERSHIPS);
			childrenFeatures.add(DairyPackage.Literals.DAIRY__BRANCH_LOCATIONS);
			childrenFeatures.add(DairyPackage.Literals.DAIRY__COLLECTION_JOURNALS);
			childrenFeatures.add(DairyPackage.Literals.DAIRY__ANIMAL_HEALTH_REQUESTS);
			childrenFeatures.add(DairyPackage.Literals.DAIRY__DAIRY_BINS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Dairy.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Dairy"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Dairy)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Dairy_type") :
			getString("_UI_Dairy_type") + " " + label;
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

		switch (notification.getFeatureID(Dairy.class)) {
			case DairyPackage.DAIRY__REGISTRATION_NUMBER:
			case DairyPackage.DAIRY__NHIF_NUMBER:
			case DairyPackage.DAIRY__NSSF_NUMBER:
			case DairyPackage.DAIRY__FEDERAL_PIN:
			case DairyPackage.DAIRY__LICENSE_EFFECTIVE_DATE:
			case DairyPackage.DAIRY__LICENSE_EXPIRATION_DATE:
			case DairyPackage.DAIRY__DAIRY_ID:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DairyPackage.DAIRY__ROUTES:
			case DairyPackage.DAIRY__VEHICLES:
			case DairyPackage.DAIRY__EMPLOYEES:
			case DairyPackage.DAIRY__MEMBERSHIPS:
			case DairyPackage.DAIRY__BRANCH_LOCATIONS:
			case DairyPackage.DAIRY__COLLECTION_JOURNALS:
			case DairyPackage.DAIRY__ANIMAL_HEALTH_REQUESTS:
			case DairyPackage.DAIRY__DAIRY_BINS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(DairyPackage.Literals.DAIRY__ROUTES,
				 DairyFactory.eINSTANCE.createRoute()));

		newChildDescriptors.add
			(createChildParameter
				(DairyPackage.Literals.DAIRY__VEHICLES,
				 DairyFactory.eINSTANCE.createVehicle()));

		newChildDescriptors.add
			(createChildParameter
				(DairyPackage.Literals.DAIRY__EMPLOYEES,
				 DairyFactory.eINSTANCE.createEmployee()));

		newChildDescriptors.add
			(createChildParameter
				(DairyPackage.Literals.DAIRY__MEMBERSHIPS,
				 DairyFactory.eINSTANCE.createMembership()));

		newChildDescriptors.add
			(createChildParameter
				(DairyPackage.Literals.DAIRY__BRANCH_LOCATIONS,
				 DairyFactory.eINSTANCE.createDairyLocation()));

		newChildDescriptors.add
			(createChildParameter
				(DairyPackage.Literals.DAIRY__COLLECTION_JOURNALS,
				 DairyFactory.eINSTANCE.createCollectionJournal()));

		newChildDescriptors.add
			(createChildParameter
				(DairyPackage.Literals.DAIRY__ANIMAL_HEALTH_REQUESTS,
				 RequestsFactory.eINSTANCE.createAnimalHealthRequest()));

		newChildDescriptors.add
			(createChildParameter
				(DairyPackage.Literals.DAIRY__DAIRY_BINS,
				 DairyFactory.eINSTANCE.createDairyContainer()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == ModelPackage.Literals.COMPANY__CONTACTS ||
			childFeature == DairyPackage.Literals.DAIRY__EMPLOYEES;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
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
