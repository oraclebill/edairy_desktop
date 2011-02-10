package com.agritrace.edairy.desktop.birt.viewer;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.riena.ui.ridgets.IDateTimeRidget;

public class DailyReportViewController extends ReportViewController {

	IDateTimeRidget date;
	
	@Override
	public void configureRidgets() {
		super.configureRidgets();

		// configure parameter ridgets
		
		// 
		date = getRidget(IDateTimeRidget.class, "report-parameter-date");
		date.setDate(Calendar.getInstance().getTime());
	}
	
	protected Map<String, Object> getReportParameters() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("date", date.getText());
		map.put("fromDate", date.getText());
		
		return map;
	}

}
