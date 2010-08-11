package com.agritrace.edairy.desktop.member.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.ImageButton;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.DesktopBaseActivator;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class ContainerListView extends AbstractDirectoryView {
	public static final String CONTAINER_GROUP = "Containers";

	public static final String FILTER_GROUP_FARM_LOOKUP = "Show conatiners :";
	public static final String FILTER_GROUP_MEMBER_LOOKUP = "Member Lookup :";
	public static final String FILTER_GROUP_TEXT = "Search for a container";

	public static final String ID = ContainerListView.class.getName();

	@Override
	protected void createFilterConditions(Composite parent) {
		// group
		final Group filterGroup = UIControlsFactory.createGroup(parent, FILTER_GROUP_TEXT);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(filterGroup);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(filterGroup);

		UIControlsFactory.createLabel(filterGroup, FILTER_GROUP_MEMBER_LOOKUP);
		// search text
		final Text searchText = UIControlsFactory.createText(filterGroup, SWT.SINGLE | SWT.BORDER,
				ViewWidgetId.FARM_LIST_MEMBER_LOOKUP_TXT);
		GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.FILL).hint(250, -1).grab(false, false).applyTo(searchText);

		final ImageButton lookupButton = UIControlsFactory.createImageButton(filterGroup, SWT.NULL,
				ViewWidgetId.FARM_LIST_SEARCH_BUTTON);
		final Image lookupIcon = Activator.getDefault().getImageRegistry().get(DesktopBaseActivator.MEMBER_SEARCH_ICON);
		lookupButton.setImage(lookupIcon);
		GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.FILL).grab(false, false).applyTo(lookupButton);

		UIControlsFactory.createLabel(filterGroup, FILTER_GROUP_FARM_LOOKUP);
		// farm combo
		final CCombo farmCombo = UIControlsFactory.createCCombo(filterGroup, ViewWidgetId.FARM_LIST_ROUTE_COMBO);
		GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.FILL).hint(235, -1).span(2, 1).grab(false, false)
				.applyTo(farmCombo);

		// search cancel button
//		final Composite searchPanel = UIControlsFactory.createComposite(filterGroup);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(3, 1).applyTo(searchPanel);
//		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(searchPanel);
//
//		final Button searchButton = UIControlsFactory.createButton(searchPanel, "Search",
//				ViewWidgetId.memberInfo_searchButton);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(false, false).applyTo(searchButton);
//
//		final Button cancelButton = UIControlsFactory.createButton(searchPanel, "Clear", ViewWidgetId.cancelButton);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(false, false).applyTo(cancelButton);

	}
//
//	@Override
//	protected void createListGroup(Composite parent) {
//
//		final Group listGroup = UIControlsFactory.createGroup(parent, CONTAINER_GROUP);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(listGroup);
//		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).applyTo(listGroup);
//
//		final Composite tablePanel = UIControlsFactory.createComposite(listGroup, SWT.NULL);
//		tablePanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
//
//		final Table table = UIControlsFactory.createTable(tablePanel, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION,
//				ViewWidgetId.CONTAINER_TABLE);
//		table.setLinesVisible(true);
//		table.setHeaderVisible(true);
//
//		final TableColumn column1 = new TableColumn(table, SWT.LEFT);
//		column1.setText("Member Id");
//		final TableColumn column2 = new TableColumn(table, SWT.LEFT);
//		column2.setText("Member Name");
//		final TableColumn column3 = new TableColumn(table, SWT.LEFT);
//		column3.setText("Farm Name");
//		final TableColumn column4 = new TableColumn(table, SWT.LEFT);
//		column4.setText("Container ID");
//		final TableColumn column5 = new TableColumn(table, SWT.LEFT);
//		column5.setText("Container Type");
//		final TableColumn column6 = new TableColumn(table, SWT.LEFT);
//		column6.setText("Unit of Measure");
//		final TableColumn column7 = new TableColumn(table, SWT.LEFT);
//		column7.setText("Capacity");
//
//		final TableColumnLayout layout = new TableColumnLayout();
//		layout.setColumnData(column1, new ColumnWeightData(10));
//		layout.setColumnData(column2, new ColumnWeightData(15));
//		layout.setColumnData(column3, new ColumnWeightData(15));
//		layout.setColumnData(column4, new ColumnWeightData(15));
//		layout.setColumnData(column5, new ColumnWeightData(15));
//		layout.setColumnData(column6, new ColumnWeightData(15));
//		layout.setColumnData(column7, new ColumnWeightData(15));
//
//		tablePanel.setLayout(layout);
//
//		createButtonPanel(listGroup, ViewWidgetId.CONTAINER_VIEW, ViewWidgetId.CONTAINER_ADD);
//
//	}

}
