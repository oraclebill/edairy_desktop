package com.agritrace.edairy.desktop.birt.viewer;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.riena.ui.ridgets.IComboRidget;

public class MonthlyReportViewController extends ReportViewController {

	private static final String[] yearSelections = new String[20];
	static {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = 0; i < 20; i++) {
			yearSelections[i] = "" + (year - i);
		}
	}

	private static final String[] monthSelections = new String[] { //
	"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November",
			"December" };

	private IComboRidget month;
	private IComboRidget year;

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		// configure parameter ridgets

		//
		month = getRidget(IComboRidget.class, "report-parameter-month");
		month.bindToModel(
				new WritableList(Arrays.asList(monthSelections), String.class), 
				String.class, 
				null, 
				new WritableValue());
		month.setSelection(Calendar.getInstance().get(Calendar.MONTH));

		year = getRidget(IComboRidget.class, "report-parameter-year");
		year.bindToModel(
				new WritableList(Arrays.asList(yearSelections), String.class), 
				String.class, 
				null, 
				new WritableValue());
		year.setSelection(0);
	}

	protected Map<String, Object> getReportParameters() {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("month", month.getText());
		map.put("year", year.getText());

		return map;
	}

}
