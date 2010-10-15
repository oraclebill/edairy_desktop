/*******************************************************************************
 * Copyright (c) 2007, 2009 compeople AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    compeople AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.riena.ui.ridgets.uibinding;

import java.util.List;

import org.eclipse.riena.core.util.ReflectionFailure;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;

/**
 * Views use implementations of this interface to bind their Ridgets.
 */
public interface IBindingManager {

	/**
	 * Injects the mapped ridgets for the uiControls in the controller.
	 * 
	 * @param controller
	 *            The controller which gets the ridgets injected.
	 * @param uiControls
	 *            The uiControls which will get mapped to ridgets.
	 */
	void injectRidgets(IRidgetContainer controller, List<Object> uiControls);

	/**
	 * Binds uiControls to their ridgets in the controller.
	 * 
	 * @param controller
	 *            The controller which holds the ridgets.
	 * @param uiControls
	 *            The uiControls which will be bound to the ridgets.
	 */
	void bind(IRidgetContainer controller, List<Object> uiControls);

	/**
	 * Unbinds uiControls from their ridgets in the controller.
	 * 
	 * @param controller
	 *            The controller which holds the ridgets.
	 * @param uiControls
	 *            The uiControls which will be unbound from the ridgets.
	 */
	void unbind(IRidgetContainer controller, List<Object> uiControls);

	/**
	 * Creates for the given UI-control the appropriate ridget.
	 * 
	 * @param control
	 *            UI-control
	 * @throws ReflectionFailure
	 */
	IRidget createRidget(Object control);

}
