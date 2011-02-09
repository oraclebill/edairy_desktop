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
package com.agritrace.edairy.desktop.birt.reports;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.agritrace.edairy.desktop.birt.controllers.ReportController;

public class MemberPayablesReportView extends ViewPart {

	public static final String ID = MemberPayablesReportView.class.getName();

	public MemberPayablesReportView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		new ReportController(ReportController.MEMBER_PAYABLE_YEAR).createPartControl(parent);
	}

	@Override
	public void setFocus() {
	}
}
