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
package org.eclipse.riena.internal.ui.ridgets.swt;

import java.util.EventListener;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.swt.MarkerSupport;
import org.eclipse.riena.ui.swt.facades.SWTFacade;

/**
 * Responsible for Rendering the disabled state of any control.
 */
public class DisabledMarkerVisualizer {

	// the painter
	private static final EventListener DISABLED_MARKER_PAINTER = SWTFacade.getDefault().createDisabledPainter();
	// the ridget
	private final IRidget ridget;

	public DisabledMarkerVisualizer(IRidget ridget) {
		this.ridget = ridget;
	}

	/**
	 * This is the entry point for {@link MarkerSupport}
	 */
	public void updateDisabled() {
		updateDisabled(getControl(), getRidget().isEnabled());
	}

	private void updateDisabled(Control control, boolean enabled) {
		control.setEnabled(enabled);
		removePaintlistener(control);

		if (!enabled) {
			addPaintlistener(control);
		}

		if (control instanceof Composite) {
			Composite composite = (Composite) control;
			Control[] children = composite.getChildren();
			for (Control child : children) {
				updateDisabled(child, enabled);
			}
		}

		control.redraw();
	}

	/**
	 * Control connect and disconnect the Paintlistener.
	 */
	protected void removePaintlistener(Control control) {
		SWTFacade facade = SWTFacade.getDefault();
		facade.removePaintListener(control, DISABLED_MARKER_PAINTER);
	}

	protected void addPaintlistener(Control control) {
		SWTFacade facade = SWTFacade.getDefault();
		facade.addPaintListener(control, DISABLED_MARKER_PAINTER);
	}

	// helping methods
	//////////////////

	private Control getControl() {
		return (Control) getRidget().getUIControl();
	}

	private IRidget getRidget() {
		return ridget;
	}

}
