package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;

public class MilkCollectionJournalLineRepository extends HibernateRepository<CollectionJournalLine> implements
		IRepository<CollectionJournalLine> {

	@Override
	protected Class<CollectionJournalLine> getClassType() {
		return CollectionJournalLine.class;
	}

	public int countByMemberRouteDate(final Membership member, final Route route, final Date date) {
		SessionRunnable<Integer> runnable = new SessionRunnable<Integer>() {
			@Override
			public void run(Session session) {
				Criteria crit = session.createCriteria(CollectionJournalLine.class);
				crit.add(Restrictions.eq("validatedMember", member));
				
				Criteria subcrit = crit.createCriteria("collectionJournal");
				subcrit.add(Restrictions.eq("route", route));
				
				Calendar cld = Calendar.getInstance();
				cld.setTime(date);
				cld = new GregorianCalendar(cld.get(Calendar.YEAR), cld.get(Calendar.MONTH),
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
}
