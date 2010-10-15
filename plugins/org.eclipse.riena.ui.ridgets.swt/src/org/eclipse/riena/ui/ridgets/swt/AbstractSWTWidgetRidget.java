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

import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.databinding.BindingException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.riena.core.marker.IMarker;
import org.eclipse.riena.ui.core.marker.DisabledMarker;
import org.eclipse.riena.ui.core.marker.ErrorMarker;
import org.eclipse.riena.ui.core.marker.ErrorMessageMarker;
import org.eclipse.riena.ui.core.marker.HiddenMarker;
import org.eclipse.riena.ui.core.marker.MandatoryMarker;
import org.eclipse.riena.ui.core.marker.OutputMarker;
import org.eclipse.riena.ui.ridgets.AbstractMarkerSupport;
import org.eclipse.riena.ui.ridgets.AbstractRidget;
import org.eclipse.riena.ui.ridgets.IBasicMarkableRidget;
import org.eclipse.riena.ui.ridgets.uibinding.IBindingPropertyLocator;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.ImageStore;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;

/**
 * Ridget for an SWT widget.
 */
public abstract class AbstractSWTWidgetRidget extends AbstractRidget implements IBasicMarkableRidget {

	private Widget uiControl;
	private String toolTip = null;
	private ErrorMessageMarker errorMarker;
	private DisabledMarker disabledMarker;
	private MandatoryMarker mandatoryMarker;
	private OutputMarker outputMarker;
	private HiddenMarker hiddenMarker;
	private AbstractMarkerSupport markerSupport;
	private Listener visibilityListener;

	/**
	 * Checks that the given uiControl is assignable to the the given type.
	 * 
	 * @param uiControl
	 *            a uiControl, may be null
	 * @param type
	 *            a class instance (non-null)
	 * @throws BindingException
	 *             if the uiControl is not of the given type
	 */
	public static void assertType(Object uiControl, Class<?> type) {
		if ((uiControl != null) && !(type.isAssignableFrom(uiControl.getClass()))) {
			String expectedClassName = type.getSimpleName();
			String controlClassName = uiControl.getClass().getSimpleName();
			throw new BindingException("uiControl of  must be a " + expectedClassName + " but was a " //$NON-NLS-1$ //$NON-NLS-2$
					+ controlClassName);
		}
	}

	/**
	 * Return true if an instance of the given {@code clazz} is a bean, false
	 * otherwise.
	 * <p>
	 * Implementation note: currently an instance is assumed to be a bean, if it
	 * has an addPropertyListener(PropertyChangeListener) method.
	 * 
	 * @param clazz
	 *            a non-null class value
	 */
	public static boolean isBean(Class<?> clazz) {
		boolean result;
		try {
			// next line throws NoSuchMethodException, if no matching method found
			clazz.getMethod("addPropertyChangeListener", PropertyChangeListener.class); //$NON-NLS-1$
			result = true; // have bean
		} catch (NoSuchMethodException e) {
			result = false; // have pojo
		}
		return result;
	}

	/*
	 * Do not override. Template Method Pattern: Subclasses may implement {@code
	 * unbindUIControl()} and {@code bindUIControl}, if they need to manipulate
	 * the control when it is bound/unbound, for example to add/remove
	 * listeners.
	 */
	public final void setUIControl(Object uiControl) {
		checkUIControl(uiControl);
		uninstallListeners();
		unbindUIControl();
		this.uiControl = (Widget) uiControl;
		updateEnabled();
		updateMarkers();
		updateToolTip();
		bindUIControl();
		installListeners();
	}

	public Widget getUIControl() {
		return uiControl;
	}

	public String getID() {
		IBindingPropertyLocator locator = SWTBindingPropertyLocator.getInstance();
		return locator.locateBindingProperty(getUIControl());
	}

	public void requestFocus() {
		// not supported
	}

	public boolean hasFocus() {
		return false;
	}

	public boolean isFocusable() {
		return false;
	}

	public void setFocusable(boolean focusable) {
		// not supported
	}

	public final void setVisible(boolean visible) {
		if (hiddenMarker == null) {
			hiddenMarker = new HiddenMarker();
		}

		if (visible) {
			removeMarker(hiddenMarker);
		} else {
			addMarker(hiddenMarker);
		}
	}

	public final void setToolTipText(String toolTipText) {
		String oldValue = this.toolTip;
		this.toolTip = toolTipText;
		updateToolTip();
		firePropertyChange(PROPERTY_TOOLTIP, oldValue, this.toolTip);
	}

	public final String getToolTipText() {
		return toolTip;
	}

