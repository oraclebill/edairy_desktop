package com.agritrace.edairy.desktop.internal.persistence;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.ICollectionJournalLineRepository;
import com.agritrace.edairy.desktop.common.persistence.services.Transactional;
import com.agritrace.edairy.desktop.internal.common.persistence.Constants;
import com.agritrace.edairy.desktop.internal.common.persistence.RepositoryUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;

@SuppressWarnings("unchecked")
public class MilkCollectionJournalLineRepository extends
		RepositoryUtil<CollectionJournalLine> implements
		ICollectionJournalLineRepository {

	@Inject
	public MilkCollectionJournalLineRepository(Provider<Session> provider) {
		super(provider);
	}

	@Override
	public List<CollectionJournalLine> all() {
		return getCurrentSession().createCriteria("CollectionJournalLine")
				.list();
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
	public long countByMemberCenterDate(final Membership member,
			final DairyLocation center, final Date date) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		final String queryText = "SELECT count(*) "
				+ "  FROM CollectionJournalLine l "
				+ " WHERE l.validatedMember = :member "
				+ "   AND l.collectionJournal.journalDate = :cal "
				+ "   AND l.collectionJournal.collectionCenter = :center ";

		final Query query = getCurrentSession().createQuery(queryText);
		query.setEntity("member", member);
		query.setEntity("center", center);
		query.setCalendarDate("cal", cal);

		return (Long) query.uniqueResult();
	}

	@Override @Transactional
	public List<Object[]> collectionsSummary(Date startDate, Date endDate) {
		final String sqlString = "select journaldate as date, dairylocation.code as route, collectionsession.code as session, sum(quantity) as sum  "
				+ "  from collectiongroup join collectionjournalline on collectionjournalline_collectionjournal_e_id = journalid "
				+ "    join collectionsession on collectionsession.id = collectionsession_session_e_id "
				+ "    join dairylocation on dairylocation.id = dairylocation_collectioncenter_id "
				+ "  where journaldate between ? and ? "
				+ " group by 2,3 "
				+ " order by 1,2,3;";
		return getCurrentSession().createSQLQuery(sqlString)
				.addScalar("date", Hibernate.DATE)
				.addScalar("route", Hibernate.STRING)
				.addScalar("session", Hibernate.STRING)
				.addScalar("sum", Hibernate.DOUBLE)
				.setDate(0, startDate)
				.setDate(1, endDate)
				.list();
	}

//	@Override
	@Transactional
	public List<CollectionGroup> allForDate(final Date date) {
		int year, month, day;

		final Calendar cal = Calendar.getInstance();

		if (date != null) {
			cal.setTime(date);
		} else {
			cal.setTime(new Date());
		}

		Calendar startDate = (Calendar) cal.clone(), endDate = (Calendar) cal
				.clone();

		int[] timeFields = new int[] { Calendar.HOUR, Calendar.MINUTE,
				Calendar.SECOND, Calendar.MILLISECOND };
		for (int field : timeFields) {
			startDate.set(field, startDate.getActualMinimum(field));
			endDate.set(field, startDate.getActualMaximum(field));
		}
		return findJournalsInRange(startDate, endDate);
	}

	public List<CollectionGroup> findJournalsInRange(Calendar startDate,
			Calendar endDate) {

		// year = cal.get(Calendar.YEAR);
		// month = cal.get(Calendar.MONTH);
		// day = cal.get(Calendar.DAY_OF_MONTH);
		//
		// final String queryText = // "SELECT grp " +
		// "FROM CollectionGroup as grp "
		// + "          where day(grp.journalDate) = :day"
		// + "          and  month(grp.journalDate) = :month"
		// + "          and  year(grp.journalDate) = :year";
		//
		// // final Query query = getCurrentSession().createQuery(queryText);
		// // query.setInteger("year", year);
		// // query.setInteger("month", month + 1);
		// // query.setInteger("day", day);

		final Criteria query = getCurrentSession().createCriteria(
				"CollectionGroup");
		if (startDate != null) {
			query.add(Restrictions.ge("journalDate", startDate.getTime()));
		}
		if (endDate != null) {
			query.add(Restrictions.le("journalDate", endDate.getTime()));
		}
		final List<CollectionGroup> results = query.list();

		// debug
		System.err.format("XXXXXX: Start: %s, End: %s", startDate, endDate);
		System.err.format("XXXXXX: results count = %d\n", results.size());
		return results;

	}

	@Override
	@Transactional
	public BigDecimal getMilkPrice(final int month, final int year) {
		// TODO: There is no MilkPrice class!

		final String queryString = "SELECT m.paymentRate "
				+ "FROM MemberPayment m " + "WHERE m.year = :year "
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
		final String queryString = "SELECT DISTINCT l.validatedMember "
				+ " FROM CollectionJournalLine l " + " WHERE 1 = 1"
				+ "   AND year(l.collectionJournal.journalDate) = :year "
				+ "   AND month(l.collectionJournal.journalDate) = :month ";

		final Query query = getCurrentSession().createQuery(queryString);
		query.setInteger("year", year);
		query.setInteger("month", month + 1);

		return query.list();
	}

	@Override
	@Transactional
	public List<Membership> getMembersWithFlaggedDeliveriesFor(final int month, final int year) {
		final String queryString = "SELECT DISTINCT validatedMember "
				+ " FROM CollectionJournalLine l " + " WHERE 1 = 1"
				+ "   AND year(l.collectionJournal.journalDate) = :year "
				+ "   AND month(l.collectionJournal.journalDate) = :month"
				+ "   AND l.flagged = TRUE";

		final Query query = getCurrentSession().createQuery(queryString);
		query.setInteger("year", year);
		query.setInteger("month", month + 1);

		return query.list();
	}

	@Override
	@Transactional
	public List<CollectionJournalLine> getPayableDeliveriesForMember(final Membership member,
			final int month, final int year) {
		final String queryString = "FROM CollectionJournalLine l "
				+ "WHERE l.validatedMember = :member "
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
	public BigDecimal getSumOfPayableDeliveries(final Membership member,
			final int month, final int year) {
		final String queryString = "SELECT sum(l.quantity) "
				+ "FROM CollectionJournalLine l "
				+ "WHERE l.validatedMember = :member "
				+ "  AND l.rejected = False " + "  AND l.flagged = False "
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

	@Override
	public Map<Membership, BigDecimal> getMapOfPayableDeliveries(int paymentMonth, int paymentYear) {
		final String queryString = "SELECT l.validatedMember, sum(l.quantity) "
			+ "FROM CollectionJournalLine l "
			+ "WHERE 1 = 1 "
			+ "  AND l.rejected = False " + "  AND l.flagged = False "
			+ "  AND year(l.collectionJournal.journalDate) = :year "
			+ "  AND month(l.collectionJournal.journalDate) = :month "
			+ "  GROUP BY l.validatedMember";

		final Query query = getCurrentSession().createQuery(queryString);
		query.setInteger("year", paymentYear);
		query.setInteger("month", paymentMonth);
	
		Map<Membership, BigDecimal> result = new HashMap<Membership, BigDecimal>();
		List<Object[]> sums = query.list();
		
		for (Object[] array: sums) {
			result.put((Membership) array[0], array[1] == null ?
					Constants.BIGZERO : new BigDecimal(array[1].toString()));
		}
		
		return result;
	}
}
