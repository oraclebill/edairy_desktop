package com.agritrace.edairy.desktop.milkops.ui.intake.journalheader;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.databinding.DateToStringConverter;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.internal.milkops.ui.Activator;
import com.agritrace.edairy.desktop.milkops.ui.intake.ViewWidgetId;

/**
	 *
	 */
public class JournalHeaderRidget extends AbstractCompositeRidget implements IJournalHeaderRidget {

	public class JournalHeaderValidationListener implements PropertyChangeListener {
		private transient Boolean lastValue = null;

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			final Boolean oldValue = lastValue;
			lastValue = isHeaderValid();
			firePropertyChange(HEADER_VALID, oldValue, lastValue);
			log(LogService.LOG_DEBUG, String.format( "propertyChange: %s - %s", oldValue, lastValue) );
		}
	}

	//
	// top panel ridgets
	//
	private ITextRidget dateRidget;
	private ITextRidget centerRidget;
	private ITextRidget sessionRidget;
	private ITextRidget vehicleRidget;
	private ITextRidget driverRidget;
	private ITextRidget statusRidget;

	//
	// bottom panel ridgets
	//
	private ITextRidget referenceNumber;
	private ITextRidget journalNumber;
	private IDecimalTextRidget driverTotalText;

	//
	// model object (CollectionJournal)
	//
//	private IObservableValue model;
	private boolean driverTotalEditable = false;
	private final PropertyChangeListener validationListener;

	public JournalHeaderRidget() {
		validationListener = new JournalHeaderValidationListener();
	}

	/**
	 *
	 */
	private void log(int level, String message) {
		Log4r.getLogger(Activator.getDefault(), getClass()).log(level, message);
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
		if (referenceNumber != null && referenceNumber.isDisableMandatoryMarker() && driverTotalText != null
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

		centerRidget = getRidget(ITextRidget.class, ViewWidgetId.collectionCenterCombo);
		centerRidget.setOutputOnly(true);
		centerRidget.setFocusable(false);

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
		referenceNumber = getRidget(ITextRidget.class, ViewWidgetId.journalText);
		referenceNumber.setMandatory(true);
		referenceNumber.addPropertyChangeListener("text", validationListener);

		journalNumber = getRidget(ITextRidget.class, ViewWidgetId.journalNumberText);
		journalNumber.setMandatory(true);
		journalNumber.addPropertyChangeListener("text", validationListener);

		driverTotalText = getRidget(IDecimalTextRidget.class, ViewWidgetId.journalTotalText);
		driverTotalText.setSigned(false);
		driverTotalText.setGrouping(true);
		driverTotalText.setMandatory(true);

		driverTotalText.addPropertyChangeListener("text", validationListener);

		statusRidget = getRidget(ITextRidget.class, ViewWidgetId.journalStatus);
		statusRidget.setOutputOnly(true);
		statusRidget.setFocusable(false);
	}

	@Override
	public void requestFocus() {
		super.requestFocus();
		referenceNumber.requestFocus();
	}


	@Override
	protected void updateEnabled() {
		super.updateEnabled();
		statusRidget.setOutputOnly(true);
		final boolean enabled = isEnabled();
		driverTotalText.setOutputOnly(!enabled && !driverTotalEditable);
		referenceNumber.setOutputOnly(!enabled);
	}

	@Override
	public void forceDriverTotalEditable() {
		driverTotalEditable = true;
		updateEnabled();
	}

	@Override
	public void bindToModel(CollectionGroup newModel) {
		dateRidget.bindToModel(newModel, "collectionDate");
		centerRidget.bindToModel(newModel, "collectionCenter.code");
		sessionRidget.bindToModel(newModel, "session.code");
		vehicleRidget.bindToModel(newModel, "vehicle.registrationNumber");
		driverRidget.bindToModel(newModel, "driver.familyName");
		referenceNumber.bindToModel(newModel, "referenceNumber");
		journalNumber.bindToModel(newModel, "journalNumber");
		driverTotalText.bindToModel(newModel, "driverTotal");
		statusRidget.bindToModel(newModel, "status");
		statusRidget.setOutputOnly(true);
	}
}