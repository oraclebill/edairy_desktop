package com.agritrace.edairy.desktop.member.ui.dialog;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
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

import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.ContactMethodsGroup;
import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.IContactMethodsGroupRidget;
import com.agritrace.edairy.desktop.common.ui.controls.location.LocationTabFolder;
import com.agritrace.edairy.desktop.member.ui.controls.MemberAccountWidget2;
import com.agritrace.edairy.desktop.member.ui.controls.MemberCollectionRecordsWidget;
import com.agritrace.edairy.desktop.member.ui.controls.MemberFarmWidget;
import com.agritrace.edairy.desktop.member.ui.controls.MemberProfileWidget;
import com.agritrace.edairy.desktop.member.ui.controls.MemberTransactionWidget;

public class MembershipTabFolder {

// public static enum TabItem {
// AccountSummary, Collections, Containers, Farm, Livestock, Profile, Transactions
// }
	public static enum TabItem {
		AccountSummary, Collections, Farm, Profile, Address, Transactions
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
	public static final String MEMBER_INFO_GROUP = "Members Information";

	public static final Set<TabItem> NEW_MEMBER_TABS = new TabItemSet(new TabItem[] { TabItem.Profile, TabItem.Address });

	private Composite tabComposite;

	public MembershipTabFolder(Composite parent) {
		initGUI(parent, ALL_TABS);
	}

	public MembershipTabFolder(Composite parent, Set<TabItem> enabledTabs) {
		initGUI(parent, enabledTabs);
	}

	public Composite getTabComposite() {
		return tabComposite;
	}

	private void initGUI(Composite parent, Set<TabItem> enabledTabs) {
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
		if (enabledTabs.contains(TabItem.Profile)) {
			final CTabItem profileTab = new CTabItem(tabfolder, SWT.NULL);
			profileTab.setText("Profile");
			final Composite profileComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
			profileComposite.setLayout(new GridLayout(1, true));
			final MemberProfileWidget profileWidget = new MemberProfileWidget(profileComposite, SWT.NONE);
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(profileWidget);
			profileTab.setControl(profileComposite);
		}

		// address tab
		if (enabledTabs.contains(TabItem.Address)) {
			final CTabItem profileTab = new CTabItem(tabfolder, SWT.NULL);
			profileTab.setText("Contact Info");
	
			final LocationTabFolder addressWidget = new LocationTabFolder(tabfolder, SWT.NONE);
			addressWidget.setLayoutData(GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).create());
			
			CTabFolder addressTabFolder = addressWidget.getTabFolder();
	
			CTabItem contactsTab = new CTabItem(addressTabFolder, SWT.NONE);
			contactsTab.setText("Contacts");
			ContactMethodsGroup contacts = new ContactMethodsGroup(addressTabFolder);
			contactsTab.setControl(contacts);
	
			SWTBindingPropertyLocator.getInstance().setBindingProperty(contacts, IContactMethodsGroupRidget.WIDGET_ID);
			profileTab.setControl(addressWidget);
		}

		// account summary
		if (enabledTabs.contains(TabItem.AccountSummary)) {
			final CTabItem accountTab = new CTabItem(tabfolder, SWT.NULL);
			accountTab.setText("Account Summary");
			final Composite accountComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
			accountComposite.setLayout(new GridLayout(1, true));
			final MemberAccountWidget2 accountWidget = new MemberAccountWidget2(accountComposite, SWT.NULL);
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(accountWidget);
			accountTab.setControl(accountComposite);
			accountTab.setControl(accountComposite);
		}

		if (enabledTabs.contains(TabItem.Transactions)) {
			final CTabItem transactionTab = new CTabItem(tabfolder, SWT.NULL);
			transactionTab.setText("Transactions");
			final Composite transComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
			transComposite.setLayout(new GridLayout(1, true));
			final MemberTransactionWidget transWidget = new MemberTransactionWidget(transComposite);
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true)
					.applyTo(transWidget.getComposite());
			transactionTab.setControl(transComposite);
		}
		if (enabledTabs.contains(TabItem.Collections)) {
			final CTabItem collectionTab = new CTabItem(tabfolder, SWT.NULL);
			collectionTab.setText("Collection Records");
			final Composite collectionComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
			collectionComposite.setLayout(new GridLayout(1, true));
			final MemberCollectionRecordsWidget collectionWidget = new MemberCollectionRecordsWidget(
					collectionComposite);
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true)
					.applyTo(collectionWidget.getComposite());
			collectionTab.setControl(collectionComposite);
		}
		if (enabledTabs.contains(TabItem.Farm)) {
			final CTabItem farmTab = new CTabItem(tabfolder, SWT.NULL);
			farmTab.setText("Farm");
			final Composite farmComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
			farmComposite.setLayout(new GridLayout(1, true));
			final MemberFarmWidget farmWidget = new MemberFarmWidget(farmComposite);
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(farmWidget.getComposite());
			farmTab.setControl(farmComposite);
		}
// if (enabledTabs.contains(TabItem.Livestock)) {
// final CTabItem livestockTab = new CTabItem(tabfolder, SWT.NULL);
// livestockTab.setText("Livestock");
// final Composite livestockComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
// livestockComposite.setLayout(new GridLayout(1, true));
// final MemberLiveStockWidget liveStockWidget = new MemberLiveStockWidget(livestockComposite);
// GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true)
// .applyTo(liveStockWidget.getComposite());
// livestockTab.setControl(livestockComposite);
// }
// if (enabledTabs.contains(TabItem.Containers)) {
// final CTabItem containerTab = new CTabItem(tabfolder, SWT.NULL);
// containerTab.setText("Containers");
// final Composite containerComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
// containerComposite.setLayout(new GridLayout(1, false));
// final MemberContainerWidget containerWidget = new MemberContainerWidget(containerComposite);
// GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true)
// .applyTo(containerWidget.getComposite());
// containerTab.setControl(containerComposite);
// }
		tabfolder.setSelection(0);
	}

}
