package com.agritrace.edairy.desktop.collections.scaledata.beans;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScaleRecord extends RawScaleRecord {

//	private static final DateFormat DATEFORMAT = DateFormat.getDateTimeInstance(
//			DateFormat.SHORT, DateFormat.SHORT, Locale.UK);
	private static final DateFormat DATEFORMAT = new SimpleDateFormat("dd/MM/yyyy");

	private Date date = null;
	private BigDecimal validQuantity;

	public ScaleRecord() {

	}

	@Override
	protected void validate() {
		super.validate();
		
		if (isValid()) {
			String dateString = getTransactionDate() + " " + getTransactionTime();
			try {				
				setValidDate(DATEFORMAT.parse(dateString));
			} catch (ParseException pe) {
				System.err.println("Error parsing date " + dateString);
				setValid(false);
			}
			
			try {
				setValidQuantity(new BigDecimal(getQuantity()));
			} catch (NumberFormatException nfe) {
				setValid(false);
			}
		}
	}

	public void setValidQuantity(BigDecimal validQuantity) {
		this.validQuantity = validQuantity;
	}
	
	public BigDecimal getValidQuantity() {
		return validQuantity;
	}

	public void setValidDate(Date date) {
		this.date = date;		
	}
	
	public Date getValidDate() {
		return date;
	}
	

}
