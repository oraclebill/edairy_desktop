package com.agritrace.edairy.desktop.common.ui.controllers;

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

	private IObservableValue value;
	private String textId;
	private String buttonId;

	/**
	 * @param container Ridget container
	 * @param value Observable value
	 * @param textId Bind if for text field
	 * @param buttonId Button bind
	 */
	public LookupControllerDelegate(IRidgetContainer container,
			IObservableValue value, String textId, String buttonId) {
		super(container);
		this.value = value;
		this.textId = textId;
		this.buttonId = buttonId;
	}

	public void configureRidgets() {

		final IRidgetContainer container = getRidgetContainer();
		if (container != null) {

			// Configure text ridget
			ITextRidget textRidget = container.getRidget(ITextRidget.class,
					textId);
			textRidget
					.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			textRidget.bindToModel(value);
			textRidget.updateFromModel();

			IActionRidget actionRidget = container.getRidget(
					IActionRidget.class, buttonId);
			actionRidget.addListener(new IActionListener() {

				@Override
				public void callback() {
					CalendarSelectionDialog calDialog = new CalendarSelectionDialog();

					ITextRidget textRidget = container.getRidget(
							ITextRidget.class, textId);
					calDialog.getController().setContext(
							SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
							DateTimeUtils.DATE_FORMAT.format(value.getValue()));
					if (calDialog.open() == AbstractWindowController.OK) {
						final Date selectedDate = (Date) calDialog
								.getController().getContext(
										SimpleFormattedDateBean.DATE_PROR);
						value.setValue(selectedDate);
						textRidget.updateFromModel();
					}
				}
			});
		}

	}
}
