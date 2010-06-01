package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.persistence.services.IRepository;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public abstract class BaseDialogController<T extends EObject> extends AbstractWindowController {

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

	protected void configureButtonsPanel() {
		final IActionRidget okAction = (IActionRidget) getRidget(ViewWidgetId.memberInfo_saveButton);
		okAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				setReturnCode(OK);
				setContext("selected", selected);
				getWindowRidget().dispose();
			}
		});

		final IActionRidget cancelAction = (IActionRidget) getRidget(ViewWidgetId.memberInfo_cacelButton);
		cancelAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				setReturnCode(CANCEL);
				getWindowRidget().dispose();
			}
		});

		final IActionRidget deleteAction = (IActionRidget) getRidget(ViewWidgetId.deleteButton);
		deleteAction.setVisible(false);
		deleteAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				setReturnCode(2);
				getWindowRidget().dispose();
			}
		});
	}

	public T getSelected() {
		return selected;
	}

	public void setSelected(T selected) {
		this.selected = selected;
	}

}