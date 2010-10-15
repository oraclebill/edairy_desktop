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

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;

/**
 * Ridget with a value.
 */
public interface IValueRidget extends IRidget {

	/**
	 * Creates a binding between the Ridget value and the specified model value.
	 * The UpdateValueStrategy will be POLICY_UPDATE to the model value
	 * (automatic update) and POLICY_ON_REQUEST from the model value.
	 * 
	 * @param observableValue
	 *            The model value.
	 * @see #updateFromModel()
	 */
	void bindToModel(IObservableValue observableValue);

	/**
	 * Creates an observable value from the specified property (i.e. getter) and
	 * binds it to the Ridget value using a default binding. The
	 * UpdateValueStrategy will be POLICY_UPDATE to the model value (automatic
	 * update) and POLICY_ON_REQUEST from the model value.
	 * 
	 * @param valueHolder
	 *            An object holding the model value.
	 * @param valuePropertyName
	 *            Name of property (example 'name' -> getName()) holding the
	 *            model value.
	 * @see #updateFromModel()
	 */
	void bindToModel(Object valueHolder, String valuePropertyName);

	/**
	 * Returns The converter used when updating from the model to the
	 * UI-control.
	 * 
	 * @return converter model to UI-control
	 */
	IConverter getModelToUIControlConverter();

	/**
	 * Sets the converter used when updating from the model to the UI-control.
	 * 
	 * @param converter
	 *            new converter model to UI-control
	 */
	void setModelToUIControlConverter(IConverter converter);
}
