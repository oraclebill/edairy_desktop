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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.collection.ui.components.JournalHeaderComposite;
import com.agritrace.edairy.desktop.collection.ui.components.JournalHeaderComposite.ControlType;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.swtdesigner.ResourceManager;

public class ScaleDataImportView extends SubModuleView {
	public static final String ID = "edairy.scale.import.view";

	private static final String BIN_COLUMN_HEADER = "Bin";

	private static final String MILK_ENTRY_LIST_GROUP_TITLE = "Milk Collection Entries";

	private static final String CANCEL_LABEL = "Cancel Import";
	private static final String SAVE_LABEL = "Save Imported Data";

	public ScaleDataImportView() {
	}

	/**
	 * Milk collection entry group - defines: - milk collection entry table -
	 * list of collection entries. - total label - current total of all entries.
	 * 
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

		final TableColumn columnTime = new TableColumn(table, SWT.LEFT);
		final TableColumn columnMember = new TableColumn(table, SWT.LEFT);
		final TableColumn columnCans = new TableColumn(table, SWT.LEFT);
		final TableColumn columnQuantity = new TableColumn(table, SWT.LEFT);
		final TableColumn columnNPRColumn = new TableColumn(table, SWT.LEFT);
		final TableColumn columnSuspended = new TableColumn(table, SWT.LEFT);

		final TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(columnTime, new ColumnWeightData(10));
		layout.setColumnData(columnMember, new ColumnWeightData(20));
		layout.setColumnData(columnCans, new ColumnWeightData(20));
		layout.setColumnData(columnQuantity, new ColumnWeightData(20));
		layout.setColumnData(columnNPRColumn, new ColumnWeightData(15));
		layout.setColumnData(columnSuspended, new ColumnWeightData(15));
		tableComposite.setLayout(layout);

		final Label totalLabel = UIControlsFactory.createLabel(panel, "");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(totalLabel);
		addUIControl(totalLabel, ViewWidgetId.totalLabel);

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

		// final Control groupOne = createJournalBookGroup(parent);
		// gdf.applyTo(groupOne);
		//
		// final Control groupTwo = createMilkBookGroup(parent);
		// gdf.applyTo(groupTwo);

		final Control headerGroups = new JournalHeaderComposite(parent, SWT.NULL);
		addUIControl(headerGroups, "journal-header");
		gdf.applyTo(headerGroups);

		final Control groupFour = createMilkEntryGroup(parent);
		gdf.grab(true, true).applyTo(groupFour);

		final Composite buttonPanel = UIControlsFactory.createComposite(parent);
		buttonPanel.setLayout(new RowLayout());
		
		UIControlsFactory.createButton(buttonPanel, CANCEL_LABEL, ViewWidgetId.cancelButton);
		UIControlsFactory.createButton(buttonPanel, SAVE_LABEL, DialogConstants.BIND_ID_BUTTON_SAVE);

	}
}
