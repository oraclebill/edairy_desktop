package com.agritrace.edairy.desktop.milkops.ui.components.journalheader;

import org.eclipse.riena.ui.ridgets.IComplexRidget;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;

public interface IJournalHeaderRidget extends IComplexRidget {
	public static final String HEADER_VALID = "header-valid";

	void bindToModel(CollectionGroup workingJournalPage);
	boolean isHeaderValid();
	void forceDriverTotalEditable();
}
