package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;

/**
 * Controller Delegate
 * 
 * @author Hui(Spark) Wan
 * 
 */
public interface IControllerDelegate {

	/**
	 * Gets ridget container
	 * 
	 * @return
	 */
	public IRidgetContainer getRidgetContainer();

	/**
	 * Configure ridgets
	 */
	public void configureRidgets();

	/**
	 * Gets Ridget
	 * 
	 * @param <R>
	 *            Type
	 * @param ridgetClazz
	 *            Ridget class
	 * @param id
	 *            Bind id
	 * @return Ridget instance
	 */
	public <R extends IRidget> R getRidget(Class<R> ridgetClazz, String id);

}
