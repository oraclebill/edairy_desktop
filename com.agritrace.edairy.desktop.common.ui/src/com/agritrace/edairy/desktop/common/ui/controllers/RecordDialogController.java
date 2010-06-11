package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.riena.core.RienaStatus;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IValueRidget;
import org.eclipse.riena.ui.ridgets.IWindowRidget;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.IRepository;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;

public abstract class RecordDialogController<T extends EObject> extends BaseDialogController<T> {

	private final Map<String, FeaturePath> ridgetPropertyMap = new HashMap<String, FeaturePath>();

	private final List<IActionListener> listeners = new ArrayList<IActionListener>();
	/**
	 * Gets working copy for editing
	 * 
	 * @return
	 */
	// protected abstract T createWorkingCopy();

	protected abstract EClass getEClass();

	/** 
	 * Null constructor 
	 */
	public RecordDialogController() {
		super();
	}

	public Object  getWorkingCopy() {
		return this.getContext(AbstractRecordListController.EDITED_OBJECT_ID);
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
	 * Will call subclass implemented 'configureUserRidgets', then configure
	 * any mapped ridgets and finally upate the button panel. 
	 * 
	 * Subclasses should implement 'afterBind' to manipulate any mapped bindings or 
	 * modify buttons based on context.
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
	 * Adds a ridget - FeaturePath mapping to the mapping registry. Mapped ridgets are bound automatically 
	 * during the configuration process. 
	 * 
	 * @param ridgetId
	 * @param featurePath
	 */
	protected void addRidgetFeatureMap(String ridgetId, EStructuralFeature... featurePath) {
		FeaturePath path = FeaturePath.fromList(featurePath);
		ridgetPropertyMap.put(ridgetId, path);
	}

	/**
	 * Adds a combo type ridget - FeaturePath mapping to the mapping registry. Combo mappings include domain lists. 
	 * 
	 * @param ridgetId
	 * @param featurePath
	 */
	protected void addRidgetFeatureMap(String ridgetId, Collection<T> domainList, EStructuralFeature... featurePath) {
		FeaturePath path = FeaturePath.fromList(featurePath);
		ridgetPropertyMap.put(ridgetId, path);
		throw new UnsupportedOperationException("Not implemented...");
	}

	protected void configureMappedRidgets() {
		
		for (final Entry<String, FeaturePath> binding : ridgetPropertyMap.entrySet()) {
			final IRidget ridget = getRidget(binding.getKey());
			if (ridget instanceof IValueRidget) {
				final IValueRidget valueRidget = (IValueRidget) ridget;
				final EStructuralFeature features[] = binding.getValue().getFeaturePath();				
				final EStructuralFeature tailFeature = features[features.length - 1];				
				final IConverter converter = 
					RidgetsConfigFactory.getInstance().getModel2UIConverter(
							tailFeature, valueRidget);
				if (converter != null) {
					valueRidget.setModelToUIControlConverter(converter);
				}
				valueRidget.bindToModel(
						EMFProperties.value(
								binding.getValue()).observe(getWorkingCopy()));
				if (tailFeature.isRequired() && valueRidget instanceof IMarkableRidget) {
					IMarkableRidget markableValue = (IMarkableRidget) valueRidget;
					markableValue.setMandatory(true);
				}				
				valueRidget.updateFromModel();
			}
		}
	}

	/**
	 * Subclasses should override to perform mappings and configure any unmappable ridgets..
	 * The default implementation does nothing.
	 * 
	 */
	protected void configureUserRidgets() {

				}

			@Override
	protected void handleSaveAction()  {
		setReturnCode(DialogConstants.ACTION_SAVE);
		if (getActionType() == AbstractRecordListController.ACTION_NEW) {
			saveNew();
		} else {
			// Update all working copy to selected object
			// EMFUtil.copy(this.getWorkingCopy(), getSelectedObject(), 2);
			saveUpdated();
		}
		notifyListeners();
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
		return (Integer) getContext(AbstractRecordListController.EDITED_ACTION_TYPE);
	}
	

	protected void doCancelPressed() {
		setReturnCode(CANCEL);
		if (!RienaStatus.isTest()) {
			getWindowRidget().dispose();
		}

	}

	protected Map<String, EStructuralFeature> configureRidgetPropertyMap() {
		final Map<String, EStructuralFeature> map = new HashMap<String, EStructuralFeature>();
		return map;
	}

	public void addListener(IActionListener listener) {
		this.listeners.add(listener);
	}

	private void notifyListeners() {
		for (final IActionListener listener : this.listeners) {
			listener.callback();
		}
	}

	private Map<String, EStructuralFeature> getRidgetFeatureMap() {
		final Map<String, EStructuralFeature> map = new HashMap<String, EStructuralFeature>();
		return map;
	}



//	/**
//	 * test support code copied from the submoduleviewcontroller..
//	 */
//	@Override
//	@SuppressWarnings("unchecked")
//	public <R extends IRidget> R getRidget(Class<R> ridgetClazz, String id) {
//		R ridget = (R) getRidget(id);
//
//		if (ridget != null) {
//			return ridget;
//		}
//		if (RienaStatus.isTest()) {
//			try {
//				if (ridgetClazz.isInterface() || Modifier.isAbstract(ridgetClazz.getModifiers())) {
//					final Class<R> mappedRidgetClazz = (Class<R>) ClassRidgetMapper.getInstance().getRidgetClass(
//							ridgetClazz);
//					if (mappedRidgetClazz != null) {
//						ridget = mappedRidgetClazz.newInstance();
//					}
//					Assert.isNotNull(
//							ridget,
//							"Could not find a corresponding implementation for " + ridgetClazz.getName() + " in " + ClassRidgetMapper.class.getName()); //$NON-NLS-1$ //$NON-NLS-2$
//				} else {
//					ridget = ridgetClazz.newInstance();
//				}
//			} catch (final InstantiationException e) {
//				throw new RuntimeException(e);
//			} catch (final IllegalAccessException e) {
//				throw new RuntimeException(e);
//			}
//
//			addRidget(id, ridget);
//		}
//
//		return ridget;
//	}

	}
