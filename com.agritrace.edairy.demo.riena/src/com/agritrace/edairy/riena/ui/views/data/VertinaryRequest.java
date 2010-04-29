package com.agritrace.edairy.riena.ui.views.data;

public class VertinaryRequest extends ServiceRequest {
	
	public static String PROPERTY_REQUEST;
	
	private String requestDescription;
	
	

	public VertinaryRequest(){
		super();
		this.requestDescription = "";
	}
	
	public String getRequestDescription() {
		return requestDescription;
	}

	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}

}
