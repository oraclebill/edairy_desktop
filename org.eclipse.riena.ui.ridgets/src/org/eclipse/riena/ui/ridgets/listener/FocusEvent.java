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

import org.eclipse.riena.ui.ridgets.IRidget;

/**
 * An event which indicates that a Ridget has gained or lost the input focus.
 */
public class FocusEvent {

	private IRidget oldFocusOwner;
	private IRidget newFocusOwner;

	/**
	 * Creates a FocusEvent.
	 * 
	 * @param oldFocusOwner
	 *            the old owner of the focus.
	 * @param newFocusOwner
	 *            the new owner of the focus.
	 */
	public FocusEvent(IRidget oldFocusOwner, IRidget newFocusOwner) {
		this.oldFocusOwner = oldFocusOwner;
		this.newFocusOwner = newFocusOwner;
	}

	/**
	 * @return the old owner of the focus.
	 */
	public IRidget getOldFocusOwner() {
		return oldFocusOwner;
	}

	/**
	 * @return the new owner of the focus.
	 */
	public IRidget getNewFocusOwner() {
		return newFocusOwner;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof FocusEvent)) {
			return false;
		}
		FocusEvent otherFocusEvent = (FocusEvent) other;
		return equals(getOldFocusOwner(), otherFocusEvent.getOldFocusOwner())
				&& equals(getNewFocusOwner(), otherFocusEvent.getNewFocusOwner());
	}

	private boolean equals(Object object1, Object object2) {
		if (object1 == null) {
			return object2 == null;
		}
		return object1 == object2;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int code = 3;
		if (getOldFocusOwner() != null) {
			code += getOldFocusOwner().hashCode();
		}
		if (getNewFocusOwner() != null) {
			code += 7 * getNewFocusOwner().hashCode();
		}
		return code;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder("FocusEvent[oldFocusOwner="); //$NON-NLS-1$
		buffer.append(getOldFocusOwner());
		buffer.append(", newFocusOwner="); //$NON-NLS-1$
		buffer.append(getNewFocusOwner());
		buffer.append("]"); //$NON-NLS-1$
		return buffer.toString();
	}

}
