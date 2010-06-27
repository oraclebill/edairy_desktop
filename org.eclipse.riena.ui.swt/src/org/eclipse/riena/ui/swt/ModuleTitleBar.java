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

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.riena.ui.core.marker.DisabledMarker;
import org.eclipse.riena.ui.swt.facades.SWTFacade;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.lnf.renderer.EmbeddedTitlebarRenderer;

/**
 * Title bar of a module (view).
 */
public class ModuleTitleBar extends EmbeddedTitleBar {

	private TitlebarMouseListener mouseListener;

	/**
	 * @param parent
	 * @param style
	 */
	public ModuleTitleBar(Composite parent, int style) {

		super(parent, style);

	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Adds also all kinds of mouse listeners.
	 */
	@Override
	protected void addListeners() {
		super.addListeners();

		mouseListener = new TitlebarMouseListener();
		addMouseListener(mouseListener);
		SWTFacade swtFacade = SWTFacade.getDefault();
		swtFacade.addMouseMoveListener(this, mouseListener);
		swtFacade.addMouseTrackListener(this, mouseListener);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Removes also the mouse listener.
	 */
	@Override
	protected void removeListeners() {
		if (mouseListener != null) {
			removeMouseListener(mouseListener);
			SWTFacade swtFacade = SWTFacade.getDefault();
			swtFacade.removeMouseMoveListener(this, mouseListener);
			swtFacade.removeMouseTrackListener(this, mouseListener);
			mouseListener = null;
		}

		super.removeListeners();
	}

	/**
	 * Informs all listeners that the module is activated.
	 * 
	 * @param event
	 *            origin mouse event
	 */
	private void fireActivated(MouseEvent event) {
		for (IEmbeddedTitleBarListener listener : titleBarListeners.getListeners()) {
			listener.windowActivated(event);
		}
	}

	/**
	 * Informs all listeners that the close button was clicked.
	 * 
	 * @param event
	 *            origin mouse event
	 */
	private void fireClosed(MouseEvent event) {
		for (IEmbeddedTitleBarListener listener : titleBarListeners.getListeners()) {
			listener.windowClosed(event);
		}
	}

	@Override
	protected EmbeddedTitlebarRenderer getLnfTitlebarRenderer() {
		final EmbeddedTitlebarRenderer r = (EmbeddedTitlebarRenderer) LnfManager.getLnf().getRenderer(
				LnfKeyConstants.MODULE_VIEW_TITLEBAR_RENDERER);
		return r != null ? r : super.getLnfTitlebarRenderer();
	}

	/**
	 * After any mouse operation a method of this listener is called. The item
	 * under the current mouse position is selected, pressed or "hovered".
	 */
	private class TitlebarMouseListener implements MouseListener, MouseTrackListener, MouseMoveListener {

		/**
		 * @see org.eclipse.swt.events.MouseListener#mouseUp(org.eclipse.swt.events.MouseEvent)
		 */
		public void mouseUp(MouseEvent e) {
			if (!isEnabled()) {
				return;
			}
			if (!shouldIgnore(e)) {
				Point point = new Point(e.x, e.y);
				if (isOverClose(point)) {
					fireClosed(e);
				} else {
					fireActivated(e);
					setPressed(false);
				}
			}
			updateCloseButtonState(e);
		}

		/**
		 * @see org.eclipse.swt.events.MouseListener#mouseDown(org.eclipse.swt.events.MouseEvent)
		 */
		public void mouseDown(MouseEvent e) {
			if (!isEnabled()) {
				return;
			}
			if (!shouldIgnore(e)) {
				setPressed(true);
			}
			updateCloseButtonState(e);
		}

		/**
		 * @see org.eclipse.swt.events.MouseListener#mouseDoubleClick(org.eclipse.swt.events.MouseEvent)
		 */
		public void mouseDoubleClick(MouseEvent e) {
			// nothing to do
		}

		/**
		 * @see org.eclipse.swt.events.MouseTrackListener#mouseEnter(org.eclipse.swt.events.MouseEvent)
		 */
		public void mouseEnter(MouseEvent e) {
			if (!isEnabled()) {
				return;
			}
			setHover(true);
			updateCloseButtonState(e);
		}

		/**
		 * @see org.eclipse.swt.events.MouseTrackListener#mouseExit(org.eclipse.swt.events.MouseEvent)
		 */
		public void mouseExit(MouseEvent e) {
			if (!isEnabled()) {
				return;
			}
			setHover(false);
			updateCloseButtonState(e);
		}

		/**
		 * @see org.eclipse.swt.events.MouseTrackListener#mouseHover(org.eclipse.swt.events.MouseEvent)
		 */
		public void mouseHover(MouseEvent e) {
		}

		/**
		 * @see org.eclipse.swt.events.MouseMoveListener#mouseMove(org.eclipse.swt.events.MouseEvent)
		 */
		public void mouseMove(MouseEvent e) {
			updateCloseButtonState(e);
		}

		/**
		 * Updates the (hover and pressed) state of the close button.
		 * 
		 * @param e
		 */
		private void updateCloseButtonState(MouseEvent e) {

			Point point = new Point(e.x, e.y);
			if (isOverClose(point)) {
				setCloseButtonHover(isHover());
				setCloseButtonPressed(isPressed());
			} else {
				setCloseButtonHover(false);
				setCloseButtonPressed(false);
			}

		}

		/**
		 * Ignore mouse events if the component is null, not enabled, or the
		 * event is not associated with the left mouse button.
		 */
		protected boolean shouldIgnore(MouseEvent e) {
			return e.button != 1;
		}

		protected boolean isEnabled() {
			return getMarkersOfType(DisabledMarker.class).isEmpty();
		}

	}

}
