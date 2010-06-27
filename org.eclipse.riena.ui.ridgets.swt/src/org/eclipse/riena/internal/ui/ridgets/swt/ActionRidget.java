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

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;

import org.eclipse.riena.ui.ridgets.swt.AbstractActionRidget;

public class ActionRidget extends AbstractActionRidget {

	private Button button;

	@Override
	public Button getUIControl() {
		return (Button) super.getUIControl();
	}

	@Override
	protected String getUIControlText() {
		return getUIControl().getText();
	}

	@Override
	protected void setUIControlText(String text) {
		getUIControl().setText(text);
	}

	@Override
	protected void setUIControlImage(Image image) {
		getUIControl().setImage(image);
	}

	@Override
	protected void checkUIControl(Object uiControl) {
		assertType(uiControl, Button.class);
	}

	@Override
	protected void bindUIControl() {
		Button control = getUIControl();
		if (control != null) {
			button = control;
			initText();
			button.addSelectionListener(actionObserver);
			updateUIText();
			updateUIIcon();
		}
	}

	@Override
	protected void unbindUIControl() {
		super.unbindUIControl();
		if (button != null) {
			button.removeSelectionListener(actionObserver);
			button = null;
		}
	}

}
