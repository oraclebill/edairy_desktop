package com.agritrace.edairy.desktop.collection.services;

import java.util.Date;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.internal.collection.services.MilkCollectionJournalLineRepository;
import com.google.inject.ImplementedBy;

@ImplementedBy(MilkCollectionJournalLineRepository.class)
public interface ICollectionJournalLineRepository extends IRepository<CollectionJournalLine> {
	int countByMemberCenterDate(final Membership member, final DairyLocation center, final Date date);
}
