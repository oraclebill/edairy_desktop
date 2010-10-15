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

/**
 * Default implementation of the {@link IMasterDetailsDelegate}.
 * <p>
 * It is recommended that subclasses extend this class instead of implementing
 * {@link IMasterDetailsDelegate} directly.
 * <p>
 * Subclasses still need to implement the abstract methods listed below. These
 * are model specific, so it is not possible to provide a usable default
 * implementation.
 * <ul>
 * <li>{@link #configureRidgets(IRidgetContainer)}</li>
 * <li>{@link #createWorkingCopy()}</li>
 * <li>{@link #copyBean(Object, Object)}</li>
 * <li>{@link #getWorkingCopy()}</li>
 * </ul>
 * Typically will also want to override {@link #isChanged(Object, Object)}, to
 * fine tune the "dirty" state of the details area.
 * <p>
 * 
 * @since 2.0
 */
public abstract class AbstractMasterDetailsDelegate implements IMasterDetailsDelegate {

	/**
	 * {@inheritDoc}
	 * <p>
	 * Default implementation for this method. Subclasses may override.
	 * <p>
	 * <b>Note:</b> it is recommended to provide a tailored implementation for
	 * this method. This will fine tune the "dirty" state of the details area.
	 */
	public boolean isChanged(Object source, Object target) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Default implementation for this method. Subclasses may override.
	 */
	public String isRemovable(Object item) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Default implementation for this method. Subclasses may override.
	 */
	public String isValid(IRidgetContainer container) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Default implementation for this method. Subclasses may override.
	 */
	public void itemCreated(Object newItem) {
		// empty
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Default implementation for this method. Subclasses may override.
	 */
	public void itemApplied(Object changedItem) {
		// empty
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Default implementation for this method. Subclasses may override.
	 */
	public void itemRemoved(Object oldItem) {
		// empty
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Default implementation for this method. Subclasses may override.
	 */
	public void prepareItemSelected(Object newSelection) {
		// empty
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Default implementation for this method. Subclasses may override.
	 */
	public void itemSelected(Object newSelection) {
		// empty
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Default implementation for this method. Subclasses may override &ndash;
	 * though it should not be necessary in most cases.
	 */
	public void updateDetails(IRidgetContainer container) {
		for (IRidget ridget : container.getRidgets()) {
			ridget.updateFromModel();
		}
	}

}
