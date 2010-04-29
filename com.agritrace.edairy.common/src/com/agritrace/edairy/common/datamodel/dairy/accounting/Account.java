package com.agritrace.edairy.common.datamodel.dairy.accounting;

import java.util.List;
import javax.persistence.*;

import com.agritrace.edairy.common.datamodel.dairy.Membership;

import java.util.Date;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private Long accountId;
	private Membership member;
	@Temporal(TemporalType.DATE)
	private Date established;
	private String type;

	@OneToMany(mappedBy="account")
	private List<AccountTransaction> transactions;
	@OneToMany(mappedBy="account")
	private List<BalancePoint> balances;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Membership getOwner() {
		return member;
	}

	public void setOwner(Membership owner) {
		this.member = owner;
	}

	public Date getEstablished() {
		return established;
	}

	public void setEstablished(Date established) {
		this.established = established;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<AccountTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<AccountTransaction> transactions) {
		this.transactions = transactions;
	}

	public List<BalancePoint> getBalances() {
		return balances;
	}

	public void setBalances(List<BalancePoint> balances) {
		this.balances = balances;
	}

}
