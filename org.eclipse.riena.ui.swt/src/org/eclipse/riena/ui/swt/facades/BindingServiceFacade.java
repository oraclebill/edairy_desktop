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
package org.eclipse.riena.ui.swt.facades;

import java.io.IOException;

import org.eclipse.jface.bindings.Binding;
import org.eclipse.jface.bindings.Scheme;
import org.eclipse.ui.keys.IBindingService;

/**
 * Facade for the {@link IBindingService} interface.
 * 
 * @since 2.0
 */
public abstract class BindingServiceFacade {

	private static final BindingServiceFacade INSTANCE = (BindingServiceFacade) FacadeFactory
			.newFacade(BindingServiceFacade.class);

	/**
	 * The applicable implementation of this class.
	 */
	public static final BindingServiceFacade getDefault() {
		return INSTANCE;
	}

	/**
	 * Returns the current set of bindings.
	 */
	public abstract Binding[] getBindings(IBindingService service);

	/**
	 * Retrieves the scheme with the given identifier. If no such scheme exists,
	 * then an undefined scheme with the given id is created.
	 */
	public abstract Scheme getScheme(IBindingService service, String schemeId);

	/**
	 * Writes the given scheme to the preference store. See
	 * IBindingService.savePreferences(...) for details.
	 * 
	 * @throws IOException
	 *             if something goes wrong while writing
	 */
	public abstract void savePreferences(IBindingService service, Scheme scheme, Binding[] bindings) throws IOException;

}
