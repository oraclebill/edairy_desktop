package com.agritrace.edairy.desktop.internal.collection.services;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.hibernate.Query;

import com.agritrace.edairy.desktop.collection.services.ICollectionJournalLineRepository;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.internal.common.persistence.RepositoryUtil;
import com.google.inject.Inject;

@SuppressWarnings("unchecked")
public class MilkCollectionJournalLineRepository extends RepositoryUtil<CollectionJournalLine> implements
		ICollectionJournalLineRepository {

	@Inject
	public MilkCollectionJournalLineRepository(HbDataStore store) {
		super(store);
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
	public long countByMemberCenterDate(final Membership member, final DairyLocation center, final Date date) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		String queryText = "SELECT count(*) " + "  FROM CollectionJournalLine l "
				+ " WHERE l.validatedMember = :member " + "   AND l.collectionJournal.journalDate = :cal "
				+ "   AND l.collectionJournal.collectionCenter = :center ";

		Query query = getCurrentSession().createQuery(queryText);
		query.setEntity("member", member);
		query.setEntity("center", center);
		query.setCalendarDate("cal", cal);

		return ((Long) query.uniqueResult());
	}

	@Override
	public List<CollectionGroup> allForDate(final Date date) {
		int year, month, day;

		Calendar cal = Calendar.getInstance();

		if (date != null) {
			cal.setTime(date);
		} else {
			cal.setTime(new Date());
		}

		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DAY_OF_MONTH);

		String queryText = // "SELECT grp " +
		"FROM CollectionGroup as grp " + "          where day(grp.journalDate) = :day"
				+ "          and  month(grp.journalDate) = :month" + "          and  year(grp.journalDate) = :year";

		Query query = getCurrentSession().createQuery(queryText);

		query.setInteger("year", year);
		query.setInteger("month", month + 1);
		query.setInteger("day", day);

		List<CollectionGroup> results = query.list();

		// debug
		System.err.format("XXXXXX: Day = %d, month = %d, year = %d\n", day, month, year);
		System.err.format("XXXXXX: results count = %d\n", results.size());
		return (results);

	}

	@Override
	public BigDecimal getMilkPrice(final int month, final int year) {
		String queryString = "SELECT value " + "FROM MilkPrice m " + "WHERE m.year = :year "
				+ "  AND m.month = :month ";

		Query query = getCurrentSession().createQuery(queryString);
		query.setInteger("year", year);
		query.setInteger("month", month);

		return (new BigDecimal(query.uniqueResult().toString()));
	}

	@Override
	public List<Membership> getMembersWithDeliveriesFor(final int month, final int year) {
		String queryString = "SELECT distinct validatedMember " + "FROM CollectionJournalLine l "
				+ "WHERE l.rejected = False " + "  AND l.flagged = False "
				+ "  AND year(l.collectionJournal.journalDate) = :year "
				+ "  AND month(l.collectionJournal.journalDate) = :month ";

		Query query = getCurrentSession().createQuery(queryString);
		query.setInteger("year", year);
		query.setInteger("month", month);

		return (query.list());
	}

	@Override
	public List<CollectionJournalLine> getPayableDeliveriesForMember(final Membership member, final int month,
			final int year) {
		String queryString = "FROM CollectionJournalLine l " + "WHERE l.validatedMember = :member "
				+ "  AND l.rejected = False " + "  AND l.flagged = False "
				+ "  AND year(l.collectionJournal.journalDate) = :year "
				+ "  AND month(l.collectionJournal.journalDate) = :month ";

		Query query = getCurrentSession().createQuery(queryString);
		query.setEntity("member", member);
		query.setInteger("year", year);
		query.setInteger("month", month);

		return (query.list());

	}

	@Override
	public BigDecimal getSumOfPayableDeliveries(final Membership member, final int month, final int year) {
		String queryString = "SELECT sum(l.quantity) " + "FROM CollectionJournalLine l "
				+ "WHERE l.validatedMember = :member " + "  AND l.rejected = False " + "  AND l.flagged = False "
				+ "  AND year(l.collectionJournal.journalDate) = :year "
				+ "  AND month(l.collectionJournal.journalDate) = :month ";

		Query query = getCurrentSession().createQuery(queryString);
		query.setEntity("member", member);
		query.setInteger("year", year);
		query.setInteger("month", month);

		return (new BigDecimal(query.uniqueResult().toString()));
	}


}
