package com.agritrace.edairy.desktop.operations.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.riena.core.Log4r;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.model.base.ImageEntry;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
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
import com.agritrace.edairy.desktop.common.model.dairy.MilkPrice;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager;
import com.agritrace.edairy.desktop.internal.common.persistence.Activator;

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
	 */
//	private static final HibernateRepository<DairyContainer> binRepository = new HibernateRepository<DairyContainer>() {
//		@Override
//		protected Class<DairyContainer> getClassType() {
//			return DairyContainer.class;
//		}
//	};

	/**
	 * 
	 */
//	private static final HibernateRepository<CollectionJournalPage> collectionsRepository = new HibernateRepository<CollectionJournalPage>() {
//		@Override
//		protected Class<CollectionJournalPage> getClassType() {
//			return CollectionJournalPage.class;
//		}
//	};
//	private static final HibernateRepository<Customer> customerRepository = new HibernateRepository<Customer>() {
//		@Override
//		protected Class<Customer> getClassType() {
//			return Customer.class;
//		}
//	};
	private static final HibernateRepository<Dairy> dairyRepository = new HibernateRepository<Dairy>() {
		@Override
		protected Class<Dairy> getClassType() {
			return Dairy.class;
		}
	};
//	private static final HibernateRepository<DeliveryJournal> deliveryRepository = new HibernateRepository<DeliveryJournal>() {
//		@Override
//		protected Class<DeliveryJournal> getClassType() {
//			return DeliveryJournal.class;
//		}
//	};

