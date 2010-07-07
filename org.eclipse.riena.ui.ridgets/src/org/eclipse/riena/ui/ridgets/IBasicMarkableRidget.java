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

import org.eclipse.riena.core.marker.IMarkable;

/**
 * A Ridget with a basic support for markers.
 */
public interface IBasicMarkableRidget extends IRidget, IMarkable {

	/**
	 * The name of the PropertyChangeEvent that will be fired if a marker was
	 * added or removed ("marker").
	 */
	String PROPERTY_MARKER = "marker"; //$NON-NLS-1$

}
