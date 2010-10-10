package com.agritrace.edairy.desktop.birt.data;

import java.util.Date;
import java.text.SimpleDateFormat;

public class YearReportData {
	private Date date;
	private String productionString;
	private String changeString;
	private SimpleDateFormat format = new SimpleDateFormat("yyyy");

	public YearReportData(Date date, String productionString, String changeString) {
		super();
		this.date = date;
		this.productionString = productionString;
		this.changeString = changeString;
	}

	public String getProductionString() {
		return productionString;
	}

	public Date getDate() {
		return date;
	}

	public String getDateString() {
		return "" + getDate();
	}

	public String getYearString(){		
		Date date = getDate();
		if(date != null){
			String year = this.format.format(getDate());
			return year;
		}
		return "0";
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setProductionString(String productionString) {
		this.productionString = productionString;
	}

	public String getChangeString() {
		return changeString;
	}

	public void setChangeString(String changeString) {
		this.changeString = changeString;
	}

}
