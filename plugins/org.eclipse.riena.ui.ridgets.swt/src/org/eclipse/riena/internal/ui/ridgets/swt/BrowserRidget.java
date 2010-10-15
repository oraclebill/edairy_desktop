/*******************************************************************************
 * Copyright © 2009 Florian Pirchner.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Florian Pirchner – initial API and implementation (based on other ridgets of
 *                    compeople AG)
 * compeople AG     - adjustments for Riena v1.2
 *******************************************************************************/
package org.eclipse.riena.internal.ui.ridgets.swt;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.browser.LocationListener;

import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.ui.ridgets.AbstractMarkerSupport;
import org.eclipse.riena.ui.ridgets.IBrowserRidget;
import org.eclipse.riena.ui.ridgets.swt.AbstractSWTRidget;
import org.eclipse.riena.ui.ridgets.swt.AbstractValueRidget;
import org.eclipse.riena.ui.ridgets.swt.BasicMarkerSupport;

/**
 * Ridget for an SWT {@link Browser} widget.
 * <p>
 * Implementation note: because of SWT <a
 * href="http://bugs.eclipse.org/84532">Bug 84532</a> the
 * {@link #setFocusable(boolean)} methods has no effect.
 * 
 * @since 1.2
 */
public class BrowserRidget extends AbstractValueRidget implements IBrowserRidget {

	private final BrowserUrlListener locationListener;

	private String url;
	private String text;

	public BrowserRidget() {
		locationListener = new BrowserUrlListener();
	}

	@Override
	protected void checkUIControl(Object uiControl) {
		AbstractSWTRidget.assertType(uiControl, Browser.class);
	}

	@Override
	protected void bindUIControl() {
		Browser control = getUIControl();
		if (control != null) {
			updateUIControl();
			control.addLocationListener(locationListener);
		}
	}

	@Override
	protected void unbindUIControl() {
		Browser control = getUIControl();
		if (control != null) {
			control.removeLocationListener(locationListener);
		}
		super.unbindUIControl();
	}

	@Override
	protected AbstractMarkerSupport createMarkerSupport() {
		return new BasicMarkerSupport(this, propertyChangeSupport);
	}

	@Override
	protected IObservableValue getRidgetObservable() {
		return BeansObservables.observeValue(this, IBrowserRidget.PROPERTY_URL);
	}

	@Override
	public Browser getUIControl() {
		return (Browser) super.getUIControl();
	}

	public String getText() {
		return text;
	}

	public String getUrl() {
		return url;
	}

	/**
	 * Always returns true because mandatory markers do not make sense for this
	 * ridget.
	 */
	@Override
	public boolean isDisableMandatoryMarker() {
		return true;
	}

	public void setText(String text) {
		if (!StringUtils.equals(this.text, text)) {
			this.text = text;
			String oldUrl = this.url;
			this.url = null;
			updateUIControl();
			firePropertyChange(IBrowserRidget.PROPERTY_URL, oldUrl, this.url);
		}
	}

	public void setUrl(String url) {
		if (!StringUtils.equals(this.url, url)) {
			String oldUrl = this.getUrl();
			this.text = null;
			this.url = url;
			updateUIControl();
			firePropertyChange(IBrowserRidget.PROPERTY_URL, oldUrl, this.url);
		}
	}

	// helping methods
	//////////////////

	private String convertNullToEmpty(String string) {
		return string != null ? string : ""; //$NON-NLS-1$
	}

	private void updateUIControl() {
		Browser control = getUIControl();
		if (control != null) {
			if (text != null) {
				if (!text.equals(control.getText())) {
					locationListener.unblock();
					control.setText(text);
				}
			} else {
				String url = convertNullToEmpty(this.url);
				if (!url.equals(control.getUrl())) {
					locationListener.unblock();
					control.setUrl(url);
				}
			}
		}
	}

	// helping classes
	//////////////////

	/**
	 * Listens to location changes in the Browser widget and update's the
	 * Ridget's URL if necessary.
	 */
	private final class BrowserUrlListener implements LocationListener {

		private boolean block;

		/**
		 * Allow the next url-change, even if output-only marker is set.
		 * <p>
		 * This is used by updateUIControl() to permit updating a widget on
		 * rebind, setText, setUrl.
		 * <p>
		 * Implementation notes: {@link #changing(LocationEvent)} is invoked an
		 * undefined time after {@link #unblock()}, since the page load happens
		 * asynchronously. Currently there is no synchronisation build in - we
		 * simply allow the next change. This is not likely to cause problems,
		 * however it could allow another change to happen, if it is processed
		 * before the intended LocationEvent. The event.location value is
		 * formatted by the browser and may have things added (parameters,
		 * http://www prefix) so checking for BrowserRidget.url equality is not
		 * an option for identifying which url to unblock.
		 */
		public void unblock() {
			block = false;
		}

		public void changing(LocationEvent event) {
			if (isOutputOnly() && block) {
				event.doit = false;
			}
			block = true;
		}

		public void changed(LocationEvent event) {
			if (event.top && !isNullOrAboutBlank(event.location)) {
				setUrl(event.location);
			}
		}

		private boolean isNullOrAboutBlank(String url) {
			return url == null || "about:blank".equals(url); //$NON-NLS-1$
		}
	}

}