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

import java.util.EventListener;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;

/**
 * Single-sourced access to SWT methods that are not available in RAP.
 * <p>
 * <b>Note:</b> The RCP implementation delegates to the appropriate SWT methods.
 * The RAP implementation does nothing (as this functionality is missing in
 * RAP).
 * 
 * @since 2.0
 */
public abstract class SWTFacade {

	private static final SWTFacade INSTANCE = (SWTFacade) FacadeFactory.newFacade(SWTFacade.class);

	/**
	 * Traversal event detail field value indicating that a mnemonic key
	 * sequence was pressed (value is 1&lt;&lt;7).
	 */
	public static final int TRAVERSE_MNEMONIC = 1 << 7;

	/**
	 * The mouse wheel event type (value is 37). This is a synonym for
	 * {@link #MouseVerticalWheel} (value is 37). Newer applications should use
	 * {@link #MouseVerticalWheel} instead of {@link #MouseWheel} to make code
	 * more understandable.
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 */
	public static final int MouseWheel = 37;

	/**
	 * The applicable implementation of this class.
	 */
	public static final SWTFacade getDefault() {
		return INSTANCE;
	}

	/**
	 * Returns true if running on the RAP platform, false otherwise.
	 */
	public static final boolean isRAP() {
		return "rap".equals(SWT.getPlatform()); //$NON-NLS-1$
	}

	/**
	 * Returns true if running on the RCP platform, false otherwise.
	 */
	public static final boolean isRCP() {
		return !SWTFacade.isRAP();
	}

	/**
	 * Returns true if the trident animation library is available.
	 */
	public static final boolean hasTrident() {
		return Platform.getBundle("org.pushingpixels.trident") != null; //$NON-NLS-1$
	}

	/**
	 * Adds an SWT.EraseItem listener to the given table.
	 */
	public abstract void addEraseItemListener(Table table, Listener listener);

	/**
	 * Adds an SWT.EraseItem listener to the given tree.
	 */
	public abstract void addEraseItemListener(Tree tree, Listener listener);

	/**
	 * Adds a MouseMoveListener to the given control.
	 * 
	 * @param listener
	 *            an Object that implements the MouseMoveListener interface, or
	 *            null
	 */
	public abstract void addMouseMoveListener(Control control, Object listener);

	/**
	 * Adds a MouseTrackListener to the given control.
	 */
	public abstract void addMouseTrackListener(Control control, MouseTrackListener listener);

	/**
	 * Adds an SWT.PaintItem listener to the given tree.
	 */
	public abstract void addPaintItemListener(Tree tree, Listener listener);

	/**
	 * Adds a PaintListener to the given control.
	 * 
	 * @param listener
	 *            an EventListener that implements the PaintListener interface,
	 *            or null
	 */
	public abstract void addPaintListener(Control control, EventListener listener);

	/**
	 * Returns a paint listener for modifying the disabled look of a control.
	 * 
	 * @return a PaintListener or null (in RAP)
	 */
	public abstract EventListener createDisabledPainter();

	/**
	 * Create a custom cursor from the given {@code cursorImage}. If the image
	 * is null, or custom cursors are not supported, create a standard cursor
	 * with the given {@code alternateStyle}.
	 * 
	 * @param display
	 *            a Display instance; never null
	 * @param cursorImage
	 *            the Image to be used for the cursor; may be null
	 * @param alternateStyle
	 *            an alternate style for the cursor; must be one of the
	 *            SWT.CURSOR_XYZ constants
	 * @return a Cursor instance; never null. Clients must dispose the returned
	 *         instance once no longer needed.
	 */
	public abstract Cursor createCursor(Display display, Image cursorImage, int alternateStyle);

	/**
	 * Returns an SWT.EraseItem / SWT.PaintItem listener, that will paint all
	 * tree cells empty when the tree is disabled.
	 * 
	 * @return a Listener or null (in RAP)
	 */
	public abstract Listener createTreeItemEraserAndPainter();

	/**
	 * TODO [ev] remove
	 * 
	 * @deprecated - RAP now supports display.getCursorControl();
	 */
	public abstract Control getCursorControl(Display display);

	/**
	 * Posts the given event on the display.
	 * 
	 * @return true if the event was generated, false otherwise
	 */
	public abstract boolean postEvent(Display display, Event event);

	/**
	 * Removes an SWT.EraseItem listener from the given table.
	 */
	public abstract void removeEraseItemListener(Table table, Listener listener);

	/**
	 * Removes an SWT.EraseItem listener from the given tree.
	 */
	public abstract void removeEraseItemListener(Tree tree, Listener listener);

	/**
	 * Removes a MouseMoveListener from the given control.
	 * 
	 * @param listener
	 *            an Object that implements the MouseMoveListener interface, or
	 *            null
	 */
	public abstract void removeMouseMoveListener(Control control, Object listener);

	/**
	 * Removes a MouseTrackListener from the given control.
	 */
	public abstract void removeMouseTrackListener(Control control, MouseTrackListener listener);

	/**
	 * Removes an SWT.PaintItem listener from the given tree.
	 */
	public abstract void removePaintItemListener(Tree tree, Listener listener);

	/**
	 * Removes a PaintListener from the given control.
	 * 
	 * @param listener
	 *            an EventListener that implements the PaintListener interface,
	 *            or null
	 */
	public abstract void removePaintListener(Control control, EventListener listener);
}
