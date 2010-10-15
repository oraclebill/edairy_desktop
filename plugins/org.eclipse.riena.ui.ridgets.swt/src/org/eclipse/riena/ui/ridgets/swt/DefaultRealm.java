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

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.widgets.Display;

/**
 * Simple realm implementation that will set itself as default when constructed.
 */
public class DefaultRealm extends Realm {

	private Realm previousRealm;

	public DefaultRealm() {
		previousRealm = super.setDefault(this);
	}

	DefaultRealm(Display display) {
		Assert.isNotNull(display);
		previousRealm = super.setDefault(this);
	}

	/**
	 * @return always returns true
	 */
	@Override
	public boolean isCurrent() {
		return true;
	}

	@Override
	protected void syncExec(Runnable runnable) {
		runnable.run();
	}

	/**
	 * @throws UnsupportedOperationException
	 */
	@Override
	public void asyncExec(Runnable runnable) {
		throw new UnsupportedOperationException("asyncExec is unsupported"); //$NON-NLS-1$
	}

	/**
	 * Removes the realm from being the current and sets the previous realm to
	 * the default.
	 */
	public void dispose() {
		if (getDefault() == this) {
			setDefault(previousRealm);
		}
	}

}
