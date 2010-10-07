package com.agritrace.edairy.desktop.persistence.finance;

import java.util.Date;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.MemberPayment;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.internal.persistence.finance.MemberPaymentsRepository;
import com.google.inject.ImplementedBy;

@ImplementedBy(MemberPaymentsRepository.class)
public interface IMemberPaymentsRepository extends IRepository<MemberPayment> {
	List<MemberPayment> getPaymentHistory(Date start, Date end);
	MemberPayment getPaymentForPeriod(int year, int month);
}
