package com.agritrace.edairy.desktop.collection.ui.components.validators;

class ValidationError extends Error {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public ValidationError() {
		super();
	}

	public ValidationError(String s) {
		super(s);
	}
}