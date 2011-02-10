package com.agritrace.edairy.desktop.birt.viewer;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.riena.ui.ridgets.IDateTextRidget;

public class DailyReportViewController extends ReportViewController {

	IDateTextRidget date;
	
	@Override
	public void configureRidgets() {
		super.configureRidgets();

		// configure parameter ridgets
		
		// 
		date = getRidget(IDateTextRidget.class, "report-parameter-date");
	}
	
	protected Map<String, Object> getReportParameters() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("date", date.getText());
		
		return map;
	}

}
