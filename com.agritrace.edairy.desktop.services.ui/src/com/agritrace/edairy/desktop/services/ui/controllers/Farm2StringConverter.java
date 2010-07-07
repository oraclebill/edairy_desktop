package com.agritrace.edairy.desktop.services.ui.controllers;

import org.eclipse.core.databinding.conversion.Converter;

import com.agritrace.edairy.desktop.common.model.tracking.Farm;

/**
 * Converter which convert Farm to String value
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class Farm2StringConverter extends Converter {

	
	public Farm2StringConverter() {
		super(Farm.class, String.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object convert(Object fromObject) {
		if (fromObject instanceof Farm) {
			return ((Farm) fromObject).getName();
		}
		return null;
	}

}
