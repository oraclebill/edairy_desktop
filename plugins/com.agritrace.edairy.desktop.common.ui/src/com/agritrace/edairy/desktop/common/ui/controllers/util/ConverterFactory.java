package com.agritrace.edairy.desktop.common.ui.controllers.util;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;

class ConverterFactory extends UpdateValueStrategy {
	@Override
	public IConverter createConverter(Object fromType, Object toType) {
		return super.createConverter(fromType, toType);
	}
}