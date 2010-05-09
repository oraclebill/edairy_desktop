package com.agritrace.edairy.member.ui.views;

import java.util.Date;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.model.SimpleNavigationNodeAdapter;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.DetachedViewsManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.ui.EDairyActivator;
import com.agritrace.edairy.ui.ImageRegistry;
import com.agritrace.edairy.ui.views.CalendarSelectionDialog;
import com.agritrace.edairy.ui.views.MemberBadge;
import com.agritrace.edairy.ui.views.ViewWidgetId;
import com.agritrace.edairy.ui.views.data.SimpleFormattedDateBean;

public class MemberSearchView extends SubModuleView implements SelectionListener{

	public static final String ID = MemberSearchView.class.getName();

	public static final String MEMBER_INFO_GROUP="Members Information";
	//address tab
	public static final String ADDRESS_TAB="Address";
	public static final String ADDRESS_LABEL="Address:";
	public static final String LOCATION_LABEL="Location:";
	public static final String VILLAGE_LABEL="Village:";
	public static final String DISTRICT_LABEL="District:";
	public static final String PROVINCE_LABEL="Province:";
	public static final String POSTAL_CODE_LABEL="Postal Code:";

	//save button
	public static final String SAVE_BUTTON="Save";
	public static final String CANCEL_BUTTON="Cancel";

	//container button
	public static final String ADD_BUTTON="Add";
	public static final String REMOVE_BUTTON="Remove";

	private Composite main;
	private Text txtName;
	private Text txtId;
	private List lstMembers;
	private Membership selectedMember;

	private MemberInfoGroup infoGroup ;

	private Button saveButton;
	private Button cancelButton;


	public MemberSearchView() {
	}

