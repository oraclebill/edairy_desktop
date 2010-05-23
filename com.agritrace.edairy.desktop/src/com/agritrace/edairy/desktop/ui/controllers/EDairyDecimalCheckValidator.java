package com.agritrace.edairy.desktop.ui.controllers;

import java.util.Locale;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.riena.ui.ridgets.validation.ValidRange;
import org.eclipse.swt.widgets.Display;

public class EDairyDecimalCheckValidator extends ValidRange {

    public EDairyDecimalCheckValidator(final Number min, final Number max, final Locale locale) {
	super(min, max, locale);
    }

    @Override
    public IStatus validate(final Object value) {
	final IStatus status = super.validate(value);
	if (!status.isOK()) {
	    Display.getCurrent().beep();
	}
	return status;
    }

}