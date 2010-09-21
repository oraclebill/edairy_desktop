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

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.LocationAdapter;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.ViewPart;

import com.agritrace.edairy.desktop.internal.home.HomeActivator;

public class DairyHomeView extends ViewPart {
	public static final String ID = "desktop.home.view";

	public static class HomepageLocationListener extends LocationAdapter {

		@Override
		public void changing(LocationEvent event) {
			System.err.println("CHANGING: " + event.location);
//			event.doit = false;
		}

	}

	public DairyHomeView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayoutFactory.fillDefaults().generateLayout(parent);
		parent.setBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_WHITE));
		parent.setLayout(new GridLayout(1, false));

		Browser browser = new Browser(parent, SWT.NONE);
		browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		browser.addLocationListener(new HomepageLocationListener());
		try {
			browser.setUrl(FileLocator.resolve(
					new URL(HomeActivator.PLUGIN_WEB_PATH + "index.html"))
					.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setFocus() {
	}

}
