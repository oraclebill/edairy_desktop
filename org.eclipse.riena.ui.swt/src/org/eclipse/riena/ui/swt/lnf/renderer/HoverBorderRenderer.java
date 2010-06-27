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

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;

import org.eclipse.riena.ui.swt.lnf.AbstractLnfRenderer;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.lnf.rienadefault.RienaDefaultLnf;

/**
 * Renderer of the border that is displayed when the mouse is over the module.
 */
public class HoverBorderRenderer extends AbstractLnfRenderer {

	private final static int DEFAULT_MARGIN = 0;

	/**
	 * @param value
	 *            is ignored
	 * 
	 * @see org.eclipse.riena.ui.swt.lnf.AbstractLnfRenderer#paint(org.eclipse.swt.graphics.GC,
	 *      java.lang.Object)
	 */
	@Override
	public void paint(GC gc, Object value) {

		//		int oldAntialias = gc.getAntialias();
		//		gc.setAntialias(SWT.OFF);

		RienaDefaultLnf lnf = LnfManager.getLnf();
		int margin = lnf.getIntegerSetting(LnfKeyConstants.EMBEDDED_TITLEBAR_HOVER_BORDER_MARGIN, DEFAULT_MARGIN);
		int x = getBounds().x + margin;
		int y = getBounds().y + margin;
		int width = getBounds().width - 2 * margin;
		int height = getBounds().height - 2 * margin;

		// top
		Color topColor = lnf.getColor(LnfKeyConstants.EMBEDDED_TITLEBAR_HOVER_BORDER_TOP_COLOR);
		gc.setForeground(topColor);
		gc.drawLine(x + 1, y, x + width - 2, y);
		Color startColor = lnf.getColor(LnfKeyConstants.EMBEDDED_TITLEBAR_HOVER_BORDER_START_COLOR);
		gc.setForeground(startColor);
		gc.drawLine(x, y + 1, x + width - 1, y + 1);

		// left
		Color endColor = lnf.getColor(LnfKeyConstants.EMBEDDED_TITLEBAR_HOVER_BORDER_END_COLOR);
		gc.setBackground(endColor);
		gc.fillGradientRectangle(x, y + 1, 2, height - 1, true);

		// right
		gc.fillGradientRectangle(x + width - 2, y + 1, 2, height - 1, true);

		// bottom
		gc.setForeground(endColor);
		gc.drawLine(x, y + height - 1, x + width - 1, y + height - 1);
		Color bottomColor = lnf.getColor(LnfKeyConstants.EMBEDDED_TITLEBAR_HOVER_BORDER_BOTTOM_COLOR);
		gc.setForeground(bottomColor);
		gc.drawLine(x + 1, y + height, x + width - 2, y + height);

		//		gc.setAntialias(oldAntialias);

	}

	/**
	 * @see org.eclipse.riena.navigation.ui.swt.lnf.ILnfRenderer#dispose()
	 */
	public void dispose() {
		// nothing to do
	}

}
