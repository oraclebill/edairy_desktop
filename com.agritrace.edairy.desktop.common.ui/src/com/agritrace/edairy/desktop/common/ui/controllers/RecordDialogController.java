package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.util.Assert;
import org.eclipse.riena.core.RienaStatus;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.IValueRidget;
import org.eclipse.riena.ui.ridgets.IWindowRidget;

import com.agritrace.edairy.desktop.common.ui.DialogConstants;

public abstract class RecordDialogController<T extends EObject> extends BaseDialogController<T> {

	private static class FeatureProperties {
		private String bindingId;
		private FeaturePath featurePath;
		private IObservableList domainList;
		private Class entityClass;

		public FeatureProperties(String bindingId, EStructuralFeature... featureList) {
			this(bindingId, FeaturePath.fromList(featureList));
			initClassFromFeatures();
		}

		public FeatureProperties(String bindingId, FeaturePath featurePath) {
			this.bindingId = bindingId;
			this.featurePath = featurePath;
		}

		public String getBindingId() {
			return bindingId;
		}

		public void setBindingId(String bindingId) {
			this.bindingId = bindingId;
		}

		public FeaturePath getFeaturePath() {
			return featurePath;
		}

		public void setFeaturePath(FeaturePath featurePath) {
			this.featurePath = featurePath;
			initClassFromFeatures();
		}

		public IObservableList getDomainList() {
			return domainList;
		}

		public void setDomainList(IObservableList domainList) {
			Assert.isLegal(domainList.getElementType() == getEntityClass(), "Entity class  " + getEntityClass()
					+ "' and list type '" + domainList.getElementType() + "' not equal");
			this.domainList = domainList;
		}

		public Class getEntityClass() {
			if (entityClass == null) {
				entityClass = getTailFeature().eClass().getInstanceClass();
			}
			return entityClass;
		}

		/**
		 * Returns null if
		 * 
		 * @return
		 */
		public EStructuralFeature getTailFeature() {
			EStructuralFeature tailFeature = null;

			if (featurePath != null) {
				EStructuralFeature[] features = featurePath.getFeaturePath();
				if (features.length > 0) {
					tailFeature = features[features.length - 1];
				}
			}

			return tailFeature;
		}

		private void initClassFromFeatures() {

		}

	}

	private final Map<String, FeatureProperties> ridgetPropertyMap = new HashMap<String, FeatureProperties>();

	/**
	 * Gets working copy for editing
	 * 
	 * @return
	 */
	// protected abstract T createWorkingCopy();

	private EClass eClass;

	/**
	 * Null constructor
	 */
	public RecordDialogController() {
		super();
	}

	public T getWorkingCopy() {
		return (T) this.getContext(AbstractDirectoryController.EDITED_OBJECT_ID);
	}

	protected void setEClass(EClass eClass) {
		this.eClass = eClass;
	}

	protected EClass getEClass() {
		return this.eClass;
	}

	// /**
	// * Gets the selected object in table list. If user doesn't select any row,
	// * this object will be null
	// *
	// * @return
	// */
	// public T getSelectedObject() {
	// return this.selectedObject;
	// }

	/**
	 * Template method for configuring the dialog widgets.
	 * 
	 * Will call subclass implemented 'configureUserRidgets', then configure any
	 * mapped ridgets and finally upate the button panel.
	 * 
	 * Subclasses should implement 'afterBind' to manipulate any mapped bindings
	 * or modify buttons based on context.
	 * 
	 * @return
	 */
	@Override
	final public void configureRidgets() {
		setWindowRidget(getRidget(IWindowRidget.class, RIDGET_ID_WINDOW));
		configureUserRidgets();
		configureMappedRidgets();
		configureButtonsPanel();
	}

	/**
	 * Adds a ridget - FeaturePath mapping to the mapping registry. Mapped
	 * ridgets are bound automatically during the configuration process.
	 * 
	 * @param ridgetId
	 * @param featurePath
	 */
	protected void addRidgetFeatureMap(String ridgetId, EStructuralFeature... featurePath) {
		FeaturePath path = FeaturePath.fromList(featurePath);
		FeatureProperties props = new FeatureProperties(ridgetId, path);
		ridgetPropertyMap.put(ridgetId, props);
	}

	/**
	 * Adds a combo type ridget - FeaturePath mapping to the mapping registry.
	 * Combo mappings include domain lists.
	 * 
	 * @param ridgetId
	 * @param featurePath
	 */
	protected void addRidgetFeatureMap(String ridgetId, List<T> domainList, EStructuralFeature... featurePath) {
		FeatureProperties props = new FeatureProperties(ridgetId, FeaturePath.fromList(featurePath));
		props.setDomainList(Observables.staticObservableList(domainList));
		ridgetPropertyMap.put(ridgetId, props);
		throw new UnsupportedOperationException("Not implemented...");
	}

