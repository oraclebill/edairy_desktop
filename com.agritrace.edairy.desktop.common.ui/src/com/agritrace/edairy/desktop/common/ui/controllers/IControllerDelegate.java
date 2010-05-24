package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;

public interface IControllerDelegate {

	public IRidgetContainer getRidgetContainer();

	public void configureRidgets();

	/**
	 * Gets Ridget
	 * 
	 * @param <R>
	 * @param ridgetClazz
	 * @param id
	 * @return
	 */
	public <R extends IRidget> R getRidget(Class<R> ridgetClazz, String id);

}
