/*******************************************************************************
 * Copyright (c) 2007, 2010 compeople AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    compeople AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.riena.ui.swt.lnf;

import org.eclipse.swt.graphics.Resource;

import org.eclipse.riena.ui.swt.utils.SwtUtilities;

/**
 * Abstract wrapper for resources of look and feel.
 */
public abstract class AbstractLnfResource<T extends Resource> implements ILnfResource<T> {

	private T resource;

	/**
	 * @see org.eclipse.riena.ui.swt.lnf.ILnfResource#getResource()
	 */
	public T getResource() {
		if (SwtUtilities.isDisposed(resource)) {
			resource = createResource();
		}
		return resource;
	}

}
