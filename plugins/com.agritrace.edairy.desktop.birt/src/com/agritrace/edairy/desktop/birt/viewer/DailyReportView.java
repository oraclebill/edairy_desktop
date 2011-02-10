package com.agritrace.edairy.desktop.birt.viewer;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.ui.util.FormToolkit;


public class DailyReportView extends ReportView {
	public DailyReportView() {
	}
	
	protected void setupParameterArea(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		FormToolkit formKit = new FormToolkit();
		formKit.createDateField(parent, "Report Date", "report-parameter-date");
	}
}
