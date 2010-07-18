package com.agritrace.edairy.desktop.common.ui.columnformatters;

import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.base.Person;

public class PersonToFormattedName extends ColumnFormatter {

	@Override
	public String getText(Object element) {
		if (element instanceof Person) {
			Person p = (Person) element;
			return String.format("%s, %s", p.getFamilyName(), p.getGivenName());
		}
		return super.getText(element);
	}

}
