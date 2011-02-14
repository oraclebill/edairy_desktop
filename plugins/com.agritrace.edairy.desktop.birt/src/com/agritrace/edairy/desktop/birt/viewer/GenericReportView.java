package com.agritrace.edairy.desktop.birt.viewer;

import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.ui.controls.fieldgroup.FieldGroup;


public class GenericReportView extends ReportView {
	public GenericReportView() {
	}
	
	protected void setupParameterArea(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		
		FieldGroup fieldGroup = new FieldGroup(parent, SWT.NONE);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(fieldGroup, "parameter-field-group");		
	}
}
