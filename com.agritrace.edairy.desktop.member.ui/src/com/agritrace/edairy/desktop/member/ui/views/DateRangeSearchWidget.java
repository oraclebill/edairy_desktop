package com.agritrace.edairy.desktop.member.ui.views;

import java.util.Date;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.ImageRegistry;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.dialogs.CalendarSelectionDialog;
import com.agritrace.edairy.desktop.member.ui.Activator;



public class DateRangeSearchWidget {
	
	private Composite composite;

	private String labelText;
	
	private String startId;
	
	private String endId;

	public DateRangeSearchWidget(Composite parent, String rangeLabelTxt, String startTxtId, String endTxtId){
		composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(new GridLayout(7,false));
		labelText = rangeLabelTxt;
		startId = startTxtId;
		endId = endTxtId;
		
		createDataRangeSearch();
	}
	
	
	private void createDataRangeSearch() {

		UIControlsFactory.createLabel(composite, labelText);
	
		final Text startDateText = UIControlsFactory.createText(composite, SWT.READ_ONLY | SWT.BORDER, startId);
		startDateText.setText("Start");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(startDateText);

		final Button calendarButton = new Button(composite, SWT.PUSH);
		final Image calendar = Activator.getImage(ImageRegistry.calendar);
		calendarButton.setImage(calendar);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(17, 16).applyTo(calendarButton);

		calendarButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
				calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
						startDateText.getText());

				if (calDialog.open() == AbstractWindowController.OK) {
					final Date selectedDate = (Date) calDialog.getController().getContext(
							SimpleFormattedDateBean.DATE_PROR);
					final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
					bean.setDate(selectedDate);
					startDateText.setText(bean.getFormattedDate());
				}
			}
		});

		final Text endDateText = UIControlsFactory.createText(composite, SWT.READ_ONLY | SWT.BORDER, endId);
		endDateText.setText("End");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(endDateText);

		final Button calendarButton2 = new Button(composite, SWT.PUSH);
		calendarButton2.setImage(calendar);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(17, 16).applyTo(calendarButton2);

		calendarButton2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
				calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
						endDateText.getText());

				if (calDialog.open() == AbstractWindowController.OK) {
					final Date selectedDate = (Date) calDialog.getController().getContext(
							SimpleFormattedDateBean.DATE_PROR);
					final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
					bean.setDate(selectedDate);
					endDateText.setText(bean.getFormattedDate());
				}
			}
		});

	}
	
	public Composite getComposite() {
		return composite;
	}


}
