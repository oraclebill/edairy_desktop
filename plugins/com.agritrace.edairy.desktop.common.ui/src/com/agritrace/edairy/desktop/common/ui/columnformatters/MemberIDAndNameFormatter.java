package com.agritrace.edairy.desktop.common.ui.columnformatters;

import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;

public class MemberIDAndNameFormatter extends ColumnFormatter {
	private String propertyName = null;

	public MemberIDAndNameFormatter(String string) {
		propertyName = string;
	}

	@Override
	public String getText( Object element) {
		String s = "Unknown member";
		try {
			if(propertyName != null) {
				element = PropertyUtils.getNestedProperty(element, propertyName);
			}
			final Membership m = (Membership) element;
			Person p = m.getMember();
			s = String.format("%s - %s, %s", m.getMemberNumber(), p.getFamilyName(), p.getGivenName());
		} catch (final Exception e) {
			e.printStackTrace();
			s = super.getText(element);
		}

		return s;
	}

}
