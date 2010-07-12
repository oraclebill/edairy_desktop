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
import com.agritrace.edairy.desktop.collection.ui.views.JournalHeaderComposite;
import com.agritrace.edairy.desktop.collection.ui.views.JournalHeaderComposite.ControlType;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Session;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.collection.ui.views.JournalHeaderComposite.ControlType;

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
	private IMarkableRidget routeRidget;
	private IMarkableRidget sessionRidget;
	private IMarkableRidget vehicleRidget;
	private IMarkableRidget driverRidget;
	private ITextRidget journalNumber;
	private IDecimalTextRidget driverTotalText;

	private ControlType controlType;

	//
	// model object (CollectionJournal)
	//
	private IObservableValue model;

	public JournalHeaderRidget() {

	}
	
	public void setControlType(ControlType controlType) {
		this.controlType = controlType;
	}
	
	public ControlType getControlType() {
		return this.controlType;
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

		try {
			routeRidget = getRidget(IComboRidget.class, ViewWidgetId.routeCombo);
			if (routeRidget != null) 
				controlType = ControlType.COMBO;
			else
				controlType = ControlType.TEXT;
		}
		catch(Exception e) {
			controlType = ControlType.TEXT;
		}
		
		switch (controlType) {
		case COMBO:
			configureComboRidgets();
			break;
		case TEXT:
			configureTextRidgets();
			break;
		}
		
		// final GroupOneSelectionListener selectionListener = new
		// GroupOneSelectionListener();
		// routeRidget.addSelectionListener(selectionListener);
		// sessionRidget.addSelectionListener(selectionListener);
		// vehicleRidget.addSelectionListener(selectionListener);
		// driverRidget.addSelectionListener(selectionListener);

		// // make'em all read/only
		// for (final IMarkableRidget ridget : Arrays.asList(new
		// IMarkableRidget[] { dateRidget, routeRidget,
		// sessionRidget, vehicleRidget, driverRidget })) {
		// ridget.setOutputOnly(true);
		// }
		// dateRidget.setEnabled(false);

		// journal group
		journalNumber = getRidget(ITextRidget.class, ViewWidgetId.journalText);
		journalNumber.setMandatory(true);
		// journalNumber.addValidationRule(new StringNumberValidator(),
		// ValidationTime.ON_UPDATE_TO_MODEL);

		driverTotalText = getRidget(IDecimalTextRidget.class, ViewWidgetId.journalTotalText);
		driverTotalText.setSigned(false);
		driverTotalText.setGrouping(true);
		driverTotalText.setMandatory(true);
	}

	private void configureComboRidgets() {
		routeRidget = getRidget(IComboRidget.class, ViewWidgetId.routeCombo);
		routeRidget.setMandatory(true);

		sessionRidget = getRidget(IComboRidget.class, ViewWidgetId.sessionCombo);
		sessionRidget.setMandatory(true);

		vehicleRidget = getRidget(IComboRidget.class, ViewWidgetId.vehicleCombo);
		vehicleRidget.setMandatory(true);

		driverRidget = getRidget(IComboRidget.class, ViewWidgetId.driverCombo);
		driverRidget.setMandatory(true);
	}

	private void configureTextRidgets() {
		routeRidget = getRidget(ITextRidget.class, ViewWidgetId.routeCombo);
		routeRidget.setMandatory(true);

		sessionRidget = getRidget(ITextRidget.class, ViewWidgetId.sessionCombo);
		sessionRidget.setMandatory(true);

		vehicleRidget = getRidget(ITextRidget.class, ViewWidgetId.vehicleCombo);
		vehicleRidget.setMandatory(true);

		driverRidget = getRidget(ITextRidget.class, ViewWidgetId.driverCombo);
		driverRidget.setMandatory(true);

	}

	@Override
	public void updateFromModel() {
		//
		// if ((workingJournalPage.getReferenceNumber() != null) &&
		// (workingJournalPage.getDriverTotal() != null)) {
		// journalNumber.setOutputOnly(true);
		// driverTotalText.setOutputOnly(true);
		// }

		super.updateFromModel();
	}

	public void bindToModel(CollectionJournalPage newModel) {
		model = new WritableValue(newModel, CollectionJournalPage.class);

		dateRidget.bindToModel(PojoObservables.observeDetailValue(model, "journalDate", Date.class));

		switch (controlType) {
		case COMBO:
			bindComboRidgets();
			break;
		case TEXT:
			bindTextRidgets();
			break;
		}

		//
		journalNumber.bindToModel(PojoObservables.observeDetailValue(model, "referenceNumber", String.class));

		driverTotalText.bindToModel(PojoObservables.observeDetailValue(model, "driverTotal", BigDecimal.class));

	}

	private void bindComboRidgets() {
		((IComboRidget) routeRidget).bindToModel(new WritableList(routes, Route.class), Route.class, "getName",
				PojoObservables.observeDetailValue(model, "route", Route.class));

		((IComboRidget) sessionRidget).bindToModel(Observables.staticObservableList(Session.VALUES), Session.class,
				"getLiteral", PojoObservables.observeDetailValue(model, "session", Session.class));

		((IComboRidget) vehicleRidget).bindToModel(new WritableList(vehicles, Vehicle.class), Vehicle.class,
				"getRegistrationNumber", PojoObservables.observeDetailValue(model, "vehicle", Vehicle.class));

		((IComboRidget) driverRidget).bindToModel(new WritableList(drivers, Employee.class), Employee.class,
				"getFamilyName", PojoObservables.observeDetailValue(model, "driver", Employee.class));
	}

	private void bindTextRidgets() {
		((ITextRidget) routeRidget).bindToModel(PojoObservables.observeDetailValue(model, "route", Route.class));

		((ITextRidget) sessionRidget).bindToModel(PojoObservables.observeDetailValue(model, "session", Session.class));

		((ITextRidget) vehicleRidget).bindToModel(PojoObservables.observeDetailValue(model, "vehicle", Vehicle.class));

		((ITextRidget) driverRidget).bindToModel(PojoObservables.observeDetailValue(model, "driver", Employee.class));
	}

	@Override
	protected void updateVisible() {
		Object controlObj = getUIControl();
		if (controlObj instanceof Control) {
			Control control = (Control) controlObj;
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
				markable.setMandatory(!outputOnly);
			}
			if (ridget instanceof IDateTimeRidget) {
				IDateTimeRidget dateTime = (IDateTimeRidget) ridget;
				dateTime.setEnabled(!outputOnly);
			}
		}
	}

}