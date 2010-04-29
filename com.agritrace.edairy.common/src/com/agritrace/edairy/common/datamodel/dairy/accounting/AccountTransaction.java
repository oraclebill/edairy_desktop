package com.agritrace.edairy.common.datamodel.dairy.accounting;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
public class AccountTransaction {
	public enum TransactionType { CREDIT, DEBIT } // credit subtracts, debit adds

	@Id @GeneratedValue
	private Long transactionId;
	@ManyToOne
	private Account account;
	private TransactionType type;
	private String source;
	private BigDecimal amount;
	private String description;
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public TransactionType getType() {
		return type;
	}
	public void setType(TransactionType type) {
		this.type = type;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
