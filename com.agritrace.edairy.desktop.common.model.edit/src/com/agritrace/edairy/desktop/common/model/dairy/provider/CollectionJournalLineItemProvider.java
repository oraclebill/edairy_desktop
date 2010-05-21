/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.provider;


import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;

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
 * This is the item provider adapter for a {@link com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CollectionJournalLineItemProvider
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
	public CollectionJournalLineItemProvider(AdapterFactory adapterFactory) {
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

			addLineNumberPropertyDescriptor(object);
			addRecordedMemberPropertyDescriptor(object);
			addQuantityPropertyDescriptor(object);
			addFlaggedPropertyDescriptor(object);
			addUnitOfMeasurePropertyDescriptor(object);
			addNotRecordedPropertyDescriptor(object);
			addValidatedMemberPropertyDescriptor(object);
			addOffRoutePropertyDescriptor(object);
			addFromPropertyDescriptor(object);
			addFarmContainerPropertyDescriptor(object);
			addDairyContainerPropertyDescriptor(object);
			addCollectionJournalPropertyDescriptor(object);
			addRejectedPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Line Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLineNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CollectionJournalLine_lineNumber_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CollectionJournalLine_lineNumber_feature", "_UI_CollectionJournalLine_type"),
				 DairyPackage.Literals.COLLECTION_JOURNAL_LINE__LINE_NUMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Recorded Member feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRecordedMemberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CollectionJournalLine_recordedMember_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CollectionJournalLine_recordedMember_feature", "_UI_CollectionJournalLine_type"),
				 DairyPackage.Literals.COLLECTION_JOURNAL_LINE__RECORDED_MEMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Quantity feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQuantityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CollectionJournalLine_quantity_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CollectionJournalLine_quantity_feature", "_UI_CollectionJournalLine_type"),
				 DairyPackage.Literals.COLLECTION_JOURNAL_LINE__QUANTITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Flagged feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFlaggedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CollectionJournalLine_flagged_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CollectionJournalLine_flagged_feature", "_UI_CollectionJournalLine_type"),
				 DairyPackage.Literals.COLLECTION_JOURNAL_LINE__FLAGGED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Unit Of Measure feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUnitOfMeasurePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CollectionJournalLine_unitOfMeasure_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CollectionJournalLine_unitOfMeasure_feature", "_UI_CollectionJournalLine_type"),
				 DairyPackage.Literals.COLLECTION_JOURNAL_LINE__UNIT_OF_MEASURE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Not Recorded feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNotRecordedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CollectionJournalLine_notRecorded_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CollectionJournalLine_notRecorded_feature", "_UI_CollectionJournalLine_type"),
				 DairyPackage.Literals.COLLECTION_JOURNAL_LINE__NOT_RECORDED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Validated Member feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValidatedMemberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CollectionJournalLine_validatedMember_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CollectionJournalLine_validatedMember_feature", "_UI_CollectionJournalLine_type"),
				 DairyPackage.Literals.COLLECTION_JOURNAL_LINE__VALIDATED_MEMBER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Off Route feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOffRoutePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CollectionJournalLine_offRoute_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CollectionJournalLine_offRoute_feature", "_UI_CollectionJournalLine_type"),
				 DairyPackage.Literals.COLLECTION_JOURNAL_LINE__OFF_ROUTE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the From feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFromPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CollectionJournalLine_from_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CollectionJournalLine_from_feature", "_UI_CollectionJournalLine_type"),
				 DairyPackage.Literals.COLLECTION_JOURNAL_LINE__FROM,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Farm Container feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFarmContainerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CollectionJournalLine_farmContainer_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CollectionJournalLine_farmContainer_feature", "_UI_CollectionJournalLine_type"),
				 DairyPackage.Literals.COLLECTION_JOURNAL_LINE__FARM_CONTAINER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Dairy Container feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDairyContainerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CollectionJournalLine_dairyContainer_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CollectionJournalLine_dairyContainer_feature", "_UI_CollectionJournalLine_type"),
				 DairyPackage.Literals.COLLECTION_JOURNAL_LINE__DAIRY_CONTAINER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Collection Journal feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCollectionJournalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CollectionJournalLine_collectionJournal_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CollectionJournalLine_collectionJournal_feature", "_UI_CollectionJournalLine_type"),
				 DairyPackage.Literals.COLLECTION_JOURNAL_LINE__COLLECTION_JOURNAL,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Rejected feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRejectedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CollectionJournalLine_rejected_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CollectionJournalLine_rejected_feature", "_UI_CollectionJournalLine_type"),
				 DairyPackage.Literals.COLLECTION_JOURNAL_LINE__REJECTED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns CollectionJournalLine.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CollectionJournalLine"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		CollectionJournalLine collectionJournalLine = (CollectionJournalLine)object;
		return getString("_UI_CollectionJournalLine_type") + " " + collectionJournalLine.getLineNumber();
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

		switch (notification.getFeatureID(CollectionJournalLine.class)) {
			case DairyPackage.COLLECTION_JOURNAL_LINE__LINE_NUMBER:
			case DairyPackage.COLLECTION_JOURNAL_LINE__RECORDED_MEMBER:
			case DairyPackage.COLLECTION_JOURNAL_LINE__QUANTITY:
			case DairyPackage.COLLECTION_JOURNAL_LINE__FLAGGED:
			case DairyPackage.COLLECTION_JOURNAL_LINE__UNIT_OF_MEASURE:
			case DairyPackage.COLLECTION_JOURNAL_LINE__NOT_RECORDED:
			case DairyPackage.COLLECTION_JOURNAL_LINE__OFF_ROUTE:
			case DairyPackage.COLLECTION_JOURNAL_LINE__REJECTED:
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
