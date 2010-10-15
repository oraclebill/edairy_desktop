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
package org.eclipse.riena.ui.ridgets.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.riena.ui.core.context.IContext;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IDefaultActionManager;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IWindowRidget;

/**
 * Controller for a view that is or has a window.
 * 
 */
public abstract class AbstractWindowController implements IController, IContext {

	/**
	 * The ridget id to use for the window ridget.
	 */
	public static final String RIDGET_ID_WINDOW = "windowRidget"; //$NON-NLS-1$

	/**
	 * Return code to indicate that the window was a OK-ed (value: {@value} ).
	 * 
	 * @see #getReturnCode()
	 * @since 1.2
	 */
	public static final int OK = 0;

	/**
	 * Return code to indicate that the window was cancelled (value: {@value} ).
	 * 
	 * @see #getReturnCode()
	 * @since 1.2
	 */
	public static final int CANCEL = 1;

	private final Map<String, IRidget> ridgets;
	private final Map<String, Object> context;
	private IWindowRidget windowRidget;
	private boolean blocked;
	private int returnCode;

	private IDefaultActionManager actionManager;

	public AbstractWindowController() {
		super();
		ridgets = new HashMap<String, IRidget>();
		context = new HashMap<String, Object>();
	}

	/**
	 * Make {@code action} the default action while the focus is within
	 * {@code focusRidget} including it's children.
	 * <p>
	 * If a default action is available and enabled, it will be invoked whenever
	 * the user presses ENTER within the window.
	 * <p>
	 * Note: the algorithm stops at the first match. It will check the most
	 * specific (innermost) ridget first and check the most general (outremost)
	 * ridget last.
	 * 
	 * @param focusRidget
	 *            the ridget that needs to have the focus to activate this rule.
	 *            Never null.
	 * @param action
	 *            this ridget will become the default action, while focusRidget
	 *            has the focus. Never null.
	 * 
	 * @since 2.0
	 */
	public void addDefaultAction(IRidget focusRidget, IActionRidget action) {
		actionManager = getWindowRidget().addDefaultAction(focusRidget, action);
	}

	public void addRidget(String id, IRidget ridget) {
		ridgets.put(id, ridget);
	}

	public void afterBind() {
		returnCode = OK;
		getWindowRidget().updateFromModel();
		if (actionManager != null) {
			actionManager.activate();
		}
	}

	public void configureRidgets() {
		setWindowRidget((IWindowRidget) getRidget(RIDGET_ID_WINDOW));
	}

	/**
	 * @since 1.2
	 */
	public Object getContext(String key) {
		return context.get(key);
	}

	public IRidget getRidget(String id) {
		return ridgets.get(id);
	}

	/**
	 * @since 2.0
	 */
	@SuppressWarnings("unchecked")
	public <R extends IRidget> R getRidget(Class<R> ridgetClazz, String id) {
		return (R) getRidget(id);
	}

	public Collection<? extends IRidget> getRidgets() {
		return ridgets.values();
	}

	/**
	 * @return The window ridget.
	 */
	public IWindowRidget getWindowRidget() {
		return windowRidget;
	}

	/**
	 * Returns the return code for this window.
	 * <p>
	 * These codes are window specific, but two return codes are already
	 * defined: {@link #OK} and {@link #CANCEL}.
	 * 
	 * @since 1.2
	 */
	public int getReturnCode() {
		return returnCode;
	}

	public boolean isBlocked() {
		return this.blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
		// TODO: implement
	}

	/**
	 * @since 1.2
	 */
	public void setContext(String key, Object value) {
		context.put(key, value);
	}

	/**
	 * Set the return code for this window.
	 * <p>
	 * These codes are window specific, but two return codes are already
	 * defined: {@link #OK} and {@link #CANCEL}.
	 * 
	 * @since 1.2
	 */
	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	/**
	 * Sets the window ridget.
	 * 
	 * @param windowRidget
	 *            The window ridget.
	 */
	public void setWindowRidget(IWindowRidget windowRidget) {
		this.windowRidget = windowRidget;
	}
}
