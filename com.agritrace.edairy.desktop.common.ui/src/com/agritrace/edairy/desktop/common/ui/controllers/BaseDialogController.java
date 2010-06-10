package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.persistence.services.IRepository;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;

public abstract class BaseDialogController<T extends EObject> extends AbstractWindowController{

	protected T selected;
	protected IRepository<T> repository;

	public BaseDialogController() {
		super();
	}

	public IRepository<T> getRepository() {
		return repository;
	}

	public void setRepository(IRepository<T> repository) {
		this.repository = repository;
	}

	public T getWorkingCopy() {
		return selected;
	}

	public void setWorkingCopy(T selected) {
		this.selected = selected;
	}
		
	private boolean validateInternal() {
		boolean retVal = validate();  // user validation first...
		if (! retVal ) {
			return false;
		}
		
		return retVal;
	}
	
	protected boolean validate() {
		return true;
	}
	
	protected void handleSaveAction() {
		setReturnCode(DialogConstants.ACTION_SAVE);
		setContext("selected", getWorkingCopy());
		System.out.println("OK calling dispose");
		getWindowRidget().dispose();
	}
	
	protected void handleCancelAction() {
		setReturnCode(DialogConstants.ACTION_CANCEL);
		getWindowRidget().dispose();
	}
	
	protected void handleDeleteAction() {
		setReturnCode(DialogConstants.ACTION_DELETE);
		getWindowRidget().dispose();		
	}
	
	protected void configureButtonsPanel() {
		final IActionRidget okAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_SAVE);
		okAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				if ( ! validateInternal() ) {
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

}