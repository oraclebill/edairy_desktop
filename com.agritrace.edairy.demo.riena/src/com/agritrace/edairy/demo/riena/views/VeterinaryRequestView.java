package com.agritrace.edairy.demo.riena.views;


import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import com.agritrace.edairy.demo.riena.Activator;
import com.agritrace.edairy.demo.riena.ImageRegistry;

public class VeterinaryRequestView extends ViewPart implements SelectionListener{

	private Combo nameCombo ;
	private Combo farmCombo;
	private Text farmlocation;
	private Button calendarButton;
	private Button nameSearchButton;
	private Button farmSearchButton;
	private Text textField;

	public VeterinaryRequestView() {
	}

	public static final String ID = VeterinaryRequestView.class.getName();

	@Override
	public void createPartControl(Composite parent) {
		parent.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));
		parent.setLayout(new GridLayout(1, false));
		
		Composite upperPanel = new Composite(parent, SWT.BORDER);
		upperPanel.setLayout(new GridLayout());
		upperPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		createHeadlerLabel(upperPanel);

		// request group
		Group requestGroup = new Group(parent, SWT.BORDER);
		//requestGroup.setText("Animal Service Request");
		requestGroup.setLayout(new GridLayout(3, false));
		requestGroup
		.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Label dateLable = new Label(requestGroup,SWT.NULL); //$NON-NLS-1$
		dateLable.setText("Date:");
		textField = new Text(requestGroup,SWT.BORDER);
		textField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false));
		textField.setText("3/22/2009");

		calendarButton = new Button(requestGroup, SWT.PUSH);
		Image searchImage = Activator.getImage(ImageRegistry.search);
		calendarButton.setImage(searchImage);
		calendarButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));

		calendarButton.addSelectionListener (new SelectionAdapter () {
			public void widgetSelected (SelectionEvent e) {
				final Shell dialog = new Shell (Display.getDefault().getActiveShell(), SWT.DIALOG_TRIM);
				dialog.setLayout (new GridLayout (3, false));

				final DateTime calendar = new DateTime (dialog, SWT.CALENDAR | SWT.BORDER);
				if(textField.getText()!=null && !textField.getText().equals("")){
					String[] textDate = textField.getText().split("/");
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
						textField.setText(textDate);
						dialog.close ();
					}
				});
				dialog.setDefaultButton (ok);
				dialog.pack ();
				dialog.open ();
			}
		});
		Label memberIdLabel = new Label(requestGroup,SWT.NULL); //$NON-NLS-1$
		memberIdLabel.setText("MemberID:");
		Text textId = new Text(requestGroup,SWT.BORDER);
		textId.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		textId.setText("LM212234");

		Label memberNameLabel = new Label(requestGroup,SWT.NULL); //$NON-NLS-1$
		memberNameLabel.setText("Member Name:");

		nameCombo = new Combo(requestGroup,SWT.BORDER|SWT.DROP_DOWN|SWT.READ_ONLY);
		nameCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false));
		nameCombo.setItems(new String[]{"Joseph Limuru","John Smith"});
		nameCombo.setText("Joseph Limuru");
		nameCombo.addSelectionListener(this);

		nameSearchButton = new Button(requestGroup, SWT.PUSH);
		nameSearchButton.setImage(searchImage);
		nameSearchButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));
		nameSearchButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected (SelectionEvent e) {
				Shell shell = new Shell(Display.getDefault().getActiveShell());
				shell.setSize(250, 400);
				MemberSearchDialog dialog = new MemberSearchDialog(shell);
				 dialog.open();
			}

			public void widgetDefaultSelected (SelectionEvent e) {
				widgetSelected(e);
			}
		});

		Label farmLabel = new Label(requestGroup,SWT.NULL); //$NON-NLS-1$
		farmLabel.setText("Farm Name:");

		farmCombo = new Combo(requestGroup,SWT.BORDER|SWT.DROP_DOWN|SWT.READ_ONLY);
		farmCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false,2,1));
		farmCombo.setItems(new String[]{"Golden Star","Little Farm"});
		farmCombo.setText("Golden Star");
		farmCombo.addSelectionListener(this);

//		farmSearchButton = new Button(requestGroup, SWT.PUSH);
//		farmSearchButton.setImage(searchImage);
//		farmSearchButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));

		Label locationLabel = new Label(requestGroup,SWT.NULL); //$NON-NLS-1$
		locationLabel.setText("Farm Location:"); //$NON-NLS-1$
		farmlocation = new Text(requestGroup,SWT.BORDER|SWT.H_SCROLL|SWT.V_SCROLL|SWT.MULTI);
		GridData locationGD = new GridData(SWT.FILL, SWT.FILL, true,false);
		locationGD.heightHint = 50;
		locationGD.horizontalSpan=2;
		farmlocation.setLayoutData(locationGD);
		farmlocation.setText("");


		createRequestTypePanel(requestGroup);
		createBottomGroup(requestGroup);
		
//		Composite bottomPanel = new Composite(parent, SWT.NULL);
//		bottomPanel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
//		bottomPanel.setLayout(new GridLayout(1,false));
		
		Composite savePanel = new Composite(requestGroup, SWT.NULL);
		savePanel.setLayoutData(new GridData(SWT.END,SWT.FILL,false,false,3,1));
		savePanel.setLayout(new GridLayout(2,false));
		
		Button saveButton = new Button(savePanel,SWT.PUSH);
		saveButton.setText("Save");
		saveButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		
		Button cancelButton = new Button(savePanel,SWT.PUSH);
		cancelButton.setText("Cancel");
		cancelButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));

	}
	
	protected void createHeadlerLabel(Composite parent){
		

		Label titleLabel = new Label(parent, SWT.NULL);
		titleLabel.setText("Veterinary Service Request");

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
		Group requestGroup = new Group(parent, SWT.NULL);
		requestGroup.setText("Request Details");
		requestGroup.setLayout(new GridLayout(1, false));
		requestGroup
		.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,3,1));

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

	@Override
	public void widgetSelected(SelectionEvent e) {
		if(e.getSource() == nameCombo){
			int i = nameCombo.getSelectionIndex();
			if(i == 0){
				farmCombo.setItems(new String[]{"Golden Star","Little Farm"});
				farmCombo.select(0);

			}else if(i == 1){
				farmCombo.setItems(new String[]{"John's Farm","Harvest Farm"});
				farmCombo.select(0);

			}
		}else if(e.getSource() == farmCombo){
			int i = farmCombo.getSelectionIndex();
			if(i<0){
				farmlocation.setText("");
			}else if(i == 0){
				farmlocation.setText("222 Reading Rd. Princeton, NJ, 08550");
			}else if(i ==1){
				farmlocation.setText("15 North Post Rd. Princeton, NJ, 08550");

			}
		}

	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		widgetSelected(e);
	}

}
