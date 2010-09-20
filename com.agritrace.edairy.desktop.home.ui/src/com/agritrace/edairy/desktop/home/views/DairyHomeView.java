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
package com.agritrace.edairy.desktop.home.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.ImageStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class DairyHomeView extends ViewPart {
	public static final String ID = "desktop.home.view";

	public DairyHomeView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayoutFactory.fillDefaults().generateLayout(parent);
		parent.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		parent.setLayout(new GridLayout(1, false));
		
		Browser browser = new Browser(parent, SWT.NONE);
		browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		browser.setUrl("http://www.google.com/");
	}

	@Override
	public void setFocus() {
	}

}
