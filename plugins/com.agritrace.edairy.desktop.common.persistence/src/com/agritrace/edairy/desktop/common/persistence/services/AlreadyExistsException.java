package com.agritrace.edairy.desktop.common.persistence.services;

public class AlreadyExistsException extends DairyPersistenceException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public AlreadyExistsException() {
		super();
	}

	public AlreadyExistsException(String reason) {
		super(reason);
	}
}