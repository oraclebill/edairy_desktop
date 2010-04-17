package com.agritrace.edairy.common.model.base;

public class ContactMethod {
	
	public enum CMType { CELL_PHONE, OTHER_PHONE, EMAIL, FAX, INSTANT_MESSAGE, WEBSITE, OTHER }
	
	private CMType contactType;
	private String contactInfo;

}
