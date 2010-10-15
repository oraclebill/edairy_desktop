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
package org.eclipse.riena.ui.ridgets.uibinding;

/**
 * Helper class to get the ID (binding property) of a UI control used for
 * binding.
 */
public interface IBindingPropertyLocator {

	/**
	 * Returns the ID (binding property) of the given UI control.
	 * 
	 * @param uiControl
	 *            UI control; may be null
	 * @return the ID String if one is available, the empty string if no ID is
	 *         available, null if uiControl is null or disposed
	 */
	String locateBindingProperty(Object uiControl);

}
