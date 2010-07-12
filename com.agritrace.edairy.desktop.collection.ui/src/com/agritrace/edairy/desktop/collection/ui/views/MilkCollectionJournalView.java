package com.agritrace.edairy.desktop.collection.ui.views;

import java.beans.Beans;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.collection.ui.components.CollectionsEntryPanel;
import com.swtdesigner.ResourceManager;

public class MilkCollectionJournalView extends SubModuleView implements TraverseListener {
	public static final String BIN_COLUMN_HEADER = "Bin";

	public static final String BIN_LABEL = "Bin :";

	public static final String CAN_ID_LABEL = "CAN :";

	public static final String DATE_LABEL = "Date:";

	public static final String DRIVER_LABEL = "Driver:";

	public static final String ID = "edairy.collection.entry.view";

	public static final String JOURNAL_LABEL = "Page Number:";

	public static final String JOURNAL_TOTAL_LABEL = "Driver Total:";

	public static final String LINE_COLUMN_HEADER = "Line";

	public static final String MEMBER_COLUMN_HEADER = "Member";

	public static final String MEMBER_ID_LABEL = "Member ID :";

	public static final String MILK_BOOK_GROUP_TITLE = "Journal Page";

	public static final String MILK_ENTRY_GROUP_TITLE = "Add New Entry";

	public static final String MILK_ENTRY_LIST_GROUP_TITLE = "Milk Collection Entries";

	public static final String MILK_JOURNAL_BOOK_GROUP_TITLE = "Journal Book / Collection Details";

	public static final int MINIMUM_LABEL_WIDTH = 80;

	public static final String NPR_COLUMN_HEADER = "NPR Missing";

	public static final String QUANTITY_COLUMN_HEADER = "Quantity";

	public static final String QUANTITY_LABEL = "Quantity :";

	public static final String REJECTED_COLUMN_HEADER = "Rejected";

	public static final String ROUTE_LABEL = "Route:";

	public static final String SAVE_LABEL = "Save and Create New Journal";

	public static final String SECTION_LABEL = "Session:";

	public static final String VEHICLE_LABEL = "Truck:";

	public MilkCollectionJournalView() {
	}

	@Override
	public void keyTraversed(TraverseEvent e) {
		if (e.detail == SWT.TRAVERSE_RETURN) {
			e.doit = true;
			e.detail = SWT.TRAVERSE_TAB_NEXT;
		}
	}

	private Composite createButtonComposite(Composite group) {
		final Composite buttonComposite = UIControlsFactory.createComposite(group);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(buttonComposite);

		final Button modifyButton = UIControlsFactory
				.createButton(buttonComposite, "Modify", ViewWidgetId.modifyButton);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).applyTo(modifyButton);

		final Button deleteButton = UIControlsFactory
				.createButton(buttonComposite, "Delete", ViewWidgetId.deleteButton);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).applyTo(deleteButton);

		final Button clearButton = UIControlsFactory.createButton(buttonComposite, "Clear", ViewWidgetId.clearButton);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).applyTo(clearButton);

		return buttonComposite;
	}

	/**
	 * Milk collection entry group - defines:
	 *  - milk collection entry table - list of collection entries.
	 *  - total label - current total of all entries.
	 * @param parent
	 * @return
	 */
	private Composite createMilkEntryGroup(Composite parent) {

		final Group group = UIControlsFactory.createGroup(parent, MILK_ENTRY_LIST_GROUP_TITLE);
		GridLayoutFactory.fillDefaults().margins(2, 2).numColumns(2).applyTo(group);

		final Composite panel = UIControlsFactory.createComposite(group);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(panel);
		GridLayoutFactory.fillDefaults().margins(2, 2).numColumns(1).applyTo(panel);

		final Composite tableComposite = new Composite(panel, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(tableComposite);

		final Table table = UIControlsFactory.createTable(tableComposite, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION,
				ViewWidgetId.milkEntryTable);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		final TableColumn columnLine = new TableColumn(table, SWT.LEFT);
		// columnLine.setText(LINE_COLUMN_HEADER);
		final TableColumn columnMember = new TableColumn(table, SWT.LEFT);
		// columnMember.setText(MEMBER_COLUMN_HEADER);
		final TableColumn columnBin = new TableColumn(table, SWT.LEFT);
		columnBin.setText(BIN_COLUMN_HEADER);
		final TableColumn columnQuantity = new TableColumn(table, SWT.LEFT);
		// columnQuantity.setText(QUANTITY_COLUMN_HEADER);
		final TableColumn columnNPRColumn = new TableColumn(table, SWT.LEFT);
		// columnNPRColumn.setText(NPR_COLUMN_HEADER);
		final TableColumn columnRejected = new TableColumn(table, SWT.LEFT);
		// columnRejected.setText(REJECTED_COLUMN_HEADER);

		final TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(columnLine, new ColumnWeightData(10));
		layout.setColumnData(columnMember, new ColumnWeightData(20));
		layout.setColumnData(columnBin, new ColumnWeightData(20));
		layout.setColumnData(columnQuantity, new ColumnWeightData(20));
		layout.setColumnData(columnNPRColumn, new ColumnWeightData(15));
		layout.setColumnData(columnRejected, new ColumnWeightData(15));
		tableComposite.setLayout(layout);

		final Label totalLabel = UIControlsFactory.createLabel(panel, "");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(totalLabel);
		addUIControl(totalLabel, ViewWidgetId.totalLabel);

		final Composite buttonComposite = createButtonComposite(panel);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).applyTo(buttonComposite);

		final Label imageLabel = UIControlsFactory.createLabel(group, "");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.TOP).applyTo(imageLabel);
		if (!Beans.isDesignTime()) {
			imageLabel.setImage(ResourceManager.getPluginImage("com.agritrace.edairy.demo.riena",
					"resources/farmerheadshot.png"));
		}
		addUIControl(imageLabel, ViewWidgetId.photoLabel);

		return group;
	}

	@Override
	protected void basicCreatePartControl(Composite parent) {
		parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		parent.setLayout(new GridLayout(1, false));

		final GridDataFactory gdf = GridDataFactory.fillDefaults().grab(true, false);

//		final Control groupOne = createJournalBookGroup(parent);
//		gdf.applyTo(groupOne);
//
//		final Control groupTwo = createMilkBookGroup(parent);
//		gdf.applyTo(groupTwo);

		final Control headerGroups = new JournalHeaderComposite(parent, SWT.NULL);
		addUIControl(headerGroups, "journal-header");
		gdf.applyTo(headerGroups);

		// final Control groupThree = createMilkEntryInputGroup(parent);
		final Control groupThree = new CollectionsEntryPanel(parent, SWT.NONE);
		gdf.applyTo(groupThree);

		final Control groupFour = createMilkEntryGroup(parent);
		gdf.grab(true, true).applyTo(groupFour);

		final Button saveButton = UIControlsFactory.createButton(parent, SAVE_LABEL, ViewWidgetId.saveButton);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).applyTo(saveButton);

	}
}
