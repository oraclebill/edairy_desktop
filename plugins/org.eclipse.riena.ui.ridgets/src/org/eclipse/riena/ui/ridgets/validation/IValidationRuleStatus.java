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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * Result of a validation.
 * 
 * @deprecated use {@link Status} or {@link IStatus}
 */
public interface IValidationRuleStatus extends IStatus {

	/**
	 * Status code indicating that the effects of the last edit that was
	 * verified must be undone and that the UI-control must be marked with a
	 * temporary ErrorMarker.
	 * 
	 * @see IStatus#getCode()
	 * 
	 * @deprecated use {@link ValidationRuleStatus#ERROR_BLOCK_WITH_FLASH}
	 */
	int ERROR_BLOCK_WITH_FLASH = ValidationRuleStatus.ERROR_BLOCK_WITH_FLASH;

	/**
	 * Status code indicating that the effects of the last edit that was
	 * verified should be allowed for the UI-control. The UI-control must be
	 * marked with an ErrorMarker until the next validation.
	 * 
	 * @see IStatus#getCode()
	 * 
	 * @deprecated use {@link ValidationRuleStatus#ERROR_ALLOW_WITH_MESSAGE}
	 */
	int ERROR_ALLOW_WITH_MESSAGE = ValidationRuleStatus.ERROR_ALLOW_WITH_MESSAGE;

}
