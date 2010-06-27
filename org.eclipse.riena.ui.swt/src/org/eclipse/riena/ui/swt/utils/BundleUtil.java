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

import org.osgi.framework.Bundle;

/**
 * Helper class with utility method related to bundles.
 */
public final class BundleUtil {

	private BundleUtil() {
		// private constructor of utility class
	}

	public static boolean isReady(Bundle bundle) {
		return bundle != null
				&& ((bundle.getState() & (Bundle.RESOLVED | Bundle.STARTING | Bundle.ACTIVE | Bundle.STOPPING)) != 0);
	}

}
