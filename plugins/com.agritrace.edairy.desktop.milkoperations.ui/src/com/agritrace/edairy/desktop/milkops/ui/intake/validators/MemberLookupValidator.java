package com.agritrace.edairy.desktop.milkops.ui.intake.validators;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.milkops.ui.intake.collectionline.IMemberLookup;

public class MemberLookupValidator implements IValidator {
	IMemberLookup memberProvider;

	public MemberLookupValidator(IMemberLookup memberProvider) {
		this.memberProvider = memberProvider;
	}

	@Override
	public IStatus validate(Object value) {
		String memberNumber = null;
		if (value instanceof CollectionJournalLine) {
			final CollectionJournalLine line = (CollectionJournalLine) value;
			if (line.getValidatedMember() != null) {
				return Status.OK_STATUS;
			}
			memberNumber = line.getRecordedMember();
		}
		if (value instanceof String) {
			memberNumber = (String) value;
		}
		if (memberProvider.getMember(memberNumber) != null) {
			return Status.OK_STATUS;
		}
		return ValidationStatus.warning("Member number not found!");
	}
}