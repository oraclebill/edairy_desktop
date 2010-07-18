package com.agritrace.edairy.desktop.collection.ui.components.validators;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

class MemberLookupValidator implements IValidator {
	IDairyRepository dairyRepo;

	public MemberLookupValidator(IDairyRepository dairyRepo) {
		this.dairyRepo = dairyRepo;
	}

	@Override
	public IStatus validate(Object value) {
		if (value instanceof String) {
			final String memberNumber = (String) value;
			if (dairyRepo.getMembershipById(memberNumber) != null)
				return ValidationStatus.OK_STATUS;
		}
		return ValidationStatus.error("Member number not found.");
	}
}