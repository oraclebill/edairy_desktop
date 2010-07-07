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

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Assert;

/**
 * Helper class for working with {@link ITreeNode} instances.
 * <p>
 * TODO [ev] unit tests
 */
public final class TreeNodeUtils {

	private TreeNodeUtils() {
		// prevent instantiation
	}

	public static boolean isLeaf(ITreeNode node) {
		Collection<ITreeNode> children = node.getChildren();
		return children.size() == 0;
	}

	public static int getLevel(ITreeNode node) {
		int result = 0;
		ITreeNode parent = node.getParent();
		while (parent != null) {
			result++;
			parent = parent.getParent();
		}
		return result;
	}

	public static int getChildCount(ITreeNode node) {
		return node.getChildren().size();
	}

	public static int getIndex(ITreeNode parent, ITreeNode child) {
		List<ITreeNode> children = parent.getChildren();
		return children.indexOf(child);
	}

	public static ITreeNode getChild(ITreeNode parent, int index) {
		Assert.isLegal(index >= 0);
		ITreeNode result = null;
		List<ITreeNode> children = parent.getChildren();
		if (index < children.size()) {
			result = children.get(index);
		}
		return result;
	}

	public static ITreeNode getRoot(ITreeNode node) {
		ITreeNode result = node;
		while (result.getParent() != null) {
			result = result.getParent();
		}
		return result;
	}

}
