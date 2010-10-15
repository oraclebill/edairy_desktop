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
package org.eclipse.riena.ui.ridgets.marker;

import org.eclipse.riena.ui.core.marker.IMessageMarker;
import org.eclipse.riena.ui.ridgets.IBasicMarkableRidget;

/**
 * Visualizes certain types of message markers of certain Ridgets.
 * 
 * @see org.eclipse.riena.ui.internal.core.marker.IMessageMarker
 */
public interface IMessageMarkerViewer {

	/**
	 * Adds a Ridget to the list of Ridgets being observed for message markers.
	 * <p>
	 * Adding the same ridget several times has no effect.
	 * 
	 * @param markableRidget
	 *            A Ridget whose message markers should be visualized (non-null)
	 * @throws RuntimeException
	 *             if markableRidget is null
	 */
	void addRidget(IBasicMarkableRidget markableRidget);

	/**
	 * Removes a Ridget from the list of Ridgets being observed for message
	 * markers.
	 * 
	 * @param markableRidget
	 *            A Ridget whose message markers should be visualized no more
	 *            (non-null)
	 * @throws RuntimeException
	 *             if markableRidget is null
	 */
	void removeRidget(IBasicMarkableRidget markableRidget);

	/**
	 * Adds a type of marker to the list of markers to be visualized.
	 * <p>
	 * Adding the same markerClass several times has no effect.
	 * 
	 * @param markerClass
	 *            A type of marker to visualize.
	 */
	void addMarkerType(Class<? extends IMessageMarker> markerClass);

	/**
	 * Removed a type of marker to the list of markers to be visualized.
	 * 
	 * @param markerClass
	 *            A type of marker to visualize no more.
	 */
	void removeMarkerType(Class<? extends IMessageMarker> markerClass);

	/**
	 * Indicates whether the visualization of the message markers is visible.
	 * 
	 * @return The visible state.
	 */
	boolean isVisible();

	/**
	 * Sets the visibility of the visualization of the message markers.
	 * 
	 * @param visible
	 *            The new visible state.
	 */
	void setVisible(boolean visible);

}
