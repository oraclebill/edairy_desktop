package com.agritrace.edairy.common.datamodel.common;

import javax.persistence.*;

/**
 * A DomainElement represents an item in a pick-list - the domain of the list might be something like
 * "AnimalRegistration Breeds" or "Honorifics" - they are values that are used commonly to ensure that data entered
 * is within an accepted set of standards, but otherwise have no programmatic significance. The application
 * will ship with a preset collection of standard values which can be extended by the user.
 * 
 * Standard domains:
 *  - AnimalRegistration Types (Cow, Goat, Other)
 *  - AnimalRegistration Breeds (Holstien, Guersey, ...)
 *  - AnimalRegistration Identifier Source (Kenya Dairy Board, Kenya Livestock Ministry, ...)
 *  - AnimalRegistration Identification Method (Ear Tag, RFID, GSM/GPRS, ...)
 *  - Contact Methods (EMail, Skype, SMS, et
 *  - etc
 *  
 * @author oraclebill
 *
 */
@Entity
public class DomainElement {
	@Id
	@GeneratedValue
	private Long domainElementId;
	private String domainName;
	private String elementCode;
	private String elementName;
	private String elementDescription;
	
}
