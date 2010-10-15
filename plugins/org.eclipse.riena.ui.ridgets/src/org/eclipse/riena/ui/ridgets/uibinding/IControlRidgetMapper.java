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
package org.eclipse.riena.ui.ridgets.uibinding;

import org.eclipse.riena.ui.ridgets.IRidget;

/**
 * Interface for mapping UI control-classes to ridget-classes.
 */
public interface IControlRidgetMapper<C> {

	/**
	 * Returns the ridget-class for a UI control-class
	 * 
	 * @param controlClazz
	 *            is the class of the UI Control
	 * @return the mapped ridget-class
	 */
	Class<? extends IRidget> getRidgetClass(Class<? extends C> controlClazz);

	/**
	 * Returns the ridget-class for a UI control
	 * 
	 * @param control
	 *            the UI control
	 * @return the mapped ridget-class
	 */
	Class<? extends IRidget> getRidgetClass(C control);

	/**
	 * Adds a mapping of a UI control-class to a ridget-class
	 * <p>
	 * Adding the same mapping twice has no effect.
	 * 
	 * @param controlClazz
	 *            the class of the UI control
	 * @param ridgetClazz
	 *            the class of the ridget
	 */
	void addMapping(Class<? extends C> controlClazz, Class<? extends IRidget> ridgetClazz);

	/**
	 * Adds a mapping of a UI control-class to a ridget-class. The mapping will
	 * only apply when the given condition evaluates to true.
	 * <p>
	 * Example:
	 * <p>
	 * {@code addMapping(Tree.class, TreeRidget.class, new
	 * TreeWithoutColumnsCondition());}
	 * <p>
	 * Adding the same mapping twice has no effect (but is possible).
	 * 
	 * @param controlClazz
	 *            the class of the UI control (<code>Object</code>)
	 * @param ridgetClazz
	 *            the class of the ridget
	 * @param condition
	 *            the condition to evaluate (non-null)
	 * @see IMappingCondition
	 * @since 1.2
	 */
	void addMapping(Class<? extends Object> controlClazz, Class<? extends IRidget> ridgetClazz,
			IMappingCondition condition);
}
