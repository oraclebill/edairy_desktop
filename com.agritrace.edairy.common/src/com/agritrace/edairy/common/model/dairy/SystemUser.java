package com.agritrace.edairy.common.model.dairy;

import com.agritrace.edairy.common.model.core.Person;
import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SystemUser
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class SystemUser extends Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long systemUserId;
	private String userName;
	private String password;
	private List<SecurityRole> securityRoles;

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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<SecurityRole> getSecurityRoles() {
		return this.securityRoles;
	}

	public void setSecurityRoles(List<SecurityRole> securityRoles) {
		this.securityRoles = securityRoles;
	}

}
