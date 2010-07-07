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

import org.eclipse.riena.ui.core.resource.IconSize;

/**
 * A ridget for UI controls that allow an action to be performed on them, like
 * clicking a button.
 */
public interface IActionRidget extends IRidget {

	/**
	 * Property name of the text property.
	 * 
	 * @see #getText()
	 * @see #setText(String)
	 * @since 1.2
	 */
	String PROPERTY_TEXT = "text"; //$NON-NLS-1$

	String BASE_ID_TOOLBARACTION = "toolbarAction."; //$NON-NLS-1$
	String BASE_ID_MENUACTION = "menuAction."; //$NON-NLS-1$

	/**
	 * Add an action listener to call back.
	 * <p>
	 * Adding the same listener several times has no effect.
	 * 
	 * @param listener
	 *            a non-null action listener.
	 */
	void addListener(IActionListener listener);

	/**
	 * Add an action listener to call back. This method is equal to calling
	 * #addListener(java.beans.EventHandler.create(IActionListener.class,
	 * target, method))
	 * <p>
	 * Adding the same listener several times has no effect.
	 * 
	 * @param target
	 *            the object to notify
	 * @param action
	 *            the method on {@code target} to invoke
	 * @see java.beans.EventHandler#create(Class, Object, String)
	 * 
	 * @deprecated use {@link #addListener(IActionListener)} or
	 *             {@code
	 *             IActionListener listener =
	 *             EventHandler.create(IActionListener.class, target, action);
	 *             this.addListener(listener);}
	 */
	void addListener(Object target, String action);

	/**
	 * Remove an action listener.
	 * 
	 * @param listener
	 *            the action listener.
	 */
	void removeListener(IActionListener listener);

	/**
	 * Set the text used to visualize the action.
	 * 
	 * @param newText
	 *            the text.
	 */
	void setText(String newText);

	/**
	 * Get the text used to visualize the action.
	 * 
	 * @return the text.
	 */
	String getText();

	/**
	 * Returns the name of the icon.
	 * 
	 * @see #setIcon
	 * 
	 * @return the name of icon.
	 */
	String getIcon();

	/**
	 * Sets the name of the icon.
	 * 
	 * @param iconName
	 *            name of the icon
	 * 
	 */
	void setIcon(String iconName);

	/**
	 * Sets the name and the size of the icon.
	 * 
	 * @param iconName
	 *            name of the icon
	 * @param size
	 *            size of the icon
	 * @since 2.0
	 */
	void setIcon(String iconName, IconSize size);

	/**
	 * Invokes a selection command on the ridget.
	 * 
	 * @since 2.0
	 */
	void fireAction();
}
