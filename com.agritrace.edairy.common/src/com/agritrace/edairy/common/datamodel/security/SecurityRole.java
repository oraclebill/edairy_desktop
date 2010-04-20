package com.agritrace.edairy.common.datamodel.security;

import javax.persistence.*;

@Entity
public class SecurityRole {
	private Long securityRoleId;
	private String name;
	private String description;
	private boolean systemDefined;

	@Id
	@GeneratedValue
	public Long getSecurityRoleId() {
		return securityRoleId;
	}

	public void setSecurityRoleId(Long securityRoleId) {
		this.securityRoleId = securityRoleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isSystemDefined() {
		return systemDefined;
	}

	public void setSystemDefined(boolean systemDefined) {
		this.systemDefined = systemDefined;
	}
}
