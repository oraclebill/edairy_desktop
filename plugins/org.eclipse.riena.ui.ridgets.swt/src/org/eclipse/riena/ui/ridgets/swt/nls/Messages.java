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
package org.eclipse.riena.ui.ridgets.swt.nls;

import org.eclipse.osgi.util.NLS;

/**
 * Provides internationalized UI strings.
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.riena.ui.ridgets.swt.nls.messages"; //$NON-NLS-1$

	public static String AbstractComboRidget_markerMessage_selectionMismatch;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
