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
package org.eclipse.riena.ui.swt.uiprocess;

import org.eclipse.riena.ui.core.uiprocess.UIProcess;

/**
 * Every {@link UIProcess} can be in different states. Usually the following
 * states should be walked through:
 * 
 * {@value #PENDING}, {@value #RUNNING},{@value #FINISHED}
 */
public enum ProcessState {
	PENDING, RUNNING, FINISHED, CANCELED
}