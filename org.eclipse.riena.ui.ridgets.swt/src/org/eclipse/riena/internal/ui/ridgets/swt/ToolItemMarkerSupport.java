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

import java.beans.PropertyChangeSupport;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.ToolItem;

import org.eclipse.riena.ui.ridgets.AbstractMarkerSupport;
import org.eclipse.riena.ui.ridgets.swt.MenuManagerHelper;

/**
 * Helper class for SWT Tool Item Ridgets to delegate their marker issues to.
 */
public class ToolItemMarkerSupport extends AbstractMarkerSupport {

	/**
	 * Creates a new instance of {@code ToolItemMarkerSupport}.
	 * 
	 * @param ridget
	 *            ridget of tool item
	 * @param propertyChangeSupport
	 */
	public ToolItemMarkerSupport(ToolItemRidget ridget, PropertyChangeSupport propertyChangeSupport) {
		super(ridget, propertyChangeSupport);
	}

	@Override
	public void updateMarkers() {
		updateToolItem();
	}

	@Override
	protected void handleMarkerAttributesChanged() {
		updateToolItem();
		super.handleMarkerAttributesChanged();
	}

	@Override
	protected ToolItemRidget getRidget() {
		return (ToolItemRidget) super.getRidget();
	}

	/**
	 * Enables or disables the given item.
	 * 
	 * @param item
	 *            tool item to update
	 */
	private void updateDisabled(ToolItem item) {
		if (item.isDisposed()) {
			return;
		}
		boolean enabled = getRidget().isEnabled();
		item.setEnabled(enabled);
	}

	/**
	 * Shows or hides the given item.
	 * 
	 * @param item
	 *            tool item to update
	 */
	private void updateVisible(ToolItem item) {

		if (!hasHiddenMarkers()) {
			getRidget().createItem();
		} else {
			MenuManager menuManager = getMenuManager(item);
			if (menuManager != null) {
				MenuManagerHelper helper = new MenuManagerHelper();
				helper.removeListeners(item, menuManager.getMenu());
			}
			item.dispose();
		}

	}

	/**
	 * Returns form the data of the given item the {@link MenuManager}.<br>
	 * <i>Only top level items of the menu bar have a MenuManger.</i>
	 * 
	 * @param item
	 *            tool item
	 * @return the menu manager or <{@code null} if the item has no menu
	 *         manager.
	 */
	private MenuManager getMenuManager(ToolItem item) {

		if (item.isDisposed()) {
			return null;
		}

		if ((item.getData() instanceof MenuManager)) {
			return (MenuManager) item.getData();
		} else {
			return null;
		}

	}

	/**
	 * Updates the tool item to display the current markers.
	 */
	private void updateToolItem() {
		ToolItem item = getRidget().getUIControl();
		if (item != null) {
			updateVisible(item);
			if (!item.isDisposed()) {
				updateDisabled(item);
			}
		}
	}

}
