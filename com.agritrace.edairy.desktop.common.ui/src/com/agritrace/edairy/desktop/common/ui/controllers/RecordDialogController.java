package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.riena.core.RienaStatus;
import org.eclipse.riena.ui.ridgets.IWindowRidget;

import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.controllers.util.BindingHelper;

public abstract class RecordDialogController<T extends EObject> extends BaseDialogController<T> {

	/**
	 * Gets working copy for editing
	 * 
	 * @return
	 */
	// protected abstract T createWorkingCopy();

	private EClass eClass;
	private BindingHelper<T> mapper;

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

	public void addRidgetFeatureMap(String ridgetId, EStructuralFeature... featurePath) {
		getOrCreateMapper().addMapping(ridgetId, featurePath);
	}

	public void addRidgetFeatureMap(String ridgetId, List<?> domainList, EStructuralFeature... featurePath) {
		getOrCreateMapper().addMapping(ridgetId, domainList, featurePath);
	}

	private final BindingHelper<T> getMapper() {
		return mapper;
	}

	private final BindingHelper<T> getOrCreateMapper() {
		if (mapper == null) {
			mapper = new BindingHelper<T>(this, getWorkingCopy());
		}
		return mapper;
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
	 * Subclasses should override to perform mappings and configure any
	 * unmappable ridgets.. The default implementation does nothing.
	 * 
	 */
	protected void configureUserRidgets() {

	}

	private void configureMappedRidgets() {
		if (getMapper() != null)
			getMapper().configureRidgets();
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
