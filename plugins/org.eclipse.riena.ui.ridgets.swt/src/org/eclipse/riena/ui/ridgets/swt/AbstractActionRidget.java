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

import java.beans.EventHandler;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;

import org.eclipse.riena.internal.ui.ridgets.swt.ActionObserver;
import org.eclipse.riena.ui.core.resource.IIconManager;
import org.eclipse.riena.ui.core.resource.IconManagerProvider;
import org.eclipse.riena.ui.core.resource.IconSize;
import org.eclipse.riena.ui.ridgets.AbstractMarkerSupport;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;

/**
 * An abstract Ridget for buttons that does not depend on the class
 * org.eclipse.swt.widgets.Button. May be used for Ridgets for custom buttons.
 */
public abstract class AbstractActionRidget extends AbstractSWTRidget implements IActionRidget {

	private static final String EMPTY_STRING = ""; //$NON-NLS-1$

	protected final ActionObserver actionObserver;

	private String text;
	private String iconID;
	private boolean textAlreadyInitialized;
	private boolean useRidgetIcon;

	public AbstractActionRidget() {
		actionObserver = new ActionObserver(this);
		textAlreadyInitialized = false;
		useRidgetIcon = false;
	}

	@Override
	protected AbstractMarkerSupport createMarkerSupport() {
		return new BasicMarkerSupport(this, propertyChangeSupport);
	}

	/**
	 * If the text of the ridget has no value, initialize it with the text of
	 * the UI control.
	 */
	protected void initText() {
		if (text == null && !textAlreadyInitialized) {
			Control control = getUIControl();
			if (control != null && !control.isDisposed()) {
				text = getUIControlText();
				if (text == null) {
					text = EMPTY_STRING;
				}
				textAlreadyInitialized = true;
			}
		}
	}

	public final void addListener(IActionListener listener) {
		actionObserver.addListener(listener);
	}

	/**
	 * @deprecated use {@link #addListener(IActionListener)}
	 */
	public final void addListener(Object target, String action) {
		addListener(EventHandler.create(IActionListener.class, target, action));
	}

	public final void removeListener(IActionListener listener) {
		actionObserver.removeListener(listener);
	}

	/**
	 * Always returns true because mandatory markers do not make sense for this
	 * ridget.
	 */
	@Override
	public boolean isDisableMandatoryMarker() {
		return true;
	}

	public final String getText() {
		return text;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * The <i>full</i> name of the icon is returned, also called icon ID. The
	 * icon ID (can) contains the name, the size and the state.
	 */
	public String getIcon() {
		return this.iconID;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * <i>Also sets the size {@code IconSize.NONE} for the icon.</i>
	 * 
	 * @see #setIcon(String,IconSize)
	 */
	public void setIcon(String icon) {
		setIcon(icon, IconSize.NONE);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * The name and the size of the icon will be managed by an implementation of
	 * {@code IIconManager}.
	 * 
	 * @since 2.0
	 */
	public void setIcon(String icon, IconSize size) {
		boolean oldUseRidgetIcon = useRidgetIcon;
		useRidgetIcon = true;
		String oldIcon = this.iconID;
		IIconManager manager = IconManagerProvider.getInstance().getIconManager();
		this.iconID = manager.getIconID(icon, size);
		if (hasChanged(oldIcon, icon) || !oldUseRidgetIcon) {
			updateUIIcon();
		}
	}

	public final void setText(String newText) {
		String oldText = this.text;
		this.text = newText;
		updateUIText();
		firePropertyChange(IActionRidget.PROPERTY_TEXT, oldText, this.text);
	}

	// helping methods
	// ////////////////

	protected void updateUIText() {
		if (getUIControl() != null) {
			setUIControlText(getText());
		}
	}

	/**
	 * Return the text from the ui control.
	 */
	protected abstract String getUIControlText();

	/**
	 * Apply a text to the ui control.
	 */
	protected abstract void setUIControlText(String text);

	protected void updateUIIcon() {
		if (getUIControl() != null) {
			Image image = null;
			if (getIcon() != null) {
				image = getManagedImage(getIcon());
			}
			if ((image != null) || useRidgetIcon) {
				setUIControlImage(image);
			}
		}
	}

	/**
	 * Apply an image to the ui control.
	 */
	protected abstract void setUIControlImage(Image image);

	/**
	 * Fires the same event that would be fired if the UIControl was klicked.
	 * Does nothing if the Ridget is disabled or invisible. <br>
	 * Should only be used in controller tests.
	 * 
	 * @since 2.0
	 */
	public void fireAction() {
		if (isVisible() && isEnabled()) {
			actionObserver.widgetSelected(null);
		}
	}

}
