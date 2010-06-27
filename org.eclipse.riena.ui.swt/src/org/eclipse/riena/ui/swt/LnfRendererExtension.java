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

import org.eclipse.riena.ui.swt.lnf.ILnfRenderer;
import org.eclipse.riena.ui.swt.lnf.ILnfRendererExtension;

/**
 * This is for creating {@code ILnfRendererExtension} manually.
 * 
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @noextend This class is not intended to be sub-classed by clients.
 */
class LnfRendererExtension implements ILnfRendererExtension {
	private final String lnfId;
	private final ILnfRenderer renderer;
	private final String lnfKey;

	/**
	 * @param lnfId
	 * @param renderer
	 */
	public LnfRendererExtension(ILnfRenderer renderer, String lnfKey) {
		super();
		this.lnfId = ""; //$NON-NLS-1$
		this.renderer = renderer;
		this.lnfKey = lnfKey;
	}

	public ILnfRenderer createRenderer() {
		return renderer;
	}

	public String getLnfId() {
		return lnfId;
	}

	public String getLnfKey() {
		return lnfKey;
	}
}