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

import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

/**
 * Facade for the {@link ActionFactory} class.
 * 
 * @since 2.0
 */
public abstract class ActionFactoryFacade {

	private static final ActionFactoryFacade INSTANCE = (ActionFactoryFacade) FacadeFactory
			.newFacade(ActionFactoryFacade.class);

	public static final ActionFactoryFacade getDefault() {
		return INSTANCE;
	}

	/**
	 * Return a new ABOUT action
	 * 
	 * @param window
	 *            an {@link IWorkbenchWindow}; never null.
	 * @return an Action or null
	 */
	public abstract IWorkbenchAction createAboutAction(IWorkbenchWindow window);
}
