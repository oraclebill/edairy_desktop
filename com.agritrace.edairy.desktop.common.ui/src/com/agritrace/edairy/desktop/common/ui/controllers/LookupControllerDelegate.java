package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.Calendar;
import java.util.Date;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.dialogs.CalendarSelectionDialog;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;

/**
 * Delegate for the lookup controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class LookupControllerDelegate extends ControllerDelegate {

	private final IObservableValue value;
	private final String textId;
	private final String buttonId;

	/**
	 * @param container
	 *            Ridget container
	 * @param value
	 *            Observable value
	 * @param textId
	 *            Bind if for text field
	 * @param buttonId
	 *            Button bind
	 */
	public LookupControllerDelegate(IRidgetContainer container, IObservableValue value, String textId, String buttonId) {
		super(container);
		this.value = value;
		this.textId = textId;
		this.buttonId = buttonId;
	}

	@Override
	public void configureRidgets() {

		final IRidgetContainer container = getRidgetContainer();
		if (container != null) {

			// Configure text ridget
			final ITextRidget textRidget = container.getRidget(ITextRidget.class, textId);
			textRidget.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			textRidget.bindToModel(value);
			textRidget.updateFromModel();

			final IActionRidget actionRidget = container.getRidget(IActionRidget.class, buttonId);
			actionRidget.addListener(new IActionListener() {

				@Override
				public void callback() {
					final CalendarSelectionDialog calDialog = new CalendarSelectionDialog();

					final ITextRidget textRidget = container.getRidget(ITextRidget.class, textId);
					if (value.getValue() != null) {
						calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
								DateTimeUtils.DATE_FORMAT.format(value.getValue()));
					} else {
						// By default it will be today
						calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
								DateTimeUtils.DATE_FORMAT.format(Calendar.getInstance().getTime()));
					}
					final int ret = calDialog.open();
					if (ret == AbstractWindowController.OK) {
						final Date selectedDate = (Date) calDialog.getController().getContext(
								SimpleFormattedDateBean.DATE_PROR);
						value.setValue(selectedDate);
						textRidget.updateFromModel();
					}
				}
			});
		}

	}
}
