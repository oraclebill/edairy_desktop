package com.agritrace.edairy.desktop.collection.services;

import java.util.Date;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.IRepository;

public interface ICollectionJournalLineRepository extends IRepository<CollectionJournalLine> {
	int countByMemberCenterDate(final Membership member, final DairyLocation center, final Date date);
	List<CollectionJournalLine> allForDate(Date date);
}
