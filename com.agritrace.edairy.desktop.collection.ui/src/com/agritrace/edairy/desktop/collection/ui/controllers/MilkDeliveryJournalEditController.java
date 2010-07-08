package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.Arrays;
import java.util.Date;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ICompositeTableRidget;

import com.agritrace.edairy.desktop.collection.ui.DeliveryJournalEditBindContants;
import com.agritrace.edairy.desktop.collection.ui.components.DeliveryJournalEditPanel;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.Session;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class MilkDeliveryJournalEditController extends RecordDialogController<DeliveryJournal> {

	private final IDairyRepository dairyRepo = DairyRepository.getInstance();

	private ICompositeTableRidget lineItemsRidget;

	public MilkDeliveryJournalEditController() {
	}

	@Override
	public DeliveryJournal getWorkingCopy() {
		DeliveryJournal working = (DeliveryJournal) super.getWorkingCopy();
		if (working.getDate() == null) working.setDate(new Date());
		return working;
	}

	//
	// @Override
	// protected EClass getEClass() {
	// return DairyPackage.Literals.DELIVERY_JOURNAL;
	// }

	@Override
	protected void configureUserRidgets() {
		addRidgetFeatureMap(DeliveryJournalEditBindContants.REFERENCE_NUM,
				DairyPackage.Literals.DELIVERY_JOURNAL__REFERENCE_NUMBER);
		
		addRidgetFeatureMap(DeliveryJournalEditBindContants.DATE_COMBO, DairyPackage.Literals.DELIVERY_JOURNAL__DATE);
		
		addRidgetFeatureMap(
				DeliveryJournalEditBindContants.SESSION_COMBO, 
				Arrays.asList(Session.values()),
				DairyPackage.Literals.DELIVERY_JOURNAL__SESSION);
		
		addRidgetFeatureMap(DeliveryJournalEditBindContants.ROUTE_COMBO, dairyRepo.allRoutes(),
				DairyPackage.Literals.DELIVERY_JOURNAL__ROUTE);

		addRidgetFeatureMap(DeliveryJournalEditBindContants.CUSTOMER_COMBO, dairyRepo.allCustomers(),
				DairyPackage.Literals.DELIVERY_JOURNAL__CUSTOMER);
		
		addRidgetFeatureMap(DeliveryJournalEditBindContants.DRIVER_COMBO, dairyRepo.employeesByPosition("Driver"),
				DairyPackage.Literals.DELIVERY_JOURNAL__DRIVER);
		
		addRidgetFeatureMap(DeliveryJournalEditBindContants.VEHICLE_COMBO, dairyRepo.allVehicles(),
				DairyPackage.Literals.DELIVERY_JOURNAL__VEHICLE);
		
		addRidgetFeatureMap(DeliveryJournalEditBindContants.LINE_ITEM_TOTAL_TEXT,
				DairyPackage.Literals.DELIVERY_JOURNAL__TOTAL);
		// addRidgetFeatureMap(DeliveryJournalEditBindContants.LINE_ITEM_TABLE,
		// DairyPackage.Literals.DELIVERY_JOURNAL__LINES);

		lineItemsRidget = getRidget(ICompositeTableRidget.class, DeliveryJournalEditBindContants.LINE_ITEM_TABLE);
		lineItemsRidget.bindToModel(
				EMFObservables.observeList(getWorkingCopy(), DairyPackage.Literals.DELIVERY_JOURNAL__LINES), 
				DeliveryJournalLine.class, DeliveryJournalEditPanel.RowRidget.class);
		lineItemsRidget.updateFromModel();
	}
	
	
}
