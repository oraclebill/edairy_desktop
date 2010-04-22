package com.agritrace.edairy.common.datamodel.farm;

import java.util.Date;

import javax.persistence.*;

@Entity
public class AnimalHistoryRecord {
	public enum State { CALF, PRODUCING, INACTIVE, SOLD, DECEASED }
	
	@Id
	private Long _animalHistoryRecordId;
	private AnimalRegistration _registrationId;
	
	private State _newStatus;
	@Temporal(TemporalType.DATE)
	private Date _newStatusDate;
	private String _statusInfo;
	
}
