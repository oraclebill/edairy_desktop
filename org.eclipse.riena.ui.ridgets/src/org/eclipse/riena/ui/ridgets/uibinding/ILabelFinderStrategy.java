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
package org.eclipse.riena.ui.ridgets.uibinding;

import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;

/**
 * A Strategy that will be used to find corresponding labels of a IRidget to
 * connect their enable-state.
 * <p>
 * 
 * This Strategy gets injected by Riena into the
 * {@link CorrespondingLabelMapper}
 * 
 * @see CorrespondingLabelMapper
 * @see ILabelFinderStrategyExtension
 * 
 * @since 1.2
 * 
 */
public interface ILabelFinderStrategy {

	/**
	 * Custom strategy to find a {@link ILabelRidget} for a {@link IRidget}.
	 * 
	 * @param ridgetContainer
	 *            the ridgetContainer which holds the ridgets that can be
	 *            connected.
	 * @param ridgetID
	 *            the ridget-ID of the {@link IRidget} that we want to connect.
	 * @return
	 */
	ILabelRidget findLabelRidget(IRidgetContainer ridgetContainer, String ridgetID);
}
