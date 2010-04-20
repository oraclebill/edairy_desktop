package com.agritrace.edairy.common.datamodel.common;

import javax.persistence.*;

@Entity
public class ContactMethod {

	public enum CMType {
		CELL_PHONE, OTHER_PHONE, EMAIL, FAX, INSTANT_MESSAGE, WEBSITE, OTHER
	}

	
	private Long contactMethodId;
	private CMType contactType;
	private String contactInfo;

	public CMType getContactType() {
		return contactType;
	}

	public void setContactType(CMType contactType) {
		this.contactType = contactType;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	@Id
	@GeneratedValue
	public Long getContactMethodId() {
		return contactMethodId;
	}

	public void setContactMethodId(Long contactMethodId) {
		this.contactMethodId = contactMethodId;
	}

}
