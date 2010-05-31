package com.agritrace.edairy.desktop.common.persistence.services;

public class DairyPersistenceException extends RuntimeException {

	public DairyPersistenceException() {
		super();
	}

	public DairyPersistenceException(String reason) {
		super(reason);
	}

	public DairyPersistenceException(Throwable e) {
		super(e);
	}
	
	public DairyPersistenceException(String reason, Throwable cause) {
		super(reason, cause);
	}
}
