package com.agritrace.edairy.riena.ui.views;

import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.ChoiceComposite;
import org.eclipse.riena.ui.swt.DatePickerComposite;
import org.eclipse.riena.ui.swt.MessageBox;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.agritrace.edairy.riena.ui.controllers.DairyLocationController;

public class DairyLocationView extends SubModuleView {
	public final static String ID = DairyLocationView.class.getName();
	private final static int WIDTH_UNIT = 100;
	private final static int COLUMN_MARGIN = 10;
	private final static int FORM_MARGIN = 10;
	private final static int ROW_MARGIN = 10;
	private Composite contentArea;

	@Override
	protected void basicCreatePartControl(Composite parent) {
		this.contentArea = parent;
		contentArea.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		
		/*FormLayout layout = new FormLayout();
		layout.marginWidth = layout.marginHeight = FORM_MARGIN;*/
		GridLayout layout = new GridLayout(3, false);
		contentArea.setLayout(layout);

		Label idLabel = UIControlsFactory.createLabel(contentArea, "Location #", SWT.LEFT);

		Text idText = UIControlsFactory.createText(contentArea, SWT.BORDER| SWT.SINGLE, DairyLocationController.RIDGET_ID_COLLECTION_CENTRE_ID);
		GridData gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		gd.horizontalSpan = 2;

/*		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = SWT.FILL;*/
		idText.setEditable(false);
		idText.setLayoutData(gd);

		Label nameLabel = UIControlsFactory.createLabel(contentArea, "Name", SWT.LEFT);

		Text nameText = UIControlsFactory.createText(contentArea, SWT.BORDER | SWT.SINGLE, DairyLocationController.RIDGET_ID_NAME);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 3;
		gd.horizontalSpan = 2;
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		nameText.setLayoutData(gd);
		
		Label descriptionLabel = UIControlsFactory.createLabel(contentArea, "Description", SWT.LEFT);
		
		Text descriptionText = UIControlsFactory.createText(contentArea, SWT.BORDER | SWT.SINGLE, DairyLocationController.RIDGET_ID_DESCRIPTION);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 3;
		gd.horizontalSpan = 2;
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		descriptionText.setLayoutData(gd);
		
		Label dateOpenedLabel = UIControlsFactory.createLabel(contentArea, "Date Opened", SWT.LEFT);
		
		DatePickerComposite dateOpenedPicker = UIControlsFactory.createDatePickerComposite(contentArea, DairyLocationController.RIDGET_ID_DATEOPENED);
		gd = new GridData();
		gd.horizontalSpan = 2;
		dateOpenedPicker.setLayoutData(gd);

		Label functionsLabel = UIControlsFactory.createLabel(contentArea, "Function", SWT.LEFT);
		
		ChoiceComposite functionChoice = UIControlsFactory.createChoiceComposite(contentArea, SWT.None, false, DairyLocationController.RIDGET_ID_FUNCTION); //$NON-NLS-1$
		functionChoice.setOrientation(SWT.HORIZONTAL);
		gd = new GridData();
		gd.horizontalSpan = 2;
		functionChoice.setLayoutData(gd);
		
		Label routeLabel = UIControlsFactory.createLabel(contentArea, "Route", SWT.LEFT);

		Combo routeCombo = UIControlsFactory.createCombo(contentArea, DairyLocationController.RIDGET_ID_ROUTE);
		
		Button addRouteButton = UIControlsFactory.createButton(contentArea, "Add", DairyLocationController.RIDGET_ID_ADD_ROUTE_ACTION);
		
		
		TabFolder tabs = new TabFolder(contentArea, SWT.None);
		gd = new GridData();
		gd.horizontalSpan = 3;
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = SWT.FILL;
		tabs.setLayoutData(gd);
		
		TabItem addressTab = new TabItem(tabs, SWT.NONE);
		addressTab.setText("Address");
		Composite tab = new Composite(tabs, SWT.NONE);
		addressTab.setControl(tab);
		createAddressTab(tab);
		
		
		TabItem directionsTab = new TabItem(tabs, SWT.NONE);
		directionsTab.setText("Directions");
		Composite tab2 = new Composite(tabs, SWT.NONE);
		directionsTab.setControl(tab2);
		createDirectionsTab(tab2);
		
		TabItem mapTab = new TabItem(tabs, SWT.NONE);
		mapTab.setText("Map");
		Composite tab3 = new Composite(tabs, SWT.NONE);
		mapTab.setControl(tab3);
		createMapTab(tab3);
		
		Composite buttonPanel = UIControlsFactory.createComposite(contentArea);
		gd = new GridData(SWT.END, SWT.FILL, true, false);
		gd.horizontalSpan = 3;
		gd.horizontalAlignment = GridData.END; 
		buttonPanel.setLayoutData(gd);
		buttonPanel.setLayout(new GridLayout(3,false));
	
		Button saveButton = UIControlsFactory.createButton(buttonPanel, "Save", DairyLocationController.RIDGET_ID_SAVE_ACTION);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		saveButton.setLayoutData(gd);
		
		Button deleteButton = UIControlsFactory.createButton(buttonPanel, "Delete", DairyLocationController.RIDGET_ID_DELETE_ACTION);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		deleteButton.setLayoutData(gd);
		
		Button cancelButton = UIControlsFactory.createButton(buttonPanel, "Cancel", DairyLocationController.RIDGET_ID_CANCEL_ACTION);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		cancelButton.setLayoutData(gd);
		
		
		
		createMessageBoxes();
	}
	
