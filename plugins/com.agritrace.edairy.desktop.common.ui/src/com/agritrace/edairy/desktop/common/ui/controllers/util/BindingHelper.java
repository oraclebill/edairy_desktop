package com.agritrace.edairy.desktop.common.ui.controllers.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IEditableRidget;
import org.eclipse.riena.ui.ridgets.IListRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IMultipleChoiceRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ISingleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;

/**
 * A utility class that eases binding of Ridgets to EMF properties.
 * 
 * @author oraclebill
 * 
 * @param <T>
 */
public class BindingHelper<T extends EObject> {

	// private static final ConverterFactory converterFactory = new
	// ConverterFactory();
	private final T modelObject;

	private final IRidgetContainer ridgetContainer;
	private final Map<String, FeatureProperties> ridgetPropertyMap = new HashMap<String, FeatureProperties>();

	/**
	 * Create a new BindingHelper.
	 * 
	 * @param ridgetContainer
	 * @param modelObject
	 */
	public BindingHelper(IRidgetContainer ridgetContainer, T modelObject) {
		if (modelObject == null) {
			throw new IllegalArgumentException("Model object must not be null");
		}

		if (ridgetContainer == null) {
			throw new IllegalArgumentException("RidgetContainer must not be null");
		}

		this.ridgetContainer = ridgetContainer;
		this.modelObject = modelObject;
	}

	/**
	 * Get the model object this binding helper was instantiated with.
	 * 
	 * @return
	 */
	public T getModelObject() {
		return modelObject;
	}

	/**
	 * Adds a ridget - FeaturePath mapping to the mapping registry. Mapped ridgets are bound automatically during the
	 * configuration process.
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
	 * Adds a combo type ridget - FeaturePath mapping to the mapping registry. Combo mappings include domain lists.
	 * 
	 * @param ridgetId
	 * @param featurePath
	 */
	public void addComboMapping(String ridgetId, List<?> domainList, String renderMethod,
			EStructuralFeature... featurePath) {
		final FeatureProperties props = new FeatureProperties(ridgetId, domainList, renderMethod, featurePath);
		ridgetPropertyMap.put(ridgetId, props);
	}

	/**
	 * Adds a combo type ridget - FeaturePath mapping to the mapping registry. Combo mappings include domain lists.
	 * 
	 * @param ridgetId
	 * @param featurePath
	 */
	public void addListMapping(String ridgetId, List<?> domainList, String renderMethod,
			EStructuralFeature... featurePath) {
		final FeatureProperties props = new FeatureProperties(ridgetId, domainList, renderMethod, featurePath);
		ridgetPropertyMap.put(ridgetId, props);
	}

	/**
	 * 
	 * @param ridgetId
	 * @param domainList
	 * @param renderMethod
	 * @param featurePath
	 */
	public void addMultipleChoiceMapping(String ridgetId, List<?> domainList, String renderMethod,
			EStructuralFeature[] featurePath) {
		final FeatureProperties props = new FeatureProperties(ridgetId, domainList, renderMethod, featurePath);
		final EStructuralFeature tail = featurePath[featurePath.length - 1];
		if (!tail.isMany()) {
			throw new IllegalArgumentException("Feature is not multi-valued");
		}
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
				bindValueRidget(binding, (IEditableRidget) ridget);
			} else if (ridget instanceof IToggleButtonRidget) {
				bindToggleButtonRidget(binding, (IToggleButtonRidget) ridget);
			} else if (ridget instanceof IComboRidget) {
				bindComboRidget(binding, (IComboRidget) ridget);
			} else if (ridget instanceof ISingleChoiceRidget) {
				bindSingleChoiceRidget(binding, (ISingleChoiceRidget) ridget);
			} else if (ridget instanceof IMultipleChoiceRidget) {
				bindMultiChoiceRidget(binding, (IMultipleChoiceRidget) ridget);
			} else if (ridget instanceof IListRidget) {
				bindListRidget(binding, (IListRidget) ridget);
			} else if (ridget == null) {
				throw new IllegalStateException("Ridget '" + binding.getBindingId() + "' is null!");
			} else {
				throw new UnsupportedOperationException("Ridget class '" + ridget.getClass().getName()
						+ "' is not supported.");
			}

