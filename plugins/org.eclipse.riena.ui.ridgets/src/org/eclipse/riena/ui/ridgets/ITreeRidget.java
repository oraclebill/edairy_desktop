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

/**
 * Ridget for a tree.
 * <p>
 * The model value can be any type conforming to the rules outlined by the
 * bindToModel(...) methods.
 */
public interface ITreeRidget extends IRidget, ISelectableRidget {

	/**
	 * The name of the PropertyChangeEvent that will be fired when the ridget's
	 * 'roots visible' setting changed ({@value} ).
	 * 
	 * @see #getRootsVisible();
	 * @since 1.2
	 */
	String PROPERTY_ROOTS_VISIBLE = "rootsVisible"; //$NON-NLS-1$

	/**
	 * Adds the listener to the collection of listeners who will be notified
	 * when the bound control is double-clicked.
	 * <p>
	 * Adding the same listener several times has no effect.
	 * 
	 * @param listener
	 *            a non-null {@link IActionListener} instance
	 * @throws RuntimeException
	 *             if listener is null
	 */
	void addDoubleClickListener(IActionListener listener);

	/**
	 * Creates a binding between the Tree Ridget and the specified treeRoots.
	 * <p>
	 * Each tree element must have an accessor that provides a list of children
	 * (List), an accessor that provides a parent (null for the a root element)
	 * and an accessor that provides a value (Object) for each child. It is
	 * assumed that the rootElement and all children are of the same type.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * MyType[] rootElements = { root1 };
	 * treeRidget.bind(rootElements, MyType.class, &quot;children&quot;, &quot;parent&quot;, &quot;value&quot;);
	 * </pre>
	 * <p>
	 * In the example above MyType must have methods specified in the bind(...)
	 * invocation, i.e.: getChildren(), getParent() and getValue(). It is
	 * suggested that MyType follows the 'beans' convention by providing add /
	 * removePropertyChangeListener(PropertyChangeListener) methods and firing
	 * events on containment or value modifications. This will keep the tree in
	 * sync automatically. Otherwise {@link #updateFromModel()} has to be called
	 * to resync.
	 * <p>
	 * Note that invoking this method will discard any queued expand/collapse
	 * operations on the ridget.
	 * 
	 * @param treeRoots
	 *            the root elements of the tree (non-null, non-empty).
	 * @param treeElementClass
	 *            the type of the elements in the tree (i.e. for treeRoot and
	 *            all children).
	 * @param childrenAccessor
	 *            a non-null, non-empty String specifying an accessor for
	 *            obtaining a List of children from an object in the tree. For
	 *            example "children" specifies "getChildren()". The returned
	 *            children will be shown underneath their parent.
	 * @param parentAccessor
	 *            a non-null, non-empty String specifying an accessor for
	 *            obtaining the parent Object from an object in the tree. The
	 *            accessor is allowed to return null for root elements. For
	 *            example "parent" specifies "getParent()". The parents are used
	 *            when determining the correct way to expand or collapse a tree
	 *            element.
	 * @param valueAccessor
	 *            a non-null, non-empty String specifying an accessor for
	 *            obtaining an Object value from each child (example "value"
	 *            specifies "getValue()"). The returned value will be shown in
	 *            the corresponding tree node.
	 */
	void bindToModel(Object[] treeRoots, Class<? extends Object> treeElementClass, String childrenAccessor,
			String parentAccessor, String valueAccessor);

