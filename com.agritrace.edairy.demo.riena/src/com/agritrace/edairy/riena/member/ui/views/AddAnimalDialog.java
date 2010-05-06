package com.agritrace.edairy.riena.member.ui.views;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.model.Gender;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.tracking.AcquisitionType;
import com.agritrace.edairy.model.tracking.Farm;
import com.agritrace.edairy.model.tracking.Purpose;
import com.agritrace.edairy.model.tracking.RearingMode;
import com.agritrace.edairy.model.tracking.ReferenceAnimalType;
import com.agritrace.edairy.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.model.tracking.TrackingFactory;
import com.agritrace.edairy.riena.ui.EDairyActivator;
import com.agritrace.edairy.riena.ui.ImageRegistry;
import com.agritrace.edairy.riena.ui.views.data.SimpleFormattedDateBean;

public class AddAnimalDialog extends TitleAreaDialog implements FocusListener, SelectionListener{

	private RegisteredAnimal newAnimal = TrackingFactory.eINSTANCE.createRegisteredAnimal();

	private Text idText;
	private Text nameText;
	private Text identifierFeatureText;
	private Text dateText;
	private Text insuranceText;
	private Text speciesText;
	private Text breedText;
	private Text speciesText2;
	private Text breedText2;
	private Button femaleButton;
	private Button maleButton;
	private Button calendarButton;
	private Membership memberShip;
	
	/**
	 * MyTitleAreaDialog constructor
	 * 
	 * @param shell the parent shell
	 */
	public AddAnimalDialog(Shell shell) {
		super(shell);
	}

	public AddAnimalDialog(Shell shell, Membership selectedMembership) {
		super(shell);
		this.memberShip = selectedMembership;
	}

	/**
	 * Closes the dialog box Override so we can dispose the image we created
	 */
	@Override
	public boolean close() {
		return super.close();
	}

