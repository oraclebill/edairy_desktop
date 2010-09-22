package com.agritrace.edairy.desktop.finance.payments;

import java.math.BigDecimal;
import java.util.Date;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;

public class PaymentRecord {
	public final Long transactionId;
	public final Date transactionDate;
	public final Membership member;
	public final BigDecimal amount;

	public PaymentRecord(Long transactionId, Date transactionDate,
			Membership member, BigDecimal amount) {
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.member = member;
		this.amount = amount;
	}
}