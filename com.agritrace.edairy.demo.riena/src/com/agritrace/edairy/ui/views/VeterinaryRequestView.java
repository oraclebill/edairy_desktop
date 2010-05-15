package com.agritrace.edairy.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
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

import com.agritrace.edairy.desktop.common.ui.ImageRegistry;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.ui.EDairyActivator;

public class VeterinaryRequestView extends ViewPart implements SelectionListener {

    private Combo nameCombo;
    private Combo farmCombo;
    private Text farmlocation;
    private Button calendarButton;
    private Button nameSearchButton;
//    private Button farmSearchButton;
    private Text textField;

    public VeterinaryRequestView() {
    }

    public static final String ID = VeterinaryRequestView.class.getName();

    @Override
    public void createPartControl(Composite parent) {
	parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
	parent.setLayout(new GridLayout(1, false));

	final GridDataFactory gdf = GridDataFactory.fillDefaults().grab(true, false);
	parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
	parent.setLayout(new GridLayout(1, false));

	final Composite upperPanel = UIControlsFactory.createComposite(parent);
	upperPanel.setLayout(new GridLayout());
	gdf.applyTo(upperPanel);

	createHeadlerLabel(upperPanel);

	// request group
	final Group requestGroup = UIControlsFactory.createGroup(parent, "");
	// requestGroup.setText("Animal Service Request");
	requestGroup.setLayout(new GridLayout(3, false));
	requestGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

	UIControlsFactory.createLabel(requestGroup, "Date:");

	textField = UIControlsFactory.createText(requestGroup);
	textField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	textField.setText("3/22/2009");

	calendarButton = UIControlsFactory.createButton(requestGroup);
	final Image searchImage = EDairyActivator.getImage(ImageRegistry.calendar);
	calendarButton.setImage(searchImage);
	calendarButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

	calendarButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent e) {
		final Shell dialog = new Shell(Display.getDefault().getActiveShell(), SWT.DIALOG_TRIM);
		dialog.setLayout(new GridLayout(3, false));

		final DateTime calendar = new DateTime(dialog, SWT.CALENDAR | SWT.BORDER);
		if (textField.getText() != null && !textField.getText().equals("")) {
		    final String[] textDate = textField.getText().split("/");
		    if (textDate != null && textDate.length == 3) {
			final int month = new Integer(textDate[0]).intValue() - 1;
			final int day = new Integer(textDate[1]).intValue();
			final int year = new Integer(textDate[2]).intValue();
			calendar.setMonth(month);
			calendar.setDay(day);
			calendar.setYear(year);

		    }
		}

		new Label(dialog, SWT.NONE);
		new Label(dialog, SWT.NONE);
		final Button ok = new Button(dialog, SWT.PUSH);
		ok.setText("OK");
		ok.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		ok.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
			final String textDate = calendar.getMonth() + 1 + "/" + calendar.getDay() + "/"
				+ calendar.getYear();
			textField.setText(textDate);
			dialog.close();
		    }
		});
		dialog.setDefaultButton(ok);
		dialog.pack();
		dialog.open();
	    }
	});
	UIControlsFactory.createLabel(requestGroup, "MemberID:");

	final Text textId = UIControlsFactory.createText(requestGroup);
	textId.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
	textId.setText("LM212234");

	UIControlsFactory.createLabel(requestGroup, "Member Name:");

	nameCombo = UIControlsFactory.createCombo(requestGroup);
	nameCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	nameCombo.setItems(new String[] { "Joseph Limuru", "John Smith" });
	nameCombo.setText("Joseph Limuru");
	nameCombo.addSelectionListener(this);

	nameSearchButton = UIControlsFactory.createButton(requestGroup);
	nameSearchButton.setImage(searchImage);
	nameSearchButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
	nameSearchButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent e) {
		final Shell shell = new Shell(Display.getDefault().getActiveShell());
		shell.setSize(250, 400);
		final MemberSearchDialog dialog = new MemberSearchDialog(shell);
		dialog.open();
	    }

	    @Override
	    public void widgetDefaultSelected(SelectionEvent e) {
		widgetSelected(e);
	    }
	});

	UIControlsFactory.createLabel(requestGroup, "Farm Name:");

	farmCombo = UIControlsFactory.createCombo(requestGroup);
	farmCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
	farmCombo.setItems(new String[] { "Golden Star", "Little Farm" });
	farmCombo.setText("Golden Star");
	farmCombo.addSelectionListener(this);

	// farmSearchButton = new Button(requestGroup, SWT.PUSH);
	// farmSearchButton.setImage(searchImage);
	// farmSearchButton.setLayoutData(new
	// GridData(SWT.FILL,SWT.FILL,false,false));

	UIControlsFactory.createLabel(requestGroup, "Farm Location:");

	farmlocation = UIControlsFactory.createText(requestGroup, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
	final GridData locationGD = new GridData(SWT.FILL, SWT.FILL, true, false);
	locationGD.heightHint = 50;
	locationGD.horizontalSpan = 2;
	farmlocation.setLayoutData(locationGD);
	farmlocation.setText("");

	// createRequestTypePanel(requestGroup);
	createBottomGroup(requestGroup);

	// Composite bottomPanel = new Composite(parent, SWT.NULL);
	// bottomPanel.setLayoutData(new
	// GridData(SWT.FILL,SWT.FILL,true,false));
	// bottomPanel.setLayout(new GridLayout(1,false));

	final Composite savePanel = UIControlsFactory.createComposite(requestGroup);
	savePanel.setLayoutData(new GridData(SWT.END, SWT.FILL, false, false, 3, 1));
	savePanel.setLayout(new GridLayout(2, false));

	final Button saveButton = UIControlsFactory.createButton(savePanel);
	saveButton.setText("Save");
	saveButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

	final Button cancelButton = UIControlsFactory.createButton(savePanel);
	cancelButton.setText("Cancel");
	cancelButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

    }

    protected void createHeadlerLabel(Composite parent) {

	final Label titleLabel = UIControlsFactory.createLabel(parent, "Veterinary Service Request");
	// Label titleLabel = new Label(parent, SWT.NULL);

	final Font labelFont = JFaceResources.getFontRegistry().getBold(JFaceResources.HEADER_FONT);
	titleLabel.setFont(labelFont);
    }

    protected void createBottomGroup(Composite parent) {
	// request group
	final Group requestGroup = UIControlsFactory.createGroup(parent, "Request Details");
	requestGroup.setLayout(new GridLayout(1, false));
	requestGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));

	UIControlsFactory.createLabel(requestGroup, "Complaint:");
	final Text textArea = UIControlsFactory.createText(requestGroup, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL
		| SWT.BORDER);
	// Text textArea = new Text(requestGroup, SWT.MULTI
	// | SWT.H_SCROLL | SWT.V_SCROLL|SWT.BORDER);
	textArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    }

    @Override
    public void setFocus() {
	// TODO Auto-generated method stub

    }

    @Override
    public void widgetSelected(SelectionEvent e) {
	if (e.getSource() == nameCombo) {
	    final int i = nameCombo.getSelectionIndex();
	    if (i == 0) {
		farmCombo.setItems(new String[] { "Golden Star", "Little Farm" });
		farmCombo.select(0);

	    } else if (i == 1) {
		farmCombo.setItems(new String[] { "John's Farm", "Harvest Farm" });
		farmCombo.select(0);

	    }
	} else if (e.getSource() == farmCombo) {
	    final int i = farmCombo.getSelectionIndex();
	    if (i < 0) {
		farmlocation.setText("");
	    } else if (i == 0) {
		farmlocation.setText("222 Reading Rd. Princeton, NJ, 08550");
	    } else if (i == 1) {
		farmlocation.setText("15 North Post Rd. Princeton, NJ, 08550");

	    }
	}

    }

    @Override
    public void widgetDefaultSelected(SelectionEvent e) {
	widgetSelected(e);
    }

}
