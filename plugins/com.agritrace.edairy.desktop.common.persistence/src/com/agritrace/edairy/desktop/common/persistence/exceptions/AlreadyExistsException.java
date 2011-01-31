package com.agritrace.edairy.desktop.common.persistence.exceptions;

public class AlreadyExistsException extends DaoPersistenceException {
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
