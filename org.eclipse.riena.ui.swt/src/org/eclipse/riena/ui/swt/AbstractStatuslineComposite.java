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

import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.riena.ui.swt.lnf.IgnoreLnFUpdater;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;

/**
 * Composite of the status line.
 */
@IgnoreLnFUpdater("background")
public abstract class AbstractStatuslineComposite extends Composite {

	private static final int LEFT_RIGHT_MARGIN = 5;
	private static final int TOP_BOTTOM_MARGIN = 0;

	/**
	 * Creates a new instance of {@code AbstractStatuslineComposite}.
	 * <p>
	 * Sets the layout of this composite and adds the content.
	 * 
	 * @param parent
	 *            the parent Composite (non-null)
	 * @param style
	 *            the SWT style of the Composite
	 */
	public AbstractStatuslineComposite(Composite parent, int style) {
		super(parent, style);
		setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.STATUSLINE_BACKGROUND));
		setContentsLayout();
		createContents();
	}

	/**
	 * Creates the contents of a composite of the status line.
	 */
	protected abstract void createContents();

	/**
	 * Sets the layout.
	 */
	protected void setContentsLayout() {

		RowLayout rowLayout = new RowLayout();
		rowLayout.justify = false;
		rowLayout.marginLeft = getLeftMargin();
		rowLayout.marginTop = getTopMargin();
		rowLayout.marginRight = getRightMargin();
		rowLayout.marginBottom = getBottomMargin();
		rowLayout.pack = true;
		setLayout(rowLayout);

	}

	protected int getTopMargin() {
		return TOP_BOTTOM_MARGIN;
	}

	protected int getBottomMargin() {
		return TOP_BOTTOM_MARGIN;
	}

	protected int getLeftMargin() {
		return LEFT_RIGHT_MARGIN;
	}

	protected int getRightMargin() {
		return LEFT_RIGHT_MARGIN;
	}

}
