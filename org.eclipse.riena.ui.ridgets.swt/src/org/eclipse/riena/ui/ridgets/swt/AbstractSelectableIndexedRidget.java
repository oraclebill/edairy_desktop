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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.riena.ui.ridgets.ISelectableIndexedRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget;

/**
 * Default implementation of an {@link ISelectableIndexedRidget}.
 * <p>
 * This ridget is a specialization of the {@link ISelectableRidget} that allows
 * manipulating the selection using index numbers.
 * 
 * @see ISelectableIndexedRidget
 */
public abstract class AbstractSelectableIndexedRidget extends AbstractSelectableRidget implements
		ISelectableIndexedRidget {

	/*
	 * this method should be provided by subclasses, since it requires access to
	 * the specific control instance (i.e. List, Table, etc.)
	 */
	public abstract Object getOption(int index);

	public final int getOptionCount() {
		if (getRowObservables() == null) {
			return 0;
		}
		return getRowObservables().size();
	}

	public final void setSelection(int index) {
		setSelection(new int[] { index });
	}

	public final void setSelection(int[] indices) {
		assertIsBoundToModel();
		List<Object> newSelection = new ArrayList<Object>();
		for (int index : indices) {
			Object option = getOption(index);
			if (option != null) {
				newSelection.add(option);
			}
		}
		setSelection(newSelection);
	}

	/*
	 * this method should be provided by subclasses, since it requires access to
	 * the specific control instance (i.e. List, Table, etc.)
	 */
	public abstract int getSelectionIndex();

	/*
	 * this method should be provided by subclasses, since it requires access to
	 * the specific control instance (i.e. List, Table, etc.)
	 */
	public abstract int[] getSelectionIndices();

	/*
	 * this method should be provided by subclasses, since it requires access to
	 * the specific control instance (i.e. List, Table, etc.)
	 */
	public abstract int indexOfOption(Object option);

}
