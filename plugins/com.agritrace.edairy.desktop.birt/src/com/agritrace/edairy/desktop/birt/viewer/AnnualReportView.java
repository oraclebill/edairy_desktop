package com.agritrace.edairy.desktop.birt.viewer;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.ui.util.FormToolkit;

public class AnnualReportView extends ReportView {

	public AnnualReportView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setupParameterArea(Composite parent) {
		parent.setLayout(new GridLayout());
		new FormToolkit().createWrappedTextField(parent, "Year", "report-parameter-year");
	}
	
	


}
