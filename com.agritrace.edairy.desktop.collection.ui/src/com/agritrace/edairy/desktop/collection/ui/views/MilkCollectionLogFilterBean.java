package com.agritrace.edairy.desktop.collection.ui.views;

import java.util.Date;
import java.util.List;

import org.eclipse.riena.beans.common.AbstractBean;

import com.agritrace.edairy.desktop.common.model.dairy.Route;

public class MilkCollectionLogFilterBean extends AbstractBean {
	public static final String START_DATE = "START_DATE";
	public static final String END_DATE = "END_DATE";
	public static final String ROUTE = "ROUTE";
	public static final String MPR_MISSING = "MPR_MISSING";
	public static final String SUSPENDED = "SUSPENDED";
	public static final String REJECTED = "REJECTED";
	private static final String ROUTES = "ROUTES";

	private Date startDate;
	private Date endDate;
	private Route route;
	private boolean mprMissing;
	private boolean suspended;
	private boolean rejected;
	private List<Route> routes;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		Object oldVal = this.startDate;
		this.startDate = startDate;
		firePropertyChanged(START_DATE, oldVal, startDate);
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		Object oldVal = this.endDate;
		this.endDate = endDate;
		firePropertyChanged(START_DATE, oldVal, endDate);
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		Object oldVal = this.route;
		this.route = route;
		firePropertyChanged(START_DATE, oldVal, route);
	}

	public boolean isMprMissing() {
		return mprMissing;
	}

	public void setMprMissing(boolean mprMissing) {
		Object oldVal = this.mprMissing;
		this.mprMissing = mprMissing;
		firePropertyChanged(START_DATE, oldVal, mprMissing);
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void setSuspended(boolean suspended) {
		Object oldVal = this.suspended;
		this.suspended = suspended;
		firePropertyChanged(START_DATE, oldVal, suspended);
	}

	public boolean isRejected() {
		return rejected;
	}

	public void setRejected(boolean rejected) {
		Object oldVal = this.rejected;
		this.rejected = rejected;
		firePropertyChanged(START_DATE, oldVal, rejected);
	}

	public List<Route> getRoutes() {
		return this.routes;
	}
	
	public void setRoutes(List<Route> routes) {
		Object oldVal = this.routes;
		this.routes = routes;
		firePropertyChanged(ROUTES, oldVal, rejected);
	}

}
