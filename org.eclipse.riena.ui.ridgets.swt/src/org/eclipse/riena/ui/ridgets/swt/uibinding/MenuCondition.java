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
package org.eclipse.riena.ui.ridgets.swt.uibinding;

import org.eclipse.riena.ui.ridgets.uibinding.IMappingCondition;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;

/**
 */
public final class MenuCondition implements IMappingCondition {

	public boolean isMatch(Object widget) {
		boolean result = false;
		if (widget instanceof MenuItem) {
			MenuItem menuItem = (MenuItem) widget;
			result = isMenu(menuItem);
		}
		return result;
	}

	/**
	 * Returns whether the given menu item is a cascade menu.
	 * 
	 * @param menuItem
	 *            menu item
	 * @return {@code true} if item is cascade menu; otherwise {@code false}
	 */
	private boolean isMenu(MenuItem menuItem) {
		return ((menuItem.getStyle() & SWT.CASCADE) == SWT.CASCADE);
	}

}
