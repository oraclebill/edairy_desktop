package com.agritrace.edairy.desktop.member.ui.controllers;

import org.eclipse.riena.navigation.ui.controllers.SubModuleController;

public abstract class BaseListViewController extends SubModuleController{
	@Override
	public void configureRidgets() {
		configureFilterGroup();
		configureListGroup();

	}
	
	protected abstract void configureFilterGroup();
	
	protected abstract void configureListGroup();

}
