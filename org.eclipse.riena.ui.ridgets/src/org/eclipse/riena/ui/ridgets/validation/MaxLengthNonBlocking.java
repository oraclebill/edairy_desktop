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
 * Non-blocking 'maximum length' validation rule.
 * <p>
 * This rule will flag strings that exceed a certain length as 'not valid' but
 * will not block user input.
 * 
 * @since 1.2
 */
public class MaxLengthNonBlocking extends MaxLength {

	public MaxLengthNonBlocking() {
		super(0, false);
	}

	public MaxLengthNonBlocking(int maxLength) {
		super(maxLength, false);
	}

}
