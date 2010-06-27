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

import org.eclipse.core.databinding.BindingException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;

import org.eclipse.riena.ui.ridgets.AbstractMarkerSupport;
import org.eclipse.riena.ui.ridgets.IMenuItemRidget;

/**
 * Ridget of a menu item.
 */
public class MenuItemRidget extends AbstractItemRidget implements IMenuItemRidget {

	/**
	 * Returns whether the given menu item is a cascade menu.
	 * 
	 * @param menuItem
	 *            menu item
	 * @return {@code true} if item is cascade menu; otherwise {@code false}
	 */
	protected boolean isMenu(MenuItem menuItem) {
		if (menuItem == null) {
			return false;
		}
		return ((menuItem.getStyle() & SWT.CASCADE) == SWT.CASCADE);
	}

	@Override
	protected void bindUIControl() {
		super.bindUIControl();
		MenuItem menuItem = getUIControl();
		if ((menuItem != null) && (!menuItem.isDisposed())) {
			menuItem.addSelectionListener(getActionObserver());
		}
	}

	@Override
	protected void unbindUIControl() {
		savedVisibleState = isVisible();
		MenuItem menuItem = getUIControl();

		if ((menuItem != null) && !menuItem.isDisposed() && !isMenu(menuItem)) {
			menuItem.removeSelectionListener(getActionObserver());
		}
		super.unbindUIControl();
	}

	@Override
	protected void checkUIControl(Object uiControl) {
		assertType(uiControl, MenuItem.class);
		if (isMenu((MenuItem) uiControl)) {
			throw new BindingException("Menu item is a cascade menu item!"); //$NON-NLS-1$
		}
	}

	@Override
	public MenuItem getUIControl() {
		return (MenuItem) super.getUIControl();
	}

	@Override
	protected AbstractMarkerSupport createMarkerSupport() {
		return new MenuItemMarkerSupport(this, propertyChangeSupport);
	}

	@Override
	protected void updateEnabled() {
		if ((getUIControl() != null) && (!getUIControl().isDisposed())) {
			getUIControl().setEnabled(isEnabled());
		}
	}

	@Override
	AbstractItemProperties createProperties() {
		return new MenuItemProperties(this);
	}

}
