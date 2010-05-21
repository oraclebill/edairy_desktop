package com.agritrace.edairy.desktop.common.ui.managers;

import java.util.Date;
import java.util.Set;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;

public interface IAccountTransactionSearch {

    AccountTransaction[] findAccountTransaction(Date start, Date end, Long memberId,  Set<TransactionType> typeCodes );

}
