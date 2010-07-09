package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.riena.ui.ridgets.controller.IController;

public interface WidgetController<T extends Object> {

	public void configure();

	public IController getController();

	public T getInputModel();

	public void setController(IController controller);

	public void setInputModel(T model);

	public void updateBinding();

}
