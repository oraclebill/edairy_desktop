package com.agritrace.edairy.demo.riena.views;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class StringNumberValidator implements IValidator {

	@Override
	public IStatus validate(Object value) {
		if(value == null){
			throw new IllegalArgumentException(
			"Parameter 'value' cannot be null.");
		}else{
			String strValue = (String)value;
			try{
				Integer i = new Integer(strValue);	
			}catch(NumberFormatException ex){
				return  ValidationStatus.error(ex.getMessage());
			}

			return Status.OK_STATUS;
			
		}
	}

}