	// abstract methods - subclasses must implement
	/////////////////////////////////////////////////////////

	/**
	 * Performs checks on the control about to be bound by this ridget.
	 * <p>
	 * Implementors must make sure the given <tt>uiControl</tt> has the expected
	 * type.
	 * 
	 * @param uiControl
	 *            a {@link Widget} instance or null
	 * @throws BindingException
	 *             if the <tt>uiControl</tt> fails the check
	 */
	abstract protected void checkUIControl(Object uiControl);

	/**
	 * Bind the current <tt>uiControl</tt> to the ridget.
	 * <p>
	 * Implementors must call {@link #getUIControl()} to obtain the current
	 * control. If the control is non-null they must do whatever necessary to
	 * bind it to the ridget.
	 */
	abstract protected void bindUIControl();

	/**
	 * Unbind the current <tt>uiControl</tt> from the ridget.
	 * <p>
	 * Implementors ensure they dispose the control-to-ridget binding and
	 * dispose any data structures that are not necessary in an unbound state.
	 */
	abstract protected void unbindUIControl();

	/**
	 * Returns true if mandatory markers should be disabled (i.e. if the ridget
	 * has non empty input).
	 */
	abstract public boolean isDisableMandatoryMarker();

	/**
	 * Update the enabled state for the ridget's control, based on the
	 * information from {@link #isEnabled()}
	 * <p>
	 * Implementation note: if a ridget has markers, the marker support logic
	 * may compute a different enabled state for this widget. The marker support
	 * will be invoked after this method is invoked.
	 * 
	 * @see #setUIControl(Object)
	 */
	abstract protected void updateEnabled();

	/**
	 * Update the tooltip for the ridget's control.
	 */
	abstract protected void updateToolTip();

	// helping methods
	// ////////////////

	/**
	 * Adds listeners to the <tt>uiControl</tt> after it was bound to the
	 * ridget.
	 */
	protected void installListeners() {
		if (getUIControl() != null) {
			if (visibilityListener == null) {
				visibilityListener = new VisibilityListener();
			}
			if (getUIControl() instanceof Control) {
				addHierarchieVisibilityListener(((Control) getUIControl()).getParent(), visibilityListener);
			}
		}
	}

	private void addHierarchieVisibilityListener(Composite parent, Listener listener) {
		if (parent != null && !parent.isDisposed()) {
			parent.addListener(SWT.Show, listener);
			parent.addListener(SWT.Hide, listener);
			addHierarchieVisibilityListener(parent.getParent(), listener);
		}
	}

	/**
	 * Removes listeners from the <tt>uiControl</tt> when it is about to be
	 * unbound from the ridget.
	 */
	protected void uninstallListeners() {
		if (getUIControl() instanceof Control && visibilityListener != null) {
			removeHierarchieVisibilityListener(((Control) getUIControl()).getParent(), visibilityListener);
		}
	}

	private void removeHierarchieVisibilityListener(Composite parent, Listener listener) {
		if (parent != null && !parent.isDisposed()) {
			parent.removeListener(SWT.Show, listener);
			parent.removeListener(SWT.Hide, listener);
			removeHierarchieVisibilityListener(parent.getParent(), listener);
		}
	}

	protected Image getManagedImage(String key) {
		Image image = ImageStore.getInstance().getImage(key);
		if (image == null) {
			image = ImageStore.getInstance().getMissingImage();
		}
		return image;
	}

	/**
	 * Compares the two given values.
	 * 
	 * @param oldValue
	 *            old value
	 * @param newValue
	 *            new value
	 * @return true, if value has changed; otherwise false
	 */
	protected boolean hasChanged(Object oldValue, Object newValue) {
		if (oldValue == null && newValue == null) {
			return false;
		}
		if (oldValue == null || newValue == null) {
			return true;
		}
		return !oldValue.equals(newValue);
	}

	public final boolean isErrorMarked() {
		return !getMarkersOfType(ErrorMarker.class).isEmpty();
	}

	public final void setErrorMarked(boolean errorMarked) {
		setErrorMarked(errorMarked, null);
	}

