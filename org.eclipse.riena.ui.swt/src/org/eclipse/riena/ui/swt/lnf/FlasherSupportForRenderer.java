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
package org.eclipse.riena.ui.swt.lnf;

import java.util.Collection;

import org.eclipse.riena.ui.core.marker.UIProcessFinishedMarker;
import org.eclipse.riena.ui.swt.lnf.renderer.UIProcessFinishedFlasher;

/**
 * This class starts the flasher for an {@link UIProcessFinishedMarker}.
 */
public class FlasherSupportForRenderer {

	private ILnfRenderer renderer;
	private Runnable updater;

	/**
	 * Creates a new instance of the support.
	 * 
	 * @param renderer
	 *            look&feel renderer
	 * @param updater
	 *            instance to updated the control of the renderer.
	 */
	public FlasherSupportForRenderer(ILnfRenderer renderer, Runnable updater) {
		this.renderer = renderer;
		this.updater = updater;
	}

	/**
	 * Starts for every not activated {@code UIProcessFinishedMarker} a flasher.
	 */
	public void startFlasher() {

		Collection<UIProcessFinishedMarker> markers = renderer.getMarkersOfType(UIProcessFinishedMarker.class);
		for (UIProcessFinishedMarker processMarker : markers) {
			if (!processMarker.isActivated()) {
				startFlasher(processMarker);
			}
		}

	}

	/**
	 * Returns {@code true} if the finished marker of an UI process is visible
	 * (on).
	 * 
	 * @return {@code true} if marker is visible; otherwise {@code false}
	 */
	public boolean isProcessMarkerVisible() {

		Collection<UIProcessFinishedMarker> markers = renderer.getMarkersOfType(UIProcessFinishedMarker.class);
		for (UIProcessFinishedMarker processMarker : markers) {
			if (processMarker.isOn()) {
				return true;
			}
		}

		return false;

	}

	/**
	 * @since 1.2
	 */
	public boolean isFlashing() {
		Collection<UIProcessFinishedMarker> markers = renderer.getMarkersOfType(UIProcessFinishedMarker.class);
		for (UIProcessFinishedMarker processMarker : markers) {
			if (processMarker.isFlashing()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Creates and starts the flasher of a finished UI process.
	 * 
	 * @param processMarker
	 *            marker of finished UI process.
	 */
	private synchronized void startFlasher(final UIProcessFinishedMarker processMarker) {

		UIProcessFinishedFlasher flasher = new UIProcessFinishedFlasher(processMarker, updater);
		processMarker.activate();
		flasher.start();

	}

}
