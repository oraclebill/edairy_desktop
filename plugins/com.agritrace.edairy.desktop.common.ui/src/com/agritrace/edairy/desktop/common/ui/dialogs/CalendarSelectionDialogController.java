package com.agritrace.edairy.desktop.common.ui.dialogs;

import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;

public class CalendarSelectionDialogController extends AbstractWindowController {

	public static final String DIALOG_TITLE = "Canlendar";

	public CalendarSelectionDialogController() {

	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		getWindowRidget().setTitle(DIALOG_TITLE);
		getWindowRidget().setIcon("calendar_icon-16.gif");

		final IDateTimeRidget calenderRidget = (IDateTimeRidget) getRidget(CalendarSelectionDialog.CALENDAR_DATE);

		final String dateString = (String) getContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP);
		final SimpleFormattedDateBean dateBean = new SimpleFormattedDateBean(dateString);

		calenderRidget.bindToModel(dateBean, SimpleFormattedDateBean.DATE_PROR);
		calenderRidget.updateFromModel();

		final IActionRidget okAction = (IActionRidget) getRidget(CalendarSelectionDialog.CALENDAR_OK);
		okAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				setReturnCode(OK);
				setContext(SimpleFormattedDateBean.DATE_PROR, calenderRidget.getDate());
				getWindowRidget().dispose();
			}
		});
		final IActionRidget cancelAction = (IActionRidget) getRidget(CalendarSelectionDialog.CALENDAR_CANCEL);
		cancelAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				setReturnCode(CANCEL);
				getWindowRidget().dispose();
			}
		});
	}

}
