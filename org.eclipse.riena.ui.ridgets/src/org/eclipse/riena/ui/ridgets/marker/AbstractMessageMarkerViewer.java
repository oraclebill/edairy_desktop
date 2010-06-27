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

import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.core.runtime.Assert;

import org.eclipse.riena.core.util.ListenerList;
import org.eclipse.riena.ui.core.marker.ErrorMessageMarker;
import org.eclipse.riena.ui.core.marker.IMessageMarker;
import org.eclipse.riena.ui.ridgets.IBasicMarkableRidget;

/**
 * Common functionality of classes visualizing certain types of message markers.
 */
public abstract class AbstractMessageMarkerViewer implements IMessageMarkerViewer {

	/**
	 * Creates a string with all messages of the given markers.
	 * 
	 * @param messageMarker
	 *            a Collection of message markers; may be null
	 * @param separator
	 *            a String for separating the message markers; never null
	 * @return string with all messages
	 * @since 1.2
	 */
	public static String constructMessage(Collection<IMessageMarker> messageMarker, String separator) {
		Assert.isNotNull(separator);
		StringWriter sw = new StringWriter();
		if (messageMarker != null) {
			for (Iterator<IMessageMarker> i = messageMarker.iterator(); i.hasNext();) {
				IMessageMarker nextMarker = i.next();
				if (sw.toString().trim().length() > 0) {
					sw.write(separator);
				}
				if (nextMarker.getMessage() != null) {
					sw.write(nextMarker.getMessage());
				}
			}
		}

		return sw.toString().trim();
	}

	private HashSet<Class<? extends IMessageMarker>> markerTypes;
	private ListenerList<IBasicMarkableRidget> ridgets;
	private boolean visible;

	public AbstractMessageMarkerViewer() {
		markerTypes = new LinkedHashSet<Class<? extends IMessageMarker>>();
		ridgets = new ListenerList<IBasicMarkableRidget>(IBasicMarkableRidget.class);
		visible = true;
		markerTypes.add(ValidationMessageMarker.class);
		markerTypes.add(ErrorMessageMarker.class);
	}

	public void addRidget(IBasicMarkableRidget markableRidget) {
		ridgets.add(markableRidget);
		showMessages(markableRidget);
	}

	public void removeRidget(IBasicMarkableRidget markableRidget) {
		ridgets.remove(markableRidget);
		hideMessages(markableRidget);
	}

	public void addMarkerType(Class<? extends IMessageMarker> markerClass) {
		markerTypes.add(markerClass);
		showMessages();
	}

	public void removeMarkerType(Class<? extends IMessageMarker> markerClass) {
		markerTypes.remove(markerClass);
		showMessages();
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
		showMessages();
	}

	private void showMessages() {
		for (IBasicMarkableRidget ridget : getRidgets()) {
			showMessages(ridget);
		}
	}

	/**
	 * Returns the string that separates the single messages of a composed
	 * message.
	 * 
	 * @return separator
	 * @since 1.2
	 */
	protected abstract String getMessageSeparator();

	protected abstract void showMessages(IBasicMarkableRidget ridget);

	protected abstract void hideMessages(IBasicMarkableRidget ridget);

	protected Collection<IMessageMarker> getMessageMarker(IBasicMarkableRidget markableRidget) {
		return getMessageMarker(markableRidget, false);
	}

	protected Collection<IMessageMarker> getMessageMarker(IBasicMarkableRidget markableRidget, boolean pRemove) {
		List<IMessageMarker> result = new ArrayList<IMessageMarker>();
		for (Class<? extends IMessageMarker> nextMessageMarkerType : markerTypes) {
			Collection<? extends IMessageMarker> nextMessageMarkers = markableRidget
					.getMarkersOfType(nextMessageMarkerType);
			if (nextMessageMarkers != null && nextMessageMarkers.size() > 0) {
				result.addAll(nextMessageMarkers);
			}
		}
		if (pRemove) {
			for (Iterator<IMessageMarker> j = result.iterator(); j.hasNext();) {
				markableRidget.removeMarker(j.next());
			}
		}
		Collections.sort(result, new MessageMarkerComparator());
		return result;
	}

	protected Collection<IBasicMarkableRidget> getRidgets() {
		return Arrays.asList(ridgets.getListeners());
	}

	protected static final class MessageMarkerComparator implements Comparator<IMessageMarker>, Serializable {

		private static final long serialVersionUID = 1L;

		public int compare(IMessageMarker o1, IMessageMarker o2) {
			String message1 = o1.getMessage();
			String message2 = o2.getMessage();
			return message1.compareTo(message2);
		}

	}

}
