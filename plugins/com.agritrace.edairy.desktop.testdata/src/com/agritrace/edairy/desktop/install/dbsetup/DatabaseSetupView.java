package com.agritrace.edairy.desktop.install.dbsetup;

import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class DatabaseSetupView extends SubModuleView
{

	public static final String	ID	= "com.agritrace.edairy.desktop.install.dbsetup.DatabaseSetupView"; //$NON-NLS-1$
	private Text dbNameTxt;
	private Text dbServerTxt;
	private Text dbPortTxt;
	private Text dbAdminUserTxt;
	private Text dbAdminPassTxt;
	private Text dairyRegistrationTxt;
	private Text dairyLicenseeTxt;

	public DatabaseSetupView()
	{
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void basicCreatePartControl(Composite parent)
	{
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		
		Group grpOptions = new Group(container, SWT.NONE);
		grpOptions.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		grpOptions.setText("Dairy");
		grpOptions.setLayout(new GridLayout(5, false));
		
		Label lblDairyId = new Label(grpOptions, SWT.NONE);
		lblDairyId.setText("Registration #");
		
		dairyRegistrationTxt = UIControlsFactory.createText(grpOptions);
		dairyRegistrationTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpOptions, SWT.NONE);
		
		Label lblDairyName = new Label(grpOptions, SWT.NONE);
		lblDairyName.setText("Licensee Name");
		
		dairyLicenseeTxt = UIControlsFactory.createText(grpOptions);
		dairyLicenseeTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpDatabaseServer = new Group(container, SWT.NONE);
		grpDatabaseServer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		grpDatabaseServer.setLayout(new GridLayout(4, false));
		grpDatabaseServer.setText("Database Server");
		
		Label lblDatabaseName = new Label(grpDatabaseServer, SWT.NONE);
		lblDatabaseName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDatabaseName.setText("Database Name");
		
		dbNameTxt = UIControlsFactory.createText(grpDatabaseServer);
		dbNameTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpDatabaseServer, SWT.NONE);
		new Label(grpDatabaseServer, SWT.NONE);
		
		Label lblServerName = new Label(grpDatabaseServer, SWT.NONE);
		lblServerName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblServerName.setText("Server Name");
		
		dbServerTxt = UIControlsFactory.createText(grpDatabaseServer);
		dbServerTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblServerPort = new Label(grpDatabaseServer, SWT.NONE);
		lblServerPort.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblServerPort.setText("Port");
		
		dbPortTxt = UIControlsFactory.createText(grpDatabaseServer);
		dbPortTxt.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Label lblAdminUsername = new Label(grpDatabaseServer, SWT.NONE);
		lblAdminUsername.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAdminUsername.setText("Admin Username");
		
		dbAdminUserTxt = UIControlsFactory.createText(grpDatabaseServer);
		dbAdminUserTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblAdminPassword = new Label(grpDatabaseServer, SWT.NONE);
		lblAdminPassword.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAdminPassword.setText("Password");
		
		dbAdminPassTxt = UIControlsFactory.createText(grpDatabaseServer);
		dbAdminPassTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblCreateNew = new Label(grpDatabaseServer, SWT.NONE);
		lblCreateNew.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, true, 1, 1));
		lblCreateNew.setText("Drop / Create?");
		
		Button dbOverwriteExistingBtn = UIControlsFactory.createButtonCheck(grpDatabaseServer);
		new Label(grpDatabaseServer, SWT.NONE);
		new Label(grpDatabaseServer, SWT.NONE);
		
		Group grpSeedData = new Group(container, SWT.NONE);
		grpSeedData.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		grpSeedData.setText("Test Reference Data");
		grpSeedData.setLayout(new GridLayout(4, false));
		
		Label lblMemberCount = new Label(grpSeedData, SWT.NONE);
		lblMemberCount.setText("Member Count");
		
		Spinner memberCountSpin = UIControlsFactory.createSpinner(grpSeedData, SWT.BORDER);
		
		Label lblNewLabel_1 = new Label(grpSeedData, SWT.NONE);
		lblNewLabel_1.setText("Employee Count");
		
		Spinner employeeCountSpin = UIControlsFactory.createSpinner(grpSeedData, SWT.BORDER);
		
		Label lblTransportRoutes = new Label(grpSeedData, SWT.NONE);
		lblTransportRoutes.setText("# Transport Routes");
		
		Spinner transportRouteSpin = UIControlsFactory.createSpinner(grpSeedData, SWT.BORDER);
		
		Label lblNewLabel = new Label(grpSeedData, SWT.NONE);
		lblNewLabel.setText("# Collection Centers");
		
		Spinner collectionCenterSpin = UIControlsFactory.createSpinner(grpSeedData, SWT.BORDER);
		
		Group grpGenerateCollectionsData = new Group(container, SWT.NONE);
		grpGenerateCollectionsData.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		grpGenerateCollectionsData.setText("Test Transaction Data");
		GridLayout gl_grpGenerateCollectionsData = new GridLayout(4, false);
		gl_grpGenerateCollectionsData.marginBottom = 3;
		gl_grpGenerateCollectionsData.marginTop = 3;
		gl_grpGenerateCollectionsData.marginRight = 3;
		gl_grpGenerateCollectionsData.marginLeft = 3;
		grpGenerateCollectionsData.setLayout(gl_grpGenerateCollectionsData);
		
		Label lblStartData = new Label(grpGenerateCollectionsData, SWT.NONE);
		lblStartData.setText("Start Date");
		
		DateTime startDate = UIControlsFactory.createDate(grpGenerateCollectionsData, SWT.BORDER);
		
		Label lblEndDate = new Label(grpGenerateCollectionsData, SWT.NONE);
		lblEndDate.setText("End Date");
		
		DateTime endDate = UIControlsFactory.createDate(grpGenerateCollectionsData, SWT.BORDER);
		
		Composite composite = new Composite(grpGenerateCollectionsData, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
		GridLayout gl_composite = new GridLayout(3, false);
		gl_composite.marginBottom = 3;
		gl_composite.marginTop = 3;
		gl_composite.marginRight = 3;
		gl_composite.marginLeft = 3;
		composite.setLayout(gl_composite);
		new Label(composite, SWT.NONE);
		
		Button btnSimulateCollections = UIControlsFactory.createButtonCheck(composite);
		btnSimulateCollections.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		btnSimulateCollections.setText("Simulate Collections?");
		new Label(composite, SWT.NONE);
		
		Label lblCollections = new Label(composite, SWT.NONE);
		lblCollections.setText("Avg. Collection / Member");
		
		Spinner avgMemberCollectionSpin = UIControlsFactory.createSpinner(composite, SWT.BORDER);
		new Label(grpGenerateCollectionsData, SWT.NONE);
		new Label(grpGenerateCollectionsData, SWT.NONE);
		new Label(grpGenerateCollectionsData, SWT.NONE);
		new Label(grpGenerateCollectionsData, SWT.NONE);
		
		Composite composite_1 = new Composite(container, SWT.NONE);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		composite_1.setLayout(new FormLayout());
		
		Button btnNewButton = UIControlsFactory.createButton(composite_1);
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.left = new FormAttachment(0, 112);
		fd_btnNewButton.top = new FormAttachment(0);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("Initialize Database");
	}

}
