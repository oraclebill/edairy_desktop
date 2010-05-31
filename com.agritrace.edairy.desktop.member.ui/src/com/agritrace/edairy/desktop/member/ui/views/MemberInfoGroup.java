package com.agritrace.edairy.desktop.member.ui.views;

import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MemberInfoGroup {

	public static final String MEMBERID = "Member ID:";
	public static final String HONORIFIC = "Hon.";
	public static final String FIRST_NAME = "Given";
	public static final String MIDDLE_NAME = "Middle :";
	public static final String ADDITIONAL_NAMES = "Additional";
	public static final String LAST_NAME = "Family:";
	public static final String SUFFIX = "Suffix";


	private Label photoLabel;
	private final Composite composite;
	private Label txtId;
	private CCombo cmbHonorable;
	private Text txtFirst;
	private Text txtMiddle;
	private Text txtLast;
	private CCombo cmbSuffix;
	private Text txtAdditional;
	private Text txtSuffix;


	public MemberInfoGroup(Composite parent) {
		composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(new GridLayout(1, false));
		initGUI();
	}

	public void initGUI() {

		final Composite upperPanel = UIControlsFactory.createComposite(composite);
		upperPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		final GridLayout upperPanelLayout = new GridLayout();
		upperPanelLayout.numColumns = 4;
		upperPanelLayout.makeColumnsEqualWidth = false;
		upperPanel.setLayout(upperPanelLayout);
		upperPanel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		// member Id
		UIControlsFactory.createLabel(upperPanel, MEMBERID);

		txtId = UIControlsFactory.createLabel(upperPanel, "Member Id : ",ViewWidgetId.memberInfo_id);
		final GridData gd_txtId = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		 gd_txtId.widthHint = 150;
		txtId.setLayoutData(gd_txtId);

		photoLabel = UIControlsFactory.createLabel(upperPanel, ""); //$NON-NLS-1$
		//	photoLabel.setImage(Activator.getImage(ImageRegistry.sample_memberphoto));
		photoLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, true, 2, 4));
		
		UIControlsFactory.createLabel(upperPanel, HONORIFIC);
		cmbHonorable = UIControlsFactory.createCCombo(upperPanel, ViewWidgetId.memberInfo_honorific); // (upperPanel, SWT.BORDER, ViewWidgetId.memberInfo_honorific);
		final GridData gd_txtHonor = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_txtHonor.widthHint = 150;
		 cmbHonorable.setLayoutData(gd_txtHonor);

		UIControlsFactory.createLabel(upperPanel, FIRST_NAME);
		txtFirst = UIControlsFactory.createText(upperPanel, SWT.BORDER, ViewWidgetId.memberInfo_firstName);
		final GridData gd_txtFirst = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		 gd_txtFirst.widthHint = 150;
		txtFirst.setLayoutData(gd_txtFirst);

		UIControlsFactory.createLabel(upperPanel, MIDDLE_NAME);
		txtMiddle = UIControlsFactory.createText(upperPanel, SWT.BORDER, ViewWidgetId.memberInfo_middleName);
		final GridData gd_txtMiddle = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_txtMiddle.widthHint = 150;
		txtMiddle.setLayoutData(gd_txtMiddle);

		UIControlsFactory.createLabel(upperPanel, LAST_NAME);
		txtLast = UIControlsFactory.createText(upperPanel, SWT.BORDER, ViewWidgetId.memberInfo_lastName);
		final GridData gd_txtLast = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_txtLast.widthHint = 150;
		txtLast.setLayoutData(gd_txtLast);

	
		UIControlsFactory.createLabel(upperPanel, ADDITIONAL_NAMES);
		txtAdditional = UIControlsFactory.createText(upperPanel, SWT.BORDER, ViewWidgetId.memberInfo_additionalNames);
		final GridData gd_txtAddtl = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_txtAddtl.widthHint = 150;
		txtAdditional.setLayoutData(gd_txtAddtl);

		UIControlsFactory.createCCombo(upperPanel, SUFFIX);
		txtSuffix = UIControlsFactory.createText(upperPanel, SWT.BORDER, ViewWidgetId.memberInfo_suffix);
		final GridData gd_txtSuffix = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_txtSuffix.widthHint = 150;
		txtSuffix.setLayoutData(gd_txtSuffix);

	
	}

	


	public Composite getComposite() {
		return composite;
	}
}
