package com.agritrace.edairy.desktop.internal.collection.services;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.agritrace.edairy.desktop.collection.services.ICollectionJournalLineRepository;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.services.Transactional;
import com.agritrace.edairy.desktop.internal.common.persistence.RepositoryUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;

@SuppressWarnings("unchecked")
public class MilkCollectionJournalLineRepository extends RepositoryUtil<CollectionJournalLine> implements
		ICollectionJournalLineRepository {

	@Inject
	public MilkCollectionJournalLineRepository(Provider<Session> provider) {
		super(provider);
	}

	@Override
	public List<CollectionJournalLine> all() {
		return getCurrentSession().createCriteria("CollectionJournalLine").list();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.agritrace.edairy.desktop.internal.collection.services.
	 * ICollectionJournalLineRepository
	 * #countByMemberCenterDate(com.agritrace.edairy
	 * .desktop.common.model.dairy.Membership,
	 * com.agritrace.edairy.desktop.common.model.dairy.DairyLocation,
	 * java.util.Date)
	 */
	@Override
	@Transactional
	public long countByMemberCenterDate(final Membership member, final DairyLocation center, final Date date) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		final String queryText = "SELECT count(*) " + "  FROM CollectionJournalLine l "
				+ " WHERE l.validatedMember = :member " + "   AND l.collectionJournal.journalDate = :cal "
				+ "   AND l.collectionJournal.collectionCenter = :center ";

		final Query query = getCurrentSession().createQuery(queryText);
		query.setEntity("member", member);
		query.setEntity("center", center);
		query.setCalendarDate("cal", cal);

		return (Long) query.uniqueResult();
	}

	@Override
	@Transactional
	public List<CollectionGroup> allForDate(final Date date) {
		int year, month, day;

		final Calendar cal = Calendar.getInstance();

		if (date != null) {
			cal.setTime(date);
		} else {
			cal.setTime(new Date());
		}

		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DAY_OF_MONTH);

		final String queryText = // "SELECT grp " +
		"FROM CollectionGroup as grp " + "          where day(grp.journalDate) = :day"
				+ "          and  month(grp.journalDate) = :month" + "          and  year(grp.journalDate) = :year";

		final Query query = getCurrentSession().createQuery(queryText);

		query.setInteger("year", year);
		query.setInteger("month", month + 1);
		query.setInteger("day", day);

		final List<CollectionGroup> results = query.list();

		// debug
		System.err.format("XXXXXX: Day = %d, month = %d, year = %d\n", day, month, year);
		System.err.format("XXXXXX: results count = %d\n", results.size());
		return results;

	}

	@Override
	@Transactional
	public BigDecimal getMilkPrice(final int month, final int year) {
		// TODO: There is no MilkPrice class!
		
		final String queryString = "SELECT m.paymentRate " + "FROM MemberPayment m " + "WHERE m.year = :year "
				+ "  AND m.month = :month ";

		final Query query = getCurrentSession().createQuery(queryString);
		query.setInteger("year", year);
		query.setInteger("month", month);

		Object value = query.uniqueResult();
		if (value == null) {
			value = "0";
		}
		return new BigDecimal(value.toString());
	}

	@Override
	@Transactional
	public List<Membership> getMembersWithDeliveriesFor(final int month, final int year) {
		final String queryString = "SELECT distinct validatedMember "
			+ " FROM CollectionJournalLine l "
			+ " WHERE 1 = 1"
			+ "   AND year(l.collectionJournal.journalDate) = :year "
			+ "   AND month(l.collectionJournal.journalDate) = :month ";

		final Query query = getCurrentSession().createQuery(queryString);
		query.setInteger("year", year);
		query.setInteger("month", month+1);

		return query.list();
	}

	@Override
	@Transactional
	public List<CollectionJournalLine> getPayableDeliveriesForMember(final Membership member, final int month,
			final int year) {
		final String queryString = "FROM CollectionJournalLine l " + "WHERE l.validatedMember = :member "
				+ "  AND l.rejected = False " + "  AND l.flagged = False "
				+ "  AND year(l.collectionJournal.journalDate) = :year "
				+ "  AND month(l.collectionJournal.journalDate) = :month ";

		final Query query = getCurrentSession().createQuery(queryString);
		query.setEntity("member", member);
		query.setInteger("year", year);
		query.setInteger("month", month);

		return query.list();

	}

	@Override
	@Transactional
	public BigDecimal getSumOfPayableDeliveries(final Membership member, final int month, final int year) {
		final String queryString = "SELECT sum(l.quantity) " + "FROM CollectionJournalLine l "
				+ "WHERE l.validatedMember = :member " + "  AND l.rejected = False " + "  AND l.flagged = False "
				+ "  AND year(l.collectionJournal.journalDate) = :year "
				+ "  AND month(l.collectionJournal.journalDate) = :month ";

		final Query query = getCurrentSession().createQuery(queryString);
		query.setEntity("member", member);
		query.setInteger("year", year);
		query.setInteger("month", month);

		Object sum = query.uniqueResult();
		if (sum == null) {
			sum = "0";
		}
		return new BigDecimal(sum.toString());
	}


}
