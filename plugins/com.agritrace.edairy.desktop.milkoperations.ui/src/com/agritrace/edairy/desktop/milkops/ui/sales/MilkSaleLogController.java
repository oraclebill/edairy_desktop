package com.agritrace.edairy.desktop.milkops.ui.sales;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.MilkSale;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.model.dairy.security.UIPermission;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractPersistenceDelegate;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.milkops.ui.sales.MilkSaleEditDialog.MilkSaleEditDialogController;
import com.google.inject.Inject;


@PermissionRequired(UIPermission.VIEW_MILK_DELIVERIES)
public class MilkSaleLogController extends BasicDirectoryController<MilkSale> {
	
	
	private IComboRidget customerRidget;

	private IDateTimeRidget endDateRidget;
	private MilkSaleLogFilterBean filterBean = null;
	private IComboRidget routeRidget;
	private IDateTimeRidget startDateRidget;

	private final IDairyRepository dairyRepo;

	@Inject
	public MilkSaleLogController(final IDairyRepository dairyRepo, final IRepository<MilkSale> repo) {
		this.dairyRepo = dairyRepo;
		setEClass(DairyPackage.Literals.MILK_SALE);
		setRepository(repo);
		setPersistenceDelegate(new AbstractPersistenceDelegate<MilkSale>() {
			
			private MilkSale lastSavedItem = null;
			
			@Override
			public MilkSale createItem() {
				MilkSale sale =  DairyFactory.eINSTANCE.createMilkSale();
				if (lastSavedItem != null) {
					// copy
					System.err.println("OUTOUTOUT");
				}
				sale.setSaleDate(new Date());
//				sale.setSaleAmount(BigDecimal.ZERO);
				return sale;
			}

			@Override
			public MilkSale load(Object key) {
				return null;
			}

			@Override
			public void delete(MilkSale obj) {
				// TODO: implement delete
				MilkSale saleObject = (MilkSale) obj;
				Long key = saleObject.getId();
				if (null != key) {
					//	dairyRepo.delete(oldItem);
				}
				throw new UnsupportedOperationException();
			}

			@Override
			public void rollback(Object obj) {
				// TODO: implement rollback
				MilkSale saleObject = (MilkSale) obj;
				Long key = saleObject.getId();
				if (null != key) {
					// dairyRepo.rollback(obj);
				}
			}

			@Override
			public void persistNew(MilkSale obj) {
				dairyRepo.save(obj);
			}

			@Override
			public MilkSale updateExisting(MilkSale obj) {
				dairyRepo.save(obj);
				return obj;
			}
			
		});

		addTableColumn("Date", DairyPackage.Literals.MILK_SALE__SALE_DATE);
		addTableColumn("Store", "storeOrRoute.code", String.class );
		addTableColumn("Customer", "customer.companyName", String.class);
		addTableColumn("Qty", DairyPackage.Literals.MILK_SALE__QUANTITY);
		addTableColumn("Grade", "grade.code", String.class);
		addTableColumn("Price", DairyPackage.Literals.MILK_SALE__UNIT_PRICE);
		addTableColumn("Amount", DairyPackage.Literals.MILK_SALE__SALE_AMOUNT);
		addTableColumn("Clerk", "salesClerk.formattedName", String.class);
	}

	@Override
	protected void configureFilterRidgets() {
		filterBean = new MilkSaleLogFilterBean();

		startDateRidget = getRidget(IDateTimeRidget.class, MilkSaleLogFilterPanel.FILTER_START_DATE);
		startDateRidget.bindToModel(BeansObservables.observeValue(filterBean, MilkSaleLogFilterBean.START_DATE));

		endDateRidget = getRidget(IDateTimeRidget.class, MilkSaleLogFilterPanel.FILTER_END_DATE);
		endDateRidget.bindToModel(BeansObservables.observeValue(filterBean, MilkSaleLogFilterBean.END_DATE));

		final List<Route> routes = new ArrayList<Route>();
		routes.add(null);
		routes.addAll(dairyRepo.allRoutes());

		routeRidget = getRidget(IComboRidget.class, MilkSaleLogFilterPanel.FILTER_STORE);
		final IObservableList routeList = Observables.staticObservableList(routes);
		routeRidget.bindToModel(routeList, Route.class, "getName", BeansObservables.observeValue(filterBean, MilkSaleLogFilterBean.STORE));

		customerRidget = getRidget(IComboRidget.class, MilkSaleLogFilterPanel.FILTER_CUSTOMER);
		final IObservableList customerList = Observables.staticObservableList(dairyRepo.allCustomers());
		customerRidget.bindToModel(customerList, Customer.class, "getCompanyName",
				BeansObservables.observeValue(filterBean, MilkSaleLogFilterBean.CUSTOMER));

		startDateRidget.updateFromModel();
		endDateRidget.updateFromModel();
		routeRidget.updateFromModel();
		customerRidget.updateFromModel();

	}
	
	@Override
	protected void resetFilterConditions() {
		Calendar cal = Calendar.getInstance();
		cal = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);
		filterBean.setMinDate(cal.getTime());
		filterBean.setMaxDate(new Date());
		filterBean.setCustomer(null);
		filterBean.setStore(null);

		updateAllRidgetsFromModel();
	}


	@Override
	protected List<MilkSale> getFilteredResult() {
		return dairyRepo.getMilkSales(
				filterBean.getMinDate(),
				filterBean.getMaxDate(),
				filterBean.getStore(),
				filterBean.getCustomer());
	}

	@Override
	protected RecordDialog<MilkSale> getRecordDialog(Shell shell) {
//		return editDialogProvider.get();		
		return new MilkSaleEditDialog(getShell(), 
				new MilkSaleEditDialogController(
						new MilkSaleEditPanelController(dairyRepo)));
	}

	@Override
	protected void createEntity(MilkSale newEntity) {
		throw new UnsupportedOperationException();
	}

}
