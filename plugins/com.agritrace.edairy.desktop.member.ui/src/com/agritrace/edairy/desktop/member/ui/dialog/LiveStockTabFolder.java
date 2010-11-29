package com.agritrace.edairy.desktop.member.ui.dialog;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

import com.agritrace.edairy.desktop.member.ui.controls.LivestockGeneralInfoPanel;
import com.agritrace.edairy.desktop.member.ui.controls.LiveStockIdentificationWidget;
import com.agritrace.edairy.desktop.member.ui.controls.LiveStockOtherWidget;
import com.agritrace.edairy.desktop.member.ui.controls.LiveStockRearingWidget;

public class LiveStockTabFolder extends Composite {

	public static enum TabItem {
		General, Identification, Other, Rearing
	}

	static class TabItemSet extends HashSet<TabItem> {
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		TabItemSet(TabItem[] tabs) {
			super();
			addAll(Arrays.asList(tabs));
		}
	};

	public static final Set<TabItem> ALL_TABS = new TabItemSet(TabItem.values());

	public static final String MEMBER_INFO_GROUP = "Animal Information";

	/**
	 * @wbp.parser.constructor
	 */
	public LiveStockTabFolder(Composite parent) {
		this(parent, ALL_TABS);
	}

	public LiveStockTabFolder(Composite parent, Set<TabItem> enabledTabs) {
		super(parent, SWT.NONE);
		
		final GridData detailsGD = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		detailsGD.minimumHeight = 200;
		setLayoutData(detailsGD);
		final GridLayout detaLayout = new GridLayout();
		detaLayout.horizontalSpacing = 0;
		detaLayout.verticalSpacing = 0;
		detaLayout.marginWidth = 0;
		detaLayout.marginHeight = 0;
		detaLayout.numColumns = 1;
		setLayout(detaLayout);

		final Group detailGroup = UIControlsFactory.createGroup(this, MEMBER_INFO_GROUP);
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
		if (enabledTabs.contains(TabItem.General)) {
			final CTabItem profileTab = new CTabItem(tabfolder, SWT.NULL);
			profileTab.setText("General");
			final Composite profileComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
			profileComposite.setLayout(new GridLayout(1, true));
			final LivestockGeneralInfoPanel profileWidget = new LivestockGeneralInfoPanel(profileComposite, SWT.NONE);
			profileWidget.setLayoutData(GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true)
					.create());
			profileTab.setControl(profileComposite);
		}

		// identification
		if (enabledTabs.contains(TabItem.Identification)) {
			final CTabItem identificationTab = new CTabItem(tabfolder, SWT.NULL);
			identificationTab.setText("Identification");
			final Composite accountComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
			accountComposite.setLayout(new GridLayout(1, true));
			final LiveStockIdentificationWidget identificationWidget = new LiveStockIdentificationWidget(
					accountComposite);
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true)
					.applyTo(identificationWidget.getComposite());
			identificationTab.setControl(accountComposite);
			identificationTab.setControl(accountComposite);
		}
		// Rearing
		if (enabledTabs.contains(TabItem.Rearing)) {
			final CTabItem rearingTab = new CTabItem(tabfolder, SWT.NULL);
			rearingTab.setText("Rearing Habits");
			final Composite rearingComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
			rearingComposite.setLayout(new GridLayout(1, true));
			final LiveStockRearingWidget rearingWidget = new LiveStockRearingWidget(rearingComposite);
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true)
					.applyTo(rearingWidget.getComposite());
			rearingTab.setControl(rearingComposite);
		}
		// other
		if (enabledTabs.contains(TabItem.Other)) {
			final CTabItem collectionTab = new CTabItem(tabfolder, SWT.NULL);
			collectionTab.setText("Other");
			final Composite collectionComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
			collectionComposite.setLayout(new GridLayout(1, true));
			final LiveStockOtherWidget otherWidget = new LiveStockOtherWidget(collectionComposite);
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true)
					.applyTo(otherWidget.getComposite());
			collectionTab.setControl(collectionComposite);
		}

		tabfolder.setSelection(0);
	}

}