//	private static final HibernateRepository<Employee> employeeRepository = new HibernateRepository<Employee>() {
//		@Override
//		protected Class<Employee> getClassType() {
//			return Employee.class;
//		}
//	};

	// private static final HibernateRepository<Membership> memberRepository =
	// new HibernateRepository<Membership>() {
	// @Override
	// protected Class<Membership> getClassType() {
	// return Membership.class;
	// }
	// };

	// private static final HibernateRepository<Route> routeRepository = new
	// HibernateRepository<Route>() {
	// @Override
	// protected Class<Route> getClassType() {
	// return Route.class;
	// }
	// };

	// private static final HibernateRepository<Vehicle> vehicleRepository = new
	// HibernateRepository<Vehicle>() {
	// @Override
	// protected Class<Vehicle> getClassType() {
	// return Vehicle.class;
	// }
	// };

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
				DairyPackage.Literals.DAIRY__CUSTOMERS, DairyPackage.Literals.DAIRY__DAIRY_BINS,
				DairyPackage.Literals.DAIRY__EMPLOYEES, DairyPackage.Literals.DAIRY__ROUTES,
				DairyPackage.Literals.DAIRY__VEHICLES, DairyPackage.Literals.DAIRY__SUPPLIERS,
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

	public List<CollectionJournalPage> allCollectionJournalPages() {
//		return collectionsRepository.getMemberships();
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
//		return deliveryRepository.getMemberships();
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

	public void deleteRoute(final Route object) {
		if (localDairy.getRoutes().remove(object)) {
			save(localDairy);
		} else {
			throw new RepositoryException("Route not found!");
		}
	}

	@Override
	public List<Employee> employeesByPosition(String string) {
//		return employeeRepository.find("FROM Employee where jobfunction='" + string + "'");
		List<Employee> found = new LinkedList<Employee>();
		for (Employee employee : localDairy.getEmployees()) {
			String job = employee.getJobFunction();
			if (job != null && job.equals(string)) {
				found.add(employee);
			}
		}
		return found;
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
//		return binRepository.findByKey(Long.parseLong(canId));
		Container found = null;
		for (Container bin : localDairy.getDairyBins()) {
			if (bin.getTrackingNumber() != null && bin.getTrackingNumber().equals(canId)) {
				found = bin;
				break;
			}
		}
		return found;
	}

	@Override
	public CollectionJournalPage getJournalPageById(Long pageId) {
		return getJournalPageById(pageId.toString());		
	}

	@Override
	public CollectionJournalPage getJournalPageById(String pageId) {
		CollectionJournalPage found = null;
		for (CollectionJournalPage page : localDairy.getCollectionJournals()) {
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
		// Long memberId = new Long(-1);
		// try {
		// memberId = Long.parseLong(memberIdString);
		// } catch (final NumberFormatException nfe) {
		// ;
		// ;
		// }
		// return memberRepository.findByKey(memberId);
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
			log(LogService.LOG_DEBUG, "getMembershipById: query time: " + (System.currentTimeMillis() - start));
		}
	}

	@Override
	public void delete(Membership member) {
//		member.setStatus(MembershipStatus.DELETED);
//		dairyRepository.save(member);
		if (localDairy.getMemberships().remove(member)) {
			save();
		}
		else {
			throw new RepositoryException("Member not in memberlist");
		}
	}
	
	@Override 
	public List<Membership> getMemberships() {
		return localDairy.getMemberships();
	}
		
	@SuppressWarnings("unchecked")
	@Override 
	public List<Farm> getMemberFarms() {
		return (List<Farm>) PersistenceManager.getDefault().getSession().createCriteria(Farm.class).list();
	}
		
	@Override
	public void saveNew(Membership newEntity) throws AlreadyExistsException {
		if (newEntity.getMemberNumber() == null || newEntity.getMemberNumber().trim().length() == 0) {
			int size = localDairy.getMemberships().size();
			long count = localDairy.getVersion();
			newEntity.setMemberNumber("A" + count + "" + size);
//			throw new RepositoryException("Member number cannot be null");
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
	public void saveNewJournalPage(CollectionJournalPage newJournal) {
//		collectionsRepository.saveNew(newJournal);
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
		MilkPrice currentPrice;
		Session session = PersistenceManager.getDefault().getSession();
		Date maxDate = (Date) session.createQuery("select max(priceDate) from MilkPrice").uniqueResult();
		if (maxDate != null) {
			currentPrice = (MilkPrice) session.createQuery("select from MilkPrice where priceDate = ?")
					.setDate(0, maxDate).uniqueResult();
		} else {
			currentPrice = null;
		}
		return currentPrice;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MilkPrice> getMilkPrices(Date startDate, Date endDate) {
		Session session = PersistenceManager.getDefault().getSession();
		return (List<MilkPrice>) session.createCriteria("MilkPrice")
				.add(Restrictions.between("priceDate", startDate, endDate)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DeliveryJournal> getDeliveryJournals(Date minDate, Date maxDate, Route route, Customer customer) {
		Session session = PersistenceManager.getDefault().getSession();
		Criteria djCriteria = session.createCriteria("DeliveryJournal");
		if (minDate != null) {
			djCriteria.add(Restrictions.ge("date", minDate));
		}
		if (maxDate != null) {
			djCriteria.add(Restrictions.le("date", maxDate));
		}
		if (route != null) {
			djCriteria.add(Restrictions.eq("route", route));
		}
		if (customer != null) {
			djCriteria.add(Restrictions.eq("customer", customer));
		}
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
	public Membership getMemberByMemberId(String searchMemberNumber) {

		long start = System.currentTimeMillis();

		String formattedNumber = searchMemberNumber;
		try {
			formattedNumber = String.format("%05d", Integer.parseInt(searchMemberNumber));
		} catch (NumberFormatException nfe) {
			;
		}

		Membership retval = null;
		for (Membership membership : localDairy.getMemberships()) {
			String memberNumber = membership.getMemberNumber();
			if (memberNumber != null && memberNumber.equals(formattedNumber)) {
				retval = membership;
				break;
			}
		}

		log(LogService.LOG_DEBUG, String.format(" > Member search %8s, looking for %s (%s), time: %d\n",
				(retval == null ? "FAILS" : "SUCCEEDS"), formattedNumber, searchMemberNumber,
				(System.currentTimeMillis() - start)));

		return retval;
	}

	@Override
	public List<CollectionJournalLine> getMemberCollectionsForSession(
			com.agritrace.edairy.desktop.common.model.dairy.Session session, Membership value) {
		// TODO: implement
		return null;
	}

	/**
	 * 
	 */
	public ImageData getImageData(String key) {
		ImageData ret = null;
		if (key != null) {
			try {
				ImageEntry entry = (ImageEntry) PersistenceManager.getDefault().getSession().load("ImageEntry", key);
				final byte[] data = entry.getImageData();
				debug_print(key, data);
				InputStream stream = new ByteArrayInputStream(entry.getImageData());
				ret = new ImageData(stream);
			} catch (HibernateException hbe) {
				log(LogService.LOG_WARNING, hbe.getMessage(), hbe);
			}
		}
		return ret;
	}

	/**
	 * 
	 */
	public void saveImageData(String key, ImageData data) {
		if (key == null) {
			return;
		}
		Session session = PersistenceManager.getDefault().getSession();
		try {
			Transaction tx = session.beginTransaction();
			ImageEntry entry = (ImageEntry) session.get("ImageEntry", key);
			if (entry == null) {
				entry = ModelFactory.eINSTANCE.createImageEntry();
				entry.setImageId(key);
				entry.setMimeType("image/unknown");
				session.save(entry);
			}
			final ByteArrayOutputStream baos = new ByteArrayOutputStream();
			final ImageLoader loader = new ImageLoader();
			loader.data = new ImageData[] { data };
			loader.save(baos, data.type);
			entry.setImageData(baos.toByteArray());
			entry.setMimeType(decodeMimeType(data.type));
			tx.commit();
		} catch (HibernateException hbe) {
			log(LogService.LOG_WARNING, "Error saving ImageEntry: " + key, hbe);
		} finally {
			if (session != null) {
				session.clear();
			}
		}

	}

	private String decodeMimeType(int type) {
		String mimeType;

		switch (type) {
		case SWT.IMAGE_BMP:
		case SWT.IMAGE_BMP_RLE:
		case SWT.IMAGE_OS2_BMP:
			mimeType = "image/bmp";
			break;

		case SWT.IMAGE_GIF:
			mimeType = "image/gif";
			break;

		case SWT.IMAGE_ICO:
			mimeType = "image/gif";
			break;

		case SWT.IMAGE_JPEG:
			mimeType = "image/jpeg";
			break;

		case SWT.IMAGE_PNG:
			mimeType = "image/png";
			break;

		case SWT.IMAGE_TIFF:
			mimeType = "image/tiff";
			break;

		case SWT.IMAGE_UNDEFINED:
		default:
			mimeType = "application/octet-stream";
		}

		return mimeType;
	}

	private void debug_print(String tag, byte[] array) {
		int COUNT = 64;
		System.err.println(String.format("First %d bytes of %s\n ", COUNT, tag));
		for (int i = 0; i < COUNT; i++) {
			System.err.print(String.format("%02x ", array[i]));
			if ((i + 1) % 32 == 0)
				System.err.print("\n");
		}
	}

	/**
	 * 
	 */
	private void log(int level, String message, Throwable exception) {
		Log4r.getLogger(Activator.getDefault(), getClass()).log(level, message, exception);
	}

	/**
	 * 
	 */
	private void log(int level, String message) {
		Log4r.getLogger(Activator.getDefault(), getClass()).log(level, message);
	}

}
