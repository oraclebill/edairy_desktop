package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.Date;

import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.swt.ImageButtonRidget;

import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.dialogs.CalendarSelectionDialog;
import com.agritrace.edairy.desktop.common.ui.util.ServiceUtils;

public class DateRangeSearchController {
	
	private IController controller;
	
	private String startDateTxtId;
	
	private String endDateTxtId;
	
	private String startDateButtonId;
	
	private String endDateButtonId;
	
	private ITextRidget startDateText;
	
	private ITextRidget endDateText;
	
	private ImageButtonRidget startDateImageButton;
	
	private ImageButtonRidget endDateImageButton;
	
	private DateRangeFilter filter;
	
	public DateRangeSearchController(IController controller, String startDateTxtId, String endDateTxtId, String startDateButtonId, String endDateButtonId, DateRangeFilter dateFilter){
		this.controller = controller;
		this.startDateTxtId = startDateTxtId;
		this.endDateTxtId = endDateTxtId;
		this.startDateButtonId = startDateButtonId;
		this.endDateButtonId = endDateButtonId;
		config();
	}
	
	public void config(){
		if(controller == null){
			return;
		}
		startDateText= controller.getRidget(ITextRidget.class,startDateTxtId);
		endDateText = controller.getRidget(ITextRidget.class,endDateTxtId);
		//default filterStartDate one month before the current date;
		startDateText.setText(ServiceUtils.getOneMonthBeforeCurrentDateString());
		endDateText.setText(ServiceUtils.getCurrentDateString());
		
		startDateImageButton =  controller.getRidget(ImageButtonRidget.class,startDateButtonId);
		startDateImageButton.addListener(new IActionListener(){

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
					if(filter != null){
						String startDateStr = startDateText.getText();
						String endDateStr = endDateText.getText();
						filter.filter(startDateStr, endDateStr);
					}
				}
			}
			
		});

			
		endDateImageButton =  controller.getRidget(ImageButtonRidget.class,endDateButtonId);
		endDateImageButton.addListener(new IActionListener(){

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
					if(filter != null){
						String startDateStr = startDateText.getText();
						String endDateStr = endDateText.getText();
						filter.filter(startDateStr, endDateStr);
					}
				}
			}
			
		});

		
	}

	public DateRangeFilter getFilter() {
		return filter;
	}

	public void setFilter(DateRangeFilter filter) {
		this.filter = filter;
	}
	
	

	
}
