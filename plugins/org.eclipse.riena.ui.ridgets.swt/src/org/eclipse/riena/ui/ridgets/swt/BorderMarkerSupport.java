/*******************************************************************************
 * Copyright (c) 2007, 2010 compeople AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    compeople AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.riena.ui.ridgets.swt;

import java.beans.PropertyChangeSupport;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Control;

import org.eclipse.riena.ui.ridgets.IBasicMarkableRidget;
import org.eclipse.riena.ui.swt.BorderControlDecoration;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.lnf.rienadefault.RienaDefaultLnf;

/**
 * This class decorates a UI control that has an {@code ErrorMarker} with a
 * border around the UI control.
 * 
 * @since 2.0
 */
public class BorderMarkerSupport extends MarkerSupport {

	private BorderControlDecoration errorDecoration;

	/**
	 * Creates a new instance of {@code BorderMarkerSupport}.
	 */
	public BorderMarkerSupport() {
		super();
	}

	/**
	 * Creates a new instance of {@code BorderMarkerSupport}.
	 * 
	 * @param ridget
	 *            the Ridget whose markers should be visualized
	 * @param propertyChangeSupport
	 *            this will be informed if a marker has changed
	 */
	public BorderMarkerSupport(IBasicMarkableRidget ridget, PropertyChangeSupport propertyChangeSupport) {
		super(ridget, propertyChangeSupport);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addError(Control control) {
		if (errorDecoration == null) {
			errorDecoration = createErrorDecoration(control);
			control.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					errorDecoration.dispose();
				}
			});
		}
		errorDecoration.show();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void clearError(Control control) {
		if (errorDecoration != null) {
			errorDecoration.hide();
		}
	}

	/**
	 * Creates a decoration with an error marker for the given control.
	 * <p>
	 * The decoration draws a border a round the UI control.
	 * 
	 * @param control
	 *            the control to be decorated with an error marker
	 * @return decoration of the given control
	 */
	protected BorderControlDecoration createErrorDecoration(Control control) {
		RienaDefaultLnf lnf = LnfManager.getLnf();
		int width = lnf.getIntegerSetting(LnfKeyConstants.ERROR_MARKER_BORDER_WIDTH, 1);
		Color borderColor = lnf.getColor(LnfKeyConstants.ERROR_MARKER_BORDER_COLOR);
		BorderControlDecoration ctrlDecoration = new BorderControlDecoration(control, width, borderColor);
		return ctrlDecoration;
	}

}
