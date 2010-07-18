package com.agritrace.edairy.desktop.collection.ui.components.validators;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;

class JournalLineValidator {
	
	private boolean errorDialogsEnabled;
	/**
	 * Called when the ID specified is not valid.
	 * 
	 * @param journalLine
	 * @param canId
	 * @return
	 */
	public boolean handleInvalidCanID(final CollectionJournalLine journalLine, final String canId) {
		boolean ret = true;

		if (errorDialogsEnabled) {
			ret = MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Error creating journal line",
					"Can't find container for " + canId + ". Do you want to continue create a new record? ");
		}

		// if we choose to continue;
		if (ret) {
			// suspend the record
			journalLine.setFlagged(true);
		}
		return ret;
	}

	/**
 * 
 */
	public boolean handleInvalidMemberID(final CollectionJournalLine journalLine, final String memberId) {
		boolean ret = true;
		if (errorDialogsEnabled) {
			ret = MessageDialog
					.openConfirm(
							Display.getDefault().getActiveShell(),
							"Error creating collection journal record!",
							"Can't find valid membership for "
									+ memberId
									+ ". The record will be marked as Suspended. Do you want to continue create a new record? ");
		}
		return ret;
	}

	/**
	 * Called when there is no can id specified.
	 * 
	 * @param journalLine
	 * @return false to abort the current operation (usually the 'save' of a journal line)
	 */
	public boolean handleNoCanSpecified(final CollectionJournalLine journalLine) {
		// this is the normal case for now.. in the future, this may be an error
		// or warning.
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public boolean handleTotalsNotEqualOnSave(CollectionJournalPage workingJournalPage) {
		return false;
	}

	/**
	 * Called when a can id is not recognized.
	 * 
	 * @param journalLine
	 * @param canId
	 * @return false to abort the current operation (usually the 'save' of a journal line)
	 */
	public boolean handleUnregisteredCan(final CollectionJournalLine journalLine, String canId) {

		return true;
	}
}