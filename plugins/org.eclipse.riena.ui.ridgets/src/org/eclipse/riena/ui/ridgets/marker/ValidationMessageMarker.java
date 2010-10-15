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
package org.eclipse.riena.ui.ridgets.marker;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.Assert;

import org.eclipse.riena.core.marker.AbstractMarker;
import org.eclipse.riena.ui.core.marker.IMessageMarker;
import org.eclipse.riena.ui.core.marker.MessageMarker;

public class ValidationMessageMarker extends AbstractMarker implements IMessageMarker {

	private static final String MESSAGE_MARKER_ATTRIBUTE = "wrappedMessageMarker"; //$NON-NLS-1$

	private IValidator validationRule;

	/**
	 * Create a new {@link ValidationMessageMarker} with the given messageMarker
	 * 
	 * @param messageMarker
	 *            an {@link IMessageMarker}; never null
	 */
	public ValidationMessageMarker(IMessageMarker messageMarker) {
		this(messageMarker, null);
	}

	/**
	 * Create a new {@link ValidationMessageMarker} with the given messageMarker
	 * 
	 * @param messageMarker
	 *            an {@link IMessageMarker}; never null
	 * @param validationRule
	 *            the validationRule associated with the {@link MessageMarker};
	 *            may be null
	 */
	public ValidationMessageMarker(IMessageMarker messageMarker, IValidator validationRule) {
		super(false);
		Assert.isNotNull(messageMarker, "messageMarker cannot be null"); //$NON-NLS-1$
		setAttribute(MESSAGE_MARKER_ATTRIBUTE, messageMarker);
		this.validationRule = validationRule;
	}

	public String getMessage() {
		return getMessageMarker().getMessage();
	}

	/**
	 * Return the IValidator held by this instance; may be null.
	 */
	public IValidator getValidationRule() {
		return validationRule;
	}

	/**
	 * Return the {@link IMessageMarker} held by this instance; never null.
	 */
	public IMessageMarker getMessageMarker() {
		return (IMessageMarker) getAttribute(MESSAGE_MARKER_ATTRIBUTE);
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof ValidationMessageMarker) {
			ValidationMessageMarker otherValidationMessageMarker = (ValidationMessageMarker) other;
			return super.equals(other)
					&& ((getValidationRule() == null && otherValidationMessageMarker.getValidationRule() == null) || (getValidationRule() != null && getValidationRule()
							.equals(otherValidationMessageMarker.getValidationRule())));
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = getMessage().hashCode();
		if (validationRule != null) {
			result = result + (17 * validationRule.hashCode());
		}
		return result;
	}

}
