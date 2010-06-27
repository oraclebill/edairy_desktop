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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

/**
 * This label displays a "number" in the status line.
 */
public class NumberLabel extends CLabel {

	private int fixWidth;

	public NumberLabel(Composite parent, int style) {
		super(parent, style);
		fixWidth = SWT.NONE;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Returns a fix width, if it was set before.
	 */
	@Override
	public Point computeSize(int wHint, int hHint, boolean changed) {
		Point size = super.computeSize(wHint, hHint, changed);
		if (getFixWidth() != SWT.NONE) {
			size.x = getFixWidth();
		}
		return size;
	}

	public int getFixWidth() {
		return fixWidth;
	}

	public void setFixWidth(int fixWidth) {
		this.fixWidth = fixWidth;
	}

}