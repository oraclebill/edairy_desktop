package com.agritrace.edairy.desktop.common.ui.controls.location;

import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.ui.controls.CompositePanel;

public class LocationTabFolder extends CompositePanel {

	final CTabFolder tabs;

	public LocationTabFolder(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout());
		setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		tabs = new CTabFolder(this, SWT.None);
		final Color startColor = LnfManager.getLnf().getColor(
				LnfKeyConstants.EMBEDDED_TITLEBAR_ACTIVE_BACKGROUND_START_COLOR);
		final Color endColor = LnfManager.getLnf().getColor(
				LnfKeyConstants.EMBEDDED_TITLEBAR_ACTIVE_BACKGROUND_END_COLOR);
		tabs.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		tabs.setSelectionBackground(new Color[] { startColor, endColor }, new int[] { 50 }, true);

		final CTabItem addressTab = new CTabItem(tabs, SWT.NONE);
		addressTab.setText("Address");
		final Composite tab = new AddressPanel(tabs, SWT.NONE);
		addressTab.setControl(tab);

		final CTabItem directionsTab = new CTabItem(tabs, SWT.NONE);
		directionsTab.setText("Directions");
		final Composite tab2 = new DirectionsPanel(tabs, SWT.NONE);
		directionsTab.setControl(tab2);

		final CTabItem mapTab = new CTabItem(tabs, SWT.NONE);
		mapTab.setText("Map");
		final Composite tab3 = new MapPanel(tabs, SWT.NONE);
		mapTab.setControl(tab3);
		//by default select address tab
		tabs.setSelection(addressTab);
	}

	public CTabFolder getTabFolder() {
		return tabs;
	}
}