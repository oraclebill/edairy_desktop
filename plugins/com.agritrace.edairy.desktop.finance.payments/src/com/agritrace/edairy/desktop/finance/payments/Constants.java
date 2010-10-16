package com.agritrace.edairy.desktop.finance.payments;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public interface Constants {
	static final MathContext MONEYCONTEXT = new MathContext(0, RoundingMode.HALF_EVEN);
	static final BigDecimal BIGZERO = new BigDecimal(0, MONEYCONTEXT);
	static final String[] MONTHS = new String[] { "Jan", "Feb", "Mar", "Apr",
			"May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

}
