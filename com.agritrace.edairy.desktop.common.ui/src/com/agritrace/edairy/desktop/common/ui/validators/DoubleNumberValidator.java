package com.agritrace.edairy.desktop.common.ui.validators;

import java.text.NumberFormat;
import java.text.ParseException;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class DoubleNumberValidator implements IValidator {
	private NumberFormat format = null;
	
	private NumberFormat getNumberFormat() {
		if (format == null)
			format = NumberFormat.getInstance();
		
		return format;
	}

	@Override
	public IStatus validate(Object value) {
		final String inputValue = (String) value;
		try {
			getNumberFormat().parse(inputValue);
			return Status.OK_STATUS;

		} catch (final ParseException ex) {
			return ValidationStatus.error(ex.getMessage());
		}
	}

}
