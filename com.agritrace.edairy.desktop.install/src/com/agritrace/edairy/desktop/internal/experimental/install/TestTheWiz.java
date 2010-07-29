/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.agritrace.edairy.desktop.internal.experimental.install;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.ProgressMonitorPart;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.install.MemberImportTool;
import com.agritrace.edairy.desktop.install.handlers.HandlerBase;

/**
 * Example how to load data from a background thread into a TableViewer
 * 
 * @author Tom Schindl <tom.schindl@bestsolution.at>
 * @since 1.0
 */
public class TestTheWiz {

	private PreferenceStore prefStore;

	private class ImportWizard extends Wizard {

		private String fileName;

		public ImportWizard() {
			setNeedsProgressMonitor(true);
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.wizard.Wizard#addPages()
		 */
		public void addPages() {
			System.err.println("addpage: " + this);
			addPage(new FileSelectionPage("Standard Page"));
			System.err.println("addpage 2: " + this);
			addPage(new ImportStatusPage("Thread Page"));
		}

		public boolean performFinish() {
			return true;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.wizard.Wizard#canFinish()
		 */
		public boolean canFinish() {
			IWizardPage[] pages = getPages();
			for (int i = 0; i < pages.length; i++) {
				if (!pages[i].isPageComplete()) {
					return false;
				}
			}

			return true;
		}

	};

	private class FileSelectionPage extends WizardPage {

		protected FileSelectionPage(String pageName) {
			super(pageName);
			setTitle(pageName);
			prefStore = new PreferenceStore();
			prefStore.setDefault("fileName", "");
			prefStore.addPropertyChangeListener(new IPropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent event) {
					((ImportWizard) getWizard()).setFileName(prefStore.getString("fileName"));
					setPageComplete(prefStore.getString("fileName").length() > 0);
				}
			});
		}

		public void createControl(Composite parent) {
			System.err.println("createControl: " + this);
			Composite comp = new Composite(parent, SWT.NONE);
			setControl(comp);
			FileFieldEditor fileEditor = new FileFieldEditor("fileName", "File", comp);
			fileEditor.setPreferenceStore(prefStore);
		}

	}

	private static class ImportStatusPage extends WizardPage {
		private boolean loading = true;
		private TableViewer v;
		private String fileName;
		private ProgressMonitorPart progressPart;

		protected ImportStatusPage(String pageName) {
			super(pageName);
			setTitle(pageName);
		}

		public void createControl(final Composite parent) {
			System.err.println("createControl: " + this);
			final Composite comp = new Composite(parent, SWT.NONE);
			comp.setLayout(new GridLayout(1, false));

			v = new TableViewer(comp, SWT.FULL_SELECTION);
			v.setContentProvider(new ArrayContentProvider());
			v.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
			v.addSelectionChangedListener(new ISelectionChangedListener() {
				public void selectionChanged(SelectionChangedEvent event) {
					getWizard().getContainer().updateButtons();
				}
			});

			progressPart = new ProgressMonitorPart(comp, null);
			progressPart.setLayoutData(new GridData(SWT.FILL, SWT.CENTER));

			Label l = new Label(comp, SWT.NONE);
			l.setText("Loading Data");
			l.setLayoutData(new GridData(SWT.FILL, SWT.CENTER));

			setControl(comp);
			new Thread(new Importer()).start();
		}

		class Importer implements Runnable {
			public void run() {
				final String fileName = ((ImportWizard) getWizard()).getFileName();
				final IProgressMonitor monitor = progressPart;
				int chuck = 3000;
				try {
					chuck = HandlerBase.countLines(new FileInputStream(new File(fileName)));
				} catch (Exception e) {
				}
				final int max = chuck;
				final HashMap<String, List<String[]>> map = new HashMap<String, List<String[]>>();
				final List<Membership> members = new ArrayList<Membership>();

				progressPart.getDisplay().syncExec(new Runnable() {
					public void run() {
						v.setInput(members);

						FileInputStream stream;
						try {
							monitor.beginTask("Importing..", max);
							stream = new FileInputStream(new File(fileName));
							MemberImportTool importTool = new MemberImportTool(stream, members, map, monitor);
							importTool.processFile();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						setPageComplete(true);
						getWizard().getContainer().updateButtons();
					}

				});
			}
		}

	}

	public void run(String[] args) {
		Display display = new Display();

		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());

		shell.open();

		WizardDialog dialog = new WizardDialog(shell, new ImportWizard());
		dialog.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();
	}

	public static void main(String[] args) {
		TestTheWiz wiz = new TestTheWiz();
		wiz.run(args);
	}

}
