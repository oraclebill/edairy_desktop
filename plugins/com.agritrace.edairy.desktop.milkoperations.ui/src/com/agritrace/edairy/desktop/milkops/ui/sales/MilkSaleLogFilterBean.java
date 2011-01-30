package com.agritrace.edairy.desktop.milkops.ui.sales;

import java.util.Date;

import org.eclipse.riena.beans.common.AbstractBean;

import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;

public class MilkSaleLogFilterBean extends AbstractBean {
	public static final String CUSTOMER = "customer";
	public static final String STORE = "store";
	public static final String START_DATE = "minDate";
	public static final String END_DATE = "maxDate";

	private Date maxDate;
	private Date minDate;
	private Customer customer;
	private DairyLocation store;

	public Customer getCustomer() {
		return customer;
	}

	public Date getMaxDate() {
		return maxDate;
	}

	public Date getMinDate() {
		return minDate;
	}

	public DairyLocation getStore() {
		return store;
	}

	public void setCustomer(Customer customer) {
		final Object old = this.customer;
		this.customer = customer;
		firePropertyChanged(CUSTOMER, old, customer);
	}

	public void setMaxDate(Date maxDate) {
		final Object old = this.maxDate;
		this.maxDate = maxDate;
		firePropertyChanged(END_DATE, old, maxDate);
	}

	public void setMinDate(Date minDate) {
		final Object old = this.minDate;
		this.minDate = minDate;
		firePropertyChanged(START_DATE, old, minDate);
	}

	public void setStore(DairyLocation route) {
		final Object old = this.store;
		this.store = route;
		firePropertyChanged(STORE, old, route);
	}
}