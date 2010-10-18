package com.agritrace.edairy.desktop.internal.persistence;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.common.persistence.IMilkCollectionRepository;
import com.agritrace.edairy.desktop.common.persistence.services.Transactional;
import com.agritrace.edairy.desktop.internal.common.persistence.RepositoryUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class MilkCollectionRepository extends RepositoryUtil<CollectionGroup>
		implements IMilkCollectionRepository {

	@Inject
	public MilkCollectionRepository(Provider<Session> provider) {
		super(provider);
	}

	@Override
	public List<CollectionGroup> all() {
		throw new UnsupportedOperationException();
	}

	@Override
	@Transactional
	public List<CollectionGroup> findCollectionGroups(DairyLocation route,
			CollectionSession collectionSession, Date startDate, Date endDate,
			JournalStatus status, boolean rejected, boolean missing,
			boolean flagged) {
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

		if (rejected)
			criteria.add(Restrictions.gt("rejectedCount", 0));
		
//		if (missing)
//			criteria.add(Restrictions.eq("", true));
//		
		if (flagged)
			criteria.add(Restrictions.eq("suspended", true));

		return (List<CollectionGroup>) criteria.list();
	}

}
