package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.Collections;
import java.util.List;

import org.eclipse.riena.beans.common.AbstractBean;

import com.agritrace.edairy.desktop.common.ui.reference.EmployeeReference;

public class EmployeeSearchBean extends AbstractBean {
	public static final String PROP_NAME = "name";
	public static final String PROP_DEPT = "dept";
	public static final String PROP_POSITION = "position";

	private String name;
	private String dept;
	private String position;
	private String department;

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
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		Object oldValue = this.position;
		this.department = department;
		firePropertyChanged(PROP_DEPT, oldValue, this.position);
	}

	public List<String> getPositions() {
		return Collections.unmodifiableList(EmployeeReference.getPositions());
	}
	
	public List<String> getDepartments() {
		return Collections.unmodifiableList(EmployeeReference.getDepartments());
	}
}
