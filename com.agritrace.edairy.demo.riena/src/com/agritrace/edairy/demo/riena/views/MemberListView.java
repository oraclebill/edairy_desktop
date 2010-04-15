package com.agritrace.edairy.demo.riena.views;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.demo.riena.EDairyActivator;
import com.agritrace.edairy.demo.riena.ImageRegistry;
import com.swtdesigner.ResourceManager;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.core.databinding.beans.PojoObservables;

public class MemberListView extends SubModuleView {
	private DataBindingContext m_bindingContext;

	public static final String ID = MemberListView.class.getName();
	private Composite main;
	private Text txtName;
	private Text txtId;
	private List lstMembers;

	public MemberListView() {
	}

	@Override
	protected void basicCreatePartControl(Composite parent) {

		parent.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));

		parent.setLayout(new GridLayout(1, false));

		main = new Composite(parent, SWT.NONE);
		main.setLayout(new GridLayout(2, false));
		GridData gd_main = new GridData();
		gd_main.minimumWidth = 600;
		gd_main.grabExcessHorizontalSpace = true;
		gd_main.horizontalAlignment = SWT.FILL;
		gd_main.grabExcessVerticalSpace = true;
		gd_main.verticalAlignment = SWT.FILL;
		main.setLayoutData(gd_main);
		
		createMemberSelectorGroup(main);
		
		createMemberSnapshotGroup(main);
		
