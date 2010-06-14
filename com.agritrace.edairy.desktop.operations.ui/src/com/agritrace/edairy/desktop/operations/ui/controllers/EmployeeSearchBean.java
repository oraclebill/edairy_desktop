package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.riena.beans.common.AbstractBean;

public class EmployeeSearchBean extends AbstractBean {
	public static final String PROP_NAME = "name";
	public static final String PROP_DEPT = "dept";
	public static final String PROP_POSITION = "position";

	public static final String[] POSITION_LIST = { 
		"Clerk",
		"Dairy Manager",
		"Driver",
		"Supervisor",
		"System Admin",		
	};
	
	private String name;
	private String dept;
	private String position;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		Object oldValue = this.name;
		this.name = name;
		firePropertyChanged(PROP_NAME, oldValue, this.name);
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		Object oldValue = this.dept;
		this.dept = dept;
		firePropertyChanged(PROP_DEPT, oldValue, this.dept);
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		Object oldValue = this.position;
		this.position = position;
		firePropertyChanged(PROP_POSITION, oldValue, this.position);
	}

	public List<String> getPositions() {
		return Collections.unmodifiableList(Arrays.asList(POSITION_LIST));
	}
}
