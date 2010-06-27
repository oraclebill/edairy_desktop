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
package org.eclipse.riena.ui.swt.lnf;

import org.eclipse.riena.core.injector.extension.ExtensionInterface;
import org.eclipse.riena.core.injector.extension.MapName;
import org.eclipse.riena.ui.ridgets.AbstractMarkerSupport;

/**
 * Marker support with an ID.
 * 
 * @since 2.0
 */
@ExtensionInterface(id = "lnfMarkerSupport")
public interface ILnfMarkerSupportExtension {

	/**
	 * ID of the marker support:
	 * 
	 * @return ID
	 */
	String getId();

	/**
	 * Creates a marker support.
	 * 
	 * @return marker support
	 */
	@MapName("class")
	AbstractMarkerSupport createMarkerSupport();

}
