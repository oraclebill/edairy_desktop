package com.agritrace.edairy.desktop.internal.common.persistence.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.annotations.Transactional;
import com.agritrace.edairy.desktop.common.persistence.dao.IMilkCollectionRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.RepositoryUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class MilkCollectionRepository extends RepositoryUtil<CollectionGroup> implements IMilkCollectionRepository {

	@Inject
	public MilkCollectionRepository(Provider<Session> provider) {
		super(provider);
	}

	@Override
	public List<CollectionGroup> all() {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<CollectionGroup> findCollectionGroups(DairyLocation route, CollectionSession collectionSession,
			Date startDate, Date endDate, JournalStatus status, Boolean rejected, Boolean missing, Boolean flagged) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria("CollectionGroup");

		if (route != null) {
			criteria.add(Restrictions.eq("collectionCenter", route));
		}

		if (collectionSession != null) {
			criteria.add(Restrictions.eq("session", collectionSession));
		}

		if (startDate != null) {
			criteria.add(Restrictions.ge("journalDate", startDate));
		}

		if (endDate != null) {
			criteria.add(Restrictions.le("journalDate", endDate));
		}

		if (status != null) {
			criteria.add(Restrictions.eq("status", status));
		}

		if (rejected != null && rejected.booleanValue())
			criteria.add(Restrictions.gt("rejectedCount", 0));

		// if (missing != null)
		// criteria.add(Restrictions.eq("??", missing));
		//
		if (flagged != null)
			criteria.add(Restrictions.eq("suspended", flagged));

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CollectionJournalLine> findCollections(Membership member, DairyLocation route, CollectionSession collectionSession,
			Date startDate, Date endDate, Boolean isMissing, Boolean isRejected, Boolean flagged) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria("CollectionJournalLine");
//									.createAlias("collectionJournal", "jrnl");
		
		if (member != null) {
			criteria.add(Restrictions.eq("validatedMember", member));
		}
		/*
		if (isRejected != null) {
			criteria.add(Restrictions.gt("rejected", isRejected));
		}

		if (isMissing != null) {
			criteria.add(Restrictions.eq("notRecorded", isMissing));
		}

		if (flagged != null) {
			criteria.add(Restrictions.eq("flagged", flagged));
		}
		*/
		
		if (route != null || collectionSession != null || startDate != null || endDate != null ) {
			criteria = criteria.createCriteria("collectionJournal");
			if (route != null) {
				criteria.add(Restrictions.eq("collectionCenter", route));
			}
	
			if (collectionSession != null) {
				criteria.add(Restrictions.eq("session", collectionSession));
			}
	
			if (startDate != null) {
				criteria.add(Restrictions.ge("journalDate", startDate));
			}

			if (endDate != null) {
				criteria.add(Restrictions.le("journalDate", endDate));
			}
		}
		

		return criteria.list();
	}

}
