package com.agritrace.edairy.common.datamodel.dairy;

import java.util.Date;
import javax.persistence.*;

import com.agritrace.edairy.common.datamodel.common.Location;

@Entity
public class CollectionCentre {
	@Id
	@GeneratedValue
	private Long _collectionCentreId;
	private String _name;
	private Date _dateOpened;
	private Route _route;
	private String _colorCode;
	private String _phoneNumber;	
	private Location _location;
	
}
