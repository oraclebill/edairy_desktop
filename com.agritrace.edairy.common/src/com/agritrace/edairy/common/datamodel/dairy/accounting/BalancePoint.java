package com.agritrace.edairy.common.datamodel.dairy.accounting;

import java.math.BigDecimal;
import java.util.Date;

public class BalancePoint {
	private Long accountBalanceId;
	private BalancePoint previousBalance;
	private Date asOf;
	private BigDecimal amount;
	

}
