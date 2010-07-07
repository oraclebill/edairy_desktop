package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.Arrays;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.ui.ridgets.ITableRidget;

import com.agritrace.edairy.desktop.collection.ui.DeliveryJournalEditBindContants;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.Session;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class MilkDeliveryJournalEditController extends RecordDialogController<DeliveryJournal> {

	private final IDairyRepository dairyRepo = DairyRepository.getInstance();

	private ITableRidget lineItemsRidget;

	public MilkDeliveryJournalEditController() {
	}

	@Override
	public DeliveryJournal getWorkingCopy() {
		return (DeliveryJournal) getContext("editObject");
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
		addRidgetFeatureMap(DeliveryJournalEditBindContants.SESSION_COMBO, Arrays.asList(Session.values()),
				DairyPackage.Literals.DELIVERY_JOURNAL__SESSION);
		addRidgetFeatureMap(DeliveryJournalEditBindContants.ROUTE_COMBO, dairyRepo.allRoutes(),
				DairyPackage.Literals.DELIVERY_JOURNAL__ROUTE);
		addRidgetFeatureMap(DeliveryJournalEditBindContants.DRIVER_COMBO, dairyRepo.employeesByPosition("Driver"),
				DairyPackage.Literals.DELIVERY_JOURNAL__DRIVER);
		addRidgetFeatureMap(DeliveryJournalEditBindContants.VEHICLE_COMBO, dairyRepo.allVehicles(),
				DairyPackage.Literals.DELIVERY_JOURNAL__VEHICLE);
		addRidgetFeatureMap(DeliveryJournalEditBindContants.LINE_ITEM_TOTAL_TEXT,
				DairyPackage.Literals.DELIVERY_JOURNAL__TOTAL);
		// addRidgetFeatureMap(DeliveryJournalEditBindContants.LINE_ITEM_TABLE,
		// DairyPackage.Literals.DELIVERY_JOURNAL__LINES);

		lineItemsRidget = getRidget(ITableRidget.class, DeliveryJournalEditBindContants.LINE_ITEM_TABLE);
		lineItemsRidget.bindToModel(new WritableList(), DeliveryJournalLine.class, new String[] { "lineNumber", "bin",
				"quantity", "description" }, new String[] { "#", "Can ID", "Quantity", "Description" });
		lineItemsRidget.updateFromModel();
	}

}
