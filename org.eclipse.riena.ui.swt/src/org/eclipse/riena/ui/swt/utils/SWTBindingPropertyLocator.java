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
package org.eclipse.riena.ui.swt.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.log.LogService;

import org.eclipse.equinox.log.Logger;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.internal.ui.swt.Activator;
import org.eclipse.riena.ui.common.IComplexComponent;
import org.eclipse.riena.ui.ridgets.uibinding.IBindingPropertyLocator;

/**
 * Helper class to get the ID of a SWT UI control used for binding.
 */
public final class SWTBindingPropertyLocator implements IBindingPropertyLocator {

	/**
	 * Key to retrieve a control's binding property.
	 * <p>
	 * That value (String) will also be assigned to the Ridget that is paired to
	 * the control.
	 */
	public final static String BINDING_PROPERTY = "binding_property"; //$NON-NLS-1$

	private static SWTBindingPropertyLocator locator;

	private SWTBindingPropertyLocator() {
		// prevent instantiation
	}

	/**
	 * Returns an instance of this class.
	 * 
	 * @return
	 */
	public static SWTBindingPropertyLocator getInstance() {
		if (locator == null) {
			locator = new SWTBindingPropertyLocator();
		}
		return locator;
	}

	/**
	 * Returns all bounds controls in the given composite and it's children.
	 * 
	 * @param composite
	 *            a Composite instance; never null
	 * @return a List of bounds Controls (exluding composite); never null; may
	 *         be empty. Will not continue into {@link IComplexComponent}s - as
	 *         they are repsonsible for they own children.
	 * @since 1.2
	 */
	public static List<Object> getControlsWithBindingProperty(Composite composite) {
		final Map<String, Object> id2control = new HashMap<String, Object>();
		SWTControlFinder finder = new SWTControlFinder(composite) {
			@Override
			public void handleBoundControl(Control control, String bindingProperty) {
				if (id2control.containsKey(bindingProperty)) {
					String format = "conflict: control with id '%s' already defined: %s, %s"; //$NON-NLS-1$
					String msg = String.format(format, bindingProperty, id2control.get(bindingProperty), control);
					throw new RuntimeException(msg);
				}
				id2control.put(bindingProperty, control);
			}
		};
		finder.run();
		return new ArrayList<Object>(id2control.values());
	}

	/**
	 * Returns true if the given UI control has a binding property, false
	 * otherwise.
	 * 
	 * @param uiControl
	 *            UI control; may be null
	 * @since 2.0
	 */
	public boolean hasBindingProperty(Object uiControl) {
		String prop = locateBindingProperty(uiControl);
		return !StringUtils.isDeepEmpty(prop);
	}

	public String locateBindingProperty(Object uiControl) {
		String result = null;
		if (uiControl instanceof Widget) {
			Widget widget = (Widget) uiControl;
			if (!widget.isDisposed()) {
				result = (String) widget.getData(BINDING_PROPERTY);
			}
		} else if (uiControl instanceof IPropertyNameProvider) {
			result = ((IPropertyNameProvider) uiControl).getPropertyName();
		}
		return result;
	}

	/**
	 * Set the ID (binding property) for the given {@code uiControl}.
	 * 
	 * @param uiControl
	 *            an instanceof {@link Widget} or {@link IPropertyNameProvider}
	 * @param id
	 *            the binding property; never null; must not be empty.The given
	 *            value will also be assigned to the Ridget that is paired to
	 *            the control.
	 */
	public void setBindingProperty(Object uiControl, String id) {
		if (uiControl instanceof Widget) {
			Widget widget = (Widget) uiControl;
			if (widget.isDisposed()) {
				return;
			}
			widget.setData(BINDING_PROPERTY, id);
		} else if (uiControl instanceof IPropertyNameProvider) {
			((IPropertyNameProvider) uiControl).setPropertyName(id);
		} else {
			Logger log = Log4r.getLogger(Activator.getDefault(), SWTBindingPropertyLocator.class);
			String className = uiControl != null ? uiControl.getClass().getName() : "null"; //$NON-NLS-1$
			String msg = String.format("Failed to set binding property '%s' for %s", id, className); //$NON-NLS-1$
			log.log(LogService.LOG_WARNING, msg);
		}
	}

}
