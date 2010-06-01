package com.agritrace.edairy.desktop.common.ui.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.riena.beans.common.AbstractBean;

import com.agritrace.edairy.desktop.common.ui.Activator;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;

public class SimpleFormattedDateBean extends AbstractBean {

	private Date date;

	private String formattedDate;

	private SimpleDateFormat dateFormat;

	public static String FORMATTED_DATE_VALUE_PROP = "formattedDate";

	public static String DATE_PROR = "date";

	private static final String STD_DATE_FORMAT = DateTimeUtils.DEFAULT_DATE_PATTERN;

	public SimpleFormattedDateBean() {
		this(null);
	}

	public SimpleFormattedDateBean(String dateValue) {
		dateFormat = new SimpleDateFormat(STD_DATE_FORMAT);
		setFormattedDate(dateValue);

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
		if (null != date)
			formattedDate = dateFormat.format(date);
	}

	public String getFormattedDate() {
		return formattedDate;
	}

	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
		if (dateFormat == null) {
			dateFormat = new SimpleDateFormat(STD_DATE_FORMAT);
		}
		try {
			if ((formattedDate == null) || formattedDate.trim().equals("")) {
				this.formattedDate = dateFormat.format(new Date());
			} else {
				date = dateFormat.parse(formattedDate);
			}
		} catch (final ParseException e) {
			final Status error = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
			Activator.getDefault().getLog().log(error);
		}
	}

}
