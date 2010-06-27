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
package org.eclipse.riena.ui.swt.utils;

/**
 * Utility class for UI testing
 * 
 * @since 1.2
 */
public final class TestingSupport {

	private TestingSupport() {
		// utility class
	}

	/**
	 * 
	 * @return true if UI is started in testing mode. It checks if
	 *         'riena.testing' system property is set to {@code true} otherwise
	 *         {@code false}.
	 */
	public static boolean isTestingEnabled() {
		return Boolean.getBoolean("riena.testing"); //$NON-NLS-1$
	}
}
