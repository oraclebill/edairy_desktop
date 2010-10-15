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
package org.eclipse.riena.ui.ridgets.listener;

import java.util.Collections;
import java.util.List;

import org.eclipse.riena.ui.ridgets.IRidget;

/**
 * An event that indicates that a ridget was selected
 * 
 * @since 1.2
 */
public class SelectionEvent {

	private IRidget source;
	private List<Object> newSelection;
	private List<Object> oldSelection;

	/**
	 * Creates a SelectionEvent.
	 * 
	 * @param source
	 *            the source ridget
	 * @param oldSelectionList
	 *            the old selection
	 * @param newSelectionList
	 *            the new selection
	 */
	public SelectionEvent(IRidget source, List<?> oldSelectionList, List<?> newSelectionList) {
		this.source = source;
		// making sure client code cannot modify the collection after using
		// getNewSelection() or getOldSelection();
		this.oldSelection = Collections.unmodifiableList(oldSelectionList);
		this.newSelection = Collections.unmodifiableList(newSelectionList);
	}

	/**
	 * @return the source ridget
	 */
	public IRidget getSource() {
		return source;
	}

	/**
	 * @return the new selection; never null; cannot be modified
	 */
	public List<Object> getNewSelection() {
		return newSelection;
	}

	/**
	 * @return the old selection; never null; cannot be modified
	 */
	public List<Object> getOldSelection() {
		return oldSelection;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder("SelectionEvent[source="); //$NON-NLS-1$
		buffer.append(getSource());
		buffer.append(", oldSelection="); //$NON-NLS-1$
		buffer.append(getOldSelection());
		buffer.append(", newSelection="); //$NON-NLS-1$
		buffer.append(getNewSelection());
		buffer.append("]"); //$NON-NLS-1$
		return buffer.toString();
	}

}
