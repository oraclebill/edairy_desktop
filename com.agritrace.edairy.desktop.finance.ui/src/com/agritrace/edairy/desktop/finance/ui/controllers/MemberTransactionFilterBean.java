package com.agritrace.edairy.desktop.finance.ui.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;

class MemberTransactionFilterBean {
	public Date startDate = null;
	public Date endDate = null;
	public Membership member = null;
	public String referenceNumber = null;
	public final Set<TransactionType> typeOptions = new HashSet<TransactionType>();
	public final List<TransactionSource> sourceOptions = new ArrayList<TransactionSource>();

	public MemberTransactionFilterBean() {
		clear();
	}
	
	public void clear() {
		Calendar now = Calendar.getInstance();
		Calendar nowMinusThirty = Calendar.getInstance();
		nowMinusThirty.add(Calendar.DAY_OF_YEAR, -30);
		
		startDate = now.getTime();
		endDate = nowMinusThirty.getTime();
		member = null;
		referenceNumber = "";
		typeOptions.clear();
		sourceOptions.clear();
	}	

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Membership getMember() {
		return member;
	}

	public void setMember(Membership member) {
		this.member = member;
	}

	public Set<TransactionType> getTypeOptions() {
		return typeOptions;
	}

	public void setTypeOptions(Set<TransactionType> typeOptions) {
		this.typeOptions.clear();
		this.typeOptions.addAll(typeOptions);
	}

	public void setSourceOptions(List<TransactionSource> sourceOptions) {
		this.sourceOptions.clear();
		this.sourceOptions.addAll(sourceOptions);
	}

	public List<TransactionSource> getSourceOptions() {
		return sourceOptions;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
}