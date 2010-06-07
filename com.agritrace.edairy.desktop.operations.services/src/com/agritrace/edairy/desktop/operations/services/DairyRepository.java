package com.agritrace.edairy.desktop.operations.services;

import java.util.List;

import org.hibernate.Session;

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
		protected Class<Dairy> getClassType() {
			return Dairy.class;
		}
	};
	private static final HibernateRepository<Route> routeRepository = new HibernateRepository<Route>() {
		protected Class<Route> getClassType() {
			return Route.class;
		}
	};
	private static final HibernateRepository<DairyContainer> binRepository = new HibernateRepository<DairyContainer>() {
		protected Class<DairyContainer> getClassType() {
			return DairyContainer.class;
		}
	};
	private static final HibernateRepository<Vehicle> vehicleRepository = new HibernateRepository<Vehicle>() {
		protected Class<Vehicle> getClassType() {
			return Vehicle.class;
		}
	};

	private static final HibernateRepository<Employee> employeeRepository = new HibernateRepository<Employee>() {
		protected Class<Employee> getClassType() {
			return Employee.class;
		}
	};

	private static final HibernateRepository<Membership> memberRepository = new HibernateRepository<Membership>() {
		protected Class<Membership> getClassType() {
			return Membership.class;
		}
	};

	public List<DairyContainer> getDairyBins() {
		return binRepository.all();
	}

	public List<Vehicle> getVehicles() {
		return vehicleRepository.all();
	}

	public List<Employee> getEmployees(String string) {
		return employeeRepository.find("From employee where jobfunction='" + string + "'");
	}

	public Membership getMembershipById(String memberId) {
		return memberRepository.findByKey(Long.parseLong(memberId));
	}

	public Container getContainerById(String canId) {
		return binRepository.findByKey(Long.parseLong(canId));
	}

	public Dairy getByName(String name) {
		List<Dairy> list = find("FROM Dairy where name='" + name + "'");
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public List<Dairy> find(String query, Object[] args) {
		return dairyRepository.find(query, args);
	}

	public List<Dairy> find(String rawQuery) {
		return dairyRepository.find(rawQuery);
	}

	public List<Dairy> all() {
		return dairyRepository.all();
	}

	public Dairy findByKey(Long key) {
		return dairyRepository.findByKey(key);
	}

	public void saveNew(Dairy newEntity) {
		newEntity.setCompanyId(null);
		dairyRepository.saveNew(newEntity);
	}

	public void update(Dairy updateableEntity) {
		dairyRepository.update(updateableEntity);
	}

	public void delete(Dairy deletableEntity) {
		dairyRepository.delete(deletableEntity);
	}

	public List<Route> getRoutes() {
		return routeRepository.all();
	}

	public void saveNewRoute(final Route newRoute) {
		routeRepository.saveNew(newRoute);
	}

	public void updateRoute(final Route changedRoute) {
		routeRepository.update(changedRoute);
	}

	public void deleteRoute(final Route object) {
		routeRepository.delete(object);
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
	public List<Dairy> getAllDairies() {
		return dairyRepository.all();
	}

	@Override
	public Dairy reloadLocalDairy() {
		throw new UnsupportedOperationException();
	}

}
