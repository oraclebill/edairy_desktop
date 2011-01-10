package com.agritrace.edairy.desktop.member.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.ContactMethodsGroup;
import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.IContactMethodsGroupRidget;
import com.agritrace.edairy.desktop.common.ui.controls.location.LocationTabFolder;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

/**
 * MemberProfile Tab widget
 * 
 * @author CJ
 * 
 */
public class MemberProfileWidget extends Composite {

	public static final String applicationDate = "Application Date:";

	public static final String EFFECTIVE_DATE_LABEL = "Effective Date:";
	public static final String INFO_GROUP_LABEL = "Membership Information";
	public static final String PHONE_NUMBER_LABEL = "Phone Number:";
	public static final String STATUS_LABEL = "Status:";
	
	private Combo comboStatus;

	private DateTime dateText;
	private DateTime effectDateText;
	private Text txtPhone;

	public MemberProfileWidget(Composite parent, int style) {
		super(parent, style);

		setLayout(new GridLayout(1, false));
		
		createMemberInfoGroup();
		createMemberLocationGroup();
	}
	
	private void createMemberLocationGroup() {

		LocationTabFolder addressWidget;
		CTabFolder addressTabFolder;
		CTabItem contactsTab;
		ContactMethodsGroup contacts;

		addressWidget = new LocationTabFolder(this, SWT.NONE);
		addressWidget.setLayoutData(GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).create());
		
		addressTabFolder = addressWidget.getTabFolder();

		contactsTab = new CTabItem(addressTabFolder, SWT.NONE);
		contactsTab.setText("Contacts");
		contacts = new ContactMethodsGroup(addressTabFolder);
		contactsTab.setControl(contacts);

		SWTBindingPropertyLocator.getInstance().setBindingProperty(contacts, IContactMethodsGroupRidget.WIDGET_ID);
	}

	private void createMemberInfoGroup() {
		final Group infoGroup = UIControlsFactory.createGroup(this, INFO_GROUP_LABEL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(infoGroup);
		infoGroup.setLayout(new GridLayout(6, false));
		UIControlsFactory.createLabel(infoGroup, applicationDate);

		// application date
		dateText = UIControlsFactory.createDate(infoGroup, SWT.BORDER, ViewWidgetId.memberInfo_applicationDate);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).span(2, 1).grab(true, false).applyTo(dateText);

		// effective date
		UIControlsFactory.createLabel(infoGroup, EFFECTIVE_DATE_LABEL);
		effectDateText = UIControlsFactory.createDate(infoGroup, SWT.BORDER, ViewWidgetId.memberInfo_effectiveDate);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).span(2, 1).grab(true, false).applyTo(effectDateText);

		// status
		UIControlsFactory.createLabel(infoGroup, STATUS_LABEL);
		comboStatus = UIControlsFactory.createCombo(infoGroup, ViewWidgetId.memberInfo_status);
		final GridData gd_comboStatus = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
		comboStatus.setLayoutData(gd_comboStatus);

		// phone
		UIControlsFactory.createLabel(infoGroup, PHONE_NUMBER_LABEL);
		txtPhone = UIControlsFactory.createText(infoGroup, SWT.BORDER, ViewWidgetId.memberInfo_phone);
		txtPhone.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));

	}

}
