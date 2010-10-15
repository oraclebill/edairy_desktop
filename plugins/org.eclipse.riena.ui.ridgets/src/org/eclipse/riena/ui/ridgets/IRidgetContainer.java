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

/**
 * A container for ridgets.
 */
public interface IRidgetContainer {
	/**
	 * Adds the ridget with id to the ridgets of this ridget container.
	 * <p>
	 * If the given (id, ridget) pair is already in the container, the previous
	 * value will be replaced.
	 * 
	 * @param id
	 *            the ridget id.
	 * @param ridget
	 *            the ridget.
	 */
	void addRidget(String id, IRidget ridget);

	/**
	 * Returns the ridget with the given id from this ridget container.
	 * 
	 * @param id
	 *            the ridget id.
	 * @return the ridget instance or null, if no ridget with this id was found.
	 */
	IRidget getRidget(String id);

	/**
	 * Returns the ridget with the given id from this container. <br>
	 * If no ridget with that id can be found (e.g. when running controller
	 * tests), this method creates and returns a ridget of the given ridgetClazz
	 * and adds it to the container.
	 * 
	 * @param <R>
	 *            the type of class
	 * @param ridgetClazz
	 *            the class of the ridget
	 * @param id
	 *            the id of the ridget
	 * @return the ridget instance
	 * 
	 * @since 2.0
	 */
	<R extends IRidget> R getRidget(Class<R> ridgetClazz, String id);

	/**
	 * Returns the ridgets of this ridget container.
	 * 
	 * @return the ridgets.
	 */
	Collection<? extends IRidget> getRidgets();

	/**
	 * This method is called after all ridgets are injected.
	 */
	void configureRidgets();

}
