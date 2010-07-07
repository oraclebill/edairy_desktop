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
package org.eclipse.riena.internal.ui.ridgets.swt;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

/**
 * This class stores the properties of a menu ridget.
 */
public class MenuProperties extends MenuItemProperties {

	private Decorations menuParent;
	private int menuStyle;
	private MenuItemProperties[] children;

	/**
	 * Creates a new instance of {@code MenuProperties}. The properties of the
	 * given ridget are stored also the children of the menu ridget.
	 * 
	 * @param ridget
	 *            menu ridget
	 */
	public MenuProperties(MenuRidget ridget) {

		super(ridget);

		MenuItem item = ridget.getUIControl();
		Assert.isNotNull(item);
		Menu menu = item.getMenu();
		Assert.isNotNull(menu);

		menuParent = menu.getParent();
		menuStyle = menu.getStyle();

		List<MenuItemRidget> childRidgets = ridget.getChildren();
		children = new MenuItemProperties[childRidgets.size()];
		for (int i = 0; i < children.length; i++) {
			MenuItemRidget childRidget = childRidgets.get(i);
			if (childRidget instanceof MenuRidget) {
				children[i] = new MenuProperties((MenuRidget) childRidget);
			} else {
				children[i] = new MenuItemProperties(childRidget);
			}
		}

	}

	@Override
	protected MenuRidget getRidget() {
		return (MenuRidget) super.getRidget();
	}

	@Override
	protected MenuItem createItem() {

		MenuItem menuItem = new MenuItem(getParent(), getStyle(), getIndex());
		setAllProperties(menuItem, true);

		// create menu
		Menu menu = new Menu(menuParent, menuStyle);
		menuItem.setMenu(menu);

		// create child items
		for (MenuItemProperties child : children) {
			child.createItem(menu);
			getRidget().addChild(child.getRidget());
		}

		getRidget().setUIControl(menuItem);

		return menuItem;

	}

}
