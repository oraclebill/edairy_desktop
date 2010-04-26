package com.agritrace.edairy.riena.ui.views;

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
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.DetachedViewsManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.model.dairy.Membership;

public class MemberListView extends SubModuleView implements MemberSearchSelectionListener, SelectionListener{

	public static final String ID = MemberListView.class.getName();
	
	public static final String MEMBER_INFO_GROUP="Members Information";
	//address tab
	public static final String ADDRESS_TAB="Address";
	public static final String ADDRESS_LABEL="Address:";
	public static final String LOCATION_LABEL="Location:";
	public static final String VILLAGE_LABEL="Village:";
	public static final String DISTRICT_LABEL="District:";
	public static final String PROVINCE_LABEL="Province:";
	public static final String POSTAL_CODE_LABEL="Postal Code:";

	
	private Composite main;
	private Text txtName;
	private Text txtId;
	private List lstMembers;
	private Membership selectedMember;
	
	private MemberInfoGroup infoGroup ;
	
	private Button saveButton;
	private Button cancelButton;
	

	public MemberListView() {
		MemberSearchSelectionManager.INSTANCE.addSearchSelectionListener(this);
	}

	@Override
	protected void basicCreatePartControl(Composite parent) {

		parent.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));

		parent.setLayout(new GridLayout(1, false));

		main = UIControlsFactory.createComposite(parent); 
		main.setLayout(new GridLayout(1, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,true).applyTo(main);
		
		createMemberSelectorGroup(main);
		createMasterDetails(main);
		
		getNavigationNode().addSimpleListener(new MemberSearchNodeListener());

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
		details.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		GridLayout detaLayout = new GridLayout();
		detaLayout.numColumns = 1;
		details.setLayout(detaLayout);

		Group detailGroup = UIControlsFactory.createGroup(details, MEMBER_INFO_GROUP);
		detailGroup
		.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		GridLayout groupLayout = new GridLayout();
		groupLayout.numColumns = 1;
		detailGroup.setLayout(groupLayout);
		detailGroup.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		TabFolder tabfolder = new TabFolder(detailGroup, SWT.NULL);
		tabfolder.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		tabfolder.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		tabfolder.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		

		// member info
		TabItem membersTab = new TabItem(tabfolder, SWT.NULL);
		membersTab.setText(ADDRESS_TAB);
		Composite membersComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		membersComposite.setLayout(new GridLayout(1,true));
		membersComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		createMembersTabcontrol(membersComposite);
		membersTab.setControl(membersComposite);

		// account summary
		TabItem accountTab = new TabItem(tabfolder, SWT.NULL);
		accountTab.setText("Account Summary");
		Composite accountComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		accountComposite.setLayout(new GridLayout(1,true));
		accountComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		createAccountSummaryTab(accountComposite);
		accountTab.setControl(accountComposite);

		TabItem transactionTab = new TabItem(tabfolder, SWT.NULL);
		transactionTab.setText("Transactions");
		Composite transComposite =UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		transComposite.setLayout(new GridLayout(1,true));
		createTrasactionsTab(transComposite);
		transactionTab.setControl(transComposite);

		TabItem collectionTab = new TabItem(tabfolder, SWT.NULL);
		collectionTab.setText("Milk");
		Composite collectionComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		collectionComposite.setLayout(new GridLayout(1,true));
		createCollectionInfoTab(collectionComposite);
		collectionTab.setControl(collectionComposite);

		TabItem farmTab = new TabItem(tabfolder, SWT.NULL);
		farmTab.setText("Farm");
		Composite farmComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		farmComposite.setLayout(new GridLayout(1,true));
		createFarmInfoTab(farmComposite);
		farmTab.setControl(farmComposite);

		TabItem livestockTab = new TabItem(tabfolder, SWT.NULL);
		livestockTab.setText("Livestock");
		Composite livestockComposite =UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		livestockComposite.setLayout(new GridLayout(1,true));
		createLivestockInfoTab(livestockComposite);
		livestockTab.setControl(livestockComposite);

		TabItem containerTab = new TabItem(tabfolder, SWT.NULL);
		containerTab.setText("Containers");
		Composite containerComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		containerComposite.setLayout(new GridLayout(1,true));
		createContainerInfoTab(containerComposite);
		containerTab.setControl(containerComposite);

		Composite buttonPanel = UIControlsFactory.createComposite(details);
		buttonPanel
		.setLayoutData(new GridData(SWT.END, SWT.FILL, true, false));
		buttonPanel.setLayout(new GridLayout(2,false));
		saveButton = UIControlsFactory.createButton(buttonPanel,"Save");
		saveButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));
		saveButton.addSelectionListener(this);

		cancelButton = UIControlsFactory.createButton(buttonPanel,"Cancel");
		cancelButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));
		cancelButton.addSelectionListener(this);

		return details;
	}

	private void createCollectionInfoTab(Composite collectionComposite) {
		// TODO Auto-generated method stub
		
	}

	private void createContainerInfoTab(Composite containerComposite) {
		// TODO Auto-generated method stub
		
	}

	private void createLivestockInfoTab(Composite livestockComposite) {
		// TODO Auto-generated method stub
		
	}

	private void createMembersTabcontrol(Composite parent){

		// bottom panel-"name group","address group" and "photo"
		Composite bottomPanel = UIControlsFactory.createComposite(parent);
		GridLayout layout2 = new GridLayout(6, false);
		bottomPanel.setLayout(layout2);
		bottomPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		
		// address
		Label label = UIControlsFactory.createLabel(bottomPanel,ADDRESS_LABEL); //$NON-NLS-1$
		GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label.minimumWidth = 100;
		label.setLayoutData(gd_label);
		Text txtAddress = UIControlsFactory.createText(bottomPanel,SWT.BORDER, "address");
		txtAddress.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 5, 1));
		// section
		UIControlsFactory.createLabel(bottomPanel, "Section/Homestead:"); //$NON-NLS-1$
		Text txtAddress2 = UIControlsFactory.createText(bottomPanel,	SWT.BORDER, "address2");
		txtAddress2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 5, 1));
		
		// estate
		UIControlsFactory.createLabel(bottomPanel, "Estate/Nearest Center:"); //$NON-NLS-1$
		Text estateAddress = UIControlsFactory.createText(bottomPanel,	SWT.BORDER, "address2");
		estateAddress.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 2, 1));

		// town
		UIControlsFactory.createLabel(bottomPanel, VILLAGE_LABEL); //$NON-NLS-1$
		Text txtVillage = UIControlsFactory.createText(bottomPanel, SWT.BORDER,
		"village");
		txtVillage.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 2, 1));
		
		// sublocation
		UIControlsFactory.createLabel(bottomPanel, "Sublocation"); //$NON-NLS-1$
		Text txtSubLocation = UIControlsFactory.createText(bottomPanel, SWT.BORDER);
		txtSubLocation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 2, 1));
		

		// location
		UIControlsFactory.createLabel(bottomPanel, "Location"); //$NON-NLS-1$
		Text txtLocation = UIControlsFactory.createText(bottomPanel, SWT.BORDER);
		txtLocation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 2, 1));
		
		// division
		UIControlsFactory.createLabel(bottomPanel, "Division"); //$NON-NLS-1$
		Text txtDivision = UIControlsFactory.createText(bottomPanel, SWT.BORDER);
		txtDivision.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 2, 1));
		
		// District
		UIControlsFactory.createLabel(bottomPanel,DISTRICT_LABEL ); //$NON-NLS-1$
		Text txtDistrict = UIControlsFactory.createText(bottomPanel,	SWT.BORDER, "district");
		txtDistrict.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 2, 1));

		// province
		UIControlsFactory.createLabel(bottomPanel,PROVINCE_LABEL); //$NON-NLS-1$
		Combo comboProvince = UIControlsFactory.createCombo(bottomPanel, "province");
		comboProvince.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 2, 1));
		
		// PostalCode
		UIControlsFactory.createLabel(bottomPanel, POSTAL_CODE_LABEL); //$NON-NLS-1$
		Text txtPostal = UIControlsFactory.createText(bottomPanel, SWT.BORDER,
		"postalCode");
		txtPostal.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,false, 2, 1));
	}

	public void createTrasactionsTab(Composite parent){

		Composite tablePanel = UIControlsFactory.createComposite(parent, SWT.NULL);
		tablePanel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));

		Table table = new Table(tablePanel, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
		//			Table table = UIControlsFactory.createTable(tablePanel, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION,
		//					"transactionTable"); //$NON-NLS-1$
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

		Table table = new Table(tablePanel, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
		//			Table table = UIControlsFactory.createTable(tablePanel, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION,
		//					"transactionTable"); //$NON-NLS-1$
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableColumn columnId = new TableColumn(table, SWT.LEFT);
		columnId.setText("Id");
		TableColumn columnName = new TableColumn(table, SWT.LEFT);
		columnName.setText("Name");
		TableColumn columnRoute = new TableColumn(table, SWT.LEFT);
		columnRoute.setText("Route");
		TableColumn columnAnimal = new TableColumn(table, SWT.LEFT);
		columnAnimal.setText("Number of Animals");
		TableColumn columnLocation = new TableColumn(table, SWT.LEFT);
		columnLocation.setText("Location");
		TableColumn columnSubLocation = new TableColumn(table, SWT.LEFT);
		columnSubLocation.setText("Sub Location");
		TableColumn columnViallage = new TableColumn(table, SWT.LEFT);
		columnViallage.setText("village");

		TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(columnId, new ColumnWeightData(10));
		layout.setColumnData(columnName, new ColumnWeightData(15));
		layout.setColumnData(columnRoute, new ColumnWeightData(15));
		layout.setColumnData(columnAnimal, new ColumnWeightData(15));
		layout.setColumnData(columnLocation, new ColumnWeightData(15));
		layout.setColumnData(columnSubLocation, new ColumnWeightData(15));
		layout.setColumnData(columnViallage, new ColumnWeightData(15));


		tablePanel.setLayout(layout);
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
			dvManager.showView("Search Member", MemberSearchView.class, SWT.RIGHT); //$NON-NLS-1$
		}

		@Override
		public void deactivated(INavigationNode<?> source) {
			dvManager.hideView("Search Member"); //$NON-NLS-1$
		}

		@Override
		public void disposed(INavigationNode<?> source) {
			// closes all detached views by this manager
			dvManager.dispose();
			// remove this listener - if not removing here, this can also be done in in 
			// the view's dispose method.
			getNavigationNode().removeSimpleListener(this);
		}



}

	
	public void update(){
		infoGroup.setMemberShip(selectedMember);

	}
	
	public void dispose() {
		MemberSearchSelectionManager.INSTANCE.clearListeners();
	}

	@Override
	public void memberSelectionChanged(Membership selectedMember) {
		this.selectedMember = selectedMember;
		update();
		
	}

	@Override
	public void memberModified(Membership modifiedMember) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if(e.getSource()== saveButton){
			MemberSearchSelectionManager.INSTANCE.notifySelectionModified(this, selectedMember);
		}
		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
