package com.agritrace.edairy.common.model;

import java.util.Date;

public class Membership {
	public enum MembershipStatus { APPLICANT, ACTIVE, FLAGGED, DORMANT, ARCHIVED }
	
	private int _membershipId;
	
	private MembershipStatus _status;
	private Date _applicationDate;
	private Date _effectiveDate;
	
}
