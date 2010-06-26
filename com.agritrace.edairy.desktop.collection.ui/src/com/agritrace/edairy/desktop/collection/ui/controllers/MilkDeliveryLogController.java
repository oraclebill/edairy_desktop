package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
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

public class MilkDeliveryLogController extends BasicDirectoryController<DeliveryJournal> {

	private final IDairyRepository dairyRepo = new DairyRepository();
	private List<DeliveryJournal> deliveries = null;
	
	public MilkDeliveryLogController() {		
		addTableColumn("Date", DairyPackage.Literals.DELIVERY_JOURNAL__DATE);
		addTableColumn("Route", DairyPackage.Literals.DELIVERY_JOURNAL__ROUTE);
		addTableColumn("Session", DairyPackage.Literals.DELIVERY_JOURNAL__SESSION);
		addTableColumn("Customer", DairyPackage.Literals.DELIVERY_JOURNAL__CUSTOMER);
		addTableColumn("Total", DairyPackage.Literals.DELIVERY_JOURNAL__TOTAL);
	} 
	
	@Override
	protected void configureFilterRidgets() {
		addFilterParam("filter-start-date", IDateTimeRidget.class, 
				FilterUtil.FILTER_GREATER_THAN, Properties.observableValue("startDate"));
		addFilterParam("filter-end-date", IDateTimeRidget.class, 
				FilterUtil.FILTER_LESS_THAN, EMFProperties.value(DairyPackage.Literals.DELIVERY_JOURNAL__ROUTE));
		addFilterParam(
				"filter-route", 
				IComboRidget.class,
				EMFObservables.observeList(getLocalDairy(), DairyPackage.Literals.DAIRY__ROUTES),
				Route.class,
				"getName",
				FilterUtil.FILTER_EQUALS, 
				EMFProperties.value(DairyPackage.Literals.DELIVERY_JOURNAL__ROUTE));
		addFilterParam(
				"filter-customer",  
				IComboRidget.class,
				EMFObservables.observeList(getLocalDairy(), DairyPackage.Literals.DAIRY__CUSTOMERS),
				Customer.class,			
				"getCompanyName",
				FilterUtil.FILTER_EQUALS, 
				EMFProperties.value(DairyPackage.Literals.DELIVERY_JOURNAL__CUSTOMER));
	}

	private Dairy getLocalDairy() {
		return dairyRepo.getLocalDairy();
	}

	private void addFilterParam(String string, Class<? extends IValueRidget> ridgetClass, String filterEquals, IValueProperty value) {
		EObject filterObj = null; 
		IValueRidget ridget = getRidget(ridgetClass, string);
		ridget.bindToModel(value.observe(filterObj));
	}

	private <X> void addFilterParam(
			String string, 
			Class<? extends IComboRidget> ridgetClass, 
			IObservableList selections, 
			Class<X> rowClass, 
			String renderMethod, 
			String filterEquals, 
			IEMFValueProperty value) {
		EObject filterObj = null; 
		IComboRidget ridget = getRidget(ridgetClass, string);
		ridget.bindToModel(selections, rowClass, renderMethod, value.observe(filterObj));
	}


	@Override
	protected List<DeliveryJournal> getFilteredResult() {
		List<DeliveryJournal> allJournals = dairyRepo.allDeliveries();
		List<DeliveryJournal> filteredList = new ArrayList<DeliveryJournal>();

		
		return new ArrayList<DeliveryJournal>();  // TODO: fix
//		return filteredList;
	}

	@Override
	protected RecordDialog<DeliveryJournal, ?> getRecordDialog(Shell shell) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void resetFilterConditions() {
		// TODO Auto-generated method stub
		
	}


}
