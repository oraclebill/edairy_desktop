package com.agritrace.edairy.common.datamodel.dairy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.*;

import com.agritrace.edairy.common.datamodel.common.Container;
import com.agritrace.edairy.common.datamodel.common.Location;
import com.agritrace.edairy.common.datamodel.security.SecurityRole;

@Entity
public class Dairy {
	
	// identification info
	@Id
	@GeneratedValue
	private Long dairyId;

	private String name;
	
	// licensing info
	private String kdbLicenseNum;

	@Temporal(value = TemporalType.DATE)
	private Date kdbLicenseEffectiveDate;
	
	@Temporal(value = TemporalType.DATE)
	private Date kdbLicenseExpirationDate;

	// locations
	private Location primaryLocation = new Location();

	@OneToOne
	private Employee manager;
	
	private String publicDescription;
	private String pin;
	private String nssfNumber;
	private String nhifNumber;
    	
	@OneToMany
	private List<Employee> employees = new ArrayList<Employee>();
	
	@OneToMany
	private List<Membership> members = new ArrayList<Membership>();
	
	@OneToMany
	private List<SecurityRole> roles = new ArrayList<SecurityRole>();
	
	@OneToMany
	private List<Route> routeDefinitions = new ArrayList<Route>();
	
	@OneToMany
	private List<DairyLocation> collectionCentres = new ArrayList<DairyLocation>();
	
	@OneToMany
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	@OneToMany
	private List<Container> bins = new ArrayList<Container>();

    private List<String> transactionSources = new ArrayList<String>();
	
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

	public Date getKdbLicenseEffectiveDate() {
		return kdbLicenseEffectiveDate;
	}

	public void setKdbLicenseEffectiveDate(Date kdbLicenseEffectiveDate) {
		this.kdbLicenseEffectiveDate = kdbLicenseEffectiveDate;
	}

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
		return employees;
	}
	
	public void addEmployee(Employee emp) {
		employees.add(emp);
	}

	public List<Membership> getMembers() {
		return members;
	}

	public List<SecurityRole> getRoles() {
		return roles;
	}

	public List<Route> getRoutes() {
		return routeDefinitions;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public List<Container> getBins() {
		return bins;
	}

	public List<Route> getRouteDefinitions() {
		return routeDefinitions;
	}

	public List<DairyLocation> getCollectionCentres() {
		return collectionCentres;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getNssfNumber() {
		return nssfNumber;
	}

	public void setNssfNumber(String nssfNumber) {
		this.nssfNumber = nssfNumber;
	}

	public String getNhifNumber() {
		return nhifNumber;
	}

	public void setNhifNumber(String nhifNumber) {
		this.nhifNumber = nhifNumber;
	}

	public List<String> getTransactionSources() {
		return transactionSources;
	}

	public void setTransactionSources(List<String> transactionSources) {
		this.transactionSources = transactionSources;
	}

}