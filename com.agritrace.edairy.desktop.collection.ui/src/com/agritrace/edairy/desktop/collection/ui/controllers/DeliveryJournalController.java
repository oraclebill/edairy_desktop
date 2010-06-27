package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.IValueRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class DeliveryJournalController extends BasicDirectoryController<DeliveryJournal> {

	private final IDairyRepository dairyRepo = new DairyRepository();
	private List<DeliveryJournal> deliveries = null;
	private DeliveryJournalFilterBean filterBean = null;
	
	private IDateTimeRidget startDateRidget;
	private IDateTimeRidget endDateRidget;
	private IComboRidget routeRidget;
	private IComboRidget customerRidget;

	public DeliveryJournalController() {
		setEClass(DairyPackage.Literals.DELIVERY_JOURNAL);
		setEntityClass(DeliveryJournal.class);
		
		addTableColumn("Date", DairyPackage.Literals.DELIVERY_JOURNAL__DATE);
		addTableColumn("Route", DairyPackage.Literals.DELIVERY_JOURNAL__ROUTE);
		addTableColumn("Session", DairyPackage.Literals.DELIVERY_JOURNAL__SESSION);
		addTableColumn("Customer", DairyPackage.Literals.DELIVERY_JOURNAL__CUSTOMER);
		addTableColumn("Total", DairyPackage.Literals.DELIVERY_JOURNAL__TOTAL);
	}

	@Override
	protected void configureFilterRidgets() {
		filterBean = new DeliveryJournalFilterBean();	
		startDateRidget = getRidget(IDateTimeRidget.class, DeliveryJournalFilterBean.START_DATE);
		startDateRidget.bindToModel(BeansObservables.observeValue(filterBean, "minDate"));
		endDateRidget = getRidget(IDateTimeRidget.class, DeliveryJournalFilterBean.END_DATE);
		endDateRidget.bindToModel(BeansObservables.observeValue(filterBean, "maxDate"));
		routeRidget = getRidget(IComboRidget.class, DeliveryJournalFilterBean.ROUTE);
		final IObservableList routeList = Observables.staticObservableList(dairyRepo.allRoutes());
		routeRidget.bindToModel(routeList, Route.class, "getName", BeansObservables.observeValue(filterBean, "route"));
		customerRidget = getRidget(IComboRidget.class, DeliveryJournalFilterBean.CUSTOMER);
		final IObservableList customerList = Observables.staticObservableList(dairyRepo.allCustomers());
		customerRidget.bindToModel(customerList, Customer.class, "getCompanyName", BeansObservables.observeValue(filterBean, "customer"));	
	}

	@Override
	public void afterBind() {
		super.afterBind();		
		bindFilterRidgets();
		bindFilterActions();
	}

	private void bindFilterRidgets() {
//		filterBean = new DeliveryJournalFilterBean();	
//		
//		startDateRidget.bindToModel(BeansObservables.observeValue(filterBean, "minDate"));
//		
//		endDateRidget.bindToModel(BeansObservables.observeValue(filterBean, "maxDate"));
//		
//		final IObservableList routeList = Observables.staticObservableList(dairyRepo.allRoutes());
//		routeRidget.bindToModel(routeList, Route.class, "getName", BeansObservables.observeValue(filterBean, "route"));
//		
//		final IObservableList customerList = Observables.staticObservableList(dairyRepo.allCustomers());
//		customerRidget.bindToModel(customerList, Customer.class, "getCompanyName", BeansObservables.observeValue(filterBean, "customer"));	

		startDateRidget.updateFromModel();
		endDateRidget.updateFromModel();
		routeRidget.updateFromModel();
		customerRidget.updateFromModel();
	}
	
	private void bindFilterActions() {
		
	}

	@Override
	protected List<DeliveryJournal> getFilteredResult() {
		List<DeliveryJournal> allJournals = dairyRepo.allDeliveries();
		List<DeliveryJournal> filteredList = new ArrayList<DeliveryJournal>();

		return new ArrayList<DeliveryJournal>(); // TODO: fix
		// return filteredList;
	}

	@Override
	protected RecordDialog<DeliveryJournal, ?> getRecordDialog(Shell shell) {
		return new DeliveryJournalEditDialog(shell);		
	}

	@Override
	protected void resetFilterConditions() {
		bindFilterRidgets();
//		table.updateFromModel();
	}

}
