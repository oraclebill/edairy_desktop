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
package org.eclipse.riena.internal.ui.ridgets.swt.uiprocess;

import java.util.Comparator;

import org.eclipse.riena.ui.swt.StatuslineUIProcess;

/**
 * Default implementation for the {@link Comparator} for {@link ProcessDetail}
 * instances for control of order in the {@link StatuslineUIProcess} window.
 */
public class DefaultProcessDetailComparator implements Comparator<ProcessDetail> {

	public int compare(ProcessDetail detail1, ProcessDetail detail2) {
		return ((Long) detail2.getStartupTS()).compareTo(detail1.getStartupTS());
	}

}
