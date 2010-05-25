package com.agritrace.edairy.desktop.member.ui.dialog;


import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;

import com.agritrace.edairy.desktop.member.ui.views.MemberAccountWidget;
import com.agritrace.edairy.desktop.member.ui.views.MemberCollectionRecordsWidget;
import com.agritrace.edairy.desktop.member.ui.views.MemberContainerWidget;
import com.agritrace.edairy.desktop.member.ui.views.MemberFarmWidget;
import com.agritrace.edairy.desktop.member.ui.views.MemberLiveStockWidget;
import com.agritrace.edairy.desktop.member.ui.views.MemberProfileWidget;
import com.agritrace.edairy.desktop.member.ui.views.MemberTransactionWidget;



public class MembershipTabFolder {
	
	private Composite tabComposite;
	
	public static final String MEMBER_INFO_GROUP = "Members Information";

	
	public MembershipTabFolder(Composite parent){
		initGUI(parent);
	}
	
	private void initGUI(Composite parent){


		tabComposite = UIControlsFactory.createComposite(parent);
		final GridData detailsGD = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		detailsGD.minimumHeight = 200;
		tabComposite.setLayoutData(detailsGD);
		final GridLayout detaLayout = new GridLayout();
		detaLayout.numColumns = 1;
		tabComposite.setLayout(detaLayout);

		final Group detailGroup = UIControlsFactory.createGroup(tabComposite, MEMBER_INFO_GROUP);
		detailGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		final GridLayout groupLayout = new GridLayout();
		groupLayout.numColumns = 1;
		detailGroup.setLayout(groupLayout);
		detailGroup.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		final CTabFolder tabfolder = new CTabFolder(detailGroup, SWT.NULL);
		tabfolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		final Color startColor = LnfManager.getLnf().getColor(
				LnfKeyConstants.EMBEDDED_TITLEBAR_ACTIVE_BACKGROUND_START_COLOR);
		final Color endColor = LnfManager.getLnf().getColor(
				LnfKeyConstants.EMBEDDED_TITLEBAR_ACTIVE_BACKGROUND_END_COLOR);
		tabfolder.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		tabfolder.setSelectionBackground(new Color[] { startColor, endColor }, new int[] { 50 }, true);
		

		//profile tab
		final CTabItem profileTab = new CTabItem(tabfolder, SWT.NULL);
		profileTab.setText("Profile");
		final Composite profileComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		profileComposite.setLayout(new GridLayout(1, true));
		MemberProfileWidget profileWidget = new MemberProfileWidget(profileComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(profileWidget.getComposite());
		profileTab.setControl(profileComposite);


		// account summary
		final CTabItem accountTab = new CTabItem(tabfolder, SWT.NULL);
		accountTab.setText("Account Summary");
		final Composite accountComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		accountComposite.setLayout(new GridLayout(1, true));
		MemberAccountWidget accountWidget = new MemberAccountWidget(accountComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(accountWidget.getComposite());		accountTab.setControl(accountComposite);
		accountTab.setControl(accountComposite);

		final CTabItem transactionTab = new CTabItem(tabfolder, SWT.NULL);
		transactionTab.setText("Transactions");
		Composite transComposite =  UIControlsFactory.createComposite(tabfolder,SWT.NONE);
		transComposite.setLayout(new GridLayout(1, true));
		MemberTransactionWidget transWidget = new MemberTransactionWidget(transComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(transWidget.getComposite());
		transactionTab.setControl(transComposite);

		final CTabItem collectionTab = new CTabItem(tabfolder, SWT.NULL);
		collectionTab.setText("Collection Records");
		final Composite collectionComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		collectionComposite.setLayout(new GridLayout(1, true));
		MemberCollectionRecordsWidget collectionWidget = new MemberCollectionRecordsWidget(collectionComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(collectionWidget.getComposite());
		collectionTab.setControl(collectionComposite);

		final CTabItem farmTab = new CTabItem(tabfolder, SWT.NULL);
		farmTab.setText("Farm");
		final Composite farmComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		farmComposite.setLayout(new GridLayout(1, true));
		MemberFarmWidget farmWidget = new MemberFarmWidget(farmComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(farmWidget.getComposite());
		farmTab.setControl(farmComposite);

		final CTabItem livestockTab = new CTabItem(tabfolder, SWT.NULL);
		livestockTab.setText("Livestock");
		final Composite livestockComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		livestockComposite.setLayout(new GridLayout(1, true));
		MemberLiveStockWidget liveStockWidget = new MemberLiveStockWidget(livestockComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(liveStockWidget.getComposite());
		livestockTab.setControl(livestockComposite);

		final CTabItem containerTab = new CTabItem(tabfolder, SWT.NULL);
		containerTab.setText("Containers");
		final Composite containerComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		containerComposite.setLayout(new GridLayout(1, false));
		MemberContainerWidget containerWidget = new MemberContainerWidget(containerComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(containerWidget.getComposite());
		containerTab.setControl(containerComposite);

		tabfolder.setSelection(accountTab);
	}

	public Composite getTabComposite() {
		return tabComposite;
	}

}
