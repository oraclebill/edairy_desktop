package com.agritrace.edairy.desktop.internal.operations.services;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.riena.core.Log4r;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MilkPrice;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager;
import com.agritrace.edairy.desktop.internal.common.persistence.Activator;
import com.agritrace.edairy.desktop.internal.common.persistence.HibernateRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class DairyRepository implements IDairyRepository, IMemberRepository {

	public static class RepositoryException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public RepositoryException() {
			super();
			// TODO Auto-generated constructor stub
		}

		public RepositoryException(String message, Throwable cause) {
			super(message, cause);
			// TODO Auto-generated constructor stub
		}

		public RepositoryException(String message) {
			super(message);
			// TODO Auto-generated constructor stub
		}

		public RepositoryException(Throwable cause) {
			super(cause);
			// TODO Auto-generated constructor stub
		}

	}

	/**
	 * 
	 */
	public static final String EDAIRY_SITE_DAIRYID = "edairy.site.dairyid";

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
	 * @author bjones
	 * 
	 */
	private final static class DairyRepoInternal extends
			HibernateRepository<Dairy> {
		@Override
		protected Class<Dairy> getClassType() {
			return Dairy.class;
		}

		class MemberByNumber extends SessionRunnable<Membership> {
			String memberNumber;

			public MemberByNumber(String number) {
				memberNumber = number;
			}

			@Override
			public void run(Session session) {
				System.err.println("finding member: " + memberNumber);
				setResult((Membership) session
						.createCriteria("Membership")
						.add(Restrictions.eq(
								DairyPackage.Literals.MEMBERSHIP__MEMBER_NUMBER
										.getName(), memberNumber))
						.uniqueResult());
			}
		}

		class AccountForMemberNo extends SessionRunnable<Account> {
			String memberNumber;

			public AccountForMemberNo(String number) {
				memberNumber = number;
			}

			@Override
			public void run(Session session) {
				System.err
						.println("AccountForMemberNo: finding member account: "
								+ memberNumber);
				Criteria query = session.createCriteria("Membership").add(
						Restrictions.eq(
								DairyPackage.Literals.MEMBERSHIP__MEMBER_NUMBER
										.getName(), memberNumber));
				final Membership member = (Membership) query.uniqueResult();
				final Account account = member != null ? member.getAccount()
						: null;
				setResult(account);
				System.err
						.println("AccountForMemberNo: returning : " + account);
			}
		}

		class MembersForRoute extends SessionRunnable<Object> {
			Route route;

			public MembersForRoute(Route route) {
				this.route = route;
			}

			@Override
			public void run(Session session) {
				@SuppressWarnings("unchecked")
				List<Membership> result = session.createCriteria("Membership")
						.add(Restrictions.eq("defaultRoute", route)).list();
				setResult(result);
			}
		}

		class SkinnyAccountsQuery extends SessionRunnable<List<Account>> {

			public SkinnyAccountsQuery() {
			}

			@Override
			public void run(Session session) {
				Criteria criteria = session.createCriteria("Account");
				criteria.setFetchMode("transactions", FetchMode.SELECT);

				@SuppressWarnings("unchecked")
				List<Account> result = criteria.list();
				setResult(result);
			}
		}

		public List<Membership> membersForRoute(Route defaultRoute) {
			MembersForRoute query = new MembersForRoute(defaultRoute);
			runWithTransaction(query);

			@SuppressWarnings("unchecked")
			List<Membership> result = (List<Membership>) query.getResult();
			return result;
		}

		public Membership memberByNumber(String memberNumber) {
			MemberByNumber query = new MemberByNumber(memberNumber);
			run(query);
			return query.getResult();
		}

		public Account primaryAccountForMemberNo(String memberNo) {
			AccountForMemberNo query = new AccountForMemberNo(memberNo);
			run(query);
			return query.getResult();
		}

		public List<Account> allAccounts() {
			SkinnyAccountsQuery query = new SkinnyAccountsQuery();
			run(query);
			return query.getResult();
		}
	};

	private static final DairyRepoInternal dairyRepository = new DairyRepoInternal();

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
				DairyPackage.Literals.DAIRY__SUPPLIERS,
				ModelPackage.Literals.CONTACTABLE__CONTACT_METHODS);
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
		dairyRepository.save(changedRoute);
	}

	@Override
	public void addRoute(final Route newRoute) {
		localDairy.getRoutes().add(newRoute);
		dairyRepository.save(localDairy);
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

	public List<CollectionGroup> allCollectionGroups() {
		// return collectionsRepository.getMemberships();
		return localDairy.getCollectionJournals();
	}

	@Override
	public List<Customer> allCustomers() {
		return getLocalDairy().getCustomers();
	}

	@Override
	public List<DairyContainer> allDairyContainers() {
		return localDairy.getDairyBins();
	}

	@Override
	public List<DeliveryJournal> allDeliveries() {
		// return deliveryRepository.getMemberships();
		return localDairy.getDeliveryJournals();
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

	@Override
	public void deleteRoute(final Route object) {
		if (localDairy.getRoutes().remove(object)) {
			PersistenceManager.getDefault().getSession().delete(object);
			PersistenceManager.getDefault().getSession().flush();
			save(localDairy);

		} else {
			throw new RepositoryException("Transport Route not found!");
		}
	}

	@Override
	public List<Employee> employeesByPosition(String string) {
		// return employeeRepository.find("FROM Employee where jobfunction='" +
		// string + "'");
		List<Employee> found = new LinkedList<Employee>();
		for (Employee employee : localDairy.getEmployees()) {
			String job = employee.getJobFunction();
			if (job != null && job.equals(string)) {
				found.add(employee);
			}
		}
		return found;
	}

	// public List<Dairy> find(String rawQuery) {
	// return dairyRepository.find(rawQuery);
	// }
	//
	// public List<Dairy> find(String query, Object[] args) {
	// return dairyRepository.find(query, args);
	// }

	@Override
	public Dairy getDairyById(Long key) {
		return dairyRepository.findByKey(key);
	}

	@Override
	public Container getFarmContainerById(String canId) {
		// return binRepository.findByKey(Long.parseLong(canId));
		Container found = null;
		for (Container bin : localDairy.getDairyBins()) {
			if (bin.getTrackingNumber() != null
					&& bin.getTrackingNumber().equals(canId)) {
				found = bin;
				break;
			}
		}
		return found;
	}

	@Override
	public CollectionGroup getJournalPageById(Long pageId) {
		return getJournalPageById(pageId.toString());
	}

	@Override
	public CollectionGroup getJournalPageById(String pageId) {
		CollectionGroup found = null;
		for (CollectionGroup page : localDairy.getCollectionJournals()) {
			if (page.getReferenceNumber().equals(pageId)) {
				found = page;
				break;
			}
		}
		return found;
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
		long start = System.currentTimeMillis();
		try {
			Membership found = null;
			for (Membership member : localDairy.getMemberships()) {
				if (member.getMemberNumber().equals(memberIdString)) {
					found = member;
					break;
				}
			}
			return found;
		} finally {
			log(LogService.LOG_DEBUG, "getMembershipById: query time: "
					+ (System.currentTimeMillis() - start));
		}
	}

	@Override
	public void delete(Membership member) {
		// member.setStatus(MembershipStatus.DELETED);
		// dairyRepository.save(member);
		if (localDairy.getMemberships().remove(member)) {
			save();
		} else {
			throw new RepositoryException("Member not in memberlist");
		}
	}

	@Override
	public List<Membership> all() {
		return localDairy.getMemberships();
	}

	public List<Account> allAccounts() {
		return dairyRepository.allAccounts();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Farm> getMemberFarms() {
		return PersistenceManager.getDefault().getSession()
				.createCriteria(Farm.class).list();
	}

	@Override
	public void saveNew(Membership newEntity) throws AlreadyExistsException {
		if (newEntity.getMemberNumber() == null
				|| newEntity.getMemberNumber().trim().length() == 0) {
			int size = localDairy.getMemberships().size();
			long count = localDairy.getVersion();
			newEntity.setMemberNumber("A" + count + "" + size);
			// throw new RepositoryException("Member number cannot be null");
		}
		if (newEntity.getAccount() == null) {
			Account memberAccount = AccountFactory.eINSTANCE.createAccount();
			memberAccount.setMember(newEntity);
			memberAccount.setAccountNumber("V" + newEntity.getMemberNumber());
		}
		if (!localDairy.getMemberships().contains(newEntity)) {
			localDairy.getMemberships().add(newEntity);
		}
		save();
	}

	@Override
	public Collection<Membership> getMembersForRoute(Route theRoute) {
		return dairyRepository.membersForRoute(theRoute);
	}

	@Override
	public void update(Membership member) {
		save(member);
	}

	@Override
	public Dairy reloadLocalDairy() {
		throw new UnsupportedOperationException();
	}

	public void save() {
		dairyRepository.save(localDairy);
	}

	@Override
	public void save(Object changedItem) {
		dairyRepository.save(changedItem);
	}

	@Override
	public void saveNewJournalPage(CollectionGroup newJournal) {
		// collectionsRepository.saveNew(newJournal);
		localDairy.getCollectionJournals().add(newJournal);
		save();
	}

	@Override
	public void updateBranchLocation(DairyLocation changedDairyLocation) {
		if (localDairy.getBranchLocations().contains(changedDairyLocation)) {
			;
		} else {
			localDairy.getBranchLocations().add(changedDairyLocation);
		}
		PersistenceManager.getDefault().getSession().flush();
	}

	@Override
	public void addBranchLocation(DairyLocation changedDairyLocation) {
		localDairy.getBranchLocations().add(changedDairyLocation);
		dairyRepository.update(localDairy);
		// PersistenceManager.getDefault().getSession().persist(changedDairyLocation);
		// PersistenceManager.getDefault().getSession().flush();
	}

	@Override
	public void deleteBranchLocation(DairyLocation oldItem) {
		localDairy.getBranchLocations().remove(oldItem);
		PersistenceManager.getDefault().getSession().delete(oldItem);
		PersistenceManager.getDefault().getSession().flush();

	}

	@Override
	public MilkPrice getCurrentMilkPrice() {
		Session session = PersistenceManager.getDefault().getSession();
		MilkPrice currentPrice = (MilkPrice) session
				.createCriteria("MilkPrice").addOrder(Order.desc("year"))
				.addOrder(Order.desc("month")).setFetchSize(1).setMaxResults(1)
				.uniqueResult();
		return currentPrice;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<MilkPrice> getMilkPrices(Date startDate, Date endDate) {
		Session session = PersistenceManager.getDefault().getSession();
		return session.createCriteria("MilkPrice")
				.addOrder(Order.desc("year"))
				.addOrder(Order.desc("month"))
				.add(Restrictions.ge("year", startDate.getYear()+1900))
				.add(Restrictions.ge("month", startDate.getMonth()))
				.add(Restrictions.le("year", endDate.getYear()+1900))
				.add(Restrictions.le("month", endDate.getMonth()))				
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DeliveryJournal> getDeliveryJournals(Date minDate,
			Date maxDate, Route route, Customer customer) {
		Session session = PersistenceManager.getDefault().getSession();
		Criteria djCriteria = session.createCriteria("DeliveryJournal");

		if (minDate != null) {
			djCriteria.add(Restrictions.ge("date", minDate));
		}

		if (maxDate != null) {
			Calendar cld = Calendar.getInstance();
			cld.setTime(maxDate);
			cld.add(Calendar.DAY_OF_MONTH, 1);
			djCriteria.add(Restrictions.lt("date", cld.getTime()));
		}

		if (route != null) {
			djCriteria.add(Restrictions.eq("route", route));
		}

		if (customer != null) {
			djCriteria.add(Restrictions.eq("customer", customer));
		}

		djCriteria.addOrder(Order.asc("route"));
		djCriteria.addOrder(Order.asc("date"));
		return djCriteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DairyContainer> getBinsByRoute(Route journalRoute) {
		Session session = PersistenceManager.getDefault().getSession();
		Criteria dcCriteria = session.createCriteria("DairyContainer");
		if (journalRoute != null) {
			dcCriteria.add(Restrictions.eq("", journalRoute));
		}
		return dcCriteria.list();
	}

	@Override
	public Membership findMemberByMemberNo(String searchMemberNumber) {
		return dairyRepository.memberByNumber(searchMemberNumber);
	}

	public Account findAccountByMemberNo(String memberNo) {
		return dairyRepository.primaryAccountForMemberNo(memberNo);
	}

	@Override
	public List<CollectionJournalLine> getMemberCollectionsForSession(
			CollectionSession session, Membership value) {
		// TODO: implement
		return null;
	}

	/**
	 * 
	 */
	private void log(int level, String message) {
		Log4r.getLogger(Activator.getDefault(), getClass()).log(level, message);
	}

}