	@Override
	protected void basicCreatePartControl(Composite parent) {

		parent.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));

		parent.setLayout(new GridLayout(1, false));

		main = UIControlsFactory.createComposite(parent); 
		main.setLayout(new GridLayout(1, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,true).applyTo(main);

		/*Button searchButton = UIControlsFactory.createButton(main,"Search", ViewWidgetId.memberInfo_searchButton);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false,false).applyTo(searchButton);
		 */
		createMemberSelectorGroup(main);
		createMasterDetails(main);

		MemberSearchNodeListener newListener = new MemberSearchNodeListener();
		getNavigationNode().addSimpleListener(newListener);
		MemberSearchSelectionManager.INSTANCE.setSearchNode(newListener);

	}

	private void createMemberSelectorGroup(Composite composite) {
		infoGroup = new MemberInfoGroup(composite);
		infoGroup.getComposite().setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
	}


	private void createMemberSnapshotGroup(Composite composite) {
		MemberBadge memberBadge = new MemberBadge(composite, "Kofi Annan", "#124-100327", "#2 - Ngeche");
		memberBadge.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false));

	}

	private void createMemberDetailGroup(Composite composite) {
		Composite memberDetail = UIControlsFactory.createComposite(composite);
		memberDetail.setEnabled(false);
		GridData gd_memberDetail = new GridData(SWT.LEFT, SWT.CENTER, true, true, 2, 1);
		gd_memberDetail.heightHint = 126;
		gd_memberDetail.widthHint = 352;
		memberDetail.setLayoutData(gd_memberDetail);

	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue lstMembersObserveSelectionObserveWidget = SWTObservables.observeSelection(lstMembers);
		IObservableValue txtNameTextObserveValue = PojoObservables.observeValue(txtName, "text");
		bindingContext.bindValue(lstMembersObserveSelectionObserveWidget, txtNameTextObserveValue, null, null);
		//
		return bindingContext;
	}

	private Composite createMasterDetails(Composite parent) {

		Composite details = UIControlsFactory.createComposite(parent);
		GridData detailsGD = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		detailsGD.minimumHeight=200;
		details.setLayoutData(detailsGD);
		GridLayout detaLayout = new GridLayout();
		detaLayout.numColumns = 1;
		details.setLayout(detaLayout);

		Group detailGroup = UIControlsFactory.createGroup(details, MEMBER_INFO_GROUP);
		detailGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout groupLayout = new GridLayout();
		groupLayout.numColumns = 1;
		detailGroup.setLayout(groupLayout);
		detailGroup.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		CTabFolder tabfolder = new CTabFolder(detailGroup, SWT.NULL);
		tabfolder.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		//		tabfolder.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		//		tabfolder.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		Color startColor = LnfManager.getLnf().getColor(LnfKeyConstants.EMBEDDED_TITLEBAR_ACTIVE_BACKGROUND_START_COLOR);
		Color endColor = LnfManager.getLnf().getColor(LnfKeyConstants.EMBEDDED_TITLEBAR_ACTIVE_BACKGROUND_END_COLOR);
		tabfolder.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		tabfolder.setSelectionBackground(new Color[]{startColor,endColor},new int[]{50},true);
		//		tabfolder.setSimple(false);

		// account summary
		CTabItem accountTab = new CTabItem(tabfolder, SWT.NULL);
		accountTab.setText("Account Summary");
		Composite accountComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		accountComposite.setLayout(new GridLayout(1,true));
		accountComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		createAccountSummaryTab(accountComposite);
		accountTab.setControl(accountComposite);

		CTabItem transactionTab = new CTabItem(tabfolder, SWT.NULL);
		transactionTab.setText("Transactions");
		Composite transComposite =UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		transComposite.setLayout(new GridLayout(2,false));
		createTrasactionsTab(transComposite);
		transactionTab.setControl(transComposite);

		CTabItem collectionTab = new CTabItem(tabfolder, SWT.NULL);
		collectionTab.setText("Collection Records");
		Composite collectionComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		collectionComposite.setLayout(new GridLayout(2,false));
		createCollectionInfoTab(collectionComposite);
		collectionTab.setControl(collectionComposite);

		CTabItem farmTab = new CTabItem(tabfolder, SWT.NULL);
		farmTab.setText("Farm");
		Composite farmComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		farmComposite.setLayout(new GridLayout(1,true));
		createFarmInfoTab(farmComposite);
		farmTab.setControl(farmComposite);

		CTabItem livestockTab = new CTabItem(tabfolder, SWT.NULL);
		livestockTab.setText("Livestock");
		Composite livestockComposite =UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		livestockComposite.setLayout(new GridLayout(3,false));
		createLivestockInfoTab(livestockComposite);
		livestockTab.setControl(livestockComposite);

		CTabItem containerTab = new CTabItem(tabfolder, SWT.NULL);
		containerTab.setText("Containers");
		Composite containerComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		containerComposite.setLayout(new GridLayout(3,false));
		createContainerInfoTab(containerComposite);
		containerTab.setControl(containerComposite);

		tabfolder.setSelection(accountTab);

		Composite buttonPanel = UIControlsFactory.createComposite(details);
		buttonPanel
		.setLayoutData(new GridData(SWT.END, SWT.FILL, true, false));
		buttonPanel.setLayout(new GridLayout(3,false));

		Button searchButton = UIControlsFactory.createButton(buttonPanel,"Search", ViewWidgetId.memberInfo_searchButton);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false,false).applyTo(searchButton);

		saveButton = UIControlsFactory.createButton(buttonPanel,SAVE_BUTTON);
		saveButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));
		addUIControl(saveButton,ViewWidgetId.memberInfo_saveButton);

		cancelButton = UIControlsFactory.createButton(buttonPanel,"Cancel");
		cancelButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));
		addUIControl(cancelButton,ViewWidgetId.memberInfo_cacelButton);




		return details;
	}

	private void createCollectionInfoTab(Composite collectionComposite) {
		//fitler panel
		Composite filterPanel = UIControlsFactory.createComposite(collectionComposite,SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(false, true).applyTo(filterPanel);
		filterPanel.setLayout(new GridLayout(1,false));

		createDataRangeSearch(filterPanel,"Collection Date Range",ViewWidgetId.COLLECTION_FILTER_STARTDATE,ViewWidgetId.COLLECTION_FILTER_ENDDATE);

		Button nprMissing = UIControlsFactory.createButtonCheck(filterPanel,"NPR Missing", ViewWidgetId.COLLECTION_FILTER_NPRMISSING);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true, false).applyTo(nprMissing);

		Button rejected = UIControlsFactory.createButtonCheck(filterPanel,"Rejected", ViewWidgetId.COLLECTION_FILTER_REJECTED);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true, false).applyTo(rejected);
		
		Button flaged = UIControlsFactory.createButtonCheck(filterPanel,"Suspended", ViewWidgetId.COLLECTION_FILTER_FLAG);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true, false).applyTo(flaged);
		
		Button filterButton = UIControlsFactory.createButton(filterPanel, "Apply");
		addUIControl(filterButton,ViewWidgetId.COLLECTION_FILTER_APPLY);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.BOTTOM).grab(true, true).applyTo(filterButton);
		
		Button showAllButton = UIControlsFactory.createButton(filterPanel, "Show All");
		addUIControl(showAllButton,ViewWidgetId.COLLECTION_FILTER_SHOWALL);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.BOTTOM).grab(true, false).applyTo(showAllButton);
		
		Composite tablePanel = UIControlsFactory.createComposite(collectionComposite, SWT.NULL);
		tablePanel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));

		Table table =  UIControlsFactory.createTable(tablePanel, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION, ViewWidgetId.COLLECTION_TABLE);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableColumn columnId = new TableColumn(table, SWT.LEFT);
		TableColumn columnDate = new TableColumn(table, SWT.LEFT);
		TableColumn columnCan = new TableColumn(table, SWT.LEFT);
		TableColumn columnQuantity = new TableColumn(table, SWT.LEFT);
		TableColumn columnNPRMissing = new TableColumn(table, SWT.LEFT);
		TableColumn columnRejected = new TableColumn(table, SWT.LEFT);
		TableColumn columnSuspected = new TableColumn(table, SWT.LEFT);

		TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(columnId, new ColumnWeightData(10));
		layout.setColumnData(columnDate, new ColumnWeightData(15));
		layout.setColumnData(columnCan, new ColumnWeightData(15));
		layout.setColumnData(columnQuantity, new ColumnWeightData(15));
		layout.setColumnData(columnNPRMissing, new ColumnWeightData(15));
		layout.setColumnData(columnRejected, new ColumnWeightData(15));
		layout.setColumnData(columnSuspected, new ColumnWeightData(15));

		tablePanel.setLayout(layout);

	}

	private void createContainerInfoTab(Composite containerComposite) {
		Composite filterPanel = UIControlsFactory.createComposite(containerComposite, SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(false, false).applyTo(filterPanel);
		filterPanel.setLayout(new GridLayout(1,false));
		Label emptyLabel = UIControlsFactory.createLabel(filterPanel, "Filter By farm:");
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(false, false).applyTo(emptyLabel);

		Combo farmCombo =  UIControlsFactory.createCombo(filterPanel, ViewWidgetId.CONTAINER_FarmCombo);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true, true).applyTo(farmCombo);
		Button filterButton = UIControlsFactory.createButton(filterPanel, "Apply");
		addUIControl(filterButton,ViewWidgetId.CONTAINER_FilterButton);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.BOTTOM).grab(false, false).applyTo(filterButton);
		
