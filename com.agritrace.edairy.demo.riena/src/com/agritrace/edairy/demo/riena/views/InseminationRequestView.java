package com.agritrace.edairy.demo.riena.views;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.demo.riena.Activator;
import com.agritrace.edairy.demo.riena.ImageRegistry;

public class InseminationRequestView extends VeterinaryRequestView {
	
	public static final String ID = InseminationRequestView.class.getName();
	
	private Text textArea;
	
	private Button calendarButton;
	
	protected void createHeadlerLabel(Composite parent){
		

		Label titleLabel = new Label(parent, SWT.NULL);
		titleLabel.setText("Insemination Service Request");

		Font labelFont = JFaceResources.getFontRegistry().getBold(
				JFaceResources.HEADER_FONT);
		titleLabel.setFont(labelFont);
	}

	protected void createRequestTypePanel(Composite parent) {
		Composite requestTypePanel = new Composite(parent,
				SWT.NULL);
		requestTypePanel.setLayout(new GridLayout(3, false));
		GridData gd = new GridData(SWT.FILL,SWT.FILL, true, false);
		gd.horizontalSpan =3;
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
		Group requestGroup = new Group(parent, SWT.NULL);
		requestGroup.setText("Request Details");
		requestGroup.setLayout(new GridLayout(3, false));
		requestGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,3,1));

		Label l =new Label(requestGroup, SWT.NULL); //$NON-NLS-1$
		l.setText("Time Heat Detected:");
		textArea = new Text(requestGroup, SWT.SINGLE|SWT.BORDER);
	    textArea.setText("3/12/2010");
		textArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		calendarButton = new Button(requestGroup, SWT.PUSH);
		Image searchImage = Activator.getImage(ImageRegistry.search);
		calendarButton.setImage(searchImage);
		calendarButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));

		calendarButton.addSelectionListener (new SelectionAdapter () {
			public void widgetSelected (SelectionEvent e) {
				final Shell dialog = new Shell (Display.getDefault().getActiveShell(), SWT.DIALOG_TRIM);
				dialog.setLayout (new GridLayout (3, false));

				final DateTime calendar = new DateTime (dialog, SWT.CALENDAR | SWT.BORDER);
				if(textArea.getText()!=null && !textArea.getText().equals("")){
					String[] textDate = textArea.getText().split("/");
					if(textDate != null && textDate.length==3){
						int month = new Integer(textDate[0]).intValue()-1;
						int day = new Integer(textDate[1]).intValue();
						int year = new Integer(textDate[2]).intValue();
						calendar.setMonth(month);
						calendar.setDay(day);
						calendar.setYear(year);

					}
				}

				new Label (dialog, SWT.NONE);
				new Label (dialog, SWT.NONE);
				Button ok = new Button (dialog, SWT.PUSH);
				ok.setText ("OK");
				ok.setLayoutData(new GridData (SWT.FILL, SWT.CENTER, false, false));
				ok.addSelectionListener (new SelectionAdapter () {
					public void widgetSelected (SelectionEvent e) {
						String textDate = (calendar.getMonth () + 1) + "/" + calendar.getDay () + "/" + calendar.getYear ();
						textArea.setText(textDate);
						dialog.close ();
					}
				});
				dialog.setDefaultButton (ok);
				dialog.pack ();
				dialog.open ();
			}
		});

		
//		Group inseminationGroup = new Group(requestGroup, SWT.NULL);
//		inseminationGroup.setText("");
//		inseminationGroup.setLayout(new GridLayout(2, false));
//		inseminationGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,2,1));
//		
		Label firstRequestLabel =new Label(requestGroup, SWT.NULL); //$NON-NLS-1$
		firstRequestLabel.setText("Insemination Numbers");
		
		
		Spinner spinner = new Spinner (requestGroup, SWT.BORDER);
		spinner.setMinimum(0);
		spinner.setMaximum(100);
		spinner.setSelection(1);
		spinner.setIncrement(1);
		spinner.setPageIncrement(10);
		spinner.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false));


		
		
	}


}
