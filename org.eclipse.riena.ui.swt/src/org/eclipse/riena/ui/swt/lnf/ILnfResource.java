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

/**
 * Wrapper for resources of look and feel.
 */
public interface ILnfResource<T extends Resource> {

	/**
	 * Returns the wrapped resource.
	 * 
	 * @return resource
	 */
	T getResource();

	/**
	 * Creates the resource.
	 * 
	 * @return resource
	 */
	T createResource();

}