	/**
	 * Creates a binding between the Tree Ridget and the specified treeRoots.
	 * <p>
	 * Each tree element must have an accessor that provides a list of children
	 * (List), an accessor that provides a parent (null for the a root element)
	 * and an accessor that provides a value (Object) for each child. It is
	 * assumed that the rootElement and all children are of the same type.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * MyType[] rootElements = { root1 };
	 * treeRidget.bind(rootElements, MyType.class, &quot;children&quot;, &quot;parent&quot;, &quot;value&quot;, &quot;enabled&quot;, &quot;visible&quot;);
	 * </pre>
	 * <p>
	 * In the example above MyType must have the methods specified in the
	 * bind(...) invocation, i.e.: getChildren(), getParent(), getValue(),
	 * getEnabled() and getVisible(). It is suggested that MyType follows the
	 * 'beans' convention by providing add /
	 * removePropertyChangeListener(PropertyChangeListener) methods and firing
	 * events on containment or value modifications. This will keep the tree in
	 * sync automatically. Otherwise {@link #updateFromModel()} has to be called
	 * to resync.
	 * <p>
	 * Note that invoking this method will discard any queued expand/collapse
	 * operations on the ridget.
	 * 
	 * @param treeRoots
	 *            the root elements of the tree (non-null, non-empty).
	 * @param treeElementClass
	 *            the type of the elements in the tree (i.e. for treeRoot and
	 *            all children).
	 * @param childrenAccessor
	 *            a non-null, non-empty String specifying an accessor for
	 *            obtaining a List of children from an object in the tree. For
	 *            example "children" specifies "getChildren()". The returned
	 *            children will be shown underneath their parent.
	 * @param parentAccessor
	 *            a non-null, non-empty String specifying an accessor for
	 *            obtaining the parent Object from an object in the tree. The
	 *            accessor is allowed to return null for root elements. For
	 *            example "parent" specifies "getParent()". The parents are used
	 *            when determining the correct way to expand or collapse a tree
	 *            element.
	 * @param valueAccessor
	 *            a non-null, non-empty String specifying an accessor for
	 *            obtaining an Object value from each child (example "value"
	 *            specifies "getValue()"). The returned value will be shown in
	 *            the corresponding tree node.
	 * @param enablementAccessor
	 *            a String specifying an accessor for obtaining an boolean
	 *            enablement value (example "enabled" specifies "isEnabled()" or
	 *            "getEnabled()"). Nodes that are not enabled, will be colored
	 *            gray and will not be selectable. The enablementAccessor can be
	 *            null; in that case all tree nodes will be enabled.
	 * @param visibilityAccessor
	 *            a String specifying an accessor for obtaining a boolean
	 *            visible value (example "visible" specifies "isVisible()" or
	 *            "isEnabled()"). Nodes that are not visible, will not be shown
	 *            in the tree. The visibilityAccessor can be null; in that case
	 *            all tree nodes will be shown.
	 */
	void bindToModel(Object[] treeRoots, Class<? extends Object> treeElementClass, String childrenAccessor,
			String parentAccessor, String valueAccessor, String enablementAccessor, String visibilityAccessor);

	/**
	 * Creates a binding between the Tree Ridget and the specified treeRoots.
	 * <p>
	 * Each tree element must have an accessor that provides a list of children
	 * (List), an accessor that provides a parent (null for the a root element)
	 * and an accessor that provides a value (Object) for each child. It is
	 * assumed that the rootElement and all children are of the same type.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * MyType[] rootElements = { root1 };
	 * treeRidget.bind(rootElements, MyType.class, &quot;children&quot;, &quot;parent&quot;, &quot;value&quot;, &quot;enabled&quot;, &quot;visible&quot;, &quot;icon&quot;);
	 * </pre>
	 * <p>
	 * In the example above MyType must have the methods specified in the
	 * bind(...) invocation, i.e.: getChildren(), getParent() and getValue(). It
	 * is suggested that MyType follows the 'beans' convention by providing add
	 * / removePropertyChangeListener(PropertyChangeListener) methods and firing
	 * events on containment or value modifications. This will keep the tree in
	 * sync automatically. Otherwise {@link #updateFromModel()} has to be called
	 * to resync.
	 * <p>
	 * Note that invoking this method will discard any queued expand/collapse
	 * operations on the ridget.
	 * 
	 * @param treeRoots
	 *            the root elements of the tree (non-null, non-empty).
	 * @param treeElementClass
	 *            the type of the elements in the tree (i.e. for treeRoot and
	 *            all children).
	 * @param childrenAccessor
	 *            a non-null, non-empty String specifying an accessor for
	 *            obtaining a List of children from an object in the tree. For
	 *            example "children" specifies "getChildren()". The returned
	 *            children will be shown underneath their parent.
	 * @param parentAccessor
	 *            a non-null, non-empty String specifying an accessor for
	 *            obtaining the parent Object from an object in the tree. The
	 *            accessor is allowed to return null for root elements. For
	 *            example "parent" specifies "getParent()". The parents are used
	 *            when determining the correct way to expand or collapse a tree
	 *            element.
	 * @param valueAccessor
	 *            a non-null, non-empty String specifying an accessor for
	 *            obtaining an Object value from each child (example "value"
	 *            specifies "getValue()"). The returned value will be shown in
	 *            the corresponding tree node.
	 * @param enablementAccessor
	 *            a String specifying an accessor for obtaining an boolean
	 *            enablement value (example "enabled" specifies "isEnabled()" or
	 *            "getEnabled()"). Nodes that are not enabled, will be colored
	 *            gray and will not be selectable. The enablementAccessor can be
	 *            null; in that case all tree nodes will be enabled.
	 * @param visibilityAccessor
	 *            a String specifying an accessor for obtaining a boolean
	 *            visible value (example "visible" specifies "isVisible()" or
	 *            "isEnabled()"). Nodes that are not visible, will not be shown
	 *            in the tree. The visibilityAccessor can be null; in that case
	 *            all tree nodes will be shown.
	 * @param leafImageAccessor
	 *            a String specifying an accessor for obtaining a String value,
	 *            which is the key (or filename) of an icon. (example "icon"
	 *            specifies "getIcon()). This key will be used to obtain an icon
	 *            for leaves of the tree. The leafImageAccessor can be null; in
	 *            that case the default icon is used for all leaves.
	 */
	void bindToModel(Object[] treeRoots, Class<? extends Object> treeElementClass, String childrenAccessor,
			String parentAccessor, String valueAccessor, String enablementAccessor, String visibilityAccessor,
			String leafImageAccessor);

