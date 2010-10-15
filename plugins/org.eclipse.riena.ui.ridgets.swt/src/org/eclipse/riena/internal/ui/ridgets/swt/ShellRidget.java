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

import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.riena.core.util.ListenerList;
import org.eclipse.riena.ui.core.marker.HiddenMarker;
import org.eclipse.riena.ui.ridgets.AbstractMarkerSupport;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IDefaultActionManager;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IWindowRidget;
import org.eclipse.riena.ui.ridgets.UIBindingFailure;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.listener.IWindowRidgetListener;
import org.eclipse.riena.ui.ridgets.swt.AbstractSWTWidgetRidget;
import org.eclipse.riena.ui.ridgets.swt.BasicMarkerSupport;

/**
 * The ridget for a Shell control.
 */
public class ShellRidget extends AbstractSWTWidgetRidget implements IWindowRidget {

	private boolean closeable;
	private boolean titleAlreadyInitialized;
	private String title;
	private String icon;
	private ListenerList<IWindowRidgetListener> windowRidgetListeners;
	private DefaultActionManager actionManager;

	private ShellListener shellListener;

	public ShellRidget() {
		super();
		titleAlreadyInitialized = false;
		title = ""; //$NON-NLS-1$
		closeable = true;
		windowRidgetListeners = new ListenerList<IWindowRidgetListener>(IWindowRidgetListener.class);
		shellListener = new RidgetShellListener();
	}

	public ShellRidget(Shell shell) {
		this();
		setUIControl(shell);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * <b>Implementation note:</b> activation of the
	 * {@link IDefaultActionManager} must be handled by the Controller &ndash;
	 * see {@link AbstractWindowController#afterBind()}. Deactivation and
	 * disposal is handled by this ridget.
	 */
	public IDefaultActionManager addDefaultAction(IRidget focusRidget, IActionRidget actionRidget) {
		if (actionManager == null) {
			actionManager = new DefaultActionManager(this);
		}
		actionManager.addAction(focusRidget, actionRidget);
		return actionManager;
	}

	public void addWindowRidgetListener(IWindowRidgetListener listener) {
		windowRidgetListeners.add(listener);
	}

	public void dispose() {
		Shell control = getUIControl();
		if (control != null) {
			control.dispose();
		}
		if (actionManager != null) {
			actionManager.dispose();
			actionManager = null;
		}
	}

	public String getTitle() {
		return title;
	}

	@Override
	public Shell getUIControl() {
		return (Shell) super.getUIControl();
	}

	@Override
	public boolean hasFocus() {
		if (getUIControl() != null) {
			return getUIControl().isFocusControl();
		}
		return false;
	}

	@Override
	public boolean isDisableMandatoryMarker() {
		return false;
	}

	public boolean isVisible() {
		// check for "hidden.marker". This marker overrules any other visibility rule
		if (!getMarkersOfType(HiddenMarker.class).isEmpty()) {
			return false;
		}

		if (getUIControl() != null) {
			// the swt control is bound
			return getUIControl().isVisible();
		}
		// control is not bound
		return savedVisibleState;
	}

	public void layout() {
		Shell control = getUIControl();
		if (control != null) {
			control.layout(true, true);
		}
	}

	public void removeWindowRidgetListener(IWindowRidgetListener listener) {
		windowRidgetListeners.remove(listener);
	}

	@Override
	public void requestFocus() {
		if (getUIControl() != null) {
			getUIControl().setFocus();
		}
	}

	public void setActive(boolean active) {
		setEnabled(active);
	}

	public void setCloseable(boolean closeable) {
		if (this.closeable != closeable) {
			this.closeable = closeable;
			updateCloseable();
		}
	}

	public void setIcon(String icon) {
		String oldIcon = this.icon;
		this.icon = icon;
		if (hasChanged(oldIcon, icon)) {
			updateIcon();
		}
	}

	public void setTitle(String title) {
		titleAlreadyInitialized = true;
		if (title != null && !this.title.equals(title)) {
			this.title = title;
			updateTitle();
		}
	}

	@Override
	public void updateFromModel() {
		super.updateFromModel();

		if (getUIControl() != null) {
			updateTitle();
			updateIcon();
		}
	}

	// protected methods
	////////////////////

	@Override
	protected void bindUIControl() {
		addShellListener();
		updateToolTip();
		updateCloseable();
		updateTitle();
		updateIcon();
	}

	@Override
	protected void checkUIControl(Object uiControl) {
		if (uiControl != null && !(uiControl instanceof Shell)) {
			throw new UIBindingFailure("uiControl of a ShellRidget must be a Shell but was a " //$NON-NLS-1$
					+ uiControl.getClass().getSimpleName());
		}
	}

	@Override
	protected AbstractMarkerSupport createMarkerSupport() {
		return new BasicMarkerSupport(this, propertyChangeSupport);
	}

	/**
	 * Compares the two given values.
	 * 
	 * @param oldValue
	 *            old value
	 * 
	 * @param newValue
	 *            new value
	 * 
	 * @return true, if value has changed; otherwise false
	 */
	@Override
	protected boolean hasChanged(Object oldValue, Object newValue) {
		if (oldValue == null && newValue == null) {
			return false;
		}
		if (oldValue == null || newValue == null) {
			return true;
		}
		return !oldValue.equals(newValue);
	}

	@Override
	protected void unbindUIControl() {
		savedVisibleState = isVisible();
		removeShellListener();
	}

	@Override
	protected void updateEnabled() {
		if (getUIControl() != null) {
			getUIControl().setEnabled(isEnabled());
		}
	}

	@Override
	protected void updateToolTip() {
		if (getUIControl() != null) {
			getUIControl().setToolTipText(getToolTipText());
		}
	}

	// helping methods
	//////////////////

	private void addShellListener() {
		if (getUIControl() != null) {
			getUIControl().addShellListener(shellListener);
		}
	}

	private void removeShellListener() {
		if (getUIControl() != null) {
			getUIControl().removeShellListener(shellListener);
		}
	}

	private void updateCloseable() {
		// TODO
	}

	/**
	 * Updates the icon of the UI control.
	 */
	private void updateIcon() {
		Shell control = getUIControl();
		if (control != null) {
			Image image = null;
			if (icon != null) {
				image = getManagedImage(icon);
			}
			control.setImage(image);
		}
	}

	private void updateTitle() {
		if (getUIControl() != null) {
			if (titleAlreadyInitialized) {
				getUIControl().setText(title);
			} else {
				titleAlreadyInitialized = true;
				title = getUIControl().getText();
			}
		}
	}

	// helping classes
	//////////////////

	private final class RidgetShellListener extends ShellAdapter {

		@Override
		public void shellActivated(ShellEvent e) {
			for (IWindowRidgetListener l : windowRidgetListeners.getListeners()) {
				l.activated();
			}
		}

		@Override
		public void shellClosed(ShellEvent e) {
			for (IWindowRidgetListener l : windowRidgetListeners.getListeners()) {
				l.closed();
			}
		}
	}

}
