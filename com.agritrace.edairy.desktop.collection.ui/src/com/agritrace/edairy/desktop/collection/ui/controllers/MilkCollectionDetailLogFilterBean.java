package com.agritrace.edairy.desktop.collection.ui.controllers;

import org.eclipse.riena.beans.common.AbstractBean;

public class MilkCollectionDetailLogFilterBean extends AbstractBean {
	private static final String PROP_PAGE_NUMBER = "page-number";
	
	private int pageNumber = 1;
	
	public MilkCollectionDetailLogFilterBean() {
		
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		Object oldVal = this.pageNumber;
		this.pageNumber = pageNumber;
		firePropertyChanged(PROP_PAGE_NUMBER, oldVal, pageNumber);
	}
}
