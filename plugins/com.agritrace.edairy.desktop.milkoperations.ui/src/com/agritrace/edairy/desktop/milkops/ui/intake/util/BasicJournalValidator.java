package com.agritrace.edairy.desktop.milkops.ui.intake.util;

import java.math.BigDecimal;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.internal.milkops.ui.Activator;

public class BasicJournalValidator implements IValidator {

	@Override
	public IStatus validate(Object value) {
		IStatus status = Status.OK_STATUS;
		if (value instanceof CollectionGroup) {
			final MultiStatus statusList = new MultiStatus(Activator.class.getName(), 0, "Validation Messages", null);
			final CollectionGroup journal = (CollectionGroup)value;
			if (journal.getEntryCount() != journal.getEntries().size()) {
				statusList.add(ValidationStatus.cancel("System Error: entry count and number of entries don't match. Please contact support."));
			}
			if (journal.getDriverTotal() == null) {
				statusList.add(ValidationStatus.cancel("System Error: driver total not set. Please contact support."));
			}
			final BigDecimal record = journal.getRecordTotal(), driver = journal.getDriverTotal();
			if (record != null && driver != null && record.compareTo(driver) != 0
					|| record == null || driver == null) {
				statusList.add(ValidationStatus.warning(String.format("The driver total (%s) and calculated total (%s) do not match.", driver, record)));
			}
//			if (0 == journal.getJournalEntries().size()) {
//				statusList.add(ValidationStatus.warning("This journal has no entries - cannot save."));
//			}
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