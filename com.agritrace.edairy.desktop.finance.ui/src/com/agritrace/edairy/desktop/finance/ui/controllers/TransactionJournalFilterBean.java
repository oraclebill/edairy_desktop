package com.agritrace.edairy.desktop.finance.ui.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;

class TransactionJournalFilterBean {
	private Date startDate = null;
	private Date endDate = null;
	private Membership member = null;
	private String referenceNumber = null;
	private final List<TransactionSource> sourceOptions = TransactionSource.VALUES;
	private final Set<TransactionSource> sourceSelections = new HashSet<TransactionSource>();
	private final List<TransactionType> typeOptions = TransactionType.VALUES;
	private final Set<TransactionType> typeSelections = new HashSet<TransactionType>();
//	private TransactionSource transactionSource;
//	private TransactionType transactionType;

	/**
	 * 
	 */
	public TransactionJournalFilterBean() {
		clear();
	}

	/**
	 * 
	 */
	public void clear() {
		final Calendar now = Calendar.getInstance();
		final Calendar nowMinusThirty = Calendar.getInstance();
		nowMinusThirty.add(Calendar.DAY_OF_YEAR, -30);

		endDate = now.getTime();
		startDate = nowMinusThirty.getTime();

		member = null;
		referenceNumber = "";
		typeSelections.clear();
		sourceSelections.clear();
	}

	/**
	 * 
	 * @return
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * 
	 * @return
	 */
	public Membership getMember() {
		return member;
	}

	/**
	 * 
	 * @return
	 */
	public String getReferenceNumber() {
		return referenceNumber;
	}

	/**
	 * 
	 * @return
	 */
	public List<TransactionSource> getSourceOptions() {
		return sourceOptions;
	}

	/**
	 * 
	 * @return
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * 
	 * @return
	 */
	public List<TransactionType> getTypeOptions() {
		return typeOptions;
	}

	/**
	 * 
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * 
	 * @param member
	 */
	public void setMember(Membership member) {
		this.member = member;
	}

	/**
	 * 
	 * @param referenceNumber
	 */
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}


	/**
	 * 
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * 
	 * @return
	 */
	public Set<TransactionType> getTypeSelections() {
		return typeSelections;
	}
	
	/**
	 * 
	 * @param typeOptions
	 */
	public void setTypeSelections(Set<TransactionType> typeOptions) {
		this.typeSelections.clear();
		this.typeSelections.addAll(typeOptions);
	}
	
	/**
	 * 
	 * @return
	 */
	public Set<TransactionSource> getSourceSelections() {
		return sourceSelections;
	}
	
	/**
	 * 
	 * @param sources
	 */
	public void setSourceSelections(Set<TransactionSource> sources) {
		this.sourceSelections.clear();
		this.sourceSelections.addAll(sources);
	}
}