//		createMemberDetailGroup(main);
		createMasterDetails(main);

	}

	private void createMemberSelectorGroup(Composite composite) {
		Group memberSelector = new Group(main, SWT.NONE);
		memberSelector.setLayout(new GridLayout(2, false));
		GridData gd_memberSelector = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_memberSelector.widthHint = 300;
		memberSelector.setLayoutData(gd_memberSelector);
		memberSelector.setText("Search");
		
		Label lblName = new Label(memberSelector, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("Name");
		
		txtName = new Text(memberSelector, SWT.BORDER);
		GridData gd_txtName = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtName.minimumWidth = 150;
		txtName.setLayoutData(gd_txtName);
		
		Label lblId = new Label(memberSelector, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblId.setText("Member ID");
		
		txtId = new Text(memberSelector, SWT.BORDER);
		GridData gd_txtId = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtId.minimumWidth = 150;
		txtId.setLayoutData(gd_txtId);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(memberSelector, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		lstMembers = new List(scrolledComposite, SWT.BORDER);
		lstMembers.setItems(new String[] {"Kofi Annan", "Kyle Rama", "Siri Dilettante", "Ronald McDonald", "Richard Pryor"});
		scrolledComposite.setContent(lstMembers);
		scrolledComposite.setMinSize(lstMembers.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
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
		m_bindingContext = initDataBindings();
		
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

		Group detailGroup = UIControlsFactory.createGroup(details, "Members Information");
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
		membersTab.setText("Member");
		Composite membersComposite = new Composite(tabfolder, SWT.NONE);
		membersComposite.setLayout(new GridLayout(1,true));
		membersComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		createMembersTabcontrol(membersComposite);
		membersTab.setControl(membersComposite);

		// account summary
		TabItem accountTab = new TabItem(tabfolder, SWT.NULL);
		accountTab.setText("Account Summary");
		Composite accountComposite = new Composite(tabfolder, SWT.NONE);
		accountComposite.setLayout(new GridLayout(1,true));
		accountComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		createAccountSummaryTab(accountComposite);
		accountTab.setControl(accountComposite);

		TabItem transactionTab = new TabItem(tabfolder, SWT.NULL);
		transactionTab.setText("Transactions");
		Composite transComposite = new Composite(tabfolder, SWT.NONE);
		transComposite.setLayout(new GridLayout(1,true));
		createTrasactionsTab(transComposite);
		transactionTab.setControl(transComposite);

		TabItem collectionTab = new TabItem(tabfolder, SWT.NULL);
		collectionTab.setText("Milk");
		Composite collectionComposite = new Composite(tabfolder, SWT.NONE);
		collectionComposite.setLayout(new GridLayout(1,true));
		createCollectionInfoTab(collectionComposite);
		collectionTab.setControl(collectionComposite);

		TabItem farmTab = new TabItem(tabfolder, SWT.NULL);
		farmTab.setText("Farm");
		Composite farmComposite = new Composite(tabfolder, SWT.NONE);
		farmComposite.setLayout(new GridLayout(1,true));
		createFarmInfoTab(farmComposite);
		farmTab.setControl(farmComposite);

		TabItem livestockTab = new TabItem(tabfolder, SWT.NULL);
		livestockTab.setText("Livestock");
		Composite livestockComposite = new Composite(tabfolder, SWT.NONE);
		livestockComposite.setLayout(new GridLayout(1,true));
		createLivestockInfoTab(livestockComposite);
		livestockTab.setControl(livestockComposite);

		TabItem containerTab = new TabItem(tabfolder, SWT.NULL);
		containerTab.setText("Containers");
		Composite containerComposite = new Composite(tabfolder, SWT.NONE);
		containerComposite.setLayout(new GridLayout(1,true));
		createContainerInfoTab(containerComposite);
		containerTab.setControl(containerComposite);

		Composite buttonPanel = UIControlsFactory.createComposite(details);
		buttonPanel
		.setLayoutData(new GridData(SWT.END, SWT.FILL, true, false));
		buttonPanel.setLayout(new GridLayout(2,false));
		Button saveButton = UIControlsFactory.createButton(buttonPanel,"Save");
		saveButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));

		Button cancelButton = UIControlsFactory.createButton(buttonPanel,"Cancel");
		cancelButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));

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
		Composite upperPanel = UIControlsFactory.createComposite(parent);
		upperPanel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		GridLayout upperPanelLayout = new GridLayout();
		upperPanelLayout.numColumns = 6;
		upperPanelLayout.makeColumnsEqualWidth = false;
		upperPanel.setLayout(upperPanelLayout);
		upperPanel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		// member Id
		UIControlsFactory.createLabel(upperPanel, "Member ID:"); //$NON-NLS-1$
		Text txtId = UIControlsFactory.createText(upperPanel, SWT.BORDER, "id"); //$NON-NLS-1$
		GridData gd_txtId = new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1);
		gd_txtId.minimumWidth = 50;
		txtId.setLayoutData(gd_txtId);

		// join date
		UIControlsFactory.createLabel(upperPanel, "Joined Date:"); //$NON-NLS-1$
		DateTime txtDate = new DateTime(upperPanel, SWT.BORDER); //$NON-NLS-1$
		GridData gd_txtDate = new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1);
		gd_txtDate.minimumWidth = 70;
		txtDate.setLayoutData(gd_txtDate);

		// status
		UIControlsFactory.createLabel(upperPanel, "Status:"); //$NON-NLS-1$
		Combo comboStatus = UIControlsFactory.createCombo(upperPanel, "status");
		comboStatus.setItems(new String[] {"Active", "Inactive", "Dormant"});
		GridData gd_comboStatus = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		gd_comboStatus.minimumWidth = 70;
		comboStatus.setLayoutData(gd_comboStatus);
		comboStatus.setText("Active");

		// bottom panel-"name group","address group" and "photo"
		Composite bottomPanel = UIControlsFactory.createComposite(parent);
		GridLayout layout2 = new GridLayout(3, false);
		bottomPanel.setLayout(layout2);
		bottomPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		bottomPanel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		// name group;
		Group nameGroup = UIControlsFactory.createGroup(bottomPanel, "Name");
		GridLayout nameGroupLayout = new GridLayout(2, false);
		nameGroup.setLayout(nameGroupLayout);
		nameGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		UIControlsFactory.createLabel(nameGroup, "First Name:"); //$NON-NLS-1$
		Text txtFirst = UIControlsFactory.createText(nameGroup, SWT.BORDER,
		"first"); //$NON-NLS-1$
		GridData gd_txtFirst = new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1);
		gd_txtFirst.minimumWidth = 100;
		txtFirst.setLayoutData(gd_txtFirst);

		//		Label imageLable = new Label(detailGroup, SWT.BORDER); //$NON-NLS-1$
		// GridData imagData = new GridData();
		// imagData.heightHint = 100;
		// imagData.widthHint = 100;
		// // imagData.minimumHeight =48;
		// // imagData.minimumWidth=48;
		// imagData.verticalSpan = 4;
		// Image photoImage = Activator.getImage(ImageRegistry.smileFace);
		// imageLable.setImage(photoImage);
		// imageLable.setLayoutData(imagData);

		UIControlsFactory.createLabel(nameGroup, "Last Name:"); //$NON-NLS-1$
		Text txtLast = UIControlsFactory.createText(nameGroup, SWT.BORDER,
		"last"); //$NON-NLS-1$
		txtLast.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));

		UIControlsFactory.createLabel(nameGroup, "Phone Number:"); //$NON-NLS-1$
		Text txtPhone = UIControlsFactory.createText(nameGroup, SWT.BORDER,
		"phone"); //$NON-NLS-1$
		txtPhone.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));

		// address group;
		Group addressGroup = UIControlsFactory.createGroup(bottomPanel, "Address");
		GridLayout addressGroupLayout = new GridLayout(2, false);
		addressGroup.setLayout(addressGroupLayout);
		addressGroup
		.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		// address
		Label label = UIControlsFactory.createLabel(addressGroup, "Address:"); //$NON-NLS-1$
		GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label.minimumWidth = 100;
		label.setLayoutData(gd_label);
		Text txtAddress = UIControlsFactory.createText(addressGroup,
				SWT.BORDER, "address");
		txtAddress.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		// address2
		UIControlsFactory.createLabel(addressGroup, "Address2:"); //$NON-NLS-1$
		Text txtAddress2 = UIControlsFactory.createText(addressGroup,
				SWT.BORDER, "address2");
		txtAddress2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		// town
		UIControlsFactory.createLabel(addressGroup, "City:"); //$NON-NLS-1$
		Text txtCity = UIControlsFactory.createText(addressGroup, SWT.BORDER,
		"city");
		txtCity.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		// province
		UIControlsFactory.createLabel(addressGroup, "Province:"); //$NON-NLS-1$
		Text txtProvince = UIControlsFactory.createText(addressGroup,
				SWT.BORDER, "province");
		txtProvince.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		// province
		UIControlsFactory.createLabel(addressGroup, "Postal Code:"); //$NON-NLS-1$
		Text txtPostal = UIControlsFactory.createText(addressGroup, SWT.BORDER,
		"postalCode");
		txtPostal.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		//photo
		Label imageLable = new Label(bottomPanel, SWT.NULL);
		//		imagData.heightHint = 90;
		//		imagData.widthHint = 80;
		imageLable.setImage(ResourceManager.getPluginImage("com.agritrace.edairy.demo.riena", "resources/farmerheadshot.png"));
		imageLable.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false));
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

		Group deliveriesGroup = new Group(accountPanel,SWT.BORDER);
		deliveriesGroup.setText("Deliveries");
		deliveriesGroup.setLayout(new GridLayout(2,false));
		deliveriesGroup.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,2));

		Label totalLabel = new Label(deliveriesGroup, SWT.NULL);
		totalLabel.setText("Total Deliveries:");

		Text deliveryField = new Text(deliveriesGroup, SWT.SINGLE|SWT.BORDER);
		deliveryField.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		deliveryField.setText("2500");
		
		Label acceptLabel = new Label(deliveriesGroup, SWT.NULL);
		acceptLabel.setText("Total Accepted:");

		Text acceptField = new Text(deliveriesGroup, SWT.SINGLE|SWT.BORDER);
		acceptField.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		acceptField.setText("2500");

		Label rejectLabel = new Label(deliveriesGroup, SWT.NULL);
		rejectLabel.setText("Total Rejected:");

		Text rejectField = new Text(deliveriesGroup, SWT.SINGLE|SWT.BORDER);
		rejectField.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		rejectField.setText("0");

		Group sharesGroupd = new Group(accountPanel,SWT.BORDER);
		sharesGroupd.setText("Shares");
		sharesGroupd.setLayout(new GridLayout(4,false));
		sharesGroupd.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));

		Label recCovLabel = new Label(sharesGroupd, SWT.NULL);
		recCovLabel.setText("Total/Recov. :");

		Text recCobTxt1 = new Text(sharesGroupd, SWT.SINGLE|SWT.BORDER);
		recCobTxt1.setLayoutData(new GridData(SWT.FILL,SWT.BEGINNING,true,false));
		recCobTxt1.setText("2500");
		
		Label slashLabel = new Label(sharesGroupd, SWT.NULL);
		slashLabel.setText("/");

		Text recCobTxt2 = new Text(sharesGroupd, SWT.SINGLE|SWT.BORDER);
		recCobTxt2.setLayoutData(new GridData(SWT.FILL,SWT.BEGINNING,true,false));
		recCobTxt2.setText("1250");


		Group creditsGroup = new Group(accountPanel,SWT.BORDER);
		creditsGroup.setText("Credits");
		creditsGroup.setLayout(new GridLayout(4,false));
		creditsGroup.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));

		Label creditScoreL = new Label(creditsGroup, SWT.NULL);
		creditScoreL.setText("Credit Score :");

		Text creditScoreTxt = new Text(creditsGroup, SWT.SINGLE|SWT.BORDER);
		creditScoreTxt.setLayoutData(new GridData(SWT.BEGINNING,SWT.BEGINNING,false,false,3,1));
		creditScoreTxt.setText("700");

		Label creditLimit = new Label(creditsGroup, SWT.NULL);
		creditLimit.setText("Credit Limit/Available :");

		Text creditLimitTxt = new Text(creditsGroup, SWT.SINGLE|SWT.BORDER);
		creditLimitTxt.setLayoutData(new GridData(SWT.BEGINNING,SWT.BEGINNING,true,false,1,1));
		creditLimitTxt.setText("2000");

		Label slashLabel2 = new Label(creditsGroup, SWT.NULL);
		slashLabel2.setText("/");

		Text creditLimitTxt2 = new Text(creditsGroup, SWT.SINGLE|SWT.BORDER);
		creditLimitTxt2.setLayoutData(new GridData(SWT.BEGINNING,SWT.BEGINNING,true,false,1,1));
		creditLimitTxt2.setText("1250");

		Label creditBalanceL = new Label(creditsGroup, SWT.NULL);
		creditBalanceL.setText("Credit Balance :");

		Text creditBalanceTxt = new Text(creditsGroup, SWT.SINGLE|SWT.BORDER);
		creditBalanceTxt.setLayoutData(new GridData(SWT.BEGINNING,SWT.BEGINNING,false,false,3,1));
		creditBalanceTxt.setText("1000");
		
		Label cashBalanceL = new Label(creditsGroup, SWT.NULL);
		cashBalanceL.setText("Cash Balance :");

		Text cashBalanceTxt = new Text(creditsGroup, SWT.SINGLE|SWT.BORDER);
		cashBalanceTxt.setLayoutData(new GridData(SWT.BEGINNING,SWT.BEGINNING,false,false,3,1));
		cashBalanceTxt.setText("1000");

	}
}
