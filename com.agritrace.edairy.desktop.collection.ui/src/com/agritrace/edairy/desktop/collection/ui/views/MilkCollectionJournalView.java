package com.agritrace.edairy.desktop.collection.ui.views;

import java.util.Date;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.collection.ui.components.CollectionsEntryPanel;
import com.agritrace.edairy.desktop.common.ui.ImageRegistry;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.dialogs.CalendarSelectionDialog;
import com.agritrace.edairy.desktop.internal.collection.ui.Activator;
import com.swtdesigner.ResourceManager;

public class MilkCollectionJournalView extends SubModuleView implements TraverseListener {
	public MilkCollectionJournalView() {
	}

	public static final String ID = "edairy.collection.entry.view";

	public static final String MILK_JOURNAL_BOOK_GROUP_TITLE = "Journal Book / Collection Details";

	public static final String MILK_BOOK_GROUP_TITLE = "Journal Page";

	public static final String MILK_ENTRY_GROUP_TITLE = "Add New Entry";

	public static final String MILK_ENTRY_LIST_GROUP_TITLE = "Milk Collection Entries";

	public static final String DATE_LABEL = "Date:";

	public static final String ROUTE_LABEL = "Route:";

	public static final String SECTION_LABEL = "Session:";

	public static final String VEHICLE_LABEL = "Truck:";

	public static final String DRIVER_LABEL = "Driver:";

	public static final String JOURNAL_LABEL = "Page Number:";

	public static final String JOURNAL_TOTAL_LABEL = "Page Total:";

	public static final String BIN_LABEL = "Bin :";

	public static final String LINE_COLUMN_HEADER = "Line";

	public static final String MEMBER_COLUMN_HEADER = "Member";

	public static final String BIN_COLUMN_HEADER = "Bin";

	public static final String QUANTITY_COLUMN_HEADER = "Quantity";

	public static final String NPR_COLUMN_HEADER = "NPR Missing";

	public static final String REJECTED_COLUMN_HEADER = "Rejected";

	public static final String MEMBER_ID_LABEL = "Member ID :";

	public static final String CAN_ID_LABEL = "CAN :";

	public static final String QUANTITY_LABEL = "Quantity :";

	public static final String SAVE_LABEL = "Save and Create New Journal";

	private DateTime dateText;
	private Button calendarButton;

	public static final int MINIMUM_LABEL_WIDTH = 70;

	@Override
	protected void basicCreatePartControl(Composite parent) {
		parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		parent.setLayout(new GridLayout(1, false));

		final GridDataFactory gdf = GridDataFactory.fillDefaults().grab(true, false);

		final Control groupOne = createJournalBookGroup(parent);
		gdf.applyTo(groupOne);

		final Control groupTwo = createMilkBookGroup(parent);
		gdf.applyTo(groupTwo);

//		final Control groupThree = createMilkEntryInputGroup(parent);
		final Control groupThree = new CollectionsEntryPanel(parent, SWT.NONE);		
		GridDataFactory.fillDefaults().grab(true, false).applyTo(groupThree);

		final Control groupFour = createMilkEntryGroup(parent);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(groupFour);

		final Button saveButton = UIControlsFactory.createButton(parent, SAVE_LABEL, ViewWidgetId.saveButton);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).applyTo(saveButton);

	}

	private Group createJournalBookGroup(Composite parent) {
		final Group group = UIControlsFactory.createGroup(parent, MILK_JOURNAL_BOOK_GROUP_TITLE,
				ViewWidgetId.milkJournalGroup);
		GridLayoutFactory.fillDefaults().margins(2, 2).numColumns(4).applyTo(group);

		final Label dateLabel = UIControlsFactory.createLabel(group, DATE_LABEL);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.FILL).hint(MINIMUM_LABEL_WIDTH, -1).applyTo(dateLabel);

		final Composite dateComposite = UIControlsFactory.createComposite(group);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(dateComposite);
		GridLayoutFactory.fillDefaults().margins(0, 0).numColumns(2).applyTo(dateComposite);

		dateText = UIControlsFactory.createDate(dateComposite,SWT.DATE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(dateText);
		addUIControl(dateText, ViewWidgetId.calendarDate);
		dateText.addTraverseListener(this);

		calendarButton = new Button(dateComposite, SWT.PUSH);
		// calendarButton = UIControlsFactory.createButton(group);
		final Image calendar = Activator.getImage(ImageRegistry.calendar);

		// Image calendarButtonImage = new Image(parent.getDisplay(),
		// calendar.getImageData().scaledTo(16, 16));
		calendarButton.setImage(calendar);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.BEGINNING).hint(17, 16).applyTo(calendarButton);
		// addUIControl(calendarButton,ViewWidgetId.calendarButton);

