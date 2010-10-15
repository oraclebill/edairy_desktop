/*******************************************************************************
 * Copyright © 2009 Florian Pirchner and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Florian Pirchner – initial API and implementation (based on other ridgets of 
 *                    compeople AG)
 * compeople AG     - adjustments for Riena v1.2
 *******************************************************************************/
package org.eclipse.riena.internal.ui.ridgets.swt;

import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Scale;

import org.eclipse.riena.ui.ridgets.ITraverseRidget;
import org.eclipse.riena.ui.ridgets.swt.AbstractSWTRidget;

/**
 * Ridget for a SWT {@link Scale} widget.
 * 
 * @since 1.2
 */
public class ScaleRidget extends AbstractTraverseRidget implements ITraverseRidget {

	@Override
	public Scale getUIControl() {
		return (Scale) super.getUIControl();
	}

	@Override
	public void checkUIControl(Object uiControl) {
		AbstractSWTRidget.assertType(uiControl, Scale.class);
	}

	// helping methods
	// ////////////////

	@Override
	protected void addSelectionListener(Control control, SelectionListener listener) {
		((Scale) control).addSelectionListener(listener);
	}

	@Override
	protected int getValue(Control control) {
		return getUIControl() != null ? getUIControl().getSelection() : 0;
	}

	@Override
	protected void initAdditionalsFromUIControl() {
		// nothing to do
	}

	@Override
	protected void removeSelectionListener(Control control, SelectionListener listener) {
		((Scale) control).removeSelectionListener(listener);
	}

	@Override
	protected void updateUIIncrement() {
		Scale control = getUIControl();
		if (control != null) {
			control.setIncrement(getIncrement());
		}
	}

	@Override
	protected void updateUIMaximum() {
		Scale control = getUIControl();
		if (control != null) {
			control.setMaximum(getMaximum());
		}
	}

	@Override
	protected void updateUIMinimum() {
		Scale control = getUIControl();
		if (control != null) {
			control.setMinimum(getMinimum());
		}
	}

	@Override
	protected void updateUIPageIncrement() {
		Scale control = getUIControl();
		if (control != null) {
			control.setPageIncrement(getPageIncrement());
		}
	}

	@Override
	protected void updateUIValue() {
		Scale control = getUIControl();
		if (control != null) {
			control.setSelection(getValue());
		}
	}

	@Override
	protected int getUIControlIncrement() {
		return getUIControl().getIncrement();
	}

	@Override
	protected int getUIControlMaximum() {
		return getUIControl().getMaximum();
	}

	@Override
	protected int getUIControlMinimum() {
		return getUIControl().getMinimum();
	}

	@Override
	protected int getUIControlPageIncrement() {
		return getUIControl().getPageIncrement();
	}

	@Override
	protected int getUIControlSelection() {
		return getUIControl().getSelection();
	}

}