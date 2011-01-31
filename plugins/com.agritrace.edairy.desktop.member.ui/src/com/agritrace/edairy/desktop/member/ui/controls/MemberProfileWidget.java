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
		createMemberCardGroup();
	}
	

	private void createMemberInfoGroup() {
		final Group infoGroup = UIControlsFactory.createGroup(this, INFO_GROUP_LABEL);
		infoGroup.setLayoutData(GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).create());
		infoGroup.setLayout(new GridLayout(6, false));
			
		GridDataFactory labelFactory = GridDataFactory.swtDefaults();
		GridDataFactory fieldFactory = GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).span(2, 1).grab(true, false);
		
		// application date
		UIControlsFactory.createLabel(infoGroup, applicationDate);
		dateText = UIControlsFactory.createDate(infoGroup, SWT.BORDER, ViewWidgetId.memberInfo_applicationDate);
		fieldFactory.applyTo(dateText);

		// effective date
		UIControlsFactory.createLabel(infoGroup, EFFECTIVE_DATE_LABEL);
		effectDateText = UIControlsFactory.createDate(infoGroup, SWT.BORDER, ViewWidgetId.memberInfo_effectiveDate);
		fieldFactory.applyTo(effectDateText);

		// status
		UIControlsFactory.createLabel(infoGroup, STATUS_LABEL);
		comboStatus = UIControlsFactory.createCombo(infoGroup, ViewWidgetId.memberInfo_status);
		fieldFactory.applyTo(comboStatus);

		// Default collection center
		labelFactory.applyTo(UIControlsFactory.createLabel(infoGroup, "Default Collection Center"));
		fieldFactory.applyTo(UIControlsFactory.createCCombo(infoGroup, ViewWidgetId.memberInfo_defaultRoute));

		// phone
		UIControlsFactory.createLabel(infoGroup, PHONE_NUMBER_LABEL);
		txtPhone = UIControlsFactory.createText(infoGroup, SWT.BORDER, ViewWidgetId.memberInfo_phone);
		fieldFactory.applyTo(txtPhone);

		// row 8: National ID
		labelFactory.applyTo(UIControlsFactory.createLabel(infoGroup, "National ID"));
		fieldFactory.applyTo(UIControlsFactory.createText(infoGroup, SWT.BORDER, ViewWidgetId.memberInfo_nationalId));

		// row 9: NSSF #
		labelFactory.applyTo(UIControlsFactory.createLabel(infoGroup, "NSSF #"));
		fieldFactory.applyTo(UIControlsFactory.createText(infoGroup, SWT.BORDER, ViewWidgetId.memberInfo_nssfId));

		// row 10: NHIF #
		labelFactory.applyTo(UIControlsFactory.createLabel(infoGroup, "NHIF #"));
		fieldFactory.applyTo(UIControlsFactory.createText(infoGroup, SWT.BORDER, ViewWidgetId.memberInfo_nhifId));

	}
	
	private void createMemberCardGroup() {
		final Group infoGroup = UIControlsFactory.createGroup(this, "Maziwa Card");
		infoGroup.setLayoutData(GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).create());
		infoGroup.setLayout(new GridLayout(6, false));
			
		GridDataFactory labelFactory = GridDataFactory.swtDefaults();
		GridDataFactory fieldFactory = GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).span(2, 1).grab(true, false);
	
		// 
		labelFactory.applyTo(UIControlsFactory.createLabel(infoGroup, "Maziwa Card #"));
		fieldFactory.applyTo(UIControlsFactory.createText(infoGroup, SWT.BORDER, ViewWidgetId.ID_MAZIWA_CARD_NUM));

		// 
		labelFactory.applyTo(UIControlsFactory.createLabel(infoGroup, "Issue Date"));
		fieldFactory.applyTo(UIControlsFactory.createDate(infoGroup, SWT.BORDER, ViewWidgetId.ID_MAZIWA_CARD_DATE));

		//		labelFactory.applyTo(UIControlsFactory.createLabel(infoGroup, "Card Status"));
		//		fieldFactory.applyTo(UIControlsFactory.createCCombo(infoGroup, SWT.BORDER, ViewWidgetId.ID_MAZIWA_CARD_STATUS));
		//	
		//		// 
		//		labelFactory.applyTo(UIControlsFactory.createLabel(infoGroup, "Issue Count"));
		//		fieldFactory.applyTo(UIControlsFactory.createText(infoGroup, SWT.BORDER, ViewWidgetId.ID_MAZIWA_CARD_ISSUE_COUNT));
	
	}

}
