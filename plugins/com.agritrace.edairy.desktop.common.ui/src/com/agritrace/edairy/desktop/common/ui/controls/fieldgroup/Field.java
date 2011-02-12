package com.agritrace.edairy.desktop.common.ui.controls.fieldgroup;

class Field<T> {
	
	FieldType type;
	String name;
	String label;
	T value;
	T[] options;

	public Field(String name, FieldType type, String label) {
		this(name, type, label, null);
	}

	public Field(String name, FieldType type, String label, T initialValue) {
		this(name, type, label, initialValue, null);
	}
	
	public Field(String name, FieldType type, String label, T initialValue, T[] options) {
		this.name = name;
		this.type = type;
		this.label = label;
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

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public T[] getOptions() {
		return options;
	}

	public void setOptions(T[] options) {
		this.options = options;
	}
	
	
}