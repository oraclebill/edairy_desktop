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

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.Assert;

import org.eclipse.riena.core.util.ReflectionFailure;
import org.eclipse.riena.core.util.ReflectionUtils;
import org.eclipse.riena.core.wire.Wire;
import org.eclipse.riena.internal.ui.ridgets.Activator;
import org.eclipse.riena.ui.common.IComplexComponent;
import org.eclipse.riena.ui.ridgets.IComplexRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;

/**
 * This class manages the binding between UI-control and ridget. In contrast to
 * the {@link InjectBindingManager} which calls a setter method for each ridget
 * immediately after ridget creation and addition to the
 * {@link IRidgetContainer} managed ridget collection this
 * {@link IBindingManager} implementation only calls the method
 * {@link IInjectAllRidgets#configureRidgets()} once. Therefore the
 * {@link IRidgetContainer} is required to interface {@link IInjectAllRidgets}
 * if using this binding policy. The binding policy is configured in the view to
 * be bound.
 */
public class DefaultBindingManager implements IBindingManager {

	private IBindingPropertyLocator propertyStrategy;
	private IControlRidgetMapper<Object> mapper;

	/**
	 * Creates the managers of all bindings of a view.
	 * 
	 * @param propertyStrategy
	 *            strategy to get the property for the binding from the
	 *            UI-control.
	 * @param mapper
	 *            mapping for UI control-classes to ridget-classes
	 */
	public DefaultBindingManager(IBindingPropertyLocator propertyStrategy, IControlRidgetMapper<Object> mapper) {
		this.propertyStrategy = propertyStrategy;
		this.mapper = mapper;
	}

	public void injectRidgets(IRidgetContainer ridgetContainer, List<Object> uiControls) {
		CorrespondingLabelMapper ridgetMapper = new CorrespondingLabelMapper(ridgetContainer);
		if (Activator.getDefault() != null) {
			Wire.instance(ridgetMapper).andStart(Activator.getDefault().getContext());
		}

		Map<String, IRidget> controls = new HashMap<String, IRidget>();

		for (Object control : uiControls) {
			String bindingProperty = propertyStrategy.locateBindingProperty(control);
			if (bindingProperty != null) {
				IRidget ridget = createRidget(control);
				injectRidget(ridgetContainer, bindingProperty, ridget);

				//because the ridgets are not bound yet, we have to save the bindingProperty separately
				if (!(ridget instanceof ILabelRidget)) {
					controls.put(bindingProperty, ridget);
				}

				if (control instanceof IComplexComponent) {
					IComplexRidget complexRidget = (IComplexRidget) ridget;
					IComplexComponent complexComponent = (IComplexComponent) control;
					injectRidgets(complexRidget, complexComponent.getUIControls());
				}
			}
		}

		// iterate over all controls that are not ILabelRidgets and try to connect 
		// them with their corresponding Label
		Iterator<Entry<String, IRidget>> it = controls.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, IRidget> entry = it.next();
			ridgetMapper.connectCorrespondingLabel(entry.getValue(), entry.getKey());
		}

		if (Activator.getDefault() != null) {
			// TODO This unveils a weakness of the wiring stuff because the dependency (to the wiring) is just moved the ridget containers to here :-(
			Wire.instance(ridgetContainer).andStart(Activator.getDefault().getContext());
		}

		ridgetContainer.configureRidgets();
	}

	/**
	 * Injects the given ridget into the given container.<br>
	 * Adds the ridget to the container.
	 * 
	 * @param ridgetContainer
	 * @param bindingProperty
	 * @param ridget
	 *            ridget to inject
	 */
	protected void injectRidget(IRidgetContainer ridgetContainer, String bindingProperty, IRidget ridget) {
		ridgetContainer.addRidget(bindingProperty, ridget);
	}

	/**
	 * Creates for the given UI-control the appropriate ridget.
	 * 
	 * @param control
	 *            UI-control
	 * @return ridget
	 * @throws ReflectionFailure
	 */
	public IRidget createRidget(Object control) throws ReflectionFailure {
		Class<? extends IRidget> ridgetClass = mapper.getRidgetClass(control);
		return ReflectionUtils.newInstance(ridgetClass);
	}

	/**
	 * Returns form the given ridget container the ridget with the given
	 * property value.
	 * 
	 * @param bindingProperty
	 *            value of the binding property
	 * @param controller
	 *            ridget container
	 * @return ridget
	 */
	protected IRidget getRidget(String bindingProperty, IRidgetContainer controller) {
		return controller.getRidget(bindingProperty);
	}

	/**
	 * @see org.eclipse.riena.ui.internal.ridgets.uibinding.IBindingManager#bind(IRidgetContainer,
	 *      java.util.List)
	 */
	public void bind(IRidgetContainer controller, List<Object> uiControls) {
		updateBindings(controller, uiControls, false);
	}

	/**
	 * @see org.eclipse.riena.ui.internal.ridgets.uibinding.IBindingManager#unbind(IRidgetContainer,
	 *      java.util.List)
	 */
	public void unbind(IRidgetContainer controller, List<Object> uiControls) {
		updateBindings(controller, uiControls, true);
	}

	private void updateBindings(IRidgetContainer controller, List<Object> uiControls, boolean unbind) {

		for (Object control : uiControls) {
			if (control instanceof IComplexComponent) {
				IComplexComponent complexComponent = (IComplexComponent) control;
				String bindingProperty = propertyStrategy.locateBindingProperty(control);
				IComplexRidget complexRidget = (IComplexRidget) getRidget(bindingProperty, controller);
				updateBindings(complexRidget, complexComponent.getUIControls(), unbind);
				if (complexRidget != null) {
					bindRidget(complexRidget, complexComponent, unbind);
				}
			} else {
				String bindingProperty = propertyStrategy.locateBindingProperty(control);
				if (bindingProperty != null) {
					IRidget ridget = getRidget(bindingProperty, controller);
					Assert.isNotNull(ridget, "Null ridget for property: " + bindingProperty); //$NON-NLS-1$
					bindRidget(ridget, control, unbind);
				}
			}
		}
	}

	private void bindRidget(IRidget ridget, Object uiControl, boolean unbind) {

		if (unbind) {
			ridget.setUIControl(null);
		} else {
			ridget.setUIControl(uiControl);
		}
	}

}
