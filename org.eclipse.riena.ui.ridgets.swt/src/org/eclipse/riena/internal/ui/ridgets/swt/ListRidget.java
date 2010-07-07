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

import org.eclipse.jface.viewers.AbstractListViewer;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;

import org.eclipse.riena.ui.ridgets.ISelectableRidget;
import org.eclipse.riena.ui.ridgets.swt.AbstractListRidget;
import org.eclipse.riena.ui.ridgets.swt.AbstractSWTRidget;
import org.eclipse.riena.ui.ridgets.swt.MarkerSupport;

/**
 * Ridget for SWT {@link List} widgets.
 */
public class ListRidget extends AbstractListRidget {

	private ListViewer viewer;

	public ListRidget() {
		selectionTypeEnforcer = new SelectionTypeEnforcer();
	}

	@Override
	protected void checkUIControl(Object uiControl) {
		AbstractSWTRidget.assertType(uiControl, List.class);
	}

	@Override
	public List getUIControl() {
		return (List) super.getUIControl();
	}

	@Override
	protected int getUIControlSelectionIndex() {
		return getUIControl().getSelectionIndex();
	}

	@Override
	protected int[] getUIControlSelectionIndices() {
		return getUIControl().getSelectionIndices();
	}

	@Override
	protected int getUIControlItemCount() {
		return getUIControl().getItemCount();
	}

	@Override
	protected void bindUIControl() {
		final List control = getUIControl();
		if (control != null) {
			viewer = new ListViewer(control);
			if (hasViewerModel()) {
				configureViewer(viewer);
			}

			updateComparator();
			updateEnabled(isEnabled());

			control.addSelectionListener(selectionTypeEnforcer);
			control.addMouseListener(doubleClickForwarder);
		}
	}

	@Override
	protected void unbindUIControl() {
		super.unbindUIControl();

		List control = getUIControl();
		if (control != null) {
			control.removeSelectionListener(selectionTypeEnforcer);
			control.removeMouseListener(doubleClickForwarder);
		}
		viewer = null;
	}

	@Override
	protected AbstractListViewer getViewer() {
		return viewer;
	}

	@Override
	protected void updateEnabled(boolean isEnabled) {
		final String savedBackgroundKey = "oldbg"; //$NON-NLS-1$
		if (isEnabled) {
			if (hasViewer()) {
				refreshViewer();
				disposeSelectionBindings();
				createSelectionBindings();
				List list = viewer.getList();
				list.setBackground((Color) list.getData(savedBackgroundKey));
				list.setData(savedBackgroundKey, null);
			}
		} else {
			disposeSelectionBindings();
			if (hasViewer()) {
				refreshViewer();
				List list = viewer.getList();
				if (MarkerSupport.isHideDisabledRidgetContent()) {
					list.deselectAll();
				}
				list.setData(savedBackgroundKey, list.getBackground());
				list.setBackground(list.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			}
		}
	}

	// helping classes
	// ////////////////

	/**
	 * Enforces selection in the control:
	 * <ul>
	 * <li>disallows selection changes when the ridget is "output only"</li>
	 * <li>disallows multiple selection is the selection type of the ridget is
	 * {@link ISelectableRidget.SelectionType#SINGLE}</li>
	 * </ul>
	 */
	private final class SelectionTypeEnforcer extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e) {
			List control = (List) e.widget;
			if (isOutputOnly()) {
				revertSelection(control);
			} else if (SelectionType.SINGLE.equals(getSelectionType())) {
				if (control.getSelectionCount() > 1) {
					// ignore this event
					e.doit = false;
					selectFirstItem(control);
				}
			}
		}

		private void selectFirstItem(List control) {
			// set selection to most recent item
			control.setSelection(control.getSelectionIndex());
			// fire event
			Event event = new Event();
			event.type = SWT.Selection;
			event.doit = true;
			control.notifyListeners(SWT.Selection, event);
		}

		private void revertSelection(List control) {
			control.setRedraw(false);
			try {
				// undo user selection when "output only"
				viewer.setSelection(new StructuredSelection(getSelection()));
			} finally {
				// redraw control to remove "cheese" that is caused when
				// using the keyboard to select the next row
				control.setRedraw(true);
			}
		}
	}

}
