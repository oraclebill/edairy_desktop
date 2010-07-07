package com.agritrace.edairy.desktop.dairy.locations.ui.views;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.ChoiceComposite;
import org.eclipse.riena.ui.swt.DatePickerComposite;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.agritrace.edairy.desktop.dairy.locations.ui.controllers.DairyLocationController;

public class DairyLocationView extends SubModuleView {
	private static class DairyLocationMasterDetailsComposite extends MasterDetailsComposite {

		public DairyLocationMasterDetailsComposite(Composite parent, int style) {
			super(parent, style);
			setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		}

		@Override
		public boolean confirmRemove(Object item) {
			final String title = "Confirm Remove";
			final String message = "Do you want to delete this item?"; //$NON-NLS-1$
			final boolean result = MessageDialog.openQuestion(getShell(), title, message);
			return result;
		}

		@Override
		protected Table createTable(Composite tableComposite, TableColumnLayout layout) {
			if (tableComposite.getParent() != null) {
				tableComposite.getParent().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			}
			tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			tableComposite.setLayout(layout);

			return super.createTable(tableComposite, layout);
		}

	}

	public final static String ID = "dairy.locations.editor";
	private final static int COLUMN_MARGIN = 20;
	private final static int FORM_MARGIN = 10;
	private final static int ROW_MARGIN = 10;
	private final static int WIDTH_UNIT = 60;
	private Composite contentArea;

	public DairyLocationView() {
	}

	public Image getIcon() {
		return AbstractUIPlugin.imageDescriptorFromPlugin("com.agritrace.edairy.desktop",
				"/icons/edairymanagericon16.png").createImage();
	}

