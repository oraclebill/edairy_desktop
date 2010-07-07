package com.agritrace.edairy.desktop.finance.ui.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;

class TransactionJournalFilterBean {
	public Date endDate = null;
	public Membership member = null;
	public String referenceNumber = null;
	public final List<TransactionSource> sourceOptions = new ArrayList<TransactionSource>();
	public Date startDate = null;
	public final List<TransactionType> typeOptions = new ArrayList<TransactionType>();

	public TransactionJournalFilterBean() {
		clear();
	}

	public void clear() {
		final Calendar now = Calendar.getInstance();
		final Calendar nowMinusThirty = Calendar.getInstance();
		nowMinusThirty.add(Calendar.DAY_OF_YEAR, -30);

		startDate = now.getTime();
		endDate = nowMinusThirty.getTime();
		member = null;
		referenceNumber = "";
		typeOptions.clear();
		sourceOptions.clear();
	}

	public Date getEndDate() {
		return endDate;
	}

	public Membership getMember() {
		return member;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public List<TransactionSource> getSourceOptions() {
		return sourceOptions;
	}

	public Date getStartDate() {
		return startDate;
	}

	public List<TransactionType> getTypeOptions() {
		return typeOptions;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setMember(Membership member) {
		this.member = member;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public void setSourceOptions(List<TransactionSource> sourceOptions) {
		this.sourceOptions.clear();
		this.sourceOptions.addAll(sourceOptions);
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setTypeOptions(List<TransactionType> typeOptions) {
		this.typeOptions.clear();
		this.typeOptions.addAll(typeOptions);
	}
}