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
package org.eclipse.riena.ui.ridgets;

import java.util.List;

/**
 * The {@link IVisualContextManager} helps determining the current active
 * context out of a list of registered contexts.
 */
public interface IVisualContextManager {

	/**
	 * Determines the amount of sub contexts making up the current active
	 * context.
	 * 
	 * @param contexts
	 *            the amount of registered sub contexts
	 * @return the active context
	 */
	List<Object> getActiveContexts(List<Object> contexts);

	/**
	 * Adds a listener to be notified when one contexts state changes.
	 * <p>
	 * If the same listener is added more that once, it will be invoked several
	 * times!
	 * 
	 * @param listener
	 *            the listener to be notified
	 * @param context
	 *            the context
	 */
	void addContextUpdateListener(IContextUpdateListener listener, Object context);

	/**
	 * Removes a listener to be notified when one contexts state changes.
	 * <p>
	 * If the same listener is added more that once, it will be invoked several
	 * times!
	 * 
	 * @param listener
	 *            the listener to be notified
	 * @param context
	 *            the context
	 */
	void removeContextUpdateListener(IContextUpdateListener listener, Object context);

}
