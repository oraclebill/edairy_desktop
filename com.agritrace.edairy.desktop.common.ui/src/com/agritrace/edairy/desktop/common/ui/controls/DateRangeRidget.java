package com.agritrace.edairy.desktop.common.ui.controls;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.swt.widgets.Control;

import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;

public class DateRangeRidget extends AbstractCompositeRidget {

	public class ValueChangedListener implements PropertyChangeListener {
		String propertyName;

		public ValueChangedListener(String propertyName) {
			this.propertyName = propertyName;
		}

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			firePropertyChange(propertyName, evt.getOldValue(), evt.getNewValue());
		}
	}

	public static final String START_DATE = "start-date";
	public static final String END_DATE = "start-date";

	private IDateTimeRidget startDateText;
	private IDateTimeRidget endDateText;

	public DateRangeRidget() {
	}

	@Override
	protected void bindUIControl() {
		Control control = (Control) getUIControl();
		if (control != null) {
			updateFromModel();
		}
	}

	@Override
	public void configureRidgets() {
		startDateText = getRidget(IDateTimeRidget.class, DateRangeControl.START_DATE_ID);
		endDateText = getRidget(IDateTimeRidget.class, DateRangeControl.END_DATE_ID);

		startDateText.setDate(DateTimeUtils.getOneMonthBeforeCurrentDate());
		endDateText.setDate(DateTimeUtils.getCurrentDate());

		startDateText.addPropertyChangeListener(IDateTimeRidget.PROPERTY_DATE, new ValueChangedListener(START_DATE));
		endDateText.addPropertyChangeListener(IDateTimeRidget.PROPERTY_DATE, new ValueChangedListener(END_DATE));
	}
	
	public Date getStartDate() {
		if (startDateText != null) {
			return startDateText.getDate();
		}
		return null;
	}
	
	public void setStartDate(Date date) {
		if (startDateText != null) {
			startDateText.setDate(date);
		}
	}


	public Date getEndDate() {
		if (endDateText != null) {
			return endDateText.getDate();
		}
		return null;
	}
	
	public void setEndDate(Date date) {
		if (endDateText != null) {
			endDateText.setDate(date);
		}
	}

	public void bindToModel(Date startDate, Date endDate) {
		startDateText.bindToModel(new WritableValue(startDate, Date.class));
		endDateText.bindToModel(new WritableValue(endDate, Date.class));
	}
	
	public void bindToModel(IObservableValue startDate, IObservableValue endDate) {
		startDateText.bindToModel(startDate);
		endDateText.bindToModel(endDate);
	}
	
	public void updateFromModel() {
		startDateText.updateFromModel();
		endDateText.updateFromModel();
	}
}
