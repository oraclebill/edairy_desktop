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
package org.eclipse.riena.ui.ridgets.swt;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.TypedListener;

/**
 * This helper class supports the {@link MenuManger}.
 */
public class MenuManagerHelper {

	/**
	 * Creates with the help of the given menu manager a menu. If the given tool
	 * item is selected, the menu is shown.
	 * 
	 * @param parent
	 * @param toolItem
	 *            tool item with menu
	 * @param topMenuManager
	 *            menu manager
	 * @return menu
	 */
	public Menu createMenu(Composite parent, final ToolItem toolItem, MenuManager topMenuManager) {

		final Menu menu = topMenuManager.createContextMenu(parent);
		toolItem.setData(topMenuManager);
		topMenuManager.updateAll(true);
		addListeners(toolItem, menu);

		return menu;

	}

	public void addListeners(final ToolItem toolItem, final Menu menu) {

		menu.addMenuListener(new TopMenuListener(menu, toolItem));
		toolItem.addSelectionListener(new TopItemListener(menu, toolItem));

	}

	public void removeListeners(final ToolItem toolItem, final Menu menu) {

		Listener[] listeners = menu.getListeners(SWT.Hide);
		for (Listener listener : listeners) {
			if (listener instanceof TypedListener) {
				TypedListener typedListener = (TypedListener) listener;
				if (typedListener.getEventListener() instanceof TopMenuListener) {
					menu.removeMenuListener((TopMenuListener) typedListener.getEventListener());
				}
			}
		}
		listeners = toolItem.getListeners(SWT.Selection);
		for (Listener listener : listeners) {
			if (listener instanceof TypedListener) {
				TypedListener typedListener = (TypedListener) listener;
				if (typedListener.getEventListener() instanceof TopItemListener) {
					toolItem.removeSelectionListener((TopItemListener) typedListener.getEventListener());
				}
			}
		}

	}

	private static class TopMenuListener implements MenuListener {

		private ToolItem toolItem;
		private Menu menu;

		public TopMenuListener(Menu menu, ToolItem toolItem) {
			this.menu = menu;
			this.toolItem = toolItem;
		}

		/**
		 * @see org.eclipse.swt.events.MenuListener#menuHidden(org.eclipse.swt.events.MenuEvent)
		 */
		public void menuHidden(MenuEvent e) {
			if (e.getSource() == menu) {
				toolItem.setSelection(false);
			}
		}

		/**
		 * @see org.eclipse.swt.events.MenuListener#menuShown(org.eclipse.swt.events.MenuEvent)
		 */
		public void menuShown(MenuEvent e) {
		}

	}

	private static class TopItemListener implements SelectionListener {

		private ToolItem toolItem;
		private Menu menu;

		public TopItemListener(Menu menu, ToolItem toolItem) {
			this.menu = menu;
			this.toolItem = toolItem;
		}

		/**
		 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		public void widgetDefaultSelected(SelectionEvent e) {
		}

		/**
		 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		public void widgetSelected(SelectionEvent e) {
			if (e.getSource() == toolItem) {
				Rectangle itemBounds = toolItem.getBounds();
				Point loc = toolItem.getParent().toDisplay(itemBounds.x, itemBounds.height + itemBounds.y);
				menu.setLocation(loc);
				menu.setVisible(true);
			}
		}

	}

}
