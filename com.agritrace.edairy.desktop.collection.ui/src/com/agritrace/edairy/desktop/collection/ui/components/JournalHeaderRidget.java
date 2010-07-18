package com.agritrace.edairy.desktop.collection.ui.components;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.databinding.DateToStringConverter;
import org.eclipse.riena.ui.ridgets.listener.FocusEvent;
import org.eclipse.riena.ui.ridgets.listener.IFocusListener;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;

/**
	 * 
	 */
public class JournalHeaderRidget extends AbstractCompositeRidget implements IJournalHeaderRidget {

	public class JournalHeaderValidationListener implements PropertyChangeListener {
		private transient Boolean lastValue = null;

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			Boolean oldValue = lastValue;
			lastValue = isHeaderValid();
			firePropertyChange("header-valid", oldValue, lastValue);
		}
	}

	//
	// top panel ridgets
	//
	private ITextRidget dateRidget;
	private ITextRidget routeRidget;
	private ITextRidget sessionRidget;
	private ITextRidget vehicleRidget;
	private ITextRidget driverRidget;
	private ITextRidget statusRidget;

	//
	// bottom panel ridgets
	//
	private ITextRidget journalNumber;
	private IDecimalTextRidget driverTotalText;

	//
	// model object (CollectionJournal)
	//
//	private IObservableValue model;
	private PropertyChangeListener validationListener;

	public JournalHeaderRidget() {
		validationListener = new JournalHeaderValidationListener();
	}

	/**
	 * 
	 */
	@Override
	public void configureRidgets() {
		configureReadOnlyRidgets();
		configureVariableRidgets();
	}

	@Override
	public boolean isHeaderValid() {
		if (journalNumber != null && journalNumber.isDisableMandatoryMarker() && driverTotalText != null
				&& driverTotalText.isDisableMandatoryMarker()) {
			return true;
		}
		return false;
	}

	private void configureReadOnlyRidgets() {

		// journal book group
		dateRidget = getRidget(ITextRidget.class, ViewWidgetId.calendarDate);
		dateRidget.setModelToUIControlConverter(new DateToStringConverter(DateTimeUtils.DEFAULT_DATE_PATTERN));
		dateRidget.setOutputOnly(true);
		dateRidget.setFocusable(false);

		routeRidget = getRidget(ITextRidget.class, ViewWidgetId.routeCombo);
		routeRidget.setOutputOnly(true);
		routeRidget.setFocusable(false);

		sessionRidget = getRidget(ITextRidget.class, ViewWidgetId.sessionCombo);
		sessionRidget.setOutputOnly(true);
		sessionRidget.setFocusable(false);

		vehicleRidget = getRidget(ITextRidget.class, ViewWidgetId.vehicleCombo);
		vehicleRidget.setOutputOnly(true);
		vehicleRidget.setFocusable(false);

		driverRidget = getRidget(ITextRidget.class, ViewWidgetId.driverCombo);
		driverRidget.setOutputOnly(true);
		driverRidget.setFocusable(false);

	}

	private void configureVariableRidgets() {
		journalNumber = getRidget(ITextRidget.class, ViewWidgetId.journalText);
		journalNumber.setMandatory(true);
		journalNumber.addPropertyChangeListener("text", validationListener);

		driverTotalText = getRidget(IDecimalTextRidget.class, ViewWidgetId.journalTotalText);
		driverTotalText.setSigned(false);
		driverTotalText.setGrouping(true);
		driverTotalText.setMandatory(true);

		driverTotalText.addPropertyChangeListener("text", validationListener);
		
		statusRidget = getRidget(ITextRidget.class, ViewWidgetId.driverCombo);
		statusRidget.setOutputOnly(true);
		statusRidget.setFocusable(false);
	}

	@Override
	public void requestFocus() {
		super.requestFocus();
		journalNumber.requestFocus();
	}

	
	@Override
	protected void updateEnabled() {
		super.updateEnabled();
		statusRidget.setOutputOnly(true);
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
		
		statusRidget.bindToModel(newModel, "status");
		statusRidget.setOutputOnly(true);
	}
}