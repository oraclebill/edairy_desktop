package com.agritrace.edairy.common.datamodel.dairy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class CollectionJournal {
	
	private Long _id;
	private Date _entryDate;
	private Employee _entryClerk;
	private String _referenceNumber;
	
	private Employee _driver;
	private Date _journalDate;
	private Route _route;
	private Vehicle _vehicle;
	private String _session;
	private BigDecimal _journalTotal;
	private boolean _flagged;           // tbd - should be "suspended" 
	private List<CollectionRecord> _entries;
	
	@Id @GeneratedValue
	public Long getId() {
		return _id;
	}
	public void setId(Long id) {
		_id = id;
	}
	@Temporal(TemporalType.DATE)
	public Date getEntryDate() {
		return _entryDate;
	}
	public void setEntryDate(Date entryDate) {
		_entryDate = entryDate;
	}
	public Employee getEntryClerk() {
		return _entryClerk;
	}
	public void setEntryClerk(Employee entryClerk) {
		_entryClerk = entryClerk;
	}
	public String getReferenceNumber() {
		return _referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		_referenceNumber = referenceNumber;
	}
	public Employee getDriver() {
		return _driver;
	}
	public void setDriver(Employee driver) {
		_driver = driver;
	}
	@Temporal(TemporalType.DATE)
	public Date getJournalDate() {
		return _journalDate;
	}
	public void setJournalDate(Date journalDate) {
		_journalDate = journalDate;
	}
	public Route getRoute() {
		return _route;
	}
	public void setRoute(Route route) {
		_route = route;
	}
	public Vehicle getVehicle() {
		return _vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		_vehicle = vehicle;
	}
	public String getSession() {
		return _session;
	}
	public void setSession(String session) {
		_session = session;
	}
	public BigDecimal getJournalTotal() {
		return _journalTotal;
	}
	public void setJournalTotal(BigDecimal journalTotal) {
		_journalTotal = journalTotal;
	}
	public boolean isFlagged() {
		return _flagged;
	}
	public void setFlagged(boolean flagged) {
		_flagged = flagged;
	}
	public List<CollectionRecord> getEntries() {
		return _entries;
	}
	public void setEntries(List<CollectionRecord> entries) {
		_entries = entries;
	}	
}
