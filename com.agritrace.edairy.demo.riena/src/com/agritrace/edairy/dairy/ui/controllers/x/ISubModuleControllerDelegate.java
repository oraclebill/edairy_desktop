package com.agritrace.edairy.dairy.ui.controllers.x;

import org.eclipse.riena.ui.ridgets.IRidget;

/**
 * SubModelue Controller Delegate
 * 
 * @author Hui(Spark) Wan
 *
 */
public interface ISubModuleControllerDelegate {

	/**
	 * Configure reidgets
	 */
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

	/**
	 * Fire the listener
	 * 
	 * @param eventType Event type
	 */
	public void fireListener(int eventType);

}
