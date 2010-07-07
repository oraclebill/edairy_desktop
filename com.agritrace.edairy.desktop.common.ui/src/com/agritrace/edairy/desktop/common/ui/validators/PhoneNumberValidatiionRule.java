package com.agritrace.edairy.desktop.common.ui.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class PhoneNumberValidatiionRule implements IValidator {

	@Override
	public IStatus validate(Object value) {
		if (value instanceof String) {
			final Pattern pattern = Pattern.compile("[^0-9]");
			final Matcher m = pattern.matcher((String) value);
			if (m.find()) {
				return ValidationStatus.error("Invaliate number");
			} else {
				return Status.OK_STATUS;
			}

		}
		return null;
	}

}
