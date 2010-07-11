package com.agritrace.edairy.desktop.collections.scaledata.beans;

public class RawScaleRecord {

	public static class ValidationException extends Exception {

		public ValidationException() {
			super();
		}

		public ValidationException(String message, Throwable cause) {
			super(message, cause);
		}

		public ValidationException(String message) {
			super(message);
		}

		public ValidationException(Throwable cause) {
			super(cause);
		}
		
	}
	
	private static final int BASE = 0;
	public static final int TRANSACTION_DATE = BASE;
	public static final int TRANSACTION_TIME = BASE + 1;
	public static final int DAIRY_CODE = BASE + 2;
	public static final int SCALE_SERIAL = BASE + 3;
	public static final int OPERATOR_CODE = BASE + 4;
	public static final int TRIP_NUMBER = BASE + 5;
	public static final int SESSION_CODE = BASE + 6;
	public static final int ROUTE_NUMBER = BASE + 7;
	public static final int CENTER_NUMBER = BASE + 8;
	public static final int MEMBER_NUMBER = BASE + 9;
	public static final int QUANTITY = BASE + 10;
	public static final int ATTR_COUNT = BASE + 11;

	private String[] attributes = new String[ATTR_COUNT];
	boolean valid;

	protected String getAttr(int attr) {
		assert (attr < ATTR_COUNT);
		return attributes[attr];
	}

	protected void setAttr(int attr, String s) {
		assert (attr < ATTR_COUNT);
		attributes[attr] = s;
	}

	public RawScaleRecord() {
	}

	public void init(String transactionDate, String transactionTime, String dairyCode, String scaleSerial,
			String operatorCode, String tripNumber, String sessionCode, String routeNumber, String centerNumber,
			String memberNumber, String quantity) {
		String params[] = new String[] { transactionDate, transactionTime, dairyCode, scaleSerial, operatorCode,
				tripNumber, sessionCode, routeNumber, centerNumber, memberNumber, quantity };

		assert (params.length == ATTR_COUNT);
		for (int i = 0; i < ATTR_COUNT; i++) {
			setAttr(i, params[i]);
		}

		validate();
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	/**
	 * Base simply checks that all attributes have been set. 
	 * 
	 * Subclasses should override to perform more meaningful validation.
	 */
	protected void validate()  {
		boolean valid = true;
		for (int i = 0; i < ATTR_COUNT; i++) {
			valid = getAttr(i) != null;
			if (getAttr(i) == null) {
				setValid(false);
			}
		}
		setValid(valid);
	}

	public String getTransactionDate() {
		return getAttr(TRANSACTION_DATE);
	}

	public void setTransactionDate(String transactionDate) {
		setAttr(TRANSACTION_DATE, transactionDate);
	}

	public String getTransactionTime() {
		return getAttr(TRANSACTION_TIME);
	}

	public void setTransactionTime(String transactionTime) {
		setAttr(TRANSACTION_TIME, transactionTime);
	}

	public String getDairyCode() {
		return getAttr(DAIRY_CODE);
	}

	public void setDairyCode(String dairyCode) {
		setAttr(DAIRY_CODE, dairyCode);
	}

	public String getScaleSerial() {
		return getAttr(SCALE_SERIAL);
	}

	public void setScaleSerial(String scaleSerial) {
		setAttr(SCALE_SERIAL, scaleSerial);
	}

	public String getOperatorCode() {
		return getAttr(OPERATOR_CODE);
	}

	public void setOperatorCode(String operatorCode) {
		setAttr(OPERATOR_CODE, operatorCode);
	}

	public String getTripNumber() {
		return getAttr(TRIP_NUMBER);
	}

	public void setTripNumber(String tripNumber) {
		setAttr(TRIP_NUMBER, tripNumber);
	}

	public String getSessionCode() {
		return getAttr(SESSION_CODE);
	}

	public void setSessionCode(String sessionCode) {
		setAttr(SESSION_CODE, sessionCode);
	}

	public String getRouteNumber() {
		return getAttr(ROUTE_NUMBER);
	}

	public void setRouteNumber(String routeNumber) {
		setAttr(ROUTE_NUMBER, routeNumber);
	}

	public String getCenterNumber() {
		return getAttr(CENTER_NUMBER);
	}

	public void setCenterNumber(String centerNumber) {
		setAttr(CENTER_NUMBER, centerNumber);
	}

	public String getMemberNumber() {
		return getAttr(MEMBER_NUMBER);
	}

	public void setMemberNumber(String memberNumber) {
		setAttr(MEMBER_NUMBER, memberNumber);
	}

	public String getQuantity() {
		return getAttr(QUANTITY);
	}

	public void setQuantity(String quantity) {
		setAttr(QUANTITY, quantity);
	}

}
