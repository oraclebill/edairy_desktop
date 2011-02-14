package com.agritrace.edairy.desktop.common.ui.controls.fieldgroup;

import org.eclipse.core.runtime.Assert;

public class Field {
	
	FieldType type;
	String name;
	String label;
	Object value;
	Object[] options;

	public Field(String name, FieldType type, String label) {
		this(name, type, label, null);
	}

	public Field(String name, FieldType type, String label, Object initialValue) {
		this(name, type, label, initialValue, null);
	}
	
	public Field(String name, FieldType type, String label, Object initialValue, Object[] options) {
		Assert.isNotNull(name);
		this.name = name;
		this.type = type;
		this.label = label != null ? label : name;
		this.value = initialValue;
		this.options = options;
	}

	public FieldType getType() {
		return type;
	}

	public void setType(FieldType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Object[] getOptions() {
		return options;
	}

	public void setOptions(Object[] options) {
		this.options = options;
	}

	public void setHelpText(String helpText) {
		
	}
	
	
}