package com.agritrace.edairy.desktop.internal.common.persistence.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.hibernate.Criteria;
import org.hibernate.Query;
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

public class MilkCollectionRepository extends RepositoryUtil<CollectionGroup> implements IMilkCollectionRepository
{

	@Inject
	public MilkCollectionRepository(Provider<Session> provider) {
		super(provider);
	}

	@Override
	public List<CollectionGroup> all()
	{
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<CollectionGroup> findCollectionGroups(	DairyLocation route,
														CollectionSession collectionSession,
														Date startDate,
														Date endDate,
														JournalStatus status,
														Boolean rejected,
														Boolean missing,
														Boolean flagged)
	{
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria("CollectionGroup");

		if (route != null) {
			criteria.add(Restrictions.eq("collectionCenter", route));
		}

		if (collectionSession != null) {
			criteria.add(Restrictions.eq("session", collectionSession));
		}

		if (startDate != null) {
			criteria.add(Restrictions.ge("collectionDate", startDate));
		}

		if (endDate != null) {
			criteria.add(Restrictions.le("collectionDate", endDate));
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

	public BigDecimal sumCollections(	Date startDate,
										Date endDate)
	{
		Assert.isLegal(startDate != null && endDate != null, "dates can not be null");
		Assert.isLegal(startDate.getTime() < endDate.getTime(), "start date must precede end date");

		Session session = getCurrentSession();
		Query query = session.createQuery("select sum(entry.quantity) "
				+ "from CollectionJournalLine entry join CollectionGroup group" + "where group.collectionDate >= ? "
				+ "and group.collectionDate <= ?");
		query.setDate(0, startDate);
		query.setDate(1, endDate);

		BigDecimal sum;
		try {
			sum = (BigDecimal) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			sum = BigDecimal.valueOf(-1);
		}
		return sum;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CollectionJournalLine> findCollections(	Membership member,
														DairyLocation route,
														CollectionSession collectionSession,
														Date startDate,
														Date endDate,
														Boolean isMissing,
														Boolean isRejected,
														Boolean flagged)
	{
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria("CollectionJournalLine");
// .createAlias("collectionJournal", "jrnl");

		if (member != null) {
			criteria.add(Restrictions.eq("validatedMember", member));
		}
		/*
		 * if (isRejected != null) { criteria.add(Restrictions.gt("rejected", isRejected)); }
		 * 
		 * if (isMissing != null) { criteria.add(Restrictions.eq("notRecorded", isMissing)); }
		 * 
		 * if (flagged != null) { criteria.add(Restrictions.eq("flagged", flagged)); }
		 */

		if (route != null || collectionSession != null || startDate != null || endDate != null) {
			criteria = criteria.createCriteria("group");
			if (route != null) {
				criteria.add(Restrictions.eq("collectionCenter", route));
			}

			if (collectionSession != null) {
				criteria.add(Restrictions.eq("session", collectionSession));
			}

			if (startDate != null) {
				criteria.add(Restrictions.ge("collectionDate", startDate));
			}

			if (endDate != null) {
				criteria.add(Restrictions.le("collectionDate", endDate));
			}
		}

		return criteria.list();
	}

}
