package com.agritrace.edairy.desktop.member.ui.views;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.model.dairy.Membership;

public class AddMemberShipDialog extends TitleAreaDialog implements ModifyListener{

	
	private Membership memberShip;

	private Text idText;
	private Text nameText;
	private Combo route;
	private Text photoText;
	private Button browseButton;
	
	//address group text fields
	private Text txtAddress;
	private Text txtSection;
	private Text estateAddress;
	private Text txtVillage;
	private Text txtSubLocation;
	private Text txtLocation; 
	private Text txtDivision;
	private Text txtDistrict;
	private Text txtPostal;

	//address group
	public static final String ADDRESS_TAB="Address";
	public static final String ADDRESS_LABEL="Address:";
	public static final String SECTION_LABEL="Section/Homestead:";
	public static final String ESTATE_LABEL="Estate/Nearest Center:";
	public static final String LOCATION_LABEL="Location:";
	public static final String SUBLOCATION_LABEL="Sublocation";
	public static final String VILLAGE_LABEL="Village:";
	public static final String DIVISION_LABEL="Division";
	public static final String DISTRICT_LABEL="District:";
	public static final String PROVINCE_LABEL="Province:";
	public static final String POSTAL_CODE_LABEL="Postal Code:";


	private ControlDecoration idError;

