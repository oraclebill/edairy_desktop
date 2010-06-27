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
package org.eclipse.riena.ui.swt.lnf.renderer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;

import org.eclipse.riena.ui.swt.facades.GCFacade;
import org.eclipse.riena.ui.swt.lnf.AbstractLnfRenderer;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;

/**
 * Renderer of the border of the (undecorated (no OS-border, no OS-titlebar))
 * dialog.
 */
public class DialogBorderRenderer extends AbstractLnfRenderer {

	private final static int BORDER_WIDTH = 2;

	protected Boolean hideOsBorder() {
		return LnfManager.getLnf().getBooleanSetting(LnfKeyConstants.DIALOG_HIDE_OS_BORDER);
	}

	protected Color getInnerBorderColorBottom() {
		return getLnfColor(LnfKeyConstants.DIALOG_INNER_BORDER_BOTTOM_RIGHT_COLOR);
	}

	protected Color getInnerBorderColorRight() {
		return getLnfColor(LnfKeyConstants.DIALOG_INNER_BORDER_BOTTOM_RIGHT_COLOR);
	}

	protected Color getInnerBorderColorTop() {
		return getLnfColor(LnfKeyConstants.DIALOG_INNER_BORDER_TOP_LEFT_COLOR);
	}

	protected Color getInnerBorderColorLeft() {
		return getLnfColor(LnfKeyConstants.DIALOG_INNER_BORDER_TOP_LEFT_COLOR);
	}

	protected Color getBorderColorBottom() {
		return getLnfColor(LnfKeyConstants.DIALOG_BORDER_BOTTOM_RIGHT_COLOR);
	}

	protected Color getBorderColorRight() {
		return getLnfColor(LnfKeyConstants.DIALOG_BORDER_BOTTOM_RIGHT_COLOR);
	}

	protected Color getBorderColorTop() {
		return getLnfColor(LnfKeyConstants.DIALOG_BORDER_TOP_LEFT_COLOR);
	}

	protected Color getBorderColorLeft() {
		return getLnfColor(LnfKeyConstants.DIALOG_BORDER_TOP_LEFT_COLOR);
	}

	protected Color getLnfColor(String key) {
		return LnfManager.getLnf().getColor(key);
	}

	/**
	 * @see org.eclipse.riena.ui.swt.lnf.AbstractLnfRenderer#paint(org.eclipse.swt.graphics.GC,
	 *      java.lang.Object)
	 */
	@Override
	public void paint(GC gc, Object value) {

		if (!hideOsBorder()) {
			return;
		}

		GCFacade gcFacade = GCFacade.getDefault();
		gcFacade.setAdvanced(gc, true);
		gcFacade.setAntialias(gc, SWT.ON);

		// Border

		// -outer
		// --top
		Color borderColor = getBorderColorTop();
		gc.setForeground(borderColor);
		int x = getBounds().x;
		int y = getBounds().y;
		int w = getWidth();
		gc.drawLine(x, y, x + w, y);
		// --bottom
		borderColor = getBorderColorBottom();
		gc.setForeground(borderColor);
		y = getBounds().y + getHeight();
		gc.drawLine(x, y, x + w, y);
		// --left
		borderColor = getBorderColorLeft();
		gc.setForeground(borderColor);
		x = getBounds().x;
		y = getBounds().y;
		int h = getHeight();
		gc.drawLine(x, y, x, y + h);
		// --right
		borderColor = getBorderColorRight();
		gc.setForeground(borderColor);
		x = getBounds().x + getWidth();
		gc.drawLine(x, y, x, y + h);

		// -inner
		// --top
		borderColor = getInnerBorderColorTop();
		gc.setForeground(borderColor);
		x = getBounds().x + 1;
		y = getBounds().y + 1;
		w = getWidth() - 2;
		gc.drawLine(x, y, x + w, y);
		// --bottom
		borderColor = getInnerBorderColorBottom();
		gc.setForeground(borderColor);
		y = getBounds().y + getHeight() - 1;
		gc.drawLine(x, y, x + w, y);
		// --left
		borderColor = getInnerBorderColorLeft();
		gc.setForeground(borderColor);
		x = getBounds().x + 1;
		y = getBounds().y + 1;
		h = getHeight() - 2;
		gc.drawLine(x, y, x, y + h);
		// --right
		borderColor = getInnerBorderColorRight();
		gc.setForeground(borderColor);
		x = getBounds().x + getWidth() - 1;
		y = getBounds().y + 2;
		h = getHeight() - 4;
		gc.drawLine(x, y, x, y + h);

	}

	/**
	 * @see org.eclipse.riena.navigation.ui.swt.lnf.ILnfRenderer#dispose()
	 */
	public void dispose() {
		// nothing to do
	}

	private int getHeight() {
		return getBounds().height - 1;
	}

	private int getWidth() {
		return getBounds().width - 1;
	}

	/**
	 * Returns the width of the border.
	 * 
	 * @return border width
	 */
	public int getBorderWidth() {

		if (hideOsBorder()) {
			return BORDER_WIDTH;
		} else {
			return 0;
		}

	}

}
