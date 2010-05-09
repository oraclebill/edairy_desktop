package com.agritrace.edairy.service.ui.views.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Utilities class for Service
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceUtils {

	public static DateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

	/**
	 * Gets the first day of month of specific date
	 * 
	 * @param date
	 *            Specific date
	 * @return First Day String
	 */
	public static String getFirstDayofMonth(Date date) {
		Date firstDate = getFirstDayOfMonth(date);
		return DATE_FORMAT.format(firstDate);
	}

	/**
	 * Gets the first day of month of current time
	 * 
	 * @return
	 */
	public static String getFirstDayofMonth() {
		return getFirstDayofMonth(Calendar.getInstance().getTime());
	}

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

	/**
	 * Gets the first day of month of specific date
	 * 
	 * @param date
	 *            Specific date
	 * @return First Day String
	 */
	public static String getLastDayofMonth(Date date) {
		Date firstDate = getLastDayOfMonth(date);
		return DATE_FORMAT.format(firstDate);
	}

	/**
	 * Gets the first day of month of current time
	 * 
	 * @return
	 */
	public static String getLastDayofMonth() {
		return getLastDayofMonth(Calendar.getInstance().getTime());
	}
	
	/**
	 * Dispose composite's children recursively
	 * 
	 * @param comp
	 */
	public static void disposeAllChildrens(Composite comp) {
		if (comp == null) {
			return;
		}
		for (Control control : comp.getChildren()) {
			if (control instanceof Composite) {
				disposeAllChildrens((Composite) control);

			}
			if (!control.isDisposed()) {
				control.dispose();
			}
		}
	}
}
