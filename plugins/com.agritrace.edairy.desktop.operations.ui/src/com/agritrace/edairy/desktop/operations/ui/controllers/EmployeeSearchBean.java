package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.Collections;
import java.util.List;

import org.eclipse.riena.beans.common.AbstractBean;

import com.agritrace.edairy.desktop.common.ui.reference.EmployeeReference;

public class EmployeeSearchBean extends AbstractBean {
	public static final String PROP_DEPT = "dept";
	public static final String PROP_NAME = "name";
	public static final String PROP_POSITION = "position";

	private String department;
	private String dept;
	private String name;
	private String position;

	public String getDepartment() {
		return department;
	}

	public List<String> getDepartments() {
		return Collections.unmodifiableList(EmployeeReference.getDepartments());
	}

	public String getDept() {
		return dept;
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public List<String> getPositions() {
		return Collections.unmodifiableList(EmployeeReference.getPositions());
	}

	public void setDepartment(String department) {
		final Object oldValue = this.position;
		this.department = department;
		firePropertyChanged(PROP_DEPT, oldValue, this.position);
	}

	public void setDept(String dept) {
		final Object oldValue = this.dept;
		this.dept = dept;
		firePropertyChanged(PROP_DEPT, oldValue, this.dept);
	}

	public void setName(String name) {
		final Object oldValue = this.name;
		this.name = name;
		firePropertyChanged(PROP_NAME, oldValue, this.name);
	}

	public void setPosition(String position) {
		final Object oldValue = this.position;
		this.position = position;
		firePropertyChanged(PROP_POSITION, oldValue, this.position);
	}
}
