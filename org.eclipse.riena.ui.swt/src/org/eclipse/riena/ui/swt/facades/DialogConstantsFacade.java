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

/**
 * Single-sourced access to common Dialog-Button labels.
 * <p>
 * This is necessary because RAP supports several languages per server and thus
 * the access mechanism to UI-Strings is different than in RCP.
 * 
 * @since 2.0
 */
public abstract class DialogConstantsFacade {

	private static final DialogConstantsFacade INSTANCE = (DialogConstantsFacade) FacadeFactory
			.newFacade(DialogConstantsFacade.class);

	/**
	 * The applicable implementation of this class.
	 */
	public static final DialogConstantsFacade getDefault() {
		return INSTANCE;
	}

	/**
	 * Returns the OK label for a Dialog button.
	 * 
	 * @return a String; never null
	 */
	public abstract String getOkLabel();

	/**
	 * Returns the CANCEL label for a Dialog button.
	 * 
	 * @return a String; never null
	 */
	public abstract String getCancelLabel();

	/**
	 * Returns the YES label for a Dialog button.
	 * 
	 * @return a String; never null
	 */
	public abstract String getYesLabel();

	/**
	 * Returns the NO label for a Dialog button.
	 * 
	 * @return a String; never null
	 */
	public abstract String getNoLabel();
}
