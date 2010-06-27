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
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.riena.ui.swt.lnf.AbstractLnfRenderer;
import org.eclipse.riena.ui.swt.lnf.LnfManager;

/**
 * Renderer of the buttons (min.,max. and close), the title , the image and
 * background of title bar.
 */
public abstract class AbstractTitleBarRenderer extends AbstractLnfRenderer {

	private final static int DEFAULT_HEIGHT = 26;
	protected final static int TOP_BUTTON_GAP = 2;
	private final static int BUTTON_RIGHT_GAP = 2;
	private final static int BUTTON_BUTTON_GAP = 2;
	protected final static int BTN_COUNT = 3;
	protected final static int CLOSE_BTN_INDEX = 0;
	protected final static int MAX_BTN_INDEX = 1;
	protected final static int MIN_BTN_INDEX = 2;
	protected final static int RESTORE_BTN_INDEX = 3;

	private boolean closeable;
	private boolean maximizable;
	private boolean minimizable;
	private boolean[] pressed = new boolean[BTN_COUNT];
	private boolean[] hover = new boolean[BTN_COUNT];
	private boolean active;
	private boolean maximized;
	private Rectangle imageBounds;
	private Rectangle textBounds;
	private Rectangle[] btnBounds = new Rectangle[BTN_COUNT];

	private Shell shell;

	/**
	 * Creates a new instance of <code>AbstractTitleBarRenderer</code> and
	 * initializes the bounds of the buttons, the text etc.
	 */
	public AbstractTitleBarRenderer() {

		super();

		resetBounds();

	}

	/**
	 * Resets the bounds of the buttons, the text etc.
	 */
	private void resetBounds() {
		for (int i = 0; i < btnBounds.length; i++) {
			btnBounds[i] = new Rectangle(0, 0, 0, 0);
		}
		imageBounds = new Rectangle(0, 0, 0, 0);
		textBounds = new Rectangle(0, 0, 0, 0);
	}

	/**
	 * Set the Shell used by this renderer.
	 * 
	 * @param shell
	 *            the shell to set (non-null)
	 */
	public void setShell(Shell shell) {
		Assert.isNotNull(shell);
		this.shell = shell;
	}

	protected Shell getShell() {
		return shell;
	}

	/**
	 * @see org.eclipse.riena.ui.swt.lnf.AbstractLnfRenderer#paint(org.eclipse.swt.graphics.GC,
	 *      java.lang.Object)
	 */
	@Override
	public void paint(GC gc, Object value) {

		Assert.isNotNull(shell);

		setActive(true);
		setMaximized(shell.getMaximized());
		resetBounds();

		paintBackground(gc);

		imageBounds = paintImage(gc);

		for (int i = 0; i < BTN_COUNT; i++) {
			paintButton(gc, i);
		}

		textBounds = paintTitle(gc);

	}

	/**
	 * Paints the background of the title bar.
	 * 
	 * @param gc
	 *            graphics context
	 */
	abstract protected void paintBackground(GC gc);

	/**
	 * Paints the title.<br>
	 * <i>To paint the title correct the bounds of the buttons and the image
	 * must be set before.</i>
	 * 
	 * @param gc
	 *            graphics context
	 * @return the bounds of the text
	 */
	abstract protected Rectangle paintTitle(GC gc);

	/**
	 * Paints the image.
	 * 
	 * @param gc
	 *            graphics context
	 * @return the bounds of the image
	 */
	abstract protected Rectangle paintImage(GC gc);

	/**
	 * Sets the bounds for a button and paints it.
	 * 
	 * @param gc
	 *            graphics context
	 * @param btnIndex
	 *            index of the button
	 */
	protected void paintButton(GC gc, int btnIndex) {

		Image image = null;

		if (getBtnShow()[btnIndex]) {
			int index = btnIndex;
			if ((index == MAX_BTN_INDEX) && isMaximized()) {
				index = RESTORE_BTN_INDEX;
			}
			if (isActive()) {
				if (isPressed(btnIndex)) {
					image = LnfManager.getLnf().getImage(getBtnHoverSelectedImageKeys()[index]);
				} else if (isHover(btnIndex)) {
					image = LnfManager.getLnf().getImage(getBtnHoverImageKeys()[index]);
				} else {
					image = LnfManager.getLnf().getImage(getBtnImageKeys()[index]);
				}
			} else {
				image = LnfManager.getLnf().getImage(getBtnInactiveImageKeys()[index]);
			}
		}

		int x = getBounds().x + getBounds().width - BUTTON_RIGHT_GAP;
		if (btnIndex > 0) {
			x = btnBounds[btnIndex - 1].x;
			if (btnBounds[btnIndex - 1].width > 0) {
				x -= BUTTON_BUTTON_GAP;
			}
		}
		int y = 0;
		if (image != null) {
			Rectangle imgBounds = image.getBounds();
			y = getBounds().height / 2 - imgBounds.height / 2;
			y -= 2;
			x -= imgBounds.width;
			gc.drawImage(image, x, y);
			btnBounds[btnIndex].width = imgBounds.width;
			btnBounds[btnIndex].height = imgBounds.height;
		}
		btnBounds[btnIndex].x = x;
		btnBounds[btnIndex].y = y;

	}

