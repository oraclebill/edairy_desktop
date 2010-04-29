package com.agritrace.edairy.common.datamodel.dairy.accounting;

import java.math.BigDecimal;
import javax.persistence.*;
import java.util.Date;

@Entity
public class BalancePoint {
	@Id @GeneratedValue
	private Long accountBalanceId;
	@ManyToOne
	private Account account;
	@OneToOne
	private BalancePoint previousBalance;
	@Temporal(TemporalType.TIMESTAMP)
	private Date asOf;
	private BigDecimal amount;
	

}
