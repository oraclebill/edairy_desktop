package com.agritrace.edairy.desktop.collection.ui.components.validators;

import java.math.BigDecimal;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;


class SimpleJournalLineValidator implements IValidator {
	private boolean validateMember = true;
	private boolean validateBin = true;

	SimpleJournalLineValidator() {
	}

	public boolean isValidateMember() {
		return validateMember;
	}

	public void setValidateMember(boolean validateMember) {
		this.validateMember = validateMember;
	}

	public boolean isValidateBin() {
		return validateBin;
	}

	public void setValidateBin(boolean validateBin) {
		this.validateBin = validateBin;
	}

	@Override
	public IStatus validate(Object value) {
		CollectionJournalLine line = (CollectionJournalLine) value;
		IStatus validationStatus = ValidationStatus.ok();
		if (line == null) {
			validationStatus = ValidationStatus.error("Invalid state - collection line unset.");
		}
		if (validateBin && line.getDairyContainer() == null) {
			validationStatus = ValidationStatus.error("Bin ID is not set.");
		}
		if ((line.getQuantity() == null) || line.getQuantity().equals(BigDecimal.ZERO)) {
			validationStatus = ValidationStatus.error("Quantity must be greater than zero.");
		}
		if (validateMember && (line.getRecordedMember() == null) || (line.getRecordedMember().length() <= 0)) {
			validationStatus = ValidationStatus.error("Member ID is not set.");
		}
		return validationStatus;
	}
}