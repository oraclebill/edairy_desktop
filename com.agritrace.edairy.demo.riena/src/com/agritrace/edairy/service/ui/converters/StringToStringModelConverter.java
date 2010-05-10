package com.agritrace.edairy.service.ui.converters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * String to String model converter
 * 
 * @author Hui(Spark) Wan
 *
 */
public class StringToStringModelConverter extends EMFModel2UIConverter {

	public StringToStringModelConverter(EObject eObject,
			EStructuralFeature fromTypeFeature) {
		super(eObject, fromTypeFeature, String.class);
	}

	@Override
	public Object convert(Object fromObject) {
		Object filteredObject = this.filter(fromObject);
		if (filteredObject instanceof String) {
			return fromObject;

		}
		return null;
	}

}
