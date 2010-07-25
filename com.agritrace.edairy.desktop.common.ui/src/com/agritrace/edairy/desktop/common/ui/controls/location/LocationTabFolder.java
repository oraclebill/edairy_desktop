package com.agritrace.edairy.desktop.common.ui.controls.location;

import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import com.agritrace.edairy.desktop.common.ui.controls.CompositePanel;

public class LocationTabFolder extends CompositePanel {

	final TabFolder tabs;

	public LocationTabFolder(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout());
		setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		
		tabs = new TabFolder(this, SWT.None);

		final TabItem addressTab = new TabItem(tabs, SWT.NONE);
		addressTab.setText("Address");
		final Composite tab = new AddressPanel(tabs, SWT.NONE);
		addressTab.setControl(tab);

		final TabItem directionsTab = new TabItem(tabs, SWT.NONE);
		directionsTab.setText("Directions");
		final Composite tab2 = new DirectionsPanel(tabs, SWT.NONE);
		directionsTab.setControl(tab2);

		final TabItem mapTab = new TabItem(tabs, SWT.NONE);
		mapTab.setText("Map");
		final Composite tab3 = new MapPanel(tabs, SWT.NONE);
		mapTab.setControl(tab3);
	}

	public TabFolder getTabFolder() {
		return tabs;
	}
}