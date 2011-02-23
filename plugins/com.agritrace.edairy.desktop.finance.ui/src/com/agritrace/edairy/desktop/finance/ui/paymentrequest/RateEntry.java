package com.agritrace.edairy.desktop.finance.ui.paymentrequest;

import java.math.BigDecimal;

class RateEntry {
	private BigDecimal rate;
	private BigDecimal gross;

	public RateEntry(BigDecimal rate, BigDecimal gross) {
		this.rate = rate;
		this.gross = gross;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getGross() {
		return gross;
	}

	public void setGross(BigDecimal gross) {
		this.gross = gross;
	}
}