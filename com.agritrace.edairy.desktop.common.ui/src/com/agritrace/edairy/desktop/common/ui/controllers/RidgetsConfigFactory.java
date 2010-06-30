package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.riena.ui.ridgets.IRidget;

/**
 * Ridget configuration factory
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class RidgetsConfigFactory {

	private static class ConverterFactory extends UpdateValueStrategy {
		@Override
		public IConverter createConverter(Object fromType, Object toType) {
			return super.createConverter(fromType, toType);
		}		
	}
	
	private static RidgetsConfigFactory instance = new RidgetsConfigFactory();

	private final ConverterFactory converterFactory = new  ConverterFactory();

	/**
	 * Gets ridgets configuration factory instance
	 * 
	 * @return Configuration factory instance
	 */
	public static RidgetsConfigFactory getInstance() {
		return instance;
	}

	/**
	 * Gets the model2UI converter based on feature and ridget
	 * 
	 * @param feature
	 *            Structuall feature
	 * @param ridget
	 *            Ridget
	 * @return Model2UIConverter
	 */
	public IConverter getModel2UIConverter(EStructuralFeature feature, IRidget ridget) {
		EClassifier featureType = feature.getEType();
		Class featureClass = featureType.getInstanceClass();
//		converterFactory.createConverter(fromType, toType);
		return null;
	}
}
