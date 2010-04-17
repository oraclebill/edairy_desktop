package com.agritrace.edairy.common.model.base;

import java.util.List;


public abstract class Party {
	// address info
	private String _address;
	private String _section;
	private String _estate;
	private String _village;
	private String _subLocation;
	private String _location;
	private String _division;
	private String _district;
	private String _postal_code;
	
	// domicile / location
	private String _addressDescription; // directions...

	// contact methods
	private List<ContactMethod> _contactMethods;
}
