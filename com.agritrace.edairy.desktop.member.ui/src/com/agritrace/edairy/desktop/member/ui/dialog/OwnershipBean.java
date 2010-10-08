package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.riena.beans.common.AbstractBean;

public class OwnershipBean extends AbstractBean {
	public static final String PROP_OWNERNAME = "ownerName";


	private String ownerName;
	private final int index;

	public OwnershipBean(int index, String ownerName) {
		this.index = index;
		this.ownerName = ownerName;

	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		final String oldValue = this.ownerName;
		this.ownerName = ownerName;
		firePropertyChanged(PROP_OWNERNAME, oldValue, ownerName);

	}

	public int getIndex() {
		return index;
	}
}

