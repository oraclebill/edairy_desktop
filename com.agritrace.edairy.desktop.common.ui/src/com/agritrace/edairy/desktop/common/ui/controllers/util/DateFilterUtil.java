package com.agritrace.edairy.desktop.common.ui.controllers.util;

import java.util.ArrayList;
import java.util.Date;
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
			throw new IllegalArgumentException("feature type " + tail.getEType().getInstanceClass()
					+ " not a Date subclass");
		}
	}

	public List<T> filterDate(List<T> inputRecords, Date startDate, Date endDate) {
		final List<T> objs = new ArrayList<T>();
		if ((inputRecords == null) || inputRecords.isEmpty()) {
			return objs;
		}
		for (T line : inputRecords) {
			final Date testDate = (Date) EMFProperties.value(dateFeature).getValue(line);
			if ((startDate == null || startDate.before(testDate)) && (endDate == null || endDate.after(testDate))) {
				objs.add(line);
			}
		}
		return objs;
	}

}
