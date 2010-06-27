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

/**
 * The {@code ILnfCustomizer} allows to customize certain Look and Feels, i.e.
 * {@code RienaDefaultLnf} or sub-classes of it.
 */
public interface ILnfCustomizer {

	/**
	 * Get the {@code ILnfResource} with the given {@code key}.
	 * 
	 * @param key
	 *            the key for the resource
	 * @return the resource
	 */
	ILnfResource<?> getLnfResource(String key);

	/**
	 * Put a {@code ILnfResource} with the given {@code key}.
	 * 
	 * @param key
	 *            the key for the resource
	 * @param resource
	 *            the resource
	 * @return the previously associated resource (already disposed) with the
	 *         given {@code key} or {@code null} if there was no previously
	 *         resource.
	 */
	ILnfResource<?> putLnfResource(String key, ILnfResource<?> resource);

	/**
	 * Get the settings {@code Object} with the given {@code key}.
	 * 
	 * @param key
	 *            the key for the settings object
	 * @return the settings object
	 */
	Object getLnfSetting(String key);

	/**
	 * Put a settings {@code Object} with the given {@code key}.
	 * 
	 * @param key
	 *            the key for the settings object
	 * @param setting
	 *            the setting object
	 * @return the previously associated setting object with the given
	 *         {@code key}
	 */
	Object putLnfSetting(String key, Object setting);

}
