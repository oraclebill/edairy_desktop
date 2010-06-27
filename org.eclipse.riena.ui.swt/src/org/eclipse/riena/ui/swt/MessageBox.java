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
package org.eclipse.riena.ui.swt;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.riena.ui.swt.utils.IPropertyNameProvider;

/**
 * The <code>MessageBox</code> pops up a standard dialog box to display
 * messages.
 */
public class MessageBox implements IPropertyNameProvider {

	private String propertyName;
	private Composite parent;
	private int result;
	private MessageDialog messageDialog;
	private Set<FocusListener> focusListeners;

	/*
	 * @see
	 * org.eclipse.riena.ui.swt.utils.IPropertyNameProvider#getPropertyName()
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.riena.ui.swt.utils.IPropertyNameProvider#setPropertyName(
	 * java.lang.String)
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * @param parent
	 *            the parent control.
	 */
	public MessageBox(Composite parent) {

		super();

		this.parent = parent;
		focusListeners = new HashSet<FocusListener>();
	}

	/**
	 * Show the standard dialog box.
	 * 
	 * @param title
	 *            the title of the dialog.
	 * @param text
	 *            the text of the dialog.
	 * @param type
	 *            the type of the dialog (i.e. MessageDialog.NONE,
	 *            MessageDialog.INFORMATION, MessageDialog.WARNING,
	 *            MessageDialog.ERROR, MessageDialog.INFORMATION,
	 *            MessageDialog.QUESTION).
	 * @param buttonLabels
	 *            the labels of the buttons shown in the dialog.
	 */
	public void show(String title, String text, int type, String[] buttonLabels) {

		messageDialog = new RienaMessageDialog(parent.getShell(), title, null, // accept the default window icon
				text, type, buttonLabels, 0) {
			//		messageDialog = new MessageDialog(parent.getShell(), title, null, // accept the default window icon
			//				text, type, buttonLabels, 0) {

			@Override
			public boolean close() {

				for (FocusListener l : focusListeners) {
					messageDialog.getShell().removeFocusListener(l);
				}
				boolean closed = super.close();
				messageDialog = null;

				return closed;
			}

			@Override
			public void create() {

				super.create();

				for (FocusListener l : focusListeners) {
					getShell().addFocusListener(l);
				}
			}
		};

		result = messageDialog.open();

	}

	/**
	 * The returned result after the dialog was closed.
	 * 
	 * @return the result
	 */
	public int getResult() {
		return result;
	}

	/**
	 * Request the focus for the control.
	 */
	public void requestFocus() {
		if (messageDialog != null) {
			messageDialog.getShell().setFocus();
		}
	}

	/**
	 * Returns, if the dialog is show and has focus.
	 * 
	 * @return true, if the dialog is show and has focus, else false.
	 */
	public boolean hasFocus() {
		if (messageDialog != null) {
			return messageDialog.getShell().isFocusControl();
		}
		return false;
	}

	/**
	 * Set the visibility of a dialog that is shown.
	 * 
	 * @param visible
	 *            the visibility.
	 */
	public void setVisible(boolean visible) {
		if (messageDialog != null) {
			messageDialog.getShell().setVisible(visible);
		}
	}

	/**
	 * Set the enabled state of a dialog that is shown.
	 * 
	 * @param enabled
	 *            the new enabled state.
	 */
	public void setEnabled(boolean enabled) {
		if (messageDialog != null) {
			messageDialog.getShell().setEnabled(enabled);
		}
	}

	/**
	 * Adds a focus listener.
	 * 
	 * @param listener
	 *            the listener
	 */
	public void addFocusListener(FocusListener listener) {
		focusListeners.add(listener);
	}

	/**
	 * Removes a focus listener.
	 * 
	 * @param listener
	 *            the listener
	 */
	public void removeFocusListener(FocusListener listener) {
		focusListeners.remove(listener);
	}
}
