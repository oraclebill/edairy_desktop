package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.core.RienaStatus;

import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.controllers.util.BindingHelper;

public abstract class RecordDialogController<T extends EObject> extends BaseDialogController<T> {

	private BindingHelper<T> mapper;
	private PersistenceDelegate<T> persistenceDelegate;
	private String entityName;

	/**
	 * Null constructor
	 */
	public RecordDialogController(String entityName) {
		super();
		this.entityName = entityName;
	}

	public void addTextMap(String ridgetId, EStructuralFeature... featurePath) {
		getOrCreateMapper().addMapping(ridgetId, featurePath);
	}

	public void addComboMap(String ridgetId, List<?> domainList, String renderMethod, EStructuralFeature... featurePath) {
		getOrCreateMapper().addComboMapping(ridgetId, domainList, renderMethod, featurePath);
	}

// public void addChoiceMap(String ridgetId, List<?> domainList, String renderMethod, EStructuralFeature... featurePath)
// {
// getOrCreateMapper().addComboMapping(ridgetId, domainList, renderMethod, featurePath);
// }

	public void addMultiChoiceMap(String ridgetId, List<?> domainList, String renderMethod,
			EStructuralFeature... featurePath) {
		getOrCreateMapper().addMultipleChoiceMapping(ridgetId, domainList, renderMethod, featurePath);
	}

	/**
	 * Template method for configuring the dialog widgets.
	 * 
	 * Will call subclass implemented 'configureUserRidgets', then configure any mapped ridgets and finally upate the
	 * button panel.
	 * 
	 * Subclasses should implement 'afterBind' to manipulate any mapped bindings or modify buttons based on context.
	 * 
	 * @return
	 */
	@Override
	final public void configureRidgets() {
		super.configureRidgets();
// setWindowRidget(getRidget(IWindowRidget.class, RIDGET_ID_WINDOW));
		configureUserRidgets();
		configureMappedRidgets();
		configureButtonsPanel();
		persistenceDelegate = getPersistenceDelegate();
		
		String actionTypeString = getActionType() == AbstractDirectoryController.ACTION_NEW ? "Create " : "Edit ";
		String entityName = getEntityName();
		String titleString = String.format("%s %s", actionTypeString, entityName); 
		getWindowRidget().setTitle(titleString);
	}

	protected String getEntityName() {
		return entityName;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getWorkingCopy() {
		T workingCopy = null;
		persistenceDelegate = getPersistenceDelegate();
		if (persistenceDelegate != null) {
			workingCopy = (T) persistenceDelegate.getItem();
		} else {
			workingCopy = (T) this.getContext(AbstractDirectoryController.EDITED_OBJECT_ID);
		}

		assert workingCopy != null;

		return workingCopy;
	}

	@Override
	public void afterBind() {
		super.afterBind();
		if (mapper != null) {
			mapper.updateAllRidgetsFromModel();
		}
	}

	private void configureMappedRidgets() {
		if (mapper != null) {
			mapper.configureRidgets();
		}
	}

	private final BindingHelper<T> getOrCreateMapper() {
		if (mapper == null) {
			mapper = new BindingHelper<T>(this, getWorkingCopy());
		}
		return mapper;
	}

	/**
	 * Subclasses should override to perform mappings and configure any unmappable ridgets.. The default implementation
	 * does nothing.
	 * 
	 */
	protected void configureUserRidgets() {

	}

	protected int getActionType() {
		return (Integer) getContext(AbstractDirectoryController.EDITED_ACTION_TYPE);
	}

	@Override
	protected boolean handleCancelAction() {
		if (persistenceDelegate != null) {
			try {
				persistenceDelegate.rollback(getWorkingCopy());
				setReturnCode(Window.CANCEL);
				if (!RienaStatus.isTest()) {
					getWindowRidget().dispose();
				}
				return true;
			} catch (Exception e) {
				MessageDialog.openError(AbstractDirectoryController.getShell(), "Error", e.getMessage());
			}
		}
		return false;
	}

	@Override
	protected void handleSaveAction() {
		if (persistenceDelegate != null) {
			try {
				persistenceDelegate.save(getWorkingCopy());
				setReturnCode(DialogConstants.ACTION_SAVE);
				if (!RienaStatus.isTest()) {
					getWindowRidget().dispose();
				}
			} catch (Exception e) {
				setReturnCode(DialogConstants.ACTION_CANCEL);
				e.printStackTrace();
				if (e.getClass().getName().contains("ConstraintViolation")) {
					MessageDialog.openError(AbstractDirectoryController.getShell(), "Error: " +  e.getMessage(),
							e.getCause().getMessage());
				}
				else {
					MessageDialog.openError(AbstractDirectoryController.getShell(), "Error During Save",
							String.format("%s", e.getMessage()));
				}
			}
		}
	}

	@Override
	protected void handleDeleteAction() {
		if (persistenceDelegate != null) {
			try {
				persistenceDelegate.delete(getWorkingCopy());
				setReturnCode(DialogConstants.ACTION_SAVE);
				if (!RienaStatus.isTest()) {
					getWindowRidget().dispose();
				}
			} catch (Exception e) {
				MessageDialog.openError(AbstractDirectoryController.getShell(), "Error", e.getMessage());
			}
		}
	}

	@SuppressWarnings("unchecked")
	private PersistenceDelegate<T> getPersistenceDelegate() {
		return (PersistenceDelegate<T>) this.getContext(AbstractDirectoryController.PERSISTENCE_DELEGATE);
	}
}
