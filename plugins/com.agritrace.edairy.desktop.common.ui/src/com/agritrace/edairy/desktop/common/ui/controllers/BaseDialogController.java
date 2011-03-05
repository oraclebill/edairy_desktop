package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IInfoFlyoutRidget;
import org.eclipse.riena.ui.ridgets.IInfoFlyoutRidget.InfoFlyoutData;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.controllers.util.ContainerValidator;
import com.agritrace.edairy.desktop.common.ui.dialogs.BaseDialogView;

public abstract class BaseDialogController<T extends EObject> extends AbstractWindowController {

	private IActionRidget		okAction;
	protected IRepository<T>	repository;

	protected T					selected;
	private IInfoFlyoutRidget	flyoutRidget;

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
		final boolean retVal = validate(); // user validation first...
		if (!retVal) {
			return false;
		}
		ContainerValidator validator = new ContainerValidator();
		Collection<IMarkableRidget> errorRidgets = validator.validateContainer(this);
		createErrorMessage(errorRidgets);
		return errorRidgets.isEmpty();
	}

	private void createErrorMessage(Collection<IMarkableRidget> errorRidgets) {
		if (errorRidgets.size() > 0) {
			StringBuffer buf = new StringBuffer();
			buf.append("The following fields have errors: ");
			for (IMarkableRidget ridget : errorRidgets) {
				buf.append(ridget.getID());
				buf.append(" ");
			}
			flyoutRidget.addInfo(new InfoFlyoutData(null, buf.toString()));
		}
	}

	/**
	 * Configures the 'Save', 'Cancel' and 'Delete' buttons. Subclasses can override the defaults by manipulating the
	 * ridget bindings.
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
		final Object actionType = getContext(AbstractDirectoryController.EDITED_ACTION_TYPE);
		if (actionType != null
				&& new Integer(actionType.toString()).intValue() == AbstractDirectoryController.ACTION_NEW) {
			deleteAction.setVisible(false);

		}
		deleteAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				handleDeleteAction();
			}
		});

		flyoutRidget = getRidget(IInfoFlyoutRidget.class, BaseDialogView.BIND_ID_INFO_FLYOUT);
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
	 * 
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
	 * Called after validation is successful, when 'Save' or 'Update' action is triggered.
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
	 * Subclasses should override to provide additional page level validation. The default implementation returns
	 * 'true'.
	 * 
	 * @return
	 */
	protected boolean validate() {
		final boolean valid = true;
		return valid;
	}
}