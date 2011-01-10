package com.agritrace.edairy.desktop.member.ui.controls;

import org.eclipse.riena.ui.ridgets.IComplexRidget;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.ITransactionRepository;

public interface IMemberAccountRidget extends IComplexRidget {

	void bindToModel(Membership member, ITransactionRepository paymentRepo);

}
