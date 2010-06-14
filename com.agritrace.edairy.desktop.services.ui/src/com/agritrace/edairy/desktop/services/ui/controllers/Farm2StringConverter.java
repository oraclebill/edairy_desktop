package com.agritrace.edairy.desktop.services.ui.controllers;

import org.eclipse.core.databinding.conversion.IConverter;

import com.agritrace.edairy.desktop.common.model.tracking.Farm;

/**
 * Converter which convert Farm to String value
 * 
 * @author Hui(Spark) Wan
 *
 */
public class Farm2StringConverter implements IConverter {

	@Override
	public Object getFromType() {
		return Farm.class;
	}

	@Override
	public Object getToType() {
		return String.class;
	}

	@Override
	public Object convert(Object fromObject) {
		if (fromObject instanceof Farm) {
			return ((Farm) fromObject).getName();
		}
		return null;
	}

}