	/**
	 * Creates a binding between the Tree Ridget and the specified treeRoots.
	 * <p>
	 * Each tree element must have an accessor that provides a list of children
	 * (List), an accessor that provides a parent (null for the a root element)
	 * and an accessor that provides a value (Object) for each child. It is
	 * assumed that the rootElement and all children are of the same type.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * MyType[] rootElements = { root1 };
	 * treeRidget.bind(rootElements, MyType.class, &quot;children&quot;, &quot;parent&quot;, &quot;value&quot;, &quot;enabled&quot;, &quot;visible&quot;, &quot;icon&quot;, &quot;openIcon&quot;);
	 * </pre>
	 * <p>
	 * In the example above MyType must have the methods specified in the
	 * bind(...) invocation, i.e.: getChildren(), getParent() and getValue(). It
	 * is suggested that MyType follows the 'beans' convention by providing add
	 * / removePropertyChangeListener(PropertyChangeListener) methods and firing
	 * events on containment or value modifications. This will keep the tree in
	 * sync automatically. Otherwise {@link #updateFromModel()} has to be called
	 * to resync.
	 * <p>
	 * Note that invoking this method will discard any queued expand/collapse
	 * operations on the ridget.
	 * 
	 * @param treeRoots
	 *            the root elements of the tree (non-null, non-empty).
	 * @param treeElementClass
	 *            the type of the elements in the tree (i.e. for treeRoot and
	 *            all children).
	 * @param childrenAccessor
	 *            a non-null, non-empty String specifying an accessor for
	 *            obtaining a List of children from an object in the tree. For
	 *            example "children" specifies "getChildren()". The returned
	 *            children will be shown underneath their parent.
	 * @param parentAccessor
	 *            a non-null, non-empty String specifying an accessor for
	 *            obtaining the parent Object from an object in the tree. The
	 *            accessor is allowed to return null for root elements. For
	 *            example "parent" specifies "getParent()". The parents are used
	 *            when determining the correct way to expand or collapse a tree
	 *            element.
	 * @param valueAccessor
	 *            a non-null, non-empty String specifying an accessor for
	 *            obtaining an Object value from each child (example "value"
	 *            specifies "getValue()"). The returned value will be shown in
	 *            the corresponding tree node.
	 * @param enablementAccessor
	 *            a String specifying an accessor for obtaining an boolean
	 *            enablement value (example "enabled" specifies "isEnabled()" or
	 *            "getEnabled()"). Nodes that are not enabled, will be colored
	 *            gray and will not be selectable. The enablementAccessor can be
	 *            null; in that case all tree nodes will be enabled.
	 * @param visibilityAccessor
	 *            a String specifying an accessor for obtaining a boolean
	 *            visible value (example "visible" specifies "isVisible()" or
	 *            "getVisible()"). Nodes that are not visible, will not be shown
	 *            in the tree. The visibilityAccessor can be null; in that case
	 *            all tree nodes will be shown.
	 * @param imageAccessor
	 *            a String specifying an accessor for obtaining a String value,
	 *            which is the key (or filename) of an icon. (example "icon"
	 *            specifies "getIcon()). This key will be used to obtain an icon
	 *            for <b>leaves AND closed nodes</b> of the tree. The
	 *            leafImageAccessor can be null; in that case the default icon
	 *            is used for all leaves and nodes. Note: nodes will only get a
	 *            custom icon if an openNodeImageAccessor is supplied as well
	 *            (see below).
	 * @param openNodeImageAccessor
	 *            a String specifying an accessor for obtaining a String value
	 *            which is the key (or filename) of an icon. (example "icon"
	 *            specifies "getIcon()" ). This key will be used to obtain an
	 *            icon for <b>open nodes</b> of the tree. The
	 *            openNodeImageAccessor can be null; in that case the default
	 *            icon is used for all nodes. Note: nodes will only get a custom
	 *            icon if an imageAccessor is supplied as well (see above).
	 * @param expandedAccessor
	 *            a String specifying an accessor for obtaining a boolean
	 *            expanded value (example "expanded" specifies "isExpanded()" or
	 *            "setExpanded()"). Nodes that are not expanded, will not be
	 *            expanded in the tree. The expandedAccessor can be null; in
	 *            that case no tree nodes except a root node will be expanded.
	 * @since 2.0
	 */
	void bindToModel(Object[] treeRoots, Class<? extends Object> treeElementClass, String childrenAccessor,
			String parentAccessor, String valueAccessor, String enablementAccessor, String visibilityAccessor,
			String imageAccessor, String openNodeImageAccessor, String expandedAccessor);

