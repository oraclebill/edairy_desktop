package com.agritrace.edairy.desktop.collection.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.swt.SwtRidgetFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.collection.ui.components.collectionline.CollectionLineComposite;
import com.agritrace.edairy.desktop.collection.ui.components.journalheader.JournalHeaderComposite;
import com.agritrace.edairy.desktop.collection.ui.controllers.BulkCollectionsEntryDialogController;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.ui.dialogs.BaseDialogView;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 *
 * @author bill jones
 *
 */
public class BulkCollectionsEntryDialog extends BaseDialogView {

	/**
	 *
	 * @author bill jones
	 *
	 */
	private static final class JournalEntryTestAction implements IActionListener {

		private JournalEntryTestAction(Shell shell) {
			this(shell, createCollectionJournal());
		}

		private JournalEntryTestAction(Shell shell, CollectionGroup page) {
		}

		private static CollectionGroup createCollectionJournal() {
			/*
			Dairy dairy = RepositoryFactory.getDairyRepository().getLocalDairy();
			CollectionGroup journal = DairyFactory.eINSTANCE.createCollectionGroup();

			journal.setJournalDate(new Date());
			// journal.setSession(Session.EARLY_MORNING);
			// journal.setRoute(dairy.getRoutes().get(0));
			journal.setDriver(dairy.getEmployees().get(0));

			journal.setReferenceNumber("r001");
//			journal.setDriverTotal(new BigDecimal("10"));

			return journal;
			*/
			return null;
		}

		@Override
		public void callback() {
			/*
			 // TODO: Do something about it
			BulkCollectionsEntryDialog dialog = new BulkCollectionsEntryDialog(shell);

			dialog.getController().setContext(BulkCollectionsEntryDialogController.CONTEXT_JOURNAL_PAGE,
					createCollectionJournal());
			dialog.getController().setContext(BulkCollectionsEntryDialogController.CONTEXT_PERSISTENCE_DELEGATE,
					new DummyJournalPersister(dialog.getController()));

			if (Window.OK == dialog.open()) {
				System.out.println("OK pressed"); //$NON-NLS-1$
			} else {
				System.out.println("CANCEL pressed"); //$NON-NLS-1$
			}
			*/
		}
	}

	class CollectionsTraversalListener implements TraverseListener {
		@Override
		public void keyTraversed(TraverseEvent e) {
			if (e.detail == SWT.TRAVERSE_RETURN) {
				e.doit = true;
				e.detail = SWT.TRAVERSE_TAB_NEXT;
			}
		}
	}

	private static final String BIN_COLUMN_HEADER = "Bin";
	private static final String MILK_ENTRY_LIST_GROUP_TITLE = "Milk Collection Entries";

	/**
	 * Create the dialog.
	 *
	 * @param parentShell
	 * @param testJournalPersister
	 */
	@Inject
	public BulkCollectionsEntryDialog(@Named("current") Shell parentShell, BulkCollectionsEntryDialogController controller) {
		super(parentShell, controller);
	}

	@Override
	protected boolean canHandleShellCloseEvent() {
		boolean ret = true;
		try {
			ret = MessageDialog.openConfirm(getShell(), "Confirm Cancel", "Are you sure you want to close this window without saving?");
		}
		catch(final Throwable t) {
			t.printStackTrace();
		}
		return ret;
	}

