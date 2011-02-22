package com.agritrace.edairy.desktop.common.persistence;

/**
 * A holder for parameters used in 'filter' operations on repository DAO's.
 * 
 * @author bjones
 *
 */
public class FilterParameter {
	public enum Type { EQUALS, LIKE, LESS_THAN, GREATER_THAN };

	private Type type;
	private String paramName;
	private Object paramValue;
		
	
	/**
	 * Create a new filter parameter.
	 * 
	 * @param paramName the parameter name
	 * @param paramValue the parameter value
	 */
	public FilterParameter(Type type, String paramName, Object paramValue) {
		this.type = type;
		this.paramName = paramName;
		this.paramValue = paramValue;
	}
	
	/**
	 * Return the parameter value.
	 * 
	 * @return the parameter name
	 */
	public String getParamName() {
		return paramName;
	}
	
	/**
	 * Set the parameter name.
	 * 
	 * @param paramName
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	
	/**
	 * Return the parameter value.
	 * 
	 * @return
	 */
	public Object getParamValue() {
		return paramValue;
	}
	
	/**
	 * Set the parameter value.
	 * 
	 * @param paramValue
	 */
	public void setParamValue(Object paramValue) {
		this.paramValue = paramValue;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
}
