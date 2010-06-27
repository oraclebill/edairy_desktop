package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.Date;

import org.eclipse.riena.beans.common.AbstractBean;

import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.Route;

public class DeliveryJournalFilterBean extends AbstractBean {
	public static final String START_DATE = "filter-min-date";
	public static final String END_DATE = "filter-max-date";
	public static final String ROUTE = "filter-route";
	public static final String CUSTOMER = "filter-customer";

	private Date minDate;
	private Date maxDate;
	private Route route;
	private Customer customer;

	public Date getMinDate() {
		return minDate;
	}

	public void setMinDate(Date minDate) {
		Object old = this.minDate;
		this.minDate = minDate;
		firePropertyChanged(START_DATE, old, minDate);
	}

	public Date getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(Date maxDate) {
		Object old = this.maxDate;
		this.maxDate = maxDate;
		firePropertyChanged(END_DATE, old, maxDate);
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		Object old = this.route;
		this.route = route;
		firePropertyChanged(ROUTE, old, route);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		Object old = this.customer;
		this.customer = customer;
		firePropertyChanged(CUSTOMER, old, customer);
	}
}