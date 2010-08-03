package com.agritrace.edairy.desktop.collection.ui.components.validators;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

import com.agritrace.edairy.desktop.collection.ui.components.collectionline.IMemberInfoProvider;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;

public class MemberLookupValidator implements IValidator {
	IMemberInfoProvider memberProvider;

	public MemberLookupValidator(IMemberInfoProvider memberProvider) {
		this.memberProvider = memberProvider;
	}

	@Override
	public IStatus validate(Object value) {
		String memberNumber = null;
		if (value instanceof CollectionJournalLine) {
			CollectionJournalLine line = (CollectionJournalLine) value;
			if (line.getValidatedMember() != null) {
				return ValidationStatus.OK_STATUS;
			}
			memberNumber = line.getRecordedMember();
		}
		if (value instanceof String) {
			memberNumber = (String) value;
		}
		if (memberProvider.getMember(memberNumber) != null) {
			return ValidationStatus.OK_STATUS;
		}
		return ValidationStatus.warning("Member number not found!");
	}
}