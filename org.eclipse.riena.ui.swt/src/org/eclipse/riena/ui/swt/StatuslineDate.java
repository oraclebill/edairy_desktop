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
package org.eclipse.riena.ui.swt;

import java.text.SimpleDateFormat;

import org.eclipse.swt.widgets.Composite;

/**
 * Represents a label of the status line that displays the current date.
 */
public class StatuslineDate extends StatuslineTime {

	/**
	 * Creates a new instance of <code>StatuslineDate</code>.
	 * 
	 * @param parent
	 *            a widget which will be the parent of the new instance
	 *            (cannot be null)
	 * @param style
	 *            the style of widget to construct
	 */
	public StatuslineDate(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * Returns the format of the date and/or time.
	 * 
	 * @return format
	 */
	@Override
	protected SimpleDateFormat getFormat() {

		if (format == null) {
			format = new SimpleDateFormat("dd.MM.yyyy"); //$NON-NLS-1$
		}
		return format;

	}

}
