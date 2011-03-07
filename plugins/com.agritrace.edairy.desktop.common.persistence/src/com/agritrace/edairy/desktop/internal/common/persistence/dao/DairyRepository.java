package com.agritrace.edairy.desktop.internal.common.persistence.dao;

import java.util.ArrayList;
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
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Bin;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.MemberPayment;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MilkGrade;
import com.agritrace.edairy.desktop.common.model.dairy.MilkSale;
import com.agritrace.edairy.desktop.common.model.dairy.TransportRoute;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.util.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.annotations.Transactional;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.HibernateRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.PersistenceActivator;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class DairyRepository implements IDairyRepository {

	/**
	 *
	 */
	public static final String EDAIRY_SITE_DAIRYID = "edairy.site.dairyid";

	/**
	 * 
	 * @author bjones
	 * 
	 */
	protected static class DairyRepoInternal extends HibernateRepository<Dairy> {
		@Inject
		protected DairyRepoInternal(Provider<Session> sessionProvider) {
			super(sessionProvider);
		}

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
				setResult((Membership) session.createCriteria("Membership")
						.add(Restrictions.eq(DairyPackage.Literals.MEMBERSHIP__MEMBER_NUMBER.getName(), memberNumber))
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
				System.err.println("AccountForMemberNo: finding member account: " + memberNumber);
				final Criteria query = session.createCriteria("Membership").add(
						Restrictions.eq(DairyPackage.Literals.MEMBERSHIP__MEMBER_NUMBER.getName(), memberNumber));
				final Membership member = (Membership) query.uniqueResult();
				final Account account = member != null ? member.getAccount() : null;
				setResult(account);
				System.err.println("AccountForMemberNo: returning : " + account);
			}
		}

		class MembersForRoute extends SessionRunnable<Object> {
			DairyLocation route;

			public MembersForRoute(DairyLocation route) {
				this.route = route;
			}

			@Override
			public void run(Session session) {
				@SuppressWarnings("unchecked")
				final List<Membership> result = session.createCriteria("Membership")
						.add(Restrictions.eq("defaultRoute", route)).list();
				setResult(result);
			}
		}

		class SkinnyAccountsQuery extends SessionRunnable<List<Account>> {

			public SkinnyAccountsQuery() {
			}

			@Override
			public void run(Session session) {
				final Criteria criteria = session.createCriteria("Account");
				criteria.setFetchMode("transactions", FetchMode.SELECT);

				@SuppressWarnings("unchecked")
				final List<Account> result = criteria.list();
				setResult(result);
			}
		}

		@Transactional
		public List<Membership> membersForRoute(DairyLocation defaultRoute) {
			final MembersForRoute query = new MembersForRoute(defaultRoute);
			runWithTransaction(query);

			@SuppressWarnings("unchecked")
			final List<Membership> result = (List<Membership>) query.getResult();
			return result;
		}

		public Membership memberByNumber(String memberNumber) {
			final MemberByNumber query = new MemberByNumber(memberNumber);
			runWithTransaction(query);
			return query.getResult();
		}

		public Account primaryAccountForMemberNo(String memberNo) {
			final AccountForMemberNo query = new AccountForMemberNo(memberNo);
			runWithTransaction(query);
			return query.getResult();
		}

		public List<Account> allAccounts() {
			final SkinnyAccountsQuery query = new SkinnyAccountsQuery();
			runWithTransaction(query);
			return query.getResult();
		}
	};

	private final Provider<Session> sessionProvider;
	private final DairyRepoInternal dairyRepository;
	private Dairy localDairy = null;

	@Inject
	public DairyRepository(final Provider<Session> sessionProvider) {
		this.sessionProvider = sessionProvider;
		this.dairyRepository = new DairyRepoInternal(sessionProvider);
	}

	@Override
	public Dairy getLocalDairy() {
		if (localDairy == null) {
			localDairy = getOrCreateDairy();
		}
		return localDairy;
	}

	@Transactional
	protected Dairy getOrCreateDairy() {

		Session session = getSession();

		Dairy dairy = (Dairy) session.createQuery("FROM Dairy").uniqueResult();

		if (dairy == null) {
			dairy = DairyFactory.eINSTANCE.createDairy();
			dairy.setLocation(DairyUtil.createLocation(null, null, null));
			dairy.setCompanyName("");
			dairy.setDescription("");
			dairy.setPhoneNumber("");
			dairy.setRegistrationNumber("");

			session.save(dairy);
		}

		// initialize the instance..
		Hibernate.initialize(dairy);
		final List<EReference> persistentCollections = Arrays.asList(DairyPackage.Literals.DAIRY__BRANCH_LOCATIONS,
				DairyPackage.Literals.DAIRY__CUSTOMERS, DairyPackage.Literals.DAIRY__DAIRY_BINS,
				DairyPackage.Literals.DAIRY__EMPLOYEES, DairyPackage.Literals.DAIRY__ROUTES,
				DairyPackage.Literals.DAIRY__COLLECTION_JOURNALS, DairyPackage.Literals.DAIRY__VEHICLES,
				DairyPackage.Literals.DAIRY__SUPPLIERS, ModelPackage.Literals.CONTACTABLE__CONTACT_METHODS);
		for (final EStructuralFeature feature : persistentCollections) {
			Hibernate.initialize(dairy.eGet(feature));
		}

		return dairy;
	}

	@Override
	public void updateDairy() {
		dairyRepository.update(getLocalDairy());
	}

	public void updateRoute(final TransportRoute changedRoute) {
		dairyRepository.save(changedRoute);
	}

	@Override
	public void addRoute(final TransportRoute newRoute) {
		getLocalDairy().getRoutes().add(newRoute);
		dairyRepository.save(getLocalDairy());
	}

	@Override
	public List<CollectionGroup> allCollectionGroups() {
		// return collectionsRepository.getMemberships();
		return getLocalDairy().getCollectionJournals();
	}

	@Override
	public List<Customer> allCustomers() {
		return getLocalDairy().getCustomers();
	}

	@Override
	public List<Bin> allDairyContainers() {
		return getLocalDairy().getDairyBins();
	}

	@Override
	public List<DeliveryJournal> allDeliveries() {
		// return deliveryRepository.getMemberships();
		return getLocalDairy().getDeliveryJournals();
	}

	@Override
	public List<TransportRoute> allRoutes() {
		return getLocalDairy().getRoutes();
	}

	@Override
	public List<Vehicle> allVehicles() {
		return getLocalDairy().getVehicles();
	}

	public void delete(Dairy deletableEntity) {
		dairyRepository.delete(deletableEntity);
	}

	@Override
	public void deleteRoute(final TransportRoute object) {
		if (getLocalDairy().getRoutes().remove(object)) {
			getSession().delete(object);
			getSession().flush();
			save(getLocalDairy());

		} else {
			throw new RepositoryException("Transport Route not found!");
		}
	}

	@Override
	public List<Employee> employeesByPosition(String string) {
		// return employeeRepository.find("FROM Employee where jobfunction='" +
		// string + "'");
		final List<Employee> found = new LinkedList<Employee>();
		for (final Employee employee : getLocalDairy().getEmployees()) {
			final String job = employee.getJobFunction();
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
		for (final Container bin : getLocalDairy().getDairyBins()) {
			if (bin.getTrackingNumber() != null && bin.getTrackingNumber().equals(canId)) {
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
		for (final CollectionGroup page : getLocalDairy().getCollectionJournals()) {
			if (page.getReferenceNumber().equals(pageId)) {
				found = page;
				break;
			}
		}
		return found;
	}

	@Override
	public List<DairyLocation> getLocalDairyLocations() {
		return getLocalDairy().getBranchLocations();
	}

	@Override
	public Membership getMembershipById(Object memberId) {
		return getMembershipById((String) memberId);
	}

	public Membership getMembershipById(String memberIdString) {
		final long start = System.currentTimeMillis();
		try {
			Membership found = null;
			for (final Membership member : getLocalDairy().getMemberships()) {
				if (member.getMemberNumber().equals(memberIdString)) {
					found = member;
					break;
				}
			}
			return found;
		} finally {
			log(LogService.LOG_DEBUG, "getMembershipById: query time: " + (System.currentTimeMillis() - start));
		}
	}


	@Override
	public List<Membership> getMembersForRoute(DairyLocation theRoute) {
		return dairyRepository.membersForRoute(theRoute);
	}


	@Override
	public Dairy reloadLocalDairy() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void save() {
		dairyRepository.save(getLocalDairy());
	}

	@Override
	public void save(Object changedItem) {
		dairyRepository.save(changedItem);
	}

	@Override
	public void saveNewJournalPage(CollectionGroup newJournal) {
		// collectionsRepository.saveNew(newJournal);
		getLocalDairy().getCollectionJournals().add(newJournal);
		save();
	}

	@Override
	public void updateBranchLocation(DairyLocation changedDairyLocation) {
		if (getLocalDairy().getBranchLocations().contains(changedDairyLocation)) {
			;
		} else {
			getLocalDairy().getBranchLocations().add(changedDairyLocation);
		}
		getSession().flush();
	}

	@Override
	public void addBranchLocation(DairyLocation changedDairyLocation) {
		getLocalDairy().getBranchLocations().add(changedDairyLocation);
		dairyRepository.update(getLocalDairy());
		// PersistenceManager.getDefault().getSession().persist(changedDairyLocation);
		// PersistenceManager.getDefault().getSession().flush();
	}

	@Override
	public void deleteBranchLocation(DairyLocation oldItem) {
		getLocalDairy().getBranchLocations().remove(oldItem);
		getSession().delete(oldItem);
		getSession().flush();

	}

	@Override
	public MemberPayment getCurrentMilkPrice() {
		final Session session = getSession();
		DetachedCriteria.forEntityName("MemberPayment").setProjection(Property.forName("priceDate").max());
		final MemberPayment currentPrice = (MemberPayment) session.createCriteria("MemberPayment")
				.addOrder(Order.desc("year")).addOrder(Order.desc("month")).setFetchSize(1).setMaxResults(1)
				.uniqueResult();
		return currentPrice;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<MemberPayment> getMilkPrices(Date startDate, Date endDate) {
		final Session session = getSession();
		return session.createCriteria("MemberPayment").addOrder(Order.desc("year")).addOrder(Order.desc("month"))
				.add(Restrictions.ge("year", startDate.getYear() + 1900))
				.add(Restrictions.ge("month", startDate.getMonth()))
				.add(Restrictions.le("year", endDate.getYear() + 1900))
				.add(Restrictions.le("month", endDate.getMonth())).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MilkSale> getMilkSales(Date minDate, Date maxDate, DairyLocation store, Customer customer) {
		final Session session = getSession();
		final Criteria djCriteria = session.createCriteria("MilkSale");

		if (minDate != null) {
			djCriteria.add(Restrictions.ge("saleDate", minDate));
		}

		if (maxDate != null) {
			final Calendar cld = Calendar.getInstance();
			cld.setTime(maxDate);
			cld.add(Calendar.DAY_OF_MONTH, 1);
			djCriteria.add(Restrictions.lt("saleDate", cld.getTime()));
		}

		if (store != null) {
			djCriteria.add(Restrictions.eq("storeOrRoute", store));
		}

		if (customer != null) {
			djCriteria.add(Restrictions.eq("customer", customer));
		}

		djCriteria.addOrder(Order.asc("saleDate"));
		djCriteria.addOrder(Order.asc("storeOrRoute"));
		return djCriteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bin> getBinsByRoute(TransportRoute journalRoute) {
		final Session session = getSession();
		final Criteria dcCriteria = session.createCriteria("Bin");
		if (journalRoute != null) {
			dcCriteria.add(Restrictions.eq("", journalRoute));
		}
		return dcCriteria.list();
	}

	@Override
	public Membership findMemberByMemberNo(String searchMemberNumber) {
		if (searchMemberNumber.length() < 5) {
			searchMemberNumber = "00000".substring(0, 5 - searchMemberNumber.length()) + searchMemberNumber;
		}
		return dairyRepository.memberByNumber(searchMemberNumber);
	}


	@Override
	public List<CollectionJournalLine> getMemberCollectionsForSession(CollectionSession session, Membership value) {
		// TODO: implement
		return null;
	}

	/**
	 * Get the current session.
	 * 
	 * @return the current session.
	 */
	private Session getSession() {
		return sessionProvider.get();
	}

	/**
	 *
	 */
	private void log(int level, String message) {
		Log4r.getLogger(PersistenceActivator.getDefault(), getClass()).log(level, message);
	}

	@Override
	public List<CollectionGroup> getCollectionGroups(Date startDate, Date endDate) {
		// Currently filters from all groups, since the list is preloaded when
		// loading the dairy. Apparently.

		final List<CollectionGroup> result = new ArrayList<CollectionGroup>();

		for (final CollectionGroup group : allCollectionGroups()) {
			final Date date = group.getJournalDate();

			if (date.compareTo(startDate) >= 0 && date.compareTo(endDate) < 0) {
				result.add(group);
			}
		}

		return result;
	}

//	@Override
	@Transactional
	public List<AccountTransaction> findAccountTransactions(Account account, Date start, Date end, String refNum, List<TransactionSource> sources) {
		final Session session = getSession();
		final Criteria criteria = session.createCriteria("Transaction");

		if (account != null) {
			criteria.add(Restrictions.eq("account", account));
		}
		if (start != null) {
			criteria.add(Restrictions.ge("transactionDate", start));
		}
		if (end != null) {
			criteria.add(Restrictions.le("transactionDate", end));
		}

		if (refNum != null) {
			criteria.add(Restrictions.like("referenceNumber", end));
		}

		if (sources != null && sources.size() > 0) {
			criteria.add(Restrictions.in("source", sources));
		}

		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<MilkGrade> getMilkGrades()  {
		// FIXME: !!! milk grades are not being mapped properly...
		
		List<MilkGrade> gradeList = (List<MilkGrade>) getSession().createCriteria("MilkGrade").list();
		if (gradeList.size() < 1) {
			MilkGrade defaultGrade = DairyFactory.eINSTANCE.createMilkGrade();
			defaultGrade.setCode("RAW");
			defaultGrade.setName("Raw Milk - Standard Grade");
			defaultGrade.setDescription("The standard grade of raw milk");
			save(defaultGrade);
			gradeList = (List<MilkGrade>) getSession().createCriteria("MilkGrade").list();
		}
		return gradeList;
	}
	
}
