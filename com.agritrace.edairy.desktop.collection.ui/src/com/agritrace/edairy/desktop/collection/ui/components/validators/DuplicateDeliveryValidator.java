package com.agritrace.edairy.desktop.collection.ui.components.validators;

import java.util.Collection;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;

public class DuplicateDeliveryValidator implements IValidator {

	private Collection<CollectionJournalLine> searchScope;
	private String scopeDescription;

	public DuplicateDeliveryValidator(Collection<?> scope, String scopeDescription) {
		this.searchScope = (Collection<CollectionJournalLine>)scope;
		this.scopeDescription = scopeDescription;
	}

	@Override
	public IStatus validate(Object value) {
		if (value instanceof CollectionJournalLine) {
			CollectionJournalLine testVal = (CollectionJournalLine)value;
			for (CollectionJournalLine line : searchScope) {
				if (line.getValidatedMember() == testVal 
						|| line.getRecordedMember() == null 
								|| line.getRecordedMember().equals(testVal.getRecordedMember())) {
					return ValidationStatus
						.warning("Duplicate member delivery found in " + scopeDescription);
				}
			}
		}
		else {
			return ValidationStatus.error("illegal state");
		}
		return ValidationStatus.ok();
	}
}