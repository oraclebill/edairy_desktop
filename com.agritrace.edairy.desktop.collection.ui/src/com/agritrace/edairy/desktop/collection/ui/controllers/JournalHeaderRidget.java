package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.swt.widgets.Control;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Session;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;

/**
	 * 
	 */
public class JournalHeaderRidget extends AbstractCompositeRidget {

	//
	// reference data lists
	//
	private List<Route> routes = Collections.EMPTY_LIST;
	private List<Vehicle> vehicles = Collections.EMPTY_LIST;
	private List<Employee> drivers = Collections.EMPTY_LIST;

	//
	// ridgets
	//
	private IDateTimeRidget dateRidget;
	private IComboRidget routeRidget;
	private IComboRidget sessionRidget;
	private IComboRidget vehicleRidget;
	private IComboRidget driverRidget;
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

		// journal book group
		dateRidget = getRidget(IDateTimeRidget.class, ViewWidgetId.calendarDate);
		// dateRidget.setFormat(DateTimeUtils.DEFAULT_DATE_PATTERN);
		dateRidget.setMandatory(true);

		routeRidget = getRidget(IComboRidget.class, ViewWidgetId.routeCombo);
		routeRidget.setMandatory(true);

		sessionRidget = getRidget(IComboRidget.class, ViewWidgetId.sessionCombo);
		sessionRidget.setMandatory(true);

		vehicleRidget = getRidget(IComboRidget.class, ViewWidgetId.vehicleCombo);
		vehicleRidget.setMandatory(true);

		driverRidget = getRidget(IComboRidget.class, ViewWidgetId.driverCombo);
		driverRidget.setMandatory(true);

		// final GroupOneSelectionListener selectionListener = new
		// GroupOneSelectionListener();
		// routeRidget.addSelectionListener(selectionListener);
		// sessionRidget.addSelectionListener(selectionListener);
		// vehicleRidget.addSelectionListener(selectionListener);
		// driverRidget.addSelectionListener(selectionListener);

//		// make'em all read/only
//		for (final IMarkableRidget ridget : Arrays.asList(new IMarkableRidget[] { dateRidget, routeRidget,
//				sessionRidget, vehicleRidget, driverRidget })) {
//			ridget.setOutputOnly(true);
//		}
//		dateRidget.setEnabled(false);

		// journal group
		journalNumber = getRidget(ITextRidget.class, ViewWidgetId.journalText);
		journalNumber.setMandatory(true);
//			journalNumber.addValidationRule(new StringNumberValidator(), ValidationTime.ON_UPDATE_TO_MODEL);

		driverTotalText = getRidget(IDecimalTextRidget.class, ViewWidgetId.journalTotalText);
		driverTotalText.setSigned(false);
		driverTotalText.setGrouping(true);
		driverTotalText.setMandatory(true);
	}

	@Override
	public void updateFromModel() {
		//
//			if ((workingJournalPage.getReferenceNumber() != null) && (workingJournalPage.getDriverTotal() != null)) {
//				journalNumber.setOutputOnly(true);
//				driverTotalText.setOutputOnly(true);
//			}

		super.updateFromModel();
	}

	public void bindToModel(CollectionJournalPage newModel) {
		model = new WritableValue(newModel, CollectionJournalPage.class);

		dateRidget.bindToModel(PojoObservables.observeDetailValue(model, "journalDate", Date.class));

		routeRidget.bindToModel(new WritableList(routes, Route.class), Route.class, "getName",
				PojoObservables.observeDetailValue(model, "route", Route.class));

		sessionRidget.bindToModel(Observables.staticObservableList(Session.VALUES), Session.class, "getLiteral",
				PojoObservables.observeDetailValue(model, "session", Session.class));

		vehicleRidget.bindToModel(new WritableList(vehicles, Vehicle.class), Vehicle.class, "getRegistrationNumber",
				PojoObservables.observeDetailValue(model, "vehicle", Vehicle.class));

		driverRidget.bindToModel(new WritableList(drivers, Employee.class), Employee.class, "getFamilyName",
				PojoObservables.observeDetailValue(model, "driver", Employee.class));

		//
		journalNumber.bindToModel(PojoObservables.observeDetailValue(model, "referenceNumber", String.class));

		driverTotalText.bindToModel(PojoObservables.observeDetailValue(model, "driverTotal", BigDecimal.class));

	}

	@Override 
	protected void updateVisible() {
		Object controlObj = getUIControl();
		if ( controlObj instanceof Control) {
			Control control = (Control)controlObj;
			control.setVisible(isVisible());
		}
	}
	
	@Override
	protected void updateEnabled() {
		boolean enabled = isEnabled();
		Collection<? extends IRidget> myRidgets = getRidgets();
		for (IRidget ridget : myRidgets) {
			ridget.setEnabled(enabled);
		}
	}

	public void setOutputOnly(boolean outputOnly) {
		Collection<? extends IRidget> myRidgets = getRidgets();
		for (IRidget ridget : myRidgets) {
			if (ridget instanceof IMarkableRidget) {
				IMarkableRidget markable = (IMarkableRidget) ridget;
				markable.setOutputOnly(outputOnly);
			}
			if (ridget instanceof IDateTimeRidget) {
				IDateTimeRidget dateTime = (IDateTimeRidget) ridget;
				dateTime.setEnabled(!outputOnly);
			}
		}
	}

}