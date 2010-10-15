package com.agritrace.edairy.desktop.operations.ui.controllers;

import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.base.Company;

final class ContactNameColumnFormatter extends ColumnFormatter {
	@Override
	public String getText(Object element) {
		if (element instanceof Company) {
			final Company supplier = (Company) element;
			if (supplier.getContactMethods().size() > 0) {
				return supplier.getContactMethods().get(0).getCmType().toString();
			}
		}
		return null;
	}
}