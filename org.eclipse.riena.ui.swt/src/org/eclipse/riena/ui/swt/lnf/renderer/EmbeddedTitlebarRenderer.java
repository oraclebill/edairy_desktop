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

import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;

import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.ui.swt.facades.GCFacade;
import org.eclipse.riena.ui.swt.lnf.AbstractLnfRenderer;
import org.eclipse.riena.ui.swt.lnf.FlasherSupportForRenderer;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.lnf.rienadefault.RienaDefaultLnf;
import org.eclipse.riena.ui.swt.utils.SwtUtilities;

/**
 * Renderer of the title bar of an embedded view.
 */
public class EmbeddedTitlebarRenderer extends AbstractLnfRenderer {

	protected final static int TITLEBAR_LABEL_PADDING_LEFT = 5;
	private final static int TITLEBAR_LABEL_PADDING = 4;
	protected final static int TITLEBAR_ICON_TEXT_GAP = 4;

	private Color defaultColor = null;
	private Control control;
	private Image image;
	private String title;
	// private Color edgeColor;
	private boolean active;
	private boolean pressed;
	private boolean hover;
	private boolean closeable;
	private boolean closeButtonPressed;
	private boolean closeButtonHover;
	private FlasherSupportForRenderer flasherSupport;

	/**
	 * Creates a new instance of the renderer for an embedded title bar.
	 */
	public EmbeddedTitlebarRenderer() {
		super();
		image = null;
		active = false;
		pressed = false;
		hover = false;
		closeable = false;
		flasherSupport = new FlasherSupportForRenderer(this, new MarkerUpdater());

	}

	/**
	 * @see org.eclipse.riena.navigation.ui.swt.lnf.ILnfRenderer#dispose()
	 */
	public void dispose() {
		SwtUtilities.disposeResource(getImage());
		SwtUtilities.disposeResource(defaultColor);
		control = null;
	}

	/**
	 * Computes the size (height) of the title bar.
	 * 
	 * @param gc
	 *            <code>GC</code> of the component <code>Control</code>
	 * @param wHint
	 *            the width hint
	 * @param hHint
	 *            the height hint
	 * @return a Point representing the size of the title bar
	 */
	public Point computeSize(GC gc, int wHint, int hHint) {

		Font font = getTitlebarFont();
		gc.setFont(font);
		FontMetrics fontMetrics = gc.getFontMetrics();

		int h = fontMetrics.getHeight() + TITLEBAR_LABEL_PADDING * 2;

		return new Point(wHint, h);

	}

	/**
	 * Returns the font of the title bar.
	 * 
	 * @return font
	 */
	protected Font getTitlebarFont() {
		RienaDefaultLnf lnf = LnfManager.getLnf();
		Font font = lnf.getFont(LnfKeyConstants.EMBEDDED_TITLEBAR_FONT);
		return font;
	}

	/**
	 * Draws the background in the specified region with the specified
	 * {@link GC}.
	 */
	protected void drawBackground(GC gc, int x, int y, int w, int h) {

		final Color startColor = getColor(LnfKeyConstants.EMBEDDED_TITLEBAR_ACTIVE_BACKGROUND_START_COLOR,
				LnfKeyConstants.EMBEDDED_TITLEBAR_PASSIVE_BACKGROUND_START_COLOR, null);
		final Color endColor = getColor(LnfKeyConstants.EMBEDDED_TITLEBAR_ACTIVE_BACKGROUND_END_COLOR,
				LnfKeyConstants.EMBEDDED_TITLEBAR_PASSIVE_BACKGROUND_END_COLOR, null);

		gc.setForeground(startColor);
		gc.setBackground(endColor);

		if (isPressed() && !isActive() && !isCloseButtonPressed()) {
			gc.fillRectangle(x, y, w, h);
		} else {
			gc.fillGradientRectangle(x, y, w, h, true);
		}
	}

	/**
	 * Draws the border of the title bar with the specified {@link GC}.
	 */
	protected void drawBorder(GC gc) {
		gc.setForeground(getBorderColor());
		final Rectangle b = getBounds();
		gc.drawRectangle(b.x, b.y, b.width - 1, b.height - 1);
	}

