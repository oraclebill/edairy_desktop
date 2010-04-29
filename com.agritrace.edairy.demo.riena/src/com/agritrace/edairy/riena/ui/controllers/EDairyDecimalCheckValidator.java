package com.agritrace.edairy.riena.ui.controllers;

import java.util.Locale;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.riena.ui.ridgets.validation.ValidRange;
import org.eclipse.swt.widgets.Display;

public class EDairyDecimalCheckValidator extends ValidRange {
	
	public EDairyDecimalCheckValidator(final Number min, final Number max, final Locale locale) {
		super(min,max,locale);
	}
	public IStatus validate(final Object value){
		IStatus status = super.validate(value);
		if(!status.isOK()){
			Display.getCurrent().beep();
		}
		return status;
	}

}
