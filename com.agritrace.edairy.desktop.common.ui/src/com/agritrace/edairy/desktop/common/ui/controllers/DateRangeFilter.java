package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.Date;
import java.util.List;

public interface DateRangeFilter {

	/**
	 * Get a list of filter results for a given date range
	 *
	 * @param startDate
	 *            the startDate String in format of "MM/dd/yyyy"
	 * @param endDate
	 *            the endDate String in format of "MM/dd/yyyy"
	 * @return a list of filter results
	 */
//	public List<?> filter(String startDate, String endDate);

	public List<?> filter(Date startDate, Date endDate);

}
