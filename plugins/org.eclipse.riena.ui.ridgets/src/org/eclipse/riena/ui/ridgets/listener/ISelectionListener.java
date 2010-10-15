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
package org.eclipse.riena.ui.ridgets.listener;

/**
 * The listener interface for receiving selection events on a ridget.
 * 
 * @since 1.2
 */
public interface ISelectionListener {

	/**
	 * Invoked when a ridget is selected.
	 * 
	 * @param event
	 *            the SelectionEvent.
	 */
	void ridgetSelected(SelectionEvent event);

}
