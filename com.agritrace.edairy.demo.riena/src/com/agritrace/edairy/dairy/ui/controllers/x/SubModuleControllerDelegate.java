package com.agritrace.edairy.dairy.ui.controllers.x;

import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IRidget;

/**
 * Default SubModuleController Delegate implementation
 * 
 * @author Hui(Spark) Wan
 *
 */
public abstract class SubModuleControllerDelegate implements
		ISubModuleControllerDelegate {

	private SubModuleController controller;

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
