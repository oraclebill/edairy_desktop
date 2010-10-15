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

import java.util.Collection;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;

import org.eclipse.riena.ui.core.marker.IMessageMarker;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.validation.ValidationRuleStatus;

/**
 * Ridget with a value that can be edited, validated and converted.
 */
public interface IEditableRidget extends IValueRidget {

	/**
	 * Returns the converter that is used when updating from the UI-control to
	 * the model.
	 * 
	 * @return converter from UI-control to model
	 */
	IConverter getUIControlToModelConverter();

	/**
	 * Sets the converter used when updating from the UI-control to the model.
	 * 
	 * @param converter
	 *            The new converter.
	 */
	void setUIControlToModelConverter(IConverter converter);

	/**
	 * Returns all validators that were added to this ridget.
	 * 
	 * @return the validation rules
	 * 
	 * @see #addValidationRule(IValidator)
	 */
	Collection<IValidator> getValidationRules();

	/**
	 * Adds a validator to this ridget.
	 * <p>
	 * By default validators will be evaluated when updating from the UI-control
	 * to the ridget ("on edit") and when updating from the ridget to the model
	 * ("on update").
	 * <p>
	 * Failed validators cause an error marker to appear next to the UI-control.
	 * "On edit" validators may choose to block user input. The reaction to a
	 * failed validation can be changed by return an {@link IStatus} instance
	 * with a special code - see {@link ValidationRuleStatus}.
	 * <p>
	 * Adding the same validator several times has no effect.
	 * 
	 * @param validator
	 *            The validator to add (non-null).
	 * @param validationTime
	 *            a value specifying when to evaluate the validator (non-null)
	 * 
	 * @see #removeValidationRule(IValidator)
	 * @see #revalidate()
	 * @see IValidator
	 * @see ValidationRuleStatus
	 */
	void addValidationRule(IValidator validator, ValidationTime validationTime);

	/**
	 * Removes a validator.
	 * 
	 * @param validator
	 *            The validation rule to remove.
	 * 
	 * @see #addValidationRule(IValidator, ValidationTime)
	 * @see #revalidate()
	 */
	void removeValidationRule(IValidator validator);

	/**
	 * Adds a message to be displayed when any validation rule of the ridget
	 * fails.
	 * <p>
	 * Adding the same message several times has no effect.
	 * 
	 * @param message
	 *            A message related to the failed validation.
	 */
	void addValidationMessage(String message);

	/**
	 * Adds a message to be displayed when the specified validation rule fails.
	 * This will not add the rule to the ridget. If the specified rule was not
	 * added to the ridget the message will never be displayed.
	 * <p>
	 * Adding the same message several times has no effect.
	 * 
	 * @param message
	 *            A message related to the failed validation.
	 * @param validationRule
	 *            The validation rule related to the message.
	 * 
	 * @see #addValidationRule(IValidator)
	 */
	void addValidationMessage(String message, IValidator validationRule);

	/**
	 * Adds an IMessageMarker to be added to the ridget automatically when and
	 * only when a validation rule fails.
	 * <p>
	 * Adding the same message several times has no effect.
	 * 
	 * @param messageMarker
	 *            An IMessageMarker related to the failed validation.
	 * 
	 * @see org.eclipse.riena.core.marker.IMarkable#addMarker(org.eclipse.riena.core.marker.IMarker)
	 * @see org.eclipse.riena.core.marker.IMarkable#removeMarker(org.eclipse.riena.core.marker.IMarker)
	 */
	void addValidationMessage(IMessageMarker messageMarker);

	/**
	 * Adds an IMessageMarker to be added to the ridget automatically when and
	 * only when the specified validation rule fails. This will not add the rule
	 * to the ridget. If the specified rule was not added to the ridget the
	 * message will never be displayed.
	 * <p>
	 * Adding the same message several times has no effect.
	 * 
	 * @param messageMarker
	 *            An IMessageMarker related to the failed validation.
	 * @param validationRule
	 *            The validation rule related to the IMessageMarker.
	 * 
	 * @see #addValidationRule(IValidator)
	 * @see org.eclipse.riena.core.marker.IMarkable#addMarker(org.eclipse.riena.core.marker.IMarker)
	 * @see org.eclipse.riena.core.marker.IMarkable#removeMarker(org.eclipse.riena.core.marker.IMarker)
	 */
	void addValidationMessage(IMessageMarker messageMarker, IValidator validationRule);

	/**
	 * Removes a message to be displayed when any validation rule of the ridget
	 * fails. If the message was never added this method does nothing.
	 * 
	 * @param message
	 *            The message to remove.
	 */
	void removeValidationMessage(String message);

	/**
	 * Removes a message to be displayed when the specified validation rule of
	 * the ridget fails. If the message was never added this method does
	 * nothing.
	 * 
	 * @param message
	 *            The message to remove.
	 * @param validationRule
	 *            The validation rule related to the message.
	 */
	void removeValidationMessage(String message, IValidator validationRule);

	/**
	 * Removes an IMessageMarker to be added to the ridget automatically when
	 * and only when a validation rule fails. If the IMessageMarker was never
	 * added this method does nothing.
	 * 
	 * @param messageMarker
	 *            The IMessageMarker to remove.
	 */
	void removeValidationMessage(IMessageMarker messageMarker);

	/**
	 * Removes an IMessageMarker to be added to the ridget automatically when
	 * and only when the specified validation rule fails. If the IMessageMarker
	 * was never added this method does nothing.
	 * 
	 * @param messageMarker
	 *            The IMessageMarker to remove.
	 * @param validationRule
	 *            The validation rule related to the IMessageMarker.
	 */
	void removeValidationMessage(IMessageMarker messageMarker, IValidator validationRule);

	/**
	 * Revalidate the ridget using the current validation rules. It can be used
	 * to update the validation state after adding or removing validation rules
	 * from the ridget.
	 * <p>
	 * If the new validation state is 'valid' this method will update the model
	 * with the current value from the ridget.
	 * 
	 * @return true if all validation rules have passed without errors, false
	 *         otherwise
	 * 
	 * @see #addValidationRule(IValidator, ValidationTime)
	 * @see #removeValidationRule(IValidator)
	 */
	boolean revalidate();

}