	@Override
	protected void buildWorkArea(Composite parent) {
		final GridDataFactory gdf = GridDataFactory.fillDefaults().grab(true, false);
		final Control headerGroups = new JournalHeaderComposite(parent, SWT.NULL);
		addUIControl(headerGroups, "journal-header");
		gdf.applyTo(headerGroups);

		final Control groupThree = new CollectionLineComposite(parent, SWT.NONE);
		addUIControl(groupThree, "journal-entry");
		gdf.applyTo(groupThree);

		final Control groupFour = createMilkEntryGroup(parent);
		gdf.grab(true, true).applyTo(groupFour);
	}

//	@Override
//	protected Control buildView(Composite parent) {
//		final GridDataFactory gdf = GridDataFactory.fillDefaults().grab(true, false);
//
//		Composite composite = UIControlsFactory.createComposite(parent);
//		GridLayout layout = new GridLayout();
//		layout.marginHeight = 10;
//		layout.marginWidth = 10;
//
//		composite.setLayout(layout);
//
//		final Control headerGroups = new JournalHeaderComposite(parent, SWT.NULL, ControlType.TEXT);
//		addUIControl(headerGroups, "journal-header");
//		gdf.applyTo(headerGroups);
//
//		final Control groupThree = new CollectionLineComposite(parent, SWT.NONE);
//		addUIControl(groupThree, "journal-entry");
//		gdf.applyTo(groupThree);
//
//		final Control groupFour = createMilkEntryGroup(parent);
//		gdf.grab(true, true).applyTo(groupFour);
//
//		final Button saveButton = UIControlsFactory.createButton(parent, SAVE_LABEL, ViewWidgetId.saveButton);
//		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).applyTo(saveButton);
//
//		final Button closeButton = UIControlsFactory.createButton(parent, CLOSE_LABEL, ViewWidgetId.closeButton);
//		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).applyTo(saveButton);
//
//		return composite;
//	}

	private Composite createButtonComposite(Composite group) {
		final Composite buttonComposite = UIControlsFactory.createComposite(group);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(buttonComposite);

		final Button modifyButton = UIControlsFactory
				.createButton(buttonComposite, "Modify", ViewWidgetId.modifyButton);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).applyTo(modifyButton);

		final Button deleteButton = UIControlsFactory
				.createButton(buttonComposite, "Delete", ViewWidgetId.deleteButton);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).applyTo(deleteButton);

		final Button clearButton = UIControlsFactory.createButton(buttonComposite, "Delete All", ViewWidgetId.clearButton);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).applyTo(clearButton);

		return buttonComposite;
	}

	/**
	 * Milk collection entry group - defines: - milk collection entry table - list of collection entries. - total label
	 * - current total of all entries.
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
		GridDataFactory.fillDefaults().grab(true, true).hint(-1, 300).applyTo(tableComposite);

		final Table table = UIControlsFactory.createTable(tableComposite, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION,
				ViewWidgetId.milkEntryTable);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		layoutTable(tableComposite, table);

		final Label totalLabel = UIControlsFactory.createLabel(panel, "");
		totalLabel.setAlignment(SWT.RIGHT);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(totalLabel);
		addUIControl(totalLabel, ViewWidgetId.totalLabel);

		final Composite buttonComposite = createButtonComposite(panel);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).applyTo(buttonComposite);

		return group;
	}

	/**
	 * Mainly useful for gui-builder support.. overridden at runtime.
	 *
	 * @param tableComposite
	 * @param table
	 */
	private final void layoutTable(final Composite tableComposite, Table table) {

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

	}

	/**
	 * Create contents of the button bar.
	 *
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

//	/**
//	 * Return the initial size of the dialog.
//	 */
//	@Override
//	protected Point getInitialSize() {
//		return new Point(450, 300);
//	}
//
//


	/**
	 * (non-javadoc) For tetsing
	 *
	 */
	public static void main(String[] args) {

		final Display display = Display.getDefault();

		try {
			final Shell shell = new Shell();
			GridLayoutFactory.fillDefaults().applyTo(shell);

			final Button button = new Button(shell, SWT.BORDER);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(button);

			final IActionRidget actionRidget = (IActionRidget) SwtRidgetFactory.createRidget(button);
			actionRidget.setText("Open dialog"); //$NON-NLS-1$
			actionRidget.addListener(new JournalEntryTestAction(shell));

			shell.pack();
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} finally {
			display.dispose();
		}
	}
}