	/**
	 * Creates a binding between the Tree Ridget and the specified treeRoots.
	 * <p>
	 * Each tree element must have an accessor that provides a list of children
	 * (List), an accessor that provides a parent (null for the a root element)
	 * and an accessor that provides a value (Object) for each child. It is
	 * assumed that the rootElement and all children are of the same type.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * MyType[] rootElements = { root1 };
	 * treeRidget.bind(rootElements, MyType.class, &quot;children&quot;, &quot;parent&quot;, &quot;value&quot;, &quot;enabled&quot;, &quot;visible&quot;, &quot;icon&quot;, &quot;openIcon&quot;);
	 * </pre>
	 * <p>
	 * In the example above MyType must have the methods specified in the
	 * bind(...) invocation, i.e.: getChildren(), getParent() and getValue(). It
	 * is suggested that MyType follows the 'beans' convention by providing add
	 * / removePropertyChangeListener(PropertyChangeListener) methods and firing
	 * events on containment or value modifications. This will keep the tree in
	 * sync automatically. Otherwise {@link #updateFromModel()} has to be called
	 * to resync.
	 * <p>
	 * Note that invoking this method will discard any queued expand/collapse
	 * operations on the ridget.
	 * 
	 * @param treeRoots
	 *            the root elements of the tree (non-null, non-empty).
	 * @param treeElementClass
	 *            the type of the elements in the tree (i.e. for treeRoot and
	 *            all children).
	 * @param childrenAccessor
	 *            a non-null, non-empty String specifying an accessor for
	 *            obtaining a List of children from an object in the tree. For
	 *            example "children" specifies "getChildren()". The returned
	 *            children will be shown underneath their parent.
	 * @param parentAccessor
	 *            a non-null, non-empty String specifying an accessor for
	 *            obtaining the parent Object from an object in the tree. The
	 *            accessor is allowed to return null for root elements. For
	 *            example "parent" specifies "getParent()". The parents are used
	 *            when determining the correct way to expand or collapse a tree
	 *            element.
	 * @param valueAccessor
	 *            a non-null, non-empty String specifying an accessor for
	 *            obtaining an Object value from each child (example "value"
	 *            specifies "getValue()"). The returned value will be shown in
	 *            the corresponding tree node.
	 * @param enablementAccessor
	 *            a String specifying an accessor for obtaining an boolean
	 *            enablement value (example "enabled" specifies "isEnabled()" or
	 *            "getEnabled()"). Nodes that are not enabled, will be colored
	 *            gray and will not be selectable. The enablementAccessor can be
	 *            null; in that case all tree nodes will be enabled.
	 * @param visibilityAccessor
	 *            a String specifying an accessor for obtaining a boolean
	 *            visible value (example "visible" specifies "isVisible()" or
	 *            "isEnabled()"). Nodes that are not visible, will not be shown
	 *            in the tree. The visibilityAccessor can be null; in that case
	 *            all tree nodes will be shown.
	 * @param imageAccessor
	 *            a String specifying an accessor for obtaining a String value,
	 *            which is the key (or filename) of an icon. (example "icon"
	 *            specifies "getIcon()). This key will be used to obtain an icon
	 *            for <b>leaves AND closed nodes</b> of the tree. The
	 *            leafImageAccessor can be null; in that case the default icon
	 *            is used for all leaves and nodes. Note: nodes will only get a
	 *            custom icon if an openNodeImageAccessor is supplied as well
	 *            (see below).
	 * @param openNodeImageAccessor
	 *            a String specifying an accessor for obtaining a String value
	 *            which is the key (or filename) of an icon. (example "icon"
	 *            specifies "getIcon()" ). This key will be used to obtain an
	 *            icon for <b>open nodes</b> of the tree. The
	 *            openNodeImageAccessor can be null; in that case the default
	 *            icon is used for all nodes. Note: nodes will only get a custom
	 *            icon if an imageAccessor is supplied as well (see above).
	 * @since 1.2
	 */
	void bindToModel(Object[] treeRoots, Class<? extends Object> treeElementClass, String childrenAccessor,
			String parentAccessor, String valueAccessor, String enablementAccessor, String visibilityAccessor,
			String imageAccessor, String openNodeImageAccessor);

