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
package org.eclipse.riena.internal.ui.swt.utils;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * A collection of utility methods for RCP.
 */
public final class RcpUtilities {

	/**
	 * This class contains only static methods. So it is not necessary to create
	 * an instance.
	 */
	private RcpUtilities() {
		throw new Error("RcpUtilities is just a container for static methods"); //$NON-NLS-1$
	}

	/**
	 * Returns the shell of the active workbench.
	 * 
	 * @return shell of {@code null} if no active workbench exists.
	 */
	public static Shell getWorkbenchShell() {

		if (PlatformUI.isWorkbenchRunning() && PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null) {
			return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		} else {
			return null;
		}

	}

}