	protected void configureMappedRidgets() {

		for (final FeatureProperties binding : ridgetPropertyMap.values()) {
			final IRidget ridget = getRidget(binding.getBindingId());
			if (ridget instanceof IValueRidget) {
				final IValueRidget valueRidget = (IValueRidget) ridget;
				final IConverter converter = createConverter(binding.getTailFeature(), valueRidget);
				if (converter != null) {
					valueRidget.setModelToUIControlConverter(converter);
				}
				valueRidget.bindToModel(EMFProperties.value(binding.getFeaturePath()).observe(getWorkingCopy()));
				if (binding.getTailFeature().isRequired() && valueRidget instanceof IMarkableRidget) {
					IMarkableRidget markableValue = (IMarkableRidget) valueRidget;
					markableValue.setMandatory(true);
				}
				valueRidget.updateFromModel();
			} else if (ridget instanceof IComboRidget) {
				final IComboRidget 		comboRidget = (IComboRidget) ridget;
				final IObservableList 	optionValues = binding.getDomainList();
				final Class<?>			rowClass = binding.getEntityClass();
				final IObservableValue 	selectionValue =  EMFProperties.value(binding.getFeaturePath()).observe(getWorkingCopy());
				if (optionValues == null || rowClass == null || selectionValue == null) {
					throw new IllegalStateException();
				}
				comboRidget.bindToModel(optionValues, rowClass, "toString()", selectionValue);
			} else if (ridget instanceof ITableRidget) {
				final ITableRidget 		tableRidget = (ITableRidget) ridget;
				
				final IObservableList 	rowObservables = binding.getDomainList();;
				final String[] 			columnPropertyNames = new String[] {};
				final String[] 			columnHeaders = new String[] {};
				final Class<?> 			rowClass = binding.getEntityClass();
				
				throw new UnsupportedOperationException();
//				tableRidget.bindToModel(rowObservables, rowClass, columnPropertyNames, columnHeaders);
			} else {
				throw new UnsupportedOperationException("Ridget classs '" + ridget.getClass().getName()
						+ "' is not supported.");
			}
		}
	}

	protected IConverter createConverter(EStructuralFeature feature, IValueRidget ridget) {
		return RidgetsConfigFactory.getInstance().getModel2UIConverter(feature, ridget);
	}

	/**
	 * Subclasses should override to perform mappings and configure any
	 * unmappable ridgets.. The default implementation does nothing.
	 * 
	 */
	protected void configureUserRidgets() {

	}

	@Override
	protected void handleSaveAction() {
		setReturnCode(DialogConstants.ACTION_SAVE);
		if (!RienaStatus.isTest()) {
			getWindowRidget().dispose();
		}
	}

	@Override
	protected void handleCancelAction() {
		setReturnCode(DialogConstants.ACTION_CANCEL);
		if (!RienaStatus.isTest()) {
			getWindowRidget().dispose();
		}
	}

	protected int getActionType() {
		return (Integer) getContext(AbstractDirectoryController.EDITED_ACTION_TYPE);
	}

	protected Map<String, EStructuralFeature> configureRidgetPropertyMap() {
		final Map<String, EStructuralFeature> map = new HashMap<String, EStructuralFeature>();
		return map;
	}

	private Map<String, EStructuralFeature> getRidgetFeatureMap() {
		final Map<String, EStructuralFeature> map = new HashMap<String, EStructuralFeature>();
		return map;
	}

	// /**
	// * test support code copied from the submoduleviewcontroller..
	// */
	// @Override
	// @SuppressWarnings("unchecked")
	// public <R extends IRidget> R getRidget(Class<R> ridgetClazz, String id) {
	// R ridget = (R) getRidget(id);
	//
	// if (ridget != null) {
	// return ridget;
	// }
	// if (RienaStatus.isTest()) {
	// try {
	// if (ridgetClazz.isInterface() ||
	// Modifier.isAbstract(ridgetClazz.getModifiers())) {
	// final Class<R> mappedRidgetClazz = (Class<R>)
	// ClassRidgetMapper.getInstance().getRidgetClass(
	// ridgetClazz);
	// if (mappedRidgetClazz != null) {
	// ridget = mappedRidgetClazz.newInstance();
	// }
	// Assert.isNotNull(
	// ridget,
	//							"Could not find a corresponding implementation for " + ridgetClazz.getName() + " in " + ClassRidgetMapper.class.getName()); //$NON-NLS-1$ //$NON-NLS-2$
	// } else {
	// ridget = ridgetClazz.newInstance();
	// }
	// } catch (final InstantiationException e) {
	// throw new RuntimeException(e);
	// } catch (final IllegalAccessException e) {
	// throw new RuntimeException(e);
	// }
	//
	// addRidget(id, ridget);
	// }
	//
	// return ridget;
	// }

}
