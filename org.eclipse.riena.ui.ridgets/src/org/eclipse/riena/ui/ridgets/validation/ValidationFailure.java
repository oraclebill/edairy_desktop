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

import org.eclipse.riena.core.exception.Failure;

/**
 * Failure during a validation.
 * 
 * @see org.eclipse.core.databinding.validation.IValidator
 */
public class ValidationFailure extends Failure {

	private static final long serialVersionUID = 6433769669502871767L;

	/**
	 * Creates a ValidationFailure.
	 * 
	 * @param msg
	 *            A message.
	 */
	public ValidationFailure(String msg) {
		super(msg);
	}

	/**
	 * Creates a ValidationFailure.
	 * 
	 * @param msg
	 *            A message.
	 * @param cause
	 *            The cause.
	 */
	ValidationFailure(String msg, Throwable cause) {
		super(msg, cause);
	}

}
