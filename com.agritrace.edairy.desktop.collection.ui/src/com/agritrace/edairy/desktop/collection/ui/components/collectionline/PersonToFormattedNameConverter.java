package com.agritrace.edairy.desktop.collection.ui.components.collectionline;

import org.eclipse.core.databinding.conversion.Converter;

import com.agritrace.edairy.desktop.common.model.base.Person;

public final class PersonToFormattedNameConverter extends Converter {
	private String defaultValue;

	public PersonToFormattedNameConverter(String defaultValue) {
		super(Person.class, String.class);
		this.defaultValue = defaultValue;
	}

	@Override
	public Object convert(Object fromObject) {
		String formattedName = defaultValue;
		if (fromObject instanceof Person) {
			Person person = (Person) fromObject;
			formattedName = String.format("%s, %s", person.getFamilyName(), person.getGivenName());
		}
		return formattedName;
	}
}