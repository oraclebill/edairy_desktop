package com.agritrace.edairy.common.model.dairy;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;

import com.agritrace.edairy.common.model.core.Location;
import org.eclipse.persistence.annotations.JoinFetch;
import static org.eclipse.persistence.annotations.JoinFetchType.INNER;
import static org.eclipse.persistence.annotations.JoinFetchType.OUTER;
import org.eclipse.persistence.annotations.PrivateOwned;
import static javax.persistence.CascadeType.ALL;

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
	
	private List<Route> routes;
	
	private List<Vehicle> vehicles;
	
	private List<Container> bins;

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

	public List<Employee> getStaff() {
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
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
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
