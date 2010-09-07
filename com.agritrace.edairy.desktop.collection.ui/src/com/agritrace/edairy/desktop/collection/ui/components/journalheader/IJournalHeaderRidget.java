package com.agritrace.edairy.desktop.collection.ui.components.journalheader;

import org.eclipse.riena.ui.ridgets.IComplexRidget;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;

public interface IJournalHeaderRidget extends IComplexRidget {
	public static final String HEADER_VALID = "header-valid";

	void bindToModel(CollectionJournalPage workingJournalPage);
	boolean isHeaderValid();
	void forceDriverTotalEditable();
}
