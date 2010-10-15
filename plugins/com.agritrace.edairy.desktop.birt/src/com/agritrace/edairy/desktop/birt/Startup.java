/* *****************************************************************************
 * Copyright (c) 2009 Ola Spjuth.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ola Spjuth - initial API and implementation
 ******************************************************************************/
package com.agritrace.edairy.desktop.birt;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IStartup;

/**
 * 
 * @author ola
 * 
 */
public class Startup implements IStartup {

	Browser browser;

	@Override
	public void earlyStartup() {

		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				final Shell shell = new Shell(Display.getDefault());
				browser = new Browser(shell, SWT.NONE);
			}
		});

		// Start up a background job for starting BIRT
		final Job loadBirtJob = new Job("Starting BIRT engine") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {

				monitor.beginTask("Initializing BIRT ", 3);
				monitor.worked(1);

				// WebViewer.startup();
				//
				// Bundle bundle = org.eclipse.core.runtime.Platform.getBundle(
				// Activator.PLUGIN_ID);
				// URL url = FileLocator.find(bundle,
				// new Path("/reports/empty.rptdesign"),
				// null);
				// final String rpt;
				// try {
				// rpt = FileLocator.toFileURL(url).getPath();
				//
				// //Do new viewer
				// // ViewerPlugin.getDefault( ).getPluginPreferences(
				// ).setValue("APPCONTEXT_EXTENSION_KEY", "MyAppContext");
				//
				// final HashMap myparms = new HashMap();
				// myparms.put("SERVLET_NAME_KEY", "frameset");
				// myparms.put("FORMAT_KEY", "html");
				//
				// monitor.worked( 1 );
				//
				// Display.getDefault().syncExec( new Runnable(){
				//
				// public void run() {
				// WebViewer.display(rpt, browser, myparms);
				// }} );
				//
				//
				// } catch ( IOException e ) {
				// e.printStackTrace();
				// }

				monitor.done();
				return Status.OK_STATUS;
			}

		};
		loadBirtJob.setUser(false);
		loadBirtJob.schedule();

	}

}
