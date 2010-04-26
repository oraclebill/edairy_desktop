package com.agritrace.edairy.common.datamodel.dairy.accounting;

import java.math.BigDecimal;

public class AccountTransaction {
	public enum TransactionType { CREDIT, DEBIT } // credit subtracts, debit adds

	private Long transactionId;
	private TransactionType type;
	private String source;
	private BigDecimal amount;
	private String description;
	

}
