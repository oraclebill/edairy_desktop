package com.agritrace.edairy.desktop.collection.ui.dialogs;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.riena.core.util.ReflectionUtils;

public class ComboConverter extends Converter {
	private final String renderMethod;
	public ComboConverter(String renderMethod) {
		super(Object.class, String.class);
		this.renderMethod = renderMethod;
	}
	@Override
	public Object convert(Object value) {
		Object valueObject = value;
		if (value != null && renderMethod != null) {
			valueObject = ReflectionUtils.invoke(value, renderMethod, (Object[]) null);
		}
		if (valueObject == null || valueObject.toString() == null) {
			valueObject = "";
		}
		return valueObject.toString();
	}
}