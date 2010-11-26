package com.agritrace.edairy.desktop.common.ui.columnformatters;

import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

public class ConstantColumnFormatter extends ColumnFormatter {
	private final String text;
	public ConstantColumnFormatter() {
		this("N/A");
	}
	public ConstantColumnFormatter(String text) {
		this.text = text;
	}
	@Override
	public String getText(Object element) {
		System.out.println("::called::"+this.hashCode()+"::");
		return text;
	}
}