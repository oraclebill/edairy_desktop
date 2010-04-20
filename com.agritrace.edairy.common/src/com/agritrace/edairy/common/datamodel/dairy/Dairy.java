package com.agritrace.edairy.common.datamodel.dairy;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.agritrace.edairy.common.datamodel.common.Container;
import com.agritrace.edairy.common.datamodel.common.Location;
import com.agritrace.edairy.common.datamodel.security.SecurityRole;

@Entity
public class Dairy {
	
	// identification info
	private Long dairyId;

	private String name;
	
	// licensing info
	private String kdbLicenseNum;

	private Date kdbLicenseEffectiveDate;
	
	private Date kdbLicenseExpirationDate;

	// locations
	private Location primaryLocation;

	private Employee manager;
	
	private String publicDescription;
	
	private List<Employee> staff;
	
	private List<Membership> members;
	
	private List<SecurityRole> roles;
	
	private List<Route> routeDefinitions;
	
	private List<CollectionCentre> collectionCentres;
	
	private List<Vehicle> vehicles;
	
	private List<Container> bins;

	private String pin;
	private String nssfNumber;
	private String nhifNumber;

	
	@Id
	@GeneratedValue
	public Long getDairyId() {
		return dairyId;
	}

	public void setDairyId(Long dairyId) {
		this.dairyId = dairyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKdbLicenseNum() {
		return kdbLicenseNum;
	}

	public void setKdbLicenseNum(String kdbLicenseNum) {
		this.kdbLicenseNum = kdbLicenseNum;
	}

	@Temporal(value = TemporalType.DATE)
	public Date getKdbLicenseEffectiveDate() {
		return kdbLicenseEffectiveDate;
	}

	public void setKdbLicenseEffectiveDate(Date kdbLicenseEffectiveDate) {
		this.kdbLicenseEffectiveDate = kdbLicenseEffectiveDate;
	}

	@Temporal(value = TemporalType.DATE)
	public Date getKdbLicenseExpirationDate() {
		return kdbLicenseExpirationDate;
	}

	public void setKdbLicenseExpirationDate(Date kdbLicenseExpirationDate) {
		this.kdbLicenseExpirationDate = kdbLicenseExpirationDate;
	}

	public Location getPrimaryLocation() {
		return primaryLocation;
	}

	public void setPrimaryLocation(Location primaryLocation) {
		this.primaryLocation = primaryLocation;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public String getPublicDescription() {
		return publicDescription;
	}

	public void setPublicDescription(String publicDescription) {
		this.publicDescription = publicDescription;
	}

	public List<Employee> getEmployees() {
		return staff;
	}

	public void setStaff(List<Employee> staff) {
		this.staff = staff;
	}

	public List<Membership> getMembers() {
		return members;
	}

	public void setMembers(List<Membership> members) {
		this.members = members;
	}

	public List<SecurityRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SecurityRole> roles) {
		this.roles = roles;
	}

	public List<Route> getRoutes() {
		return routeDefinitions;
	}

	public void setRoutes(List<Route> routeDefinitions) {
		this.routeDefinitions = routeDefinitions;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public List<Container> getBins() {
		return bins;
	}

	public void setBins(List<Container> bins) {
		this.bins = bins;
	}
}
