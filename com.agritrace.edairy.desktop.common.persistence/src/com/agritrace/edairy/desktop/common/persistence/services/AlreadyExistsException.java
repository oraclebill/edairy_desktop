package com.agritrace.edairy.desktop.common.persistence.services;

public class AlreadyExistsException extends DairyPersistenceException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -178793147741752677L;

	public AlreadyExistsException() {
		super();
	}
	
	public AlreadyExistsException(String reason) {
		super(reason);
	}
}
