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

import org.eclipse.core.databinding.observable.list.IObservableList;

/**
 * Ridget for lists (equivalent to tables with one column and no headers).
 * 
 * @since 1.2
 */
public interface IListRidget extends ITableRidget {

	/**
	 * Binds the list to the model data.
	 * 
	 * @param rowObservables
	 *            An observable list of objects (non-null).
	 * @param rowClass
	 *            The class of the objects in the list.
	 * @param columnPropertyName
	 *            The non-null property name to access the row value. Each
	 *            object in rowObservables must have a corresponding getter.
	 */
	void bindToModel(IObservableList rowObservables, Class<? extends Object> rowClass, String columnPropertyName);

	/**
	 * Binds the list to the model data.
	 * 
	 * @param listHolder
	 *            An object that has a property with a list of objects.
	 * @param listPropertyName
	 *            Property for accessing the list of objects.
	 * @param rowClass
	 *            The class of the objects in the list.
	 * @param columnPropertyName
	 *            The non-null property name to access the row value. Each
	 *            object in rowObservables must have a corresponding getter.
	 */
	void bindToModel(Object listHolder, String listPropertyName, Class<? extends Object> rowClass,
			String columnPropertyName);

	/**
	 * Binds the list to the model data. Uses toString-Method for accessing the
	 * row value.
	 * 
	 * @param listHolder
	 *            An object that has a property with a list of objects.
	 * @param listPropertyName
	 *            Property for accessing the list of objects.
	 */
	void bindToModel(Object listHolder, String listPropertyName);
}
