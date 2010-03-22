package com.agritrace.edairy.demo.riena.views;

import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class VeterinaryRequestView extends ViewPart {

	public VeterinaryRequestView() {
	}

	public static final String ID = VeterinaryRequestView.class.getName();

	@Override
	public void createPartControl(Composite parent) {
		parent.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));
		parent.setLayout(new GridLayout(1, false));

		// request group
		Group requestGroup = new Group(parent, SWT.BORDER);
		requestGroup.setText("Animal Serive Request");
		requestGroup.setLayout(new GridLayout(2, false));
		requestGroup
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		Label dateLable = new Label(requestGroup,SWT.NULL); //$NON-NLS-1$
		dateLable.setText("Date:");
		Text textField = new Text(requestGroup,SWT.BORDER);
		textField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false));
		textField.setText("03/22/2009");

		Label memberIdLabel = new Label(requestGroup,SWT.NULL); //$NON-NLS-1$
		memberIdLabel.setText("MemberID:");
		Text textId = new Text(requestGroup,SWT.BORDER);
		textId.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		textId.setText("LM212234");

		Label memberNameLabel = new Label(requestGroup,SWT.NULL); //$NON-NLS-1$
		memberNameLabel.setText("Member Name:");
		
		Text textName = new Text(requestGroup,SWT.BORDER);
		textName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false));
		textName.setText("Joseph Limuru");
		Label locationLabel = new Label(requestGroup,SWT.NULL); //$NON-NLS-1$
		locationLabel.setText("Farm Location:"); //$NON-NLS-1$
		Text farmlocation = new Text(requestGroup,SWT.BORDER);
		farmlocation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false));
		farmlocation.setText("222 Reading Rd. Princeton, NJ, 08550");

		
		createRequestTypePanel(requestGroup);
		createBottomGroup(parent);

	}

	protected void createRequestTypePanel(Composite parent) {
		Composite requestTypePanel = new Composite(parent,
				SWT.NULL);
		requestTypePanel.setLayout(new GridLayout(3, false));
		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, false);
		gd.horizontalSpan =2;
		requestTypePanel.setLayoutData(gd);

		Label requestTypeLabel = new Label(requestTypePanel, SWT.NULL);
		requestTypeLabel.setText("Request Type:");
		requestTypeLabel.setLayoutData(new GridData(SWT.BEGINNING,
				SWT.BEGINNING, false, false));

		Button clinicalButton = new Button(requestTypePanel, SWT.RADIO);
		clinicalButton.setText("clinical");
		clinicalButton.setSelection(true);
//		clinicalButton.setEnabled(false);
		clinicalButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL,
				false, false));

		Button inseminationButton = new Button(requestTypePanel, SWT.RADIO);
		inseminationButton.setText("insemination");
		inseminationButton.setSelection(false);
//		inseminationButton.setEnabled(false);
		inseminationButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL,
				false, false));
	}

	protected void createBottomGroup(Composite parent) {
		// request group
		Group requestGroup = new Group(parent, SWT.BORDER);
		requestGroup.setText("Request Details");
		requestGroup.setLayout(new GridLayout(1, false));
		requestGroup
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Label l =new Label(requestGroup, SWT.NULL); //$NON-NLS-1$
		l.setText("Complaint:");
		Text textArea = new Text(requestGroup, SWT.MULTI
				| SWT.H_SCROLL | SWT.V_SCROLL|SWT.BORDER);
		textArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

}
