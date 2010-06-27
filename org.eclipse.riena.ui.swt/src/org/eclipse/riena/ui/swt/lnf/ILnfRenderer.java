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
package org.eclipse.riena.ui.swt.lnf;

import java.util.Collection;

import org.eclipse.riena.core.marker.IMarker;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;

/**
 * Renderer of a widget or a part of a widget.
 */
public interface ILnfRenderer {

	/**
	 * Paints the widget.
	 * 
	 * @param gc
	 *            graphics context
	 * @param value
	 */
	void paint(GC gc, Object value);

	/**
	 * Dispose all resources used by the renderer
	 */
	void dispose();

	/**
	 * Returns the bounds of the widget.
	 * 
	 * @return bounds
	 */
	Rectangle getBounds();

	/**
	 * Sets size and location to the rectangular area specified by the
	 * arguments.
	 * 
	 * @param x
	 *            the new x coordinate the widget
	 * @param y
	 *            the new y coordinate the widget
	 * @param width
	 *            the new width the widget
	 * @param height
	 *            the new height the widget
	 */
	void setBounds(int x, int y, int width, int height);

	/**
	 * Set the bounds of rectangular area of the widget.
	 * 
	 * @param bounds
	 *            the new bounds of the widget
	 */
	void setBounds(Rectangle bounds);

	/**
	 * Returns all markers
	 * 
	 * @return markers
	 */
	Collection<? extends IMarker> getMarkers();

	/**
	 * Sets markers.
	 * 
	 * @param markers
	 *            collection of markers
	 */
	void setMarkers(Collection<? extends IMarker> markers);

	/**
	 * Returns all markers corresponding to a certain type.
	 * 
	 * @param type
	 *            the type of markers.
	 * @return markers corresponding to a certain type.
	 */
	<T extends IMarker> Collection<T> getMarkersOfType(Class<T> type);

}
