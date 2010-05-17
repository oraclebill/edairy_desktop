package com.agritrace.edairy.desktop.common.ui.managers;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;

public interface IAccountTransactionSearch {

    AccountTransaction[] findAccountTransaction(AccountTransaction sample);

}
