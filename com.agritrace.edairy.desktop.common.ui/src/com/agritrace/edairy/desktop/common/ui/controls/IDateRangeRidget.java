package com.agritrace.edairy.desktop.common.ui.controls;

import java.util.Date;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.riena.ui.ridgets.IRidget;

public interface IDateRangeRidget extends IRidget {

	Date getStartDate();
	void setStartDate(Date start);
	
	Date getEndDate();
	void setEndDate(Date end);
	
	void bindToModel(IObservableValue startDate, IObservableValue endDate);

}
