package com.agritrace.edairy.desktop.internal.common.persistence;

import java.util.List;

import org.hibernate.Session;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AccountRepository extends HibernateRepository<Account> {
	@Inject
	protected AccountRepository(Provider<Session> sessionProvider) {
		super(sessionProvider);
	}
	
	@Override
	protected Class<Account> getClassType() {
		return Account.class;
	}
	
	@Override
	public List<Account> all() {
		return super.allWithEagerFetch("balances", "member.member.location");
	}
}
