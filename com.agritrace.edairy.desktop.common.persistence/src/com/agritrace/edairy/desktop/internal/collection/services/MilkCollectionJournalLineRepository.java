package com.agritrace.edairy.desktop.internal.collection.services;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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
	public int countByMemberCenterDate(final Membership member,
			final DairyLocation center, final Date date) {
		SessionRunnable<Integer> runnable = new SessionRunnable<Integer>() {
			@Override
			public void run(Session session) {
				Criteria crit = session
						.createCriteria(CollectionJournalLine.class);
				crit.add(Restrictions.eq("validatedMember", member));

				Criteria subcrit = crit.createCriteria("collectionJournal");
				subcrit.add(Restrictions.eq("collectionCenter", center));

				Calendar cld = Calendar.getInstance();
				cld.setTime(date);
				cld = new GregorianCalendar(cld.get(Calendar.YEAR),
						cld.get(Calendar.MONTH),
						cld.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
				subcrit.add(Restrictions.ge("journalDate", cld.getTime()));
				cld.add(Calendar.DAY_OF_MONTH, 1);
				subcrit.add(Restrictions.lt("journalDate", cld.getTime()));

				crit.setProjection(Projections.rowCount());
				setResult((Integer) crit.uniqueResult());
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
				}
				else { 
					cal.setTime(new Date());
				}				
				
				year = cal.get(Calendar.YEAR);
				month = cal.get(Calendar.MONTH);
				day = cal.get(Calendar.DAY_OF_MONTH);

				String queryText = //"SELECT grp " +
						"FROM CollectionGroup as grp "
						+ "          where day(grp.journalDate) = :day"
						+ "          and  month(grp.journalDate) = :month"
						+ "          and  year(grp.journalDate) = :year";

				Query query = session.createQuery(queryText);

				query.setInteger("year", year);
				query.setInteger("month", month+1);
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
	
					
					Object queryResult = query.uniqueResult();
					if(queryResult != null){
						setResult(new BigDecimal(queryResult.toString()));
					}
				
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
				String queryString = "SELECT distinct validatedMember "
						+ "FROM CollectionJournalLine l "
						+ "WHERE l.rejected = False "
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
