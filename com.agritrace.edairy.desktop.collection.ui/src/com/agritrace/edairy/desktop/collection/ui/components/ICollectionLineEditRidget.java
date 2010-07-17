package com.agritrace.edairy.desktop.collection.ui.components;

import java.util.List;

import org.eclipse.riena.ui.ridgets.IComplexRidget;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;

public interface ICollectionLineEditRidget extends IComplexRidget {

	void setBinList(List<DairyContainer> binList);
	void setCollectionLine(CollectionJournalLine journaLine);
	List<DairyContainer> getBinList();

}
