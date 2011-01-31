package com.agritrace.edairy.desktop.common.persistence.exceptions;

public class DaoPersistenceException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public DaoPersistenceException() {
		super();
	}

	public DaoPersistenceException(String reason) {
		super(reason);
	}

	public DaoPersistenceException(String reason, Throwable cause) {
		super(reason, cause);
	}

	public DaoPersistenceException(Throwable e) {
		super(e);
	}
	}
