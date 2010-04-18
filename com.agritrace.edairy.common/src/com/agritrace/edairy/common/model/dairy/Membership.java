package com.agritrace.edairy.common.model.dairy;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.*;

@Entity
public class Membership {
	public enum MembershipStatus {
		APPLICANT, ACTIVE, FLAGGED, DORMANT, ARCHIVED
	}

	private int membershipId;

	private MembershipStatus status;
	private Date applicationDate;
	private Date effectiveDate;

	@Id
	@GeneratedValue
	public int getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(int membershipId) {
		this.membershipId = membershipId;
	}

	public MembershipStatus getStatus() {
		return status;
	}

	public void setStatus(MembershipStatus status) {
		this.status = status;
	}

	@Temporal(value = TemporalType.DATE)
	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	@Temporal(value = TemporalType.DATE)
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

}
