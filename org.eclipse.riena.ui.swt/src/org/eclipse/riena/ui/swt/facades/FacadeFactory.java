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

import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;

/**
 * Returns an RCP or RAP specific instance of a given type.
 */
final class FacadeFactory {

	/**
	 * Returns an RCP or RAP specific instance of the given type.
	 * <p>
	 * The code will append "RAP" or "RCP" to the given type, try to load the
	 * resulting class and invoke the 0-argument constructor. If successfull it
	 * will return an instance that implements the argument {@code type}.
	 * 
	 * @param type
	 *            the desired type; never null
	 * @return an instance of type; never null
	 * @throws RuntimeException
	 *             if no matching instance could be found
	 */
	static Object newFacade(final Class<?> type) {
		String suffix = "rap".equals(SWT.getPlatform()) ? "RAP" : "RCP"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		String name = type.getName() + suffix;
		try {
			return type.getClassLoader().loadClass(name).newInstance();
		} catch (Throwable throwable) {
			String msg = NLS.bind("Could not load {0}", name); //$NON-NLS-1$
			throw new RuntimeException(msg, throwable);
		}
	}

}
