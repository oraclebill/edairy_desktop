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
package org.eclipse.riena.ui.ridgets.marker;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;

import org.eclipse.riena.ui.core.marker.ErrorMarker;
import org.eclipse.riena.ui.core.marker.IMessageMarker;
import org.eclipse.riena.ui.ridgets.IBasicMarkableRidget;
import org.eclipse.riena.ui.ridgets.IStatuslineRidget;
import org.eclipse.riena.ui.ridgets.listener.FocusEvent;
import org.eclipse.riena.ui.ridgets.listener.IFocusListener;

/**
 * Visualizes certain types of message markers by displaying the message in the
 * status line.
 */
public class StatuslineMessageMarkerViewer extends AbstractMessageMarkerViewer {

	private String statuslineMessage;
	private String originalStatuslineMessage;
	private IStatuslineRidget statusline = null;

	private PropertyChangeListener markerPropertyChangeListener = new MarkerPropertyChangeListener();
	private IFocusListener ridgetFocusListener = new RidgetFocusListener();

	enum Severity {
		NONE(0), INFO(1), WARNING(2), ERROR(3);
		private int index;

		Severity(int index) {
			this.index = index;
		}

		boolean isLower(Severity other) {
			return index < other.index;
		}
	}

	/**
	 * @param statuslineridget
	 *            The status line.
	 */
	public StatuslineMessageMarkerViewer(IStatuslineRidget statuslineRidget) {
		this.statusline = statuslineRidget;
	}

	@Override
	public void addRidget(IBasicMarkableRidget markableRidget) {
		super.addRidget(markableRidget);
		markableRidget.addPropertyChangeListener(markerPropertyChangeListener);
		markableRidget.addFocusListener(ridgetFocusListener);
	}

	@Override
	protected void showMessages(IBasicMarkableRidget markableRidget) {
		if (markableRidget.hasFocus()) {
			Collection<IMessageMarker> messageMarker = this.getMessageMarker(markableRidget);
			String message = constructMessage(messageMarker, getMessageSeparator());
			Severity severity = getMaxSeverity(messageMarker);
			// show the message only if there is something to show
			if (message.length() > 0 && isVisible()) {
				setStatuslineMessage(message, severity);
			} else {
				hideMessages(markableRidget);
			}
		}
	}

	@Override
	protected void hideMessages(IBasicMarkableRidget ridget) {
		if (ridget.hasFocus()) {
			resetStatuslineMessage();
		}
	}

	@Override
	protected String getMessageSeparator() {
		return " "; //$NON-NLS-1$
	}

	private void setStatuslineMessage(String message, Severity severity) {
		if (getStatusLine() != null) {
			if (statuslineMessage == null) {
				originalStatuslineMessage = getStatusLine().getMessage();
			}
			switch (severity) {
			case ERROR:
				getStatusLine().error(message);
				break;
			case WARNING:
				getStatusLine().warning(message);
				break;
			case INFO:
				getStatusLine().info(message);
				break;
			default:
				getStatusLine().clear();
				getStatusLine().setMessage(message);
				break;
			}
			statuslineMessage = message;
		}
	}

	private void resetStatuslineMessage() {
		if (getStatusLine() != null) {
			if (statuslineMessage != null && statuslineMessage.equals(getStatusLine().getMessage())) {
				getStatusLine().clear();
				getStatusLine().setMessage(originalStatuslineMessage);
			}
			statuslineMessage = null;
		}
	}

	private Severity getMaxSeverity(Collection<IMessageMarker> messageMarkers) {

		Severity severity = Severity.NONE;

		for (IMessageMarker messageMarker : messageMarkers) {
			if (messageMarker instanceof ErrorMarker) {
				if (severity.isLower(Severity.ERROR)) {
					severity = Severity.ERROR;
				}
			}
		}

		return severity;

	}

	IStatuslineRidget getStatusLine() {
		// if ( statusline == null ) {
		// IModuleApplicationController moduleApplicationController =
		// subModuleController.getModuleApplicationController();
		// if ( moduleApplicationController != null ) {
		// statusline = moduleApplicationController.getStatusline();
		// PostCondition.assertNotNull( "The statusline to show messages in must
		// not be
		// null!", statusline );
		// }
		// }
		return statusline;
	}

	private class MarkerPropertyChangeListener implements PropertyChangeListener {

		public void propertyChange(PropertyChangeEvent evt) {
			if (evt.getPropertyName().equals(IBasicMarkableRidget.PROPERTY_MARKER)
					&& evt.getSource() instanceof IBasicMarkableRidget
					&& ((IBasicMarkableRidget) evt.getSource()).hasFocus()) {
				showMessages((IBasicMarkableRidget) evt.getSource());
			}
		}

	}

	private class RidgetFocusListener implements IFocusListener {

		public void focusGained(FocusEvent event) {
			if (event.getNewFocusOwner() instanceof IBasicMarkableRidget) {
				showMessages((IBasicMarkableRidget) event.getNewFocusOwner());
			}
		}

		public void focusLost(FocusEvent event) {
			if (event.getOldFocusOwner() instanceof IBasicMarkableRidget) {
				resetStatuslineMessage();
			}
		}

	}

}
