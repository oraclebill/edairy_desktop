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
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;

import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SwtUtilities;

/**
 * Renderer of the title bar of a dialog.
 */
public class DialogTitleBarRenderer extends AbstractTitleBarRenderer {

	private final static int IMAGE_TITLE_GAP = 5;
	private final static int BORDER_IMAGE_GAP = 5;

	private String[] btnImageKeys = new String[] { LnfKeyConstants.DIALOG_CLOSE_ICON, LnfKeyConstants.DIALOG_MAX_ICON,
			LnfKeyConstants.DIALOG_MIN_ICON, LnfKeyConstants.DIALOG_RESTORE_ICON };
	private String[] btnHoverSelectedImageKeys = new String[] { LnfKeyConstants.DIALOG_CLOSE_HOVER_SELECTED_ICON,
			LnfKeyConstants.DIALOG_MAX_HOVER_SELECTED_ICON, LnfKeyConstants.DIALOG_MIN_HOVER_SELECTED_ICON,
			LnfKeyConstants.DIALOG_RESTORE_HOVER_SELECTED_ICON };
	private String[] btnHoverImageKeys = new String[] { LnfKeyConstants.DIALOG_CLOSE_HOVER_ICON,
			LnfKeyConstants.DIALOG_MAX_HOVER_ICON, LnfKeyConstants.DIALOG_MIN_HOVER_ICON,
			LnfKeyConstants.DIALOG_RESTORE_HOVER_ICON };
	private String[] btnInactiveImageKeys = new String[] { LnfKeyConstants.DIALOG_CLOSE_INACTIVE_ICON,
			LnfKeyConstants.DIALOG_MAX_INACTIVE_ICON, LnfKeyConstants.DIALOG_MIN_INACTIVE_ICON,
			LnfKeyConstants.DIALOG_RESTORE_INACTIVE_ICON };

	@Override
	protected String[] getBtnHoverImageKeys() {
		return btnHoverImageKeys;
	}

	@Override
	protected String[] getBtnHoverSelectedImageKeys() {
		return btnHoverSelectedImageKeys;
	}

	@Override
	protected String[] getBtnImageKeys() {
		return btnImageKeys;
	}

	@Override
	protected String[] getBtnInactiveImageKeys() {
		return btnInactiveImageKeys;
	}

	@Override
	protected void paintBackground(GC gc) {

		gc.setForeground(LnfManager.getLnf().getColor(LnfKeyConstants.DIALOG_TITLEBAR_BACKGROUND_END_COLOR));
		gc.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.DIALOG_TITLEBAR_BACKGROUND_START_COLOR));
		gc.fillGradientRectangle(3, 3, getBounds().width - 3, getBounds().height - 4, true);

		// top and left
		gc.setForeground(LnfManager.getLnf().getColor(LnfKeyConstants.DIALOG_TITLEBAR_BACKGROUND_TOP_COLOR_1));
		gc.drawLine(0, 0, getBounds().width - 1, 0);
		gc.drawLine(0, 0, 0, getHeight() - 1);
		gc.setForeground(LnfManager.getLnf().getColor(LnfKeyConstants.DIALOG_TITLEBAR_BACKGROUND_TOP_COLOR_2));
		gc.drawLine(1, 1, getBounds().width - 1, 1);
		gc.drawLine(1, 1, 1, getHeight() - 2);
		gc.setForeground(LnfManager.getLnf().getColor(LnfKeyConstants.DIALOG_TITLEBAR_BACKGROUND_TOP_COLOR_3));
		gc.drawLine(2, 2, getBounds().width - 1, 2);
		gc.drawLine(2, 2, 2, getHeight() - 2);

		// bottom and right
		gc.setForeground(LnfManager.getLnf().getColor(LnfKeyConstants.DIALOG_TITLEBAR_BACKGROUND_BOTTOM_COLOR_1));
		gc.drawLine(0, getHeight() - 3, getBounds().width - 1, getHeight() - 3);
		gc.setForeground(LnfManager.getLnf().getColor(LnfKeyConstants.DIALOG_TITLEBAR_BACKGROUND_BOTTOM_COLOR_2));
		gc.drawLine(1, getHeight() - 4, getBounds().width - 1, getHeight() - 4);
		gc.setForeground(LnfManager.getLnf().getColor(LnfKeyConstants.DIALOG_TITLEBAR_BACKGROUND_BOTTOM_COLOR_3));
		gc.drawLine(2, getHeight() - 5, getBounds().width - 1, getHeight() - 5);
		gc.drawLine(getBounds().width - 1, 0, getBounds().width - 1, getHeight() - 5);

	}

	@Override
	protected Rectangle paintTitle(GC gc) {

		if (!LnfManager.getLnf().getBooleanSetting(LnfKeyConstants.DIALOG_HIDE_OS_BORDER)) {
			return new Rectangle(0, 0, 0, 0);
		}

		String title = getShell().getText();
		if (StringUtils.isEmpty(title)) {
			return new Rectangle(0, 0, 0, 0);
		}

		Color fgColor = LnfManager.getLnf().getColor(LnfKeyConstants.DIALOG_FOREGROUND);
		if (!isActive()) {
			fgColor = LnfManager.getLnf().getColor(LnfKeyConstants.DIALOG_PASSIVE_FOREGROUND);
		}
		gc.setForeground(fgColor);

		Font font = LnfManager.getLnf().getFont(LnfKeyConstants.DIALOG_FONT);
		gc.setFont(font);

		int textHeight = gc.getFontMetrics().getHeight();
		int y = getHeight() / 2 - textHeight / 2;
		y -= 2;

		int x = getImageBounds().x + getImageBounds().width + IMAGE_TITLE_GAP;
		int textWidth = SwtUtilities.calcTextWidth(gc, title);
		if (textWidth + x > getBounds().width) {
			textWidth = getBounds().width - x;
			title = SwtUtilities.clipText(gc, title, textWidth);
		}

		gc.drawText(title, x, y, true);

		return new Rectangle(x, y, textWidth, textHeight);

	}

	@Override
	protected Rectangle paintImage(GC gc) {

		if (!LnfManager.getLnf().getBooleanSetting(LnfKeyConstants.DIALOG_HIDE_OS_BORDER)) {
			return new Rectangle(0, 0, 0, 0);
		}

		Image image = getShell().getImage();
		if (image == null) {
			return new Rectangle(0, 0, 0, 0);
		}

		int x = BORDER_IMAGE_GAP;
		int imageWidth = image.getBounds().width;
		int imageHeight = image.getBounds().height;
		int y = getHeight() / 2 - imageHeight / 2;

		gc.drawImage(image, x, y);

		return new Rectangle(x, y, imageWidth, imageHeight);

	}

}