	/**
	 * @param value
	 *            title text
	 * 
	 * @see org.eclipse.riena.ui.swt.lnf.AbstractLnfRenderer#paint(org.eclipse.swt.graphics.GC,
	 *      java.lang.Object)
	 */
	@Override
	public void paint(GC gc, Object value) {

		Assert.isNotNull(gc);
		Assert.isNotNull(value);
		Assert.isTrue(value instanceof Control);
		control = (Control) value;

		if (getBounds() == null) {
			return;
		}

		GCFacade gcFacade = GCFacade.getDefault();
		gcFacade.setAdvanced(gc, true);
		gcFacade.setAntialias(gc, SWT.ON);

		Font font = getTitlebarFont();
		gc.setFont(font);

		int x = getBounds().x;
		int y = getBounds().y;
		int w = getBounds().width;
		int h = getBounds().height;

		// Background + border
		drawBackground(gc, x, y, w, h);
		drawBorder(gc);

		//		// Edges
		//		if ((edgeColor == null) || (edgeColor.isDisposed())) {
		//			edgeColor = SwtUtilities.makeBrighter(borderColor, 1.15f);
		//		}
		//		gc.setForeground(edgeColor);
		//		x = getBounds().x;
		//		y = getBounds().y;
		//		gc.drawPoint(x, y);
		//		x = getBounds().x + getWidth();
		//		y = getBounds().y;
		//		gc.drawPoint(x, y);
		//		x = getBounds().x;
		//		y = getBounds().y + getHeight();
		//		gc.drawPoint(x, y);
		//		x = getBounds().x + getWidth();
		//		y = getBounds().y + getHeight();
		//		gc.drawPoint(x, y);

		// Close icon
		Rectangle closeBounds = computeCloseButtonBounds();
		if (isCloseable()) {
			Image closeImage = getCloseButtonImage();
			gc.drawImage(closeImage, closeBounds.x, closeBounds.y);
		} else {
			closeBounds.x = 0;
			closeBounds.y = 0;
			closeBounds.width = 0;
			closeBounds.height = 0;
		}

		// Icon
		x = getBounds().x + TITLEBAR_LABEL_PADDING_LEFT;
		if (getImage() != null) {
			Rectangle imageBounds = getImage().getBounds();
			y = getBounds().y + (getHeight() - imageBounds.height) / 2;
			y++;
			gc.drawImage(getImage(), x, y);
			x += imageBounds.width + TITLEBAR_ICON_TEXT_GAP;
		}

		// Text
		String text = getTitle();
		if (!StringUtils.isEmpty(text)) {
			Color fgColor = getColor(LnfKeyConstants.EMBEDDED_TITLEBAR_ACTIVE_FOREGROUND,
					LnfKeyConstants.EMBEDDED_TITLEBAR_PASSIVE_FOREGROUND,
					LnfKeyConstants.EMBEDDED_TITLEBAR_DISABLED_FOREGROUND);
			gc.setForeground(fgColor);
			int y2 = (getHeight() - gc.getFontMetrics().getHeight()) / 2;
			y = getBounds().y + y2;
			y++;
			text = getClippedText(gc, text);
			gc.drawText(text, x, y, true);
		}

		// Hover border
		if (isHover() && (!isPressed() || isActive())) {
			x = getBounds().x;
			y = getBounds().y;
			w = getBounds().width;
			h = getHeight();
			getHoverBorderRenderer().setBounds(x, y, w, h);
			getHoverBorderRenderer().paint(gc, null);
		}

		getFlasherSupport().startFlasher();

	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isPressed() {
		return pressed;
	}

	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}

	public boolean isHover() {
		return hover;
	}

