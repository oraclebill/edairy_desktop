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
package org.eclipse.riena.ui.ridgets.tree2;

import org.eclipse.riena.ui.ridgets.ITreeRidget;

/**
 * Defines additional requirements for an object that is used as a tree node
 * together with a {@link ITreeRidget}.
 * <p>
 * It is recommended to use {@link TreeNode}. This is a default implementation
 * of this interface that wraps a generic value Object.
 * <p>
 * You are <b>not required</b> to provide your own implementation. You can bind
 * your value objects directly to the {@link ITreeRidget}.
 * 
 * @see ITreeRidget#bindToModel(Object[], Class, String, String, String)
 * @see ITreeRidget#bindToModel(Object[], Class, String, String, String, String,
 *      String)
 * @see ITreeNode
 */
public interface ITreeNode2 extends ITreeNode {

	/**
	 * Property name of the enabled property ({@value} ).
	 * 
	 * @see #isEnabled()
	 */
	String PROPERTY_ENABLED = "enabled"; //$NON-NLS-1$

	/**
	 * Property name of the visible property ({@value} ).
	 * 
	 * @see #isVisible()
	 */
	String PROPERTY_VISIBLE = "visible"; //$NON-NLS-1$

	/**
	 * Returns true if this node is enabled, false otherwise.
	 * 
	 * @return <code>true</code> if enabled otherwise <code>false</code>
	 */
	boolean isEnabled();

	/**
	 * Returns true if this node is visible, false otherwise.
	 * 
	 * @return <code>true</code> if visible otherwise <code>false</code>
	 */
	boolean isVisible();
}
