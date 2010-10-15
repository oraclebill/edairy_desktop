package com.agritrace.edairy.desktop.operations.ui.controllers;

import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.base.Company;

final class ContactPhoneColumnFormatter extends ColumnFormatter {
	@Override
	public String getText(Object element) {
		if (element instanceof Company) {

			final Company supplier = (Company) element;

			if (supplier.getContacts().size() > 0) {
				return supplier.getContacts().get(0).getPhoneNumber();
			}

		}
		return null;
	}
}