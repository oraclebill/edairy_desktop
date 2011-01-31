package com.agritrace.edairy.desktop.common.persistence.dao;

import java.util.Date;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.dao.MilkCollectionRepository;
import com.google.inject.ImplementedBy;

@ImplementedBy(MilkCollectionRepository.class)
public interface IMilkCollectionRepository extends IRepository<CollectionGroup> {
	
	public List<CollectionGroup> findCollectionGroups(
			DairyLocation route, CollectionSession session, Date startDate, Date endDate, 
			JournalStatus status, Boolean rejected, Boolean missing, Boolean flagged );

	public List<CollectionJournalLine> findCollections(Membership member, DairyLocation route,
			CollectionSession collectionSession, Date startDate, Date endDate, Boolean isMissing, Boolean isRejected,
			Boolean flagged);
	
}
