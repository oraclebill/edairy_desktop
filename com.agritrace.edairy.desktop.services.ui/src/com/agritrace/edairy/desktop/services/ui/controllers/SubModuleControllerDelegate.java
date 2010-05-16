package com.agritrace.edairy.desktop.services.ui.controllers;

import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IRidget;

/**
 * Default SubModuleController Delegate implementation
 * 
 * @author Hui(Spark) Wan
 * 
 */
public abstract class SubModuleControllerDelegate implements ISubModuleControllerDelegate {

    private final SubModuleController controller;

    public SubModuleControllerDelegate(SubModuleController controller) {
	super();
	this.controller = controller;
    }

    @Override
    public <R extends IRidget> R getRidget(Class<R> ridgetClazz, String id) {
	return this.getSubModuleController().getRidget(ridgetClazz, id);
    }

    public SubModuleController getSubModuleController() {
	return this.controller;
    }

}
