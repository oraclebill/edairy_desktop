package com.agritrace.edairy.desktop.common.ui.columnformatters;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.base.Person;

public class PersonToFormattedName extends ColumnFormatter {
	private String propertyName = null;

	public PersonToFormattedName() {
		this(null);
	}

	public PersonToFormattedName(String string) {
		propertyName = string;
	}

	@Override
	public String getText(Object element) {
		if (propertyName != null) {
			element = getBeanProperty(element, propertyName);
		}
		if (element == null) {
			System.err.println("(null) recieved by PersonToFormattedName ColumnFormatter.");
		} else {
			try {
				final Person p = (Person) element;
				return String.format("%s, %s", p.getFamilyName(), p.getGivenName());
			} catch (final Exception e) {
				System.err.printf("Invalid type recieved by PersonToFormattedName ColumnFormatter: %s (%s)\n",
						element.getClass(), element);
			}
		}
		return super.getText(element);
	}

	private Object getBeanProperty(Object element, String propertyName2) {
		Object property = null;
		try {
			property = PropertyUtils.getNestedProperty(element, propertyName2);
		} catch (final IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return property;
	}

}