	/**
	 * Collapses a node if it is part of the data-model currently bound to the
	 * tree. If the node is not part of the model nothing will happen.
	 * <p>
	 * If the UI-control is null when this method is invoked, the collapsing
	 * will be queued and applied to the ridget at a later time. Re-binding the
	 * ridget to another model will cancel any queued expand/collapse
	 * operations.
	 * 
	 * @param node
	 *            The node to collapse.
	 * 
	 * @see #bindToModel(Object, Class, String, String)
	 * @see IRidget#getUIControl()
	 */
	void collapse(Object node);

	/**
	 * Collapses all nodes of the tree if the Ridget is currently bound to a
	 * tree UI-control.
	 * <p>
	 * If the UI-control is null when this method is invoked, the collapsing
	 * will be queued and applied to the ridget at a later time. Re-binding the
	 * ridget to another model will cancel any queued expand/collapse
	 * operations.
	 * 
	 * @see #bindToModel(Object, Class, String, String)
	 * @see IRidget#getUIControl()
	 */
	void collapseAll();

	/**
	 * Expands a node if it is part of the data-model currently bound to the
	 * tree. If the node is not part of the data-model nothing will happen.
	 * <p>
	 * If the UI-control is null when this method is invoked, the expansion will
	 * be queued and applied to the ridget at a later time. Re-binding the
	 * ridget to another model will cancel any queued expand/collapse
	 * operations.
	 * 
	 * @param node
	 *            The node to expand (non-null).
	 * 
	 * @see #bindToModel(Object, Class, String, String)
	 * @see IRidget#getUIControl()
	 */
	void expand(Object node);

	/**
	 * Expands all nodes of the tree based on the current ITreeModel value if
	 * the Ridget is currently bound to a tree UI-control.
	 * <p>
	 * If the UI-control is null when this method is invoked, the expansion will
	 * be queued and applied to the ridget at a later time. Re-binding the
	 * ridget to another model will cancel any queued expand/collapse
	 * operations.
	 * 
	 * @see #bindToModel(Object, Class, String, String)
	 * @see IRidget#getUIControl()
	 */
	void expandAll();

	/**
	 * Returns true, if the roots of the tree shall be shown and false
	 * otherwise.
	 * <p>
	 * The default setting is true.
	 * 
	 * @return {@code true}: show roots; otherwise {@code false}
	 */
	boolean getRootsVisible();

	/**
	 * Refresh the given row or rows in the control.
	 * <p>
	 * This is useful when the values shown by the ridget do not fire property
	 * change notifications when they are changed (pojos).
	 * <p>
	 * Does not have an effect when no control is present.
	 * 
	 * @param node
	 *            the row value that should be refreshed or null to refresh all
	 *            rows
	 * @since 2.0
	 */
	void refresh(Object node);

	/**
	 * Removes the listener from the collection of listeners who will be
	 * notified when the bound control is double-clicked.
	 * 
	 * @param listener
	 *            a non-null {@link IActionListener} instance
	 * @throws RuntimeException
	 *             if listener is null
	 */
	void removeDoubleClickListener(IActionListener listener);

	/**
	 * Indicates that the roots of the tree should be shown, if the argument is
	 * true, and not be shown otherwise.
	 * 
	 * @param showRoots
	 *            true to show the roots, false otherwise
	 */
	void setRootsVisible(boolean showRoots);

}
