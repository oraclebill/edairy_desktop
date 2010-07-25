package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.riena.core.RienaStatus;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.controllers.util.BindingHelper;

public abstract class RecordDialogController<T extends EObject> extends BaseDialogController<T> {

	private BindingHelper<T> mapper;

	/**
	 * Null constructor
	 */
	public RecordDialogController() {
		super();
	}

	public void addRidgetFeatureMap(String ridgetId, EStructuralFeature... featurePath) {
		getOrCreateMapper().addMapping(ridgetId, featurePath);
	}

	public void addRidgetFeatureMap(String ridgetId, List<?> domainList, String renderMethod, EStructuralFeature... featurePath) {
		getOrCreateMapper().addComboMapping(ridgetId, domainList, renderMethod, featurePath);
	}

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
		super.configureRidgets();
//		setWindowRidget(getRidget(IWindowRidget.class, RIDGET_ID_WINDOW));
		configureUserRidgets();
		configureMappedRidgets();
		configureButtonsPanel();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getWorkingCopy() {
		return (T) this.getContext(AbstractDirectoryController.EDITED_OBJECT_ID);
	}

	private void configureMappedRidgets() {
		if (mapper != null) {
			mapper.configureRidgets();
			mapper.updateAllRidgetsFromModel();
		}
	}

	private final BindingHelper<T> getOrCreateMapper() {
		if (mapper == null) {
			mapper = new BindingHelper<T>(this, getWorkingCopy());
		}
		return mapper;
	}

	/**
	 * Subclasses should override to perform mappings and configure any
	 * unmappable ridgets.. The default implementation does nothing.
	 * 
	 */
	protected void configureUserRidgets() {
		
	}

	protected int getActionType() {
		return (Integer) getContext(AbstractDirectoryController.EDITED_ACTION_TYPE);
	}

	@Override
	protected boolean handleCancelAction() {
		setReturnCode(DialogConstants.ACTION_CANCEL);
		if (!RienaStatus.isTest()) {
			getWindowRidget().dispose();
		}
		return true;
	}

	@Override
	protected void handleSaveAction() {
		setReturnCode(DialogConstants.ACTION_SAVE);
		if (!RienaStatus.isTest()) {
			getWindowRidget().dispose();
		}
	}
}