	private void createAddressTab(Composite parent)
	{
		parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		GridLayout layout = new GridLayout(4, false);
		layout.marginWidth = layout.marginHeight = FORM_MARGIN;
		layout.horizontalSpacing = COLUMN_MARGIN;
		parent.setLayout(layout);
		
		Label addressLabel = UIControlsFactory.createLabel(parent, "Address");
		GridData gd = new GridData();
		addressLabel.setLayoutData(gd);
		
		
		Text addressText = UIControlsFactory.createText(parent, SWT.BORDER | SWT.SINGLE, DairyLocationController.RIDGET_ID_PL_ADDRESS);
		gd = new GridData();
		gd.horizontalSpan = 3;
		gd.widthHint = WIDTH_UNIT *3;
		addressText.setLayoutData(gd);
		
		Label sectionLabel = UIControlsFactory.createLabel(parent, "Section/Homestead");
		gd = new GridData();
		sectionLabel.setLayoutData(gd);
		
		Text sectionText = UIControlsFactory.createText(parent, SWT.BORDER | SWT.SINGLE, DairyLocationController.RIDGET_ID_PL_SECTION);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		sectionText.setLayoutData(gd);
		
		Label townLabel = UIControlsFactory.createLabel(parent, "Town/Village");
		gd = new GridData();
		townLabel.setLayoutData(gd);
		
		Text townText = UIControlsFactory.createText(parent, SWT.BORDER| SWT.SINGLE, DairyLocationController.RIDGET_ID_PL_TOWN);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		townText.setLayoutData(gd);
		
		//#TODO: Should this UI component be removed or update the dairy.escore file?
		Label estateLabel = UIControlsFactory.createLabel(parent, "Estate/Nearest Centre");
		gd = new GridData();
		estateLabel.setLayoutData(gd);
		
		Text estateText = UIControlsFactory.createText(parent, SWT.BORDER| SWT.SINGLE, DairyLocationController.RIDGET_ID_PL_ESTATE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		estateText.setLayoutData(gd);
		
		Label locationLabel = UIControlsFactory.createLabel(parent, "Location");
		gd = new GridData();
		locationLabel.setLayoutData(gd);
		
		Text locationText = UIControlsFactory.createText(parent, SWT.BORDER| SWT.SINGLE, DairyLocationController.RIDGET_ID_PL_LOCATION);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		locationText.setLayoutData(gd);
		
		Label subLocationLabel = UIControlsFactory.createLabel(parent, "Sub");
		gd = new GridData();
		subLocationLabel.setLayoutData(gd);
		
		Text subLocationText = UIControlsFactory.createText(parent, SWT.BORDER| SWT.SINGLE, DairyLocationController.RIDGET_ID_PL_SUB);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		subLocationText.setLayoutData(gd);
		
		Label districtLabel = UIControlsFactory.createLabel(parent, "District");
		gd = new GridData();
		districtLabel.setLayoutData(gd);
		
		Text districtText = UIControlsFactory.createText(parent, SWT.BORDER| SWT.SINGLE, DairyLocationController.RIDGET_ID_PL_DISTRICT);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		districtText.setLayoutData(gd);
		
		Label divisionLabel = UIControlsFactory.createLabel(parent, "Division");
		gd = new GridData();
		divisionLabel.setLayoutData(gd);
		
		Text divisionText = UIControlsFactory.createText(parent, SWT.BORDER| SWT.SINGLE, DairyLocationController.RIDGET_ID_PL_DIVISION);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		divisionText.setLayoutData(gd);
		
		Label postalCodeLabel = UIControlsFactory.createLabel(parent, "Postal Code");
		gd = new GridData();
		postalCodeLabel.setLayoutData(gd);
		
		Text postalCodeText = UIControlsFactory.createText(parent, SWT.BORDER| SWT.SINGLE, DairyLocationController.RIDGET_ID_PL_POSTALCODE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		postalCodeText.setLayoutData(gd);
		
		/*Label provinceLabel = UIControlsFactory.createLabel(parent, "Province");
		gd = new GridData();
		provinceLabel.setLayoutData(gd);
		
		Text provinceText = UIControlsFactory.createText(parent, SWT.BORDER| SWT.SINGLE, DairyLocationController.RIDGET_ID_PL_PROVINCE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		provinceText.setLayoutData(gd);*/
	}
	
	private void createDirectionsTab(Composite parent) 
	{
		parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = layout.marginHeight = FORM_MARGIN;
		layout.horizontalSpacing = COLUMN_MARGIN;
		parent.setLayout(layout);
		
		Label landmarkLabel = UIControlsFactory.createLabel(parent, "Landmark");
		GridData gd = new GridData();
		landmarkLabel.setLayoutData(gd);
		
		Text landmarkText = UIControlsFactory.createText(parent, SWT.BORDER| SWT.SINGLE, DairyLocationController.RIDGET_ID_DL_LANDMARK);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 4;
		landmarkText.setLayoutData(gd);
		
		Label directionsLabel = UIControlsFactory.createLabel(parent, "Directions");
		gd = new GridData();
		directionsLabel.setLayoutData(gd);
		
		Text directionsText = UIControlsFactory.createTextMulti(parent, false, false, DairyLocationController.RIDGET_ID_DL_DIRECTIONS);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 4;
		gd.heightHint = ROW_MARGIN * 5;
		directionsText.setLayoutData(gd);
	}
	
	private void createMapTab(Composite parent)
	{
		parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		GridLayout layout = new GridLayout(3, false);
		layout.marginWidth = layout.marginHeight = FORM_MARGIN;
		layout.horizontalSpacing = COLUMN_MARGIN;
		parent.setLayout(layout);
		
		Label latitudeLabel = UIControlsFactory.createLabel(parent, "Latitude");
		GridData gd = new GridData();
		latitudeLabel.setLayoutData(gd);
		
		Text lattitudeText = UIControlsFactory.createTextDecimal(parent, DairyLocationController.RIDGET_ID_ML_LATITUDE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT ;
		lattitudeText.setLayoutData(gd);
		
		Browser map = UIControlsFactory.createBrowser(parent, SWT.BORDER);
		gd = new GridData();
		gd.verticalSpan = 3;
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = SWT.FILL;
		map.setLayoutData(gd);
		
		Label longitudeLabel = UIControlsFactory.createLabel(parent, "Longitutde");
		gd = new GridData();
		longitudeLabel.setLayoutData(gd);
		
		Text longitudeText = UIControlsFactory.createTextDecimal(parent, DairyLocationController.RIDGET_ID_ML_LONGITUDE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		longitudeText.setLayoutData(gd);
		
		
		
	}
	private void createMessageBoxes()
	{
		MessageBox nameErrorMessage = UIControlsFactory.createMessageBox(contentArea);
		this.addUIControl(nameErrorMessage, DairyLocationController.RIDGET_ID_DUPLICATE_NAME_DIALOG);
		MessageBox addressErrorMessage  = UIControlsFactory.createMessageBox(contentArea);
		this.addUIControl(addressErrorMessage, DairyLocationController.RIDGET_ID_ADDRESS_REQUIRED_DIALOG);
		MessageBox deleteConfirmMessage  = UIControlsFactory.createMessageBox(contentArea);
		this.addUIControl(deleteConfirmMessage, DairyLocationController.RIDGET_ID_DELETE_CONFIRM_DIALOG);
	}

	public Image getIcon() {
		return AbstractUIPlugin.imageDescriptorFromPlugin("com.averline.edm_client", "/icons/user_16.png")
				.createImage();
	}

	@Override
	protected DairyLocationController createController(ISubModuleNode subModuleNode) {
		return new DairyLocationController(subModuleNode);
	}
}
