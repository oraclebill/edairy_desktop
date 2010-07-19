package com.agritrace.edairy.desktop.importers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

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

	private DairyRepository dairyRepo;
	private Dairy dairy;
	private Map<Long, Membership> memberCache = new HashMap<Long, Membership>();
	private Map<String, Route> routeCache = new HashMap<String, Route>();


	public MemberImportTool(File file) throws FileNotFoundException {
		super(file);
		dairyRepo = DairyRepository.getInstance();
		dairy = dairyRepo.getLocalDairy();
		for(Route route : dairy.getRoutes()) {
			routeCache.put(route.getCode(), route);
		}
		for (Membership member : dairy.getMemberships()) {
			memberCache.put(member.getMemberId(), member);
		}
	}

	@Override
	protected void processRecord(String[] values) {
		String givenName = values[MEMBER_GIVEN_NAME];
		String familyNames = values[MEMBER_FAMILY_NAME];
		String accountNumber = values[MEMBER_ACCOUNT_NUMBER];
		String membershipNumber = values[MEMBER_NUMBER];
		String defaultRoute = values[MEMBER_DEFAULT_ROUTE];

		Long key;
		try {
			key = Long.decode(membershipNumber);
		} catch (NumberFormatException nfe) {
			try {
				String chopped = membershipNumber.substring(0, membershipNumber.length() - 1);
				key = Long.decode(chopped);
			} catch (NumberFormatException nfe2) {
				throw new ValidationException("Unable to create valid key");
			}
		}

		Membership membership = memberCache.get(key);
		if (membership != null) {
			throw new ValidationException("Duplicate Record");
		}
		
		Formatter formatter = new Formatter();
		formatter.format("%s %s (%s) Farm", givenName, familyNames, membershipNumber);
		Farm farm = DairyUtil.createFarm(formatter.toString(), DairyUtil.createLocation(null, null, null));
		Farmer farmer = DairyUtil.createFarmer(givenName, "", familyNames, "<missing>", farm);
		membership = DairyUtil.createMembership(DEFAULT_IMPORT_DATE, DEFAULT_IMPORT_DATE, farmer);
		membership.setMemberId(key);
		membership.setMemberNumber(values[MEMBER_NUMBER]);
		membership.setStatus(MembershipStatus.ACTIVE);
		
		membership.setDefaultRoute(getRoute(values[MEMBER_DEFAULT_ROUTE]));
				

		Account account = AccountFactory.eINSTANCE.createAccount();
		account.setMember(membership);
		account.setAccountNumber("V"+membership.getMemberNumber());
		account.setStatus(AccountStatus.ACTIVE);
		account.setEstablished(DEFAULT_IMPORT_DATE);

		System.out.println(membership);
		dairy.getMemberships().add(membership);
	}

	private Route getRoute(String string) {
		return routeCache.get(string);
	}

	@Override
	protected void doImportComplete() {
		dairyRepo.save(dairy);
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

}
