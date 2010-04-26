package com.agritrace.edairy.demo.riena.controllers;

import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.demo.riena.views.ViewWidgetId;
import com.agritrace.edairy.demo.riena.views.data.SimpleFormattedDateBean;

public class CalendarSelectionDialogController extends AbstractWindowController {

	public static final String DIALOG_TITLE="Canlendar"; 
	
	
	public CalendarSelectionDialogController(){
		
	}


	@Override
	public void configureRidgets() {
		super.configureRidgets();

		getWindowRidget().setTitle(DIALOG_TITLE); //$NON-NLS-1$
		getWindowRidget().setIcon("calendar_icon-16.gif");
		
		final IDateTimeRidget calenderRidget = (IDateTimeRidget) getRidget(ViewWidgetId.calendarDate);
		
		String dateString = (String) getContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP);
		SimpleFormattedDateBean dateBean = new SimpleFormattedDateBean(dateString);

		calenderRidget.bindToModel(dateBean,SimpleFormattedDateBean.DATE_PROR);
		calenderRidget.updateFromModel();

		IActionRidget okAction = (IActionRidget) getRidget(ViewWidgetId.okButton);
		okAction.addListener(new IActionListener() {
			public void callback() {
				setReturnCode(OK);
				setContext(SimpleFormattedDateBean.DATE_PROR, calenderRidget.getDate());
				getWindowRidget().dispose();
			}
		});
		IActionRidget cancelAction = (IActionRidget) getRidget(ViewWidgetId.cancelButton);
		cancelAction.addListener(new IActionListener() {
			public void callback() {
				setReturnCode(CANCEL);
				getWindowRidget().dispose();
			}
		});
	}

}
