package com.agritrace.edairy.desktop.collection.ui.beans;

import java.util.Date;
import java.util.List;

import org.eclipse.riena.beans.common.AbstractBean;

import com.agritrace.edairy.desktop.common.model.dairy.Route;

public class MilkCollectionLogFilterBean extends AbstractBean {
	public static final String END_DATE = "END_DATE";
	public static final String MPR_MISSING = "MPR_MISSING";
	public static final String REJECTED = "REJECTED";
	public static final String ROUTE = "ROUTE";
	public static final String START_DATE = "START_DATE";
	public static final String SUSPENDED = "SUSPENDED";
	private static final String ROUTES = "ROUTES";

	private Date endDate;
	private boolean mprMissing;
	private boolean rejected;
	private Route route;
	private List<Route> routes;
	private Date startDate;
	private boolean suspended;

	public Date getEndDate() {
		return endDate;
	}

	public Route getRoute() {
		return route;
	}

	public List<Route> getRoutes() {
		return this.routes;
	}

	public Date getStartDate() {
		return startDate;
	}

	public boolean isMprMissing() {
		return mprMissing;
	}

	public boolean isRejected() {
		return rejected;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void setEndDate(Date endDate) {
		final Object oldVal = this.endDate;
		this.endDate = endDate;
		firePropertyChanged(END_DATE, oldVal, endDate);
	}

	public void setMprMissing(boolean mprMissing) {
		final Object oldVal = this.mprMissing;
		this.mprMissing = mprMissing;
		firePropertyChanged(MPR_MISSING, oldVal, mprMissing);
	}

	public void setRejected(boolean rejected) {
		final Object oldVal = this.rejected;
		this.rejected = rejected;
		firePropertyChanged(REJECTED, oldVal, rejected);
	}

	public void setRoute(Route route) {
		final Object oldVal = this.route;
		this.route = route;
		firePropertyChanged(ROUTE, oldVal, route);
	}

	public void setRoutes(List<Route> routes) {
		final Object oldVal = this.routes;
		this.routes = routes;
		firePropertyChanged(ROUTES, oldVal, rejected);
	}

	public void setStartDate(Date startDate) {
		final Object oldVal = this.startDate;
		this.startDate = startDate;
		firePropertyChanged(START_DATE, oldVal, startDate);
	}

	public void setSuspended(boolean suspended) {
		final Object oldVal = this.suspended;
		this.suspended = suspended;
		firePropertyChanged(SUSPENDED, oldVal, suspended);
	}

}
