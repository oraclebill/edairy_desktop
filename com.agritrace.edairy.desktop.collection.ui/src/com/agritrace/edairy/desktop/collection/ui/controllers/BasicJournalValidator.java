package com.agritrace.edairy.desktop.collection.ui.controllers;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.internal.collection.ui.Activator;

public class BasicJournalValidator implements IValidator {

	@Override
	public IStatus validate(Object value) {
		IStatus status = ValidationStatus.OK_STATUS;
		if (value instanceof CollectionJournalPage) {
			MultiStatus statusList = new MultiStatus(Activator.class.getName(), 0, "Validation Messages", null);
			CollectionJournalPage journal = (CollectionJournalPage)value;
			if (journal.getEntryCount() != journal.getJournalEntries().size()) {
				statusList.add(ValidationStatus.cancel("System Error: entry count and number of entries don't match. Please contact support."));
			}
			if (journal.getDriverTotal() == null) {
				statusList.add(ValidationStatus.cancel("System Error: driver total not set. Please contact support."));
			}
			if (!journal.getDriverTotal().equals(journal.getRecordTotal())) {
				statusList.add(ValidationStatus.error(String.format("The driver total (%s) and calculated total (%s) do not match.", journal.getDriverTotal(), journal.getRecordTotal())));					
			}
			if (0 == journal.getJournalEntries().size()) {
				statusList.add(ValidationStatus.error("This journal has no entries - cannot save."));
			}
			if (0 == journal.getJournalEntries().size()) {
				statusList.add(ValidationStatus.error("This journal has no entries - cannot save."));
			}
			if (statusList.getChildren().length > 0) {
				status = statusList;
			}
		}
		else 
		{
			status = ValidationStatus.error("Invalid record type: " + value.getClass());					
		}
		return status;
	}

}