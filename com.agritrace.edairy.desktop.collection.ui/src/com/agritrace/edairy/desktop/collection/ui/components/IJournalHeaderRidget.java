package com.agritrace.edairy.desktop.collection.ui.components;

import org.eclipse.riena.ui.ridgets.IComplexRidget;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;

public interface IJournalHeaderRidget extends IComplexRidget {

	void setOutputOnly(boolean b);
	void bindToModel(CollectionJournalPage workingJournalPage);

}
