package com.agritrace.edairy.desktop.common.model.persistence.services;

public class AlreadyExistsException extends Exception {
	public AlreadyExistsException() {
		super();
	}
	
	public AlreadyExistsException(String reason) {
		super(reason);
	}
}
