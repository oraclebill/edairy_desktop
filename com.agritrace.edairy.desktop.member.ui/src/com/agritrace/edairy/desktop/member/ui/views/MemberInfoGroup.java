package com.agritrace.edairy.desktop.member.ui.views;

import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;

public class MemberInfoGroup {

	public static final String memberId = "Member ID:";
	public static final String firstName = "Name:";


	private final Composite composite;
	private Label txtId;
	private Text txtFirst;
	private Label photoLabel;


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
		UIControlsFactory.createLabel(upperPanel, memberId);

		txtId = UIControlsFactory.createLabel(upperPanel, "Member Id : ",ViewWidgetId.memberInfo_id);
		final GridData gd_txtId = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		 gd_txtId.widthHint = 150;
		txtId.setLayoutData(gd_txtId);

		photoLabel = UIControlsFactory.createLabel(upperPanel, ""); //$NON-NLS-1$
		//	photoLabel.setImage(Activator.getImage(ImageRegistry.sample_memberphoto));
		photoLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, true, 2, 4));
		
		UIControlsFactory.createLabel(upperPanel, firstName);
		txtFirst = UIControlsFactory.createText(upperPanel, SWT.BORDER, ViewWidgetId.memberInfo_firstName);
		final GridData gd_txtFirst = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		 gd_txtFirst.widthHint = 150;
		txtFirst.setLayoutData(gd_txtFirst);

	
	}

	


	public Composite getComposite() {
		return composite;
	}
}
