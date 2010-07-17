package com.agritrace.edairy.desktop.collection.ui.components;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.databinding.DateToStringConverter;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;

/**
	 * 
	 */
public class JournalHeaderRidget extends AbstractCompositeRidget implements IJournalHeaderRidget {

	//
	// top panel ridgets
	//
	private ITextRidget dateRidget;
	private ITextRidget routeRidget;
	private ITextRidget sessionRidget;
	private ITextRidget vehicleRidget;
	private ITextRidget driverRidget;

	//
	// bottom panel ridgets
	//
	private ITextRidget journalNumber;
	private IDecimalTextRidget driverTotalText;

	//
	// model object (CollectionJournal)
	//
	private IObservableValue model;

	public JournalHeaderRidget() {

	}

	/**
	 * 
	 */
	@Override
	public void configureRidgets() {
		configureReadOnlyRidgets();
		configureVariableRidgets();
	}

	private void configureReadOnlyRidgets() {

		// journal book group
		dateRidget = getRidget(ITextRidget.class, ViewWidgetId.calendarDate);
		dateRidget.setModelToUIControlConverter(new DateToStringConverter(DateTimeUtils.DEFAULT_DATE_PATTERN));
		dateRidget.setOutputOnly(true);

		routeRidget = getRidget(ITextRidget.class, ViewWidgetId.routeCombo);
		routeRidget.setOutputOnly(true);

		sessionRidget = getRidget(ITextRidget.class, ViewWidgetId.sessionCombo);
		sessionRidget.setOutputOnly(true);

		vehicleRidget = getRidget(ITextRidget.class, ViewWidgetId.vehicleCombo);
		vehicleRidget.setOutputOnly(true);

		driverRidget = getRidget(ITextRidget.class, ViewWidgetId.driverCombo);
		driverRidget.setOutputOnly(true);
	}

	private void configureVariableRidgets() {
		journalNumber = getRidget(ITextRidget.class, ViewWidgetId.journalText);
		journalNumber.setMandatory(true);

		driverTotalText = getRidget(IDecimalTextRidget.class, ViewWidgetId.journalTotalText);
		driverTotalText.setSigned(false);
		driverTotalText.setGrouping(true);
		driverTotalText.setMandatory(true);
	}

	@Override
	public void bindToModel(CollectionJournalPage newModel) {

		dateRidget.bindToModel(newModel, "journalDate");

		routeRidget.bindToModel(newModel, "route.code");

		sessionRidget.bindToModel(newModel, "session");

		vehicleRidget.bindToModel(newModel, "vehicle.registrationNumber");

		driverRidget.bindToModel(newModel, "driver.familyName");
		
		journalNumber.bindToModel(newModel, "referenceNumber");

		driverTotalText.bindToModel(newModel, "driverTotal");

	}
}