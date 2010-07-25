package com.agritrace.edairy.desktop.collection.ui.components.validators;

import java.util.Collection;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;

public class DuplicateDeliveryValidator implements IValidator {

	private Collection<?> searchScope;
	private String scopeDescription;

	public DuplicateDeliveryValidator(Collection<?> scope, String scopeDescription) {
		this.searchScope = scope;
		this.scopeDescription = scopeDescription;
	}

	@Override
	public IStatus validate(Object value) {
		if (searchScope.contains(value)) {
			return ValidationStatus
					.warning("Duplicate member delivery found in " + scopeDescription);
		}
		return ValidationStatus.ok();
	}
}