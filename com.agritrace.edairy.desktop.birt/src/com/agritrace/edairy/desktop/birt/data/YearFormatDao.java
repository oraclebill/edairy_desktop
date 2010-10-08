package com.agritrace.edairy.desktop.birt.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class YearFormatDao {
	private static final int YEARS_AFTER = 20;
	private static final int YEARS_BEFORE = 10;

	public List<String> getReportValues(){
		final int year = Calendar.getInstance().get(Calendar.YEAR);
		final List<String> ret = new ArrayList<String>();
		for(int i = year-YEARS_BEFORE; i<year+YEARS_AFTER; i++){
			ret.add(Integer.toString(i));
		}

		return ret;
	}

}
