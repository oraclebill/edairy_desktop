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

import org.eclipse.swt.widgets.Composite;

import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.ICompositeRidget;
import org.eclipse.riena.ui.ridgets.swt.AbstractSWTRidget;

/**
 * Ridget for an SWT {@link Composite}.
 */
public class CompositeRidget extends AbstractCompositeRidget implements ICompositeRidget {

	public void layout() {
		Composite control = getUIControl();
		if (control != null) {
			control.layout(true, true);
		}
	}

	@Override
	public Composite getUIControl() {
		return (Composite) super.getUIControl();
	}

	// protected methods
	////////////////////

	@Override
	protected void checkUIControl(Object uiControl) {
		AbstractSWTRidget.assertType(uiControl, Composite.class);
	}

	@Override
	protected boolean isUIControlVisible() {
		return getUIControl().isVisible();
	}

	@Override
	protected void updateEnabled() {
		Composite control = getUIControl();
		if (control != null) {
			control.setEnabled(isEnabled());
		}
	}

	@Override
	protected void updateToolTipText() {
		Composite control = getUIControl();
		if (control != null) {
			control.setToolTipText(getToolTipText());
		}
	}

	@Override
	protected void updateVisible() {
		Composite control = getUIControl();
		if (control != null) {
			control.setVisible(!isMarkedHidden());
		}
	}
}
