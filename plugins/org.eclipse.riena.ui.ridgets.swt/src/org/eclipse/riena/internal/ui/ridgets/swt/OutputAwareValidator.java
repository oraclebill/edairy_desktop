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
package org.eclipse.riena.internal.ui.ridgets.swt;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;

/**
 * This validator will cancel a ui-to-model update when the ridget is set to
 * "output only". This prevents the user from modifying the ridget selection
 * observable when the ridget is in "output only" mode.
 */
public final class OutputAwareValidator implements IValidator {

	private final IMarkableRidget ridget;

	public OutputAwareValidator(IMarkableRidget ridget) {
		Assert.isNotNull(ridget);
		this.ridget = ridget;
	}

	public IStatus validate(Object value) {
		return ridget.isOutputOnly() ? Status.CANCEL_STATUS : Status.OK_STATUS;
	}
}
