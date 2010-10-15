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

import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.IStatuslineNumberRidget;
import org.eclipse.riena.ui.ridgets.IStatuslineRidget;
import org.eclipse.riena.ui.ridgets.IStatuslineUIProcessRidget;
import org.eclipse.riena.ui.ridgets.uibinding.IBindingPropertyLocator;
import org.eclipse.riena.ui.swt.Statusline;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;

/**
 * Ridget for the {@link Statusline}.
 */
public class StatuslineRidget extends AbstractCompositeRidget implements IStatuslineRidget {

	private final static String LONG_EMPTY_STRING = "            "; //$NON-NLS-1$

	private String message;
	private Image image;
	private IStatuslineNumberRidget statuslineNumberRidget;

	private IStatuslineUIProcessRidget statuslineUIProcessRidget;

	/**
	 * Creates a new instance of {@code StatuslineRidget}.
	 */
	public StatuslineRidget() {
		super();
		message = LONG_EMPTY_STRING;
	}

	@Override
	public Statusline getUIControl() {
		return (Statusline) super.getUIControl();
	}

	@Override
	protected void bindUIControl() {
		updateImage();
		updateMessage();
	}

	public void clear() {
		setImage(null);
		setMessage(LONG_EMPTY_STRING);
	}

	public void error(String message) {
		setImage(LnfManager.getLnf().getImage(LnfKeyConstants.STATUSLINE_ERROR_ICON));
		setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public IStatuslineNumberRidget getStatuslineNumberRidget() {
		return statuslineNumberRidget;
	}

	/**
	 * @param statuslineNumberRidget
	 *            the statuslineNumberRidget to set
	 */
	public void setStatuslineNumberRidget(IStatuslineNumberRidget statuslineNumberRidget) {
		this.statuslineNumberRidget = statuslineNumberRidget;
		addRidget(Statusline.SL_NUMBER_RIDGET_ID, statuslineNumberRidget);
	}

	public void setStatuslineUIProcessRidget(IStatuslineUIProcessRidget statuslineUIProcessRidget) {
		addRidget(Statusline.SL_UIPROCES_RIDGET_ID, statuslineUIProcessRidget);
		this.statuslineUIProcessRidget = statuslineUIProcessRidget;
	}

	public IStatuslineUIProcessRidget getStatuslineUIProcessRidget() {
		return statuslineUIProcessRidget;
	}

	public void info(String message) {
		setImage(LnfManager.getLnf().getImage(LnfKeyConstants.STATUSLINE_INFO_ICON));
		setMessage(message);
	}

	public void setMessage(String message) {
		if (message != null && !message.equals(this.message)) {
			this.message = message;
			updateMessage();
		}
	}

	public void warning(String message) {
		setImage(LnfManager.getLnf().getImage(LnfKeyConstants.STATUSLINE_WARNING_ICON));
		setMessage(message);
	}

	@Override
	public String getID() {
		IBindingPropertyLocator locator = SWTBindingPropertyLocator.getInstance();
		return locator.locateBindingProperty(getUIControl());
	}

	// helping methods
	//////////////////

	private void setImage(Image image) {
		if (this.image != image) {
			this.image = image;
			updateImage();
		}
	}

	private void updateImage() {
		Statusline control = getUIControl();
		if (control != null) {
			control.getMessageComposite().setImage(image);
		}
	}

	private void updateMessage() {
		Statusline control = getUIControl();
		if (control != null) {
			control.getMessageComposite().setMessage(message);
		}
	}

}
