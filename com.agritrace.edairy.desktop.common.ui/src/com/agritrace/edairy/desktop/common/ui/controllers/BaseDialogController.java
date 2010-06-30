package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.riena.core.marker.IMarker;
import org.eclipse.riena.ui.core.marker.ErrorMarker;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.persistence.services.IRepository;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;

public abstract class BaseDialogController<T extends EObject> extends AbstractWindowController {

	protected T selected;
	protected IRepository<T> repository;

	private IActionRidget okAction;

	public BaseDialogController() {
		super();
	}

	public T getWorkingCopy() {
		return selected;
	}

	public void setWorkingCopy(T selected) {
		this.selected = selected;
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
		boolean valid = true;
		return valid;
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
	 * Called when 'Cancel' action is triggered.
	 * 
	 */
	protected void handleCancelAction() {
		setReturnCode(DialogConstants.ACTION_CANCEL);
		getWindowRidget().dispose();
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
		deleteAction.setVisible(false);
		deleteAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				handleDeleteAction();
			}
		});
	}

	private boolean validateInternal() {
		boolean retVal = validate(); // user validation first...
		if (!retVal) {
			return false;
		}
		for (IRidget test : getRidgets()) {
			IMarkableRidget markable;
			if (test instanceof IMarkableRidget) {
				markable = (IMarkableRidget) test;
				if (markable.isMandatory() && !markable.isDisableMandatoryMarker()) {
					System.err.println(">>>>>>>> mandatory widget " + markable);
					retVal = false;
				}
				if (markable.isErrorMarked()) {
					System.err.println(">>>>>>>> error widget " + markable);

					retVal = false;
					// FIXME: Display error messages in message area.
				}

			}
		}
		return retVal;
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

	@Override
	public void afterBind() {
		super.afterBind();
		// we set return code to cancel as default, because if user close
		// the window via ESCAPE (shell close), it returns OK now.
		setReturnCode(CANCEL);
	}
}