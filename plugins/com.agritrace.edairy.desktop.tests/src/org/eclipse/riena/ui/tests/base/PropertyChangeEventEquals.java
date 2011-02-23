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
package org.eclipse.riena.ui.tests.base;

import java.beans.PropertyChangeEvent;

import org.easymock.EasyMock;
import org.easymock.IArgumentMatcher;

/**
 * Argument matcher checking if two property change events are equal.
 */
public class PropertyChangeEventEquals implements IArgumentMatcher {

	private PropertyChangeEvent expected;

	/**
	 * Creates and reports an argument matcher for the specified property change
	 * event. See EasyMock 2 documentation:
	 * http://www.easymock.org/EasyMock2_2_Documentation.html
	 * 
	 * @param <T>
	 * @param expected
	 *            The expected property change event.
	 * @return null, intended to be used a argument for a method call of a mock
	 *         object.
	 */
	public static <T extends PropertyChangeEvent> T eqPropertyChangeEvent(T expected) {
		EasyMock.reportMatcher(new PropertyChangeEventEquals(expected));
		return null;
	}

	/**
	 * Creates an argument matcher that checks if some actual property change
	 * event matches the expected one.
	 * 
	 * @param expected
	 *            The expected property change event.
	 */
	public PropertyChangeEventEquals(PropertyChangeEvent expected) {
		this.expected = expected;
	}

	/**
	 * @see org.easymock.IArgumentMatcher#matches(java.lang.Object)
	 */
	public boolean matches(Object actualObject) {
		if (actualObject instanceof PropertyChangeEvent) {
			PropertyChangeEvent actual = (PropertyChangeEvent) actualObject;
			return expected.getSource().equals(actual.getSource())
					&& expected.getPropertyName().equals(actual.getPropertyName())
					&& equals(expected.getOldValue(), actual.getOldValue())
					&& equals(expected.getNewValue(), actual.getNewValue());
		} else {
			return false;
		}
	}

	private boolean equals(Object value1, Object value2) {
		return (value1 == null && value2 == null) || (value1 != null && value1.equals(value2));
	}

	/**
	 * @see org.easymock.IArgumentMatcher#appendTo(java.lang.StringBuffer)
	 */
	public void appendTo(StringBuffer buffer) {
		buffer.append("eqPropertyChangeEvent(");
		buffer.append(expected.getClass().getName());
		buffer.append(" with source <");
		buffer.append(expected.getSource());
		buffer.append(">, property name \"");
		buffer.append(expected.getPropertyName());
		buffer.append("\", old value <");
		buffer.append(expected.getOldValue());
		buffer.append("> and new value <");
		buffer.append(expected.getNewValue());
		buffer.append(">)");
	}

}
