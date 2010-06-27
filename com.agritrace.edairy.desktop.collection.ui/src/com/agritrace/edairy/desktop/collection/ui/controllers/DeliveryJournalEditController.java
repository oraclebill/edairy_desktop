package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.Arrays;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.collection.ui.DeliveryJournalEditBindContants;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.Session;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class DeliveryJournalEditController extends RecordDialogController<DeliveryJournal> {

	private IDairyRepository dairyRepo = new DairyRepository();
	
	private IDateTimeRidget dateRidget;
	private IComboRidget sessionRidget;
	private IComboRidget routeRidget;
	private IComboRidget customerRidget;
	private IComboRidget driverRidget;
	private IComboRidget vehicleRidget;
	private ITableRidget lineItemsRidget;
	private ITextRidget journalTotalRidget;
	
	public DeliveryJournalEditController() {
		addRidgetFeatureMap(DeliveryJournalEditBindContants.REFERENCE_NUM, DairyPackage.Literals.DELIVERY_JOURNAL__REFERENCE_NUMBER);
		addRidgetFeatureMap(DeliveryJournalEditBindContants.DATE_COMBO, DairyPackage.Literals.DELIVERY_JOURNAL__DATE);
		addRidgetFeatureMap(
				DeliveryJournalEditBindContants.SESSION_COMBO,
				Arrays.asList(Session.values()),
				DairyPackage.Literals.DELIVERY_JOURNAL__SESSION);
		addRidgetFeatureMap(
				DeliveryJournalEditBindContants.ROUTE_COMBO,
				dairyRepo.allRoutes(),
				DairyPackage.Literals.DELIVERY_JOURNAL__ROUTE);
		addRidgetFeatureMap(
				DeliveryJournalEditBindContants.DRIVER_COMBO,
				dairyRepo.employeesByPosition("Driver"),
				DairyPackage.Literals.DELIVERY_JOURNAL__DRIVER);
		addRidgetFeatureMap(
				DeliveryJournalEditBindContants.VEHICLE_COMBO, 
				dairyRepo.allVehicles(),
				DairyPackage.Literals.DELIVERY_JOURNAL__VEHICLE);
		addRidgetFeatureMap(
				DeliveryJournalEditBindContants.LINE_ITEM_TOTAL_TEXT,
				DairyPackage.Literals.DELIVERY_JOURNAL__TOTAL);
		//addRidgetFeatureMap(DeliveryJournalEditBindContants.LINE_ITEM_TABLE, DairyPackage.Literals.DELIVERY_JOURNAL__LINES);
	}
	
	@Override
	protected void configureUserRidgets() {
//		dateRidget = getRidget(IDateTimeRidget.class, DeliveryJournalEditBindContants.DATE_COMBO);
//		dateRidget.setMandatory(true);
//		
//		sessionRidget = getRidget(IComboRidget.class, DeliveryJournalEditBindContants.SESSION_COMBO);
//		sessionRidget.setMandatory(true);
//		
//		routeRidget = getRidget(IComboRidget.class, DeliveryJournalEditBindContants.ROUTE_COMBO);
//		routeRidget.setMandatory(true);
//		
//		customerRidget = getRidget(IComboRidget.class, DeliveryJournalEditBindContants.CUSTOMER_COMBO);
//		customerRidget.setMandatory(true);
//		
//		driverRidget = getRidget(IComboRidget.class, DeliveryJournalEditBindContants.DRIVER_COMBO);
//		driverRidget.setMandatory(true);
//		
//		vehicleRidget = getRidget(IComboRidget.class, DeliveryJournalEditBindContants.VEHICLE_COMBO);
//		vehicleRidget.setMandatory(true);
//		
//		journalTotalRidget = getRidget(ITextRidget.class, DeliveryJournalEditBindContants.LINE_ITEM_TOTAL_TEXT);
//		journalTotalRidget.setOutputOnly(true);
//		
		lineItemsRidget = getRidget(ITableRidget.class, DeliveryJournalEditBindContants.LINE_ITEM_TABLE);
		lineItemsRidget.bindToModel(
				new WritableList(), 
				DeliveryJournalLine.class, 
				new String[] { "lineNumber", "bin", "quantity", "description" }, 
				new String[] { "#", "Can ID", "Quantity", "Description" });
		lineItemsRidget.updateFromModel();		
	}

	
	@Override
	protected EClass getEClass() {
		return DairyPackage.Literals.DELIVERY_JOURNAL;
	}

	@Override
	public DeliveryJournal getWorkingCopy() {
		return (DeliveryJournal) getContext("editObject");
	}


}
