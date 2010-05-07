package com.agritrace.edairy.service.ui.views.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Utilities class for Service
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceUtils {

	public static DateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

	/**
	 * Gets the first day of a month
	 * 
	 * @param date
	 *            One day in a month
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	/**
	 * Gets the last day of a month
	 * 
	 * @param date
	 *            One day in a month
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int lastDate = calendar.getActualMaximum(Calendar.DATE);
		calendar.set(Calendar.DATE, lastDate);
		return calendar.getTime();

	}
}
