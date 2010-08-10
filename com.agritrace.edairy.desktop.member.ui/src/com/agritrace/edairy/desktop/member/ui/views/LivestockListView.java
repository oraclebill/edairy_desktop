package com.agritrace.edairy.desktop.member.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.ImageButton;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.DesktopBaseActivator;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.controls.LiveStockFilterWidget;

public class LivestockListView extends AbstractDirectoryView {
	
	
	public static final String CONTAINER_GROUP = "Containers";
	public static final int DEFAULT_LABEL_WIDTH = 110;
	public static final String FILTER_GROUP_FARM_LOOKUP = "Show conatiners :";
	public static final String FILTER_GROUP_MEMBER_LOOKUP = "Member Lookup :";
	public static final String FILTER_GROUP_TEXT = "Search for a Livestock";

	public static final String ID = LivestockListView.class.getName();
	
	public LivestockListView() {
	}

	@Override
	protected void createFilterConditions(Composite parent) {
		// group
		final Group filterGroup = UIControlsFactory.createGroup(parent, FILTER_GROUP_TEXT);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(filterGroup);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(filterGroup);

		final Label memberLabel = UIControlsFactory.createLabel(filterGroup, FILTER_GROUP_MEMBER_LOOKUP);
		final GridDataFactory labelFactory = GridDataFactory.swtDefaults().hint(DEFAULT_LABEL_WIDTH, -1).indent(18, 0);
		labelFactory.applyTo(memberLabel);
		// search text
		final Text searchText = UIControlsFactory.createText(filterGroup, SWT.SINGLE | SWT.BORDER,
				ViewWidgetId.FARM_LIST_MEMBER_LOOKUP_TXT);
		GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.FILL).hint(250, -1).grab(false, false).applyTo(searchText);

		final ImageButton lookupButton = UIControlsFactory.createImageButton(filterGroup, SWT.NULL,
				ViewWidgetId.FARM_LIST_SEARCH_BUTTON);
		final Image lookupIcon = Activator.getDefault().getImageRegistry().get(DesktopBaseActivator.MEMBER_SEARCH_ICON);
		lookupButton.setImage(lookupIcon);
		GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.FILL).grab(false, false).applyTo(lookupButton);

		final Composite filterPanel = UIControlsFactory.createComposite(filterGroup);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(3, 1).applyTo(filterPanel);
		final GridLayout gd = new GridLayout();
		gd.marginLeft = 0;
		gd.marginRight = 0;
		filterPanel.setLayout(gd);

		final LiveStockFilterWidget filter = new LiveStockFilterWidget(filterPanel,true);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(filter.getComposite());

	}

//	@Override
//	protected void createListGroup(Composite parent) {

//		final Group listGroup = UIControlsFactory.createGroup(parent, CONTAINER_GROUP);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(listGroup);
//		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).applyTo(listGroup);
//
//		final Composite tablePanel = UIControlsFactory.createComposite(listGroup, SWT.NULL);
//		tablePanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
//
//		final Table table = UIControlsFactory.createTable(tablePanel, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION,
//				ViewWidgetId.LIVESTOCK_TABLE);
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
//		column4.setText("Purpose");
//		final TableColumn column5 = new TableColumn(table, SWT.LEFT);
//		column5.setText("LiveStock Name");
//		final TableColumn column6 = new TableColumn(table, SWT.LEFT);
//		column6.setText("Species");
//		final TableColumn column7 = new TableColumn(table, SWT.LEFT);
//		column7.setText("Breed");
//		final TableColumn column8 = new TableColumn(table, SWT.LEFT);
//		column8.setText("Acquisition");
//		final TableColumn column9 = new TableColumn(table, SWT.LEFT);
//		column9.setText("Status");
//
//		final TableColumnLayout layout = new TableColumnLayout();
//		layout.setColumnData(column1, new ColumnWeightData(10));
//		layout.setColumnData(column2, new ColumnWeightData(15));
//		layout.setColumnData(column3, new ColumnWeightData(15));
//		layout.setColumnData(column4, new ColumnWeightData(10));
//		layout.setColumnData(column5, new ColumnWeightData(10));
//		layout.setColumnData(column6, new ColumnWeightData(10));
//		layout.setColumnData(column7, new ColumnWeightData(10));
//		layout.setColumnData(column8, new ColumnWeightData(10));
//		layout.setColumnData(column9, new ColumnWeightData(10));
//
//		tablePanel.setLayout(layout);
//
//		createButtonPanel(listGroup, ViewWidgetId.LIVESTOCK_VIEW, ViewWidgetId.LIVESTOCK_ADD);

//	}

}
