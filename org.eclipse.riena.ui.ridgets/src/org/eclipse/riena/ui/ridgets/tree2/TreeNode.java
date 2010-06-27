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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.riena.beans.common.AbstractBean;
import org.eclipse.riena.ui.ridgets.ITreeRidget;

/**
 * A TreeNode wraps an arbitary object value to make it usable in the tree
 * maintained by an {@link ITreeRidget}.
 * 
 * @see ITreeNode
 */
public class TreeNode extends AbstractBean implements ITreeNode, ITreeNode2 {

	private static void addToParent(ITreeNode parent, ITreeNode child) {
		Assert.isNotNull(child);
		List<ITreeNode> pChildren = parent.getChildren();
		pChildren.add(child);
		parent.setChildren(pChildren);
	}

	private final ITreeNode parent;

	private Object value;
	private List<ITreeNode> children;
	private boolean isEnabled;
	private boolean isVisible;

	/**
	 * Creates a tree node instance.
	 * <p>
	 * The node is visible and enabled by default.
	 * 
	 * @param parent
	 *            the parent node of this tree node. The parent cannot be
	 *            changed. The parent be null if this tree node is a 'root'
	 *            element.
	 * @param value
	 *            the value to wrap in this tree node (may be null)
	 * @see #setValue(Object)
	 */
	public TreeNode(ITreeNode parent, Object value) {
		this.parent = parent;
		this.value = value;
		this.isEnabled = true;
		this.isVisible = true;
		if (parent != null) {
			addToParent(parent, this);
		}
	}

	/**
	 * Sets the enablement property of this node. Will fire a property change
	 * event if modified.
	 * 
	 * @param enabled
	 *            true if this node is enabled, false otherwise.
	 */
	public void setEnabled(boolean enabled) {
		if (isEnabled != enabled) {
			firePropertyChanged(PROPERTY_ENABLED, isEnabled, isEnabled = enabled);
		}
	}

	/**
	 * Sets the visibility property of this node. Will fire a property change
	 * event if modified.
	 * 
	 * @param visible
	 *            true if this node is visible, false otherwise.
	 */
	public void setVisible(boolean visible) {
		if (isVisible != visible) {
			firePropertyChanged(PROPERTY_VISIBLE, isVisible, isVisible = visible);
		}
	}

	@Override
	public String toString() {
		return String.valueOf(getValue());
	}

	// interface methods of ITreeNode
	/////////////////////////////////

	/**
	 * Creates a 'root' tree node instance. 'Root' nodes do not have a parent
	 * node.
	 * 
	 * @param value
	 *            the value to wrap in this tree node (may be null)
	 * @see #setValue(Object)
	 */
	public TreeNode(Object value) {
		this(null, value);
	}

	public List<ITreeNode> getChildren() {
		return children != null ? new ArrayList<ITreeNode>(children) : new ArrayList<ITreeNode>();
	}

	public ITreeNode getParent() {
		return parent;
	}

	public Object getValue() {
		return value;
	}

	public void setChildren(List<ITreeNode> children) {
		if (this.children != children) {
			List<ITreeNode> newValue = (children != null) ? new ArrayList<ITreeNode>(children) : null;
			firePropertyChanged(PROPERTY_CHILDREN, this.children, this.children = newValue);
		}
	}

	public void setValue(Object value) {
		if (this.value != value) {
			Object oldValue = this.value;
			this.value = value;
			firePropertyChanged(PROPERTY_VALUE, oldValue, this.value);
		}
	}

	// interface methods of ITreeNode2
	//////////////////////////////////

	public boolean isEnabled() {
		return isEnabled;
	}

	public boolean isVisible() {
		return isVisible;
	}

}
