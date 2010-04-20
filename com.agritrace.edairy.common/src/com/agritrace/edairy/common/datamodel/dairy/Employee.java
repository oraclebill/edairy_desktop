package com.agritrace.edairy.common.datamodel.dairy;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.agritrace.edairy.common.datamodel.common.Person;

@Entity
public class Employee {
	
	private Long employmentRelationshipId;
	private Person employee;
	private Date startDate;
	private Date endDate;
	private String jobFunction;
	private Long previousEmpId;
	
	@Id
	@GeneratedValue
	public Long getEmploymentRelationshipId() {
		return employmentRelationshipId;
	}

	public void setEmploymentRelationshipId(Long employmentRelationshipId) {
		this.employmentRelationshipId = employmentRelationshipId;
	}

	public Person getEmployee() {
		return employee;
	}

	public void setEmployee(Person employee) {
		this.employee = employee;
	}

	@Temporal(value = TemporalType.DATE)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(value = TemporalType.DATE)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getJobFunction() {
		return jobFunction;
	}

	public void setJobFunction(String jobFunction) {
		this.jobFunction = jobFunction;
	}

	public Long getPreviousEmpId() {
		return previousEmpId;
	}

	public void setPreviousEmpId(Long previousEmpId) {
		this.previousEmpId = previousEmpId;
	}


}
