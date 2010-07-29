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

import java.util.ArrayList;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

/**
 * Example how to load data from a background thread into a TableViewer
 *
 * @author Tom Schindl <tom.schindl@bestsolution.at>
 * @since 1.0
 */
public class Snippet047WizardWithLongRunningOperation {

	private static class MyWizard extends Wizard {

		private int loadingType;

		public MyWizard(int loadingType) {
			this.loadingType = loadingType;
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see org.eclipse.jface.wizard.Wizard#addPages()
		 */
		public void addPages() {
			System.err.println("addp: " + this);
			addPage(new MyWizardPage("Standard Page"));
			System.err.println("addp2: " + this);
			addPage(new MyWizardPageThread("Thread Page", loadingType));
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

	private static class MyWizardPage extends WizardPage {

		protected MyWizardPage(String pageName) {
			super(pageName);
			setTitle(pageName);
		}

		public void createControl(Composite parent) {
			System.err.println("createControl: " + this);
			Composite comp = new Composite(parent, SWT.NONE);
			setControl(comp);
		}
	}

	private static class MyWizardPageThread extends WizardPage {
		private int loadingType;
		private boolean loading = true;
		private TableViewer v;
		private Composite barContainer;
		private ProgressBar bar;
		private Composite comp;

		protected MyWizardPageThread(String pageName, int loadingType) {
			super(pageName);
			this.loadingType = loadingType;
			setTitle(pageName);
		}

		public void createControl(final Composite parent) {
			System.err.println("createControl: " + this);
			comp = new Composite(parent, SWT.NONE);
			comp.setLayout(new GridLayout(1, false));

			v = new TableViewer(comp, SWT.FULL_SELECTION);
			v.setContentProvider(new ArrayContentProvider());
			v.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
			v.addSelectionChangedListener(new ISelectionChangedListener() {

				public void selectionChanged(SelectionChangedEvent event) {
					getWizard().getContainer().updateButtons();
				}

			});

			barContainer = new Composite(comp, SWT.NONE);
			barContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			barContainer.setLayout(new GridLayout(2, false));

			Label l = new Label(barContainer, SWT.NONE);
			l.setText("Loading Data");

			bar = new ProgressBar(barContainer,
					(loadingType == 1) ? SWT.INDETERMINATE : SWT.NONE);
			bar.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

			if (loadingType == 2) {
				bar.setMaximum(10);
			}
			comp.addListener(SWT.Show, new Listener() {				
				@Override
				public void handleEvent(Event event) {
					startImport();
				}
			});
			
			setControl(comp);
			
		}
		
		protected void startImport() {
			System.err.println("startImport: " + this);

			Thread t = new Thread() {

				public void run() {
					System.err.println("in run: " + this);
					if (loadingType == 1) {
						try {
							Thread.sleep(10000);
							final ArrayList ms = new ArrayList();
							for (int i = 0; i < 10; i++) {
								ms.add(new MyModel(i));
							}

							if (v.getTable().isDisposed()) {
								return;
							}

							barContainer.getDisplay().asyncExec(new Runnable() {

								public void run() {
									v.setInput(ms);
									((GridData) barContainer.getLayoutData()).exclude = true;
									comp.layout(true);
								}

							});
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						System.err.println("in run: " + this);
						final ArrayList ms = new ArrayList();
						barContainer.getDisplay().syncExec(new Runnable() {

							public void run() {
								System.err.println("setInput: " + this);
								v.setInput(ms);
							}

						});

						for (int i = 0; i < 10; i++) {
							final int j = i;
							if (v.getTable().isDisposed()) {
								return;
							}
							barContainer.getDisplay().asyncExec(new Runnable() {

								public void run() {
									System.err.println("adding data: " + this);
									MyModel tmp = new MyModel(j);
									v.add(tmp);
									ms.add(tmp);
									bar.setSelection(j + 1);
								}
							});

							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

						barContainer.getDisplay().asyncExec(new Runnable() {

							public void run() {
								((GridData) barContainer.getLayoutData()).exclude = true;
								comp.layout(true);
							}

						});
					}

					barContainer.getDisplay().syncExec(new Runnable() {

						public void run() {
							loading = false;
							getWizard().getContainer().updateButtons();
						}

					});
				}

			};

			t.start();
		}

		public boolean isPageComplete() {
			return !loading && !v.getSelection().isEmpty();
		}

	}

	private static class MyModel {
		private int index;

		public MyModel(int index) {
			this.index = index;
		}

		public String toString() {
			return "Item-" + index;
		}
	}

	public static void main(String[] args) {
		Display display = new Display();

		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());

		Button b = new Button(shell, SWT.PUSH);
		b.setText("Load in one Chunk");
		b.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				WizardDialog dialog = new WizardDialog(shell, new MyWizard(1));
				dialog.open();
			}

		});

		b = new Button(shell, SWT.PUSH);
		b.setText("Load Item by Item");
		b.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				WizardDialog dialog = new WizardDialog(shell, new MyWizard(2));
				dialog.open();
			}

		});

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();
	}
}
