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

import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SwtUtilities;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * Spacer or separator between the composites of the status line.
 */
public class StatuslineSpacer extends AbstractStatuslineComposite {

	private static final int TOP_BOTTOM_MARGIN = 3;

	private Label separator;

	/**
	 * @param parent
	 * @param style
	 */
	public StatuslineSpacer(Composite parent, int style) {
		super(parent, style | SWT.NO_FOCUS);

	}

	/**
	 * Creates the contents of spacer composite of the status line.
	 */
	@Override
	protected void createContents() {

		separator = new Label(this, SWT.SEPARATOR | SWT.VERTICAL);
		separator.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.STATUSLINE_BACKGROUND));
	}

	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {

		super.dispose();

		SwtUtilities.disposeWidget(separator);

	}

	/**
	 * @see org.eclipse.riena.ui.swt.AbstractStatuslineComposite#getBottomMargin()
	 */
	@Override
	protected int getBottomMargin() {
		return 0;
	}

	/**
	 * @see org.eclipse.riena.ui.swt.AbstractStatuslineComposite#getTopMargin()
	 */
	@Override
	protected int getTopMargin() {
		return TOP_BOTTOM_MARGIN;
	}

	/**
	 * @see org.eclipse.riena.ui.swt.AbstractStatuslineComposite#getRightMargin()
	 */
	@Override
	protected int getRightMargin() {
		return TOP_BOTTOM_MARGIN;
	}

	/**
	 * @see org.eclipse.riena.ui.swt.AbstractStatuslineComposite#getLeftMargin()
	 */
	@Override
	protected int getLeftMargin() {
		return 0;
	}

}