	/**
	 * @see org.eclipse.riena.navigation.ui.swt.lnf.ILnfRenderer#dispose()
	 */
	public void dispose() {
		// nothing to do
	}

	/**
	 * @return the pressed
	 */
	protected boolean isPressed(int btnIndex) {
		return pressed[btnIndex];
	}

	/**
	 * @param pressed
	 *            the pressed to set
	 */
	protected void setPressed(int btnIndex, boolean pressed) {
		this.pressed[btnIndex] = pressed;
	}

	/**
	 * @return the hover
	 */
	protected boolean isHover(int btnIndex) {
		return hover[btnIndex];
	}

	/**
	 * @param hover
	 *            the hover to set
	 */
	protected void setHover(int btnIndex, boolean hover) {
		this.hover[btnIndex] = hover;
	}

	/**
	 * @return the active
	 */
	protected boolean isActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	protected void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the maximized
	 */
	protected boolean isMaximized() {
		return maximized;
	}

	/**
	 * @param maximiz
	 *            the maximized to set
	 */
	protected void setMaximized(boolean maximized) {
		this.maximized = maximized;
	}

	/**
	 * Returns <code>true</code> if the given point is inside the bounds of the
	 * close button, and <code>false</code> otherwise.
	 * 
	 * @param pt
	 *            the point to test
	 * @return <code>true</code> if the close button bounds contains the point
	 *         and <code>false</code> otherwise
	 */
	public boolean isInsideCloseButton(Point pt) {
		return isInsideButton(pt, CLOSE_BTN_INDEX);
	}

	/**
	 * Returns <code>true</code> if the given point is inside the bounds of the
	 * minimize button, and <code>false</code> otherwise.
	 * 
	 * @param pt
	 *            the point to test
	 * @return <code>true</code> if the minimize button bounds contains the
	 *         point and <code>false</code> otherwise
	 */
	public boolean isInsideMinimizeButton(Point pt) {
		return isInsideButton(pt, MIN_BTN_INDEX);
	}

	/**
	 * Returns <code>true</code> if the given point is inside the bounds of the
	 * maximize/restore button, and <code>false</code> otherwise.
	 * 
	 * @param pt
	 *            the point to test
	 * @return <code>true</code> if the maximize/restore button bounds contains
	 *         the point and <code>false</code> otherwise
	 */
	public boolean isInsideMaximizeButton(Point pt) {
		return isInsideButton(pt, MAX_BTN_INDEX);
	}

	/**
	 * Returns <code>true</code> if the given point is inside the bounds of the
	 * button, and <code>false</code> otherwise.
	 * 
	 * @param pt
	 *            the point to test
	 * @param btnIndex
	 *            index of button
	 * @return <code>true</code> if the button bounds contains the point and
	 *         <code>false</code> otherwise
	 */
	private boolean isInsideButton(Point pt, int btnIndex) {
		return btnBounds[btnIndex].contains(pt);
	}

