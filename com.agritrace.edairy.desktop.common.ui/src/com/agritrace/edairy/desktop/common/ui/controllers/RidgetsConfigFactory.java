package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.riena.ui.ridgets.IColumnFormatter;
import org.eclipse.riena.ui.ridgets.IRidget;

public class RidgetsConfigFactory {

	private static RidgetsConfigFactory instance = new RidgetsConfigFactory();

	public static RidgetsConfigFactory getInstance() {
		return instance;
	}

	public IConverter getModel2UIConverter(EStructuralFeature feature,
			IRidget ridget) {
		return null;

	}

	public IColumnFormatter getColumnFormater(EStructuralFeature feature,
			IRidget ridget) {
		return null;

	}
}
