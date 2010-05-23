package com.agritrace.edairy.desktop.member.ui.controllers;

import org.eclipse.riena.navigation.ui.controllers.SubModuleController;

public interface WidgetController {
	
	public void configue();
	
	public Object getInputModel();
	
	public void setInputModel(Object model);
	
	public SubModuleController getSubModuleController();
	
	public void setSubModuleController(SubModuleController controller);
	
	public void updateBinding();

}
