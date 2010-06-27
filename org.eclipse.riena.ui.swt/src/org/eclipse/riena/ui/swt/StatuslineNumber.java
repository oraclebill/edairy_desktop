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
import org.eclipse.swt.widgets.Composite;

import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SwtUtilities;

/**
 * Represents a label of the status line that displays a number (7-digit).
 */
public class StatuslineNumber extends AbstractStatuslineComposite {

	private NumberLabel numberLabel;

	/**
	 * Creates a new instance of <code>StatuslineNumber</code>.
	 * 
	 * @param parent
	 *            a widget which will be the parent of the new instance (cannot
	 *            be null)
	 * @param style
	 *            the style of widget to construct
	 */
	public StatuslineNumber(Composite parent, int style) {
		super(parent, style | SWT.NO_FOCUS);
	}

	/**
	 * @see org.eclipse.riena.ui.swt.AbstractStatuslineComposite#createContents()
	 */
	@Override
	protected void createContents() {

		numberLabel = new NumberLabel(this, SWT.LEFT);
		numberLabel.setFixWidth(getFixWidthLabel());
		numberLabel.setText("0000000"); //$NON-NLS-1$
		numberLabel.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.STATUSLINE_BACKGROUND));
	}

	/**
	 * Override this method to have fixed width of the label
	 * 
	 * @return the fixed with
	 * @since 1.2
	 */
	protected int getFixWidthLabel() {
		return SWT.NONE;
	}

	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {

		super.dispose();

		SwtUtilities.disposeWidget(numberLabel);

	}

	/**
	 * Sets a number, that will be display in the status line. <br>
	 * If the number is greater 0, the number gets leading 0. Otherwise the
	 * number is not displayed.
	 * 
	 * @param number
	 *            number to display in the status line.
	 */
	public void setNumber(int number) {

		if (number <= 0) {
			numberLabel.setText(""); //$NON-NLS-1$
			return;
		}

		String numberStrg = Integer.toString(number);
		// add leading '0'
		StringBuilder sb = new StringBuilder(numberStrg);
		while (sb.length() < 7) {
			sb.insert(0, '0');
		}
		numberLabel.setText(sb.toString());

	}

	/**
	 * Sets the given "number", that will be display in the status line.
	 * 
	 * @param number
	 *            the string to displayed in the status line; null removes the
	 *            number string from the status line
	 */
	public void setNumber(String number) {

		if (number != null) {
			numberLabel.setText(number);
		} else {
			numberLabel.setText(""); //$NON-NLS-1$
		}

	}

}