	/**
	 * Returns <code>true</code> if the given point is inside the bounds of the
	 * move area, and <code>false</code> otherwise.<br>
	 * The move area is the area of the shell less the bounds of the buttons.
	 * 
	 * @param pt
	 *            the point to test
	 * @return <code>true</code> if the move area bounds contains the point and
	 *         <code>false</code> otherwise
	 */
	public boolean isInsideMoveArea(Point pt) {
		boolean result = false;
		Rectangle bounds = getBounds();
		if (bounds != null) {
			Rectangle moveArea = new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height);
			int minX = bounds.x + bounds.width;
			int maxHeight = textBounds.y + textBounds.height;
			for (int i = 0; i < btnBounds.length; i++) {
				minX = Math.min(minX, btnBounds[i].x);
				maxHeight = Math.max(maxHeight, btnBounds[i].y + btnBounds[i].height);
			}
			int width = minX - bounds.x;
			if (width < 0) {
				width = 0;
			}
			moveArea.width = width;
			moveArea.height = maxHeight;
			result = moveArea.contains(pt);
		}
		return result;
	}

	/**
	 * Returns the bounds of all buttons.
	 * 
	 * @return bounds of buttons
	 */
	public Rectangle getAllButtonsBounds() {

		Rectangle bounds = new Rectangle(btnBounds[0].x, btnBounds[0].y, btnBounds[0].width, btnBounds[0].height);

		for (int i = 1; i < btnBounds.length; i++) {
			bounds.add(btnBounds[i]);
		}

		return bounds;

	}

	protected Rectangle getImageBounds() {
		return imageBounds;
	}

	/**
	 * Returns a array with the bounds of every single button.
	 * 
	 * @return bounds of buttons
	 */
	protected Rectangle[] getButtonsBounds() {

		return btnBounds;

	}

	/**
	 * @return the pressed
	 */
	public boolean isCloseButtonPressed() {
		return isPressed(CLOSE_BTN_INDEX);
	}

	/**
	 * @param pressed
	 *            the pressed to set
	 */
	public void setCloseButtonPressed(boolean pressed) {
		setPressed(CLOSE_BTN_INDEX, pressed);
	}

	/**
	 * @return the hover
	 */
	public boolean isCloseButtonHover() {
		return isHover(CLOSE_BTN_INDEX);
	}

	/**
	 * @param hover
	 *            the hover to set
	 */
	public void setCloseButtonHover(boolean hover) {
		setHover(CLOSE_BTN_INDEX, hover);
	}

	/**
	 * @return the pressed
	 */
	public boolean isMaximizedButtonPressed() {
		return isPressed(MAX_BTN_INDEX);
	}

	/**
	 * @param pressed
	 *            the pressed to set
	 */
	public void setMaximizedButtonPressed(boolean pressed) {
		setPressed(MAX_BTN_INDEX, pressed);
	}

	/**
	 * @return the hover
	 */
	public boolean isMaximizedButtonHover() {
		return isHover(MAX_BTN_INDEX);
	}

	/**
	 * @param hover
	 *            the hover to set
	 */
	public void setMaximizedButtonHover(boolean hover) {
		setHover(MAX_BTN_INDEX, hover);
	}

	/**
	 * @return the pressed
	 */
	public boolean isMinimizedButtonPressed() {
		return isPressed(MIN_BTN_INDEX);
	}

	/**
	 * @param pressed
	 *            the pressed to set
	 */
	public void setMinimizedButtonPressed(boolean pressed) {
		setPressed(MIN_BTN_INDEX, pressed);
	}

	/**
	 * @return the hover
	 */
	public boolean isMinimizedButtonHover() {
		return isHover(MIN_BTN_INDEX);
	}

	/**
	 * @param hover
	 *            the hover to set
	 */
	public void setMinimizedButtonHover(boolean hover) {
		setHover(MIN_BTN_INDEX, hover);
	}

	abstract protected String[] getBtnImageKeys();

	abstract protected String[] getBtnHoverSelectedImageKeys();

	abstract protected String[] getBtnHoverImageKeys();

	abstract protected String[] getBtnInactiveImageKeys();

	private boolean[] getBtnShow() {

		boolean[] btnShow = new boolean[BTN_COUNT];

		btnShow[CLOSE_BTN_INDEX] = isCloseable();
		btnShow[MAX_BTN_INDEX] = isMaximizable();
		btnShow[MIN_BTN_INDEX] = isMinimizable();
		return btnShow;

	}

	public void setCloseable(boolean closeable) {
		this.closeable = closeable;
	}

	public boolean isCloseable() {
		return closeable;
	}

	public void setMaximizable(boolean maximizable) {
		this.maximizable = maximizable;
	}

	public boolean isMaximizable() {
		return maximizable;
	}

	public void setMinimizable(boolean minimizable) {
		this.minimizable = minimizable;
	}

	public boolean isMinimizable() {
		return minimizable;
	}

	/**
	 * Returns the height of the title bar.
	 * 
	 * @return height of title bar
	 */
	public int getHeight() {

		int height = 0;
		if (getBounds() != null) {
			height = getBounds().height;
		}
		if (height <= 0) {
			height = DEFAULT_HEIGHT;
		}

		return height;

	}

}
