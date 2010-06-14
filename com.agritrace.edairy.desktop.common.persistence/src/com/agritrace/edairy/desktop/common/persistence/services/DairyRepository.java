package com.agritrace.edairy.desktop.common.persistence.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.tracking.Container;

public class DairyRepository {

	private final PersistenceManager persistenceMgr = PersistenceManager
			.getDefault();

	private Session session;

	private void setupSession() {
		session = persistenceMgr.getSession();
		if (null == session || !session.isOpen()) {
			session = persistenceMgr.getDataStore().getSessionFactory()
					.openSession();
		}

		if (session.isDirty())
			session.flush();
	}

	public List<?> runQuery(String queryString) {
		setupSession();
		return (List<?>)session.createQuery(queryString).list();
	}

	public List<Route> getRoutes() {
		return  (List<Route>) runQuery("FROM Route");		
	}

	public List<DairyContainer> getDairyBins() {				
		return (List<DairyContainer>) runQuery("FROM DairyContainer");
	}

	public List<Vehicle> getVehicles() {
		return (List<Vehicle>) runQuery("FROM Vehicle");
	}

	public List<Employee> getEmployees(String type) {
		return (List<Employee>) runQuery("FROM Employee where jobfunc16_6_='" + type +  "'");
	}

	public void addCollectionJournal(CollectionJournalPage newJournal) {
		setupSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist("CollectionJournal", newJournal);
			tx.commit();
		}
		catch(Exception e) {
			tx.rollback();
		}
		finally {

		}
		
		
	}

	public Membership getMembershipById(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Container findContainer(String canId) {
		// TODO Auto-generated method stub
		return null;
	}

}
