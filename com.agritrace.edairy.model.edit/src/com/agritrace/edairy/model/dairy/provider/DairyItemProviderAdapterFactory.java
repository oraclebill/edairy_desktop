/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.model.dairy.provider;

import com.agritrace.edairy.model.dairy.util.DairyAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DairyItemProviderAdapterFactory extends DairyAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DairyItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.agritrace.edairy.model.dairy.Vehicle} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VehicleItemProvider vehicleItemProvider;

	/**
	 * This creates an adapter for a {@link com.agritrace.edairy.model.dairy.Vehicle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVehicleAdapter() {
		if (vehicleItemProvider == null) {
			vehicleItemProvider = new VehicleItemProvider(this);
		}

		return vehicleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.agritrace.edairy.model.dairy.CollectionJournalLine} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionJournalLineItemProvider collectionJournalLineItemProvider;

	/**
	 * This creates an adapter for a {@link com.agritrace.edairy.model.dairy.CollectionJournalLine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCollectionJournalLineAdapter() {
		if (collectionJournalLineItemProvider == null) {
			collectionJournalLineItemProvider = new CollectionJournalLineItemProvider(this);
		}

		return collectionJournalLineItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.agritrace.edairy.model.dairy.Employee} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EmployeeItemProvider employeeItemProvider;

	/**
	 * This creates an adapter for a {@link com.agritrace.edairy.model.dairy.Employee}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEmployeeAdapter() {
		if (employeeItemProvider == null) {
			employeeItemProvider = new EmployeeItemProvider(this);
		}

		return employeeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.agritrace.edairy.model.dairy.DairyLocation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DairyLocationItemProvider dairyLocationItemProvider;

	/**
	 * This creates an adapter for a {@link com.agritrace.edairy.model.dairy.DairyLocation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDairyLocationAdapter() {
		if (dairyLocationItemProvider == null) {
			dairyLocationItemProvider = new DairyLocationItemProvider(this);
		}

		return dairyLocationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.agritrace.edairy.model.dairy.CollectionJournal} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionJournalItemProvider collectionJournalItemProvider;

	/**
	 * This creates an adapter for a {@link com.agritrace.edairy.model.dairy.CollectionJournal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCollectionJournalAdapter() {
		if (collectionJournalItemProvider == null) {
			collectionJournalItemProvider = new CollectionJournalItemProvider(this);
		}

		return collectionJournalItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.agritrace.edairy.model.dairy.Route} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RouteItemProvider routeItemProvider;

	/**
	 * This creates an adapter for a {@link com.agritrace.edairy.model.dairy.Route}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRouteAdapter() {
		if (routeItemProvider == null) {
			routeItemProvider = new RouteItemProvider(this);
		}

		return routeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.agritrace.edairy.model.dairy.Trip} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TripItemProvider tripItemProvider;

	/**
	 * This creates an adapter for a {@link com.agritrace.edairy.model.dairy.Trip}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTripAdapter() {
		if (tripItemProvider == null) {
			tripItemProvider = new TripItemProvider(this);
		}

		return tripItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.agritrace.edairy.model.dairy.DeliveryJournal} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeliveryJournalItemProvider deliveryJournalItemProvider;

	/**
	 * This creates an adapter for a {@link com.agritrace.edairy.model.dairy.DeliveryJournal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDeliveryJournalAdapter() {
		if (deliveryJournalItemProvider == null) {
			deliveryJournalItemProvider = new DeliveryJournalItemProvider(this);
		}

		return deliveryJournalItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.agritrace.edairy.model.dairy.Dairy} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DairyItemProvider dairyItemProvider;

	/**
	 * This creates an adapter for a {@link com.agritrace.edairy.model.dairy.Dairy}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDairyAdapter() {
		if (dairyItemProvider == null) {
			dairyItemProvider = new DairyItemProvider(this);
		}

		return dairyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.agritrace.edairy.model.dairy.Membership} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MembershipItemProvider membershipItemProvider;

	/**
	 * This creates an adapter for a {@link com.agritrace.edairy.model.dairy.Membership}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMembershipAdapter() {
		if (membershipItemProvider == null) {
			membershipItemProvider = new MembershipItemProvider(this);
		}

		return membershipItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.agritrace.edairy.model.dairy.Asset} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssetItemProvider assetItemProvider;

	/**
	 * This creates an adapter for a {@link com.agritrace.edairy.model.dairy.Asset}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAssetAdapter() {
		if (assetItemProvider == null) {
			assetItemProvider = new AssetItemProvider(this);
		}

		return assetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.agritrace.edairy.model.dairy.DairyContainer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DairyContainerItemProvider dairyContainerItemProvider;

	/**
	 * This creates an adapter for a {@link com.agritrace.edairy.model.dairy.DairyContainer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDairyContainerAdapter() {
		if (dairyContainerItemProvider == null) {
			dairyContainerItemProvider = new DairyContainerItemProvider(this);
		}

		return dairyContainerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.agritrace.edairy.model.dairy.Supplier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SupplierItemProvider supplierItemProvider;

	/**
	 * This creates an adapter for a {@link com.agritrace.edairy.model.dairy.Supplier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSupplierAdapter() {
		if (supplierItemProvider == null) {
			supplierItemProvider = new SupplierItemProvider(this);
		}

		return supplierItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (vehicleItemProvider != null) vehicleItemProvider.dispose();
		if (collectionJournalLineItemProvider != null) collectionJournalLineItemProvider.dispose();
		if (employeeItemProvider != null) employeeItemProvider.dispose();
		if (dairyLocationItemProvider != null) dairyLocationItemProvider.dispose();
		if (collectionJournalItemProvider != null) collectionJournalItemProvider.dispose();
		if (routeItemProvider != null) routeItemProvider.dispose();
		if (tripItemProvider != null) tripItemProvider.dispose();
		if (deliveryJournalItemProvider != null) deliveryJournalItemProvider.dispose();
		if (dairyItemProvider != null) dairyItemProvider.dispose();
		if (membershipItemProvider != null) membershipItemProvider.dispose();
		if (assetItemProvider != null) assetItemProvider.dispose();
		if (dairyContainerItemProvider != null) dairyContainerItemProvider.dispose();
		if (supplierItemProvider != null) supplierItemProvider.dispose();
	}

}