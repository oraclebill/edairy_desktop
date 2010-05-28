package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;

/**
 * Abstract implementation for <code>IControllerDelegate</code>
 * 
 * @author Hui(Spark) Wan
 *
 */
public abstract class ControllerDelegate implements IControllerDelegate {

	public ControllerDelegate(IRidgetContainer container) {
		this.ridgetContainer = container;
	}

	private IRidgetContainer ridgetContainer;

	@Override
	public IRidgetContainer getRidgetContainer() {
		return this.ridgetContainer;
	}

	@Override
	public abstract void configureRidgets();

	@Override
	public <R extends IRidget> R getRidget(Class<R> ridgetClazz, String id) {
		if (this.ridgetContainer != null) {
			return this.ridgetContainer.getRidget(ridgetClazz, id);
		}
		return null;
	}

}
