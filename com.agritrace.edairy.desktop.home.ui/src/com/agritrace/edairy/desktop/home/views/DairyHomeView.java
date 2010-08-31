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

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;

import com.agritrace.edairy.desktop.reporting.views.SimpleReportView;

public class DairyHomeView extends SimpleReportView {

	public static final String ID = "desktop.home.view";

	public DairyHomeView() {
	}

	@Override
	public void setFocus() {
	}

	@Override
	protected String getReportURL() {
		String reportURL = null;
		Bundle bundle = org.eclipse.core.runtime.Platform
				.getBundle("com.agritrace.edairy.desktop.common.reporting");
		URL url = FileLocator.find(bundle, new Path(
				"/reports/dairy_home.rptdesign"), null);
		try {
			reportURL = FileLocator.toFileURL(url).getPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.err.println("Rerturngin report url:" + reportURL);
		return reportURL;
	}
}
