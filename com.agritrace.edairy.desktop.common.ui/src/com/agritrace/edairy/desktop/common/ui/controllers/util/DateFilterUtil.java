package com.agritrace.edairy.desktop.common.ui.controllers.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EStructuralFeature;

public class DateFilterUtil<T extends Object> {

	private final FeaturePath dateFeature;

	public DateFilterUtil(Class<T> eObjClass, EStructuralFeature... dateFeature) {
		EStructuralFeature tail = dateFeature[dateFeature.length - 1];
		this.dateFeature = FeaturePath.fromList(dateFeature);
		if (!Date.class.isAssignableFrom(tail.getEType().getInstanceClass())) {
			throw new IllegalArgumentException("feature type "
					+ tail.getEType().getInstanceClass()
					+ " not a Date subclass");
		}
	}

	public List<T> filterDate(List<T> inputRecords, Date startDate, Date endDate) {
		final List<T> objs = new ArrayList<T>();
		if ((inputRecords == null) || inputRecords.isEmpty()) {
			return objs;
		}
		Calendar start = startDate == null ? null : new GregorianCalendar();
		if (start != null) {
			start.setTime(startDate);
		}
		Calendar startC = startDate == null ? null : Calendar.getInstance();
		if (startC != null) {
			startC.set(start.get(Calendar.YEAR), start.get(Calendar.MONTH),
					start.get(Calendar.DAY_OF_MONTH));
		}

		Calendar end = endDate == null ? null : new GregorianCalendar();
		if (endDate != null) {
			end.setTime(endDate);
		}
		Calendar endC = endDate == null ? null : Calendar.getInstance();
		if (endC != null) {
			endC.set(end.get(Calendar.YEAR), end.get(Calendar.MONTH), end
					.get(Calendar.DAY_OF_MONTH));
		}

		for (T line : inputRecords) {
			final Date testDate = (Date) EMFProperties.value(dateFeature)
					.getValue(line);
			Calendar test = new GregorianCalendar();
			test.setTime(testDate);
			Calendar testC = Calendar.getInstance();
			testC.set(test.get(Calendar.YEAR), test.get(Calendar.MONTH), test
					.get(Calendar.DAY_OF_MONTH));
			if ((startDate == null || (!startC.after(testC)))
					&& (endDate == null || (!endC.before(testC)))) {
				objs.add(line);
			}
		}
		return objs;
	}

}
