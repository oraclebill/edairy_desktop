package com.agritrace.edairy.service.ui.converters;

import java.text.DateFormat;
import java.util.Date;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.agritrace.edairy.service.ui.views.utils.ServiceUtils;

/**
 * Date to String model convertor
 * 
 * @author Hui(Spark) Wan
 *
 */
public class DateToStringModelConvertor extends EMFModel2UIConverter {

	private DateFormat format;

	public DateToStringModelConvertor(EObject eObject,
			EStructuralFeature fromTypeFeature, DateFormat format) {
		super(eObject, fromTypeFeature, String.class);
		this.format = format;

	}

	public DateToStringModelConvertor(EObject eObject,
			EStructuralFeature fromTypeFeature) {
		this(eObject, fromTypeFeature,  ServiceUtils.DATE_FORMAT);

	}
	
	

	@Override
	public Object convert(Object fromObject) {
		Object filteredObject = this.filter(fromObject);
		if (filteredObject instanceof Date) {
			Date date = (Date) filteredObject;
			return format.format(date).toString();

		}
		return null;
	}

}