	private void createAddressTab(Composite parent) {
		parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		final GridLayout layout = new GridLayout(4, false);
		layout.marginWidth = layout.marginHeight = FORM_MARGIN;
		layout.horizontalSpacing = COLUMN_MARGIN;
		parent.setLayout(layout);

		final Label addressLabel = UIControlsFactory.createLabel(parent, "Address");
		GridData gd = new GridData();
		addressLabel.setLayoutData(gd);

		final Text addressText = UIControlsFactory.createText(parent, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_PL_ADDRESS);
		gd = new GridData();
		gd.horizontalSpan = 3;
		gd.widthHint = WIDTH_UNIT * 3;
		addressText.setLayoutData(gd);

		final Label sectionLabel = UIControlsFactory.createLabel(parent, "Section/Homestead");
		gd = new GridData();
		sectionLabel.setLayoutData(gd);

		final Text sectionText = UIControlsFactory.createText(parent, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_PL_SECTION);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 2;
		sectionText.setLayoutData(gd);

		final Label townLabel = UIControlsFactory.createLabel(parent, "Town/Village");
		gd = new GridData();
		townLabel.setLayoutData(gd);

		final Text townText = UIControlsFactory.createText(parent, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_PL_TOWN);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 2;
		townText.setLayoutData(gd);

		// #TODO: Should this UI component be removed or update the dairy.escore
		// file?
		final Label estateLabel = UIControlsFactory.createLabel(parent, "Estate/Nearest Centre");
		gd = new GridData();
		estateLabel.setLayoutData(gd);

		final Text estateText = UIControlsFactory.createText(parent, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_PL_ESTATE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 2;
		estateText.setLayoutData(gd);

		final Label locationLabel = UIControlsFactory.createLabel(parent, "Location");
		gd = new GridData();
		locationLabel.setLayoutData(gd);

		final Text locationText = UIControlsFactory.createText(parent, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_PL_LOCATION);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 2;
		locationText.setLayoutData(gd);

		final Label subLocationLabel = UIControlsFactory.createLabel(parent, "Sub");
		gd = new GridData();
		subLocationLabel.setLayoutData(gd);

		final Text subLocationText = UIControlsFactory.createText(parent, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_PL_SUB);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 2;
		subLocationText.setLayoutData(gd);

		final Label districtLabel = UIControlsFactory.createLabel(parent, "District");
		gd = new GridData();
		districtLabel.setLayoutData(gd);

		final Text districtText = UIControlsFactory.createText(parent, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_PL_DISTRICT);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 2;
		districtText.setLayoutData(gd);

		final Label divisionLabel = UIControlsFactory.createLabel(parent, "Division");
		gd = new GridData();
		divisionLabel.setLayoutData(gd);

		final Text divisionText = UIControlsFactory.createText(parent, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_PL_DIVISION);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 2;
		divisionText.setLayoutData(gd);

		final Label postalCodeLabel = UIControlsFactory.createLabel(parent, "Postal Code");
		gd = new GridData();
		postalCodeLabel.setLayoutData(gd);

		final Text postalCodeText = UIControlsFactory.createText(parent, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_PL_POSTALCODE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 2;
		postalCodeText.setLayoutData(gd);

		final Label provinceLabel = UIControlsFactory.createLabel(parent, "Province");
		gd = new GridData();
		provinceLabel.setLayoutData(gd);

		final Text provinceText = UIControlsFactory.createText(parent, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_PL_PROVINCE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 2;
		provinceText.setLayoutData(gd);
	}

	private void createDetailsPanel(Composite details) {
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		gd.verticalAlignment = SWT.FILL;
		// gd.heightHint = ROW_MARGIN * 2;
		details.setLayoutData(gd);

		final GridLayout detaLayout = new GridLayout();
		detaLayout.numColumns = 1;
		details.setLayout(detaLayout);

		final Group detailGroup = UIControlsFactory.createGroup(details, "Details");
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		detailGroup.setLayoutData(gd);
		final GridLayout layout2 = new GridLayout(3, false);
		detailGroup.setLayout(layout2);

		UIControlsFactory.createLabel(detailGroup, "Location #", SWT.LEFT);

		final Text idText = UIControlsFactory.createText(detailGroup, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_COLLECTION_CENTRE_ID);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		gd.horizontalSpan = 2;
		idText.setEditable(false);
		idText.setLayoutData(gd);

		UIControlsFactory.createLabel(detailGroup, "Name", SWT.LEFT);

		final Text nameText = UIControlsFactory.createText(detailGroup, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_NAME);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 3;
		gd.horizontalSpan = 2;
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		nameText.setLayoutData(gd);

		UIControlsFactory.createLabel(detailGroup, "Description", SWT.LEFT);

		final Text descriptionText = UIControlsFactory.createText(detailGroup, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_DESCRIPTION);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 3;
		gd.horizontalSpan = 2;
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		descriptionText.setLayoutData(gd);

		UIControlsFactory.createLabel(detailGroup, "Phone", SWT.LEFT);

		final Text phoneText = UIControlsFactory.createText(detailGroup, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_PHONE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 3;
		gd.horizontalSpan = 2;
		phoneText.setLayoutData(gd);

		UIControlsFactory.createLabel(detailGroup, "Date Opened", SWT.LEFT);

		final DatePickerComposite dateOpenedPicker = UIControlsFactory.createDatePickerComposite(detailGroup,
				DairyLocationController.RIDGET_ID_DATEOPENED);
		gd = new GridData();
		gd.horizontalSpan = 2;
		dateOpenedPicker.setLayoutData(gd);

		UIControlsFactory.createLabel(detailGroup, "Functions", SWT.LEFT);

		final ChoiceComposite functionsChoice = UIControlsFactory.createChoiceComposite(detailGroup, SWT.None, true,
				DairyLocationController.RIDGET_ID_FUNCTIONS);
		functionsChoice.setOrientation(SWT.HORIZONTAL);
		gd = new GridData();
		gd.horizontalSpan = 2;
		functionsChoice.setLayoutData(gd);

		UIControlsFactory.createLabel(detailGroup, "Route", SWT.LEFT);

		final CCombo combo = UIControlsFactory.createCCombo(detailGroup, DairyLocationController.RIDGET_ID_ROUTE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 3;
		gd.verticalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.horizontalSpan = 2;
		combo.setLayoutData(gd);

		// UIControlsFactory.createButton(detailGroup, "?",
		// DairyLocationController.RIDGET_ID_CONFIGURE_ROUTE_ACTION);

		final TabFolder tabs = new TabFolder(detailGroup, SWT.None);
		gd = new GridData();
		gd.horizontalSpan = 3;
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = SWT.FILL;
		tabs.setLayoutData(gd);

		final TabItem addressTab = new TabItem(tabs, SWT.NONE);
		addressTab.setText("Address");
		final Composite tab = new Composite(tabs, SWT.NONE);
		addressTab.setControl(tab);
		createAddressTab(tab);

		final TabItem directionsTab = new TabItem(tabs, SWT.NONE);
		directionsTab.setText("Directions");
		final Composite tab2 = new Composite(tabs, SWT.NONE);
		directionsTab.setControl(tab2);
		createDirectionsTab(tab2);

		final TabItem mapTab = new TabItem(tabs, SWT.NONE);
		mapTab.setText("Map");
		final Composite tab3 = new Composite(tabs, SWT.NONE);
		mapTab.setControl(tab3);
		createMapTab(tab3);
	}

	private void createDirectionsTab(Composite parent) {
		parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		final GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = layout.marginHeight = FORM_MARGIN;
		layout.horizontalSpacing = COLUMN_MARGIN;
		parent.setLayout(layout);

		final Label landmarkLabel = UIControlsFactory.createLabel(parent, "Landmark");
		GridData gd = new GridData();
		landmarkLabel.setLayoutData(gd);

		final Text landmarkText = UIControlsFactory.createText(parent, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_DL_LANDMARK);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 4;
		landmarkText.setLayoutData(gd);

		final Label directionsLabel = UIControlsFactory.createLabel(parent, "Directions");
		gd = new GridData();
		directionsLabel.setLayoutData(gd);

		final Text directionsText = UIControlsFactory.createTextMulti(parent, false, false,
				DairyLocationController.RIDGET_ID_DL_DIRECTIONS);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT * 4;
		gd.heightHint = ROW_MARGIN * 5;
		directionsText.setLayoutData(gd);
	}

	private void createMapTab(Composite parent) {
		parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		final GridLayout layout = new GridLayout(3, false);
		layout.marginWidth = layout.marginHeight = FORM_MARGIN;
		layout.horizontalSpacing = COLUMN_MARGIN;
		parent.setLayout(layout);

		final Label latitudeLabel = UIControlsFactory.createLabel(parent, "Latitude");
		GridData gd = new GridData();
		latitudeLabel.setLayoutData(gd);

		final Text lattitudeText = UIControlsFactory.createTextDecimal(parent,
				DairyLocationController.RIDGET_ID_ML_LATITUDE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		lattitudeText.setLayoutData(gd);

		final Browser map = UIControlsFactory.createBrowser(parent, SWT.BORDER);
		gd = new GridData();
		gd.verticalSpan = 3;
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = SWT.FILL;
		map.setLayoutData(gd);

		final Label longitudeLabel = UIControlsFactory.createLabel(parent, "Longitutde");
		gd = new GridData();
		longitudeLabel.setLayoutData(gd);

		final Text longitudeText = UIControlsFactory.createTextDecimal(parent,
				DairyLocationController.RIDGET_ID_ML_LONGITUDE);
		gd = new GridData();
		gd.widthHint = WIDTH_UNIT;
		longitudeText.setLayoutData(gd);

	}

	@Override
	protected void basicCreatePartControl(Composite parent) {
		this.contentArea = parent;
		contentArea.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		final GridLayout layout = new GridLayout(1, false);
		contentArea.setLayout(layout);
		final DairyLocationMasterDetailsComposite master = new DairyLocationMasterDetailsComposite(contentArea,
				SWT.NONE);
		this.addUIControl(master, "master");
		final GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = SWT.FILL;
		master.setLayoutData(gd);
		final Composite details = master.getDetails();
		createDetailsPanel(details);
	}

}
