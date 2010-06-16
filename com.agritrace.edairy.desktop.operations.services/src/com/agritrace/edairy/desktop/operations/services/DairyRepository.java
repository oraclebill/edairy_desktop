package com.agritrace.edairy.desktop.operations.services;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.ui.managers.DairyUtil;

public class DairyRepository implements IDairyRepository {

	private static final String EDAIRY_SITE_DAIRYID = "edairy.site.dairyid";

	private static final HibernateRepository<Dairy> dairyRepository = new HibernateRepository<Dairy>() {
		@Override
		protected Class<Dairy> getClassType() {
			return Dairy.class;
		}
	};
	private static final HibernateRepository<Route> routeRepository = new HibernateRepository<Route>() {
		@Override
		protected Class<Route> getClassType() {
			return Route.class;
		}
	};
	private static final HibernateRepository<DairyContainer> binRepository = new HibernateRepository<DairyContainer>() {
		@Override
		protected Class<DairyContainer> getClassType() {
			return DairyContainer.class;
		}
	};
	private static final HibernateRepository<Vehicle> vehicleRepository = new HibernateRepository<Vehicle>() {
		@Override
		protected Class<Vehicle> getClassType() {
			return Vehicle.class;
		}
	};

	private static final HibernateRepository<Employee> employeeRepository = new HibernateRepository<Employee>() {
		@Override
		protected Class<Employee> getClassType() {
			return Employee.class;
		}
	};

	private static final HibernateRepository<Membership> memberRepository = new HibernateRepository<Membership>() {
		@Override
		protected Class<Membership> getClassType() {
			return Membership.class;
		}
	};
	
	private static final HibernateRepository<CollectionJournalPage> collectionsRepository = new HibernateRepository<CollectionJournalPage>() {
		@Override
		protected Class<CollectionJournalPage> getClassType() {
			return CollectionJournalPage.class;
		}
	};

	@Override
	public List<Dairy> allDairies() {
		return dairyRepository.all();
	}

	@Override
	public List<DairyContainer> allDairyContainers() {
		return binRepository.all();
	}

	@Override
	public List<Route> allRoutes() {
		return routeRepository.all();
	}

	@Override
	public List<Vehicle> allVehicles() {
		return vehicleRepository.all();
	}

	public void delete(Dairy deletableEntity) {
		dairyRepository.delete(deletableEntity);
	}

	public void deleteRoute(final Route object) {
		routeRepository.delete(object);
	}

	@Override
	public List<Employee> employeesByPosition(String string) {
		return employeeRepository.find("FROM Employee where jobfunction='" + string + "'");
	}

	public List<Dairy> find(String rawQuery) {
		return dairyRepository.find(rawQuery);
	}

	public List<Dairy> find(String query, Object[] args) {
		return dairyRepository.find(query, args);
	}

	@Override
	public Dairy getDairyById(Long key) {
		return dairyRepository.findByKey(key);
	}

	public Dairy getDairyByName(String name) {
		List<Dairy> list = find("FROM Dairy where name='" + name + "'");
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public List<CollectionJournalPage> allCollectionJournalPages() {
		return collectionsRepository.all();
	}

	@Override
	public Container getFarmContainerById(String canId) {
		return binRepository.findByKey(Long.parseLong(canId));
	}

	@Override
	public CollectionJournalPage getJournalPageById(String pageId) {
		return collectionsRepository.findByKey(Long.parseLong(pageId));
	}

	@Override
	public Dairy getLocalDairy() {
		Dairy local = null;
		
		// find local
		List<Dairy> dairies = dairyRepository.all();
		if (dairies.size() > 0) {
			if (dairies.size() > 1)
				throw new IllegalStateException("multiple dairies unsupported.");
			return dairies.get(0);
		}

		// create local
		local = DairyFactory.eINSTANCE.createDairy();
		local.setLocation(DairyUtil.createLocation(null, null, null));
		long id = 0;
		try {
			String dairyId = System.getProperty(EDAIRY_SITE_DAIRYID);
			if (dairyId != null) {
				id = new Long(dairyId).longValue();
				local.setCompanyId(id);
			}
		} catch (Exception e) {
		}
		return local;
	}

	@Override
	public Membership getMembershipById(Object memberId) {
		// TODO Auto-generated method stub
		return getMembershipById((String)memberId);
	}

	public Membership getMembershipById(String memberId) {
		return memberRepository.findByKey(Long.parseLong(memberId));
	}

	@Override
	public Dairy reloadLocalDairy() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void saveNewDairy(Dairy newEntity) {
		newEntity.setCompanyId(null);
		dairyRepository.saveNew(newEntity);
	}

	@Override
	public void saveNewJournalPage(CollectionJournalPage newJournal) {		
		collectionsRepository.saveNew(newJournal);
	}

	public void saveNewRoute(final Route newRoute) {
		routeRepository.saveNew(newRoute);
	}

	@Override
	public void updateDairy(Dairy updateableEntity) {
		dairyRepository.update(updateableEntity);
	}

	public void updateRoute(final Route changedRoute) {
		routeRepository.update(changedRoute);
	}

	@Override
	public void save(Object changedItem) {
		dairyRepository.save(changedItem);		
	}


}
