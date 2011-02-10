package com.agritrace.edairy.desktop.birt.viewer;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.ui.util.FormToolkit;

public class MonthlyReportView extends ReportView {

	public MonthlyReportView() {
	}

	@Override
	protected void setupParameterArea(Composite parent) {
		parent.setLayout(new GridLayout(2, true));
		FormToolkit toolkit = new FormToolkit();
		toolkit.createComboField(parent, "Month", "report-parameter-month");
		toolkit.createComboField(parent, "Year", "report-parameter-year");
	}
	
	

}
