package com.agritrace.edairy.common.datamodel.security;

import java.util.Date;
import javax.persistence.*;

@Entity
public class LoginHistory {

	private Long loginHistoryId;
	private Date timestamp;
	private String ipAddress;

	@Id
	@GeneratedValue
	public Long getLoginHistoryId() {
		return loginHistoryId;
	}

	public void setLoginHistoryId(Long loginHistoryId) {
		this.loginHistoryId = loginHistoryId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Column(nullable = false)
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}
