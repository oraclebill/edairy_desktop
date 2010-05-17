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
package com.agritrace.edairy.desktop.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.swtdesigner.SWTResourceManager;

public class BlankView extends ViewPart {

    public BlankView() {
    }

    public static final String ID = "default.blank.view";

    @Override
    public void createPartControl(Composite parent) {
	final Composite top = new Composite(parent, SWT.NONE);
	top.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
    }

    @Override
    public void setFocus() {
    }

}
