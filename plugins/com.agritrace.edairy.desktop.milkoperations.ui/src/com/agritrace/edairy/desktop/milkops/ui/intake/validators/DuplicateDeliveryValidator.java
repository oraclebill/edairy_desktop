package com.agritrace.edairy.desktop.milkops.ui.intake.validators;

import java.util.Collection;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;

public class DuplicateDeliveryValidator implements IValidator {

	private final Collection<CollectionJournalLine> searchScope;
	private final String scopeDescription;

	@SuppressWarnings("unchecked")
	public DuplicateDeliveryValidator(Collection<?> scope, String scopeDescription) {
		this.searchScope = (Collection<CollectionJournalLine>)scope;
		this.scopeDescription = scopeDescription;
	}

	@Override
	public IStatus validate(Object value) {
		if (value instanceof CollectionJournalLine) {
			final CollectionJournalLine testVal = (CollectionJournalLine)value;
			for (final CollectionJournalLine line : searchScope) {
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