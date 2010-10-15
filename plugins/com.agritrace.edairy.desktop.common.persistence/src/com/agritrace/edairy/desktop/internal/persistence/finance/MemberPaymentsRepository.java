package com.agritrace.edairy.desktop.internal.persistence.finance;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.agritrace.edairy.desktop.common.model.dairy.MemberPayment;
import com.agritrace.edairy.desktop.internal.common.persistence.HibernateRepository;
import com.agritrace.edairy.desktop.persistence.finance.IMemberPaymentsRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;


public class MemberPaymentsRepository extends HibernateRepository<MemberPayment> implements IMemberPaymentsRepository {

	@Inject
	protected MemberPaymentsRepository(Provider<Session> sessionProvider) {
		super(sessionProvider);
	}

	@Override
	public List<MemberPayment> getPaymentHistory(Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberPayment getPaymentForPeriod(int year, int month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?> getClassType() {
		return MemberPayment.class;
	}

}
