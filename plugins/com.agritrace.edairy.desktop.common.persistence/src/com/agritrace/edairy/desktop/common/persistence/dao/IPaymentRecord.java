package com.agritrace.edairy.desktop.common.persistence.dao;

import java.math.BigDecimal;
import java.util.Date;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;

public interface IPaymentRecord {

	/**
	 * @return the transactionId
	 */
	public abstract Long getTransactionId();

	/**
	 * @return the transactionDate
	 */
	public abstract Date getTransactionDate();

	/**
	 * @return the member
	 */
	public abstract Membership getMember();

	/**
	 * @return the milkIncome
	 */
	public abstract BigDecimal getMilkIncome();

	/**
	 * @return the accountCredits
	 */
	public abstract BigDecimal getAccountCredits();

	/**
	 * @return the accountAdjustments
	 */
	public abstract BigDecimal getAccountAdjustments();

	/**
	 * @return the totalPayment
	 */
	public abstract BigDecimal getTotalPayment();

	/**
	 * @return the payableMilkQuantity
	 */
	public abstract BigDecimal getPayableMilkQuantity();

	/**
	 * @return the paymentRate
	 */
	public abstract BigDecimal getPaymentRate();

	/**
	 * @return the year
	 */
	public abstract int getYear();

	/**
	 * @return the month
	 */
	public abstract int getMonth();

	/**
	 * @return the startingBalance
	 */
	public abstract BigDecimal getStartingBalance();

}