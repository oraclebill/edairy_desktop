package com.agritrace.edairy.desktop.common.ui.columnformatters;

import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.riena.ui.ridgets.swt.DateColumnFormatter;

import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;

public class DirectoryDateColumnFormatter extends DateColumnFormatter {
	private String propName;
	
	public DirectoryDateColumnFormatter(String propertyName) {
		super(DateTimeUtils.DEFAULT_DATE_PATTERN);
		propName = propertyName;
	}
	
	@Override
	protected java.util.Date getDate(Object element) {
		Date date = null;
		try {
			date = (Date) PropertyUtils.getProperty(element, propName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}