package com.agritrace.edairy.desktop.collection.ui.beans;

import java.util.Date;

import org.eclipse.riena.beans.common.AbstractBean;

import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.Route;

public class DeliveryJournalFilterBean extends AbstractBean {
	public static final String CUSTOMER = "filter-customer";
	public static final String END_DATE = "filter-max-date";
	public static final String ROUTE = "filter-route";
	public static final String START_DATE = "filter-min-date";

	private Customer customer;
	private Date maxDate;
	private Date minDate;
	private Route route;

	public Customer getCustomer() {
		return customer;
	}

	public Date getMaxDate() {
		return maxDate;
	}

	public Date getMinDate() {
		return minDate;
	}

	public Route getRoute() {
		return route;
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

	public void setRoute(Route route) {
		final Object old = this.route;
		this.route = route;
		firePropertyChanged(ROUTE, old, route);
	}
}