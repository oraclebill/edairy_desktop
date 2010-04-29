package com.agritrace.edairy.common.datamodel.dairy.accounting;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Entity
public class MilkPrice {

	@Id @GeneratedValue
	private Long priceId;
	@Temporal(value = TemporalType.DATE)
	private Date priceDate;
	private BigDecimal price;

	public Long getPriceId() {
		return priceId;
	}

	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}

	public Date getPriceDate() {
		return priceDate;
	}

	public void setPriceDate(Date priceDate) {
		this.priceDate = priceDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
