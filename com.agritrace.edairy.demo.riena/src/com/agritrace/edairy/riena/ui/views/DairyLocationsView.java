package com.agritrace.edairy.riena.ui.views;

import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.ChoiceComposite;
import org.eclipse.riena.ui.swt.MessageBox;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
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

import com.agritrace.edairy.riena.controllers.DairyLocationsSubModuleController;

public class DairyLocationsView extends SubModuleView {
	public final static String ID = DairyLocationsView.class.getName();
	private final static int WIDTH_UNIT = 100;
	private final static int COLUMN_MARGIN = 10;
	private final static int FORM_MARGIN = 10;
	private final static int ROW_MARGIN = 20;
	private Composite contentArea;

	@Override
	protected void basicCreatePartControl(Composite parent) {
		this.contentArea = parent;
		contentArea.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		
		FormLayout layout = new FormLayout();
		layout.marginWidth = layout.marginHeight = FORM_MARGIN;
		contentArea.setLayout(layout);

		Label locationIdLabel = UIControlsFactory.createLabel(contentArea, "Location #", SWT.LEFT);
		FormData fd = new FormData();
		fd.top = new FormAttachment(0, 0);
		fd.left = new FormAttachment(0, 0);
		locationIdLabel.setLayoutData(fd);

		Text locationIdText = UIControlsFactory.createText(contentArea, SWT.BORDER| SWT.SINGLE, DairyLocationsController.RIDGET_ID_DAIRY_LOCATION_ID);
		fd = new FormData();
		fd.top = new FormAttachment(locationIdLabel, 0, SWT.CENTER);
		fd.left = new FormAttachment(locationIdLabel, COLUMN_MARGIN, SWT.RIGHT);
		fd.width = WIDTH_UNIT;
		locationIdText.setEditable(false);
		locationIdText.setLayoutData(fd);

		Label nameLabel = UIControlsFactory.createLabel(contentArea, "Name", SWT.LEFT);
		fd = new FormData();
		fd.top = new FormAttachment(locationIdLabel, ROW_MARGIN, SWT.BOTTOM);
		fd.left = new FormAttachment(locationIdLabel, 0, SWT.LEFT);
		nameLabel.setLayoutData(fd);

		Text nameText = UIControlsFactory.createText(contentArea, SWT.BORDER | SWT.SINGLE, DairyLocationsController.RIDGET_ID_NAME);
		fd = new FormData();
		fd.top = new FormAttachment(nameLabel, 0, SWT.CENTER);
		fd.left = new FormAttachment(locationIdText, 0, SWT.LEFT);
		fd.width = WIDTH_UNIT * 3;
		nameText.setLayoutData(fd);

		Label functionsLabel = UIControlsFactory.createLabel(contentArea, "Functions", SWT.LEFT);
		fd = new FormData();
		fd.top = new FormAttachment(nameLabel, ROW_MARGIN, SWT.BOTTOM);
		fd.left = new FormAttachment(nameLabel, 0, SWT.LEFT);
		functionsLabel.setLayoutData(fd);
		
		//function check boxes group start
		ChoiceComposite choiceFunctions = UIControlsFactory.createChoiceComposite(contentArea, SWT.None, true, DairyLocationsController.RIDGET_ID_FUNCTIONS); //$NON-NLS-1$
		choiceFunctions.setOrientation(SWT.HORIZONTAL);
		fd = new FormData();
		fd.top = new FormAttachment(functionsLabel, 0, SWT.CENTER);
		fd.left = new FormAttachment(functionsLabel, COLUMN_MARGIN, SWT.RIGHT);
		choiceFunctions.setLayoutData(fd);
		
		Label routeLabel = UIControlsFactory.createLabel(contentArea, "Route", SWT.LEFT);
		fd = new FormData();
		fd.top = new FormAttachment(functionsLabel, ROW_MARGIN, SWT.BOTTOM);
		fd.left = new FormAttachment(functionsLabel, 0, SWT.LEFT);
		//fd.width = LABEL_WIDTH;
		routeLabel.setLayoutData(fd);
		
		Combo routeCombo = UIControlsFactory.createCombo(contentArea, DairyLocationsController.RIDGET_ID_ROUTE);
		fd = new FormData();
		fd.top = new FormAttachment(routeLabel, 0, SWT.CENTER);
		fd.left = new FormAttachment(nameText, 0, SWT.LEFT);
		//fd.width = FIELD_WIDTH;
		routeCombo.setLayoutData(fd);
		
		Button addRouteButton = UIControlsFactory.createButton(parent, "Add", DairyLocationsController.RIDGET_ID_ADD_ROUTE_ACTION);
		fd = new FormData();
		fd.top = new FormAttachment(routeLabel, 0, SWT.CENTER);
		fd.left = new FormAttachment(routeCombo, COLUMN_MARGIN, SWT.RIGHT);
		addRouteButton.setLayoutData(fd);
		
		TabFolder tabs = new TabFolder(contentArea, SWT.None);
		fd = new FormData();
		fd.top = new FormAttachment(routeLabel, 40, SWT.BOTTOM);
		fd.left = new FormAttachment(routeLabel, 0, SWT.LEFT); 
		fd.width = (int)(WIDTH_UNIT * 5.5);
		tabs.setLayoutData(fd);
		
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
		
		Button deleteButton = UIControlsFactory.createButton(contentArea, "Delete", DairyLocationsController.RIDGET_ID_DELETE_ACTION);
		fd = new FormData();
		fd.top = new FormAttachment(tabs, ROW_MARGIN, SWT.BOTTOM);
		fd.left = new FormAttachment(locationIdLabel, COLUMN_MARGIN, SWT.LEFT);
		fd.width = WIDTH_UNIT;
		deleteButton.setLayoutData(fd);
		
		Button cancelButton = UIControlsFactory.createButton(contentArea, "Cancel", DairyLocationsController.RIDGET_ID_CANCEL_ACTION);
		fd = new FormData();
		fd.top = new FormAttachment(deleteButton, 0, SWT.TOP);
		fd.left = new FormAttachment(tabs, 0, SWT.CENTER);
		fd.width = WIDTH_UNIT;
		cancelButton.setLayoutData(fd);
		
		Button saveButton = UIControlsFactory.createButton(contentArea, "Save", DairyLocationsController.RIDGET_ID_SAVE_ACTION);
		fd = new FormData();
		fd.top = new FormAttachment(deleteButton, 0, SWT.TOP);
		fd.right = new FormAttachment(tabs, -COLUMN_MARGIN, SWT.RIGHT);
		fd.width = WIDTH_UNIT;
		saveButton.setLayoutData(fd);
		
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
		
		
		Text addressText = UIControlsFactory.createText(parent, SWT.BORDER | SWT.SINGLE, DairyLocationsController.RIDGET_ID_PL_ADDRESS);
		gd = new GridData();
		gd.horizontalSpan = 3;
		gd.widthHint = WIDTH_UNIT *3;
		addressText.setLayoutData(gd);
		
		Label sectionLabel = UIControlsFactory.createLabel(parent, "Section/Homestead");
		gd = new GridData();
		sectionLabel.setLayoutData(gd);
		
		Text sectionText = UIControlsFactory.createText(parent, SWT.BORDER | SWT.SINGLE, DairyLocationsController.RIDGET_ID_PL_SECTION);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		sectionText.setLayoutData(gd);
		
		Label townLabel = UIControlsFactory.createLabel(parent, "Town/Village");
		gd = new GridData();
		townLabel.setLayoutData(gd);
		
		Text townText = UIControlsFactory.createText(parent, SWT.BORDER| SWT.SINGLE, DairyLocationsController.RIDGET_ID_PL_TOWN);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		townText.setLayoutData(gd);
		
		//#TODO: Should this UI component be removed or update the dairy.escore file?
		Label estateLabel = UIControlsFactory.createLabel(parent, "Estate/Nearest Centre");
		gd = new GridData();
		estateLabel.setLayoutData(gd);
		
		Text estateText = UIControlsFactory.createText(parent, SWT.BORDER| SWT.SINGLE, DairyLocationsController.RIDGET_ID_PL_ESTATE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		estateText.setLayoutData(gd);
		
		Label locationLabel = UIControlsFactory.createLabel(parent, "Location");
		gd = new GridData();
		locationLabel.setLayoutData(gd);
		
		Text locationText = UIControlsFactory.createText(parent, SWT.BORDER| SWT.SINGLE, DairyLocationsController.RIDGET_ID_PL_LOCATION);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		locationText.setLayoutData(gd);
		
		Label subLocationLabel = UIControlsFactory.createLabel(parent, "Sub");
		gd = new GridData();
		subLocationLabel.setLayoutData(gd);
		
		Text subLocationText = UIControlsFactory.createText(parent, SWT.BORDER| SWT.SINGLE, DairyLocationsController.RIDGET_ID_PL_SUB);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		subLocationText.setLayoutData(gd);
		
		Label districtLabel = UIControlsFactory.createLabel(parent, "District");
		gd = new GridData();
		districtLabel.setLayoutData(gd);
		
		Text districtText = UIControlsFactory.createText(parent, SWT.BORDER| SWT.SINGLE, DairyLocationsController.RIDGET_ID_PL_DISTRICT);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		districtText.setLayoutData(gd);
		
		Label divisionLabel = UIControlsFactory.createLabel(parent, "Division");
		gd = new GridData();
		divisionLabel.setLayoutData(gd);
		
		Text divisionText = UIControlsFactory.createText(parent, SWT.BORDER| SWT.SINGLE, DairyLocationsController.RIDGET_ID_PL_DIVISION);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		divisionText.setLayoutData(gd);
		
		Label postalCodeLabel = UIControlsFactory.createLabel(parent, "Postal Code");
		gd = new GridData();
		postalCodeLabel.setLayoutData(gd);
		
		Text postalCodeText = UIControlsFactory.createText(parent, SWT.BORDER| SWT.SINGLE, DairyLocationsController.RIDGET_ID_PL_POSTALCODE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		postalCodeText.setLayoutData(gd);
		
		Label provinceLabel = UIControlsFactory.createLabel(parent, "Province");
		gd = new GridData();
		provinceLabel.setLayoutData(gd);
		
		Text provinceText = UIControlsFactory.createText(parent, SWT.BORDER| SWT.SINGLE, DairyLocationsController.RIDGET_ID_PL_PROVINCE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		provinceText.setLayoutData(gd);
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
		
		Text landmarkText = UIControlsFactory.createText(parent, SWT.BORDER| SWT.SINGLE, DairyLocationsController.RIDGET_ID_DL_LANDMARK);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 4;
		landmarkText.setLayoutData(gd);
		
		Label directionsLabel = UIControlsFactory.createLabel(parent, "Directions");
		gd = new GridData();
		directionsLabel.setLayoutData(gd);
		
		Text directionsText = UIControlsFactory.createTextMulti(parent, false, false, DairyLocationsController.RIDGET_ID_DL_DIRECTIONS);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 4;
		gd.heightHint = ROW_MARGIN * 5;
		directionsText.setLayoutData(gd);
	}
	
	private void createMapTab(Composite parent)
	{
		parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = layout.marginHeight = FORM_MARGIN;
		layout.horizontalSpacing = COLUMN_MARGIN;
		parent.setLayout(layout);
		
		Label latitudeLabel = UIControlsFactory.createLabel(parent, "Latitude");
		GridData gd = new GridData();
		latitudeLabel.setLayoutData(gd);
		
		Text lattitudeText = UIControlsFactory.createTextDecimal(parent, DairyLocationsController.RIDGET_ID_ML_LATITUDE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT ;
		lattitudeText.setLayoutData(gd);
		
		Label longitudeLabel = UIControlsFactory.createLabel(parent, "Longitutde");
		gd = new GridData();
		longitudeLabel.setLayoutData(gd);
		
		Text longitudeText = UIControlsFactory.createTextDecimal(parent, DairyLocationsController.RIDGET_ID_ML_LONGITUDE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		longitudeText.setLayoutData(gd);
	}
	private void createMessageBoxes()
	{
		MessageBox nameErrorMessage = UIControlsFactory.createMessageBox(contentArea);
		this.addUIControl(nameErrorMessage, DairyLocationsController.RIDGET_ID_DUPLICATE_NAME_DIALOG);
		MessageBox addressErrorMessage  = UIControlsFactory.createMessageBox(contentArea);
		this.addUIControl(addressErrorMessage, DairyLocationsController.RIDGET_ID_ADDRESS_REQUIRED_DIALOG);
		MessageBox deleteConfirmMessage  = UIControlsFactory.createMessageBox(contentArea);
		this.addUIControl(deleteConfirmMessage, DairyLocationsController.RIDGET_ID_DELETE_CONFIRM_DIALOG);
	}

	public Image getIcon() {
		return AbstractUIPlugin.imageDescriptorFromPlugin("com.averline.edm_client", "/icons/user_16.png")
				.createImage();
	}

	@Override
	protected DairyLocationsController createController(ISubModuleNode subModuleNode) {
		return new DairyLocationsController(subModuleNode);
	}
}