//		calendarButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				final CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
//				calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
//						dateText.getText());
//
//				if (calDialog.open() == AbstractWindowController.OK) {
//					final Date selectedDate = (Date) calDialog.getController().getContext(
//							SimpleFormattedDateBean.DATE_PROR);
//					final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
//					bean.setDate(selectedDate);
//					dateText.setText(bean.getFormattedDate());
//				}
//			}
//		});

		final Label padComposite = UIControlsFactory.createLabel(group, "");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).span(2, 1).applyTo(padComposite);

		final Label routeLabel = UIControlsFactory.createLabel(group, ROUTE_LABEL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH, -1).applyTo(routeLabel);

		// Combo combo = new Combo(group, SWT.BORDER|SWT.DROP_DOWN);
		final Combo combo = UIControlsFactory.createCombo(group);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(combo);
		addUIControl(combo, ViewWidgetId.routeCombo);
		combo.addTraverseListener(this);

		final Label sectionLabel = UIControlsFactory.createLabel(group, SECTION_LABEL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH, -1)
		.applyTo(sectionLabel);

		final Combo combo2 = UIControlsFactory.createCombo(group);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(combo2);
		addUIControl(combo2, ViewWidgetId.sessionCombo);
		combo2.addTraverseListener(this);

		// Composite pane = UIControlsFactory.createComposite(group);
		// GridLayoutFactory.fillDefaults().margins(2,
		// 2).numColumns(4).applyTo(pane);
		// GridDataFactory.fillDefaults().grab(true,false).span(7,
		// 1).applyTo(pane);

		final Label vehicleLabel = UIControlsFactory.createLabel(group, VEHICLE_LABEL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH, -1)
		.applyTo(vehicleLabel);

		final Combo combo3 = UIControlsFactory.createCombo(group);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(combo3);
		combo3.addTraverseListener(this);

		addUIControl(combo3, ViewWidgetId.vehicleCombo);

		final Label driverLabel = UIControlsFactory.createLabel(group, DRIVER_LABEL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH, -1).applyTo(driverLabel);

		final Combo combo4 = UIControlsFactory.createCombo(group);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(combo4);
		addUIControl(combo4, ViewWidgetId.driverCombo);
		combo4.addTraverseListener(this);

		return group;
	}

	private Group createMilkBookGroup(Composite parent) {
		final Group group = UIControlsFactory.createGroup(parent, MILK_BOOK_GROUP_TITLE, ViewWidgetId.milkGroup);
		GridLayoutFactory.fillDefaults().margins(2, 2).numColumns(4).applyTo(group);

		final Label journalLabel = UIControlsFactory.createLabel(group, JOURNAL_LABEL);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH, -1)
		.applyTo(journalLabel);

		final Text journalText = UIControlsFactory.createText(group, SWT.BORDER);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(journalText);
		addUIControl(journalText, ViewWidgetId.journalText);
		journalText.addTraverseListener(this);

		final Label journalTotalLabel = UIControlsFactory.createLabel(group, JOURNAL_TOTAL_LABEL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH, -1)
		.applyTo(journalTotalLabel);

		final Text journalTotalText = UIControlsFactory.createTextDecimal(group);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(journalTotalText);
		journalTotalText.addTraverseListener(this);
		addUIControl(journalTotalText, ViewWidgetId.journalTotalText);

		return group;
	}

