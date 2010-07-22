package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.Date;

import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.swt.ImageButtonRidget;

import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.dialogs.CalendarSelectionDialog;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;

public class DateRangeSearchController {

	private final IRidgetContainer container;

	private final String endDateButtonId;

	private ImageButtonRidget endDateImageButton;

	private IDateTimeRidget endDate;

	private final String endDateTxtId;

	private DateRangeFilter filter;

	private final String startDateButtonId;

	private ImageButtonRidget startDateImageButton;

	private IDateTimeRidget startDate;

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
		startDate = container.getRidget(IDateTimeRidget.class, startDateTxtId);
		if (null == startDate) {
			return;
		}
		endDate = container.getRidget(IDateTimeRidget.class, endDateTxtId);
		// default filterStartDate one month before the current date;
		startDate.setDate(DateTimeUtils.getOneMonthBeforeCurrentDate());
		endDate.setDate(DateTimeUtils.getCurrentDate());

//		startDateImageButton = container.getRidget(ImageButtonRidget.class, startDateButtonId);
//		startDateImageButton.addListener(new IActionListener() {
//
//			@Override
//			public void callback() {
//				final CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
//				calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
//						startDate.getText());
//
//				if (calDialog.open() == AbstractWindowController.OK) {
//					final Date selectedDate = (Date) calDialog.getController().getContext(
//							SimpleFormattedDateBean.DATE_PROR);
//					final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
//					bean.setDate(selectedDate);
//					startDate.setText(bean.getFormattedDate());
//					if (filter != null) {
//						final String startDateStr = startDate.getText();
//						final String endDateStr = endDate.getText();
//						filter.filter(startDateStr, endDateStr);
//					}
//				}
//			}
//
//		});
//
//		endDateImageButton = container.getRidget(ImageButtonRidget.class, endDateButtonId);
//		endDateImageButton.addListener(new IActionListener() {
//
//			@Override
//			public void callback() {
//				final CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
//				calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
//						startDate.getText());
//
//				if (calDialog.open() == AbstractWindowController.OK) {
//					final Date selectedDate = (Date) calDialog.getController().getContext(
//							SimpleFormattedDateBean.DATE_PROR);
//					final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
//					bean.setDate(selectedDate);
//					endDate.setText(bean.getFormattedDate());
//					if (filter != null) {
//						final String startDateStr = startDate.getText();
//						final String endDateStr = endDate.getText();
//						filter.filter(startDateStr, endDateStr);
//					}
//				}
//			}
//
//		});

	}

	public Date getEndDate() {
		if (endDate != null) {
			return endDate.getDate();
		}
		return null;
	}

	public DateRangeFilter getFilter() {
		return filter;
	}

	public Date getStartDate() {
		if (startDate != null) {
			return startDate.getDate();
		}
		return null;

	}

	public void setFilter(DateRangeFilter filter) {
		new Exception().printStackTrace();
		this.filter = filter;
	}

}
