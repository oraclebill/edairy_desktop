package com.agritrace.edairy.desktop.collections.scaledata.beans;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ScaleRecord extends RawScaleRecord {
//	public static final String  DEFAULT_DATE_PATTERN = "dd/MM/YYYY";
//		public static final DateFormat DATE_FORMAT = new SimpleDateFormat(DEFAULT_DATE_PATTERN);

//	private static final DateFormat DATEFORMAT = DateFormat.getDateInstance(
//			DateFormat.SHORT, Locale.UK);
	private static final DateFormat DATEFORMAT = new SimpleDateFormat("dd/MM/yy");
	private static final DateFormat DATETIMEFORMAT = new SimpleDateFormat("dd/MM/yy HH:mm a");

	private Date validDate = null;
	private BigDecimal validQuantity;

	private Date validDateTime;

	public ScaleRecord() {

	}

	@Override
	public void convertValues() {
		try {				
			setValidDate(DATEFORMAT.parse(getTransactionDate()));
		} catch (ParseException pe) {
			System.err.println("Error parsing date " + getTransactionDate());
			setValid(false);
		}
		
		String dateTimeString = getTransactionDate() + " " + getTransactionTime() + " " + getSessionCode();
		try {
			setValidDateTime(DATETIMEFORMAT.parse(dateTimeString));
		}
		catch(ParseException pe) {
			System.err.println("Error parsing datetime " + dateTimeString);
		}
		
		try {
			setValidQuantity(new BigDecimal(getQuantity()));
		} catch (NumberFormatException nfe) {
			setValid(false);
		}
	}

	public void setValidDateTime(Date parse) {
		this.validDateTime = parse;
	}

	public Date getValidDateTime() {
		return this.validDateTime;
	}
	
	
	public void setValidQuantity(BigDecimal validQuantity) {
		this.validQuantity = validQuantity;
	}
	
	public BigDecimal getValidQuantity() {
		return validQuantity;
	}

	public void setValidDate(Date date) {
		this.validDate = date;		
	}
	
	public Date getValidDate() {
		return this.validDate;
	}
	
	public String getValidMember() {
		// TODO: implement
		return getMemberNumber();
	}
	public String toString() {
		StringBuffer buf = new StringBuffer(super.toString());
		buf.append("\n");
		buf.append("isValid: " ).append( isValid() ).append(", ");
		buf.append("validDate: " ).append( getValidDate() ).append(", ");
		buf.append("validMember: " ).append( getValidMember() ).append(", ");
		buf.append("validQuantity: " ).append( getValidQuantity() ).append(", ");
		return buf.toString();
	}

}