	protected final void setErrorMarked(boolean errorMarked, String message) {
		if (!errorMarked) {
			if (errorMarker != null) {
				removeMarker(errorMarker);
			}
		} else {
			if (errorMarker == null) {
				errorMarker = new ErrorMessageMarker(message);
			} else {
				errorMarker.setMessage(message);
			}
			addMarker(errorMarker);
		}
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Adding the same marker twice has no effect.
	 */
	public synchronized final void addMarker(IMarker marker) {
		if (markerSupport == null) {
			markerSupport = createMarkerSupport();
		}
		if (marker instanceof MandatoryMarker) {
			((MandatoryMarker) marker).setDisabled(isDisableMandatoryMarker());
		}
		markerSupport.addMarker(marker);
	}

	/**
	 * Creates and initializes the marker support for this Ridget.
	 * <p>
	 * The Look&Feel returns the marker support according of the Look&Feel
	 * setting and the type of this Ridget. If the Look&Feel can not return a
	 * appropriate marker support, this method creates and returns the default
	 * marker support.
	 * 
	 * @return marker support
	 */
	protected AbstractMarkerSupport createMarkerSupport() {
		AbstractMarkerSupport lnfMarkerSupport = null;
		if (LnfManager.getLnf() != null) {
			lnfMarkerSupport = LnfManager.getLnf().getMarkerSupport(this.getClass());
		}
		if (lnfMarkerSupport == null) {
			// No MarkerSupport exits. Default MarkerSupport is used.
			lnfMarkerSupport = new MarkerSupport();
		}
		lnfMarkerSupport.init(this, propertyChangeSupport);
		Assert.isNotNull(lnfMarkerSupport, "Marker support is null!"); //$NON-NLS-1$
		return lnfMarkerSupport;
	}

	public final Collection<IMarker> getMarkers() {
		if (markerSupport != null) {
			return markerSupport.getMarkers();
		}
		return Collections.emptySet();
	}

	public final <T extends IMarker> Collection<T> getMarkersOfType(Class<T> type) {
		if (markerSupport != null) {
			return markerSupport.getMarkersOfType(type);
		}
		return Collections.emptySet();
	}

	public final void removeAllMarkers() {
		if (markerSupport != null) {
			markerSupport.removeAllMarkers();
		}
	}

	public final void removeMarker(IMarker marker) {
		if (markerSupport != null) {
			markerSupport.removeMarker(marker);
		}
	}

	public boolean isEnabled() {
		return getMarkersOfType(DisabledMarker.class).isEmpty();
	}

	public synchronized void setEnabled(boolean enabled) {
		if (enabled) {
			if (disabledMarker != null) {
				removeMarker(disabledMarker);
			}
		} else {
			if (disabledMarker == null) {
				disabledMarker = new DisabledMarker();
			}
			addMarker(disabledMarker);
		}
	}

	public final boolean isOutputOnly() {
		return !getMarkersOfType(OutputMarker.class).isEmpty();
	}

	public final void setOutputOnly(boolean outputOnly) {
		if (!outputOnly) {
			if (outputMarker != null) {
				removeMarker(outputMarker);
			}
		} else {
			if (outputMarker == null) {
				outputMarker = new OutputMarker();
			}
			addMarker(outputMarker);
		}
	}

	public final boolean isMandatory() {
		return !getMarkersOfType(MandatoryMarker.class).isEmpty();
	}

	public final void setMandatory(boolean mandatory) {
		if (!mandatory) {
			if (mandatoryMarker != null) {
				removeMarker(mandatoryMarker);
			}
		} else {
			if (mandatoryMarker == null) {
				mandatoryMarker = new MandatoryMarker();
			}
			addMarker(mandatoryMarker);
		}
	}

	// protected methods
	// //////////////////

	/**
	 * Iterates over the MandatoryMarker instances held by this ridget changing
	 * their disabled state to given value.
	 * 
	 * @param disable
	 *            the new disabled state
	 */
	protected final void disableMandatoryMarkers(boolean disable) {
		for (IMarker marker : getMarkersOfType(MandatoryMarker.class)) {
			MandatoryMarker mMarker = (MandatoryMarker) marker;
			mMarker.setDisabled(disable);
		}
	}

	// helping methods
	// ////////////////

	private void updateMarkers() {
		if (markerSupport != null) {
			markerSupport.updateMarkers();
		}
	}

	// helping classes
	// ////////////////

	private class VisibilityListener implements Listener {

		public void handleEvent(Event event) {
			// fire a showing event for Ridgets with markers whose visibility
			// changes because of a parent widget so that markers can be
			// updated (bug 261980)
			if (!getMarkers().isEmpty() && getUIControl() != null && !getUIControl().isDisposed()) {
				getUIControl().getDisplay().asyncExec(new Runnable() {
					public void run() {
						if (getUIControl() != null && !getUIControl().isDisposed()) {
							markerSupport.fireShowingPropertyChangeEvent();
						}
					}
				});
			}
		}

	}

}
