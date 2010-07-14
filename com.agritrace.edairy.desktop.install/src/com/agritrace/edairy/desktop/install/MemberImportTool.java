package com.agritrace.edairy.desktop.install;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountStatus;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.ui.managers.DairyUtil;

public class MemberImportTool extends AbstractImportTool {
	private static final Date DEFAULT_IMPORT_DATE = getDefaultDate();

	public static final int MEMBER_NUMBER = 2;
	public static final int MEMBER_ACCOUNT_NUMBER = 1;
	public static final int MEMBER_DEFAULT_ROUTE = 3;
	public static final int MEMBER_GIVEN_NAME = 6;
	public static final int MEMBER_FAMILY_NAME = 7;

	private Map<Long, Membership> memberships = new HashMap<Long, Membership>();

	public MemberImportTool(File file) throws FileNotFoundException {
		super(file);
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
				key = null;
			}
		}
		
		Membership membership = memberships.get(key);
		if ( membership != null ) {
			throw new ValidationException("Duplicate Record");
		}
		
		Formatter formatter = new Formatter();
		formatter.format("%s %s (%s) Farm", givenName, familyNames, membershipNumber);
		Farm farm = DairyUtil.createFarm(formatter.toString(), DairyUtil.createLocation(null, null, null));
		Farmer farmer = DairyUtil.createFarmer(givenName, "", familyNames, "<missing>", farm);
		membership = DairyUtil.createMembership(DEFAULT_IMPORT_DATE, DEFAULT_IMPORT_DATE, farmer);
		membership.setMemberNumber(values[MEMBER_NUMBER]);
		membership.setStatus(MembershipStatus.ACTIVE);		
		
		Account account = AccountFactory.eINSTANCE.createAccount();
		account.setMember(membership);
		account.setStatus(AccountStatus.ACTIVE);
		account.setEstablished(DEFAULT_IMPORT_DATE);

		System.out.println(membership);
	}

	@Override
	protected void doImportRecord(Object entity) {
		System.out.println(entity);
	}

	private static Date getDefaultDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 1970);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

}
