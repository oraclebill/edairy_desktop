package com.agritrace.edairy.desktop.finance.ui.paymentrequest;

import java.util.Calendar;
import java.util.Date;

import org.eclipse.core.runtime.Assert;

class PaymentPeriod {

	private Frequency periodType = Frequency.MONTHLY;
	private int periodNum;
	private int year;

	public Frequency getPeriodType() {
		return periodType;
	}

	public void setPeriodType(Frequency periodType) {
		this.periodType = periodType;
	}

	public int getPeriodNum() {
		return periodNum;
	}

	public void setPeriodNum(int periodNum) {
		Assert.isLegal(periodNum < periodType.timesPerYear && periodNum >= 0);
		this.periodNum = periodNum;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	private static final int[] CALENDAR_FIELDS = new int[] { Calendar.DAY_OF_MONTH, Calendar.HOUR, Calendar.MINUTE,
			Calendar.SECOND, Calendar.MILLISECOND };

	public Date getStartDate() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, getYear());
		switch (getPeriodType()) {
		case WEEKLY:
			cal.set(Calendar.WEEK_OF_YEAR, getPeriodNum() - 1);
			break;
		case BIWEEKLY:
			cal.set(Calendar.WEEK_OF_YEAR, (getPeriodNum() - 1) * 2);
			break;
		case MONTHLY:
			cal.set(Calendar.MONTH, getPeriodNum());
			break;
		default:
			throw new IllegalStateException("Period type not set.");
		}

		for (int field : CALENDAR_FIELDS) {
			cal.set(field, cal.getActualMinimum(field));
		}
		return cal.getTime();
	}

	public Date getEndDate() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, getYear());
		switch (getPeriodType()) {
		case WEEKLY:
			cal.set(Calendar.WEEK_OF_YEAR, getPeriodNum());
			break;
		case BIWEEKLY:
			cal.set(Calendar.WEEK_OF_YEAR, getPeriodNum() * 2 + 1);
			break;
		case MONTHLY:
			cal.set(Calendar.MONTH, getPeriodNum());
			break;
		default:
			throw new IllegalStateException("Period type not set.");
		}
		for (int field : CALENDAR_FIELDS) {
			cal.set(field, cal.getActualMaximum(field));
		}
		return cal.getTime();
	}

	public String toString() {
		return String.format("%1$tb-%1$te-%1$tY - %2$tb-%2$te-%2$tY", getStartDate(), getEndDate());
	}

}