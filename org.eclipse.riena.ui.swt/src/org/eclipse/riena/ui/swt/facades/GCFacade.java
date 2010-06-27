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
package org.eclipse.riena.ui.swt.facades;

import org.eclipse.swt.graphics.GC;

/**
 * Facade for the {@link GC} class.
 * 
 * @since 2.0
 */
public abstract class GCFacade {

	private static final GCFacade INSTANCE = (GCFacade) FacadeFactory.newFacade(GCFacade.class);

	/**
	 * The applicable implementation of this class.
	 */
	public static final GCFacade getDefault() {
		return INSTANCE;
	}

	/**
	 * @deprecated - RAP's GC now supports this directly TODO [ev] remove
	 */
	public abstract void drawLine(GC gc, int x1, int y1, int x2, int y2);

	/**
	 * Draws a round-cornered rectangle according to the given arguments with
	 * the GC's foreground color.
	 * <p>
	 * The RAP implementation of this class does nothing.
	 * 
	 * @param GC
	 *            a GC instance; never null
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 * @param arcWidth
	 *            the width of the arc
	 * @param arcHeight
	 *            the height of the arc
	 * @deprecated - RAP's GC now supports this directly TODO [ev] remove
	 */
	public abstract void drawRoundRectangle(GC gc, int x, int y, int width, int height, int arcWidth, int arcHeight);

	/**
	 * Compute the horizontal distance, in pixels, the cursor should move after
	 * printing the character in the current font.
	 * <p>
	 * Implementation note: on the RAP-Platform the returned value may be an
	 * approximation.
	 * 
	 * @param gc
	 *            a GC instance; never null
	 * @param ch
	 *            a character
	 * @return an amount in pixels (greater or equal to zero)
	 */
	public abstract int getAdvanceWidth(GC gc, char ch);

	/**
	 * Enable or disable use of the OS's advanced graphics subsystem for
	 * drawing. If advanced graphics are not available, this operation does
	 * nothing.
	 * 
	 * @param gc
	 *            the GC instance, never null
	 * @param isEnabled
	 *            true of false
	 */
	public abstract void setAdvanced(GC gc, boolean isEnabled);

	/**
	 * Enable or disable the user of anti-aliasing for all non-text drawing
	 * operations. This requires advanced graphics support in the OS. If
	 * advanced graphics are not available, this operations does nothing.
	 * 
	 * @param gc
	 *            the GC instance, never null
	 * @param option
	 *            one of the following values: SWT.DEFAULT, SWT.OFF, SWT.ON
	 */
	public abstract void setAntialias(GC gc, int option);

}