			ridget.updateFromModel();
		}
	}

	/**
	 *
	 */
	public void updateAllRidgetsFromModel() {
		if (modelObject != null) {
			for (final IRidget ridget : ridgetContainer.getRidgets()) {
				try {
					ridget.updateFromModel();
				} catch (final org.eclipse.core.databinding.BindingException bindException) {
					System.err.printf("Error [%s] binding ridget %s[%s] - no model binding: ",
							bindException.getMessage(), ridget, ridget.getUIControl());

				} catch (final IllegalArgumentException argException) {
					System.err.printf("%s error binding ridget %s[%s] - no model binding: ", argException.getMessage(),
							ridget, ridget.getUIControl());
				}
			}
		}
	}

	/**
	 * 
	 * @param binding
	 * @param ridget
	 * @param valueRidget
	 */
	void bindValueRidget(final FeatureProperties binding, final IEditableRidget valueRidget) {
		final IObservableValue observable = PojoObservables.observeValue(getModelObject(), binding.getPropertyName());
		valueRidget.bindToModel(observable);

		// bug-154: set direct writing by default on text ridgets.
		if (valueRidget instanceof ITextRidget) {
			try {
				((ITextRidget) valueRidget).setDirectWriting(true);
			} catch (final UnsupportedOperationException uoe) {
				;
				;
			}
		}

		try {
			valueRidget.updateFromModel();
		} catch (final Exception e) {
			System.err.printf("Error mapping ridget %s to feature %s: %s", valueRidget, binding.getFeaturePath(),
					e.getMessage());
		}
	}

	/**
	 * @param binding
	 * @param toggleRidget
	 */
	void bindToggleButtonRidget(final FeatureProperties binding, final IToggleButtonRidget toggleRidget) {
		final IObservableValue observable = PojoObservables.observeValue(getModelObject(), binding.getPropertyName());
		// validate
		Object valueType = observable.getValueType();
		if (valueType instanceof Class
				&& (((Class) valueType).isAssignableFrom(Boolean.class) 
						|| ((Class) valueType).isAssignableFrom(boolean.class))) {
			toggleRidget.bindToModel(observable);
			try {
				toggleRidget.updateFromModel();
			} catch (final Exception e) {
				System.err.printf("Error mapping ridget %s to feature %s: %s", toggleRidget, binding.getFeaturePath(),
						e.getMessage());
			}
		} else {
			throw new UnsupportedOperationException("Toggle buttons can only be bound to 'Boolean' values: ");
		}
	}

	/**
	 * @param binding
	 * @param comboRidget
	 */
	void bindComboRidget(final FeatureProperties binding, final IComboRidget comboRidget) {
		final IObservableList optionValues = binding.getDomainList();
		final Class<?> rowClass = binding.getEntityClass();
		final IObservableValue selectionValue = PojoProperties.value(binding.getPropertyName()).observe(
				getModelObject());

		checkParameters(optionValues, rowClass, selectionValue);
		comboRidget.bindToModel(optionValues, rowClass, binding.getRenderMethod(), selectionValue);
	}

	/**
	 * @param binding
	 * @param singleChoice
	 */
	void bindSingleChoiceRidget(final FeatureProperties binding, final ISingleChoiceRidget singleChoice) {
		final IObservableList optionValues = binding.getDomainList();
		final Class<?> rowClass = binding.getEntityClass();
		final IObservableValue selectionValue = EMFProperties.value(binding.getFeaturePath()).observe(getModelObject());

		checkParameters(optionValues, rowClass, selectionValue);
		singleChoice.bindToModel(optionValues, selectionValue);
	}

	/**
	 * @param binding
	 * @param ridget
	 */
	void bindMultiChoiceRidget(final FeatureProperties binding, final IMultipleChoiceRidget ridget) {
		final IObservableList optionValues = binding.getDomainList();
		final Class<?> rowClass = binding.getEntityClass();
		final IObservableList selectionValues = EMFProperties.list(binding.getFeaturePath()).observe(getModelObject());

		checkParameters(optionValues, rowClass, selectionValues);
		checkMandatory(binding, ridget);
		ridget.bindToModel(optionValues, selectionValues);
	}

	private void bindListRidget(FeatureProperties binding, IListRidget ridget) {
		final IObservableList optionValues = binding.getDomainList();
		final Class<?> rowClass = binding.getEntityClass();

		checkParameters(optionValues, rowClass, optionValues);
		checkMandatory(binding, ridget);
		ridget.bindToModel(optionValues, rowClass, binding.getRenderMethod());
		if (binding.getTailFeature().isMany()) {
			ridget.bindMultiSelectionToModel(EMFProperties.list(binding.getFeaturePath()).observe(getModelObject()));
		} else {
			ridget.bindSingleSelectionToModel(EMFProperties.value(binding.getFeaturePath()).observe(getModelObject()));
		}
	}

	/**
	 * Mark ridgets as mandatory IFF all components of the featurepath are required.
	 * 
	 * @param binding
	 * @param ridget
	 */
	void checkMandatory(FeatureProperties binding, IRidget ridget) {
		boolean required = true;
		for (EStructuralFeature testFeature : binding.getFeaturePath().getFeaturePath()) {
			required = required && testFeature.isRequired();
		}
		if (required && ridget instanceof IMarkableRidget) {
			final IMarkableRidget markableValue = (IMarkableRidget) ridget;
			markableValue.setMandatory(true);
		}
	}

	void checkParameters(IObservableList optionValues, Class<?> rowClass, Object selectionValue) {
		if (optionValues == null || rowClass == null || selectionValue == null) {
			throw new IllegalStateException("One of [optionValues, rowClass, selectionValue] is null (" + optionValues
					+ ", " + rowClass + ", " + selectionValue + ")");
		}
	}

	//
	// private IConverter createUI2ModelConverter(IEditableRidget ridget,
	// EStructuralFeature feature) {
	// try {
	// final EClassifier featureType = feature.getEType();
	// final Class<?> featureClass = featureType.getInstanceClass();
	// return converterFactory.createConverter(String.class, featureClass);
	// } catch (final Exception e) {
	// System.err.println("WARN: converter factory failed for feature: " +
	// feature);
	// return null;
	// }
	// }
	//
	// private IConverter createModel2UIControlConverter(Object obj,
	// IEditableRidget ridget) {
	// return new Converter(obj, String.class) {
	// @Override
	// public Object convert(Object from) {
	// return from != null ? from.toString() : "";
	// }
	// };
	// }

	// protected Map<String, EStructuralFeature> configureRidgetPropertyMap() {
	// final Map<String, EStructuralFeature> map = new HashMap<String,
	// EStructuralFeature>();
	// return map;
	// }

}
