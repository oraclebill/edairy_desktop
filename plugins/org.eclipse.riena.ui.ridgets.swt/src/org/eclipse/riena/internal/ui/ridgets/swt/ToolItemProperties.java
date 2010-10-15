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
import org.eclipse.jface.action.MenuManager;
import org.eclipse.riena.ui.ridgets.swt.MenuManagerHelper;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

/**
 * This class stores the properties of a tool item.
 */
public class ToolItemProperties extends AbstractItemProperties {

	private ToolBar parent;
	private List<String> prevSiblingIds;
	private Image hotImage;
	private Image disabledImage;

	/**
	 * @param item
	 */
	public ToolItemProperties(ToolItemRidget ridget) {

		super(ridget);

		ToolItem item = ridget.getUIControl();
		parent = item.getParent();
		hotImage = item.getHotImage();
		disabledImage = item.getDisabledImage();
		storePreviousSiblings(item);

	}

	/**
	 * Stores all the previous siblings of the given tool item.
	 * 
	 * @param item
	 *            item of tool bar
	 */
	private void storePreviousSiblings(ToolItem item) {
		int index = parent.indexOf(item);
		Item[] siblings = parent.getItems();
		prevSiblingIds = new ArrayList<String>();
		for (int i = 0; i < index; i++) {
			prevSiblingIds.add(SWTBindingPropertyLocator.getInstance().locateBindingProperty(siblings[i]));
		}
	}

	/**
	 * Returns the index of this tool item to insert it at the correct position
	 * in the tool bar.
	 * 
	 * @return index
	 */
	private int getIndex() {

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
	protected ToolItemRidget getRidget() {
		return (ToolItemRidget) super.getRidget();
	}

	@Override
	protected ToolItem createItem() {

		IContributionItem contributionItem = getContributionItem();
		MenuManager menuManager = getMenuManager();
		ToolItem toolItem;
		if ((contributionItem != null) && (menuManager == null)) {
			contributionItem.fill(parent, getIndex());
			toolItem = parent.getItem(getIndex());
			toolItem.setEnabled(true);
			setAllProperties(toolItem, false);
			contributionItem.update();
		} else {
			toolItem = new ToolItem(parent, getStyle(), getIndex());
			setAllProperties(toolItem, true);
			if (menuManager != null) {
				toolItem.setData(menuManager);
				MenuManagerHelper helper = new MenuManagerHelper();
				helper.addListeners(toolItem, menuManager.getMenu());
			}
		}
		getRidget().setUIControl(toolItem);
		return toolItem;

	}

	@Override
	protected void setAllProperties(Item item, boolean addListeners) {
		super.setAllProperties(item, addListeners);
		ToolItem toolItem = (ToolItem) item;
		if (hotImage == null || !hotImage.isDisposed()) {
			toolItem.setHotImage(hotImage);
		}
		if (disabledImage == null || !disabledImage.isDisposed()) {
			toolItem.setDisabledImage(disabledImage);
		}

	}

	private MenuManager getMenuManager() {

		IContributionItem contributionItem = getContributionItem();
		if (contributionItem instanceof MenuManager) {
			return (MenuManager) contributionItem;
		}

		return null;

	}

}
