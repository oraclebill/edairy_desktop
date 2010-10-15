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

/**
 * Implementations can be used to observe changes of visual contexts registered
 * at the {@link IVisualContextManager}.
 * 
 */
public interface IContextUpdateListener {

	/**
	 * Gets called before the state of the observed context changes.
	 * 
	 * @param context
	 *            the observed context
	 */
	void beforeContextUpdate(Object context);

	/**
	 * Notification for context updates.
	 * 
	 * @param context
	 *            the observed context
	 * @return true if this listener should be unregistered automatically at the
	 *         observed component
	 */
	boolean contextUpdated(Object context);

}
