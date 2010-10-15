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
 * Manages the default button state for one or more ridgets.
 * <p>
 * The manager has the following lifecycle:
 * <ul>
 * <li>activate() - starts listening to focus event and managing the default
 * button</li>
 * <li>deactivate() - stops listening to focus events. Call activate again to
 * resume</li>
 * <li>dispose() - stop listening to focus events and reset all internal state</li>
 * </ul>
 * 
 * @see IWindowRidget#addDefaultAction(IRidget, IActionRidget);
 * @since 2.0
 */
public interface IDefaultActionManager {

	/**
	 * Starts listening to focus events and managing the default button.
	 * <p>
	 * When activated you can invoke {@link #deactivate()} or {@link #dispose()}.
	 * <p>
	 * <b>Important:</b> once you activate this instance, you <b>have</b> to
	 * deactivate or dispose it. If you don't the manager will keep responding
	 * to every focus event.
	 */
	void activate();

	/**
	 * Stop listening to focus events.
	 * <p>
	 * When deactivated you can invoke {@link #activate()} or {@link #dispose()}.
	 */
	void deactivate();

	/**
	 * Stop listening to focus events and reset all internal state.
	 * <p>
	 * When disposed you cannot transition to any other state.
	 */
	void dispose();

}
