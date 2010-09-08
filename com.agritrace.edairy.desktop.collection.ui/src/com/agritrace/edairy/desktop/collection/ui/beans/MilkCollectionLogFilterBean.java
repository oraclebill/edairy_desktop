package com.agritrace.edairy.desktop.collection.ui.beans;

import java.util.Date;
import java.util.List;

import org.eclipse.riena.beans.common.AbstractBean;

import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Session;

public class MilkCollectionLogFilterBean extends AbstractBean {
	public static final String END_DATE = "END_DATE";
	public static final String MPR_MISSING = "MPR_MISSING";
	public static final String REJECTED = "REJECTED";
	public static final String ROUTE = "ROUTE";
	public static final String START_DATE = "START_DATE";
	public static final String SUSPENDED = "SUSPENDED";
	public static final String STATUS = "STATUS";
	public static final String SESSION = "SESSION";
	
	public static final String ROUTES = "ROUTES";

	private Date endDate;
	private boolean mprMissing;
	private boolean rejected;
	private Route route;
	private List<Route> routes;
	private Date startDate;
	private boolean suspended;
	private JournalStatus status;
	private Session session;

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

	public JournalStatus getStatus() {
		return status;
	}

	public Session getSession() {
		return session;
	}

	public void setEndDate(Date endDate) {
		final Object oldVal = getEndDate();
		this.endDate = endDate;
		firePropertyChanged(END_DATE, oldVal, endDate);
	}

	public void setMprMissing(boolean mprMissing) {
		final Object oldVal = isMprMissing();
		this.mprMissing = mprMissing;
		firePropertyChanged(MPR_MISSING, oldVal, mprMissing);
	}

	public void setRejected(boolean rejected) {
		final Object oldVal = isRejected();
		this.rejected = rejected;
		firePropertyChanged(REJECTED, oldVal, rejected);
	}

	public void setRoute(Route route) {
		final Object oldVal = getRoute();
		this.route = route;
		firePropertyChanged(ROUTE, oldVal, route);
	}

	public void setRoutes(List<Route> routes) {
		final Object oldVal = getRoutes();
		this.routes = routes;
		firePropertyChanged(ROUTES, oldVal, rejected);
	}

	public void setStartDate(Date startDate) {
		final Object oldVal = getStartDate();
		this.startDate = startDate;
		firePropertyChanged(START_DATE, oldVal, startDate);
	}

	public void setSuspended(boolean suspended) {
		final Object oldVal = isSuspended();
		this.suspended = suspended;
		firePropertyChanged(SUSPENDED, oldVal, suspended);
	}

	public void setStatus(JournalStatus status) {
		final Object oldVal = getStatus();
		this.status = status;
		firePropertyChanged(STATUS, oldVal, status);
	}
	
	public void setSession(Session session) {
		final Object oldVal = getSession();
		this.session = session;
		firePropertyChanged(SESSION, oldVal, this.session);
	}

}
