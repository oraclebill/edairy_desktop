package com.agritrace.edairy.desktop.member.ui.controllers;

import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

final class ConstantColumnFormatter extends ColumnFormatter {
	private final String text;
	public ConstantColumnFormatter() {
		this("N/A");
	}
	public ConstantColumnFormatter(String text) {
		this.text = text;
	}
	@Override
	public String getText(Object element) {
		return text;
	}
}