//		Button showAllButton = UIControlsFactory.createButton(filterPanel, "Show All");
//		addUIControl(showAllButton,ViewWidgetId.CONTAINER_ShowAllButton);
//		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(false, false).applyTo(showAllButton);
		
		Composite containerPanel = UIControlsFactory.createComposite(containerComposite, SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true, true).applyTo(containerPanel);

		Table table = UIControlsFactory.createTable(containerPanel, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION, ViewWidgetId.CONTAINER_TABLE);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableColumn columnID = new TableColumn(table, SWT.LEFT);
		//		columnID.setText("ID");
		TableColumn columnType = new TableColumn(table, SWT.LEFT);
		//		columnType.setText("Type");

		TableColumn columnMeasure = new TableColumn(table, SWT.LEFT);
		//		columnMeasure.setText("Measure");

		TableColumn columnCapacity = new TableColumn(table, SWT.LEFT);
		//		columnCapacity.setText("Capacity");


		TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(columnID, new ColumnWeightData(25));
		layout.setColumnData(columnType, new ColumnWeightData(25));
		layout.setColumnData(columnMeasure, new ColumnWeightData(25));
		layout.setColumnData(columnCapacity, new ColumnWeightData(25));
		containerPanel.setLayout(layout);

		Composite buttonsPanel = UIControlsFactory.createComposite(containerComposite,SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.BOTTOM).grab(false, true).applyTo(buttonsPanel);
		buttonsPanel.setLayout(new GridLayout(1,false));

		Button addButton = UIControlsFactory.createButton(buttonsPanel, ADD_BUTTON, ViewWidgetId.CONTAINER_ADD);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.BOTTOM).grab(false, false).applyTo(addButton);

		Button removeButton = UIControlsFactory.createButton(buttonsPanel, REMOVE_BUTTON, ViewWidgetId.CONTAINER_Remove);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.BOTTOM).grab(false, false).applyTo(removeButton);


	}

	private void createLivestockInfoTab(Composite livestockComposite) {

		//fitler panel
		Composite filterPanel = UIControlsFactory.createComposite(livestockComposite,SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(false, true).applyTo(filterPanel);
		filterPanel.setLayout(new GridLayout(1,false));

		createDataRangeSearch(filterPanel,"Acqusion Date Range",ViewWidgetId.LIVESTOCK_FILTER_STARTDATE,ViewWidgetId.LIVESTOCK_FILTER_ENDDATE);

		Label emptyLabel = UIControlsFactory.createLabel(filterPanel, "Filter By farm:");
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true, false).applyTo(emptyLabel);

		Combo farmCombo =  UIControlsFactory.createCombo(filterPanel, ViewWidgetId.LIVESTOCK_FarmCombo);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true, false).applyTo(farmCombo);
		
		Label typeLabel = UIControlsFactory.createLabel(filterPanel, "Filter By Species:");
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true, false).applyTo(typeLabel);

		Text speciesText =  UIControlsFactory.createText(filterPanel, SWT.BORDER|SWT.SINGLE,ViewWidgetId.LIVESTOCK_ContainerSpeciesFilter);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true, false).applyTo(speciesText);
		
		Label breedLabel = UIControlsFactory.createLabel(filterPanel, "Filter By Breed:");
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true, false).applyTo(typeLabel);

		Text breedText =  UIControlsFactory.createText(filterPanel, SWT.BORDER|SWT.SINGLE,ViewWidgetId.LIVESTOCK_ContainerBreedFilter);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true, false).applyTo(breedText);

		Button filterButton = UIControlsFactory.createButton(filterPanel, "Apply");
		addUIControl(filterButton,ViewWidgetId.LIVESTOCK_ContainerFilterButton);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true, false).applyTo(filterButton);
		
		Button showAllButton = UIControlsFactory.createButton(filterPanel, "Show All");
		addUIControl(showAllButton,ViewWidgetId.LIVESTOCK_ContainerShowAllButton);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true, false).applyTo(showAllButton);


		Composite containerPanel = UIControlsFactory.createComposite(livestockComposite, SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true, true).applyTo(containerPanel);
		Table table = UIControlsFactory.createTable(containerPanel, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION, ViewWidgetId.LIVESTOCK_TABLE);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableColumn columnID = new TableColumn(table, SWT.LEFT);
		TableColumn columnFarm = new TableColumn(table, SWT.LEFT);
		TableColumn columnPurpose = new TableColumn(table, SWT.LEFT);
		TableColumn columnName = new TableColumn(table, SWT.LEFT);
		TableColumn columnSpecies = new TableColumn(table, SWT.LEFT);
		TableColumn columnBreed = new TableColumn(table, SWT.LEFT);
		TableColumn columnAcquisionDate = new TableColumn(table, SWT.LEFT);
		TableColumn columnAcquisionType = new TableColumn(table, SWT.LEFT);


		TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(columnID, new ColumnWeightData(9));
		layout.setColumnData(columnFarm, new ColumnWeightData(13));
		layout.setColumnData(columnPurpose, new ColumnWeightData(13));
		layout.setColumnData(columnName, new ColumnWeightData(13));
		layout.setColumnData(columnSpecies, new ColumnWeightData(13));
		layout.setColumnData(columnBreed, new ColumnWeightData(13));
		layout.setColumnData(columnAcquisionDate, new ColumnWeightData(13));
		layout.setColumnData(columnAcquisionType, new ColumnWeightData(13));
		containerPanel.setLayout(layout);



		Composite addbuttonsPanel = UIControlsFactory.createComposite(livestockComposite,SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.BOTTOM).grab(false, true).applyTo(addbuttonsPanel);
		addbuttonsPanel.setLayout(new GridLayout(1,false));


		Button addButton = UIControlsFactory.createButton(addbuttonsPanel, ADD_BUTTON, ViewWidgetId.LIVESTOCK_ADD);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.BOTTOM).grab(true, false).applyTo(addButton);

		Button removeButton = UIControlsFactory.createButton(addbuttonsPanel, REMOVE_BUTTON, ViewWidgetId.LIVESTOCK_Remove);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.BOTTOM).grab(false, false).applyTo(removeButton);


	}


	public void createTrasactionsTab(Composite parent){

		//fitler panel
		Composite filterPanel = UIControlsFactory.createComposite(parent,SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(false, true).applyTo(filterPanel);
		filterPanel.setLayout(new GridLayout(1,false));

		createDataRangeSearch(filterPanel,"Transaction Date Range",ViewWidgetId.TRANSACTION_FILTER_STARTDATE,ViewWidgetId.TRANSACTION_FILTER_ENDDATE);

		
		Button filterButton = UIControlsFactory.createButton(filterPanel, "Apply");
		addUIControl(filterButton,ViewWidgetId.TRANSACTION_FILTER_APPLY);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.BOTTOM).grab(true, true).applyTo(filterButton);
		
		Button showAllButton = UIControlsFactory.createButton(filterPanel, "Show All");
		addUIControl(showAllButton,ViewWidgetId.TRANSACTION_FILTER_SHOWALL);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.BOTTOM).grab(true, false).applyTo(showAllButton);
		
		Composite tablePanel = UIControlsFactory.createComposite(parent, SWT.NULL);
		tablePanel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));

		Table table = UIControlsFactory.createTable(tablePanel, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION, ViewWidgetId.TRANSACTION_TABLE);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableColumn columnDate = new TableColumn(table, SWT.LEFT);
		columnDate.setText("Date");
		TableColumn columnType = new TableColumn(table, SWT.LEFT);
		columnType.setText("Type");

		TableColumn columnDescription = new TableColumn(table, SWT.LEFT);
		columnDescription.setText("Description");

		TableColumn columnAmount = new TableColumn(table, SWT.LEFT);
		columnAmount.setText("Amount");

		TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(columnDate, new ColumnWeightData(20));
		layout.setColumnData(columnType, new ColumnWeightData(20));
		layout.setColumnData(columnAmount, new ColumnWeightData(20));
		layout.setColumnData(columnDescription, new ColumnWeightData(40));
		tablePanel.setLayout(layout);
	}

	public void createFarmInfoTab(Composite parent){

		Composite tablePanel = UIControlsFactory.createComposite(parent, SWT.NULL);
		tablePanel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));


		Table table =  UIControlsFactory.createTable(tablePanel, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION, ViewWidgetId.FARM_TABLE);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableColumn columnId = new TableColumn(table, SWT.LEFT);
		columnId.setText("Id");
		TableColumn columnName = new TableColumn(table, SWT.LEFT);
		columnName.setText("Name");
		TableColumn columnLocation = new TableColumn(table, SWT.LEFT);
		columnLocation.setText("Location");
		TableColumn columnAnimal = new TableColumn(table, SWT.LEFT);
		columnAnimal.setText("Number of Animals");
		TableColumn columnCan = new TableColumn(table, SWT.LEFT);
		columnLocation.setText("Number of Containers");


		TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(columnId, new ColumnWeightData(20));
		layout.setColumnData(columnName, new ColumnWeightData(20));
		layout.setColumnData(columnLocation, new ColumnWeightData(20));
		layout.setColumnData(columnAnimal, new ColumnWeightData(20));
		layout.setColumnData(columnCan, new ColumnWeightData(20));
		tablePanel.setLayout(layout);

		Composite buttonsPanel = UIControlsFactory.createComposite(parent,SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.END,SWT.FILL).grab(true, false).applyTo(buttonsPanel);
		buttonsPanel.setLayout(new GridLayout(2,false));

		Button addButton = UIControlsFactory.createButton(buttonsPanel, ADD_BUTTON, ViewWidgetId.FARM_ADD);
		GridDataFactory.swtDefaults().align(SWT.END,SWT.FILL).grab(false, false).applyTo(addButton);

		Button removeButton = UIControlsFactory.createButton(buttonsPanel, REMOVE_BUTTON, ViewWidgetId.FARM_Remove);
		GridDataFactory.swtDefaults().align(SWT.END,SWT.FILL).grab(false, false).applyTo(removeButton);

	}

	public void createAccountSummaryTab(Composite parent){

		Composite accountPanel = UIControlsFactory.createComposite(parent, SWT.NULL);
		accountPanel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		accountPanel.setLayout(new GridLayout(2,true));

		Group deliveriesGroup =UIControlsFactory.createGroup(accountPanel,"Deliveries");
		deliveriesGroup.setLayout(new GridLayout(2,false));
		deliveriesGroup.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,2));

		Label totalLabel = UIControlsFactory.createLabel(deliveriesGroup, "Total Deliveries:");

		Text deliveryField = UIControlsFactory.createText(deliveriesGroup, SWT.SINGLE|SWT.BORDER);
		deliveryField.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		deliveryField.setText("2500");

		Label acceptLabel =  UIControlsFactory.createLabel(deliveriesGroup, "Total Accepted:");

		Text acceptField =  UIControlsFactory.createText(deliveriesGroup, SWT.SINGLE|SWT.BORDER);
		acceptField.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		acceptField.setText("2500");

		Label rejectLabel = UIControlsFactory.createLabel(deliveriesGroup, "Total Rejected:");

		Text rejectField =UIControlsFactory.createText(deliveriesGroup, SWT.SINGLE|SWT.BORDER);
		rejectField.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		rejectField.setText("0");

		Group sharesGroupd =UIControlsFactory.createGroup(accountPanel,"Shares");
		sharesGroupd.setLayout(new GridLayout(4,false));
		sharesGroupd.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));

		Label recCovLabel = UIControlsFactory.createLabel(sharesGroupd, "Total/Recov. :");

		Text recCobTxt1 = UIControlsFactory.createText(sharesGroupd, SWT.SINGLE|SWT.BORDER);
		recCobTxt1.setLayoutData(new GridData(SWT.FILL,SWT.BEGINNING,true,false));
		recCobTxt1.setText("2500");

		Label slashLabel = UIControlsFactory.createLabel(sharesGroupd, "/");

		Text recCobTxt2 = UIControlsFactory.createText(sharesGroupd, SWT.SINGLE|SWT.BORDER);
		recCobTxt2.setLayoutData(new GridData(SWT.FILL,SWT.BEGINNING,true,false));
		recCobTxt2.setText("1250");


		Group creditsGroup =UIControlsFactory.createGroup(accountPanel,"Credits");
		creditsGroup.setLayout(new GridLayout(4,false));
		creditsGroup.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));

		Label creditScoreL =UIControlsFactory.createLabel(creditsGroup,"Credit Score :");

		Text creditScoreTxt = UIControlsFactory.createText(creditsGroup, SWT.SINGLE|SWT.BORDER);
		creditScoreTxt.setLayoutData(new GridData(SWT.BEGINNING,SWT.BEGINNING,false,false,3,1));
		creditScoreTxt.setText("700");

		Label creditLimit = UIControlsFactory.createLabel(creditsGroup,"Credit Limit/Available :");

		Text creditLimitTxt = UIControlsFactory.createText(creditsGroup, SWT.SINGLE|SWT.BORDER);
		creditLimitTxt.setLayoutData(new GridData(SWT.BEGINNING,SWT.BEGINNING,true,false,1,1));
		creditLimitTxt.setText("2000");

		Label slashLabel2 = UIControlsFactory.createLabel(creditsGroup, "/");


		Text creditLimitTxt2 = UIControlsFactory.createText(creditsGroup, SWT.SINGLE|SWT.BORDER);
		creditLimitTxt2.setLayoutData(new GridData(SWT.BEGINNING,SWT.BEGINNING,true,false,1,1));
		creditLimitTxt2.setText("1250");

		Label creditBalanceL = UIControlsFactory.createLabel(creditsGroup, "Credit Balance :");

		Text creditBalanceTxt = UIControlsFactory.createText(creditsGroup, SWT.SINGLE|SWT.BORDER);
		creditBalanceTxt.setLayoutData(new GridData(SWT.BEGINNING,SWT.BEGINNING,false,false,3,1));
		creditBalanceTxt.setText("1000");

		Label cashBalanceL =UIControlsFactory.createLabel(creditsGroup, "Cash Balance :");

		Text cashBalanceTxt = UIControlsFactory.createText(creditsGroup, SWT.SINGLE|SWT.BORDER);
		cashBalanceTxt.setLayoutData(new GridData(SWT.BEGINNING,SWT.BEGINNING,false,false,3,1));
		cashBalanceTxt.setText("1000");

	}


	public class MemberSearchNodeListener extends SimpleNavigationNodeAdapter{


		private final DetachedViewsManager dvManager = new DetachedViewsManager(getSite());

		@Override
		public void activated(INavigationNode<?> source) {
			//			showView(true);
		}

		@Override
		public void deactivated(INavigationNode<?> source) {
			showView(false);
		}

		@Override
		public void disposed(INavigationNode<?> source) {
			// closes all detached views by this manager
			dvManager.dispose();
			// remove this listener - if not removing here, this can also be done in in 
			// the view's dispose method.
			getNavigationNode().removeSimpleListener(this);
			MemberSearchSelectionManager.INSTANCE.setSearchNode(null);
		}

		public void showView(boolean show){
			if(show){
				dvManager.showView("Search Member", MemberSearchDetachedView.class, SWT.RIGHT); //$NON-NLS-1$

			}else{
				dvManager.hideView("Search Member"); //$NON-NLS-1$
			}
		}
	}


	public void update(){
		infoGroup.setMemberShip(selectedMember);

	}

	@Override
	public void dispose() {
		MemberSearchSelectionManager.INSTANCE.clearListeners();
	}



	@Override
	public void widgetSelected(SelectionEvent e) {
		if(e.getSource()== saveButton){
			//			MemberSearchSelectionManager.INSTANCE.notifySelectionModified(this, selectedMember);
		}

	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}

	private void createDataRangeSearch(Composite parent, String rangeLabelTxt, String startTxtId, String endTxtId){

		UIControlsFactory.createLabel(parent, rangeLabelTxt);
		Composite datePanel = UIControlsFactory.createComposite(parent);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true,false).applyTo(datePanel);
		datePanel.setLayout(new GridLayout(3,false));

		UIControlsFactory.createLabel(datePanel, "Start");
		final Text startDateText = UIControlsFactory.createText(datePanel, SWT.READ_ONLY| SWT.BORDER, startTxtId);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,false).applyTo(startDateText);


		Button calendarButton = new Button(datePanel, SWT.PUSH);
		Image calendar = EDairyActivator.getImage(ImageRegistry.calendar);
		calendarButton.setImage(calendar);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(17, 16).applyTo(calendarButton);

		calendarButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
				calDialog.getController().setContext(
						SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,startDateText.getText());

				if (calDialog.open() == AbstractWindowController.OK) {
					Date selectedDate = (Date) calDialog.getController().getContext(SimpleFormattedDateBean.DATE_PROR);
					SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
					bean.setDate(selectedDate);
					startDateText.setText(bean.getFormattedDate());
				}
			}
		});

		UIControlsFactory.createLabel(datePanel, "End");
		final Text endDateText = UIControlsFactory.createText(datePanel, SWT.READ_ONLY| SWT.BORDER, endTxtId);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,false).applyTo(endDateText);
	
		Button calendarButton2 = new Button(datePanel, SWT.PUSH);
		calendarButton2.setImage(calendar);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(
				17, 16).applyTo(calendarButton2);

		calendarButton2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
				calDialog.getController().setContext(
						SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
						endDateText.getText());

				if (calDialog.open() == AbstractWindowController.OK) {
					Date selectedDate = (Date) calDialog.getController()
					.getContext(SimpleFormattedDateBean.DATE_PROR);
					SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
					bean.setDate(selectedDate);
					endDateText.setText(bean.getFormattedDate());
				}
			}
		});

	}

}