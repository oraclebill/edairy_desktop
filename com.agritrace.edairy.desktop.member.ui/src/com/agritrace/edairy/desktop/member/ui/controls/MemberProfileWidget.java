package com.agritrace.edairy.desktop.member.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.riena.ui.swt.ImageButton;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.DesktopBaseActivator;
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

	public static final String applicationDate = "Application Date:";

	public static final String effectiveDate = "Effective Date:";
	public static final String INFO_GROUP = "Membership Information";
	public static final String phoneNumber = "Phone Number:";
	public static final String status = "Status:";
	private ComboViewer comboStatus;

	private final Composite composite;
	private Text dateText;
	private Text effectDateText;
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

		final LocationProfileWidget addressWidget = new LocationProfileWidget(composite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(addressWidget.getComposite());

		final CommunicationsGroupWidget communication = new CommunicationsGroupWidget(composite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(communication.getGroup());
	}

	private void createInfoGroup() {
		final Group infoGroup = UIControlsFactory.createGroup(composite, INFO_GROUP);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(infoGroup);
		infoGroup.setLayout(new GridLayout(6, false));
		UIControlsFactory.createLabel(infoGroup, applicationDate);
		dateText = UIControlsFactory.createText(infoGroup, SWT.READ_ONLY | SWT.BORDER,
				ViewWidgetId.memberInfo_applicationDate);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(dateText);

		final ImageButton calendarButton = UIControlsFactory.createImageButton(infoGroup, SWT.NONE,
				ViewWidgetId.memberInfo_applicationDate_btn);
		final Image calendar = Activator.getDefault().getImageRegistry().get(DesktopBaseActivator.CALENDAR_ICON);
		calendarButton.setImage(calendar);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(17, 16).applyTo(calendarButton);

		// effective date
		UIControlsFactory.createLabel(infoGroup, effectiveDate);
		effectDateText = UIControlsFactory.createText(infoGroup, SWT.READ_ONLY | SWT.BORDER,
				ViewWidgetId.memberInfo_effectiveDate);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(effectDateText);
		// addUIControl(dateText,ViewWidgetId.calendarDate);

		final ImageButton calendarButton2 = UIControlsFactory.createImageButton(infoGroup, SWT.NONE,
				ViewWidgetId.memberInfo_effectiveDate_btn);
		calendarButton2.setImage(calendar);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(17, 16).applyTo(calendarButton2);
		// addUIControl(calendarButton,ViewWidgetId.calendarButton);

		// calendarButton2.addSelectionListener(new SelectionAdapter() {
		// @Override
		// public void widgetSelected(SelectionEvent e) {
		// final CalendarSelectionDialog calDialog = new
		// CalendarSelectionDialog();
		// calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
		// dateText.getText());
		//
		// if (calDialog.open() == AbstractWindowController.OK) {
		// final Date selectedDate = (Date)
		// calDialog.getController().getContext(
		// SimpleFormattedDateBean.DATE_PROR);
		// final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
		// bean.setDate(selectedDate);
		// effectDateText.setText(bean.getFormattedDate());
		// }
		// }
		// });

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
