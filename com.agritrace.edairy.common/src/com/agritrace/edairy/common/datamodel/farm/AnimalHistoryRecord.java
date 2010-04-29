package com.agritrace.edairy.common.datamodel.farm;

import java.util.Date;

import javax.persistence.*;

@Entity
public class AnimalHistoryRecord {
	public enum State {
		CALF, PRODUCING, INACTIVE, SOLD, DECEASED
	}

	@Id
	private Long animalHistoryRecordId;
	private RegisteredAnimal registrationId;

	private State newStatus;
	@Temporal(TemporalType.DATE)
	private Date newStatusDate;
	private String statusInfo;

	public Long getAnimalHistoryRecordId() {
		return animalHistoryRecordId;
	}

	public void setAnimalHistoryRecordId(Long animalHistoryRecordId) {
		this.animalHistoryRecordId = animalHistoryRecordId;
	}

	public RegisteredAnimal getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(RegisteredAnimal registrationId) {
		this.registrationId = registrationId;
	}

	public State getNewStatus() {
		return newStatus;
	}

	public void setNewStatus(State newStatus) {
		this.newStatus = newStatus;
	}

	public Date getNewStatusDate() {
		return newStatusDate;
	}

	public void setNewStatusDate(Date newStatusDate) {
		this.newStatusDate = newStatusDate;
	}

	public String getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

}
