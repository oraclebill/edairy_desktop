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
package org.eclipse.riena.internal.ui.ridgets.swt;

import org.eclipse.riena.ui.ridgets.swt.AbstractSWTRidget;
import org.eclipse.riena.ui.swt.ModuleTitleBar;

/**
 * Ridget for {@link ModuleTitleBarRidget}.
 */
public class ModuleTitleBarRidget extends EmbeddedTitleBarRidget {

	/**
	 * @see org.eclipse.riena.ui.ridgets.swt.AbstractSWTRidget#checkUIControl
	 *      (java.lang.Object)
	 */
	@Override
	protected void checkUIControl(Object uiControl) {
		AbstractSWTRidget.assertType(uiControl, ModuleTitleBar.class);
	}

	/**
	 * @return the closeable
	 */
	public boolean isCloseable() {
		return getUIControl().isCloseable();
	}

	/**
	 * @param closeable
	 *            the closeable to set
	 */
	@Override
	public void setCloseable(boolean closeable) {
		if (getUIControl() != null) {
			getUIControl().setCloseable(closeable);
		}
	}

}
