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

import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.ui.common.IComplexComponent;

/**
 * Visits each control, starting with the given {@composite} and recursively
 * continuing into each of it's children. The following rules apply:
 * <ul>
 * <li>{@link #handleControl(Control)} is invoked for every visited control</li>
 * <li>{@link #handleBoundControl(Control, String)} is invoked for every visited
 * control that has a binding property, unless {@link #skip(Control)} returns
 * true for that control</li>
 * <li>the visitor does not descent into controls that are an
 * {@link IComplexComponent}, since those are manage their contents autonomously
 * </li>
 * </ul>
 * Usage example:
 * 
 * <pre>
 * SWTControlFinder finder = new SWTControlFinder(composite) {
 * 	public void handleBoundControl(Control control, String bindingProperty) {
 * 		addUIControl(control, bindingProperty);
 * 	}
 * };
 * finder.run();
 * </pre>
 * 
 * @see visitor pattern
 * @since 2.0
 */
public abstract class SWTControlFinder {

	private Composite start;

	public SWTControlFinder(Composite composite) {
		Assert.isNotNull(composite);
		start = composite;
	}

	/**
	 * Visits all controls, starting with the {@code composite} designated in
	 * the constructor and recursively descending into each of it's children.
	 * <p>
	 * This method can only be called once.
	 * 
	 * @throws RuntimeException
	 *             if called more than once
	 */
	public void run() {
		if (start == null) {
			throw new IllegalStateException("cannot run more than once!"); //$NON-NLS-1$
		}
		addUIControls(start);
		start = null;
	}

	/**
	 * Returns true to skip calling {@link #handleBoundControl(Control, String)}
	 * for the given {@control}, false otherwise.
	 * <p>
	 * The default implementation always returns false. Subclasses may override.
	 * 
	 * @param control
	 *            the control; never null
	 */
	public boolean skip(Control control) {
		return false;
	}

	/**
	 * This method is invoked for every visited control.
	 * <p>
	 * Implementors may override, but <b>must</b> call super.
	 * 
	 * @param control
	 *            the control; never null
	 */
	public void handleControl(Control control) {
		if ((control instanceof Composite) && !(control instanceof IComplexComponent)) {
			addUIControls((Composite) control);
		}
	}

	/**
	 * This method is invoked for every bound control that is not skipped (see
	 * {@link #skip(Control)}).
	 * <p>
	 * Bound controls are those controls that have been assigned with a binding
	 * ID.
	 * 
	 * @param control
	 *            the control; never null
	 * @param bindingProperty
	 *            the binding ID for that control (a non-null, non-empty String)
	 */
	public abstract void handleBoundControl(Control control, String bindingProperty);

	// protected methods
	////////////////////

	private void addUIControls(Composite composite) {
		SWTBindingPropertyLocator locator = SWTBindingPropertyLocator.getInstance();
		for (Control control : composite.getChildren()) {
			String bindingProperty = locator.locateBindingProperty(control);
			if (StringUtils.isGiven(bindingProperty) && !skip(control)) {
				handleBoundControl(control, bindingProperty);
			}
			handleControl(control);
		}
	}
}
