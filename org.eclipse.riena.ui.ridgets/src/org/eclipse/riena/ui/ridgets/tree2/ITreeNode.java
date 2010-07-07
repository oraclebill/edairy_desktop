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

import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.riena.ui.ridgets.ITreeRidget;

/**
 * Defines the requirements for an object that can be used as a tree node
 * together with a {@link ITreeRidget}.
 * <p>
 * It is recommended to use {@link TreeNode}. This is a default implementation
 * of this interface that wraps a generic value Object.
 * <p>
 * You are <b>not required</b> to provide your own implementation of this
 * interface. You can bind your value objects of any type directly to an
 * {@link ITreeRidget}, as long as those objects satisfy the following
 * requirements:
 * <ol>
 * <li>they must all have the same type</li>
 * <li>they must provide an read-only accessor for a value (i.e. public Object
 * getXXXX)</li>
 * <li>they must provide read/write accessor for a List of children (i.e. public
 * List&lt;Object&gt; get/setXXXX)</li>
 * <li>they must be able to provide their parent instance (i.e. public Object
 * getXXXXX), which may be null if this object is a tree-root
 * <li>they should (but do not have to) follow the 'beans' convention. I.e.
 * provide support for adding / removing {@link PropertyChangeListener}s and
 * firing property change events. This will allow the tree ridget to keep the
 * tree in sync with the model automatically. Otherwise
 * {@link ITreeRidget#updateFromModel} has to be invoked to resync.</li>
 * </ol>
 * 
 * @see ITreeRidget#bindToModel(Object[], Class, String, String, String)
 */
public interface ITreeNode {

	/**
	 * Property name of the value property ({@value} ).
	 * 
	 * @see #getValue()
	 * @see #setValue(Object)
	 */
	String PROPERTY_VALUE = "value"; //$NON-NLS-1$

	/**
	 * Property name of the children property ({@value} ).
	 * 
	 * @see #getChildren()
	 * @see #setChildren(List)
	 */
	String PROPERTY_CHILDREN = "children"; //$NON-NLS-1$

	/**
	 * Property name of the parent property ({@value} ).
	 * 
	 * @see #getParent()
	 */
	String PROPERTY_PARENT = "parent"; //$NON-NLS-1$

	/**
	 * Returns the children objects of this node.
	 * <p>
	 * The returned list must be a copy, to prevent accidental external
	 * modification of this node's state.
	 * 
	 * @return a List of ITreeNodes; never null; may be empty
	 */
	List<ITreeNode> getChildren();

	/**
	 * Return the value object for this node
	 * 
	 * @return an Object instance (may be null)
	 */
	Object getValue();

	/**
	 * Set the children object for this node.
	 * <p>
	 * The given list should be copied, to prevent accidental external
	 * modification of this node's state.
	 * 
	 * @param children
	 *            a List of ITreeNodes; may be null.
	 */
	void setChildren(List<ITreeNode> children);

	/**
	 * Set the value object for this node
	 * 
	 * @param newValue
	 *            an Object instance (may be null)
	 */
	void setValue(Object newValue);

	/**
	 * Returns the parent tree node <code>ITreeNode</code> of the receiver.
	 * 
	 * @return parent an ITreeNode instance; may be null if this node is a root
	 */
	ITreeNode getParent();

	/**
	 * Adds a PropertyChangeListener for all properties.
	 * <p>
	 * Adding the same listener several times has no effect.
	 * 
	 * @param propertyChangeListener
	 *            The PropertyChangeListener to be added (non-null)
	 * @throws RuntimeException
	 *             if propertyChangeListener is null
	 */
	void addPropertyChangeListener(PropertyChangeListener propertyChangeListener);

	/**
	 * Removes a PropertyChangeListener from this class.
	 * 
	 * @param propertyChangeListener
	 *            The PropertyChangeListener to be removed (non null)
	 * @throws RuntimeException
	 *             if propertyChangeListener is null
	 */
	void removePropertyChangeListener(PropertyChangeListener propertyChangeListener);
}
