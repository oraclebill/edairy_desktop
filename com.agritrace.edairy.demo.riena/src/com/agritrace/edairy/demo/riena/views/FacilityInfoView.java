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
package com.agritrace.edairy.demo.riena.views;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class FacilityInfoView extends ViewPart {

	public static final String ID = "com.agritrace.edairy.demo.riena.views.FacilityInfoView"; //$NON-NLS-1$

	@Override
	public void createPartControl(Composite parent) {
		Composite top = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		top.setLayout(layout);
		// top banner
		Composite banner = new Composite(top, SWT.NONE);
		banner.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL, GridData.VERTICAL_ALIGN_BEGINNING, true,
				false));
		layout = new GridLayout();
		layout.marginHeight = 5;
		layout.marginWidth = 10;
		layout.numColumns = 2;
		banner.setLayout(layout);

		// setup bold font
		Font boldFont = JFaceResources.getFontRegistry().getBold(JFaceResources.DEFAULT_FONT);

		Label l = new Label(banner, SWT.WRAP);
		l.setText("Subject:"); //$NON-NLS-1$
		l.setFont(boldFont);
		l = new Label(banner, SWT.WRAP);
		l.setText("This is a message about the cool Eclipse RCP!"); //$NON-NLS-1$

		l = new Label(banner, SWT.WRAP);
		l.setText("From:"); //$NON-NLS-1$
		l.setFont(boldFont);

		final Link link = new Link(banner, SWT.NONE);
		link.setText("<a>nicole@mail.org</a>"); //$NON-NLS-1$
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(getSite().getShell(),
						"Not Implemented", "Imagine the address book or a new message being created now."); //$NON-NLS-1$ //$NON-NLS-2$
			}
		});

		l = new Label(banner, SWT.WRAP);
		l.setText("Date:"); //$NON-NLS-1$
		l.setFont(boldFont);
		l = new Label(banner, SWT.WRAP);
		l.setText("10:34 am"); //$NON-NLS-1$
		// message contents
		Text text = new Text(top, SWT.MULTI | SWT.WRAP);
		text
				.setText("This RCP Application was generated from the PDE Plug-in Project wizard. This sample shows how to:\n" + //$NON-NLS-1$
						"- add a top-level menu and toolbar with actions\n" + //$NON-NLS-1$
						"- add keybindings to actions\n" + //$NON-NLS-1$
						"- create views that can't be closed and\n" + //$NON-NLS-1$
						"  multiple instances of the same view\n" + //$NON-NLS-1$
						"- perspectives with placeholders for new views\n" + //$NON-NLS-1$
						"- use the default about dialog\n" + //$NON-NLS-1$
						"- create a product definition\n"); //$NON-NLS-1$
		text.setLayoutData(new GridData(GridData.FILL_BOTH));
	}

	@Override
	public void setFocus() {
	}

}
