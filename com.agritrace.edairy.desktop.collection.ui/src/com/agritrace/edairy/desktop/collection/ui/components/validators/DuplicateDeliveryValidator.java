package com.agritrace.edairy.desktop.collection.ui.components.validators;

import java.util.List;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class DuplicateDeliveryValidator implements IValidator {

	private IDairyRepository dairyRepo;

	public DuplicateDeliveryValidator(IDairyRepository dairyRepo) {
		this.dairyRepo = dairyRepo;
	}

	@Override
	public IStatus validate(Object value) {
		CollectionJournalLine line = (CollectionJournalLine) value;
		CollectionJournalPage page = line.getCollectionJournal();
		if (page != null) {
			if (page.getJournalEntries().contains(value)) {
				return ValidationStatus.error("Member number cannot appear twice in the same journal.");
			}
			List<CollectionJournalLine> collections = dairyRepo.getMemberCollectionsForSession(page.getSession(),
					(Membership) value);
			if (dairyRepo != null && collections != null && collections.size() > 0) {
				return ValidationStatus.warning("Member number appears in a separate journal for this session.");
			}
		}
		return ValidationStatus.ok();
	}
}