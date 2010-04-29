package com.agritrace.edairy.common.datamodel.dairy;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.agritrace.edairy.common.datamodel.common.Person;
import com.agritrace.edairy.common.datamodel.dairy.accounting.AccountTransaction;
import com.agritrace.edairy.common.datamodel.farm.Farm;
import com.agritrace.edairy.common.datamodel.farm.RegisteredAnimal;

@Entity
public class Membership {
	public enum MembershipStatus {
		APPLICANT, ACTIVE, FLAGGED, DORMANT, ARCHIVED
	}

	private int membershipId;
	private MembershipStatus status;
	private Person member;
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

	public Person getMember() {
		return member;
	}

	public void setMember(Person member) {
		this.member = member;
	}
	
	public List<Farm> getMemberFarms() {
	    throw new UnsupportedOperationException();
	    
    }
    
	public List<RegisteredAnimal> getMemberLivestock() {
	    throw new UnsupportedOperationException();
    }

    public List<CollectionRecord> getMemberMilkCollections(Date start, Date end) {
	    throw new UnsupportedOperationException();
    }
        
    /**
     * returns members credit sales records and other financial transactions
     */
    public List<AccountTransaction> getMemberTransactions(Date start, Date end) {
	    throw new UnsupportedOperationException();
    }
        
    public List<CollectionRecord> getMemberContainers() {
	    throw new UnsupportedOperationException();
    }
        
    public List<Route> getDefaultRoutes() {
	    throw new UnsupportedOperationException();
    }
}
