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
package org.eclipse.riena.ui.ridgets.validation;

/**
 * Validator checking that a String matches a given pattern for a Date or
 * represents a valid intermediate state on the way to a valid date. Used during
 * editing to mark dates that start like "42.01.2..." immediately as an error.
 */
public class ValidIntermediateDate extends AbstractValidDate {

	public ValidIntermediateDate() {
		super(true);
	}

	public ValidIntermediateDate(String pattern) {
		super(pattern, true);
	}

}
