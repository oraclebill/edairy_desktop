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
import com.agritrace.edairy.desktop.internal.common.persistence.HibernateRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class MilkCollectionJournalLineRepository extends
		HibernateRepository<CollectionJournalLine> implements
		ICollectionJournalLineRepository {
	@Inject
	protected MilkCollectionJournalLineRepository(Provider<Session> sessionProvider) {
		super(sessionProvider);
	}

	@Override
	protected Class<CollectionJournalLine> getClassType() {
		return CollectionJournalLine.class;
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
	public long countByMemberCenterDate(final Membership member,
			final DairyLocation center, final Date date) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		SessionRunnable<Long> runnable = new SessionRunnable<Long>() {
			@Override
			public void run(Session session) {
				String queryText = "SELECT count(*) "
						+ "  FROM CollectionJournalLine l "
						+ " WHERE l.validatedMember = :member "
						+ "   AND l.collectionJournal.journalDate = :cal "
						+ "   AND l.collectionJournal.collectionCenter = :center ";

				Query query = session.createQuery(queryText);
				query.setEntity("member", member);
				query.setEntity("center", center);
				query.setCalendarDate("cal", cal);

				setResult((Long) query.uniqueResult());
			}
		};

		runWithTransaction(runnable);
		return runnable.getResult();
	}

	@Override
	public List<CollectionGroup> allForDate(final Date date) {
		SessionRunnable<List<CollectionGroup>> runnable = new SessionRunnable<List<CollectionGroup>>() {
			@SuppressWarnings({ "unchecked" })
			@Override
			public void run(Session session) {
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
				"FROM CollectionGroup as grp "
						+ "          where day(grp.journalDate) = :day"
						+ "          and  month(grp.journalDate) = :month"
						+ "          and  year(grp.journalDate) = :year";

				Query query = session.createQuery(queryText);

				query.setInteger("year", year);
				query.setInteger("month", month + 1);
				query.setInteger("day", day);

				List<CollectionGroup> results = query.list();
				setResult(results);

				// debug
				System.err.format("XXXXXX: Day = %d, month = %d, year = %d\n",
						day, month, year);
				System.err.format("XXXXXX: results count = %d\n",
						results.size());

			}
		};

		runWithTransaction(runnable);
		return runnable.getResult();
	}


//	@Override
//	public List<CollectionJournalLine> getPayableDeliveries(
//			final Membership member, final int month, final int year) {
//		SessionRunnable<List<CollectionJournalLine>> runnable = new SessionRunnable<List<CollectionJournalLine>>() {
//			@Override
//			public void run(Session session) {
//				String queryString = "FROM CollectionJournalLine l "
//						+ "WHERE l.validatedMember = :member "
//						+ "  AND l.rejected = False "
//						+ "  AND l.flagged = False "
//						+ "  AND year(l.collectionJournal.journalDate) = :year "
//						+ "  AND month(l.collectionJournal.journalDate) = :month ";
//				
//				Query query = session.createQuery(queryString);
//				query.setEntity("member", member);
//				query.setInteger("year", year);
//				query.setInteger("month", month);
//				
//				setResult(query.list());
//			}
//		};
//
//		runWithTransaction(runnable);
//		return runnable.getResult();
//	}
	
	@Override
	public BigDecimal getMilkPrice(final int month, final int year) {
		SessionRunnable<BigDecimal> runnable = new SessionRunnable<BigDecimal>() {
			@Override
			public void run(Session session) {
				String queryString = "SELECT value " + "FROM MilkPrice m "
						+ "WHERE m.year = :year " + "  AND m.month = :month ";

				Query query = session.createQuery(queryString);
				query.setInteger("year", year);
				query.setInteger("month", month);

				setResult(new BigDecimal(query.uniqueResult().toString()));
			}
		};

		runWithTransaction(runnable);
		return runnable.getResult();
	}

	@Override
	public List<Membership> getMembersWithDeliveriesFor(final int month,
			final int year) {
		SessionRunnable<List<Membership>> runnable = new SessionRunnable<List<Membership>>() {
			@Override
			public void run(Session session) {
				String queryString = "SELECT validatedMember "
						+ "FROM CollectionJournalLine l "
						+ "WHERE l.validatedMember = :member "
						+ "  AND l.rejected = False "
						+ "  AND l.flagged = False "
						+ "  AND year(l.collectionJournal.journalDate) = :year "
						+ "  AND month(l.collectionJournal.journalDate) = :month ";

				Query query = session.createQuery(queryString);
				query.setInteger("year", year);
				query.setInteger("month", month);

				setResult(query.list());
			}
		};

		runWithTransaction(runnable);
		return runnable.getResult();
	}

	@Override
	public List<CollectionJournalLine> getPayableDeliveriesForMember(
			final Membership member, final int month, final int year) {
		SessionRunnable<List<CollectionJournalLine>> runnable = new SessionRunnable<List<CollectionJournalLine>>() {
			@Override
			public void run(Session session) {
				String queryString = "FROM CollectionJournalLine l "
						+ "WHERE l.validatedMember = :member "
						+ "  AND l.rejected = False "
						+ "  AND l.flagged = False "
						+ "  AND year(l.collectionJournal.journalDate) = :year "
						+ "  AND month(l.collectionJournal.journalDate) = :month ";

				Query query = session.createQuery(queryString);
				query.setEntity("member", member);
				query.setInteger("year", year);
				query.setInteger("month", month);

				setResult(query.list());
			}
		};

		runWithTransaction(runnable);
		return runnable.getResult();
	}

	@Override
	public BigDecimal getSumOfPayableDeliveries(final Membership member,
			final int month, final int year) {
		SessionRunnable<BigDecimal> runnable = new SessionRunnable<BigDecimal>() {
			@Override
			public void run(Session session) {
				String queryString = "SELECT sum(l.quantity) "
						+ "FROM CollectionJournalLine l "
						+ "WHERE l.validatedMember = :member "
						+ "  AND l.rejected = False "
						+ "  AND l.flagged = False "
						+ "  AND year(l.collectionJournal.journalDate) = :year "
						+ "  AND month(l.collectionJournal.journalDate) = :month ";

				Query query = session.createQuery(queryString);
				query.setEntity("member", member);
				query.setInteger("year", year);
				query.setInteger("month", month);

				setResult(new BigDecimal(query.uniqueResult().toString()));
			}
		};

		runWithTransaction(runnable);
		return (BigDecimal) runnable.getResult();
	}

}
