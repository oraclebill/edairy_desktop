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
package org.eclipse.riena.ui.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SwtUtilities;

/**
 * Represents a label of the status line that displays a message.
 */
public class StatuslineMessage extends AbstractStatuslineComposite {

	private CLabel messageLabel;

	/**
	 * Creates a new instance of <code>StatuslineMessage</code>.
	 * 
	 * @param parent
	 *            a widget which will be the parent of the new instance
	 *            (cannot be null)
	 * @param style
	 *            the style of widget to construct
	 */
	public StatuslineMessage(Composite parent, int style) {
		super(parent, style | SWT.NO_FOCUS);
	}

	/**
	 * @see org.eclipse.riena.ui.swt.AbstractStatuslineComposite#createContents()
	 */
	@Override
	protected void createContents() {

		messageLabel = new CLabel(this, SWT.LEFT);
		messageLabel.setText(" "); //$NON-NLS-1$
		messageLabel.setImage(getPlaceholderImage());
		messageLabel.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.STATUSLINE_BACKGROUND));

	}

	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {

		super.dispose();

		SwtUtilities.disposeWidget(messageLabel);

	}

	/**
	 * Sets the given image.
	 * 
	 * @param image
	 *            the image to set.
	 */
	public void setImage(Image image) {
		messageLabel.setImage(image);
	}

	/**
	 * Sets the given message.
	 * 
	 * @param msg
	 *            the message to set.
	 */
	public void setMessage(String msg) {
		messageLabel.setText(msg);
		messageLabel.getParent().layout(true);
	}

	/**
	 * Returns the placeholder image.
	 * 
	 * @return image
	 */
	private Image getPlaceholderImage() {
		return LnfManager.getLnf().getImage(LnfKeyConstants.STATUSLINE_SPACER_ICON);
	}

}
