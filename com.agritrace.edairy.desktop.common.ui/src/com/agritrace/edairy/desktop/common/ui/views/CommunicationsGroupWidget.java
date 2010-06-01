package com.agritrace.edairy.desktop.common.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;

public class CommunicationsGroupWidget {
	private Group communicationGroup;

	public static final String COMMUNICATION_GROUP_TXT="Communications";
	public static final String EMAIL_TXT="Email:";
	public static final String PHONE_TXT="Phone:";

	private Text emailText;
	private Text phoneText;
	private Text secondPhoneText;

	public CommunicationsGroupWidget(Composite parent){
		communicationGroup = UIControlsFactory.createGroup(parent, COMMUNICATION_GROUP_TXT);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true,false).applyTo(communicationGroup);
		creatDirectonsGroup();
	}

	private void creatDirectonsGroup() {
		communicationGroup.setLayout(new GridLayout(2,false));
		Label emailLabel = UIControlsFactory.createLabel(communicationGroup, EMAIL_TXT);
		emailText = UIControlsFactory.createText(communicationGroup, SWT.SINGLE|SWT.BORDER, ViewWidgetId.EMAIL_TEXT);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true,false).applyTo(emailText);

		Label phoneLabel = UIControlsFactory.createLabel(communicationGroup, PHONE_TXT);
		phoneText = UIControlsFactory.createText(communicationGroup, SWT.SINGLE|SWT.BORDER, ViewWidgetId.PHONE_TEXT);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true,false).applyTo(phoneText);
		
		Label phoneLabel2 = UIControlsFactory.createLabel(communicationGroup, PHONE_TXT);
		secondPhoneText = UIControlsFactory.createText(communicationGroup, SWT.SINGLE|SWT.BORDER, ViewWidgetId.SECOND_PHONE_TEXT);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true,false).applyTo(secondPhoneText);
	}
	
	public Group getGroup() {
		return communicationGroup;
	}
}
