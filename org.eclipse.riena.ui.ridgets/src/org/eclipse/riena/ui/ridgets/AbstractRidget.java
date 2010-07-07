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
package org.eclipse.riena.ui.ridgets;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.core.runtime.Assert;

import org.eclipse.riena.core.util.ListenerList;
import org.eclipse.riena.ui.ridgets.listener.FocusEvent;
import org.eclipse.riena.ui.ridgets.listener.IFocusListener;

/**
 * Superclass for ridgets with property change support.
 */
public abstract class AbstractRidget implements IRidget {

	public final static String PROPERTY_RIDGET = "ridget"; //$NON-NLS-1$

	protected PropertyChangeSupport propertyChangeSupport;
	private ListenerList<IFocusListener> focusListeners;
	protected boolean savedVisibleState = true;

	/**
	 * Constructor.
	 */
	public AbstractRidget() {
		propertyChangeSupport = new PropertyChangeSupport(this);
		focusListeners = new ListenerList<IFocusListener>(IFocusListener.class);
	}

	public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
		addPropertyChangeListener(null, propertyChangeListener);
	}

	public void addPropertyChangeListener(String propertyName, PropertyChangeListener propertyChangeListener) {
		Assert.isNotNull(propertyChangeListener);
		if (!hasListener(propertyName, propertyChangeListener)) {
			if (propertyName == null) {
				propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
			} else {
				propertyChangeSupport.addPropertyChangeListener(propertyName, propertyChangeListener);
			}
		}
	}

	public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
		removePropertyChangeListener(null, propertyChangeListener);
	}

	public void removePropertyChangeListener(String propertyName, PropertyChangeListener propertyChangeListener) {
		Assert.isNotNull(propertyChangeListener);
		if (propertyName == null) {
			propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
		} else {
			propertyChangeSupport.removePropertyChangeListener(propertyName, propertyChangeListener);
		}
	}

	public void addFocusListener(IFocusListener listener) {
		focusListeners.add(listener);
	}

	public void removeFocusListener(IFocusListener listener) {
		focusListeners.remove(listener);
	}

	public void updateFromModel() {
		// Do nothing by default
	}

	/**
	 * This was never implemented.
	 * 
	 * @return false always
	 * 
	 * @deprecated - this was never implemented - do not call
	 */
	public final boolean isBlocked() {
		return false;
	}

	/**
	 * @deprecated - this was never implemented - do not call
	 */
	public final void setBlocked(boolean blocked) {
	}

	// protected methods
	////////////////////

	/**
	 * Notifies all listeners that the ridget has lost the focus.
	 * 
	 * @param event
	 *            the FocusEvent
	 */
	protected final void fireFocusLost(FocusEvent event) {
		for (IFocusListener focusListener : focusListeners.getListeners()) {
			focusListener.focusLost(event);
		}
	}

	/**
	 * Notifies all listeners that the ridget has gained the focus.
	 * 
	 * @param event
	 *            the FocusEvent
	 */
	protected final void fireFocusGained(FocusEvent event) {
		for (IFocusListener focusListener : focusListeners.getListeners()) {
			focusListener.focusGained(event);
		}
	}

	/**
	 * Notifies all listeners about a changed property. No event is fired if old
	 * and new are equal and non-null.
	 * 
	 * @param propertyName
	 *            The name of the property that was changed.
	 * @param oldValue
	 *            The old value of the property.
	 * @param newValue
	 *            The new value of the property.
	 */
	protected final void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {
		propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * Notifies all listeners about a changed property. No event is fired if old
	 * and new are equal and non-null.
	 * 
	 * @param propertyName
	 *            The name of the property that was changed.
	 * @param oldValue
	 *            The old value of the property.
	 * @param newValue
	 *            The new value of the property.
	 */
	protected final void firePropertyChange(String propertyName, int oldValue, int newValue) {
		propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}

	/**
	 * Notifies all listeners about a changed property. No event is fired if old
	 * and new are equal and non-null.
	 * 
	 * @param propertyName
	 *            The name of the property that was changed.
	 * @param oldValue
	 *            The old value of the property.
	 * @param newValue
	 *            The new value of the property.
	 */
	protected final void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}

	// helping methods
	//////////////////

	private boolean hasListener(String propertyName, Object listener) {
		boolean result = false;
		PropertyChangeListener[] listeners = propertyChangeSupport.getPropertyChangeListeners(propertyName);
		for (int i = 0; !result && i < listeners.length; i++) {
			result = (listeners[i] == listener);
		}
		return result;
	}

}