	/**
	 * Creates the dialog's contents
	 * 
	 * @param parent the parent composite
	 * @return Control
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		setTitle("Add Animal");
		setMessage("Please input animal details");
		return contents;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setSize(550, 450);
	}

	/**
	 * Creates the gray area
	 * 
	 * @param parent the parent composite
	 * @return Control
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		Composite dialogArea = UIControlsFactory.createComposite(composite);
		dialogArea.setLayout(new GridLayout(6,false));
		dialogArea.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));

		Label id = UIControlsFactory.createLabel(dialogArea,"ID:");
		idText = UIControlsFactory.createText(dialogArea, SWT.BORDER|SWT.SINGLE);
		idText.setTextLimit(10);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(2, 1).applyTo(idText);
		idText.addFocusListener(this);

		Label nameLabel = UIControlsFactory.createLabel(dialogArea,"Name:");
		nameText = UIControlsFactory.createText(dialogArea, SWT.BORDER|SWT.SINGLE);
		nameText.setTextLimit(10);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(2, 1).applyTo(nameText);
		nameText.addFocusListener(this);

		Label farmLabel = UIControlsFactory.createLabel(dialogArea, "Farm:");
		Combo farmCombo = UIControlsFactory.createCombo(dialogArea);
		ComboViewer farmComboViewer = new ComboViewer(farmCombo);
		farmComboViewer.setContentProvider(new ArrayContentProvider());
		if(memberShip != null){
			farmComboViewer.setInput(memberShip.getFarms());
			farmComboViewer.setLabelProvider(new LabelProvider(){
				@Override
				public String getText(Object element) {
					if(element instanceof Farm){
						return ((Farm)element).getName();
					}
					return super.getText(element);
				}
			});

		}
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(2, 1).applyTo(farmComboViewer.getControl());
		farmComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				Farm value = (Farm)((IStructuredSelection)event.getSelection()).getFirstElement();
				newAnimal.setLocation(value);
				getButton(IDialogConstants.OK_ID).setEnabled(validate());

			}
		});

		Label gender = UIControlsFactory.createLabel(dialogArea, "Gender:");
		Composite genderComposite = UIControlsFactory.createComposite(dialogArea);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(2,1).applyTo(genderComposite);
		
		genderComposite.setLayout(new GridLayout(2,false));
		
		femaleButton = UIControlsFactory.createButtonRadio(genderComposite);
		femaleButton.setText("Female");
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.FILL).grab(false, false).applyTo(femaleButton);
		femaleButton.addSelectionListener(this);
		
		maleButton = UIControlsFactory.createButtonRadio(genderComposite);
		maleButton.setText("Male");
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.FILL).grab(false, false).applyTo(maleButton);
		maleButton.addSelectionListener(this);
		maleButton.setSelection(true);

		Label purpose = UIControlsFactory.createLabel(dialogArea, "Purpse:");
		Combo purposeCombo = UIControlsFactory.createCombo(dialogArea);
		ComboViewer purposeViewer = new ComboViewer(purposeCombo);
		purposeViewer.setContentProvider(new ArrayContentProvider());
		purposeViewer.setInput(Purpose.VALUES);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(2, 1).applyTo(purposeViewer.getControl());
		purposeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				Purpose value = (Purpose)((IStructuredSelection)event.getSelection()).getFirstElement();
				newAnimal.setPurpose(value);
				getButton(IDialogConstants.OK_ID).setEnabled(validate());

			}
		});
		
		Label identifierFeature = UIControlsFactory.createLabel(dialogArea, "Identifier Feature:");
		identifierFeatureText = UIControlsFactory.createText(dialogArea, SWT.BORDER|SWT.SINGLE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(2, 1).applyTo(identifierFeatureText);
		identifierFeatureText.addFocusListener(this);
		
		Label dateLabel = UIControlsFactory.createLabel(dialogArea,"Date of Acquisition:");
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(dateLabel);

		dateText = UIControlsFactory.createText(dialogArea, SWT.READ_ONLY|SWT.BORDER);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(dateText);
	
		calendarButton = new Button(dialogArea,SWT.PUSH);
		Image calendar = EDairyActivator.getImage(ImageRegistry.calendar);
		
		calendarButton.setImage(calendar);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(17, 16).applyTo(calendarButton);
		calendarButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final Shell dialog = new Shell(Display.getDefault()
						.getActiveShell(), SWT.DIALOG_TRIM);
				dialog.setLayout(new GridLayout(3, false));

				final DateTime calendar = new DateTime(dialog, SWT.CALENDAR
						| SWT.BORDER);
				if (dateText.getText() != null && !dateText.getText().equals("")) {
					String[] textDate = dateText.getText().split("/");
					if (textDate != null && textDate.length == 3) {
						int month = new Integer(textDate[0]).intValue() - 1;
						int day = new Integer(textDate[1]).intValue();
						int year = new Integer(textDate[2]).intValue();
						calendar.setMonth(month);
						calendar.setDay(day);
						calendar.setYear(year);

					}
				}

				new Label(dialog, SWT.NONE);
				new Label(dialog, SWT.NONE);
				Button ok = new Button(dialog, SWT.PUSH);
				ok.setText("OK");
				ok.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
						false));
				ok.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						String textDate = (calendar.getMonth() + 1) + "/"
								+ calendar.getDay() + "/" + calendar.getYear();
						dateText.setText(textDate);
						SimpleFormattedDateBean dateBean = new SimpleFormattedDateBean(textDate);
						newAnimal.setDateOfAcquisition(dateBean.getDate());
						dialog.close();
					}
				});
				dialog.setDefaultButton(ok);
				dialog.pack();
				dialog.open();
				getButton(IDialogConstants.OK_ID).setEnabled(validate());

			}
		});
//		
		Label acquisionLabel = UIControlsFactory.createLabel(dialogArea,"Acquisition Type:");
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(dateLabel);
		Combo acquisitionCombo = UIControlsFactory.createCombo(dialogArea);
		ComboViewer  acquisitionViewer = new ComboViewer(acquisitionCombo);
		acquisitionViewer.setContentProvider(new ArrayContentProvider());
		acquisitionViewer.setInput(AcquisitionType.VALUES);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(2, 1).applyTo(acquisitionViewer.getControl());
		acquisitionViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				AcquisitionType value = (AcquisitionType)((IStructuredSelection)event.getSelection()).getFirstElement();
				newAnimal.setAcquisitionType(value);
				getButton(IDialogConstants.OK_ID).setEnabled(validate());
			}
		});
//		
//
		Label identifiersLabel = UIControlsFactory.createLabel(dialogArea,"Animal Identifies:");
		Combo identifiersCombo = UIControlsFactory.createCombo(dialogArea);
		ComboViewer identifiersViewer = new ComboViewer(identifiersCombo);
		identifiersViewer.setContentProvider(new ArrayContentProvider());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(identifiersViewer.getControl());
//		
		Button addIdentiferButton = UIControlsFactory.createButton(dialogArea, "...");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(false, false).applyTo(addIdentiferButton);

		Label ownerLabel = UIControlsFactory.createLabel(dialogArea,"Past Owners:");
		Combo ownersCombo = UIControlsFactory.createCombo(dialogArea);
		ComboViewer ownersViewer = new ComboViewer(ownersCombo);
		ownersViewer.setContentProvider(new ArrayContentProvider());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(ownersViewer.getControl());

		Button addOwnersButton = UIControlsFactory.createButton(dialogArea, "...");
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false, false).applyTo(addOwnersButton);
		
		Label insuranceLabel = UIControlsFactory.createLabel(dialogArea,"Insurance Number:");
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(dateLabel);
		insuranceText = UIControlsFactory.createText(dialogArea, SWT.SINGLE|SWT.BORDER);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).span(2,1).applyTo(insuranceText);
		insuranceText.addFocusListener(this);
		
		Label rearingMode = UIControlsFactory.createLabel(dialogArea,"Rearing Mode:");
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(dateLabel);
		Combo rearingModeCombo = UIControlsFactory.createCombo(dialogArea);
		ComboViewer rearingModeViewer = new ComboViewer(rearingModeCombo);
		rearingModeViewer.setContentProvider(new ArrayContentProvider());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(rearingModeViewer.getControl());
		rearingModeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				RearingMode value = (RearingMode)((IStructuredSelection)event.getSelection()).getFirstElement();
				newAnimal.setRearingMode(value);
				getButton(IDialogConstants.OK_ID).setEnabled(validate());
			}
		});
		rearingModeViewer.setInput(RearingMode.VALUES);
		
		Group animalType = UIControlsFactory.createGroup(dialogArea, "Animal Type");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,false).span(3,1).applyTo(animalType);
		animalType.setLayout(new GridLayout(3,false));
		
		Label speciesLabel = UIControlsFactory.createLabel(animalType,"Species:");
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(dateLabel);
		speciesText = UIControlsFactory.createText(animalType, SWT.SINGLE|SWT.BORDER);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).span(2,1).applyTo(speciesText);
		speciesText.addFocusListener(this);
		
		Label breedLabel = UIControlsFactory.createLabel(animalType,"Breed:");
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(dateLabel);
		breedText = UIControlsFactory.createText(animalType, SWT.SINGLE|SWT.BORDER);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).span(2,1).applyTo(breedText);
		breedText.addFocusListener(this);
		
		Group sireType = UIControlsFactory.createGroup(dialogArea, "Sire Type");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,false).span(3,1).applyTo(sireType);
		sireType.setLayout(new GridLayout(3,false));
		
		Label speciesLabel2 = UIControlsFactory.createLabel(sireType,"Species:");
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(dateLabel);
		speciesText2 = UIControlsFactory.createText(sireType, SWT.SINGLE|SWT.BORDER);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).span(2,1).applyTo(speciesText2);
		speciesText2.addFocusListener(this);
		
		Label breedLabel2 = UIControlsFactory.createLabel(sireType,"Breed:");
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(dateLabel);
		breedText2= UIControlsFactory.createText(sireType, SWT.SINGLE|SWT.BORDER);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).span(2,1).applyTo(breedText2);
		breedText2.addFocusListener(this);
		
		return composite;
	}

	/**
	 * Creates the buttons for the button bar
	 * 
	 * @param parent the parent composite
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
//		okButton.setEnabled(false);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, true);

	}

	public RegisteredAnimal getNewAnimal() {
		return newAnimal;
	}

	public void setNewAnimal(RegisteredAnimal newAnimal) {
		this.newAnimal = newAnimal;
	}
	
	private boolean validate(){
     	return newAnimal.getGivenName() != null && newAnimal.getLocation() != null && newAnimal.getAcquisitionType() != null && newAnimal.getDateOfAcquisition() != null && newAnimal.getPurpose() != null && newAnimal.getRearingMode() != null;
	}

	private ControlDecoration createDecorator(Text text, String message) {
		ControlDecoration controlDecoration = new ControlDecoration(text,
				SWT.LEFT | SWT.TOP);
		controlDecoration.setDescriptionText(message);
		FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault()
		.getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
		controlDecoration.setImage(fieldDecoration.getImage());
		return controlDecoration;
	}

	

	public Membership getMemberShip() {
		return memberShip;
	}

	public void setMemberShip(Membership memberShip) {
		this.memberShip = memberShip;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource() == idText){
//			newAnimal.setAnimnalRegistrationId(value);
		}else if(e.getSource()==nameText){
			newAnimal.setGivenName(nameText.getText());
		}else if(e.getSource()==identifierFeatureText){
			newAnimal.setIdentifyingFeatures(identifierFeatureText.getText());
		}else if(e.getSource() == insuranceText){
			newAnimal.setInsuranceNumber(insuranceText.getText());
		}else if(e.getSource() == speciesText){
			 ReferenceAnimalType animalType = newAnimal.getAnimalType();
			 if(animalType == null){
				 animalType = TrackingFactory.eINSTANCE.createReferenceAnimalType();
				 newAnimal.setAnimalType(animalType);
			 }
			 animalType.setSpecies(speciesText.getText());
		}else if(e.getSource() == breedText){
			 ReferenceAnimalType animalType = newAnimal.getAnimalType();
			 if(animalType == null){
				 animalType = TrackingFactory.eINSTANCE.createReferenceAnimalType();
				 newAnimal.setAnimalType(animalType);
			 }
			 animalType.setBreed(breedText.getText());
		}else if(e.getSource() == speciesText2){
			 ReferenceAnimalType animalType = newAnimal.getSireType();
			 if(animalType == null){
				 animalType = TrackingFactory.eINSTANCE.createReferenceAnimalType();
				 newAnimal.setSireType(animalType);
			 }
			 animalType.setSpecies(speciesText2.getText());
		}else if(e.getSource() == breedText2){
			 ReferenceAnimalType animalType = newAnimal.getSireType();
			 if(animalType == null){
				 animalType = TrackingFactory.eINSTANCE.createReferenceAnimalType();
				 newAnimal.setSireType(animalType);
			 }
			 animalType.setBreed(breedText2.getText());
		}
		
		getButton(IDialogConstants.OK_ID).setEnabled(validate());
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if(femaleButton.getSelection()){
			newAnimal.setGender(Gender.FEMALE);
		}else if(maleButton.getSelection()){
			newAnimal.setGender(Gender.MALE);
		}
		getButton(IDialogConstants.OK_ID).setEnabled(validate());
		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		widgetSelected(e);
		
	}
}