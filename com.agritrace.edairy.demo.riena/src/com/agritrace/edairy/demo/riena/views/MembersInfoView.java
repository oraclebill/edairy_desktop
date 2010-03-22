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
		
		TabFolder tabfolder = new TabFolder(detailGroup, SWT.NULL);
		tabfolder.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		tabfolder.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		tabfolder.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		
		TabItem membersTab = new TabItem(tabfolder, SWT.NULL);
		membersTab.setText("Member");
		Composite membersComposite = new Composite(tabfolder, SWT.NONE);
		membersComposite.setLayout(new GridLayout(1,true));
	    createMembersTabcontrol(membersComposite);
	    membersTab.setControl(membersComposite);
	    
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

		return result;
	}
	
	private void createMembersTabcontrol(Composite parent){
		Composite upperPanel = UIControlsFactory.createComposite(parent);
		GridLayout upperPanelLayout = new GridLayout();
		upperPanelLayout.numColumns = 6;
		upperPanelLayout.makeColumnsEqualWidth = false;
		upperPanel.setLayout(upperPanelLayout);
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
		GridData imagData = new GridData(SWT.BEGINNING,SWT.BEGINNING,false,false);
		imagData.heightHint = 100;
		imagData.widthHint = 100;
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

}
