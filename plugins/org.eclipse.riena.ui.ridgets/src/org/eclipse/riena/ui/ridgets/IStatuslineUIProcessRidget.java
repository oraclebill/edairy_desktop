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

import org.eclipse.riena.ui.core.uiprocess.IProgressVisualizerObserver;
import org.eclipse.riena.ui.core.uiprocess.UIProcess;

/**
 * interface for the ridget controlling the display of active {@link UIProcess}
 * ´s infos.
 */
public interface IStatuslineUIProcessRidget extends IProgressVisualizerObserver, IRidget {

	/**
	 * Sets the contextLocator that will be used to help determine the current
	 * active context.
	 * 
	 * @param contextLocator
	 */
	void setContextLocator(IVisualContextManager contextLocator);

}
