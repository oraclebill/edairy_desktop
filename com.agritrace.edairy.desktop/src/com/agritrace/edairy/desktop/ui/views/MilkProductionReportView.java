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

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.agritrace.ediary.desktop.reports.controllers.ReportController;

public class MilkProductionReportView extends ViewPart {

	public static final String ID = "reports.milk.production";

	public MilkProductionReportView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		new ReportController(ReportController.MILK_COLLECTION_YEAR).createPartControl(parent);
//		final Composite top = new Composite(parent, SWT.NONE);
//		top.setSize(new Point(800, 800));
//		top.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
//		top.setLayout(new GridLayout(1, false));
//
//		final ScrolledComposite scrolledComposite = new ScrolledComposite(top, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
//		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
//		scrolledComposite.setExpandHorizontal(true);
//		scrolledComposite.setExpandVertical(true);
//
//		final Label label = new Label(scrolledComposite, SWT.NONE);
//		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
//		
//		
//		final Image img = ImageStore.getInstance().getImage("eDairyReportTemplate-milkproduction.jpg");
//		System.err.println("Image: " + img);
//		label.setImage(img);
//		scrolledComposite.setContent(label);
//		scrolledComposite.setMinSize(label.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
	}

	@Override
	public void setFocus() {
	}
}