//	private Composite createMilkEntryInputGroup(Composite parent) {
//
//		final Group group = UIControlsFactory.createGroup(parent, MILK_ENTRY_GROUP_TITLE);
//		GridLayoutFactory.fillDefaults().margins(2, 2).numColumns(2).applyTo(group);
//
//		final Group panel = UIControlsFactory.createGroup(group, "");
//		GridDataFactory.fillDefaults().grab(true, true).span(1, 2).applyTo(panel);
//		GridLayoutFactory.fillDefaults().margins(2, 2).numColumns(4).applyTo(panel);
//
//		final Label binLabel = UIControlsFactory.createLabel(panel, BIN_LABEL);
//		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(MINIMUM_LABEL_WIDTH, -1)
//		.applyTo(binLabel);
//
//		final Combo binList = UIControlsFactory.createCombo(panel, ViewWidgetId.binCombo);
//		GridDataFactory.fillDefaults().grab(true, false).applyTo(binList);
//		binList.addTraverseListener(this);
//
//		final Label memberLabel = UIControlsFactory.createLabel(panel, MEMBER_ID_LABEL);
//		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(memberLabel);
//
//		final Text memberText = UIControlsFactory.createText(panel, SWT.BORDER);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(memberText);
//		addUIControl(memberText, ViewWidgetId.memberIdText);
//		memberText.addTraverseListener(this);
//
//		final Label canLabel = UIControlsFactory.createLabel(panel, CAN_ID_LABEL);
//		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(canLabel);
//
//		final Text canText = UIControlsFactory.createText(panel, SWT.BORDER);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(canText);
//		addUIControl(canText, ViewWidgetId.canIdText);
//		canText.addTraverseListener(this);
//
//		final Label quantityLabel = UIControlsFactory.createLabel(panel, QUANTITY_LABEL);
//		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(quantityLabel);
//
//		final Text quantityText = UIControlsFactory.createTextDecimal(panel);
//		GridDataFactory.fillDefaults().grab(true, false).applyTo(quantityText);
//		addUIControl(quantityText, ViewWidgetId.quantityText);
//		quantityText.addTraverseListener(this);
//
//		final Composite buttonComposite = UIControlsFactory.createComposite(panel);
//		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(true, false).span(4, 1).applyTo(buttonComposite);
//		GridLayoutFactory.fillDefaults().margins(0, 0).numColumns(2).applyTo(buttonComposite);
//
//		final Button nprMissingButton = UIControlsFactory.createButtonCheck(buttonComposite, NPR_COLUMN_HEADER,
//				ViewWidgetId.nprMissingCombo);
//		GridDataFactory.fillDefaults().align(SWT.END, SWT.FILL).applyTo(nprMissingButton);
//		nprMissingButton.addTraverseListener(this);
//
//		final Button rejectedButton = UIControlsFactory.createButtonCheck(buttonComposite, REJECTED_COLUMN_HEADER,
//				ViewWidgetId.rejectedCombo);
//		GridDataFactory.fillDefaults().align(SWT.END, SWT.FILL).applyTo(rejectedButton);
//		rejectedButton.addTraverseListener(this);
//
//		final Button addButton = UIControlsFactory.createButton(group, "Add", ViewWidgetId.addButton);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BOTTOM).hint(50, SWT.DEFAULT).applyTo(addButton);
//
//		final Button clearButton = UIControlsFactory.createButton(group, "Clear", ViewWidgetId.entryInputClear);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BOTTOM).hint(50, SWT.DEFAULT).applyTo(clearButton);
//
//		return group;
//
//	}

	//
	// private Group createMilkEntryGroup(Composite parent){
	//
	// }

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
		imageLabel.setImage(ResourceManager.getPluginImage("com.agritrace.edairy.demo.riena",
		"resources/farmerheadshot.png"));
		addUIControl(imageLabel, ViewWidgetId.photoLabel);

		return group;
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

	@Override
	public void keyTraversed(TraverseEvent e) {
		if (e.detail == SWT.TRAVERSE_RETURN) {
			e.doit = true;
			e.detail = SWT.TRAVERSE_TAB_NEXT;
		}
	}
}
