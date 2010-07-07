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

import com.agritrace.edairy.desktop.common.ui.views.LocationProfileWidget;
import com.agritrace.edairy.desktop.member.ui.controls.MemberContainerWidget;
import com.agritrace.edairy.desktop.member.ui.controls.MemberLiveStockWidget;

public class FarmTabFolder {

	public static final String MEMBER_INFO_GROUP = "Farm Information";
	private Composite tabComposite;

	public FarmTabFolder(Composite parent) {
		initGUI(parent);
	}

	public Composite getTabComposite() {
		return tabComposite;
	}

	private void initGUI(Composite parent) {
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

		// profile tab
		final CTabItem profileTab = new CTabItem(tabfolder, SWT.NULL);
		profileTab.setText("Address");
		final Composite profileComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		profileComposite.setLayout(new GridLayout(1, true));
		final LocationProfileWidget addressWidget = new LocationProfileWidget(profileComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(addressWidget.getComposite());
		profileTab.setControl(profileComposite);

		final CTabItem livestockTab = new CTabItem(tabfolder, SWT.NULL);
		livestockTab.setText("Livestock");
		final Composite livestockComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		livestockComposite.setLayout(new GridLayout(1, true));
		final MemberLiveStockWidget liveStockWidget = new MemberLiveStockWidget(livestockComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true)
				.applyTo(liveStockWidget.getComposite());
		livestockTab.setControl(livestockComposite);

		final CTabItem containerTab = new CTabItem(tabfolder, SWT.NULL);
		containerTab.setText("Containers");
		final Composite containerComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		containerComposite.setLayout(new GridLayout(1, false));
		final MemberContainerWidget containerWidget = new MemberContainerWidget(containerComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true)
				.applyTo(containerWidget.getComposite());
		containerTab.setControl(containerComposite);
		// by default select the profile tab
		tabfolder.setSelection(profileTab);
	}

}
