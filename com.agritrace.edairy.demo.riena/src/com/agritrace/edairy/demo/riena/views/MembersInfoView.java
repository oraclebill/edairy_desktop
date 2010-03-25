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

import com.agritrace.edairy.demo.riena.Activator;
import com.agritrace.edairy.demo.riena.ImageRegistry;

public class MembersInfoView extends SubModuleView {

	public static final String ID = MembersInfoView.class.getName();

	public MembersInfoView() {
	}

	@Override
	protected void basicCreatePartControl(Composite parent) {

		parent.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));

		parent.setLayout(new GridLayout(1, false));

		Composite composite = new Composite(parent, SWT.NONE);
		GridData data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = SWT.FILL;
		data.grabExcessVerticalSpace = true;
		data.verticalAlignment = SWT.FILL;
		composite.setLayoutData(data);

		GridLayout layout = new GridLayout();
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		layout.numColumns = 1;
		composite.setLayout(layout);
		createMasterDetails(composite);

	}

	// helping methods
	// ////////////////

	private Group createMasterDetails(Composite parent) {
		Group result = UIControlsFactory.createGroup(parent,
		"Members Information:"); //$NON-NLS-1$
		result.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		//
		GridLayout layout = new GridLayout();
		layout.marginHeight = 20;
		layout.marginWidth = 20;
		layout.numColumns = 1;
		result.setLayout(layout);

		StaffInfoMasterDetailsComposite mdComposite = new StaffInfoMasterDetailsComposite(
				result, SWT.NONE);
		Composite details = mdComposite.getDetails();
		details.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		GridLayout detaLayout = new GridLayout();
		detaLayout.numColumns = 1;
		details.setLayout(detaLayout);

		Group detailGroup = UIControlsFactory.createGroup(details, "Details");
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

		TabItem membersTab = new TabItem(tabfolder, SWT.NULL);
		membersTab.setText("Member");
		Composite membersComposite = new Composite(tabfolder, SWT.NONE);
		membersComposite.setLayout(new GridLayout(1,true));
		membersComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		createMembersTabcontrol(membersComposite);
		membersTab.setControl(membersComposite);

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

		TabItem farmTab = new TabItem(tabfolder, SWT.NULL);
		farmTab.setText("Farm");
		Composite farmComposite = new Composite(tabfolder, SWT.NONE);
		farmComposite.setLayout(new GridLayout(1,true));
		createFarmInfoTab(farmComposite);
		farmTab.setControl(farmComposite);

		this.addUIControl(mdComposite, "master"); //$NON-NLS-1$

		Composite buttonPanel = UIControlsFactory.createComposite(details);
		buttonPanel
		.setLayoutData(new GridData(SWT.END, SWT.FILL, true, false));
		buttonPanel.setLayout(new GridLayout(2,false));
		Button saveButton = UIControlsFactory.createButton(buttonPanel,"Save");
		saveButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));

		Button cancelButton = UIControlsFactory.createButton(buttonPanel,"Cancel");
		cancelButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));

		return result;
	}

	private void createMembersTabcontrol(Composite parent){
		Composite upperPanel = UIControlsFactory.createComposite(parent);
		GridLayout upperPanelLayout = new GridLayout();
		upperPanelLayout.numColumns = 6;
		upperPanelLayout.makeColumnsEqualWidth = false;
		upperPanel.setLayout(upperPanelLayout);
		upperPanel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		// member Id
		UIControlsFactory.createLabel(upperPanel, "Member ID:"); //$NON-NLS-1$
		Text txtId = UIControlsFactory.createText(upperPanel, SWT.BORDER, "id"); //$NON-NLS-1$
		txtId.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		// join date
		UIControlsFactory.createLabel(upperPanel, "Joined Date:"); //$NON-NLS-1$
		Text txtDate = UIControlsFactory.createText(upperPanel, SWT.BORDER,
		"date"); //$NON-NLS-1$
		txtDate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		// status
		UIControlsFactory.createLabel(upperPanel, "Status:"); //$NON-NLS-1$
		Combo comboStatus = UIControlsFactory.createCombo(upperPanel, "status");
		comboStatus.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

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
		txtFirst.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

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
		UIControlsFactory.createLabel(addressGroup, "Address:"); //$NON-NLS-1$
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
		Label imageLable = new Label(bottomPanel, SWT.NULL); //$NON-NLS-1$
		GridData imagData = new GridData(SWT.FILL,SWT.TOP,false,false);
		//		imagData.heightHint = 90;
		//		imagData.widthHint = 80;
		Image photoImage = Activator.getImage(ImageRegistry.smileFace);
		imageLable.setImage(photoImage);
		imageLable.setLayoutData(imagData);
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
