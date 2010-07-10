package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.Date;

import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.swt.ImageButtonRidget;

import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.dialogs.CalendarSelectionDialog;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;

public class DateRangeSearchController {

	private final IRidgetContainer container;

	private final String endDateButtonId;

	private ImageButtonRidget endDateImageButton;

	private ITextRidget endDateText;

	private final String endDateTxtId;

	private DateRangeFilter filter;

	private final String startDateButtonId;

	private ImageButtonRidget startDateImageButton;

	private ITextRidget startDateText;

	private final String startDateTxtId;

	public DateRangeSearchController(IRidgetContainer controller2, String startDateTxtId, String endDateTxtId,
			String startDateButtonId, String endDateButtonId, DateRangeFilter dateFilter) {
		this.container = controller2;
		this.startDateTxtId = startDateTxtId;
		this.endDateTxtId = endDateTxtId;
		this.startDateButtonId = startDateButtonId;
		this.endDateButtonId = endDateButtonId;
		this.filter = dateFilter;
		config();
	}

	public void config() {
		if (container == null) {
			return;
		}
		startDateText = container.getRidget(ITextRidget.class, startDateTxtId);
		if (null == startDateText) {
			return;
		}
		endDateText = container.getRidget(ITextRidget.class, endDateTxtId);
		// default filterStartDate one month before the current date;
		startDateText.setText(DateTimeUtils.getOneMonthBeforeCurrentDateString());
		endDateText.setText(DateTimeUtils.getCurrentDateString());

		startDateImageButton = container.getRidget(ImageButtonRidget.class, startDateButtonId);
		startDateImageButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				final CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
				calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
						startDateText.getText());

				if (calDialog.open() == AbstractWindowController.OK) {
					final Date selectedDate = (Date) calDialog.getController().getContext(
							SimpleFormattedDateBean.DATE_PROR);
					final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
					bean.setDate(selectedDate);
					startDateText.setText(bean.getFormattedDate());
					if (filter != null) {
						final String startDateStr = startDateText.getText();
						final String endDateStr = endDateText.getText();
						filter.filter(startDateStr, endDateStr);
					}
				}
			}

		});

		endDateImageButton = container.getRidget(ImageButtonRidget.class, endDateButtonId);
		endDateImageButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				final CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
				calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
						startDateText.getText());

				if (calDialog.open() == AbstractWindowController.OK) {
					final Date selectedDate = (Date) calDialog.getController().getContext(
							SimpleFormattedDateBean.DATE_PROR);
					final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
					bean.setDate(selectedDate);
					endDateText.setText(bean.getFormattedDate());
					if (filter != null) {
						final String startDateStr = startDateText.getText();
						final String endDateStr = endDateText.getText();
						filter.filter(startDateStr, endDateStr);
					}
				}
			}

		});

	}

	public String getEndDate() {
		if (endDateText != null) {
			return endDateText.getText();
		}
		return "";
	}

	public DateRangeFilter getFilter() {
		return filter;
	}

	public String getStartDate() {
		if (startDateText != null) {
			return startDateText.getText();
		}
		return "";

	}

	public void setFilter(DateRangeFilter filter) {
		this.filter = filter;
	}

}
