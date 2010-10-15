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
package org.eclipse.riena.ui.ridgets.swt;

import java.beans.PropertyChangeSupport;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Table;

import org.eclipse.riena.internal.ui.ridgets.swt.DisabledMarkerVisualizer;
import org.eclipse.riena.ui.ridgets.AbstractMarkerSupport;
import org.eclipse.riena.ui.ridgets.IBasicMarkableRidget;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;

/**
 * Helper class for Ridgets to delegate their marker issues to that just handles
 * the basic markers for uneditable Ridgets: the HiddenMarker to toggle
 * visibility and the DisabledMarker that toggles the enabled state.
 */
public class BasicMarkerSupport extends AbstractMarkerSupport {

	private static boolean alwaysSkipRedraw = false;
	private static boolean osChecked = false;
	private DisabledMarkerVisualizer disabledMarkerVisualizer;

	public BasicMarkerSupport() {
		super();
	}

	public BasicMarkerSupport(IBasicMarkableRidget ridget, PropertyChangeSupport propertyChangeSupport) {
		super(ridget, propertyChangeSupport);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(final IBasicMarkableRidget ridget, PropertyChangeSupport propertyChangeSupport) {

		super.init(ridget, propertyChangeSupport);

		Control control = getUIControl();
		if (control != null) {
			control.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					Control control = getUIControl();
					if (e.widget == control) {
						// workaround for Bug 304869
						if (!(control instanceof CCombo)) {
							clearAllMarkers(control);
						}
					}
				}
			});
		}

		// workaround for 272863
		if (!osChecked) {
			osChecked = true;
			String osname = System.getProperty("org.osgi.framework.os.name"); //$NON-NLS-1$
			if (osname != null && osname.equalsIgnoreCase("macosx")) { //$NON-NLS-1$
				alwaysSkipRedraw = true;
			}
		}

		createDisabledMarkerVisualizer();

	}

	/**
	 * Does nothing. Subclasses may override.
	 * 
	 * @param control
	 *            the control
	 */
	protected void clearAllMarkers(Control control) {
		// does nothing
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control getUIControl() {
		return (Control) super.getUIControl();
	}

	private void createDisabledMarkerVisualizer() {
		this.disabledMarkerVisualizer = new DisabledMarkerVisualizer(getRidget());
	}

	protected DisabledMarkerVisualizer getDisabledMarkerVisualizer() {
		return disabledMarkerVisualizer;
	}

	@Override
	public void updateMarkers() {
		updateUIControl();
	}

	@Override
	protected void handleMarkerAttributesChanged() {
		updateUIControl();
		super.handleMarkerAttributesChanged();
	}

	private void updateUIControl() {
		Control control = getUIControl();
		if (control != null) {
			stopRedraw(control);
			try {
				updateUIControl(control);
			} finally {
				startRedraw(control);
			}
		}
	}

	protected void updateUIControl(Control control) {
		updateVisible(control);
		updateDisabled(control);
	}

	protected void updateVisible(Control control) {
		control.setVisible(!hasHiddenMarkers());
	}

	protected void updateDisabled(Control control) {
		boolean on = LnfManager.getLnf().getBooleanSetting(LnfKeyConstants.DISABLED_MARKER_ADVANCED);
		if (on) {
			// delegate to the visualizer for rendering
			getDisabledMarkerVisualizer().updateDisabled();
		} else {
			control.setEnabled(getRidget().isEnabled());
		}
	}

	private void startRedraw(Control control) {
		if (!skipRedrawForBug258176(control)) {
			control.setRedraw(true);
		}
		control.redraw();
	}

	private void stopRedraw(Control control) {
		if (!skipRedrawForBug258176(control)) {
			control.setRedraw(false);
		}
	}

	/**
	 * These controls are affected by bug 258176 in SWT.
	 */
	private boolean skipRedrawForBug258176(Control control) {
		if (alwaysSkipRedraw) {
			return true;
		}
		return (control instanceof Combo) || (control instanceof Table) || (control instanceof List);
	}

}
