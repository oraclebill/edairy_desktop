package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.controllers.util.ContainerValidator;

public abstract class BaseDialogController<T extends EObject> extends AbstractWindowController {

	private IActionRidget okAction;
	protected IRepository<T> repository;

	protected T selected;

	public BaseDialogController() {
		super();
	}

	@Override
	public void afterBind() {
		super.afterBind();
		// we set return code to cancel as default, because if user close
		// the window via ESCAPE (shell close), it returns OK now.
		setReturnCode(CANCEL);
	}

	public T getWorkingCopy() {
		return selected;
	}

	public void setWorkingCopy(T selected) {
		this.selected = selected;
	}

	private boolean validateInternal() {
		boolean retVal = validate(); // user validation first...
		if (!retVal) {
			return false;
		}
		return ContainerValidator.validateContainer(this).isEmpty();
	}

	/**
	 * Configures the 'Save', 'Cancel' and 'Delete' buttons. Subclasses can
	 * override the defaults by manipulating the ridget bindings.
	 * 
	 */
	protected void configureButtonsPanel() {
		if (okAction == null) {
			okAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_SAVE);
		}
		okAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				if (!validateInternal()) {
					return;
				}
				handleSaveAction();
			}
		});

		final IActionRidget cancelAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_CANCEL);
		cancelAction.addListener(new IActionListener() {

			@Override
			public void callback() {
				handleCancelAction();
			}
		});

		final IActionRidget deleteAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_DELETE);
		Object actionType = getContext(AbstractDirectoryController.EDITED_ACTION_TYPE);
		if(actionType != null && new Integer(actionType.toString()).intValue() == AbstractDirectoryController.ACTION_NEW){
			deleteAction.setVisible(false);

		}
		deleteAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				handleDeleteAction();
			}
		});
	}

	/**
	 * Enable /disable the save button.
	 * 
	 * @param enable
	 */
	protected void enableSaveButton(boolean enable) {
		if (okAction == null) {
			okAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_SAVE);
		}
		okAction.setEnabled(enable);
	}

	/**
	 * Called when 'Cancel' action is triggered.
	 * @return true if cancel should succeed.
	 * 
	 */
	protected boolean handleCancelAction() {
		setReturnCode(DialogConstants.ACTION_CANCEL);
		getWindowRidget().dispose();
		return true;
	}

	/**
	 * Called when 'Delete' action is triggered.
	 * 
	 */
	protected void handleDeleteAction() {
		setReturnCode(DialogConstants.ACTION_DELETE);
		getWindowRidget().dispose();
	}

	/**
	 * Called after validation is successful, when 'Save' or 'Update' action is
	 * triggered.
	 * 
	 * 
	 */
	protected void handleSaveAction() {
		setReturnCode(DialogConstants.ACTION_SAVE);
		setContext("selected", getWorkingCopy());
		System.out.println("OK calling dispose");
		getWindowRidget().dispose();
	}

	/**
	 * Validate is called before the standard page validation processs.
	 * 
	 * Subclasses should override to provide additional page level validation.
	 * The default implementation returns 'true'.
	 * 
	 * @return
	 */
	protected boolean validate() {
		final boolean valid = true;
		return valid;
	}
}