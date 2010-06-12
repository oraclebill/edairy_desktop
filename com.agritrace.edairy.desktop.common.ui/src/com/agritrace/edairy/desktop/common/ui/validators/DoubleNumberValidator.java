package com.agritrace.edairy.desktop.common.ui.validators;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class DoubleNumberValidator implements IValidator {

	@Override
	public IStatus validate(Object value) {
		String inputValue = (String) value;
		try {
			double capacityValue = Double.valueOf(inputValue);
			return Status.OK_STATUS;

		} catch (NumberFormatException ex) {
			return ValidationStatus.error(ex.getMessage());
		}
	}

}
