package com.agritrace.edairy.desktop.collection.ui.components.validators;

import java.util.Collection;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

import com.agritrace.edairy.desktop.common.model.tracking.Container;

class CanValidator implements IValidator {
	static final IStatus CONTAINER_NOT_FOUND = ValidationStatus.error("Container not found.");
	private final Collection<? extends Container> validCans;

	public CanValidator(Collection<? extends Container> cans) {
		validCans = cans;
	}

	@Override
	public IStatus validate(Object value) {
		return validCans.contains(value) ? ValidationStatus.OK_STATUS : CONTAINER_NOT_FOUND;
	}
}