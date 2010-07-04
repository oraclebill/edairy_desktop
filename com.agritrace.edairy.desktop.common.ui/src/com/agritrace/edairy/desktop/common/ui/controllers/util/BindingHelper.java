package com.agritrace.edairy.desktop.common.ui.controllers.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IEditableRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ISingleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;

public class BindingHelper<T extends EObject> {

	private static final ConverterFactory converterFactory = new ConverterFactory();
	private final T modelObject;

	private final IRidgetContainer ridgetContainer;
	private final Map<String, FeatureProperties> ridgetPropertyMap = new HashMap<String, FeatureProperties>();

	/**
	 * Create a new EMFBindingHelper.
	 * 
	 * @param ridgetContainer
	 * @param modelObject
	 */
	public BindingHelper(IRidgetContainer ridgetContainer, T modelObject) {
		if (modelObject == null) 
			throw new IllegalArgumentException("Model object must not be null");
		
		if (ridgetContainer == null) 
			throw new IllegalArgumentException("RidgetContainer must not be null");
		
		this.ridgetContainer = ridgetContainer;
		this.modelObject = modelObject;
	}

	/**
	 * Adds a ridget - FeaturePath mapping to the mapping registry. Mapped
	 * ridgets are bound automatically during the configuration process.
	 * 
	 * @param ridgetId
	 * @param featurePath
	 */
	public void addMapping(String ridgetId, EStructuralFeature... featurePath) {
		// TODO: automatically create domain list for features that are
		// instances of an enum type.
		final FeatureProperties props = new FeatureProperties(ridgetId, featurePath);
		ridgetPropertyMap.put(ridgetId, props);
	}

	/**
	 * Adds a combo type ridget - FeaturePath mapping to the mapping registry.
	 * Combo mappings include domain lists.
	 * 
	 * @param ridgetId
	 * @param featurePath
	 */
	public void addMapping(String ridgetId, List<?> domainList, EStructuralFeature... featurePath) {
		final FeatureProperties props = new FeatureProperties(ridgetId, domainList, featurePath);
		ridgetPropertyMap.put(ridgetId, props);
	}

	/**
	 * 
	 */
	public void configureRidgets() {

		for (final FeatureProperties binding : ridgetPropertyMap.values()) {
			final IRidget ridget = ridgetContainer.getRidget(binding.getBindingId());
			checkMandatory(binding, ridget);

			if (ridget instanceof IEditableRidget) {
				final IEditableRidget valueRidget = (IEditableRidget) ridget;
				final IValueProperty modelValue = EMFProperties.value(binding.getFeaturePath());
				valueRidget.bindToModel(modelValue.observe(getModelObject()));
				final IConverter converter = createUI2ModelConverter(valueRidget, binding.getTailFeature());
				if (converter != null) {
//					valueRidget.setUIControlToModelxConverter(converter); // has no effect..
				}
				valueRidget.updateFromModel();
			} else if (ridget instanceof IComboRidget) {
				final IComboRidget comboRidget = (IComboRidget) ridget;
				final IObservableList optionValues = binding.getDomainList();
				final Class<?> rowClass = binding.getEntityClass();
				final IObservableValue selectionValue = EMFProperties.value(binding.getFeaturePath()).observe(
						getModelObject());

				checkParameters(optionValues, rowClass, selectionValue);
				checkMandatory(binding, ridget);
				comboRidget.bindToModel(optionValues, rowClass, "toString()", selectionValue);
			} else if (ridget instanceof ITableRidget) {
//				final ITableRidget tableRidget = (ITableRidget) ridget;
//
//				final IObservableList rowObservables = binding.getDomainList();
//				;
//				final String[] columnPropertyNames = new String[] {};
//				final String[] columnHeaders = new String[] {};
//				final Class<?> rowClass = binding.getEntityClass();
				// tableRidget.bindToModel(rowObservables, rowClass,
				// columnPropertyNames, columnHeaders);

				throw new UnsupportedOperationException();
			} else if (ridget instanceof ISingleChoiceRidget) {
				final ISingleChoiceRidget singleChoice = (ISingleChoiceRidget) ridget;
				// final IComboRidget comboRidget = (IComboRidget) ridget;
				final IObservableList optionValues = binding.getDomainList();
				final Class<?> rowClass = binding.getEntityClass();
				final IObservableValue selectionValue = EMFProperties.value(binding.getFeaturePath()).observe(
						getModelObject());

				checkParameters(optionValues, rowClass, selectionValue);
				checkMandatory(binding, ridget);
				singleChoice.bindToModel(optionValues, selectionValue);
			} else if (ridget == null) {
				throw new IllegalStateException("Ridget '" + binding.getBindingId() + " is null!");
			} else {
				throw new UnsupportedOperationException("Ridget classs '" + ridget.getClass().getName()
						+ "' is not supported.");
			}
		}
	}

	/**
	 * Get the model object this binding helper was instantiated with.
	 * 
	 * @return
	 */
	public T getModelObject() {
		return modelObject;
	}

	private void checkMandatory(FeatureProperties binding, IRidget ridget) {
		final FeaturePath path = binding.getFeaturePath();
		final EStructuralFeature testFeature = path.getFeaturePath()[0];
		if (testFeature.isRequired() && (ridget instanceof IMarkableRidget)) {
			final IMarkableRidget markableValue = (IMarkableRidget) ridget;
			markableValue.setMandatory(true);
		}
	}

	private void checkParameters(IObservableList optionValues, Class<?> rowClass, IObservableValue selectionValue) {
		if ((optionValues == null) || (rowClass == null) || (selectionValue == null)) {
			throw new IllegalStateException("One of [optionValues, rowClass, selectionValue] is null (" + optionValues
					+ ", " + rowClass + ", " + selectionValue + ")");
		}
	}

	private IConverter createUI2ModelConverter(IEditableRidget ridget, EStructuralFeature feature) {
		try {
			final EClassifier featureType = feature.getEType();
			final Class<?> featureClass = featureType.getInstanceClass();
			return converterFactory.createConverter(String.class, featureClass);
		} catch (final Exception e) {
			System.err.println("WARN: converter factory failed for feature: " + feature);
			return null;
		}
	}

	// protected Map<String, EStructuralFeature> configureRidgetPropertyMap() {
	// final Map<String, EStructuralFeature> map = new HashMap<String,
	// EStructuralFeature>();
	// return map;
	// }

}