	public AddMemberShipDialog(Shell parentShell) {
		super(parentShell);
		memberShip = EMFObjectUtil.createMembership();

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
		setTitle("Add Membership");
		setMessage("Please input membership details. Fields with \"*\" are required.");
		return contents;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setSize(450, 330);
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
		idText.setTextLimit(50);
		idText.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,2,1));
		idText.addModifyListener(this);
		createDecorator(idText,"",false);
		idError = createDecorator(idText,"Invalid format, only number String is allowed",true);
		idError.hide();

		Label name = UIControlsFactory.createLabel(dialogArea,"Name:");
		nameText = UIControlsFactory.createText(dialogArea, SWT.BORDER|SWT.SINGLE);
		nameText.setTextLimit(50);
		GridData nameGD = new GridData(SWT.FILL,SWT.FILL,true,false,2,1);
		nameText.setLayoutData(nameGD);
		nameText.addModifyListener(this);
		createDecorator(nameText,"",false);
		
		Label defaultRoute = UIControlsFactory.createLabel(dialogArea,"Route:");
		route = UIControlsFactory.createCombo(dialogArea);
		route.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,2,1));
		route.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		createDecorator(route,"",false);
		

		Label photoLabel = UIControlsFactory.createLabel(dialogArea,"Photo:");
		photoText = UIControlsFactory.createText(dialogArea, SWT.READ_ONLY);
		photoText.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		photoText.addModifyListener(this);
		createDecorator(photoText,"",false);
		
		browseButton = UIControlsFactory.createButton(dialogArea, "Browse...");
		browseButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));

		//		Composite addressComposite = UIControlsFactory.createComposite(dialogArea);
		//		GridDataFactory.swtDefaults().grab(true, true).span(2, 2).applyTo(addressComposite);
		createAddresscontrol(dialogArea);

		return composite;
	}

	private void createAddresscontrol(Composite parent){

		// address composite
		//		Composite addressPanel = UIControlsFactory.createComposite(parent);
		//		GridLayout layout2 = new GridLayout(6, false);
		//		addressPanel.setLayout(layout2);
		//		GridDataFactory.swtDefaults().grab(true, true).span(2, 2).applyTo(addressPanel);


		// address
		Label label = UIControlsFactory.createLabel(parent,ADDRESS_LABEL); 
		GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		//		gd_label.minimumWidth = 100;
		label.setLayoutData(gd_label);
		txtAddress = UIControlsFactory.createText(parent,SWT.BORDER, ViewWidgetId.ADDRESS_TXT);
		txtAddress.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 5,1));
		txtAddress.addModifyListener(this);
		createDecorator(txtAddress,"",false);

		// section
		UIControlsFactory.createLabel(parent, SECTION_LABEL); 
		txtSection = UIControlsFactory.createText(parent,	SWT.BORDER, ViewWidgetId.SECTION_TXT);
		txtSection.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 5, 1));
		txtSection.addModifyListener(this);

		createDecorator(txtSection,"",false);


		// estate
		UIControlsFactory.createLabel(parent, ESTATE_LABEL); 
		estateAddress = UIControlsFactory.createText(parent,	SWT.BORDER, ViewWidgetId.ESTATE_TXT);
		estateAddress.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 2, 1));
		estateAddress.addModifyListener(this);


		// town
		UIControlsFactory.createLabel(parent, VILLAGE_LABEL); 
		txtVillage = UIControlsFactory.createText(parent, SWT.BORDER,ViewWidgetId.VILLAGE_TXT);
		txtVillage.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 2, 1));
		txtVillage.addModifyListener(this);

		createDecorator(txtVillage,"",false);

		// sublocation
		UIControlsFactory.createLabel(parent, SUBLOCATION_LABEL); 
		txtSubLocation = UIControlsFactory.createText(parent, SWT.BORDER,ViewWidgetId.SUBLOCATION_TXT);
		txtSubLocation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 2, 1));
		txtSubLocation.addModifyListener(this);



		// location
		UIControlsFactory.createLabel(parent, LOCATION_LABEL); 
		txtLocation = UIControlsFactory.createText(parent, SWT.BORDER,ViewWidgetId.LOCATION_TXT);
		txtLocation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 2, 1));
		txtLocation.addModifyListener(this);


		// division
		UIControlsFactory.createLabel(parent, DIVISION_LABEL); 
		txtDivision = UIControlsFactory.createText(parent, SWT.BORDER,ViewWidgetId.DIVISION_TXT);
		txtDivision.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 2, 1));
		txtDivision.addModifyListener(this);


		// District
		UIControlsFactory.createLabel(parent,DISTRICT_LABEL );
		txtDistrict = UIControlsFactory.createText(parent,	SWT.BORDER, ViewWidgetId.DISTRICT_TXT);
		txtDistrict.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 2, 1));
		txtDistrict.addModifyListener(this);


		// province
		UIControlsFactory.createLabel(parent,PROVINCE_LABEL); 
		final Combo comboProvince = UIControlsFactory.createCombo(parent, ViewWidgetId.PROVINCE_TXT);
		comboProvince.setItems(ViewWidgetId.PROVINCES_LIST);
		comboProvince.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false,2, 1));
		createDecorator(comboProvince, "",false);
		comboProvince.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				memberShip.getMember().getLocation().getPostalLocation().setProvince(comboProvince.getText());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});


		// PostalCode
		UIControlsFactory.createLabel(parent, POSTAL_CODE_LABEL); 
		txtPostal = UIControlsFactory.createText(parent, SWT.BORDER,ViewWidgetId.POSTAL_CODE_TXT);
		txtPostal.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 2, 1));
		txtPostal.addModifyListener(this);

		createDecorator(txtPostal, "",false);
	}

	/**
	 * Creates the buttons for the button bar
	 * 
	 * @param parent the parent composite
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		okButton.setEnabled(false);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, true);

	}


		private boolean validate(){
			boolean valid = true;
			//check name
			valid = memberShip.getMember().getName() != null && !memberShip.getMember().getName().trim().isEmpty();
			if(!valid){
				return false;
			}
			//check address
			String address = memberShip.getMember().getLocation().getPostalLocation().getAddress(); 
			valid =  address != null && !address.trim().isEmpty();
			if(!valid){
				return false;
			}
			//check section
			String section =memberShip.getMember().getLocation().getPostalLocation().getSection();
			valid =  section != null && !section.trim().isEmpty();
			if(!valid){
				return false;
			}
			//check village
			String village = memberShip.getMember().getLocation().getPostalLocation().getVillage();
			valid =  village != null && !village.trim().isEmpty();
			if(!valid){
				return false;
			}
			//check postal code
			String postal =memberShip.getMember().getLocation().getPostalLocation().getPostalCode();
			valid =  postal != null && !postal.trim().isEmpty();
			return valid;
		}

	private ControlDecoration createDecorator(Control text, String message, boolean isError) {
		ControlDecoration controlDecoration = new ControlDecoration(text,
				SWT.LEFT | SWT.TOP);
		controlDecoration.setDescriptionText(message);
		FieldDecoration fieldDecoration = isError?  FieldDecorationRegistry.getDefault()
				.getFieldDecoration(FieldDecorationRegistry.DEC_ERROR):FieldDecorationRegistry.getDefault()
				.getFieldDecoration(FieldDecorationRegistry.DEC_REQUIRED);
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
	public void modifyText(ModifyEvent e) {
		if(e.getSource() == idText){
			String value = idText.getText();
			if(value != null && !value.trim().equals("")){
				memberShip.setMemberId(value);
				if(idError.isVisible()){
					setErrorMessage(null);
					idError.hide();	
				}

			}
		}else if(e.getSource() == nameText){
			String value = nameText.getText();
			memberShip.getMember().setName(value);
		}else if(e.getSource() == txtAddress){
			String value = txtAddress.getText();
			memberShip.getMember().getLocation().getPostalLocation().setAddress(value);
		}else if(e.getSource() == txtSection){
			String value = txtSection.getText();
			memberShip.getMember().getLocation().getPostalLocation().setSection(value);
		}else if(e.getSource() == estateAddress){
			String value = estateAddress.getText();
			memberShip.getMember().getLocation().getPostalLocation().setEstate(value);
		}else if(e.getSource() == txtVillage){
			String value = txtVillage.getText();
			memberShip.getMember().getLocation().getPostalLocation().setVillage(value);
		}else if(e.getSource() == txtSubLocation){
			String value = txtSubLocation.getText();
			memberShip.getMember().getLocation().getPostalLocation().setSubLocation(value);
		}else if(e.getSource() == txtLocation){
			String value = txtLocation.getText();
			memberShip.getMember().getLocation().getPostalLocation().setLocation(value);
		}else if(e.getSource() == txtDivision){
			String value = txtDivision.getText();
			memberShip.getMember().getLocation().getPostalLocation().setDivision(value);
		}else if(e.getSource() == txtDistrict){
			String value = txtDistrict.getText();
			memberShip.getMember().getLocation().getPostalLocation().setDistrict(value);
		}else if(e.getSource() == txtPostal){
			String value = txtPostal.getText();
			memberShip.getMember().getLocation().getPostalLocation().setPostalCode(value);
		}
		if(validate()){
			setErrorMessage(null);
			getButton(IDialogConstants.OK_ID).setEnabled(true);
		}else{
			getButton(IDialogConstants.OK_ID).setEnabled(false);
		}
	}

}

