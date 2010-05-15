package com.agritrace.edairy.ui.views;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class StringNumberValidator implements IValidator {

    @Override
    public IStatus validate(Object value) {
	if (value == null) {
	    throw new IllegalArgumentException("Parameter 'value' cannot be null.");
	} else {
	    final String strValue = (String) value;
	    try {
		@SuppressWarnings("unused")
		final Integer i = new Integer(strValue);
	    } catch (final NumberFormatException ex) {
		return ValidationStatus.error(ex.getMessage());
	    }

	    return Status.OK_STATUS;

	}
    }

}
