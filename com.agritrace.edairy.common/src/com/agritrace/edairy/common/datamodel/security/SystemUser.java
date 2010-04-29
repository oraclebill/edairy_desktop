package com.agritrace.edairy.common.datamodel.security;


import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.agritrace.edairy.common.datamodel.dairy.Employee;


/**
 * Entity implementation class for Entity: SystemUser
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class SystemUser extends Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long systemUserId;
	private String userName;
	private String encryptedPassword;
	private List<SecurityRole> securityRoles;
	private List<LoginHistory> loginHistory;

	public SystemUser() {
		super();
	}

	public Long getSystemUserId() {
		return this.systemUserId;
	}

	public void setSystemUserId(Long systemUserId) {
		this.systemUserId = systemUserId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@ManyToMany
	public List<SecurityRole> getSecurityRoles() {
		return this.securityRoles;
	}

	public void setSecurityRoles(List<SecurityRole> securityRoles) {
		this.securityRoles = securityRoles;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}


}
