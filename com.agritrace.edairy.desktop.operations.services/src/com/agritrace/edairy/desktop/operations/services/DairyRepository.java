package com.agritrace.edairy.desktop.operations.services;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.hibernate.Hibernate;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager;
import com.agritrace.edairy.desktop.common.ui.managers.DairyUtil;

public class DairyRepository implements IDairyRepository {
	
	/**
	 * 
	 */
	private static final String EDAIRY_SITE_DAIRYID = "edairy.site.dairyid";
	
	/**
	 * 
	 */
	private static class DairyRepositoryHolder {
		private static final DairyRepository INSTANCE = new DairyRepository();
	}

	/**
	 * 
	 */
	public static DairyRepository getInstance() {
		return DairyRepositoryHolder.INSTANCE;
	}

	/**
	 * 
	 */
	private static final HibernateRepository<DairyContainer> binRepository = new HibernateRepository<DairyContainer>() {
		@Override
		protected Class<DairyContainer> getClassType() {
			return DairyContainer.class;
		}
	};

	/**
	 * 
	 */
	private static final HibernateRepository<CollectionJournalPage> collectionsRepository = new HibernateRepository<CollectionJournalPage>() {
		@Override
		protected Class<CollectionJournalPage> getClassType() {
			return CollectionJournalPage.class;
		}
	};
	private static final HibernateRepository<Customer> customerRepository = new HibernateRepository<Customer>() {
		@Override
		protected Class<Customer> getClassType() {
			return Customer.class;
		}
	};
	private static final HibernateRepository<Dairy> dairyRepository = new HibernateRepository<Dairy>() {
		@Override
		protected Class<Dairy> getClassType() {
			return Dairy.class;
		}
	};
	private static final HibernateRepository<DeliveryJournal> deliveryRepository = new HibernateRepository<DeliveryJournal>() {
		@Override
		protected Class<DeliveryJournal> getClassType() {
			return DeliveryJournal.class;
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

	private static final HibernateRepository<Route> routeRepository = new HibernateRepository<Route>() {
		@Override
		protected Class<Route> getClassType() {
			return Route.class;
		}
	};

	private static final HibernateRepository<Vehicle> vehicleRepository = new HibernateRepository<Vehicle>() {
		@Override
		protected Class<Vehicle> getClassType() {
			return Vehicle.class;
		}
	};

	private final Dairy localDairy;

	private DairyRepository() {
		Dairy myDairy = dairyRepository.findByKey(1L);
		if (myDairy == null) {
			myDairy = createLocalDairy();
			dairyRepository.saveNew(myDairy);
		}
		localDairy = myDairy;
		initLocalDairy();
	}
	
	/**
	 * Initialize local dairy collections - 
	 */
	private void initLocalDairy() {
		Hibernate.initialize(localDairy);
		final List<EReference> persistentCollections = Arrays.asList(
				DairyPackage.Literals.DAIRY__BRANCH_LOCATIONS,
				DairyPackage.Literals.DAIRY__CUSTOMERS,
				DairyPackage.Literals.DAIRY__DAIRY_BINS,
				DairyPackage.Literals.DAIRY__EMPLOYEES,
				DairyPackage.Literals.DAIRY__ROUTES,
				DairyPackage.Literals.DAIRY__VEHICLES,
				DairyPackage.Literals.DAIRY__SUPPLIERS				
			);
		for (EStructuralFeature feature : persistentCollections) {
			Hibernate.initialize(localDairy.eGet(feature));
		}		
	}

	@Override
	public Dairy getLocalDairy() {
		return localDairy;
	}

	@Override
	public void updateDairy() {
		dairyRepository.update(localDairy);
	}

	public void updateRoute(final Route changedRoute) {
		routeRepository.update(changedRoute);
	}

	public void addRoute(final Route newRoute) {
		localDairy.getRoutes().add(newRoute);
		routeRepository.saveNew(newRoute);
	}

	protected Dairy createLocalDairy() {
		Dairy dairy = DairyFactory.eINSTANCE.createDairy();
		dairy.setLocation(DairyUtil.createLocation(null, null, null));
		// dairy.setCompanyId(Long.decode(System.getProperty(EDAIRY_SITE_DAIRYID,
		// "0")));
		dairy.setCompanyId(1l);
		dairy.setCompanyName("");
		dairy.setDescription("");
		dairy.setPhoneNumber("");
		dairy.setRegistrationNumber("");
		return dairy;
	}

	public List<CollectionJournalPage> allCollectionJournalPages() {
		return collectionsRepository.all();
	}

	@Override
	public List<Customer> allCustomers() {
		return customerRepository.all();
	}

	@Override
	public List<DairyContainer> allDairyContainers() {
		return localDairy.getDairyBins();
	}

	@Override
	public List<DeliveryJournal> allDeliveries() {
		return deliveryRepository.all();
	}

	@Override
	public List<Route> allRoutes() {
		return localDairy.getRoutes();
	}

	@Override
	public List<Vehicle> allVehicles() {
		return localDairy.getVehicles();
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

	@Override
	public Container getFarmContainerById(String canId) {
		return binRepository.findByKey(Long.parseLong(canId));
	}

	@Override
	public CollectionJournalPage getJournalPageById(Long pageId) {
		return collectionsRepository.findByKey(pageId);
	}

	@Override
	public CollectionJournalPage getJournalPageById(String pageId) {
		try {
			return getJournalPageById(Long.parseLong(pageId));
		} catch (final NumberFormatException nfe) {
			return null;
		}
	}

	@Override
	public List<DairyLocation> getLocalDairyLocations() {
		return localDairy.getBranchLocations();
	}

	@Override
	public Membership getMembershipById(Object memberId) {
		return getMembershipById((String) memberId);
	}

	public Membership getMembershipById(String memberIdString) {
		Long memberId = new Long(-1);
		try {
			memberId = Long.parseLong(memberIdString);
		} catch (final NumberFormatException nfe) {
			;
			;
		}
		return memberRepository.findByKey(memberId);
	}

	@Override
	public Dairy reloadLocalDairy() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void save(Object changedItem) {
		dairyRepository.save(changedItem);
	}

	@Override
	public void saveNewJournalPage(CollectionJournalPage newJournal) {
		collectionsRepository.saveNew(newJournal);
	}

	@Override
	public void updateBranchLocation(DairyLocation changedDairyLocation) {
		if(localDairy.getBranchLocations().contains(changedDairyLocation)) {
			;
		}
		else {
			localDairy.getBranchLocations().add(changedDairyLocation);
		}
		PersistenceManager.getDefault().getSession().flush();
	}

	@Override
	public void addBranchLocation(DairyLocation changedDairyLocation) {
		localDairy.getBranchLocations().add(changedDairyLocation);	
		dairyRepository.update(localDairy);
//		PersistenceManager.getDefault().getSession().persist(changedDairyLocation);
//		PersistenceManager.getDefault().getSession().flush();
	}

	@Override
	public void deleteBranchLocation(DairyLocation oldItem) {
		localDairy.getBranchLocations().remove(oldItem);
		PersistenceManager.getDefault().getSession().delete(oldItem);
		PersistenceManager.getDefault().getSession().flush();

	}

}
