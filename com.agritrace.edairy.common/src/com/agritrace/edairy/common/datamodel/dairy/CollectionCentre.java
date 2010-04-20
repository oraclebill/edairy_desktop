package com.agritrace.edairy.common.datamodel.dairy;

import java.util.Date;
import javax.persistence.*;

import com.agritrace.edairy.common.datamodel.common.Location;

@Entity
public class CollectionCentre {
	private Long _collectionCentreId;
	private String _name;
	private Date _dateOpened;
	private Route _route;
	private String _colorCode;
	private String _phoneNumber;	
	private Location _location;
	
	@Id
	@GeneratedValue
	public Long getCollectionCentreId() {
		return _collectionCentreId;
	}
	public void setCollectionCentreId(Long collectionCentreId) {
		_collectionCentreId = collectionCentreId;
	}
	public String getName() {
		return _name;
	}
	public void setName(String name) {
		_name = name;
	}
	@Temporal(TemporalType.DATE)	
	public Date getDateOpened() {
		return _dateOpened;
	}
	public void setDateOpened(Date dateOpened) {
		_dateOpened = dateOpened;
	}
	public Route getRoute() {
		return _route;
	}
	public void setRoute(Route route) {
		_route = route;
	}
	public String getColorCode() {
		return _colorCode;
	}
	public void setColorCode(String colorCode) {
		_colorCode = colorCode;
	}
	public String getPhoneNumber() {
		return _phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}
	public Location getLocation() {
		return _location;
	}
	public void setLocation(Location location) {
		_location = location;
	}
	
}
