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

/**
 * The methods of this interface for a RienaDialog and RienaMessageDialog are
 * used form the class;@link RienaDialogDelegate}. Both methods exists in a
 * super classes of RienaDialog/RienaMessageDialog but they are protected in the
 * super class and so they are not visible for;@link RienaDialogDelegate}. This
 * interface forces the implementation to make this methods .
 * 
 * @deprecated - use AbstractDialogView instead
 */
public interface IRienaDialog {

	/**
	 * Returns the shell style bits.
	 * 
	 * @return the shell style bits
	 */
	int getShellStyle();

	/**
	 * Sets the shell style bits. This method has no effect after the shell is
	 * created.
	 * 
	 * @param newShellStyle
	 *            the new shell style bits
	 */
	void setShellStyle(int newShellStyle);

	boolean isHideOsBorder();

	boolean isCloseable();

	boolean isMaximizeable();

	boolean isMinimizeable();

	boolean isResizeable();

	boolean isApplicationModal();

}
