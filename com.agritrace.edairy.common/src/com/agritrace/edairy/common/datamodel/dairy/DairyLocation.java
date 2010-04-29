package com.agritrace.edairy.common.datamodel.dairy;

import java.util.Date;
import javax.persistence.*;

import com.agritrace.edairy.common.datamodel.common.Location;

@Entity
public class DairyLocation {
	public enum DairyFunction { STORE_SALES, MILK_COLLECTION, WAREHOUSE, MILK_PROCESSING, MILK_STORAGE, OFFICES } 
	
	@Id @GeneratedValue
	private Long collectionCentreId;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date dateOpened;
	private Route route;
	private String colorCode;
	private String phoneNumber;	
	private Location location;	
	private String description;
	private DairyFunction function; 
}
