package com.agritrace.edairy.common.datamodel.dairy;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.agritrace.edairy.common.datamodel.common.Location;
import com.agritrace.edairy.common.datamodel.common.Person;

@Entity
public class Supplier {

	public enum SupplierStatus {
		PENDING, ACTIVE, CANCELLED, EXPIRED, OTHER
	}

	private Long _supplierId;
	private String _name;
	private Location _location;
	private SupplierStatus _status;
	private String _category;
	private List<Person> _contacts;
	private String _description;
	private Date _effectiveDate;
	private Long _contractDuration;

	@Id
	@GeneratedValue
	public Long getSupplierId() {
		return _supplierId;
	}

	public void setSupplierId(Long supplierId) {
		_supplierId = supplierId;
	}

	@Temporal(TemporalType.DATE)
	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		_effectiveDate = effectiveDate;
	}

	public Long getContractDuration() {
		return _contractDuration;
	}

	public void setContractDuration(Long contractDuration) {
		_contractDuration = contractDuration;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	@ManyToMany
	public List<Person> getContacts() {
		return _contacts;
	}

	public void setContacts(List<Person> contacts) {
		_contacts = contacts;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public SupplierStatus getStatus() {
		return _status;
	}

	public void setStatus(SupplierStatus status) {
		_status = status;
	}

}
