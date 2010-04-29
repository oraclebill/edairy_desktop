package com.agritrace.edairy.common.datamodel.common;

import javax.persistence.*;

/**
 * A DomainElement represents an item in a pick-list - the domain of the list might be something like
 * "RegisteredAnimal Breeds" or "Honorifics" - they are values that are used commonly to ensure that data entered
 * is within an accepted set of standards, but otherwise have no programmatic significance. The application
 * will ship with a preset collection of standard values which can be extended by the user.
 * 
 * Standard domains:
 *  - RegisteredAnimal Types (Cow, Goat, Other)
 *  - RegisteredAnimal Breeds (Holstien, Guersey, ...)
 *  - RegisteredAnimal Identifier Source (Kenya Dairy Board, Kenya Livestock Ministry, ...)
 *  - RegisteredAnimal Identification Method (Ear Tag, RFID, GSM/GPRS, ...)
 *  - Contact Methods (EMail, Skype, SMS, et
 *  - etc
 *  
 * @author oraclebill
 *
 */
@Entity
public class DomainElement {
	private Long domainElementId;
	private String domainName;
	private String elementCode;
	private String elementName;
	private String elementDescription;
	
	@Id
	@GeneratedValue	
	public Long getDomainElementId() {
		return domainElementId;
	}
	public void setDomainElementId(Long domainElementId) {
		this.domainElementId = domainElementId;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getElementCode() {
		return elementCode;
	}
	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
	}
	public String getElementName() {
		return elementName;
	}
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	public String getElementDescription() {
		return elementDescription;
	}
	public void setElementDescription(String elementDescription) {
		this.elementDescription = elementDescription;
	}
	
}
