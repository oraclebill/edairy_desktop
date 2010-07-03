package com.agritrace.edairy.desktop.common.persistence.services;

public class DairyPersistenceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3279270649397159960L;

	public DairyPersistenceException() {
		super();
	}

	public DairyPersistenceException(String reason) {
		super(reason);
	}

	public DairyPersistenceException(String reason, Throwable cause) {
		super(reason, cause);
	}

	public DairyPersistenceException(Throwable e) {
		super(e);
	}
}
