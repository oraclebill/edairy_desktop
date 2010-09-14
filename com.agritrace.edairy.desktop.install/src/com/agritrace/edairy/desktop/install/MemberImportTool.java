package com.agritrace.edairy.desktop.install;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountStatus;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

public class MemberImportTool extends AbstractImportTool {
	private static final Date DEFAULT_IMPORT_DATE = getDefaultDate();

	public static final int MEMBER_NUMBER = 2;
	public static final int MEMBER_ACCOUNT_NUMBER = 1;
	public static final int MEMBER_DEFAULT_ROUTE = 3;
	public static final int MEMBER_GIVEN_NAME = 6;
	public static final int MEMBER_FAMILY_NAME = 7;

	// private DairyRepository dairyRepo;
	// private Dairy dairy;
	private Map<String, Membership> memberCache = new HashMap<String, Membership>();
	private Map<String, Route> routeCache = new HashMap<String, Route>();
	private Collection<Membership> memberCollection;
	private Map<String, List<String[]>> failedRecords;
	public int count = 0;
	public int errors = 0;

	public MemberImportTool(InputStream stream, List<Membership> memberCollection,
			Map<String, List<String[]>> failedRecords, IProgressMonitor monitor) throws FileNotFoundException, IOException {

		super(new InputStreamReader(stream));
		setMonitor(monitor);
		this.memberCollection = memberCollection;
		this.failedRecords = failedRecords;

		Dairy dairy = DairyRepository.getInstance().getLocalDairy();
		for (Route route : dairy.getRoutes()) {
			routeCache.put(route.getName(), route);
		}
		for (Membership member : dairy.getMemberships()) {
			memberCache.put(member.getMemberNumber(), member);
		}
	}

	@Override
	protected void processRecord(String[] values) {
		count += 1;
		// validate
		Membership membership = memberCache.get(values[MEMBER_NUMBER]);
		if (membership != null) {
			addFailure("Member already exists!", values);
			return;
		} else {
			try {
				membership = createMembership(values);
				memberCollection.add(membership);
			} catch (Exception e) {
				addFailure(e.getMessage(), values);
			}
		}
	}

	private void addFailure(String message, String[] values) {
		errors += 1;
		List<String[]> records = failedRecords.get(message);
		if (records == null) {
			records = new LinkedList<String[]>();
			failedRecords.put(message, records);
		}
		records.add(values);		
	}

	public Membership createMembership(String[] values) {
		Membership membership = null;

		final String givenName = values[MEMBER_GIVEN_NAME];
		final String familyNames = values[MEMBER_FAMILY_NAME];
		final String accountNumber = values[MEMBER_ACCOUNT_NUMBER];
		final String membershipNumber = values[MEMBER_NUMBER];
		final String defaultRoute = values[MEMBER_DEFAULT_ROUTE];

		Formatter formatter = new Formatter();
		formatter.format("%s %s (%s) Farm", givenName, familyNames, membershipNumber);
		Farm farm = DairyUtil.createFarm(formatter.toString(), DairyUtil.createLocation(null, null, null));
		Farmer farmer = DairyUtil.createFarmer(givenName, "", familyNames, "<missing>", farm);
		membership = DairyUtil.createMembership(DEFAULT_IMPORT_DATE, DEFAULT_IMPORT_DATE, farmer);
		// membership.setMemberId(key);
		membership.setMemberNumber(membershipNumber);
		membership.setStatus(MembershipStatus.ACTIVE);

		membership.setDefaultRoute(getRoute(defaultRoute));

		Account account = AccountFactory.eINSTANCE.createAccount();
		account.setMember(membership);
		// account.setAccountNumber("V"+membership.getMemberNumber());
		account.setAccountNumber(accountNumber);
		account.setStatus(AccountStatus.ACTIVE);
		account.setEstablished(DEFAULT_IMPORT_DATE);

		return membership;
	}

	private Route getRoute(String string) {
		return routeCache.get(string);
	}

	@Override
	protected void doImportComplete(int okCount, int failCount) {
//		done();
	}

	private static Date getDefaultDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 1970);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	@Override
	protected void saveImportedEntity(Object entity) {
		// TODO Auto-generated method stub
	}

	@Override
	protected String[] getExpectedHeaders() {
		return new String[] { null, "account-id", "membership-id", "default-route", null, null, "given-name",
				"family-name" };
	}


	@Override
	protected EObject createBlankEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<Entry> getFields() {
		// TODO Auto-generated method stub
		return null;
	}

}
