package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.collection.ui.beans.DeliveryJournalFilterBean;
import com.agritrace.edairy.desktop.collection.ui.dialogs.DeliveryJournalEditDialog;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class MilkDeliveryJournalController extends BasicDirectoryController<DeliveryJournal> {

	private IComboRidget customerRidget;
	private final IDairyRepository dairyRepo = DairyRepository.getInstance();

	private IDateTimeRidget endDateRidget;
	private DeliveryJournalFilterBean filterBean = null;
	private IComboRidget routeRidget;
	private IDateTimeRidget startDateRidget;

	private static abstract class DJColumnFormatter extends ColumnFormatter {
		@Override public final String getText(Object element) {
			if (element instanceof DeliveryJournal) {
				DeliveryJournal jrnlLine = (DeliveryJournal)element;
				return getFormattedText(jrnlLine);
			}
			return super.getText(element);
		}
		protected abstract String getFormattedText(DeliveryJournal line);
	}

	public MilkDeliveryJournalController() {
		setEClass(DairyPackage.Literals.DELIVERY_JOURNAL);
		// setEntityClass(DeliveryJournal.class);

		addTableColumn("Date", DairyPackage.Literals.DELIVERY_JOURNAL__DATE);
		addTableColumn("Route", DairyPackage.Literals.DELIVERY_JOURNAL__ROUTE, new DJColumnFormatter() {
			@Override public String getFormattedText(DeliveryJournal element) {
				return element.getRoute().getName();
			}
		});
		addTableColumn("Session", DairyPackage.Literals.DELIVERY_JOURNAL__SESSION);
		addTableColumn("Customer", DairyPackage.Literals.DELIVERY_JOURNAL__CUSTOMER, new DJColumnFormatter() {
			@Override public String getFormattedText(DeliveryJournal element) {
				return element.getCustomer().getCompanyName();
			}
		});
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
		customerRidget.bindToModel(customerList, Customer.class, "getCompanyName",
				BeansObservables.observeValue(filterBean, "customer"));

		startDateRidget.updateFromModel();
		endDateRidget.updateFromModel();
		routeRidget.updateFromModel();
		customerRidget.updateFromModel();

	}

	@Override
	protected void resetFilterConditions() {
		filterBean.setCustomer(null);
		filterBean.setMaxDate(null);
		filterBean.setMinDate(null);
		filterBean.setRoute(null);
		
		updateAllRidgetsFromModel();
	}


	@Override
	protected List<DeliveryJournal> getFilteredResult() {
		return dairyRepo.getDeliveryJournals(
				filterBean.getMinDate(), 
				filterBean.getMaxDate(), 
				filterBean.getRoute(), 
				filterBean.getCustomer());
	}

	@Override
	protected RecordDialog<DeliveryJournal, ?> getRecordDialog(Shell shell) {
		return new DeliveryJournalEditDialog(shell);
	}

	@Override
	protected void createEntity(DeliveryJournal newEntity) {
		// TODO: save as a batch - currently this will result in 'n + 1' transactions, where n is number of lines
		// FIXME:      also, if error on one line, entire journal should be rolled back..
		dairyRepo.getLocalDairy().getDeliveryJournals().add(newEntity);
		dairyRepo.save(dairyRepo.getLocalDairy());		 // depend on the cascade
//		for (DeliveryJournalLine line : newEntity.getLines()) {
//			dairyRepo.save(line);
//		}
//		dairyRepo.save(newEntity);
	}

}