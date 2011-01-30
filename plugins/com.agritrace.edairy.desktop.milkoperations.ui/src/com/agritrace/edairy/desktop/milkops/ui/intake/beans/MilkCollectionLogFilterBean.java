package com.agritrace.edairy.desktop.milkops.ui.intake.beans;

import java.util.Date;

import org.eclipse.riena.beans.common.AbstractBean;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;

public class MilkCollectionLogFilterBean extends AbstractBean {
	public static final String END_DATE = "END_DATE";
	public static final String MPR_MISSING = "MPR_MISSING";
	public static final String REJECTED = "REJECTED";
	public static final String COLLECTION_CENTER = "COLLECTION_CENTER";
	public static final String START_DATE = "START_DATE";
	public static final String SUSPENDED = "SUSPENDED";
	public static final String STATUS = "STATUS";
	public static final String SESSION = "SESSION";

	public static final String ROUTES = "ROUTES";

	private Date endDate;
	private boolean mprMissing;
	private boolean rejected;
	private Date startDate;
	private boolean suspended;
	private JournalStatus status;
	private CollectionSession session;
	private DairyLocation collectionCenter;

	public Date getEndDate() {
		return endDate;
	}

	public DairyLocation getCollectionCenter() {
		return collectionCenter;
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

	public CollectionSession getSession() {
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

	public void setCollectionCenter(DairyLocation center) {
		final Object oldVal = getCollectionCenter();
		this.collectionCenter = center;
		firePropertyChanged(COLLECTION_CENTER, oldVal, center);
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

	public void setSession(CollectionSession session) {
		final Object oldVal = getSession();
		this.session = session;
		firePropertyChanged(SESSION, oldVal, this.session);
	}

}
