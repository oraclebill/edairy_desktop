package com.agritrace.edairy.desktop.internal.collection.services;

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
import com.agritrace.edairy.desktop.common.persistence.services.Audit;
import com.agritrace.edairy.desktop.internal.common.persistence.HibernateRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class MilkCollectionJournalLineRepository extends
		HibernateRepository<CollectionJournalLine> implements
		ICollectionJournalLineRepository {
	@Inject
	protected MilkCollectionJournalLineRepository(Provider<Session> sessionProvider, @Audit Provider<Session> auditProvider) {
		super(sessionProvider, auditProvider);
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
}
