package com.agritrace.edairy.desktop.common.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public interface Constants {
	static final MathContext MILK_QTY_CONTEXT = new MathContext(25, 	RoundingMode.HALF_DOWN);
	static final MathContext MONEY_CONTEXT = new MathContext(25, 	RoundingMode.HALF_EVEN);
	
	static final BigDecimal BIGZERO = new BigDecimal(0, MONEY_CONTEXT);
	static final String[] MONTHS = new String[] { "Jan", "Feb", "Mar", "Apr",
			"May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

}
