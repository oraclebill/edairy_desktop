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
package org.eclipse.riena.ui.ridgets.swt.uibinding;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.uibinding.DefaultBindingManager;
import org.eclipse.riena.ui.ridgets.uibinding.IBindingManager;
import org.eclipse.riena.ui.ridgets.uibinding.IBindingPropertyLocator;
import org.eclipse.riena.ui.ridgets.uibinding.IControlRidgetMapper;

/**
 * A delegate for the binding of view (UI controls) and controller (Ridgets).
 */
public abstract class AbstractViewBindingDelegate {

	private List<Object> uiControls;

	private IBindingManager bindingManager;

	public AbstractViewBindingDelegate(IBindingPropertyLocator propertyStrategy, IControlRidgetMapper<Object> mapper) {
		bindingManager = createBindingManager(propertyStrategy, mapper);
		uiControls = new ArrayList<Object>();
	}

	/**
	 * Creates the manager for the binding.
	 * 
	 * @return binding manager
	 */
	protected IBindingManager createBindingManager(IBindingPropertyLocator propertyStrategy,
			IControlRidgetMapper<Object> mapper) {
		return new DefaultBindingManager(propertyStrategy, mapper);
	}

	/**
	 * Adds the given control to the list of the controls that will be binded.
	 * Note: Only widgets that are not already added are added to the list.
	 * 
	 * @param uiControl
	 *            control to bind
	 */
	public void addUIControl(Object uiControl) {
		if (!uiControls.contains(uiControl)) {
			uiControls.add(uiControl);
		}
	}

	/**
	 * Adds the given control to the list of the controls that will be bound.
	 * 
	 * @param uiControl
	 *            control to bind
	 * @param bindingId
	 *            ID for binding
	 */
	public void addUIControl(Object uiControl, String bindingId) {
		addUIControl(uiControl);
	}

	/**
	 * Injects and binds UI controls to their ridgets in the controller.
	 * 
	 * @param controller
	 *            The controller which gets the ridgets injected.
	 */
	public void injectAndBind(IController controller) {
		injectRidgets(controller);
		bind(controller);
	}

	/**
	 * Injects the mapped ridgets for the uiControls in the controller.
	 * 
	 * @param controller
	 *            The controller which gets the ridgets injected.
	 */
	public void injectRidgets(IController controller) {
		bindingManager.injectRidgets(controller, uiControls);
	}

	/**
	 * Binds UI controls to their ridgets in the controller.
	 * 
	 * @param controller
	 *            The controller which holds the ridgets.
	 */
	public void bind(IController controller) {
		bindingManager.bind(controller, uiControls);
	}

	/**
	 * Unbinds UI controls from their ridgets in the controller.
	 * 
	 * @param controller
	 *            The controller which holds the ridgets.
	 */
	public void unbind(IController controller) {
		bindingManager.unbind(controller, uiControls);
	}

}
