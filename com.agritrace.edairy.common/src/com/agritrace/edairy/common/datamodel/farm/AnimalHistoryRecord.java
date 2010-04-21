package com.agritrace.edairy.common.datamodel.farm;

import java.util.Date;

public class AnimalHistoryRecord {
	public enum State { CALF, PRODUCING, INACTIVE, SOLD, DECEASED }
	
	private Long _animalHistoryRecordId;
	private AnimalRegistration _registrationId;
	
	private State _newStatus;
	private Date _newStatusDate;
	private String _statusInfo;
	
}
