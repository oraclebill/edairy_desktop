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
package org.eclipse.riena.ui.swt.utils;

import org.eclipse.riena.ui.ridgets.IRidget;

/**
 * Interface for classes that don't support a data-Property by there own.
 * <p>
 * 
 * Implementations of this class will be used to locate a bindingId of a
 * {@link IRidget}.
 * 
 * @see SWTBindingPropertyLocator
 */
public interface IPropertyNameProvider {

	/**
	 * Gets the propertyName.
	 * 
	 * @return
	 */
	String getPropertyName();

	/**
	 * Sets the proptyName.
	 * 
	 * @param propertyName
	 */
	void setPropertyName(String propertyName);
}
