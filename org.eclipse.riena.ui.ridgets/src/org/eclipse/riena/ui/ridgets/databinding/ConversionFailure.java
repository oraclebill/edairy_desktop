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
package org.eclipse.riena.ui.ridgets.databinding;

import org.eclipse.riena.core.exception.Failure;

/**
 * Failure during a conversion. Should be prevented by using a Validator.
 * 
 * @see org.eclipse.core.databinding.conversion.IConverter
 * @see org.eclipse.core.databinding.validation.IValidator
 */
public class ConversionFailure extends Failure {

	private static final long serialVersionUID = -527421462771521337L;

	/**
	 * Creates a ConversionFailure.
	 * 
	 * @param msg
	 *            A message.
	 */
	public ConversionFailure(String msg) {
		super(msg);
	}

	/**
	 * Creates a ConversionFailure.
	 * 
	 * @param msg
	 *            A message.
	 * @param cause
	 *            The cause.
	 */
	ConversionFailure(String msg, Throwable cause) {
		super(msg, cause);
	}

}
