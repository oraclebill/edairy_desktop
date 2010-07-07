package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.riena.ui.ridgets.controller.IController;

public interface WidgetController {

	public void configure();

	public IController getController();

	public Object getInputModel();

	public void setController(IController controller);

	public void setInputModel(Object model);

	public void updateBinding();

}
