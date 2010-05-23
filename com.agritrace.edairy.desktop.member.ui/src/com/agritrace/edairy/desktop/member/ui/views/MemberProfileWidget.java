package com.agritrace.edairy.desktop.member.ui.views;



import java.util.Date;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
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

import com.agritrace.edairy.desktop.common.ui.ImageRegistry;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.dialogs.CalendarSelectionDialog;
import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;
import com.agritrace.edairy.desktop.common.ui.views.AddressGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.CommunicationsGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.DirectionsGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.MapGroupWidget;
import com.agritrace.edairy.desktop.member.ui.Activator;

/**
 * MemberProfile Tab widget
 * @author CJ
 *
 */
public class MemberProfileWidget {
	
	private Composite composite;
	
	public static final String INFO_GROUP="Membership Information";
	public static final String applicationDate = "Application Date:";
	public static final String effectiveDate = "Effective Date:";
	public static final String status = "Status:";
	public static final String phoneNumber = "Phone Number:";
	
	private Text dateText;
	private Text effectDateText;
	private ComboViewer comboStatus;
	private Text txtPhone;

	public MemberProfileWidget(Composite parent){
		composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(new GridLayout(1, false));
		initGUI();
	}
	
	public Composite getComposite() {
		return composite;
	}
	
	public void initGUI() {
		createInfoGroup();
		Group addressGroup = new AddressGroupWidget(composite).getGroup();
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(addressGroup);
		
		Composite mapPanel = UIControlsFactory.createComposite(composite) ;
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(mapPanel);
		mapPanel.setLayout(new GridLayout(3,false));
		
		Group directionGroup = new DirectionsGroupWidget(mapPanel).getGroup();
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(2, 1).applyTo(directionGroup);
		
		Group mapGroup = new MapGroupWidget(mapPanel).getGroup();
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(mapGroup);
		
		Group communicationGroup =  new CommunicationsGroupWidget(composite).getGroup();
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(communicationGroup);
	}
	
	private void createInfoGroup(){
		
		Group infoGroup = UIControlsFactory.createGroup(composite, INFO_GROUP);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(infoGroup);
		infoGroup.setLayout(new GridLayout(6, false));
		UIControlsFactory.createLabel(infoGroup, applicationDate);
		dateText = UIControlsFactory.createText(infoGroup, SWT.READ_ONLY | SWT.BORDER,
				ViewWidgetId.memberInfo_applicationDate);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(dateText);
		// addUIControl(dateText,ViewWidgetId.calendarDate);

		final Button calendarButton = new Button(infoGroup, SWT.PUSH);
		final Image calendar = Activator.getImage(ImageRegistry.calendar);
		calendarButton.setImage(calendar);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(17, 16).applyTo(calendarButton);
		// addUIControl(calendarButton,ViewWidgetId.calendarButton);

		calendarButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
				calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
						dateText.getText());

				if (calDialog.open() == AbstractWindowController.OK) {
					final Date selectedDate = (Date) calDialog.getController().getContext(
							SimpleFormattedDateBean.DATE_PROR);
					final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
					bean.setDate(selectedDate);
					dateText.setText(bean.getFormattedDate());
				}
			}
		});

		// effective date
		UIControlsFactory.createLabel(infoGroup, effectiveDate);
		effectDateText = UIControlsFactory.createText(infoGroup, SWT.READ_ONLY | SWT.BORDER,
				ViewWidgetId.memberInfo_effectiveDate);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(effectDateText);
		// addUIControl(dateText,ViewWidgetId.calendarDate);

		final Button calendarButton2 = new Button(infoGroup, SWT.PUSH);
		calendarButton2.setImage(calendar);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(17, 16).applyTo(calendarButton2);
		// addUIControl(calendarButton,ViewWidgetId.calendarButton);

		calendarButton2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
				calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
						dateText.getText());

				if (calDialog.open() == AbstractWindowController.OK) {
					final Date selectedDate = (Date) calDialog.getController().getContext(
							SimpleFormattedDateBean.DATE_PROR);
					final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
					bean.setDate(selectedDate);
					effectDateText.setText(bean.getFormattedDate());
				}
			}
		});

		// status
		UIControlsFactory.createLabel(infoGroup, status);
		comboStatus = new ComboViewer(UIControlsFactory.createCombo(infoGroup, ViewWidgetId.memberInfo_status));
		// comboStatus.setItems(new String[] {"Active", "Inactive", "Dormant"});
		final GridData gd_comboStatus = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
		comboStatus.getControl().setLayoutData(gd_comboStatus);

		UIControlsFactory.createLabel(infoGroup, phoneNumber);
		txtPhone = UIControlsFactory.createText(infoGroup, SWT.BORDER, ViewWidgetId.memberInfo_phone);
		txtPhone.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));

	}

}
