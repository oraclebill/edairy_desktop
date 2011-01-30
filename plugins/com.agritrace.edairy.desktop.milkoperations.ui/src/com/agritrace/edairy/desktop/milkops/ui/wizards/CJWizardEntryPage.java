package com.agritrace.edairy.desktop.milkops.ui.wizards;

import java.beans.Beans;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.milkops.ui.intake.ViewWidgetId;
import com.agritrace.edairy.desktop.milkops.ui.intake.collectionline.CollectionLineComposite;
import com.swtdesigner.ResourceManager;

public class CJWizardEntryPage extends WizardPage {

	private static final String JOURNAL_TOTAL_LABEL = "Driver Total:";
	private static final String MILK_BOOK_GROUP_TITLE = "Journal Page";
	private static final int MINIMUM_LABEL_WIDTH = 80;

	/**
	 * Create the wizard.
	 */
	public CJWizardEntryPage() {
		super("wizardPage");
		setTitle("Wizard Page title");
		setDescription("Wizard Page description");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		setControl(container);

		container.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		container.setLayout(new GridLayout(1, false));

		final GridDataFactory gdf = GridDataFactory.fillDefaults().grab(true, false);

		final Control headerGroups = createSubHeaderGroup(container);
		addUIControl(headerGroups, "journal-header");
		gdf.applyTo(headerGroups);

		// final Control groupThree = createMilkEntryInputGroup(parent);
		final Control groupThree = new CollectionLineComposite(container, SWT.NONE);
		addUIControl(groupThree, "journal-entry");
		gdf.applyTo(groupThree);

		final Control groupFour = createMilkEntryGroup(container);
		gdf.grab(true, true).applyTo(groupFour);

	}

	private Group createSubHeaderGroup(Composite parent) {
		final Group group = UIControlsFactory.createGroup(parent, MILK_BOOK_GROUP_TITLE,
				ViewWidgetId.milkGroup);
		GridLayoutFactory.fillDefaults().margins(2, 2).numColumns(4).applyTo(group);

		final Label journalLabel = UIControlsFactory.createLabel(group, "Reference No:");
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING)
				.hint(MINIMUM_LABEL_WIDTH, -1).applyTo(journalLabel);

		final Text journalText = UIControlsFactory.createText(group, SWT.BORDER);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(journalText);
		addUIControl(journalText, ViewWidgetId.journalText);
//		journalText.addTraverseListener(traverseListener);

		final Label journalTotalLabel = UIControlsFactory.createLabel(group,
				JOURNAL_TOTAL_LABEL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING)
				.hint(MINIMUM_LABEL_WIDTH, -1).applyTo(journalTotalLabel);

		final Text journalTotalText = UIControlsFactory.createTextDecimal(group);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(journalTotalText);
//		journalTotalText.addTraverseListener(traverseListener);
		addUIControl(journalTotalText, ViewWidgetId.journalTotalText);

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

	/**
	 * Milk collection entry group - defines:
	 *  - milk collection entry table - list of collection entries.
	 *  - total label - current total of all entries.
	 * @param parent
	 * @return
	 */
	private Composite createMilkEntryGroup(Composite parent) {

		final Group group = UIControlsFactory.createGroup(parent, "Collections Entries");
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
		columnBin.setText("Bin");
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

	private void addUIControl(Control control, String id) {

	}

}
