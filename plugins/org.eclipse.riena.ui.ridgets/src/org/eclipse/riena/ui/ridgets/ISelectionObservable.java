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

import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;

/**
 * Maintains a set of ISelectionListeners that will be notified when the
 * selection changes.
 * 
 * @see ISelectionListener
 * @since 1.2
 */
public interface ISelectionObservable {

	/**
	 * Adds the listener to the collection of listeners who will be notified
	 * when the bound control is selected.
	 * <p>
	 * Adding the same listener several times has no effect.
	 * 
	 * @param listener
	 *            a non-null {@link ISelectionListener} instance
	 * @throws RuntimeException
	 *             if listener is null
	 * @since 1.2
	 */
	void addSelectionListener(ISelectionListener listener);

	/**
	 * Removes the listener from the collection of listeners who will be
	 * notified when the bound control is selected.
	 * 
	 * @param listener
	 *            a non-null {@link ISelectionListener} instance
	 * @throws RuntimeException
	 *             if listener is null
	 * @since 1.2
	 */
	void removeSelectionListener(ISelectionListener listener);
}
