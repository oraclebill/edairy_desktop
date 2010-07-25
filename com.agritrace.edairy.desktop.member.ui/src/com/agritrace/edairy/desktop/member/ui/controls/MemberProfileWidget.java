package com.agritrace.edairy.desktop.member.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.ContactMethodsGroup;
import com.agritrace.edairy.desktop.common.ui.controls.location.LocationProfileWidget;
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
	private DateTime dateText;
	private DateTime effectDateText;
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

		final ContactMethodsGroup communication = new ContactMethodsGroup(composite);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(communication, "contact-methods");		
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(communication);
	}

	private void createInfoGroup() {
		final Group infoGroup = UIControlsFactory.createGroup(composite, INFO_GROUP);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(infoGroup);
		infoGroup.setLayout(new GridLayout(6, false));
		UIControlsFactory.createLabel(infoGroup, applicationDate);

		// application date
		dateText = UIControlsFactory.createDate(infoGroup,  SWT.BORDER,
				ViewWidgetId.memberInfo_applicationDate);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).span(2,1).grab(true, false).applyTo(dateText);

		// effective date
		UIControlsFactory.createLabel(infoGroup, effectiveDate);
		effectDateText = UIControlsFactory.createDate(infoGroup, SWT.BORDER,
				ViewWidgetId.memberInfo_effectiveDate);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).span(2,1).grab(true, false).applyTo(effectDateText);

		// status
		UIControlsFactory.createLabel(infoGroup, status);
		comboStatus = new ComboViewer(UIControlsFactory.createCombo(infoGroup, ViewWidgetId.memberInfo_status));
		final GridData gd_comboStatus = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
		comboStatus.getControl().setLayoutData(gd_comboStatus);

		// phone
		UIControlsFactory.createLabel(infoGroup, phoneNumber);
		txtPhone = UIControlsFactory.createText(infoGroup, SWT.BORDER, ViewWidgetId.memberInfo_phone);
		txtPhone.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));

	}

}
