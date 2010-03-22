package com.agritrace.edairy.demo.riena.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class InseminationRequestView extends VeterinaryRequestView {
	
	public static final String ID = InseminationRequestView.class.getName();

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
		clinicalButton.setSelection(false);
//		clinicalButton.setEnabled(false);
		clinicalButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL,
				false, false));

		Button inseminationButton = new Button(requestTypePanel, SWT.RADIO);
		inseminationButton.setText("insemination");
		inseminationButton.setSelection(true);
//		inseminationButton.setEnabled(false);
		inseminationButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL,
				false, false));
	}
	
	protected void createBottomGroup(Composite parent) {
		// request group
		Group requestGroup = new Group(parent, SWT.BORDER);
		requestGroup.setText("Request Details");
		requestGroup.setLayout(new GridLayout(2, false));
		requestGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Label l =new Label(requestGroup, SWT.NULL); //$NON-NLS-1$
		l.setText("Time Heat Detected:");
		Text textArea = new Text(requestGroup, SWT.SINGLE|SWT.BORDER);
	    textArea.setText("03/12/2010");
		textArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		
		Group inseminationGroup = new Group(requestGroup, SWT.NULL);
		inseminationGroup.setText("Insemination Numbers");
		inseminationGroup.setLayout(new GridLayout(2, false));
		inseminationGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,2,1));
		
		Label firstRequestLabel =new Label(inseminationGroup, SWT.NULL); //$NON-NLS-1$
		firstRequestLabel.setText("First Request:");
		Text firstRequestText = new Text(inseminationGroup, SWT.SINGLE|SWT.BORDER);
		firstRequestText.setText("some request");
		firstRequestText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		Label secondRequestLabel =new Label(inseminationGroup, SWT.NULL); //$NON-NLS-1$
		secondRequestLabel.setText("Second Request:");
		Text secondRequestText = new Text(inseminationGroup, SWT.SINGLE|SWT.BORDER);
		secondRequestText.setText("some request");
		secondRequestText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		
	}


}
