package com.agritrace.edairy.desktop.common.ui.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.riena.ui.ridgets.databinding.DateToStringConverter;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

//import com.agritrace.edairy.desktop.common.ui.converters.DateToStringConverter;

/**
 * Utilities class for Date Time
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class DateTimeUtils {

	/**
	 * Defaults date format pattern
	 */
	public static String DEFAULT_DATE_PATTERN = "dd/MM/yyyy";
	/**
	 * Default date format instance
	 */
	public static DateFormat DATE_FORMAT = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
	/**
	 * Date to String converter using default date pattern
	 */
	public static IConverter DEFAULT_DATE_STRING_CONVERTER = new DateToStringConverter(
			DateTimeUtils.DEFAULT_DATE_PATTERN);

	// private static class BindingManager extends DefaultBindingManager {
	// public BindingManager(IBindingPropertyLocator propertyStrategy,
	// IControlRidgetMapper<Object> mapper) {
	// super(propertyStrategy, mapper);
	//
	// }
	//
	// @Override
	// public void injectRidget(IRidgetContainer ridgetContainer, String
	// bindingProperty, IRidget ridget) {
	// super.injectRidget(ridgetContainer, bindingProperty, ridget);
	// }
	// }

	// private static final BindingManager BINDING_MAN = new
	// BindingManager(SWTBindingPropertyLocator.getInstance(),
	// SwtControlRidgetMapper.getInstance());

	/**
	 * Gets the first day of month of specific date
	 * 
	 * @param date
	 *            Specific date
	 * @return First Day String
	 */
	public static String getFirstDayofMonth(Date date) {
		final Date firstDate = getFirstDayOfMonth(date);
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
		final Calendar cal = Calendar.getInstance();
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

		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		final int lastDate = calendar.getActualMaximum(Calendar.DATE);
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
		final Date firstDate = getLastDayOfMonth(date);
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
	 * Get one month date before the current date
	 * 
	 * @return date one month ago, {@link Date}
	 */
	public static Date getOneMonthBeforeCurrentDate() {
		final Calendar now = Calendar.getInstance();
		now.add(Calendar.MONDAY, -1);
		return now.getTime();
	}

	/**
	 * Get the formatted String of the date one month before the current date.
	 * 
	 * @return the formatted String "MM/dd/yyyy"
	 */
	public static String getOneMonthBeforeCurrentDateString() {
		final Date date = getOneMonthBeforeCurrentDate();
		return DateTimeUtils.DATE_FORMAT.format(date);
	}

	/**
	 * Get the current date
	 * 
	 * @return date one month ago, {@link Date}
	 */
	public static Date getCurrentDate() {
		final Calendar now = Calendar.getInstance();
		return now.getTime();
	}

	/**
	 * Get the formatted String of the current date.
	 * 
	 * @return the formatted String "MM/dd/yyyy"
	 */
	public static String getCurrentDateString() {
		final Date date = getCurrentDate();
		return DateTimeUtils.DATE_FORMAT.format(date);
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
		for (final Control control : comp.getChildren()) {
			if (control instanceof Composite) {
				disposeAllChildrens((Composite) control);

			}
			if (!control.isDisposed()) {
				control.dispose();
			}
		}
	}
	
	/**
	 * Add one day to specific date
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNextDate(Date date)
	{
		final Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.DAY_OF_MONTH, 1);
		return now.getTime();
	}

}
