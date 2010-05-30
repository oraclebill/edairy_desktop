package com.agritrace.edairy.desktop.common.persistence.services;

public class AlreadyExistsException extends DairyPersistenceException {
	public AlreadyExistsException() {
		super();
	}
	
	public AlreadyExistsException(String reason) {
		super(reason);
	}
}
