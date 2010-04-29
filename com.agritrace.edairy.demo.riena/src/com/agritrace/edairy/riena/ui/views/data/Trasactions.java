package com.agritrace.edairy.riena.ui.views.data;

import java.util.Date;

import org.eclipse.riena.beans.common.AbstractBean;

public class Trasactions extends AbstractBean {

	public static String PROPERTY_DATE = "date";
	public static String PROPERTY_TYPE = "type";
	public static String PROPERTY_DESCRIPTION = "description";
	public static String PROPERTY_AMOUNT = "amount";

	private Date date;
	private String type;
	private String description;
	private double amount;

	public Trasactions() {
		date = new Date();
		type = "";
		description = "";
		amount = 0.0;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Trasactions other = (Trasactions) obj;
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (date != other.date) {
			return false;
		}

		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}

		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}

		if (amount != other.amount) {
			return false;
		}

		return true;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
