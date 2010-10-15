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

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;

import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.internal.ui.ridgets.Activator;

/**
 * Utility class for working with {@link IStatus} objects writing validation
 * rules ({@link IValidator} implementations).
 * <p>
 * This class defines Riena specific error codes that can be used in
 * {@link IStatus} objects to trigger certain behavior in the ridgets (such as
 * 'blocking' of user input).
 * <p>
 * It also provides helper methods for creating or joining {@link IStatus}
 * instances.
 */
public final class ValidationRuleStatus {

	/**
	 * Status code indicating that the effects of the last edit that was
	 * verified must be undone and that the UI-control must be marked with a
	 * temporary ErrorMarker.
	 * 
	 * @see IStatus#getCode()
	 * 
	 * @since 1.2
	 */
	public static final int ERROR_BLOCK_WITH_FLASH = 1024;

	/**
	 * Status code indicating that the effects of the last edit that was
	 * verified should be allowed for the UI-control. The UI-control must be
	 * marked with an ErrorMarker until the next validation.
	 * 
	 * @see IStatus#getCode()
	 * 
	 * @since 1.2
	 */
	public static final int ERROR_ALLOW_WITH_MESSAGE = 1025;

	/**
	 * Returns an OK status.
	 * 
	 * @return an OK status
	 */
	public static IStatus ok() {
		return Status.OK_STATUS;
	}

	/**
	 * Returns an ERROR status
	 * 
	 * @param blocker
	 *            Indicates whether the effects of the input that lead to the
	 *            error status must be undone i.e. whether the input must be
	 *            blocked.
	 * @param message
	 *            A message.
	 * @param source
	 *            <b>is UNUSED</b>
	 * @return An ERROR status; never null.
	 * 
	 * @deprecated use {@link #error(boolean, String)}
	 */
	public static IStatus error(boolean blocker, String message, IValidator source) {
		return error(blocker, message);
	}

	/**
	 * Returns an ERROR status
	 * 
	 * @param blocker
	 *            Indicates whether the effects of the input that lead to the
	 *            error status must be undone i.e. whether the input must be
	 *            blocked.
	 * @param message
	 *            A message.
	 * 
	 * @return An ERROR status; never null.
	 * 
	 * @since 1.2
	 */
	public static IStatus error(boolean blocker, String message) {
		int code = blocker ? ERROR_BLOCK_WITH_FLASH : ERROR_ALLOW_WITH_MESSAGE;
		return new Status(IStatus.ERROR, Activator.PLUGIN_ID, code, message, null);
	}

	/**
	 * Returns a MultiStatus that joins multiple statuses. The code that holds
	 * the blocking information will be set to the most severe of the joined
	 * statuses.
	 * 
	 * @param statuses
	 *            The statuses to join.
	 * @return The joined status.
	 */
	public static IStatus join(IStatus[] statuses) {
		IStatus result;
		if (statuses.length == 1) {
			result = statuses[0];
		} else {
			int code = ValidationRuleStatus.ERROR_ALLOW_WITH_MESSAGE;
			StringBuilder allMessages = new StringBuilder();
			for (IStatus status : statuses) {
				if (status.getCode() == ValidationRuleStatus.ERROR_BLOCK_WITH_FLASH) {
					code = ValidationRuleStatus.ERROR_BLOCK_WITH_FLASH;
				}
				if (!StringUtils.isDeepEmpty(status.getMessage())) {
					allMessages.append(status.getMessage() + "\n"); //$NON-NLS-1$
				}
			}
			String message = allMessages.length() == 0 ? null : allMessages.toString();
			result = new MultiStatus(Activator.PLUGIN_ID, code, statuses, message, null);
		}
		return result;
	}

	private ValidationRuleStatus() {
		// prevent instantiation
	}

}
