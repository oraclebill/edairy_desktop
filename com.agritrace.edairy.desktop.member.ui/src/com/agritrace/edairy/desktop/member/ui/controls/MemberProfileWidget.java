package com.agritrace.edairy.desktop.member.ui.controls;

import java.util.Date;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.ImageButton;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.dialogs.CalendarSelectionDialog;
import com.agritrace.edairy.desktop.common.ui.views.CommunicationsGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.LocationProfileWidget;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

/**
 * MemberProfile Tab widget
 * 
 * @author CJ
 * 
 */
public class MemberProfileWidget {

	private Composite composite;

	public static final String INFO_GROUP = "Membership Information";
	public static final String applicationDate = "Application Date:";
	public static final String effectiveDate = "Effective Date:";
	public static final String status = "Status:";
	public static final String phoneNumber = "Phone Number:";

	private Text dateText;
	private Text effectDateText;
	private ComboViewer comboStatus;
	private Text txtPhone;

	public MemberProfileWidget(Composite parent) {
		composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(new GridLayout(1, false));
		initGUI();
	}

	public Composite getComposite() {
		return composite;
	}

	public void initGUI() {
		createInfoGroup();

		LocationProfileWidget addressWidget = new LocationProfileWidget(composite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(addressWidget.getComposite());

		CommunicationsGroupWidget communication = new CommunicationsGroupWidget(composite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(communication.getGroup());
	}

	private void createInfoGroup() {
		Group infoGroup = UIControlsFactory.createGroup(composite, INFO_GROUP);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(infoGroup);
		infoGroup.setLayout(new GridLayout(6, false));
		UIControlsFactory.createLabel(infoGroup, applicationDate);
		dateText = UIControlsFactory.createText(infoGroup, SWT.READ_ONLY | SWT.BORDER,
				ViewWidgetId.memberInfo_applicationDate);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(dateText);

		ImageButton calendarButton = UIControlsFactory.createImageButton(infoGroup, SWT.NONE,ViewWidgetId.memberInfo_applicationDate_btn);
		final Image calendar = Activator.getDefault().getImageRegistry().get(Activator.CALENDAR_ICON);
		calendarButton.setImage(calendar);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(17, 16).applyTo(calendarButton);

		// effective date
		UIControlsFactory.createLabel(infoGroup, effectiveDate);
		effectDateText = UIControlsFactory.createText(infoGroup, SWT.READ_ONLY | SWT.BORDER,
				ViewWidgetId.memberInfo_effectiveDate);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(effectDateText);
		// addUIControl(dateText,ViewWidgetId.calendarDate);

		ImageButton calendarButton2 = UIControlsFactory.createImageButton(infoGroup,SWT.NONE, ViewWidgetId.memberInfo_effectiveDate_btn);
		calendarButton2.setImage(calendar);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(17, 16).applyTo(calendarButton2);
		// addUIControl(calendarButton,ViewWidgetId.calendarButton);

//		calendarButton2.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				final CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
//				calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
//						dateText.getText());
//
//				if (calDialog.open() == AbstractWindowController.OK) {
//					final Date selectedDate = (Date) calDialog.getController().getContext(
//							SimpleFormattedDateBean.DATE_PROR);
//					final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
//					bean.setDate(selectedDate);
//					effectDateText.setText(bean.getFormattedDate());
//				}
//			}
//		});

		// status
		UIControlsFactory.createLabel(infoGroup, status);
		comboStatus = new ComboViewer(UIControlsFactory.createCombo(infoGroup, ViewWidgetId.memberInfo_status));
		final GridData gd_comboStatus = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
		comboStatus.getControl().setLayoutData(gd_comboStatus);

		UIControlsFactory.createLabel(infoGroup, phoneNumber);
		txtPhone = UIControlsFactory.createText(infoGroup, SWT.BORDER, ViewWidgetId.memberInfo_phone);
		txtPhone.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));

	}

}