	public void setHover(boolean hover) {
		this.hover = hover;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	protected int getHeight() {
		return getBounds().height - 1;
	}

	protected int getWidth() {
		return getBounds().width - 1;
	}

	protected HoverBorderRenderer getHoverBorderRenderer() {
		return (HoverBorderRenderer) LnfManager.getLnf().getRenderer(
				LnfKeyConstants.SUB_MODULE_VIEW_HOVER_BORDER_RENDERER);
	}

	/**
	 * @return the closeable
	 */
	public boolean isCloseable() {
		return closeable;
	}

	/**
	 * @param closeable
	 *            the closeable to set
	 */
	public void setCloseable(boolean closeable) {
		this.closeable = closeable;
	}

	/**
	 * Computes the bounds of the close "button".
	 * 
	 * @return bounds
	 */
	protected Rectangle computeCloseButtonBounds() {

		Rectangle closeBounds = new Rectangle(0, 0, 0, 0);

		Image closeImage = getCloseButtonImage();
		// if no close icon was found, return 0 sized bounds
		if (closeImage == null) {
			return closeBounds;
		}
		closeBounds.width = closeImage.getBounds().width;
		closeBounds.height = closeImage.getBounds().height;
		closeBounds.x = getBounds().x + getWidth() - closeBounds.width - TITLEBAR_LABEL_PADDING;
		closeBounds.y = getBounds().y + (getHeight() - closeBounds.height) / 2;

		return closeBounds;

	}

	/**
	 * Returns <code>true</code> if the given point is inside the bounds of the
	 * close button, and <code>false</code> otherwise.
	 * 
	 * @param pt
	 *            the point to test
	 * @return <code>true</code> if the button bounds contains the point and
	 *         <code>false</code> otherwise
	 */
	public boolean isInsideCloseButton(Point pt) {

		Rectangle closeBounds = computeCloseButtonBounds();
		return closeBounds.contains(pt);

	}

	/**
	 * Returns the image of the close button according of the current button
	 * state.
	 * 
	 * @return button image
	 */
	protected Image getCloseButtonImage() {

		RienaDefaultLnf lnf = LnfManager.getLnf();

		String key = LnfKeyConstants.EMBEDDED_TITLEBAR_CLOSE_ICON;
		if (isEnabled()) {
			if (isCloseButtonPressed()) {
				key = LnfKeyConstants.EMBEDDED_TITLEBAR_CLOSE_HOVER_SELECTED_ICON;
			} else if (isCloseButtonHover()) {
				key = LnfKeyConstants.EMBEDDED_TITLEBAR_CLOSE_HOVER_ICON;
			}
		} else {
			key = LnfKeyConstants.EMBEDDED_TITLEBAR_CLOSE_INACTIVE_ICON;
		}

		Image closeImage = lnf.getImage(key);

		return closeImage;

	}

	/**
	 * @return the pressed
	 */
	public boolean isCloseButtonPressed() {
		return closeButtonPressed;
	}

	/**
	 * @param pressed
	 *            the pressed to set
	 */
	public void setCloseButtonPressed(boolean pressed) {
		closeButtonPressed = pressed;
	}

	/**
	 * @return the hover
	 */
	public boolean isCloseButtonHover() {
		return closeButtonHover;
	}

	/**
	 * @param hover
	 *            the hover to set
	 */
	public void setCloseButtonHover(boolean hover) {
		closeButtonHover = hover;
	}

	/**
	 * Computes the bounds of the text.
	 * 
	 * @return bounds
	 */
	public Rectangle computeTextBounds(GC gc) {

		Rectangle textBounds = new Rectangle(0, 0, 0, 0);

		textBounds.x = getBounds().x + TITLEBAR_LABEL_PADDING_LEFT;
		if (getImage() != null) {
			textBounds.x += getImage().getBounds().width + TITLEBAR_ICON_TEXT_GAP;
		}

		textBounds.width = getWidth() - (textBounds.x - getBounds().x) - TITLEBAR_LABEL_PADDING;

		Font font = getTitlebarFont();
		gc.setFont(font);
		FontMetrics fontMetrics = gc.getFontMetrics();

		textBounds.height = fontMetrics.getHeight();
		textBounds.y = getBounds().y + (getBounds().height - textBounds.height) / 2;

		return textBounds;

	}

	/**
	 * Clips the given text if the text it too long for the title bar.
	 * 
	 * @param gc
	 * @param text
	 *            text to clip (if necessary)
	 * @return text
	 */
	public String getClippedText(GC gc, String text) {

		if (StringUtils.isEmpty(text)) {
			return text;
		}
		Rectangle textBounds = computeTextBounds(gc);
		int maxWidth = textBounds.width;
		if (isCloseable()) {
			Rectangle closeBounds = computeCloseButtonBounds();
			maxWidth -= closeBounds.width;
		}

		Font font = getTitlebarFont();
		gc.setFont(font);
		return SwtUtilities.clipText(gc, text, maxWidth);

	}

	/**
	 * This class updates (redraws) the title bar, so that the marker are also
	 * updated (redrawn).
	 */
	private class MarkerUpdater implements Runnable {

		/**
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			if (control != null) {
				control.redraw();
			}
		}
	}

	protected Color getBorderColor() {
		return getColor(LnfKeyConstants.EMBEDDED_TITLEBAR_ACTIVE_BORDER_COLOR,
				LnfKeyConstants.EMBEDDED_TITLEBAR_PASSIVE_BORDER_COLOR,
				LnfKeyConstants.EMBEDDED_TITLEBAR_DISABLED_BORDER_COLOR);
	}

	/**
	 * Returns according to the states of the title bar the color of one of the
	 * given key.<br>
	 * If one key is not needed, the parameter can be {@code null}.
	 * 
	 * @param activeColorKey
	 * @param passiveColorKey
	 * @param disabeldColorKey
	 * @return color TODO same code in SubApplicationTabRenderer Returns
	 *         according to the
	 */
	protected Color getColor(String activeColorKey, String passiveColorKey, String disabeldColorKey) {

		Color color = null;

		String colorKey = getKey(activeColorKey, passiveColorKey, disabeldColorKey);
		if (colorKey == null) {
			colorKey = activeColorKey;
		}

		RienaDefaultLnf lnf = LnfManager.getLnf();
		color = lnf.getColor(colorKey);
		if (color == null) {
			return getDefaultColor();
		}

		return color;

	}

	private Color getDefaultColor() {
		// this was added so that the class loading no longer accesses the UIThread
		if (defaultColor == null) {
			defaultColor = new Color(null, 0, 0, 0); // black
		}
		return defaultColor;
	}

	/**
	 * Selects according to the state of the title bar one of the given keys.<br>
	 * If one key is not needed, the parameter can be {@code null}.
	 * 
	 * @param activeKey
	 * @param passiveKey
	 * @param disabledKey
	 * @return key
	 * @TODO same code in SubApplicationTabRenderer Returns according to the
	 */
	private String getKey(String activeKey, String passiveKey, String disabledKey) {

		String key = null;
		if (isEnabled()) {
			if (isActive() || getFlasherSupport().isProcessMarkerVisible()) {
				key = activeKey;
			} else {
				key = passiveKey;
			}
		} else {
			key = disabledKey;
		}

		if (key == null) {
			key = activeKey;
		}
		if (key == null) {
			key = passiveKey;
		}
		if (key == null) {
			key = disabledKey;
		}

		return key;

	}

	protected FlasherSupportForRenderer getFlasherSupport() {
		return flasherSupport;

	}
}
