package com.agritrace.edairy.desktop.member.ui.controllers;

import org.eclipse.riena.ui.ridgets.controller.IController;

public interface WidgetController {
	
	public void configue();
	
	public Object getInputModel();
	
	public void setInputModel(Object model);
	
	public IController getController();
	
	public void setController(IController controller);
	
	public void updateBinding();

}
