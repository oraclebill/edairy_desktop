package com.agritrace.edairy.desktop.finance.payments;

import java.math.BigDecimal;
import java.util.Date;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;

public class PaymentRecord {
	private int year, month;
	private Long transactionId;
	private Date transactionDate;
	private Membership member;
	private BigDecimal payableMilkQuantity;
	private BigDecimal paymentRate;
	private BigDecimal milkIncome;
	private BigDecimal accountCredits;
	private BigDecimal accountAdjustments;
	private BigDecimal totalPayment;
	private BigDecimal startingBalance;

	public PaymentRecord(Long transactionId, Date transactionDate, Membership member, BigDecimal amount) {
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.member = member;
		this.totalPayment = amount;

	}

	public PaymentRecord(Membership member, int priceMonth, int priceYear) {
		this.member = member;
		this.month = priceMonth;
		this.year = priceYear;
	}

	/**
	 * @return the transactionId
	 */
	public Long getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the member
	 */
	public Membership getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(Membership member) {
		this.member = member;
	}

	/**
	 * @return the milkIncome
	 */
	public BigDecimal getMilkIncome() {
		if (milkIncome == null
			&& getPaymentRate() != null
			&& getPayableMilkQuantity() != null) {
			return getPaymentRate().multiply(getPayableMilkQuantity(), Constants.MONEYCONTEXT);
		}
		return milkIncome;
	}

	/**
	 * @param milkIncome the milkIncome to set
	 */
	public void setMilkIncome(BigDecimal milkIncome) {
		this.milkIncome = milkIncome;
	}

	/**
	 * @return the accountCredits
	 */
	public BigDecimal getAccountCredits() {
		return accountCredits;
	}

	/**
	 * @param accountCredits the accountCredits to set
	 */
	public void setAccountCredits(BigDecimal accountCredits) {
		this.accountCredits = accountCredits;
	}

	/**
	 * @return the accountAdjustments
	 */
	public BigDecimal getAccountAdjustments() {
		return accountAdjustments;
	}

	/**
	 * @param accountAdjustments the accountAdjustments to set
	 */
	public void setAccountAdjustments(BigDecimal accountAdjustments) {
		this.accountAdjustments = accountAdjustments;
	}

	/**
	 * @return the totalPayment
	 */
	public BigDecimal getTotalPayment() {
		if (totalPayment == null
				&& getAccountCredits() != null
				&& getMilkIncome() != null
				&& getAccountCredits() != null) {
			return getMilkIncome().subtract(getAccountCredits()).add(getAccountAdjustments());
		}
		return totalPayment;
	}

	/**
	 * @param totalPayment the totalPayment to set
	 */
	public void setTotalPayment(BigDecimal totalPayment) {
		this.totalPayment = totalPayment;
	}

	/**
	 * @return the payableMilkQuantity
	 */
	public BigDecimal getPayableMilkQuantity() {
		return payableMilkQuantity;
	}

	/**
	 * @param payableMilkQuantity the payableMilkQuantity to set
	 */
	public void setPayableMilkQuantity(BigDecimal payableMilkQuantity) {
		this.payableMilkQuantity = payableMilkQuantity;
	}

	/**
	 * @return the paymentRate
	 */
	public BigDecimal getPaymentRate() {
		return paymentRate;
	}

	/**
	 * @param paymentRate the paymentRate to set
	 */
	public void setPaymentRate(BigDecimal paymentRate) {
		this.paymentRate = paymentRate;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @return the startingBalance
	 */
	public BigDecimal getStartingBalance() {
		return startingBalance;
	}

	/**
	 * @param startingBalance the startingBalance to set
	 */
	public void setStartingBalance(BigDecimal startingBalance) {
		this.startingBalance = startingBalance;
	}
	
	@Override
	public String toString() {
		return String.format("[Payment: year = %s, month = %s, amount = %s, member = %s]", year, month, totalPayment, member); 
	}
}