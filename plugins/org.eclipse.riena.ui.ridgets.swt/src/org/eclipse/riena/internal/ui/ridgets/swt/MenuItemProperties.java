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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

/**
 * This class stores the properties of a menu item ridget.
 */
public class MenuItemProperties extends AbstractItemProperties {

	private Menu parent;
	private List<String> prevSiblingIds;

	/**
	 * Creates a new instance of {@code MenuItemProperties}. The properties of
	 * the given ridget are stored.
	 * 
	 * @param ridget
	 *            menu ridget
	 */
	public MenuItemProperties(MenuItemRidget ridget) {

		super(ridget);

		MenuItem item = ridget.getUIControl();
		parent = item.getParent();
		storePreviousSiblings(item);
	}

	/**
	 * Stores all the previous siblings of the given menu item.
	 * 
	 * @param item
	 *            item of tool bar
	 */
	private void storePreviousSiblings(MenuItem item) {
		int index = parent.indexOf(item);
		Item[] siblings = parent.getItems();
		prevSiblingIds = new ArrayList<String>();
		for (int i = 0; i < index; i++) {
			prevSiblingIds.add(SWTBindingPropertyLocator.getInstance().locateBindingProperty(siblings[i]));
		}
	}

	/**
	 * Returns the index of this tool item to insert it at the correct position
	 * in the menu.
	 * 
	 * @return index
	 */
	protected int getIndex() {

		int index = 0;

		Item[] siblings = parent.getItems();
		for (int i = 0; i < siblings.length; i++) {
			String id = SWTBindingPropertyLocator.getInstance().locateBindingProperty(siblings[i]);
			if (prevSiblingIds.contains(id)) {
				index++;
			}
		}

		return index;

	}

	@Override
	protected MenuItem createItem() {
		return createItem(getParent());
	}

	@Override
	protected MenuItemRidget getRidget() {
		return (MenuItemRidget) super.getRidget();
	}

	/**
	 * Creates a new menu item base on the stored properties.
	 * 
	 * @param parent
	 *            parent menu
	 * @return menu item
	 */
	protected MenuItem createItem(Menu parent) {
		IContributionItem contributionItem = getContributionItem();
		MenuItem menuItem;
		if (contributionItem != null) {
			contributionItem.fill(parent, getIndex());
			menuItem = parent.getItem(getIndex());
			setAllProperties(menuItem, false);
			contributionItem.update();
		} else {
			menuItem = new MenuItem(parent, getStyle(), getIndex());
			setAllProperties(menuItem, true);
		}
		getRidget().setUIControl(menuItem);
		return menuItem;
	}

	protected Menu getParent() {
		return parent;
	}

}
