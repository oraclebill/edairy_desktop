package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.ui.controllers.util.BindingHelper;

public abstract class AbstractDetailPanelController<T extends EObject> {
	private IRidgetContainer container;
	private BindingHelper<T> mapper;
	private T model;

	public void checkValid() {

	}

	public void configureAndBind() {
		if (container == null) {
			throw new IllegalStateException("RidgetContainer must be set before configureAndBind");
		}

		if (model == null) {
			throw new IllegalStateException("Model must be set before configureAndBind");
		}

		createMapper();
		bindRidgets();
		bindMappedRidgets();
	}

	
	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	public IRidgetContainer getRidgetContainer() {
		return container;
	}

	public <R extends IRidget> R getRidget(Class<R> ridgetClazz, String id) {
		return container.getRidget(ridgetClazz, id);
	}

	public void setRidgetContainer(IRidgetContainer container) {
		this.container = container;
	}

	private void bindMappedRidgets() {
		mapper.configureRidgets();
	}

	private void createMapper() {
		mapper = new BindingHelper<T>(container, model);
	}

	protected BindingHelper<T> getMapper() {
		return mapper;
	}

	protected abstract void bindRidgets();

	protected void enableMandatoryRidget(IRidget ridget, boolean enabled) {
		ridget.setEnabled(enabled);

		if (ridget instanceof ITextRidget) {
			final ITextRidget editable = (ITextRidget) ridget;
			editable.setMandatory(enabled);
		} else if (ridget instanceof IComboRidget) {
			final IComboRidget editable = (IComboRidget) ridget;
			editable.setMandatory(enabled);
		}
		// else if (ridget instanceof ILabelRidget) {
		// ILabelRidget editable = (ILabelRidget) ridget;
		// }
	}

}