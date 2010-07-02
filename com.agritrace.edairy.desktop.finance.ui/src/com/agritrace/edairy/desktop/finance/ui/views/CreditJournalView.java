package com.agritrace.edairy.desktop.finance.ui.views;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import com.agritrace.edairy.desktop.finance.ui.controls.TransactionEntryPanel;

public class CreditJournalView extends ViewPart {
	public CreditJournalView() {
		setPartName("Transaction Batch Entry");
	}

	public static final String ID = "edairy.desktop.credit-journal-entry";

	private Text dateField;
	private Button calendarButton;

	private TableViewer tableViewer;
	Text text;
	Text text_1;
	Text text_2;

	// private final List<CreditRecord> input =
	// CreditRecordFactory.createCreditRecords();

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		final Label titleLabel = new Label(parent, SWT.NULL);
		titleLabel.setText("Transaction Batch Entry");
		final Font labelFont = JFaceResources.getFontRegistry().getBold(JFaceResources.HEADER_FONT);
		titleLabel.setFont(labelFont);

		new TransactionEntryPanel(parent, SWT.NONE);
		createButtonPanel(parent);
		createTablePanel(parent);
	}

	private void createButtonPanel(Composite myParent) {

		Composite parent = new Composite(myParent, SWT.NONE);
		parent.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());

		final Button addButton = new Button(parent, SWT.PUSH);
		addButton.setText("Add Record");
		addButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		addButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// final CreditRecord record = new CreditRecord();
				//
				// record.setStore(storeTypeBox.getText());
				// record.setDate(dateField.getText());
				// record.setReference(referenceText.getText());
				// final String amount = amountText.getText();
				// if (amount != null && !amount.trim().equals("")) {
				// final Integer i = new Integer(amount.trim());
				// record.setAmount(i.intValue());
				//
				// }
				// record.setMember(memberText.getText());
				// record.setRecord(recordLabelText.getText());
				// input.add(record);
				// tableViewer.setInput(input);

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);

			}
		});

		final Button clearButton = new Button(parent, SWT.PUSH);
		clearButton.setText("Clear");
		clearButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		clearButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (MessageDialog.openConfirm(clearButton.getShell(), "Clear input fields",
						"Do you want to clear input fields?")) {
					// referenceText.setText("");
					// memberText.setText("");
					// memberAddressText.setText("");
					// amountText.setText("");
					// recordLabelText.setText("");
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);

			}
		});
	}

	private void createTablePanel(Composite parent) {

		final Group itemsGroup = new Group(parent, SWT.BORDER);
		itemsGroup.setText("Credit Records ");
		itemsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		itemsGroup.setLayout(new GridLayout(2, false));

		final Composite tableContainer = new Composite(itemsGroup, SWT.NULL);
		tableContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));

		tableViewer = new TableViewer(tableContainer, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION
				| SWT.BORDER);
		final Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		final TableColumn store = new TableColumn(table, SWT.LEFT);
		store.setText("Store");

		final TableColumn date = new TableColumn(table, SWT.LEFT);
		date.setText("Date");

		final TableColumn referecne = new TableColumn(table, SWT.LEFT);
		referecne.setText("Reference #");

		final TableColumn record = new TableColumn(table, SWT.LEFT);
		record.setText("Record #");

		final TableColumn member = new TableColumn(table, SWT.LEFT);
		member.setText("Member #");

		final TableColumn amount = new TableColumn(table, SWT.LEFT);
		amount.setText("Amount");

		final TableColumnLayout layout = new TableColumnLayout();

		layout.setColumnData(store, new ColumnWeightData(20));
		layout.setColumnData(date, new ColumnWeightData(20));
		layout.setColumnData(referecne, new ColumnWeightData(20));
		layout.setColumnData(record, new ColumnWeightData(20));
		layout.setColumnData(member, new ColumnWeightData(20));
		layout.setColumnData(amount, new ColumnWeightData(20));

		tableContainer.setLayout(layout);

		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setLabelProvider(new CreditRecordLabelProivder());
		// tableViewer.setInput(input);

		final Button removeButton = new Button(itemsGroup, SWT.NULL);
		removeButton.setText("Remove");
		removeButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				final IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				if (!selection.isEmpty()) {
					if (MessageDialog.openConfirm(removeButton.getShell(), "Remove Items",
							"Do you want to remove the selected records?")) {
						// final Iterator i = selection.iterator();
						// while (i.hasNext()) {
						// final CreditRecord item = (CreditRecord) i.next();
						// input.remove(item);
						// }
						// tableViewer.setInput(input);
					}

				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);

			}
		});
		removeButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));

		final Composite savePanel = new Composite(parent, SWT.NULL);
		savePanel.setLayoutData(new GridData(SWT.END, SWT.FILL, false, false));
		savePanel.setLayout(new GridLayout(2, false));

		final Button saveButton = new Button(savePanel, SWT.PUSH);
		saveButton.setText("Save");
		saveButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		final Button cancelButton = new Button(savePanel, SWT.PUSH);
		cancelButton.setText("Cancel");
		cancelButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	private class CreditRecordLabelProivder implements ITableLabelProvider {

		@Override
		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			// if (element instanceof CreditRecord) {
			// switch (columnIndex) {
			// case 0:
			// return ((CreditRecord) element).getStore();
			// case 1:
			// return ((CreditRecord) element).getDate();
			// case 2:
			// return ((CreditRecord) element).getReference();
			// case 3:
			// return ((CreditRecord) element).getRecord();
			// case 4:
			// return ((CreditRecord) element).getMember();
			// case 5:
			// return ((CreditRecord) element).getAmount() + "";
			// }
			// }
			return null;
		}

	}

}
